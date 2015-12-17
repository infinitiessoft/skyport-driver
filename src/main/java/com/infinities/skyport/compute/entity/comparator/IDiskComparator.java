package com.infinities.skyport.compute.entity.comparator;

import java.util.Comparator;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import com.infinities.skyport.compute.IDisk;

public class IDiskComparator implements Comparator<IDisk> {

	@Override
	public int compare(IDisk a, IDisk b) {
		return ComparisonChain.start().compare(a.getDiskid(), b.getDiskid(), Ordering.natural().nullsFirst())
				.compare(a.getName(), b.getName(), Ordering.natural().nullsFirst())
				.compare(a.getDesc(), b.getDesc(), Ordering.natural().nullsFirst())
				.compare(a.getDiskinterface(), b.getDiskinterface(), Ordering.natural().nullsFirst())
				.compare(a.getDisktype(), b.getDisktype(), Ordering.natural().nullsFirst())
				.compare(a.getInternaldrivemapping(), b.getInternaldrivemapping(), Ordering.natural().nullsFirst())
				.compare(a.getVolumeformat(), b.getVolumeformat(), Ordering.natural().nullsFirst())
				.compare(a.getVolumetype(), b.getVolumetype(), Ordering.natural().nullsFirst())
				.compare(a.getSizegb(), b.getSizegb(), Ordering.natural().nullsFirst()).result();
	}

}
