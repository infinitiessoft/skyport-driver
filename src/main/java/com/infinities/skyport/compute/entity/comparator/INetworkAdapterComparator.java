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
