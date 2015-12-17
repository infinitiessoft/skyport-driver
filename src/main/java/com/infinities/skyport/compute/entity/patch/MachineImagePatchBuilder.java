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
