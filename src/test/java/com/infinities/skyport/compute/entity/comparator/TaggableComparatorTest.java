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
package com.infinities.skyport.compute.entity.comparator;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.dasein.cloud.Taggable;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TaggableComparatorTest {

	protected Mockery context = new JUnit4Mockery() {

		{
			setThreadingPolicy(new Synchroniser());
			setImposteriser(ClassImposteriser.INSTANCE);
		}
	};
	private TaggableComparator comparator;
	private Taggable o1, o2;


	@Before
	public void setUp() throws Exception {
		comparator = new TaggableComparator();
		o1 = context.mock(Taggable.class, "o1");
		o2 = context.mock(Taggable.class, "o2");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCompare() {
		final Map<String, String> m1 = new HashMap<String, String>();
		final Map<String, String> m2 = new HashMap<String, String>();
		context.checking(new Expectations() {

			{
				exactly(1).of(o1).getTags();
				will(returnValue(m1));

				exactly(1).of(o2).getTags();
				will(returnValue(m2));
			}
		});
		int result = comparator.compare(o1, o2);
		assertEquals(0, result);
	}

	@Test
	public void testCompareKey() {
		final Map<String, String> m1 = new HashMap<String, String>();
		m1.put("name", "mock");
		final Map<String, String> m2 = new HashMap<String, String>();
		m2.put("name2", "mock");
		context.checking(new Expectations() {

			{
				exactly(1).of(o1).getTags();
				will(returnValue(m1));

				exactly(1).of(o2).getTags();
				will(returnValue(m2));
			}
		});
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@Test
	public void testCompareValue() {
		final Map<String, String> m1 = new HashMap<String, String>();
		m1.put("name", "mock");
		final Map<String, String> m2 = new HashMap<String, String>();
		m2.put("name", "mock2");
		context.checking(new Expectations() {

			{
				exactly(1).of(o1).getTags();
				will(returnValue(m1));

				exactly(1).of(o2).getTags();
				will(returnValue(m2));
			}
		});
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testComparePairs() {
		final Map<String, String> m1 = new HashMap<String, String>();
		m1.put("name", "mock");
		final Map<String, String> m2 = new HashMap<String, String>();
		context.checking(new Expectations() {

			{
				exactly(1).of(o1).getTags();
				will(returnValue(m1));

				exactly(1).of(o2).getTags();
				will(returnValue(m2));
			}
		});
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

}
