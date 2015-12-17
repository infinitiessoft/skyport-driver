package com.infinities.skyport.compute.entity.comparator;

import java.util.Comparator;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import com.infinities.skyport.compute.entity.ResourcePool;

public class ResourcePoolComparator implements Comparator<ResourcePool> {

	@Override
	public int compare(ResourcePool a, ResourcePool b) {
		return ComparisonChain.start().compare(a.getResourceid(), b.getResourceid(), Ordering.natural().nullsFirst())
				.compare(a.getName(), b.getName(), Ordering.natural().nullsFirst())
				.compare(a.getStatus(), b.getStatus(), Ordering.natural().nullsFirst())
				.compare(a.getDatacenterid(), b.getDatacenterid(), Ordering.natural().nullsFirst())
				.compare(a.getHypervisortype(), b.getHypervisortype(), Ordering.natural().nullsFirst()).result();
	}

}
