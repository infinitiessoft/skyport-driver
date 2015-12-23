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

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.Callable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.dasein.cloud.CloudException;
import org.dasein.cloud.CloudProvider;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.OperationNotSupportedException;
import org.dasein.cloud.Tag;
import org.dasein.cloud.Taggable;
import org.dasein.cloud.VisibleScope;
import org.dasein.cloud.compute.Architecture;
import org.dasein.cloud.compute.ComputeServices;
import org.dasein.cloud.compute.Platform;
import org.dasein.cloud.compute.VirtualMachineLifecycle;
import org.dasein.cloud.compute.VmState;
import org.dasein.cloud.compute.VmStatus;
import org.dasein.cloud.compute.Volume;
import org.dasein.cloud.compute.VolumeFilterOptions;
import org.dasein.cloud.compute.VolumeSupport;
import org.dasein.cloud.network.Networkable;

import com.infinities.skyport.network.SkyportRawAddress;

/**
 * @author pohsun
 *
 */
public class NovaStyleVirtualMachine implements Networkable, Taggable {

	private String affinityGroupId;
	private Architecture architecture;
	private boolean clonable;
	private long creationTimestamp;
	private VmState currentState;
	private Map<String, String> tags;
	private String[] labels;
	private String description;
	private boolean imagable;
	private long lastBootTimestamp;
	private long lastPauseTimestamp;
	private String name;
	private boolean pausable;
	private boolean persistent;
	private Platform platform;
	private String privateDnsAddress;
	private SkyportRawAddress[] privateIpAddresses;
	private String productId;
	private String providerAssignedIpAddressId;
	private String providerDataCenterId;
	private String providerKernelImageId;
	private String providerMachineImageId;
	private String providerOwnerId;
	private String providerRamdiskImageId;
	private String providerRegionId;
	private String[] providerShellKeyIds;
	private String providerSubnetId;
	private String providerVirtualMachineId;
	private String[] providerNetworkInterfaceIds;
	private String providerVlanId;
	private String providerKeypairId;
	private String[] providerFirewallIds;
	private String[] providerVolumeIds;
	private String publicDnsAddress;
	private SkyportRawAddress[] publicIpAddresses;
	private boolean rebootable;
	private String rootPassword;
	private String rootUser;
	private String stateReasonMessage;
	private long terminationTimestamp;
	private Volume[] volumes;
	private boolean ioOptimized;
	private boolean ipForwardingAllowed;
	private String providerRoleId;
	private VmStatus providerHostStatus;
	private VmStatus providerVmStatus;
	private String virtualMachineGroup;
	private VisibleScope visibleScope;
	private VirtualMachineLifecycle lifecycle;
	private String spotRequestId; // TODO - add filtering by, add setter/getter
	private String resourcePoolId;
	private String clientRequestToken;


	public NovaStyleVirtualMachine() {

	}

	@Override
	public boolean equals(Object ob) {
		if (ob == null) {
			return false;
		}
		if (ob == this) {
			return true;
		}
		if (!getClass().equals(ob.getClass())) {
			return false;
		}
		NovaStyleVirtualMachine other = (NovaStyleVirtualMachine) ob;

		if (!getProviderRegionId().equals(other.getProviderRegionId())) {
			return false;
		}
		return getProviderVirtualMachineId().equals(other.getProviderVirtualMachineId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((providerRegionId == null) ? 0 : providerRegionId.hashCode());
		result = prime * result + ((providerVirtualMachineId == null) ? 0 : providerVirtualMachineId.hashCode());
		return result;
	}

	public void addTag(Tag t) {
		addTag(t.getKey(), t.getValue());
	}

	public void addTag(String key, String value) {
		getTags().put(key, value);
	}


	private transient volatile Callable<String> passwordCallback;


	public void setPasswordCallback(Callable<String> callback) {
		this.passwordCallback = callback;
	}

	public void setRootPassword(String rootPassword) {
		this.rootPassword = rootPassword;
	}

	public String getRootPassword() {
		String pw;

		synchronized (this) {
			pw = rootPassword;
		}
		if (pw != null) {
			return pw;
		}
		if (passwordCallback != null) {
			pw = fetchPassword();
		}
		return pw;
	}

	public String getRootPassword(long timeoutInMilliseconds) throws InterruptedException {
		long timeout = System.currentTimeMillis() + timeoutInMilliseconds;
		String pw = getRootPassword();
		boolean hasCallback;

		synchronized (this) {
			hasCallback = (passwordCallback != null);
		}
		if (hasCallback) {
			while (pw == null) {
				if (timeout <= System.currentTimeMillis()) {
					throw new InterruptedException("System timed out waiting for a password to become available.");
				}
				try {
					Thread.sleep(15000L);
				} catch (InterruptedException ignore) {
				}
				pw = getRootPassword();
			}
		}
		return pw;
	}

	public String fetchPassword() {
		String pw;

		synchronized (this) {
			pw = rootPassword;
		}
		if (pw != null) {
			return pw;
		}
		if (passwordCallback == null) {
			return null;
		}
		try {
			pw = passwordCallback.call();
			if (pw != null) {
				synchronized (this) {
					rootPassword = pw;
				}
			}
			return rootPassword;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String toString() {
		return name + " [" + providerVirtualMachineId + "]";
	}

	public String getAffinityGroupId() {
		return affinityGroupId;
	}

	public void setAffinityGroupId(String affinityGroupId) {
		this.affinityGroupId = affinityGroupId;
	}

	public Architecture getArchitecture() {
		return architecture;
	}

	public void setArchitecture(Architecture architecture) {
		this.architecture = architecture;
	}

	public boolean isClonable() {
		return clonable;
	}

	public void setClonable(boolean clonable) {
		this.clonable = clonable;
	}

	public long getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(long creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public VmState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(VmState currentState) {
		this.currentState = currentState;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isImagable() {
		return imagable;
	}

	public void setImagable(boolean imagable) {
		this.imagable = imagable;
	}

	public long getLastBootTimestamp() {
		return lastBootTimestamp;
	}

	public void setLastBootTimestamp(long lastBootTimestamp) {
		this.lastBootTimestamp = lastBootTimestamp;
	}

	public long getLastPauseTimestamp() {
		return lastPauseTimestamp;
	}

	public void setLastPauseTimestamp(long lastPauseTimestamp) {
		this.lastPauseTimestamp = lastPauseTimestamp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPausable() {
		return pausable;
	}

	public void setPausable(boolean pausable) {
		this.pausable = pausable;
	}

	public boolean isPersistent() {
		return persistent;
	}

	public void setPersistent(boolean persistent) {
		this.persistent = persistent;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public String getPrivateDnsAddress() {
		return privateDnsAddress;
	}

	public void setPrivateDnsAddress(String privateDnsAddress) {
		this.privateDnsAddress = privateDnsAddress;
	}

	@Nonnull
	public SkyportRawAddress[] getPrivateAddresses() {
		return (privateIpAddresses == null ? new SkyportRawAddress[0] : privateIpAddresses);
	}

	/**
	 * @return a list of private IP address strings
	 * @deprecated Use {@link #getPrivateAddresses()}
	 */
	@Deprecated
	public String[] getPrivateIpAddresses() {
		String[] addrs = new String[privateIpAddresses == null ? 0 : privateIpAddresses.length];

		if (privateIpAddresses != null) {
			int i = 0;

			for (SkyportRawAddress addr : privateIpAddresses) {
				addrs[i++] = addr.getIpAddress();
			}
		}
		return addrs;
	}

	public void setPrivateAddresses(@Nonnull SkyportRawAddress... addresses) {
		privateIpAddresses = addresses;
	}

	public String getProviderAssignedIpAddressId() {
		return providerAssignedIpAddressId;
	}

	public void setProviderAssignedIpAddressId(String providerAssignedIpAddressId) {
		this.providerAssignedIpAddressId = providerAssignedIpAddressId;
	}

	public String getProviderDataCenterId() {
		return providerDataCenterId;
	}

	public void setProviderDataCenterId(String providerDataCenterId) {
		this.providerDataCenterId = providerDataCenterId;
	}

	public String getProviderMachineImageId() {
		return providerMachineImageId;
	}

	public void setProviderMachineImageId(String providerMachineImageId) {
		this.providerMachineImageId = providerMachineImageId;
	}

	public String getProviderOwnerId() {
		return providerOwnerId;
	}

	public void setProviderOwnerId(String providerOwnerId) {
		this.providerOwnerId = providerOwnerId;
	}

	public String getProviderRegionId() {
		return providerRegionId;
	}

	public void setProviderRegionId(String providerRegionId) {
		this.providerRegionId = providerRegionId;
	}

	public String getProviderVirtualMachineId() {
		return providerVirtualMachineId;
	}

	public void setProviderVirtualMachineId(String providerVirtualMachineId) {
		this.providerVirtualMachineId = providerVirtualMachineId;
	}

	public String getPublicDnsAddress() {
		return publicDnsAddress;
	}

	public void setPublicDnsAddress(String publicDnsAddress) {
		this.publicDnsAddress = publicDnsAddress;
	}

	@Nonnull
	public SkyportRawAddress[] getPublicAddresses() {
		return (publicIpAddresses == null ? new SkyportRawAddress[0] : publicIpAddresses);
	}

	/**
	 * Creates an informal association under a group name for the launched VM
	 * with other virtual machines in the system. The underlying cloud may
	 * interpret this in any number of ways.
	 *
	 * @return the virtual machine group association
	 */
	@Nullable
	public String getVirtualMachineGroup() {
		return virtualMachineGroup;
	}

	/**
	 * @param virtualMachineGroup
	 *            the virtualMachineGroup to set
	 */
	public void setVirtualMachineGroup(String virtualMachineGroup) {
		this.virtualMachineGroup = virtualMachineGroup;
	}

	public void setPublicAddresses(@Nonnull SkyportRawAddress... addresses) {
		publicIpAddresses = addresses;
	}

	public boolean isRebootable() {
		return rebootable;
	}

	public void setRebootable(boolean rebootable) {
		this.rebootable = rebootable;
	}

	public String getRootUser() {
		return rootUser;
	}

	public void setRootUser(String rootUser) {
		this.rootUser = rootUser;
	}

	public String getStateReasonMessage() {
		return stateReasonMessage;
	}

	public void setStateReasonMessage(String stateReasonMessage) {
		this.stateReasonMessage = stateReasonMessage;
	}

	public long getTerminationTimestamp() {
		return terminationTimestamp;
	}

	public void setTerminationTimestamp(long terminationTimestamp) {
		this.terminationTimestamp = terminationTimestamp;
	}

	public Callable<String> getPasswordCallback() {
		return passwordCallback;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductId() {
		return productId;
	}

	public void setLabels(String[] labels) {
		this.labels = labels;
	}

	public String[] getLabels() {
		return (labels == null ? new String[0] : labels);
	}

	public Object getTag(String tag) {
		return getTags().get(tag);
	}

	@Override
	@Nonnull
	public synchronized Map<String, String> getTags() {
		if (tags == null) {
			tags = new HashMap<String, String>();
		}
		return tags;
	}

	@Override
	public void setTag(@Nonnull String key, @Nonnull String value) {
		if (tags == null) {
			tags = new HashMap<String, String>();
		}
		tags.put(key, value);
	}

	public synchronized void setTags(Map<String, String> properties) {
		getTags().clear();
		getTags().putAll(properties);
	}

	public void setProviderSubnetId(String providerSubnetId) {
		this.providerSubnetId = providerSubnetId;
	}

	public String getProviderSubnetId() {
		return providerSubnetId;
	}

	public void setProviderVlanId(String providerVlanId) {
		this.providerVlanId = providerVlanId;
	}

	public String getProviderVlanId() {
		return providerVlanId;
	}

	public String getProviderKeypairId() {
		return providerKeypairId;
	}

	public void setProviderKeypairId(String providerKeypairId) {
		this.providerKeypairId = providerKeypairId;
	}

	public String[] getProviderFirewallIds() {
		return (providerFirewallIds == null ? new String[0] : providerFirewallIds);
	}

	public void setProviderFirewallIds(String[] providerFirewallIds) {
		this.providerFirewallIds = providerFirewallIds;
	}

	public String[] getProviderNetworkInterfaceIds() {
		return (providerNetworkInterfaceIds == null ? new String[0] : providerNetworkInterfaceIds);
	}

	public void setProviderNetworkInterfaceIds(String[] providerNetworkInterfaceIds) {
		this.providerNetworkInterfaceIds = providerNetworkInterfaceIds;
	}

	@Nullable
	public String getProviderKernelImageId() {
		return providerKernelImageId;
	}

	public void setProviderKernelImageId(@Nullable String providerKernelImageId) {
		this.providerKernelImageId = providerKernelImageId;
	}

	@Nullable
	public String getProviderRamdiskImageId() {
		return providerRamdiskImageId;
	}

	public void setProviderRamdiskImageId(@Nullable String providerRamdiskImageId) {
		this.providerRamdiskImageId = providerRamdiskImageId;
	}

	public void setProviderShellKeyIds(@Nonnull String... keyIds) {
		this.providerShellKeyIds = keyIds;
	}

	@Nonnull
	public String[] getProviderShellKeyIds() {
		return (providerShellKeyIds == null ? new String[0] : providerShellKeyIds);
	}

	@Nonnull
	public String[] getProviderVolumeIds(@Nonnull CloudProvider provider) throws CloudException, InternalException {
		if (providerVolumeIds == null) {
			ComputeServices services = provider.getComputeServices();

			if (services == null) {
				throw new OperationNotSupportedException("No compute services are defined");
			}
			VolumeSupport support = services.getVolumeSupport();

			if (support == null) {
				providerVolumeIds = new String[0];
			} else {
				TreeSet<String> ids = new TreeSet<String>();
				VolumeFilterOptions options = VolumeFilterOptions.getInstance().attachedTo(providerVirtualMachineId);
				for (Volume v : support.listVolumes(options)) {
					ids.add(v.getProviderVolumeId());
				}
				providerVolumeIds = ids.toArray(new String[ids.size()]);
			}
		}
		return providerVolumeIds;
	}

	public void setProviderVolumeIds(@Nonnull String... ids) {
		providerVolumeIds = ids;
	}

	@Nullable
	public Volume[] getVolumes() {
		return volumes;
	}

	public void setVolumes(@Nullable Volume[] volumes) {
		this.volumes = volumes;
	}

	public boolean isIoOptimized() {
		return ioOptimized;
	}

	public void setIoOptimized(boolean ioOptimized) {
		this.ioOptimized = ioOptimized;
	}

	public boolean isIpForwardingAllowed() {
		return ipForwardingAllowed;
	}

	public void setIpForwardingAllowed(boolean ipForwardingAllowed) {
		this.ipForwardingAllowed = ipForwardingAllowed;
	}

	public String getProviderRoleId() {
		return providerRoleId;
	}

	public void setProviderRoleId(String roleId) {
		this.providerRoleId = roleId;
	}

	public VmStatus getProviderVmStatus() {
		return providerVmStatus;
	}

	public void setProviderVmStatus(VmStatus vmStatus) {
		this.providerVmStatus = vmStatus;
	}

	public VmStatus getProviderHostStatus() {
		return providerHostStatus;
	}

	public void setProviderHostStatus(VmStatus vmStatus) {
		this.providerHostStatus = vmStatus;
	}

	public void setVisibleScope(VisibleScope visibleScope) {
		this.visibleScope = visibleScope;
	}

	public VisibleScope getVisibleScope() {
		return this.visibleScope;
	}

	public VirtualMachineLifecycle getLifecycle() {
		if (lifecycle == null) {
			lifecycle = VirtualMachineLifecycle.NORMAL;
		}
		return lifecycle;
	}

	public void setLifecycle(VirtualMachineLifecycle lifecycle) {
		this.lifecycle = lifecycle;
	}

	public String getSpotRequestId() {
		return spotRequestId;
	}

	public void setSpotRequestId(String spotRequestId) {
		this.spotRequestId = spotRequestId;
	}

	public String getResourcePoolId() {
		return resourcePoolId;
	}

	public void setResourcePoolId(String resourcePoolId) {
		this.resourcePoolId = resourcePoolId;
	}

	public String getClientRequestToken() {
		return clientRequestToken;
	}

	public void setClientRequestToken(String clientRequestToken) {
		this.clientRequestToken = clientRequestToken;
	}
}
