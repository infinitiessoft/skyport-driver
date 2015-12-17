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
package com.infinities.skyport.compute.entity;

import org.dasein.cloud.compute.Snapshot;


public class Snapshots {
	
	private Snapshots() {
		
	}
	
	public static Snapshot clone(Snapshot snapshot) {
		Snapshot ret = new Snapshot();
		ret.setCurrentState(snapshot.getCurrentState());
		ret.setDescription(snapshot.getDescription());
		ret.setName(snapshot.getName());
		ret.setOwner(snapshot.getOwner());
		ret.setProgress(snapshot.getProgress());
		ret.setProviderSnapshotId(snapshot.getProviderSnapshotId());
		ret.setRegionId(snapshot.getRegionId());
		ret.setSizeInGb(snapshot.getSizeInGb());
		ret.setSnapshotTimestamp(snapshot.getSnapshotTimestamp());
		ret.setTags(snapshot.getTags());
		ret.setVisibleScope(snapshot.getVisibleScope());
		ret.setVolumeId(snapshot.getVolumeId());
		return ret;
	}

}
