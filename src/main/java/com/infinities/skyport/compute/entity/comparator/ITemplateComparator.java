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

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import com.infinities.skyport.compute.IComputeObject;
import com.infinities.skyport.compute.IDisk;
import com.infinities.skyport.compute.INetworkAdapter;

public class ITemplateComparator implements Comparator<IComputeObject>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public int compare(IComputeObject a, IComputeObject b) {
		int basic = ComparisonChain.start().compare(a.getTemplateid(), b.getTemplateid(), Ordering.natural().nullsFirst())
				.compare(a.getName(), b.getName(), Ordering.natural().nullsFirst())
				.compare(a.getDesc(), b.getDesc(), Ordering.natural().nullsFirst())
				.compare(a.getOs(), b.getOs(), Ordering.natural().nullsFirst())
				.compare(a.getCpunum(), b.getCpunum(), Ordering.natural().nullsFirst())
				.compare(a.getMemorysize(), b.getMemorysize(), Ordering.natural().nullsFirst())
				.compare(a.getDisks().size(), b.getDisks().size()).compare(a.getNics().size(), b.getNics().size()).result();

		if (basic != 0) {
			return basic;
		}

		basic += compareDisks(a.getDisks(), b.getDisks());
		if (basic != 0) {
			return basic;
		}

		basic += compareNics(a.getNics(), b.getNics());
		return basic;
	}

	private int compareNics(Set<? extends INetworkAdapter> set, Set<? extends INetworkAdapter> set2) {
		Map<String, INetworkAdapter> aNicMap = new HashMap<String, INetworkAdapter>();
		Map<String, INetworkAdapter> bNicMap = new HashMap<String, INetworkAdapter>();
		for (INetworkAdapter nic : set) {
			aNicMap.put(nic.getNicid(), nic);
		}
		for (INetworkAdapter nic : set2) {
			bNicMap.put(nic.getNicid(), nic);
		}
		int basic = aNicMap.keySet().containsAll(bNicMap.keySet()) ? 0 : 1;
		if (basic != 0) {
			return basic;
		}
		for (INetworkAdapter nic : set) {
			INetworkAdapter bnic = bNicMap.get(nic.getNicid());
			basic = comparaNic(nic, bnic);
			if (basic != 0) {
				return basic;
			}
		}

		return 0;
	}

	private int comparaNic(INetworkAdapter a, INetworkAdapter b) {
		return new INetworkAdapterComparator().compare(a, b);
	}

	private int compareDisks(Set<? extends IDisk> set, Set<? extends IDisk> set2) {
		Map<String, IDisk> aDiskMap = new HashMap<String, IDisk>();
		Map<String, IDisk> bDiskMap = new HashMap<String, IDisk>();
		for (IDisk disk : set) {
			aDiskMap.put(disk.getDiskid(), disk);
		}
		for (IDisk disk : set2) {
			bDiskMap.put(disk.getDiskid(), disk);
		}
		int basic = aDiskMap.keySet().containsAll(bDiskMap.keySet()) ? 0 : 1;
		if (basic != 0) {
			return basic;
		}
		for (IDisk disk : set) {
			IDisk bdisk = bDiskMap.get(disk.getDiskid());
			basic = comparaDisk(disk, bdisk);
			if (basic != 0) {
				return basic;
			}
		}

		return 0;
	}

	private int comparaDisk(IDisk a, IDisk b) {
		return new IDiskComparator().compare(a, b);
	}
}
