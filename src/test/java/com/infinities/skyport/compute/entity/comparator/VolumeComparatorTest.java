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

import org.dasein.cloud.compute.Platform;
import org.dasein.cloud.compute.Volume;
import org.dasein.cloud.compute.VolumeFormat;
import org.dasein.cloud.compute.VolumeState;
import org.dasein.cloud.compute.VolumeType;
import org.dasein.util.uom.storage.Gigabyte;
import org.dasein.util.uom.storage.Storage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VolumeComparatorTest {

	private VolumeComparator comparator = new VolumeComparator();
	private Volume o1, o2;


	@Before
	public void setUp() throws Exception {
		o1 = new Volume();
		o2 = new Volume();

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
	public void testCompareCreationTimestamp() {
		o1.setCreationTimestamp(1);
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@Test
	public void testCompareCurrentState() {
		o1.setCurrentState(VolumeState.AVAILABLE);
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCompareDataCenterId() {
		o1.setDataCenterId("dataCenterId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareDeleteOnVirtualMachineTermination() {
		o1.setDeleteOnVirtualMachineTermination(true);
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareDescription() {
		o1.setDescription("description");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareDeviceId() {
		o1.setDeviceId("deviceId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareVolumeFormat() {
		o1.setFormat(VolumeFormat.NFS);
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@Test
	public void testCompareGuestOperatingSystem() {
		o1.setGuestOperatingSystem(Platform.CENT_OS);
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareIops() {
		o1.setIops(1);
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@Test
	public void testCompareMediaLink() {
		o1.setMediaLink("mediaLink");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareName() {
		o1.setName("name");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareProviderDataCenterId() {
		o1.setProviderDataCenterId("dataCenterId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareProviderProductId() {
		o1.setProviderProductId("providerProductId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareProviderRegionId() {
		o1.setProviderRegionId("regionId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareProviderSnapshotId() {
		o1.setProviderSnapshotId("snapshotId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareProviderVirtualMachineId() {
		o1.setProviderVirtualMachineId("serverId");
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@Test
	public void testCompareProviderVlanId() {
		o1.setProviderVlanId("providerVlanId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareProviderVolumeId() {
		o1.setProviderVolumeId("providerVolumeId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCompareRegionId() {
		o1.setRegionId("regionId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareRootVolume() {
		o1.setRootVolume(true);
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCompareServerId() {
		o1.setServerId("serverId");
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@Test
	public void testCompareSize() {
		o1.setSize(new Storage<Gigabyte>(5, new Gigabyte()));
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCompareSnapshotId() {
		o1.setSnapshotId("snapshotId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareTag() {
		o1.setTag("key", "value");
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@Test
	public void testCompareType() {
		o1.setType(VolumeType.HDD);
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

}
