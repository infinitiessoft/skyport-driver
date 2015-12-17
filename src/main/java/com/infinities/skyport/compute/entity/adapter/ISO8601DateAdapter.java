package com.infinities.skyport.compute.entity.adapter;

import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infinities.skyport.util.PropertiesHolder;

public class ISO8601DateAdapter extends XmlAdapter<String, Date> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static DateTimeZone timeZone = DateTimeZone.forTimeZone(TimeZone.getTimeZone(PropertiesHolder
			.getProperty(PropertiesHolder.TIMEZONE)));
	private static DateTimeFormatter inputFormatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ").withZone(
			timeZone);
	private static DateTimeFormatter outputFormatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ")
			.withZone(timeZone);
	// private ThreadLocal<DateFormat> iso8601Format = new
	// ThreadLocal<DateFormat>() {
	//
	// @Override
	// protected DateFormat initialValue() {
	// DateFormat iso8601Format = new
	// SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	// iso8601Format.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
	// return iso8601Format;
	// }
	// };
	private static final Logger logger = LoggerFactory.getLogger(ISO8601DateAdapter.class);


	@Override
	public Date unmarshal(String v) throws Exception {
		if (v == null) {
			return null;
		}
		try {
			// DateFormat format = iso8601Format.get();
			// return format.parse(v);
			return inputFormatter.parseDateTime(v).toDate();
		} catch (Exception e) {
			logger.debug("Failed to parse string {}", v);
			return null;
		}

	}

	@Override
	public String marshal(Date v) throws Exception {
		try {
			// DateFormat format = iso8601Format.get();
			// return format.format(v);
			DateTime dt = new DateTime(v);
			dt.withZone(timeZone);
			return dt.toString(outputFormatter);
		} catch (Exception e) {
			logger.warn("Failed to format date {}", v.toString());
			return null;
		}
	}

}
