package com.infinities.skyport.compute.entity.comparator;

import java.util.Comparator;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import com.infinities.skyport.compute.entity.Network;

public class NetworkComparator implements Comparator<Network> {

	@Override
	public int compare(Network a, Network b) {
		return ComparisonChain.start().compare(a.getNetworkid(), b.getNetworkid(), Ordering.natural().nullsFirst())
				.compare(a.getName(), b.getName(), Ordering.natural().nullsFirst())
				.compare(a.getDesc(), b.getDesc(), Ordering.natural().nullsFirst())
				.compare(a.getStatus(), b.getStatus(), Ordering.natural().nullsFirst())
				.compare(a.getDatacenterid(), b.getDatacenterid(), Ordering.natural().nullsFirst())
				.compare(a.getIsdisplay(), b.getIsdisplay(), Ordering.natural().nullsFirst()).result();
	}

}
