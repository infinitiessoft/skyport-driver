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
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dasein.cloud.compute.VirtualMachine;
import org.dasein.cloud.compute.Volume;
import org.dasein.cloud.network.RawAddress;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

public class VirtualMachineComparator implements Comparator<VirtualMachine> {

	private TaggableComparator taggableComparator = new TaggableComparator();
	private VolumeComparator volumeComparator = new VolumeComparator();


	@Override
	public int compare(VirtualMachine a, VirtualMachine b) {
		List<String> aLabels = a.getLabels() == null ? null : Arrays.asList(a.getLabels());
		List<String> bLabels = b.getLabels() == null ? null : Arrays.asList(b.getLabels());
		List<String> aPrivateAddress = convert(a.getPrivateAddresses());
		List<String> bPrivateAddress = convert(b.getPrivateAddresses());
		List<String> aProviderFirewallIds = a.getProviderFirewallIds() == null ? null : Arrays.asList(a
				.getProviderFirewallIds());
		List<String> bProviderFirewallIds = b.getProviderFirewallIds() == null ? null : Arrays.asList(b
				.getProviderFirewallIds());
		List<String> aProviderNetworkInterfaceIds = a.getProviderNetworkInterfaceIds() == null ? null : Arrays.asList(a
				.getProviderNetworkInterfaceIds());
		List<String> bProviderNetworkInterfaceIds = b.getProviderNetworkInterfaceIds() == null ? null : Arrays.asList(b
				.getProviderNetworkInterfaceIds());
		List<String> aProviderShellKeyIds = a.getProviderShellKeyIds() == null ? null : Arrays.asList(a
				.getProviderShellKeyIds());
		List<String> bProviderShellKeyIds = b.getProviderShellKeyIds() == null ? null : Arrays.asList(b
				.getProviderShellKeyIds());
		List<String> aPublicAddress = convert(a.getPublicAddresses());
		List<String> bPublicAddress = convert(b.getPublicAddresses());

		int ret = ComparisonChain
				.start()
				.compare(a.getProviderVirtualMachineId(), b.getProviderVirtualMachineId(), Ordering.natural().nullsLast())
				.compare(a.getProviderVmStatus(), b.getProviderVmStatus(), Ordering.natural().nullsLast())
				.compare(a.getAffinityGroupId(), b.getAffinityGroupId(), Ordering.natural().nullsLast())
				.compare(a.getArchitecture(), b.getArchitecture(), Ordering.natural().nullsLast())
				.compare(a.getClientRequestToken(), b.getClientRequestToken(), Ordering.natural().nullsLast())
				.compare(a.isClonable(), b.isClonable(), Ordering.natural().nullsLast())
				.compare(a.getCreationTimestamp(), b.getCreationTimestamp(), Ordering.natural().nullsLast())
				.compare(a.getCurrentState(), b.getCurrentState(), Ordering.natural().nullsLast())
				.compare(a.getDescription(), b.getDescription(), Ordering.natural().nullsLast())
				.compare(a.isImagable(), b.isImagable(), Ordering.natural().nullsLast())
				.compare(a.isIoOptimized(), b.isIoOptimized(), Ordering.natural().nullsLast())
				.compare(a.isIpForwardingAllowed(), b.isIpForwardingAllowed(), Ordering.natural().nullsLast())
				.compare(a.getLastBootTimestamp(), b.getLastBootTimestamp(), Ordering.natural().nullsLast())
				.compare(a.getLastPauseTimestamp(), b.getLastPauseTimestamp(), Ordering.natural().nullsLast())
				.compare(a.getLifecycle(), b.getLifecycle(), Ordering.natural().nullsLast())
				.compare(a.getName(), b.getName(), Ordering.natural().nullsLast())
				.compare(a.isPausable(), b.isPausable(), Ordering.natural().nullsLast())
				.compare(a.isPersistent(), b.isPersistent(), Ordering.natural().nullsLast())
				.compare(a.getPlatform(), b.getPlatform(), Ordering.natural().nullsLast())
				.compare(a.getProductId(), b.getProductId(), Ordering.natural().nullsLast())
				.compare(a.getProviderAssignedIpAddressId(), b.getProviderAssignedIpAddressId(),
						Ordering.natural().nullsLast())
				.compare(a.getProviderDataCenterId(), b.getProviderDataCenterId(), Ordering.natural().nullsLast())
				.compare(a.getProviderHostStatus(), b.getProviderHostStatus(), Ordering.natural().nullsLast())
				.compare(a.getProviderKernelImageId(), b.getProviderKernelImageId(), Ordering.natural().nullsLast())
				.compare(a.getProviderKeypairId(), b.getProviderKeypairId(), Ordering.natural().nullsLast())
				.compare(a.getProviderMachineImageId(), b.getProviderMachineImageId(), Ordering.natural().nullsLast())
				.compare(a.getProviderOwnerId(), b.getProviderOwnerId(), Ordering.natural().nullsLast())
				.compare(a.getProviderRamdiskImageId(), b.getProviderRamdiskImageId(), Ordering.natural().nullsLast())
				.compare(a.getProviderRegionId(), b.getProviderRegionId(), Ordering.natural().nullsLast())
				.compare(a.getProviderRoleId(), b.getProviderRoleId(), Ordering.natural().nullsLast())
				.compare(a.getProviderSubnetId(), b.getProviderSubnetId(), Ordering.natural().nullsLast())
				.compare(a.getProviderVlanId(), b.getProviderVlanId(), Ordering.natural().nullsLast())
				.compare(a.isRebootable(), b.isRebootable(), Ordering.natural().nullsLast())
				.compare(a.getResourcePoolId(), b.getResourcePoolId(), Ordering.natural().nullsLast())
				.compare(a.getRootPassword(), b.getRootPassword(), Ordering.natural().nullsLast())
				.compare(a.getRootUser(), b.getRootUser(), Ordering.natural().nullsLast())
				.compare(a.getSpotRequestId(), b.getSpotRequestId(), Ordering.natural().nullsLast())
				.compare(a.getStateReasonMessage(), b.getStateReasonMessage(), Ordering.natural().nullsLast())
				.compare(a.getTerminationTimestamp(), b.getTerminationTimestamp(), Ordering.natural().nullsLast())
				.compare(a.getVisibleScope(), b.getVisibleScope(), Ordering.natural().nullsLast())
				.compare(aLabels, bLabels, Ordering.<String>natural().lexicographical().nullsLast())
				.compare(aPrivateAddress, bPrivateAddress, Ordering.<String>natural().lexicographical().nullsLast())
				.compare(a.getPrivateDnsAddress(), b.getPrivateDnsAddress(), Ordering.natural().nullsLast())
				.compare(aProviderFirewallIds, bProviderFirewallIds,
						Ordering.<String>natural().lexicographical().nullsLast())
				.compare(aProviderNetworkInterfaceIds, bProviderNetworkInterfaceIds,
						Ordering.<String>natural().lexicographical().nullsLast())
				.compare(aProviderShellKeyIds, bProviderShellKeyIds,
						Ordering.<String>natural().lexicographical().nullsLast())
				.compare(aPublicAddress, bPublicAddress, Ordering.<String>natural().lexicographical().nullsLast())
				.compare(a.getPublicDnsAddress(), b.getPublicDnsAddress(), Ordering.natural().nullsLast())
				.compare(a, b, taggableComparator).result();
		if (ret != 0) {
			return ret;
		}

		return compareVolumes(a.getVolumes(), b.getVolumes());
	}

	private List<String> convert(RawAddress[] addresses) {
		List<String> ret = null;
		if (addresses != null) {
			ret = new ArrayList<String>();
			for (RawAddress address : addresses) {
				ret.add(address.getIpAddress());
			}
		}
		return ret;
	}

	private int compareVolumes(Volume[] a, Volume[] b) {
		if (a == null || b == null) {
			if (a == null && b == null) {
				return 0;
			} else if (a != null && b == null) {
				return 1;
			} else {
				return -1;
			}
		}

		if (a.length != b.length) {
			return ComparisonChain.start().compare(a.length, b.length).result();
		}
		Map<String, Volume> aVolumeMap = new HashMap<String, Volume>();
		Map<String, Volume> bVolumeMap = new HashMap<String, Volume>();
		for (Volume v : a) {
			aVolumeMap.put(v.getProviderVolumeId(), v);
		}
		for (Volume v : b) {
			bVolumeMap.put(v.getProviderVolumeId(), v);
		}
		int basic = aVolumeMap.keySet().containsAll(bVolumeMap.keySet()) ? 0 : 1;
		if (basic != 0) {
			return basic;
		}
		for (Volume aVolume : a) {
			Volume bVolume = bVolumeMap.get(aVolume.getProviderVolumeId());
			basic = comparaVolume(aVolume, bVolume);
			if (basic != 0) {
				return basic;
			}
		}
		return 0;
	}

	private int comparaVolume(Volume aVolume, Volume bVolume) {
		return volumeComparator.compare(aVolume, bVolume);
	}
}
