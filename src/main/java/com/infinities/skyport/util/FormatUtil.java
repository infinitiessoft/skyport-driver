package com.infinities.skyport.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Pattern;

import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;

public class FormatUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(FormatUtil.class);
	private static final char DEFAULT_HEX_DELIMITER = ':';
	private static Pattern uuidPattern = Pattern.compile("^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$");
	private static DateTimeFormatter parser = DateTimeFormat.forPattern("yyyy-MM-dd'T'H:mm:ss.SSSZ").withZone(
			DateTimeZone.forTimeZone(TimeZone.getTimeZone(PropertiesHolder.getProperty(PropertiesHolder.TIMEZONE))));
	private static DateTimeFormatter parser2 = DateTimeFormat.forPattern("yyyy-MM-dd'T'H:mmZ").withZone(
			DateTimeZone.forTimeZone(TimeZone.getTimeZone(PropertiesHolder.getProperty(PropertiesHolder.TIMEZONE))));
	private static DateTimeFormatter parser3 = DateTimeFormat.forPattern("yyyy-MM-dd'T'H:mm:ssZ").withZone(
			DateTimeZone.forTimeZone(TimeZone.getTimeZone(PropertiesHolder.getProperty(PropertiesHolder.TIMEZONE))));


	private FormatUtil() {

	}

	public static long percentages(String a, String b) {
		BigDecimal c, d;
		c = new BigDecimal(a);
		d = new BigDecimal(b);
		BigDecimal toReturn = c.divide(d, 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100));

		return toReturn.longValue();
	}

	public static double percentage(String a, String b) {
		BigDecimal c, d;
		c = new BigDecimal(a);
		d = new BigDecimal(b);
		BigDecimal toReturn = c.divide(d, 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100));

		return toReturn.doubleValue();
	}

	public static double percentage(long a, long b) {
		BigDecimal c, d;
		c = new BigDecimal(a);
		d = new BigDecimal(b);
		BigDecimal toReturn = c.divide(d, 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100));

		return toReturn.doubleValue();
	}

	public static double percentage(double a, double b) {
		BigDecimal c, d;
		c = new BigDecimal(a);
		d = new BigDecimal(b);
		BigDecimal toReturn = c.divide(d, 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100));

		return toReturn.doubleValue();
	}

	public static long kbToMB(double s) {
		BigDecimal b = new BigDecimal(s);
		BigDecimal l = new BigDecimal(1024);
		return b.divide(l, 2, RoundingMode.HALF_UP).longValue();
	}

	public static long kbToMB(String s) {
		BigDecimal b = new BigDecimal(s);
		BigDecimal l = new BigDecimal(1024);
		return b.divide(l, 2, RoundingMode.HALF_UP).longValue();
	}

	public static long kbToGB(String s) {
		BigDecimal b = new BigDecimal(s);
		BigDecimal l = new BigDecimal(1048576);
		return b.divide(l, 2, RoundingMode.HALF_UP).longValue();
	}

	public static long kbToGB(double s) {
		BigDecimal b = new BigDecimal(s);
		BigDecimal l = new BigDecimal(1048576);
		return b.divide(l, 2, RoundingMode.HALF_UP).longValue();
	}

	public static long kbToGB(long s) {
		BigDecimal b = new BigDecimal(s);
		BigDecimal l = new BigDecimal(1048576);
		return b.divide(l, 2, RoundingMode.HALF_UP).longValue();
	}

	public static long mbToGB(String s) {
		BigDecimal b = new BigDecimal(s);
		BigDecimal l = new BigDecimal(1024);

		return b.divide(l, 2, RoundingMode.HALF_UP).longValue();

	}

	public static long mbToGB(long s) {
		BigDecimal b = new BigDecimal(s);
		BigDecimal l = new BigDecimal(1024);

		return b.divide(l, 2, RoundingMode.HALF_UP).longValue();

	}

	public static long getUsedSize(String total, String available) {
		if (Strings.isNullOrEmpty(total) || Strings.isNullOrEmpty(available)) {
			return 0L;
		}

		try {
			long totalSize = Long.parseLong(total);
			long availableSize = Long.parseLong(available);

			return totalSize - availableSize;
		} catch (Exception e) {
			logger.error("encounter error", e);
			return 0L;
		}
	}

	public static boolean isUUID(String text) {
		return uuidPattern.matcher(text).matches();
	}

	// public static double usage(String a, String b) {
	// BigDecimal c, d;
	// c = new BigDecimal(a);
	// d = new BigDecimal(b);
	// BigDecimal toReturn = c.divide(d, 2, RoundingMode.HALF_UP);
	//
	// return toReturn.doubleValue();
	// }
	//
	// public static double usage(int a, int b) {
	// BigDecimal c, d;
	// c = new BigDecimal(a);
	// d = new BigDecimal(b);
	// BigDecimal toReturn = c.divide(d, 2, RoundingMode.HALF_UP);
	//
	// return toReturn.doubleValue();
	// }

	public static long gbToMB(long s) {
		return (s * (1024));
	}

	public static long gbToMB(String s) {
		long b;
		b = Long.parseLong(s);
		return (b * (1024));

	}

	public static long gbToByte(String s) {
		long b;
		b = Long.parseLong(s);
		return (b * (1073741824L));

	}

	public static long gbToByte(long s) {
		return (s * (1073741824L));
	}

	public static long byteToGB(String s) {
		BigDecimal b = new BigDecimal(s);
		BigDecimal l = new BigDecimal(1073741824);

		return b.divide(l, 2, RoundingMode.HALF_UP).longValue();
	}

	public static long byteToGB(long s) {
		BigDecimal b = new BigDecimal(s);
		BigDecimal l = new BigDecimal(1073741824);

		return b.divide(l, 2, RoundingMode.HALF_UP).longValue();
	}

	public static long byteToGB(int s) {
		BigDecimal b = new BigDecimal(s);
		BigDecimal l = new BigDecimal(1073741824);

		return b.divide(l, 2, RoundingMode.HALF_UP).longValue();
	}

	public static long byteToMB(String s) {
		BigDecimal b = new BigDecimal(s);
		BigDecimal l = new BigDecimal(1048576);

		return b.divide(l, 2, RoundingMode.HALF_UP).longValue();
	}

	public static long byteToMB(long s) {
		BigDecimal b = new BigDecimal(s);
		BigDecimal l = new BigDecimal(1048576);

		return b.divide(l, 2, RoundingMode.HALF_UP).longValue();
	}

	public static long mbToByte(String s) {
		BigDecimal b = new BigDecimal(s);
		BigDecimal l = new BigDecimal(1048576);

		return b.multiply(l).longValue();
	}

	public static long mbToByte(long s) {
		BigDecimal b = new BigDecimal(s);
		BigDecimal l = new BigDecimal(1048576);

		return b.multiply(l).longValue();
	}

	public static String ucFirst(String str) {
		StringBuilder b = new StringBuilder(str);
		int i = 0;
		do {
			b.replace(i, i + 1, b.substring(i, i + 1).toUpperCase());
			i = b.indexOf(" ", i) + 1;
		} while (i > 0 && i < b.length());
		return b.toString();
	}

	public static Date getDefaultCreationDate() {
		String jtdate = "1970-01-01T12:00:00.000+08:00";
		return getDate(jtdate);
	}

	public static Date getDate(String str) {
		Date date = parser.parseDateTime(str).toDate();
		return date;
	}

	public static Date getDateWithoutSeconds(String str) {
		Date date = parser2.parseDateTime(str).toDate();
		return date;
	}

	public static Date getDateWithoutMiliSecond(String str) {
		Date date = parser3.parseDateTime(str).toDate();
		return date;
	}

	public static String toHex(long l) {
		return "0x" + String.format("%08x", (0xFFFFFFFF & l)).toUpperCase();
	}

	public static String byteArrayToHexString(byte[] b) {
		StringBuffer sb = new StringBuffer(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			int v = b[i] & 0xff;
			if (v < 16) {
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));
		}
		return sb.toString().toUpperCase();
	}

	public static String toHexString(byte[] value) {
		return toHexString(value, DEFAULT_HEX_DELIMITER);
	}

	public static String toHexString(byte[] value, char separator) {
		return toString(value, separator, 16);
	}

	public static String toString(byte[] value, char separator, int radix) {
		int digits = (int) (Math.round((float) Math.log(256) / Math.log(radix)));
		StringBuffer buf = new StringBuffer(value.length * (digits + 1));
		for (int i = 0; i < value.length; i++) {
			if (i > 0) {
				buf.append(separator);
			}
			int v = (value[i] & 0xFF);
			String val = Integer.toString(v, radix);
			for (int j = 0; j < digits - val.length(); j++) {
				buf.append('0');
			}
			buf.append(val);
		}
		return buf.toString();
	}

	public static Calendar getCalendar(String str) {
		Date date = getDate(str);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c;
	}

}
