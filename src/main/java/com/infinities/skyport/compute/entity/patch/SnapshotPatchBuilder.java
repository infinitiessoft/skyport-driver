package com.infinities.skyport.compute.entity.patch;

import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.dasein.cloud.compute.Snapshot;

public class SnapshotPatchBuilder implements PatchBuilder<Snapshot> {

	@Override
	public DiffResult diff(Snapshot old, Snapshot updated) {
		DiffResult diff = new DiffBuilder(old, updated, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("sizeInGb", old.getSizeInGb(), updated.getSizeInGb())
				.append("snapshotTimestamp", old.getSnapshotTimestamp(), updated.getSnapshotTimestamp())
				.append("currentState", old.getCurrentState(), updated.getCurrentState())
				.append("description", old.getDescription(), updated.getDescription())
				.append("name", old.getName(), updated.getName()).append("owner", old.getOwner(), updated.getOwner())
				.append("progress", old.getProgress(), updated.getProgress())
				.append("providerSnapshotId", old.getProviderSnapshotId(), updated.getProviderSnapshotId())
				.append("regionId", old.getRegionId(), updated.getRegionId())
				.append("tags", old.getTags(), updated.getTags())
				.append("visibleScope", old.getVisibleScope(), updated.getVisibleScope())
				.append("volumeId", old.getVolumeId(), updated.getVolumeId()).build();
		return diff;
	}
}
