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

public class VolumePatchBuilderTest {

	private VolumePatchBuilder builder;


	@Before
	public void setUp() throws Exception {
		builder = new VolumePatchBuilder();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDiff() {
		Volume old = new Volume();
		old.setCreationTimestamp(0);
		old.setCurrentState(VolumeState.AVAILABLE);
		old.setDeleteOnVirtualMachineTermination(false);
		old.setDescription("description");
		old.setDeviceId("deviceId");
		old.setFormat(VolumeFormat.BLOCK);
		old.setGuestOperatingSystem(Platform.CENT_OS);
		old.setIops(0);
		old.setMediaLink("mediaLink");
		old.setName("name");
		old.setProviderDataCenterId("dataCenterId");
		old.setProviderProductId("providerProductId");
		old.setProviderRegionId("regionId");
		old.setProviderSnapshotId("snapshotId");
		old.setProviderVirtualMachineId("serverId");
		old.setProviderVlanId("providerVlanId");
		old.setProviderVolumeId("providerVolumeId");
		old.setRootVolume(false);
		old.setSize(new Storage<Gigabyte>(5, new Gigabyte()));
		old.setTag("key", "value");
		old.setType(VolumeType.HDD);

		Volume updated = new Volume();
		updated.setCreationTimestamp(1);
		updated.setCurrentState(VolumeState.DELETED);
		updated.setDeleteOnVirtualMachineTermination(true);
		updated.setDescription("description1");
		updated.setDeviceId("deviceId1");
		updated.setFormat(VolumeFormat.NFS);
		updated.setGuestOperatingSystem(Platform.COREOS);
		updated.setIops(1);
		updated.setMediaLink("mediaLink1");
		updated.setName("name1");
		updated.setProviderDataCenterId("dataCenterId1");
		updated.setProviderProductId("providerProductId1");
		updated.setProviderRegionId("regionId1");
		updated.setProviderSnapshotId("snapshotId1");
		updated.setProviderVirtualMachineId("serverId1");
		updated.setProviderVlanId("providerVlanId1");
		updated.setProviderVolumeId("providerVolumeId1");
		updated.setRootVolume(true);
		updated.setSize(new Storage<Gigabyte>(6, new Gigabyte()));
		updated.setTag("key1", "value1");
		updated.setType(VolumeType.SSD);

		DiffResult diffResult = builder.diff(old, updated);
		assertEquals(21, diffResult.getNumberOfDiffs());
	}

}
