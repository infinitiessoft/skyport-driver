//package com.infinities.skyport.compute.entity.comparator;
//
//import java.io.Serializable;
//import java.util.Comparator;
//
//import org.dasein.cloud.network.RawAddress;
//
//import com.google.common.collect.ComparisonChain;
//import com.google.common.collect.Ordering;
//
//public class RawAddressComparator implements Comparator<RawAddress>, Serializable {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//
//	@Override
//	public int compare(RawAddress o1, RawAddress o2) {
//		return ComparisonChain.start().compare(o1.getIpAddress(), o2.getIpAddress(), Ordering.natural().nullsLast())
//				.compare(o1.getVersion(), o2.getVersion(), Ordering.natural().nullsLast()).result();
//	}
//
//}
