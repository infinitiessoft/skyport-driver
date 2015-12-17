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
package com.infinities.skyport.compute.entity.patch;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.builder.DiffResult;
import org.dasein.cloud.compute.VolumeProduct;
import org.dasein.cloud.compute.VolumeType;
import org.dasein.util.uom.storage.Gigabyte;
import org.dasein.util.uom.storage.Storage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VolumeProductPatchBuilderTest {

	private VolumeProductPatchBuilder builder;


	@Before
	public void setUp() throws Exception {
		builder = new VolumeProductPatchBuilder();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDiff() {
		VolumeProduct vp = VolumeProduct.getInstance("id", "name", "description", VolumeType.SSD, new Storage<Gigabyte>(5,
				new Gigabyte()), "currency", 5, 5, new Float(5), new Float(5));
		vp.withMaxIopsRatio(1);
		vp.withMaxVolumeSize(new Storage<Gigabyte>(1, new Gigabyte()));
		vp.withMinVolumeSize(new Storage<Gigabyte>(1, new Gigabyte()));
		VolumeProduct updated = VolumeProduct.getInstance("id", "name", "description", VolumeType.SSD,
				new Storage<Gigabyte>(5, new Gigabyte()), "currency", 5, 5, new Float(5), new Float(5));
		updated.withMaxIopsRatio(5);
		updated.withMaxVolumeSize(new Storage<Gigabyte>(100, new Gigabyte()));
		updated.withMinVolumeSize(new Storage<Gigabyte>(2, new Gigabyte()));
		DiffResult diffResult = builder.diff(vp, updated);
		assertEquals(3, diffResult.getNumberOfDiffs());
	}
}
