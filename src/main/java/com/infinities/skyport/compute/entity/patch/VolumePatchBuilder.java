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
