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
import org.dasein.cloud.compute.MachineImage;

public class MachineImagePatchBuilder implements PatchBuilder<MachineImage> {

	@Override
	public DiffResult diff(MachineImage old, MachineImage updated) {
		DiffResult diff = new DiffBuilder(old, updated, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("creationTimestamp", old.getCreationTimestamp(), updated.getCreationTimestamp())
				.append("minimumDiskSizeGb", old.getMinimumDiskSizeGb(), updated.getMinimumDiskSizeGb())
				.append("architecture", old.getArchitecture(), updated.getArchitecture())
				.append("currentState", old.getCurrentState(), updated.getCurrentState())
				.append("description", old.getDescription(), updated.getDescription())
				.append("imageClass", old.getImageClass(), updated.getImageClass())
				.append("kernelImageId", old.getKernelImageId(), updated.getKernelImageId())
				.append("name", old.getName(), updated.getName())
				.append("platform", old.getPlatform(), updated.getPlatform())
				.append("providerDataCenterId", old.getProviderDataCenterId(), updated.getProviderDataCenterId())
				.append("providerMachineImageId", old.getProviderMachineImageId(), updated.getProviderMachineImageId())
				.append("providerMetadata", old.getProviderMetadata(), updated.getProviderMetadata())
				.append("providerOwnerId", old.getProviderOwnerId(), updated.getProviderOwnerId())
				.append("providerRegionId", old.getProviderRegionId(), updated.getProviderRegionId())
				.append("software", old.getSoftware(), updated.getSoftware())
				.append("storageFormat", old.getStorageFormat(), updated.getStorageFormat())
				.append("tags", old.getTags(), updated.getTags()).append("type", old.getType(), updated.getType())
				.append("visibleScope", old.getVisibleScope(), updated.getVisibleScope())
				.append("volumes", old.getVolumes(), updated.getVolumes()).build();
		return diff;
	}

}
