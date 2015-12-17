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
