package com.infinities.skyport.compute.entity.adapter;

import java.io.Serializable;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infinities.skyport.util.FormatUtil;

public class BooleanAdapter extends XmlAdapter<String, Boolean> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(BooleanAdapter.class);


	@Override
	public Boolean unmarshal(String arg0) throws Exception {
		try {
			return Boolean.parseBoolean(arg0);
		} catch (Exception e) {
			logger.debug("Failed to parse string {}", arg0);
			throw new RuntimeException(e);
		}
	}

	@Override
	public String marshal(Boolean arg0) throws Exception {
		if (arg0 == null) {
			return null;
		}
		try {
			return FormatUtil.ucFirst(String.valueOf(arg0));
		} catch (Exception e) {
			logger.warn("Failed to format float {}", arg0);
			throw new RuntimeException(e);
		}

	}
}
