package com.infinities.skyport.compute.entity;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Callable;

import org.dasein.cloud.VisibleScope;
import org.dasein.cloud.compute.Architecture;
import org.dasein.cloud.compute.Platform;
import org.dasein.cloud.compute.VirtualMachineLifecycle;
import org.dasein.cloud.compute.VmState;
import org.dasein.cloud.compute.VmStatus;
import org.dasein.cloud.compute.Volume;
import org.dasein.cloud.network.RawAddress;

public interface IVirtualMachine extends ManagedObject, Serializable {

	String getRootPassword();

	String getAffinityGroupId();

	Architecture getArchitecture();

	boolean isClonable();

	long getCreationTimestamp();

	VmState getCurrentState();

	String getDescription();

	boolean isImagable();

	long getLastBootTimestamp();

	long getLastPauseTimestamp();

	String getName();

	boolean isPausable();

	boolean isPersistent();

	Platform getPlatform();

	String getPrivateDnsAddress();

	RawAddress[] getPrivateAddresses();

	String getProviderAssignedIpAddressId();

	String getProviderDataCenterId();

	String getProviderMachineImageId();

	String getProviderOwnerId();

	String getProviderRegionId();

	String getProviderVirtualMachineId();

	String getPublicDnsAddress();

	RawAddress[] getPublicAddresses();

	String getVirtualMachineGroup();

	boolean isRebootable();

	String getRootUser();

	String getStateReasonMessage();

	long getTerminationTimestamp();

	Callable<String> getPasswordCallback();

	String getProductId();

	String[] getLabels();

	Map<String, String> getTags();

	String getProviderSubnetId();

	String getProviderVlanId();

	String getProviderKeypairId();

	String[] getProviderFirewallIds();

	String[] getProviderNetworkInterfaceIds();

	String getProviderKernelImageId();

	String getProviderRamdiskImageId();

	String[] getProviderShellKeyIds();

	Volume[] getVolumes();

	boolean isIoOptimized();

	boolean isIpForwardingAllowed();

	String getProviderRoleId();

	VmStatus getProviderVmStatus();

	VmStatus getProviderHostStatus();

	VisibleScope getVisibleScope();

	VirtualMachineLifecycle getLifecycle();

	String getSpotRequestId();

	String getResourcePoolId();

	String getClientRequestToken();

}
