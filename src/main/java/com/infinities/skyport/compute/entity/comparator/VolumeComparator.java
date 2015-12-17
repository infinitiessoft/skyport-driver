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

import org.dasein.cloud.compute.Volume;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

public class VolumeComparator implements Comparator<Volume> {

	private TaggableComparator taggableComparator = new TaggableComparator();


	@Override
	public int compare(Volume o1, Volume o2) {
		return ComparisonChain
				.start()
				.compare(o1.getCreationTimestamp(), o2.getCreationTimestamp())
				.compare(o1.getIops(), o2.getIops())
				.compare(o1.getSizeInGigabytes(), o2.getSizeInGigabytes())
				.compare(o1.getCurrentState(), o2.getCurrentState(), Ordering.natural().nullsLast())
				.compareFalseFirst(o1.isAttached(), o2.isAttached())
				.compareFalseFirst(o1.isRootVolume(), o2.isRootVolume())
				.compare(o1.getDescription(), o2.getDescription(), Ordering.natural().nullsLast())
				.compare(o1.getDeviceId(), o2.getDeviceId(), Ordering.natural().nullsLast())
				.compare(o1.getFormat(), o2.getFormat(), Ordering.natural().nullsLast())
				.compare(o1.getGuestOperatingSystem(), o2.getGuestOperatingSystem(), Ordering.natural().nullsLast())
				.compare(o1.getMediaLink(), o2.getMediaLink(), Ordering.natural().nullsLast())
				.compare(o1.getName(), o2.getName(), Ordering.natural().nullsLast())
				.compare(o1.getProviderDataCenterId(), o2.getProviderDataCenterId(), Ordering.natural().nullsLast())
				.compare(o1.getProviderProductId(), o2.getProviderProductId(), Ordering.natural().nullsLast())
				.compare(o1.getProviderRegionId(), o2.getProviderRegionId(), Ordering.natural().nullsLast())
				.compare(o1.getProviderSnapshotId(), o2.getProviderSnapshotId(), Ordering.natural().nullsLast())
				.compare(o1.getProviderVirtualMachineId(), o2.getProviderVirtualMachineId(), Ordering.natural().nullsLast())
				.compare(o1.getProviderVlanId(), o2.getProviderVlanId(), Ordering.natural().nullsLast())
				.compare(o1.getProviderVolumeId(), o2.getProviderVolumeId(), Ordering.natural().nullsLast())
				.compare(o1.getType(), o2.getType(), Ordering.natural().nullsLast())
				.compare(o1.isDeleteOnVirtualMachineTermination(), o2.isDeleteOnVirtualMachineTermination(),
						Ordering.natural().nullsLast()).compare(o1, o2, taggableComparator).result();
	}

}
