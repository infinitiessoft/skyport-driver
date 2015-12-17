package com.infinities.skyport.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesHolder {

	private static final Logger logger = LoggerFactory.getLogger(PropertiesHolder.class);
	private static final String SKYPORT_PROPERTIES_FILE = "skyport.properties";
	private final Properties skyportProperties = new Properties();
	public static final String CONFIG_FOLDER = "config";
	// public static final String WEB_SERVER_PROTOCOL = "webserver.protocol";
	// public static final String WEB_SERVER_IP = "webserver.ip";
	// public static final String WEB_SERVER_PORT = "webserver.port";
	// public static final String WEB_SERVER_CONTEXT = "webserver.context";
	// public static final String NOVNC_SERVER_MODE = "novncserver.mode";
	// public static final String NOVNC_SERVER_PROTOCOL =
	// "novncserver.protocol";
	// public static final String NOVNC_SERVER_USERNAME =
	// "novncserver.username";
	// public static final String NOVNC_SERVER_PASSWORD =
	// "novncserver.password";
	// public static final String NOVNC_SERVER_IP = "novncserver.ip";
	// public static final String NOVNC_SERVER_PORT = "novncserver.port";
	// public static final String NOVNC_SERVER_WEBDIR = "novncserver.webdir";
	// public static final String NOVNC_SERVER_REQUIRE_SSL =
	// "novncserver.requireSSL";
	// public static final String NOVNC_SERVER_ENABLE_SSL =
	// "novncserver.enableSSL";
	// public static final String NOVNC_SERVER_PATH = "novncserver.path";
	// public static final String KEYSTORE_TYPE = "keystore.type";
	// public static final String KEYSTORE_PATH = "keystore.path";
	// public static final String KEYSTORE_PASSWORD = "keystore.password";
	// public static final String KEYSTORE_KEY_PASSWORD =
	// "keystore.keypassword";
	public static final String UI_ENABLED = "ui.enabled";
	// public static final String MAX_PORT = "vnc.max";
	// public static final String MIN_PORT = "vnc.min";
	public static final String KEY = "profile.key";
	// public static final String WEBAPI_CONTEXT = "webapi.context";
	public static final String CLUSTER_DELEGATE = "cluster.delegate";
	public static final String TIMEZONE = "timezone";
	public static final String CACHE_ENABLED = "cache.enabled";
	public static final String LIMIT_MAX = "limit.max";
	public static final String THREADPOOL_CORE_MIN = "threadpool.core.min";
	public static final String THREADPOOL_CORE_MAX = "threadpool.core.max";
	public static final String THREADPOOL_MAX_MIN = "threadpool.max.min";
	public static final String THREADPOOL_MAX_MAX = "threadpool.max.max";
	public static final String THREADPOOL_CAPACITY_MIN = "threadpool.capacity.min";
	public static final String THREADPOOL_CAPACITY_MAX = "threadpool.capacity.max";
	public static final String DELAY_MIN = "delay.min";
	public static final String DELAY_MAX = "delay.max";
	public static final String TIMEOUT_MIN = "timeout.min";
	public static final String TIMEOUT_MAX = "timeout.max";

	private static PropertiesHolder instance = new PropertiesHolder();


	private PropertiesHolder() {
		String configFileLocation = CONFIG_FOLDER + File.separator + SKYPORT_PROPERTIES_FILE;
		try {
			skyportProperties.load(new FileInputStream(configFileLocation));
		} catch (FileNotFoundException e) {
			String message = configFileLocation + " file is not found";
			logger.warn(message, e);
			throw new RuntimeException(message, e);
		} catch (IOException e) {
			String message = "Error while reading" + configFileLocation + " file";
			logger.warn(message, e);
			throw new RuntimeException(message, e);
		}
	}

	public static String getProperty(String key) {
		return instance.skyportProperties.getProperty(key);
	}

}
