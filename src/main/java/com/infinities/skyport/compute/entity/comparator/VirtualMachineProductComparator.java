package com.infinities.skyport.compute.entity.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dasein.cloud.compute.Architecture;
import org.dasein.cloud.compute.VirtualMachineProduct;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

public class VirtualMachineProductComparator implements Comparator<VirtualMachineProduct> {

	@Override
	public int compare(VirtualMachineProduct a, VirtualMachineProduct b) {
		List<String> aArch = convert(a.getArchitectures());
		List<String> bArch = convert(b.getArchitectures());

		List<String> aMetadata = convert(a.getProviderMetadata());
		List<String> bMeatadata = convert(b.getProviderMetadata());

		return ComparisonChain.start().compare(a.getCpuCount(), b.getCpuCount(), Ordering.natural().nullsLast())
				.compare(a.getStandardHourlyRate(), b.getStandardHourlyRate(), Ordering.natural().nullsLast())
				.compare(a.getDataCenterId(), b.getDataCenterId(), Ordering.natural().nullsLast())
				.compare(a.getDescription(), b.getDescription(), Ordering.natural().nullsLast())
				.compare(a.getName(), b.getName(), Ordering.natural().nullsLast())
				.compare(a.getProviderProductId(), b.getProviderProductId(), Ordering.natural().nullsLast())
				.compare(a.getStatus(), b.getStatus(), Ordering.natural().nullsLast())
				.compare(a.getVisibleScope(), b.getVisibleScope(), Ordering.natural().nullsLast())
				.compare(aArch, bArch, Ordering.<String>natural().lexicographical().nullsLast())
				.compare(aMetadata, bMeatadata, Ordering.<String>natural().lexicographical().nullsLast())
				.compare(a.getRamSize().toString(), b.getRamSize().toString(), Ordering.natural().nullsLast())
				.compare(a.getRootVolumeSize().toString(), b.getRootVolumeSize().toString(), Ordering.natural().nullsLast())
				.result();
	}

	private List<String> convert(Architecture[] architectures) {
		List<String> ret = null;
		if (architectures != null) {
			ret = new ArrayList<String>();
			for (Architecture architecture : architectures) {
				ret.add(architecture.name());
			}
		}
		return ret;
	}

	private List<String> convert(Map<String, String> metadatas) {
		List<String> ret = null;
		if (metadatas != null) {
			ret = new ArrayList<String>();
			for (Entry<String, String> entry : metadatas.entrySet()) {
				ret.add(entry.getKey() + ":" + entry.getValue());
			}
		}
		return ret;
	}

}
