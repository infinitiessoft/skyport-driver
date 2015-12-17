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

import org.dasein.cloud.compute.Snapshot;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;


public class SnapshotComparator implements Comparator<Snapshot> {

	private TaggableComparator taggableComparator = new TaggableComparator();
	
	@Override
	public int compare(Snapshot a, Snapshot b) {
		return ComparisonChain.start()
				.compare(a.getSizeInGb(), b.getSizeInGb(), Ordering.natural().nullsLast())
				.compare(a.getSnapshotTimestamp(), b.getSnapshotTimestamp(), Ordering.natural().nullsLast())
				.compare(a.getCurrentState(), b.getCurrentState(), Ordering.natural().nullsLast())
				.compare(a.getDescription(), b.getDescription(), Ordering.natural().nullsLast())
				.compare(a.getName(), b.getName(), Ordering.natural().nullsLast())
				.compare(a.getOwner(), b.getOwner(), Ordering.natural().nullsLast())
				.compare(a.getProgress(), b.getProgress(), Ordering.natural().nullsLast())
				.compare(a.getProviderSnapshotId(), b.getProviderSnapshotId(), Ordering.natural().nullsLast())
				.compare(a.getRegionId(), b.getRegionId(), Ordering.natural().nullsLast())
				.compare(a.getVisibleScope(), b.getVisibleScope(), Ordering.natural().nullsLast())
				.compare(a.getVolumeId(), b.getVolumeId(), Ordering.natural().nullsLast())
				.compare(a, b, taggableComparator)
				.result();
	}

}
