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
