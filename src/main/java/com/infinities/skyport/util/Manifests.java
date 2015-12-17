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
