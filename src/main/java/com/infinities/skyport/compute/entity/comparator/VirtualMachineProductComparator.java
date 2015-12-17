/*******************************************************************************
 * Copyright 2015 InfinitiesSoft Solutions Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *******************************************************************************/
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
