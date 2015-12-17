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
