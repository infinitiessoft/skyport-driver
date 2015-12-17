package com.infinities.skyport.compute.entity.adapter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BooleanAdapterTest {

	private BooleanAdapter adapter;


	@Before
	public void setUp() throws Exception {
		adapter = new BooleanAdapter();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUnmarshalStringTrue() throws Exception {
		assertTrue(adapter.unmarshal("true"));
	}

	@Test
	public void testUnmarshalStringTrue2() throws Exception {
		assertTrue(adapter.unmarshal("True"));
	}

	@Test
	public void testUnmarshalStringTrue3() throws Exception {
		assertTrue(adapter.unmarshal("TRUE"));
	}

	@Test
	public void testUnmarshalStringYes() throws Exception {
		assertFalse(adapter.unmarshal("yes"));
	}

	@Test
	public void testUnmarshalStringFalse() throws Exception {
		assertFalse(adapter.unmarshal("false"));
	}

	@Test
	public void testUnmarshalStringFalse2() throws Exception {
		assertFalse(adapter.unmarshal("False"));
	}

	@Test
	public void testUnmarshalStringFalse3() throws Exception {
		assertFalse(adapter.unmarshal("FALSE"));
	}

	@Test
	public void testMarshalBooleanNull() throws Exception {
		String ret = adapter.marshal(null);
		assertEquals(null, ret);
	}
	
	@Test
	public void testMarshalBoolean() throws Exception {
		String ret = adapter.marshal(true);
		assertEquals("True", ret);
	}
	
	@Test
	public void testMarshalBoolean2() throws Exception {
		String ret = adapter.marshal(false);
		assertEquals("False", ret);
	}

}
