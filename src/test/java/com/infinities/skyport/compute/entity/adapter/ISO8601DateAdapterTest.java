package com.infinities.skyport.compute.entity.adapter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ISO8601DateAdapterTest {

	private ISO8601DateAdapter adapter;


	@Before
	public void setUp() throws Exception {
		adapter = new ISO8601DateAdapter();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUnmarshalString() throws Exception {
		Date ret = adapter.unmarshal("wrong");
		assertNull(ret);
	}

	@Test
	public void testUnmarshalString2() throws Exception {
		Date ret = adapter.unmarshal("2014-01-01T13:00:00.000+0800");
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
		calendar.set(2014, 00, 01, 13, 00, 00);
		calendar.set(Calendar.MILLISECOND, 000);
		Date expect = calendar.getTime();
		assertEquals(0, expect.compareTo(ret));
	}

	@Test
	public void testMarshalDate() throws Exception {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
		calendar.set(2014, 00, 01, 13, 00, 00);
		calendar.set(Calendar.MILLISECOND, 000);
		Date expect = calendar.getTime();
		String ret = adapter.marshal(expect);
		assertEquals("2014-01-01T13:00:00+0800", ret);
	}

}
