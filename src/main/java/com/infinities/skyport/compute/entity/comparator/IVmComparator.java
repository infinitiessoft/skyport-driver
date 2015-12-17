package com.infinities.skyport.compute.entity.comparator;

import java.io.Serializable;
import java.util.Comparator;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import com.infinities.skyport.compute.IVm;

public class IVmComparator implements Comparator<IVm>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public int compare(IVm a, IVm b) {
		int basic = ComparisonChain.start().compare(a.getVmid(), b.getVmid(), Ordering.natural().nullsFirst())
				.compare(a.getStatus(), b.getStatus(), Ordering.natural().nullsFirst()).result();

		if (basic != 0) {
			return basic;
		}

		return new ITemplateComparator().compare(a, b);
	}
}
