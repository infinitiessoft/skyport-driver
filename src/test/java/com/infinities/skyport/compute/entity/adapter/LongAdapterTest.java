package com.infinities.skyport.compute.entity.adapter;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LongAdapterTest {

	private LongAdapter adapter;


	@Before
	public void setUp() throws Exception {
		adapter = new LongAdapter();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUnmarshalString() throws Exception {
		Long d = adapter.unmarshal("1000");
		assertEquals(new Long(1000), d);
	}

	@Test
	public void testUnmarshalStringWithGroup() throws Exception {
		Long d = adapter.unmarshal("1,000");
		assertEquals(new Long(1000), d);
	}

	@Test
	public void testMarshalLong() throws Exception {
		assertEquals("1000", adapter.marshal(new Long(1000)));
	}

}
