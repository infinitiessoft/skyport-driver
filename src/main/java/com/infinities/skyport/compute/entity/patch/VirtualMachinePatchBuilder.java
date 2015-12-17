package com.infinities.skyport.compute.entity.patch;

import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.dasein.cloud.compute.VirtualMachine;

public class VirtualMachinePatchBuilder implements PatchBuilder<VirtualMachine> {

	@Override
	public DiffResult diff(VirtualMachine old, VirtualMachine updated) {
		DiffResult diff = new DiffBuilder(old, updated, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("providerVirtualMachineId", old.getProviderVirtualMachineId(), updated.getProviderVirtualMachineId())
				.append("providerVmStatus", old.getProviderVmStatus(), updated.getProviderVmStatus())
				.append("affinityGroupId", old.getAffinityGroupId(), updated.getAffinityGroupId())
				.append("architecture", old.getArchitecture(), updated.getArchitecture())
				.append("clientRequestToken", old.getClientRequestToken(), updated.getClientRequestToken())
				.append("clonable", old.isClonable(), updated.isClonable())
				.append("creationTimestamp", old.getCreationTimestamp(), updated.getCreationTimestamp())
				.append("currentState", old.getCurrentState(), updated.getCurrentState())
				.append("description", old.getDescription(), updated.getDescription())
				.append("imagable", old.isImagable(), updated.isImagable())
				.append("ioOptimized", old.isIoOptimized(), updated.isIoOptimized())
				.append("ipForwardingAllowed", old.isIpForwardingAllowed(), updated.isIpForwardingAllowed())
				.append("lastBootTimestamp", old.getLastBootTimestamp(), updated.getLastBootTimestamp())
				.append("lastPauseTimestamp", old.getLastPauseTimestamp(), updated.getLastPauseTimestamp())
				.append("lifecycle", old.getLifecycle(), updated.getLifecycle())
				.append("name", old.getName(), updated.getName())
				.append("pausable", old.isPausable(), updated.isPausable())
				.append("persistent", old.isPersistent(), updated.isPersistent())
				.append("platform", old.getPlatform(), updated.getPlatform())
				.append("productId", old.getProductId(), updated.getProductId())
				.append("providerAssignedIpAddressId", old.getProviderAssignedIpAddressId(),
						updated.getProviderAssignedIpAddressId())
				.append("providerDataCenterId", old.getProviderDataCenterId(), updated.getProviderDataCenterId())
				.append("providerHostStatus", old.getProviderHostStatus(), updated.getProviderHostStatus())
				.append("providerKernelImageId", old.getProviderKernelImageId(), updated.getProviderKernelImageId())
				.append("providerKeypairId", old.getProviderKeypairId(), updated.getProviderKeypairId())
				.append("providerMachineImageId", old.getProviderMachineImageId(), updated.getProviderMachineImageId())
				.append("providerOwnerId", old.getProviderOwnerId(), updated.getProviderOwnerId())
				.append("providerRamdiskImageId", old.getProviderRamdiskImageId(), updated.getProviderRamdiskImageId())
				.append("providerRegionId", old.getProviderRegionId(), updated.getProviderRegionId())
				.append("providerRoleId", old.getProviderRoleId(), updated.getProviderRoleId())
				.append("providerSubnetId", old.getProviderSubnetId(), updated.getProviderSubnetId())
				.append("providerVlanId", old.getProviderVlanId(), updated.getProviderVlanId())
				.append("rebootable", old.isRebootable(), updated.isRebootable())
				.append("resourcePoolId", old.getResourcePoolId(), updated.getResourcePoolId())
				.append("rootPassword", old.getRootPassword(), updated.getRootPassword())
				.append("rootUser", old.getRootUser(), updated.getRootUser())
				.append("spotRequestId", old.getSpotRequestId(), updated.getSpotRequestId())
				.append("stateReasonMessage", old.getStateReasonMessage(), updated.getStateReasonMessage())
				.append("terminationTimestamp", old.getTerminationTimestamp(), updated.getTerminationTimestamp())
				.append("visibleScope", old.getVisibleScope(), updated.getVisibleScope())
				.append("labels", old.getLabels(), updated.getLabels())
				.append("privateAddresses", old.getPrivateAddresses(), updated.getPrivateAddresses())
				.append("privateDnsAddress", old.getPrivateDnsAddress(), updated.getPrivateDnsAddress())
				.append("providerFirewallIds", old.getProviderFirewallIds(), updated.getProviderFirewallIds())
				.append("providerNetworkInterfaceIds", old.getProviderNetworkInterfaceIds(),
						updated.getProviderNetworkInterfaceIds())
				.append("providerShellKeyIds", old.getProviderShellKeyIds(), updated.getProviderShellKeyIds())
				.append("publicAddresses", old.getPublicAddresses(), updated.getPublicAddresses())
				.append("publicDnsAddress", old.getPublicDnsAddress(), updated.getPublicDnsAddress())
				.append("tags", old.getTags(), updated.getTags()).append("volumes", old.getVolumes(), updated.getVolumes())
				.build();
		return diff;
	}

}
