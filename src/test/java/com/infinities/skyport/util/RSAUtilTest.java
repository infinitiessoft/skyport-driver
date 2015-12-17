package com.infinities.skyport.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.io.BaseEncoding;

public class RSAUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEncryptAndDecrypt() throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		// KeyPair keypair = RSAUtil.generateKeys();
		// String message = UUID.randomUUID().toString();
		// System.err.println(message);
		// String text = RSAUtil.encrypt(message, keypair.getPublic());
		// System.err.println(text);
		// String original = RSAUtil.decrypt(text, keypair.getPrivate());
		// System.err.println(original);

		// KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA1");
		// SecretKey mD5key = keyGen.generateKey();
		KeyPair keypair = RSAUtil.generateKeys();
		System.out.println("Finish generating key");
		String plainText = "86e07f7e-ed36-4d63-b823-a7c7576f4be3";
		System.err.println(plainText);
		// get a MAC object and update it with the plaintext
		Mac mac = Mac.getInstance("HmacSHA1");
		mac.init(keypair.getPrivate());
		mac.update(plainText.getBytes("UTF8"));
		// print out the provider used and the MAC
		System.out.println("\n" + mac.getProvider().getInfo());
		System.out.println("\nMAC: ");
		// System.out.println(new String(mac.doFinal(), "UTF8"));
		// System.out.println(new String(Hex.encode(mac.doFinal())));
		System.err.println(BaseEncoding.base64().encode(mac.doFinal()).replaceAll("\\W", ""));
	}

}
