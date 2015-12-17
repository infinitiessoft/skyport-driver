package com.infinities.skyport.compute.entity.adapter;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class IntegerAdapterTest {
	
	private IntegerAdapter adapter;

	@Before
	public void setUp() throws Exception {
		adapter = new IntegerAdapter();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUnmarshalString() throws Exception {
		Integer d = adapter.unmarshal("1000");
		assertEquals(new Integer(1000), d);
	}

	@Test
	public void testUnmarshalStringWithGroup() throws Exception {
		Integer d = adapter.unmarshal("1,000");
		assertEquals(new Integer(1000), d);
	}

	@Test
	public void testMarshalInteger() throws Exception {
		assertEquals("1000", adapter.marshal(new Integer(1000)));
	}

}
