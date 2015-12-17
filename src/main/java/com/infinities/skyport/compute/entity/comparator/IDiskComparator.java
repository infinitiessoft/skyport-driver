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
