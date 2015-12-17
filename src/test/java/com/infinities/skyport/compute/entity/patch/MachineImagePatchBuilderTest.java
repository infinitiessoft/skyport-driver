package com.infinities.skyport.compute.entity.patch;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.DiffResult;
import org.dasein.cloud.VisibleScope;
import org.dasein.cloud.compute.Architecture;
import org.dasein.cloud.compute.ImageClass;
import org.dasein.cloud.compute.MachineImage;
import org.dasein.cloud.compute.MachineImageFormat;
import org.dasein.cloud.compute.MachineImageState;
import org.dasein.cloud.compute.MachineImageType;
import org.dasein.cloud.compute.MachineImageVolume;
import org.dasein.cloud.compute.Platform;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MachineImagePatchBuilderTest {

	private MachineImagePatchBuilder builder;


	@Before
	public void setUp() throws Exception {
		builder = new MachineImagePatchBuilder();
	}

	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testDiff() {
		MachineImage old = new MachineImage();
		old.setArchitecture(Architecture.I32);
		// updated.setCreationTimestamp(0);
		old.setCurrentState(MachineImageState.ACTIVE);
		old.setDescription("description");
		old.setImageClass(ImageClass.KERNEL);
		old.associatedWith("kernelImageId");
		old.setMinimumDiskSizeGb(0);
		old.setName("name");
		old.setPlatform(Platform.CENT_OS);
		old.setProviderMachineImageId("providerMachineImageId");
		old.setProviderOwnerId("providerOwnerId");
		old.setProviderRegionId("providerRegionId");
		old.withSoftware("software");
		old.withStorageFormat(MachineImageFormat.AWS);
		old.setTag("key", "value");
		old.withType(MachineImageType.STORAGE);
		old.withVisibleScope(VisibleScope.ACCOUNT_DATACENTER);
		Map<String, String> providerMetadata = new HashMap<String, String>();
		providerMetadata.put("key", "value");
		old.withProviderMetadata(providerMetadata);
		old.constrainedTo("dataCenterId");
		old.createdAt(0);
		MachineImageVolume volume = MachineImageVolume.getInstance("deviceName", "snapshotId", 1, "volumeType", 1);
		List<MachineImageVolume> volumes = new ArrayList<MachineImageVolume>();
		volumes.add(volume);
		old.withVolumes(volumes);

		MachineImage updated = new MachineImage();
		updated.setArchitecture(Architecture.I64);
		// updated.setCreationTimestamp(0);
		updated.setCurrentState(MachineImageState.DELETED);
		updated.setDescription("description1");
		updated.setImageClass(ImageClass.MACHINE);
		updated.associatedWith("kernelImageId1");
		updated.setMinimumDiskSizeGb(1);
		updated.setName("name1");
		updated.setPlatform(Platform.COREOS);
		updated.setProviderMachineImageId("providerMachineImageId1");
		updated.setProviderOwnerId("providerOwnerId1");
		updated.setProviderRegionId("providerRegionId1");
		updated.withSoftware("software1");
		updated.withStorageFormat(MachineImageFormat.NIMBULA);
		updated.setTag("key1", "value1");
		updated.withType(MachineImageType.VOLUME);
		updated.withVisibleScope(VisibleScope.ACCOUNT_GLOBAL);
		Map<String, String> providerMetadata1 = new HashMap<String, String>();
		providerMetadata1.put("key1", "value1");
		updated.withProviderMetadata(providerMetadata1);
		updated.constrainedTo("dataCenterId1");
		updated.createdAt(1);
		MachineImageVolume volume1 = MachineImageVolume.getInstance("deviceName1", "snapshotId1", 2, "volumeType1", 2);
		List<MachineImageVolume> updagedVolumes = new ArrayList<MachineImageVolume>();
		updagedVolumes.add(volume1);
		updated.withVolumes(updagedVolumes);

		DiffResult diffResult = builder.diff(old, updated);
		assertEquals(20, diffResult.getNumberOfDiffs());
	}

}
