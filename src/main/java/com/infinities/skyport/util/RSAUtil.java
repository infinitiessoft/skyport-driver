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

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.bouncycastle.openssl.jcajce.JcaPEMWriter;

import com.google.common.base.Charsets;
import com.google.common.io.BaseEncoding;
import com.google.common.io.Files;

public class RSAUtil {

	private RSAUtil() {

	}

	public static KeyPair generateKeys() throws NoSuchAlgorithmException {
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(2048);
		return keyGen.genKeyPair();
	}

	public static String extractAndSaveKey(KeyPair keys, File file) throws IOException {
		String privateKeyStr = extractPrivateKey(keys);
		savePem(file, privateKeyStr);
		return privateKeyStr;
	}

	private static String extractPrivateKey(KeyPair keys) throws IOException {
		StringWriter writer = new StringWriter();
		JcaPEMWriter pemWriter = null;
		try {
			pemWriter = new JcaPEMWriter(writer);
			pemWriter.writeObject(keys.getPrivate());
		} finally {
			if (pemWriter != null) {
				pemWriter.close();
			}
		}
		return writer.toString();
	}

	private static void savePem(File file, String privateKeyStr) throws IOException {
		Files.write(privateKeyStr, file, Charsets.UTF_8);
	}

	public static String encrypt(String message, PublicKey key) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, key);

		byte[] stringBytes = message.getBytes("UTF8");
		byte[] raw = cipher.doFinal(stringBytes);
		String base64 = BaseEncoding.base64().encode(raw);
		return base64;
	}

	public static String decrypt(String encrypted, PrivateKey key) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, key);

		byte[] raw = BaseEncoding.base64().decode(encrypted);

		byte[] stringBytes = cipher.doFinal(raw);
		String clear = new String(stringBytes, "UTF8");
		return clear;
	}

	public static PrivateKey readPrivateKey(byte[] bytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		PKCS8EncodedKeySpec privspec = new PKCS8EncodedKeySpec(bytes);
		KeyFactory factory = KeyFactory.getInstance("RSA");
		PrivateKey privkey = factory.generatePrivate(privspec);
		return privkey;
	}

}
