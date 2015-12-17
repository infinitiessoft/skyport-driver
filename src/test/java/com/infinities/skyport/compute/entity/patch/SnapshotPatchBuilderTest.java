package com.infinities.skyport.compute.entity.patch;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.builder.DiffResult;
import org.dasein.cloud.VisibleScope;
import org.dasein.cloud.compute.Snapshot;
import org.dasein.cloud.compute.SnapshotState;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SnapshotPatchBuilderTest {

	private SnapshotPatchBuilder builder;


	@Before
	public void setUp() throws Exception {
		builder = new SnapshotPatchBuilder();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDiff() {
		Snapshot old = new Snapshot();
		old.setCurrentState(SnapshotState.AVAILABLE);
		old.setDescription("description");
		old.setName("name");
		old.setOwner("owner");
		old.setProgress("progress");
		old.setProviderSnapshotId("providerSnapshotId");
		old.setRegionId("regionId");
		old.setSizeInGb(0);
		old.setSnapshotTimestamp(0);
		old.setTag("key", "value");
		old.setVisibleScope(VisibleScope.ACCOUNT_DATACENTER);
		old.setVolumeId("volumeId");

		Snapshot updated = new Snapshot();
		updated.setCurrentState(SnapshotState.DELETED);
		updated.setDescription("description1");
		updated.setName("name1");
		updated.setOwner("owner1");
		updated.setProgress("progress1");
		updated.setProviderSnapshotId("providerSnapshotId1");
		updated.setRegionId("regionId1");
		updated.setSizeInGb(1);
		updated.setSnapshotTimestamp(1);
		updated.setTag("key1", "value1");
		updated.setVisibleScope(VisibleScope.ACCOUNT_GLOBAL);
		updated.setVolumeId("volumeId1");

		DiffResult diffResult = builder.diff(old, updated);
		assertEquals(12, diffResult.getNumberOfDiffs());
	}

}
