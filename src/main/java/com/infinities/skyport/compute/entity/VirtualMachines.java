package com.infinities.skyport.compute.entity;

import org.dasein.cloud.compute.VirtualMachine;

public class VirtualMachines {

	private VirtualMachines() {

	}

	public static VirtualMachine clone(VirtualMachine vm) {
		VirtualMachine ret = new VirtualMachine();
		ret.setAffinityGroupId(vm.getAffinityGroupId());
		ret.setArchitecture(vm.getArchitecture());
		ret.setClientRequestToken(vm.getClientRequestToken());
		ret.setClonable(vm.isClonable());
		ret.setCreationTimestamp(vm.getCreationTimestamp());
		ret.setCurrentState(vm.getCurrentState());
		ret.setDescription(vm.getDescription());
		ret.setImagable(vm.isImagable());
		ret.setIoOptimized(vm.isIoOptimized());
		ret.setIpForwardingAllowed(vm.isIpForwardingAllowed());
		ret.setLabels(vm.getLabels());
		ret.setLastBootTimestamp(vm.getLastBootTimestamp());
		ret.setLastPauseTimestamp(vm.getLastPauseTimestamp());
		ret.setLifecycle(vm.getLifecycle());
		ret.setName(vm.getName());
		ret.setPausable(vm.isPausable());
		ret.setPersistent(vm.isPersistent());
		ret.setPlatform(vm.getPlatform());
		ret.setPrivateAddresses(vm.getPrivateAddresses());
		ret.setPrivateDnsAddress(vm.getPrivateDnsAddress());
		ret.setProductId(vm.getProductId());
		ret.setProviderAssignedIpAddressId(vm.getProviderAssignedIpAddressId());
		ret.setProviderDataCenterId(vm.getProviderDataCenterId());
		ret.setProviderFirewallIds(vm.getProviderFirewallIds());
		ret.setProviderHostStatus(vm.getProviderHostStatus());
		ret.setProviderKernelImageId(vm.getProviderKernelImageId());
		ret.setProviderKeypairId(vm.getProviderKeypairId());
		ret.setProviderMachineImageId(vm.getProviderMachineImageId());
		ret.setProviderNetworkInterfaceIds(vm.getProviderNetworkInterfaceIds());
		ret.setProviderOwnerId(vm.getProviderOwnerId());
		ret.setProviderRamdiskImageId(vm.getProviderRamdiskImageId());
		ret.setProviderRegionId(vm.getProviderRegionId());
		ret.setProviderRoleId(vm.getProviderRoleId());
		ret.setProviderShellKeyIds(vm.getProviderShellKeyIds());
		ret.setProviderSubnetId(vm.getProviderSubnetId());
		ret.setProviderVirtualMachineId(vm.getProviderVirtualMachineId());
		ret.setProviderVlanId(vm.getProviderVlanId());
		ret.setProviderVmStatus(vm.getProviderVmStatus());
		ret.setPublicAddresses(vm.getPublicAddresses());
		ret.setPublicDnsAddress(vm.getPublicDnsAddress());
		ret.setRebootable(vm.isRebootable());
		ret.setResourcePoolId(vm.getResourcePoolId());
		ret.setRootPassword(vm.getRootPassword());
		ret.setRootUser(vm.getRootUser());
		ret.setSpotRequestId(vm.getSpotRequestId());
		ret.setStateReasonMessage(vm.getStateReasonMessage());
		ret.setTags(vm.getTags());
		ret.setTerminationTimestamp(vm.getTerminationTimestamp());
		ret.setVisibleScope(vm.getVisibleScope());
		ret.setVolumes(vm.getVolumes());
		return ret;
	}

}
