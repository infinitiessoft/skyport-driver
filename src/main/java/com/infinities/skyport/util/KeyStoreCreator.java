/*******************************************************************************
 * Copyright 2015 InfinitiesSoft Solutions Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *******************************************************************************/
package com.infinities.skyport.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.KeyStore;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KeyStoreCreator {

	private static Logger logger = LoggerFactory.getLogger(KeyStoreCreator.class);

	private static final String FILE_LOCATION = "http://192.168.0.235:8080/ca.crt";
	public static final String KEYSTORE_TYPE = "JKS";
	private static final String KEYSTORE_NAME = "restapi.jks";
	private static final String KEYSTORE_PASS = "changeit";
	private static final String ALIAS_NAME = "rhevm";


	public boolean createKeyStore(String fileLocation) {
		return createKeyStore(KEYSTORE_TYPE, KEYSTORE_NAME, KEYSTORE_PASS, FILE_LOCATION, ALIAS_NAME);
	}

	public KeyStore buildKeyStore(String keyStoreType, String keyStorePass, String fileLocation, String alias)
			throws IOException {
		InputStream certInputStream = null;
		InputStream inputStream = null;
		try {
			certInputStream = getCertificate(fileLocation);
			logger.info("Certificate loaded from: {}", fileLocation);

			KeyStore ks = KeyStore.getInstance(keyStoreType);
			char[] password = keyStorePass.toCharArray();
			ks.load(null, password);
			logger.debug("JKS KeyStore instance is loaded");

			BufferedReader br = new BufferedReader(new InputStreamReader(certInputStream));
			String data = null;
			StringBuffer buffer = new StringBuffer();
			while ((data = br.readLine()) != null) {
				buffer.append(data + "\n");
			}
			br.close();

			buffer = new StringBuffer(buffer.substring(buffer.indexOf("-----BEGIN CERTIFICATE-----")));
			byte[] bytes = buffer.toString().getBytes();
			inputStream = new ByteArrayInputStream(bytes);

			logger.debug(buffer.toString());

			CertificateFactory cf = CertificateFactory.getInstance("X509");
			Certificate trustedCert = cf.generateCertificate(inputStream);
			logger.debug("Certificate converted to X509 format");

			KeyStore.TrustedCertificateEntry certEntry = new KeyStore.TrustedCertificateEntry(trustedCert);
			ks.setEntry(alias, certEntry, null);
			logger.debug("Certificate entry has been added to the keystore");

			return ks;
		} catch (Exception e) {
			throw new IOException("Error while importing a trusted certificate from: " + fileLocation + "with alias: "
					+ alias, e);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					logger.error("encounter error", e);
				}
			}
			if (certInputStream != null) {
				try {
					certInputStream.close();
				} catch (IOException e) {
					logger.error("encounter error", e);
				}
			}
		}
	}

	public KeyStore buildKeyStore(String keyStoreType, String pass, byte[] content, String alias) throws IOException {
		InputStream inputStream = null;
		try {
			Security.addProvider(new BouncyCastleProvider());
			KeyStore ks = KeyStore.getInstance(keyStoreType, BouncyCastleProvider.PROVIDER_NAME);
			char[] password = pass.toCharArray();
			inputStream = new ByteArrayInputStream(content);
			ks.load(inputStream, password);
			logger.debug("Certificate entry has been added to the keystore");

			return ks;
		} catch (Exception e) {
			throw new IOException("Error while importing a trusted certificate with alias: " + alias, e);
		}
	}

	private boolean createKeyStore(String keyStoreType, String keyStoreName, String keyStorePass, String fileLocation,
			String alias) {
		try {
			KeyStore ks = buildKeyStore(keyStoreType, keyStorePass, fileLocation, alias);
			char[] password = keyStorePass.toCharArray();

			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(keyStoreName);
				ks.store(fos, password);
				logger.info("Keystore {} has been successfully created", keyStoreName);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Error while saving the keystore: " + keyStoreName, e);
			} finally {
				if (fos != null) {
					fos.close();
				}
			}
			return false;
		} catch (Exception e) {
			logger.error("Error while importing a trusted certificate from: " + fileLocation + "with alias: " + alias
					+ " into keystore: " + keyStoreName, e);
			return false;
		}
	}

	private InputStream getCertificate(String fileLocation) throws IOException {
		URL url = new URL(fileLocation);
		url.openConnection();
		return url.openStream();
	}

	public static void main(String[] args) throws Exception {
		KeyStoreCreator keyStoreCreator = new KeyStoreCreator();
		keyStoreCreator.createKeyStore(FILE_LOCATION);

	}

}
