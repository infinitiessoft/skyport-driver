package com.infinities.skyport.compute.entity.comparator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dasein.cloud.compute.Architecture;
import org.dasein.cloud.compute.ImageClass;
import org.dasein.cloud.compute.MachineImage;
import org.dasein.cloud.compute.MachineImageState;
import org.dasein.cloud.compute.MachineImageVolume;
import org.dasein.cloud.compute.Platform;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MachineImageComparatorTest {

	private MachineImageComparator comparator = new MachineImageComparator();
	private MachineImage o1, o2;


	@Before
	public void setUp() throws Exception {
		o1 = MachineImage.getInstance("ownerId", "regionId", "imageId", ImageClass.KERNEL, MachineImageState.ACTIVE, "name",
				"description", Architecture.I32, Platform.CENT_OS);
		o2 = MachineImage.getInstance("ownerId", "regionId", "imageId", ImageClass.KERNEL, MachineImageState.ACTIVE, "name",
				"description", Architecture.I32, Platform.CENT_OS);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCompare() {
		int result = comparator.compare(o1, o2);
		assertEquals(0, result);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCompareCreationTimestamp() {
		o1.setCreationTimestamp(1);
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@Test
	public void testCompareMinimumDiskSizeGb() {
		o1.setMinimumDiskSizeGb(1);
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCompareArchitecture() {
		o1.setArchitecture(Architecture.I64);
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCompareCurrentState() {
		o1.setCurrentState(MachineImageState.PENDING);
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCompareDescription() {
		o1.setDescription("changeit");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCompareImageClass() {
		o1.setImageClass(ImageClass.MACHINE);
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCompareKernelImageId() {
		o1.setKernelImageId("changeit");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCompareName() {
		o1.setName("changeit");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testComparePlatform() {
		o1.setPlatform(Platform.UBUNTU);
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareProviderDataCenterId() {
		o1.constrainedTo("dataCenterId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCompareProviderMachineImageId() {
		o1.setProviderMachineImageId("changeit");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCompareProviderOwnerId() {
		o1.setProviderOwnerId("changeit");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCompareProviderRegionId() {
		o1.setProviderRegionId("changeit");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareProviderMetadata() {
		Map<String, String> providerMetadata = new HashMap<String, String>();
		providerMetadata.put("key", "value");
		o1.withProviderMetadata(providerMetadata);
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@Test
	public void testCompareVolumes() {
		List<MachineImageVolume> volumes = new ArrayList<MachineImageVolume>();
		volumes.add(MachineImageVolume.getInstance("deviceName", "snapshotId", 1, "volumeType", 1));
		o1.withVolumes(volumes);
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareTag() {
		o1.setTag("key", "value");
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}
}
