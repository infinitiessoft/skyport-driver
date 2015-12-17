package com.infinities.skyport.compute.entity.adapter;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DoubleAdapterTest {

	private DoubleAdapter adapter;


	@Before
	public void setUp() throws Exception {
		adapter = new DoubleAdapter();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUnmarshalString() throws Exception {
		Double d = adapter.unmarshal("1000.01");
		assertEquals(new Double(1000.01), d);
	}

	@Test
	public void testUnmarshalStringWithGroup() throws Exception {
		Double d = adapter.unmarshal("1,000.01");
		assertEquals(new Double(1000.01), d);
	}

	@Test
	public void testMarshalDouble() throws Exception {
		assertEquals("1000.01", adapter.marshal(new Double(1000.01)));
	}

}
