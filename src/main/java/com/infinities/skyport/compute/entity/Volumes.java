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
package com.infinities.skyport.compute.entity;

import org.dasein.cloud.compute.Volume;

public class Volumes {

	private Volumes() {

	}

	@SuppressWarnings("deprecation")
	public static Volume clone(Volume volume) {
		Volume ret = new Volume();
		ret.setCreationTimestamp(volume.getCreationTimestamp());
		ret.setCurrentState(volume.getCurrentState());
		ret.setDataCenterId(volume.getDataCenterId());
		ret.setDeleteOnVirtualMachineTermination(volume.isDeleteOnVirtualMachineTermination());
		ret.setDescription(volume.getDescription());
		ret.setDeviceId(volume.getDeviceId());
		ret.setFormat(volume.getFormat());
		ret.setGuestOperatingSystem(volume.getGuestOperatingSystem());
		ret.setIops(volume.getIops());
		ret.setMediaLink(volume.getMediaLink());
		ret.setName(volume.getName());
		ret.setProviderDataCenterId(volume.getProviderDataCenterId());
		ret.setProviderProductId(volume.getProviderProductId());
		ret.setProviderRegionId(volume.getRegionId());
		ret.setProviderSnapshotId(volume.getProviderSnapshotId());
		ret.setProviderVirtualMachineId(volume.getProviderVirtualMachineId());
		ret.setProviderVlanId(volume.getProviderVlanId());
		ret.setProviderVolumeId(volume.getProviderVolumeId());
		ret.setRegionId(volume.getRegionId());
		ret.setRootVolume(volume.isRootVolume());
		ret.setServerId(volume.getServerId());
		ret.setSize(volume.getSize());
		ret.setSnapshotId(volume.getSnapshotId());
		ret.setTags(volume.getTags());
		ret.setType(volume.getType());
		return ret;
	}
}
