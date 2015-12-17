package com.infinities.skyport.compute.entity.adapter;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DoubleAdapter extends XmlAdapter<String, Double> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(DoubleAdapter.class);


	@Override
	public Double unmarshal(String arg0) throws Exception {
		// logger.debug("unmarshal double: {}", arg0);
		if (arg0 == null) {
			return null;
		}

		try {
			NumberFormat numFormat = NumberFormat.getNumberInstance();
			numFormat.setMaximumFractionDigits(2);
			numFormat.setMinimumFractionDigits(2);
			return numFormat.parse(arg0).doubleValue();
		} catch (ParseException e) {
			logger.debug("Failed to parse string {}", arg0);
			return null;
		}
	}

	@Override
	public String marshal(Double arg0) throws Exception {
		try {
			// logger.debug("marshal double: {}", arg0);
			NumberFormat numFormat = NumberFormat.getNumberInstance();
			numFormat.setMaximumFractionDigits(2);
			numFormat.setMinimumFractionDigits(2);
			numFormat.setGroupingUsed(false);
			return numFormat.format(arg0);
		} catch (Exception e) {
			logger.warn("Failed to format float {}", arg0);
			return null;
		}

	}

}
