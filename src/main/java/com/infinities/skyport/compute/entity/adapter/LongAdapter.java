package com.infinities.skyport.compute.entity.adapter;

import java.io.Serializable;
import java.text.NumberFormat;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongAdapter extends XmlAdapter<String, Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(LongAdapter.class);


	@Override
	public Long unmarshal(String arg0) throws Exception {
		if (arg0 == null) {
			return 0L;
		}

		try {
			NumberFormat numFormat = NumberFormat.getNumberInstance();
			return numFormat.parse(arg0).longValue();
		} catch (Exception e) {
			logger.debug("Failed to parse string {}", arg0);
			return null;
		}
	}

	@Override
	public String marshal(Long arg0) throws Exception {
		try {
			NumberFormat numFormat = NumberFormat.getNumberInstance();
			numFormat.setGroupingUsed(false);
			return numFormat.format(arg0);
		} catch (Exception e) {
			logger.warn("Failed to format float {}", arg0);
			return "0";
		}

	}

}
