package com.infinities.skyport.util;

import java.io.IOException;
import java.net.URL;
import java.util.jar.Manifest;

public class Manifests {

	public static final String INPLEMENTATION_TITLE = "Implementation-Title";
	public static final String INPLEMENTATION_VERSION = "Implementation-Version";


	private Manifests() {

	}

	public static String getAttribute(String name) throws IOException {
		Class<Manifests> clazz = Manifests.class;
		String className = clazz.getSimpleName() + ".class";
		String classPath = clazz.getResource(className).toString();
		String manifestPath = "";
		if (!classPath.startsWith("jar")) {
			manifestPath += "file:META-INF/MANIFEST.MF";
		} else {
			manifestPath += classPath.substring(0, classPath.lastIndexOf("!") + 1) + "/META-INF/MANIFEST.MF";
		}
		Manifest manifest = new Manifest(new URL(manifestPath).openStream());
		return manifest.getMainAttributes().getValue(name);
	}

}
