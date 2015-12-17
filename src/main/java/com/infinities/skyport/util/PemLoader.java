package com.infinities.skyport.util;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;

public class PemLoader {

	private static final Logger logger = LoggerFactory.getLogger(PemLoader.class);
	private static final String PEM_TXT = ".pem.txt";
	private static final String PEM = ".pem";
	private String defaultDirectory;


	public PemLoader(String defaultDirectory) {
		this.defaultDirectory = defaultDirectory;
	}

	public String readPem(String keypairName) throws IOException {
		String fileLocation = keypairName;
		File file = new File(fileLocation);
		if (!file.exists()) {
			fileLocation = defaultDirectory + keypairName + PEM;
			file = new File(fileLocation);
			if (!file.exists()) {
				fileLocation = defaultDirectory + keypairName + PEM_TXT;
				file = new File(fileLocation);
				if (!file.exists()) {
					throw new IllegalArgumentException("invalid keypairName: " + keypairName);
				}
			}
		}
		logger.info("pem loaded from: {}", fileLocation);
		return Files.asCharSource(new File(fileLocation), Charsets.US_ASCII).read();
	}

	public void savePem(String directory, String keypairName, String privateKey) throws IOException {
		String fileLocation = directory + keypairName + PEM;
		logger.info("pem loaded from: {}", fileLocation);
		Files.asCharSink(new File(fileLocation), Charsets.US_ASCII, FileWriteMode.APPEND).write(privateKey);
	}

	public void savePem(String keypairName, String privateKey) throws IOException {
		this.savePem(defaultDirectory, keypairName, privateKey);
	}
}
