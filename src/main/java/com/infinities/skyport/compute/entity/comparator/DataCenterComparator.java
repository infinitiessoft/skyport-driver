package com.infinities.skyport.compute.entity.comparator;

import java.util.Comparator;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import com.infinities.skyport.compute.entity.DataCenter;

public class DataCenterComparator implements Comparator<DataCenter> {

	@Override
	public int compare(DataCenter a, DataCenter b) {
		return ComparisonChain.start().compare(a.getDataCenterId(), b.getDataCenterId(), Ordering.natural().nullsFirst())
				.compare(a.getName(), b.getName(), Ordering.natural().nullsFirst())
				.compare(a.getDescription(), b.getDescription(), Ordering.natural().nullsFirst())
				.compare(a.getStatus(), b.getStatus(), Ordering.natural().nullsFirst())
				.compare(a.getType(), b.getType(), Ordering.natural().nullsFirst()).result();
	}

}
