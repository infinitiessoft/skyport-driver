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
import org.dasein.cloud.compute.Volume;

public class VolumePatchBuilder implements PatchBuilder<Volume> {

	@Override
	public DiffResult diff(Volume old, Volume updated) {
		DiffResult diff = new DiffBuilder(old, updated, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("creationTimestamp", old.getCreationTimestamp(), updated.getCreationTimestamp())
				.append("iops", old.getIops(), updated.getIops())
				.append("currentState", old.getCurrentState(), updated.getCurrentState())
				.append("description", old.getDescription(), updated.getDescription())
				.append("deviceId", old.getDeviceId(), updated.getDeviceId())
				.append("format", old.getFormat(), updated.getFormat())
				.append("guestOperatingSystem", old.getGuestOperatingSystem(), updated.getGuestOperatingSystem())
				.append("mediaLink", old.getMediaLink(), updated.getMediaLink())
				.append("name", old.getName(), updated.getName())
				.append("providerDataCenterId", old.getProviderDataCenterId(), updated.getProviderDataCenterId())
				.append("providerProductId", old.getProviderProductId(), updated.getProviderProductId())
				.append("providerRegionId", old.getProviderRegionId(), updated.getProviderRegionId())
				.append("providerSnapshotId", old.getProviderSnapshotId(), updated.getProviderSnapshotId())
				.append("providerVirtualMachineId", old.getProviderVirtualMachineId(), updated.getProviderVirtualMachineId())
				.append("providerVlanId", old.getProviderVlanId(), updated.getProviderVlanId())
				.append("providerVolumeId", old.getProviderVolumeId(), updated.getProviderVolumeId())
				.append("size", old.getSize(), updated.getSize())
				.append("tags", old.getTags(), updated.getTags())
				.append("deleteOnVirtualMachineTermination", old.isDeleteOnVirtualMachineTermination(),
						updated.isDeleteOnVirtualMachineTermination()).append("type", old.getType(), updated.getType())
				.append("rootVolume", old.isRootVolume(), updated.isRootVolume()).build();
		return diff;
	}

}
