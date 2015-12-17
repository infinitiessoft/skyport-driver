package com.infinities.skyport.compute.entity.comparator;

import static org.junit.Assert.assertEquals;

import org.dasein.cloud.VisibleScope;
import org.dasein.cloud.compute.Snapshot;
import org.dasein.cloud.compute.SnapshotState;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SnapshotComparatorTest {
	
	private SnapshotComparator comparator = new SnapshotComparator();
	private Snapshot o1, o2;

	@Before
	public void setUp() throws Exception {
		o1 = new Snapshot();
		o2 = new Snapshot();
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
	public void testCompareSizeInGb() {
		o1.setSizeInGb(1);
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@Test
	public void testCompareSnapshotTimestamp() {
		o1.setSnapshotTimestamp(1);
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}
	
	@Test
	public void testCompareCurrentState() {
		o1.setCurrentState(SnapshotState.AVAILABLE);
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
	public void testCompareName() {
		o1.setName("name");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareOwner() {
		o1.setOwner("owner");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}
	
	@Test
	public void testCompareProgress() {
		o1.setProgress("progress");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}
	
	@Test
	public void testCompareProviderSnapshotId() {
		o1.setProviderSnapshotId("providerSnapshotId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}
	
	@Test
	public void testCompareRegionId() {
		o1.setRegionId("regionId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}
	
	@Test
	public void testCompareVisibleScope() {
		o1.setVisibleScope(VisibleScope.ACCOUNT_DATACENTER);
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}
	
	@Test
	public void testCompareVolumeId() {
		o1.setVolumeId("volumeId");
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
