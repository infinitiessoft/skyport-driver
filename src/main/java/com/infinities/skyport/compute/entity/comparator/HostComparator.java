package com.infinities.skyport.compute.entity.comparator;

import java.util.Comparator;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import com.infinities.skyport.compute.entity.Host;

public class HostComparator implements Comparator<Host> {

	@Override
	public int compare(Host a, Host b) {
		return ComparisonChain.start().compare(a.getHostid(), b.getHostid(), Ordering.natural().nullsFirst())
				.compare(a.getName(), b.getName(), Ordering.natural().nullsFirst())
				.compare(a.getDesc(), b.getDesc(), Ordering.natural().nullsFirst())
				.compare(a.getIp(), b.getIp(), Ordering.natural().nullsFirst())
				.compare(a.getStatus(), b.getStatus(), Ordering.natural().nullsFirst())
				.compare(a.getPort(), b.getPort(), Ordering.natural().nullsFirst()).result();
	}

}
