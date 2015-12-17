package com.infinities.skyport.compute.entity.comparator;

import java.util.Comparator;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import com.infinities.skyport.compute.INetworkAdapter;

public class INetworkAdapterComparator implements Comparator<INetworkAdapter> {

	@Override
	public int compare(INetworkAdapter a, INetworkAdapter b) {
		return ComparisonChain.start().compare(a.getNicid(), b.getNicid(), Ordering.natural().nullsFirst())
				.compare(a.getName(), b.getName(), Ordering.natural().nullsFirst())
				.compare(a.getDesc(), b.getDesc(), Ordering.natural().nullsFirst())
				.compare(a.getNetwork(), b.getNetwork(), Ordering.natural().nullsFirst())
				.compare(a.getMac(), b.getMac(), Ordering.natural().nullsFirst())
				.compare(a.getType(), b.getType(), Ordering.natural().nullsFirst()).result();
	}

}
