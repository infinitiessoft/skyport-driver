package com.infinities.skyport.compute.entity;

import org.dasein.cloud.compute.MachineImage;

public class MachineImages {

	private MachineImages() {

	}

	public static MachineImage clone(MachineImage image) {
		MachineImage ret = MachineImage.getInstance(image.getProviderOwnerId(), image.getProviderRegionId(),
				image.getProviderMachineImageId(), image.getImageClass(), image.getCurrentState(), image.getName(),
				image.getDescription(), image.getArchitecture(), image.getPlatform());
		return ret;
	}

}
