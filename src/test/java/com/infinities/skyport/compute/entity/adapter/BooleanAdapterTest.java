/*******************************************************************************
 * Copyright 2015 InfinitiesSoft Solutions Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *******************************************************************************/
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
