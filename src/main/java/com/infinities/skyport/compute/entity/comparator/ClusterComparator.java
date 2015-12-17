package com.infinities.skyport.compute.entity.comparator;

import java.util.Comparator;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import com.infinities.skyport.compute.entity.Cluster;

public class ClusterComparator implements Comparator<Cluster> {

	@Override
	public int compare(Cluster a, Cluster b) {
		return ComparisonChain.start().compare(a.getClusterId(), b.getClusterId(), Ordering.natural().nullsFirst())
				.compare(a.getName(), b.getName(), Ordering.natural().nullsFirst())
				.compare(a.getStatus(), b.getStatus(), Ordering.natural().nullsFirst())
				.compare(a.getDescription(), b.getDescription(), Ordering.natural().nullsFirst())
				.compare(a.getDataCenterId(), b.getDataCenterId(), Ordering.natural().nullsFirst())
				.compare(a.getHypervisorType(), b.getHypervisorType(), Ordering.natural().nullsFirst()).result();
	}

}
