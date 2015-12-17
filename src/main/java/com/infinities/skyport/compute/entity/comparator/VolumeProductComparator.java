package com.infinities.skyport.compute.entity.comparator;

import java.util.Comparator;

import org.dasein.cloud.compute.VolumeProduct;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

public class VolumeProductComparator implements Comparator<VolumeProduct> {

	@Override
	public int compare(VolumeProduct a, VolumeProduct b) {
		return ComparisonChain.start().compare(a.getMaxIops(), b.getMaxIops(), Ordering.natural().nullsLast())
				.compare(a.getMinIops(), b.getMinIops(), Ordering.natural().nullsLast())
				.compare(a.getCurrency(), b.getCurrency(), Ordering.natural().nullsLast())
				.compare(a.getDescription(), b.getDescription(), Ordering.natural().nullsLast())
				.compare(a.getIopsCost(), b.getIopsCost(), Ordering.natural().nullsLast())
				.compare(a.getMaxIopsRatio(), b.getMaxIopsRatio(), Ordering.natural().nullsLast())
				// .compare(a.getMonthlyGigabyteCost(),
				// b.getMonthlyGigabyteCost(), Ordering.natural().nullsLast())
				// .compare(a.getName(), b.getName(),
				// Ordering.natural().nullsLast())
				// .compare(a.getProviderProductId(), b.getProviderProductId(),
				// Ordering.natural().nullsLast())
				// .compare(a.getType(), b.getType(),
				// Ordering.natural().nullsLast())
				// .compare(a.getMaxVolumeSize(), b.getMaxVolumeSize(),
				// storageComparator)
				// .compare(a.getMinVolumeSize(), b.getMinVolumeSize(),
				// storageComparator)
				.result();
	}

}
