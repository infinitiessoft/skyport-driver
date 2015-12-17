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
