package com.infinities.skyport.compute.entity;

import org.dasein.cloud.compute.VolumeProduct;

public class VolumeProducts {

	private VolumeProducts() {

	}

	@SuppressWarnings("deprecation")
	public static VolumeProduct clone(VolumeProduct product) {
		VolumeProduct ret = VolumeProduct.getInstance(product.getProviderProductId(), product.getName(),
				product.getDescription(), product.getType(), product.getVolumeSize(), product.getCurrency(),
				product.getMinIops(), product.getMaxIops(), product.getMonthlyGigabyteCost(), product.getIopsCost());
		return ret;
	}
}
