package com.infinities.skyport.compute.entity.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dasein.cloud.compute.MachineImage;
import org.dasein.cloud.compute.MachineImageVolume;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

public class MachineImageComparator implements Comparator<MachineImage> {

	private TaggableComparator taggableComparator = new TaggableComparator();


	@Override
	public int compare(MachineImage a, MachineImage b) {
		List<String> aMetadata = convert(a.getProviderMetadata());
		List<String> bMeatadata = convert(b.getProviderMetadata());

		List<String> aVolume = convert(a.getVolumes());
		List<String> bVolume = convert(b.getVolumes());

		return ComparisonChain.start()
				.compare(a.getCreationTimestamp(), b.getCreationTimestamp(), Ordering.natural().nullsLast())
				.compare(a.getMinimumDiskSizeGb(), b.getMinimumDiskSizeGb(), Ordering.natural().nullsLast())
				.compare(a.getArchitecture(), b.getArchitecture(), Ordering.natural().nullsLast())
				.compare(a.getCurrentState(), b.getCurrentState(), Ordering.natural().nullsLast())
				.compare(a.getDescription(), b.getDescription(), Ordering.natural().nullsLast())
				.compare(a.getImageClass(), b.getImageClass(), Ordering.natural().nullsLast())
				.compare(a.getKernelImageId(), b.getKernelImageId(), Ordering.natural().nullsLast())
				.compare(a.getName(), b.getName(), Ordering.natural().nullsLast())
				.compare(a.getPlatform(), b.getPlatform(), Ordering.natural().nullsLast())
				.compare(a.getProviderDataCenterId(), b.getProviderDataCenterId(), Ordering.natural().nullsLast())
				.compare(a.getProviderMachineImageId(), b.getProviderMachineImageId(), Ordering.natural().nullsLast())
				.compare(a.getProviderOwnerId(), b.getProviderOwnerId(), Ordering.natural().nullsLast())
				.compare(a.getProviderRegionId(), b.getProviderRegionId(), Ordering.natural().nullsLast())
				.compare(aMetadata, bMeatadata, Ordering.<String>natural().lexicographical().nullsLast())
				.compare(aVolume, bVolume, Ordering.<String>natural().lexicographical().nullsLast())
				.compare(a, b, taggableComparator).result();
	}

	private List<String> convert(Iterable<MachineImageVolume> volumes) {
		List<String> ret = null;
		if (volumes != null) {
			ret = new ArrayList<String>();
			for (MachineImageVolume volume : volumes) {
				ret.add(volume.getSnapshotId());
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
