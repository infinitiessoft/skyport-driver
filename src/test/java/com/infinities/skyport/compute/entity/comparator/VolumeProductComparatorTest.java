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

import org.dasein.cloud.compute.VolumeProduct;
import org.dasein.cloud.compute.VolumeType;
import org.dasein.util.uom.storage.Gigabyte;
import org.dasein.util.uom.storage.Storage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VolumeProductComparatorTest {

	private VolumeProductComparator comparator = new VolumeProductComparator();
	private VolumeProduct o1, o2;


	@Before
	public void setUp() throws Exception {
		o1 = VolumeProduct.getInstance("id", "name", "description", VolumeType.SSD,
				new Storage<Gigabyte>(5, new Gigabyte()), "currency", 5, 5, new Float(5), new Float(5));
		o2 = VolumeProduct.getInstance("id", "name", "description", VolumeType.SSD,
				new Storage<Gigabyte>(5, new Gigabyte()), "currency", 5, 5, new Float(5), new Float(5));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCompare() {
		int result = comparator.compare(o1, o2);
		assertEquals(0, result);
	}

	@Test
	public void testCompareMaxIopsRatio() {
		o1.withMaxIopsRatio(1);
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareMaxVolumeSize() {
		o1.withMaxVolumeSize(new Storage<Gigabyte>(1, new Gigabyte()));
		int result = comparator.compare(o1, o2);
		assertEquals(0, result);
	}

	@Test
	public void testCompareMinVolumeSize() {
		o1.withMinVolumeSize(new Storage<Gigabyte>(1, new Gigabyte()));
		int result = comparator.compare(o1, o2);
		assertEquals(0, result);
	}

}
