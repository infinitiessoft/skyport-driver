//package com.infinities.skyport.compute.entity;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.TreeSet;
//import java.util.concurrent.Callable;
//
//import javax.annotation.Nonnull;
//import javax.annotation.Nullable;
//
//import org.dasein.cloud.CloudException;
//import org.dasein.cloud.CloudProvider;
//import org.dasein.cloud.InternalException;
//import org.dasein.cloud.OperationNotSupportedException;
//import org.dasein.cloud.Tag;
//import org.dasein.cloud.VisibleScope;
//import org.dasein.cloud.compute.Architecture;
//import org.dasein.cloud.compute.ComputeServices;
//import org.dasein.cloud.compute.Platform;
//import org.dasein.cloud.compute.VirtualMachineLifecycle;
//import org.dasein.cloud.compute.VmState;
//import org.dasein.cloud.compute.VmStatus;
//import org.dasein.cloud.compute.Volume;
//import org.dasein.cloud.compute.VolumeFilterOptions;
//import org.dasein.cloud.compute.VolumeSupport;
//import org.dasein.cloud.network.RawAddress;
//
//public class Instance implements IVirtualMachine {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private String affinityGroupId;
//	private Architecture architecture;
//	private boolean clonable;
//	private long creationTimestamp;
//	private VmState currentState;
//	private Map<String, String> tags;
//	private String[] labels;
//	private String description;
//	private boolean imagable;
//	private long lastBootTimestamp;
//	private long lastPauseTimestamp;
//	private String name;
//	private boolean pausable;
//	private boolean persistent;
//	private Platform platform;
//	private String privateDnsAddress;
//	private RawAddress[] privateIpAddresses;
//	private String productId;
//	private String providerAssignedIpAddressId;
//	private String providerDataCenterId;
//	private String providerKernelImageId;
//	private String providerMachineImageId;
//	private String providerOwnerId;
//	private String providerRamdiskImageId;
//	private String providerRegionId;
//	private String[] providerShellKeyIds;
//	private String providerSubnetId;
//	private String providerVirtualMachineId;
//	private String[] providerNetworkInterfaceIds;
//	private String providerVlanId;
//	private String providerKeypairId;
//	private String[] providerFirewallIds;
//	private String[] providerVolumeIds;
//	private String publicDnsAddress;
//	private RawAddress[] publicIpAddresses;
//	private boolean rebootable;
//	private String rootPassword;
//	private String rootUser;
//	private String stateReasonMessage;
//	private long terminationTimestamp;
//	private Volume[] volumes;
//	private boolean ioOptimized;
//	private boolean ipForwardingAllowed;
//	private String providerRoleId;
//	private VmStatus providerHostStatus;
//	private VmStatus providerVmStatus;
//	private String virtualMachineGroup;
//	private VisibleScope visibleScope;
//	private VirtualMachineLifecycle lifecycle;
//	private String spotRequestId; // TODO - add filtering by, add setter/getter
//	private String resourcePoolId;
//	private String clientRequestToken;
//
//	private String configName;
//	private String configId;
//
//
//	public Instance() {
//	}
//
//	public Instance(Instance virtualMachine, String configName, String configId) {
//		this.affinityGroupId = virtualMachine.getAffinityGroupId();
//		this.architecture = virtualMachine.getArchitecture();
//		this.clonable = virtualMachine.isClonable();
//		this.creationTimestamp = virtualMachine.getCreationTimestamp();
//		this.currentState = virtualMachine.getCurrentState();
//		this.tags = virtualMachine.getTags();
//		this.labels = virtualMachine.getLabels();
//		this.description = virtualMachine.getDescription();
//		this.imagable = virtualMachine.isImagable();
//		this.lastBootTimestamp = virtualMachine.getLastBootTimestamp();
//		this.lastPauseTimestamp = virtualMachine.getLastPauseTimestamp();
//		this.name = virtualMachine.getName();
//		this.pausable = virtualMachine.isPausable();
//		this.persistent = virtualMachine.isPersistent();
//		this.platform = virtualMachine.getPlatform();
//		this.privateDnsAddress = virtualMachine.getPrivateDnsAddress();
//		this.privateIpAddresses = virtualMachine.getPrivateIpAddresses();
//		this.productId = virtualMachine.getProductId();
//		this.providerAssignedIpAddressId = virtualMachine.getProviderAssignedIpAddressId();
//		this.providerDataCenterId = virtualMachine.getProviderDataCenterId();
//		this.providerKernelImageId = virtualMachine.getProviderKernelImageId();
//		this.providerMachineImageId = virtualMachine.getProviderMachineImageId();
//		this.providerOwnerId = virtualMachine.getProviderOwnerId();
//		this.providerRamdiskImageId = virtualMachine.getProviderRamdiskImageId();
//		this.providerRegionId = virtualMachine.getProviderRegionId();
//		this.providerShellKeyIds = virtualMachine.getProviderShellKeyIds();
//		this.providerSubnetId = virtualMachine.getProviderSubnetId();
//		this.providerVirtualMachineId = virtualMachine.getProviderVirtualMachineId();
//		this.providerNetworkInterfaceIds = virtualMachine.getProviderNetworkInterfaceIds();
//		this.providerVlanId = virtualMachine.getProviderVlanId();
//		this.providerKeypairId = virtualMachine.getProviderKeypairId();
//		this.providerFirewallIds = virtualMachine.getProviderFirewallIds();
//		this.providerVolumeIds = virtualMachine.getProviderV;
//		this.publicDnsAddress = virtualMachine.getPublicDnsAddress();
//		this.publicIpAddresses = virtualMachine.getPublicIpAddresses();
//		this.rebootable = virtualMachine.isRebootable();
//		this.rootPassword = virtualMachine.getRootPassword();
//		this.rootUser = virtualMachine.getRootUser();
//		this.stateReasonMessage = virtualMachine.getStateReasonMessage();
//		this.terminationTimestamp = virtualMachine.getTerminationTimestamp();
//		this.volumes = virtualMachine.getVolumes();
//		this.ioOptimized = virtualMachine.isIoOptimized();
//		this.ipForwardingAllowed = virtualMachine.isIpForwardingAllowed();
//		this.providerRoleId = virtualMachine.getProviderRoleId();
//		this.providerHostStatus = virtualMachine.getProviderHostStatus();
//		this.providerVmStatus = virtualMachine.getProviderVmStatus();
//		this.virtualMachineGroup = virtualMachine.getVirtualMachineGroup();
//		this.visibleScope = virtualMachine.getVisibleScope();
//		this.lifecycle = virtualMachine.getLifecycle();
//		this.spotRequestId = virtualMachine.getSpotRequestId(); // TODO - add
//																// filtering by,
//																// add
//																// setter/getter
//		this.resourcePoolId = virtualMachine.getResourcePoolId();
//		this.clientRequestToken = virtualMachine.getClientRequestToken();
//
//		this.configName = configName;
//		this.configId = configId;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((configId == null) ? 0 : configId.hashCode());
//		result = prime * result + ((providerMachineImageId == null) ? 0 : providerMachineImageId.hashCode());
//		result = prime * result + ((providerRegionId == null) ? 0 : providerRegionId.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Instance other = (Instance) obj;
//		if (configId == null) {
//			if (other.configId != null)
//				return false;
//		} else if (!configId.equals(other.configId))
//			return false;
//		if (providerMachineImageId == null) {
//			if (other.providerMachineImageId != null)
//				return false;
//		} else if (!providerMachineImageId.equals(other.providerMachineImageId))
//			return false;
//		if (providerRegionId == null) {
//			if (other.providerRegionId != null)
//				return false;
//		} else if (!providerRegionId.equals(other.providerRegionId))
//			return false;
//		return true;
//	}
//
//	public void addTag(Tag t) {
//		addTag(t.getKey(), t.getValue());
//	}
//
//	public void addTag(String key, String value) {
//		getTags().put(key, value);
//	}
//
//
//	private transient volatile Callable<String> passwordCallback;
//
//
//	public void setPasswordCallback(Callable<String> callback) {
//		this.passwordCallback = callback;
//	}
//
//	public void setRootPassword(String rootPassword) {
//		this.rootPassword = rootPassword;
//	}
//
//	@Override
//	public String getRootPassword() {
//		String pw;
//
//		synchronized (this) {
//			pw = rootPassword;
//		}
//		if (pw != null) {
//			return pw;
//		}
//		if (passwordCallback != null) {
//			pw = fetchPassword();
//		}
//		return pw;
//	}
//
//	public String getRootPassword(long timeoutInMilliseconds) throws InterruptedException {
//		long timeout = System.currentTimeMillis() + timeoutInMilliseconds;
//		String pw = getRootPassword();
//		boolean hasCallback;
//
//		synchronized (this) {
//			hasCallback = (passwordCallback != null);
//		}
//		if (hasCallback) {
//			while (pw == null) {
//				if (timeout <= System.currentTimeMillis()) {
//					throw new InterruptedException("System timed out waiting for a password to become available.");
//				}
//				try {
//					Thread.sleep(15000L);
//				} catch (InterruptedException ignore) {
//				}
//				pw = getRootPassword();
//			}
//		}
//		return pw;
//	}
//
//	public String fetchPassword() {
//		String pw;
//
//		synchronized (this) {
//			pw = rootPassword;
//		}
//		if (pw != null) {
//			return pw;
//		}
//		if (passwordCallback == null) {
//			return null;
//		}
//		try {
//			pw = passwordCallback.call();
//			if (pw != null) {
//				synchronized (this) {
//					rootPassword = pw;
//				}
//			}
//			return rootPassword;
//		} catch (Exception e) {
//			return null;
//		}
//	}
//
//	@Override
//	public String toString() {
//		return name + " [" + providerVirtualMachineId + "]";
//	}
//
//	@Override
//	public String getAffinityGroupId() {
//		return affinityGroupId;
//	}
//
//	public void setAffinityGroupId(String affinityGroupId) {
//		this.affinityGroupId = affinityGroupId;
//	}
//
//	@Override
//	public Architecture getArchitecture() {
//		return architecture;
//	}
//
//	public void setArchitecture(Architecture architecture) {
//		this.architecture = architecture;
//	}
//
//	@Override
//	public boolean isClonable() {
//		return clonable;
//	}
//
//	public void setClonable(boolean clonable) {
//		this.clonable = clonable;
//	}
//
//	@Override
//	public long getCreationTimestamp() {
//		return creationTimestamp;
//	}
//
//	public void setCreationTimestamp(long creationTimestamp) {
//		this.creationTimestamp = creationTimestamp;
//	}
//
//	@Override
//	public VmState getCurrentState() {
//		return currentState;
//	}
//
//	public void setCurrentState(VmState currentState) {
//		this.currentState = currentState;
//	}
//
//	@Override
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	@Override
//	public boolean isImagable() {
//		return imagable;
//	}
//
//	public void setImagable(boolean imagable) {
//		this.imagable = imagable;
//	}
//
//	@Override
//	public long getLastBootTimestamp() {
//		return lastBootTimestamp;
//	}
//
//	public void setLastBootTimestamp(long lastBootTimestamp) {
//		this.lastBootTimestamp = lastBootTimestamp;
//	}
//
//	@Override
//	public long getLastPauseTimestamp() {
//		return lastPauseTimestamp;
//	}
//
//	public void setLastPauseTimestamp(long lastPauseTimestamp) {
//		this.lastPauseTimestamp = lastPauseTimestamp;
//	}
//
//	@Override
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	@Override
//	public boolean isPausable() {
//		return pausable;
//	}
//
//	public void setPausable(boolean pausable) {
//		this.pausable = pausable;
//	}
//
//	@Override
//	public boolean isPersistent() {
//		return persistent;
//	}
//
//	public void setPersistent(boolean persistent) {
//		this.persistent = persistent;
//	}
//
//	@Override
//	public Platform getPlatform() {
//		return platform;
//	}
//
//	public void setPlatform(Platform platform) {
//		this.platform = platform;
//	}
//
//	@Override
//	public String getPrivateDnsAddress() {
//		return privateDnsAddress;
//	}
//
//	public void setPrivateDnsAddress(String privateDnsAddress) {
//		this.privateDnsAddress = privateDnsAddress;
//	}
//
//	@Override
//	public @Nonnull RawAddress[] getPrivateAddresses() {
//		return (privateIpAddresses == null ? new RawAddress[0] : privateIpAddresses);
//	}
//
//	public void setPrivateAddresses(@Nonnull RawAddress... addresses) {
//		privateIpAddresses = addresses;
//	}
//
//	@Override
//	public String getProviderAssignedIpAddressId() {
//		return providerAssignedIpAddressId;
//	}
//
//	public void setProviderAssignedIpAddressId(String providerAssignedIpAddressId) {
//		this.providerAssignedIpAddressId = providerAssignedIpAddressId;
//	}
//
//	@Override
//	public String getProviderDataCenterId() {
//		return providerDataCenterId;
//	}
//
//	public void setProviderDataCenterId(String providerDataCenterId) {
//		this.providerDataCenterId = providerDataCenterId;
//	}
//
//	@Override
//	public String getProviderMachineImageId() {
//		return providerMachineImageId;
//	}
//
//	public void setProviderMachineImageId(String providerMachineImageId) {
//		this.providerMachineImageId = providerMachineImageId;
//	}
//
//	@Override
//	public String getProviderOwnerId() {
//		return providerOwnerId;
//	}
//
//	public void setProviderOwnerId(String providerOwnerId) {
//		this.providerOwnerId = providerOwnerId;
//	}
//
//	@Override
//	public String getProviderRegionId() {
//		return providerRegionId;
//	}
//
//	public void setProviderRegionId(String providerRegionId) {
//		this.providerRegionId = providerRegionId;
//	}
//
//	@Override
//	public String getProviderVirtualMachineId() {
//		return providerVirtualMachineId;
//	}
//
//	public void setProviderVirtualMachineId(String providerVirtualMachineId) {
//		this.providerVirtualMachineId = providerVirtualMachineId;
//	}
//
//	@Override
//	public String getPublicDnsAddress() {
//		return publicDnsAddress;
//	}
//
//	public void setPublicDnsAddress(String publicDnsAddress) {
//		this.publicDnsAddress = publicDnsAddress;
//	}
//
//	@Override
//	public @Nonnull RawAddress[] getPublicAddresses() {
//		return (publicIpAddresses == null ? new RawAddress[0] : publicIpAddresses);
//	}
//
//	/**
//	 * Creates an informal association under a group name for the launched VM
//	 * with other virtual machines in the system. The underlying cloud may
//	 * interpret this in any number of ways.
//	 *
//	 * @return the virtual machine group association
//	 */
//	@Override
//	public @Nullable String getVirtualMachineGroup() {
//		return virtualMachineGroup;
//	}
//
//	public void setPublicAddresses(@Nonnull RawAddress... addresses) {
//		publicIpAddresses = addresses;
//	}
//
//	@Override
//	public boolean isRebootable() {
//		return rebootable;
//	}
//
//	public void setRebootable(boolean rebootable) {
//		this.rebootable = rebootable;
//	}
//
//	@Override
//	public String getRootUser() {
//		return rootUser;
//	}
//
//	public void setRootUser(String rootUser) {
//		this.rootUser = rootUser;
//	}
//
//	@Override
//	public String getStateReasonMessage() {
//		return stateReasonMessage;
//	}
//
//	public void setStateReasonMessage(String stateReasonMessage) {
//		this.stateReasonMessage = stateReasonMessage;
//	}
//
//	@Override
//	public long getTerminationTimestamp() {
//		return terminationTimestamp;
//	}
//
//	public void setTerminationTimestamp(long terminationTimestamp) {
//		this.terminationTimestamp = terminationTimestamp;
//	}
//
//	@Override
//	public Callable<String> getPasswordCallback() {
//		return passwordCallback;
//	}
//
//	public void setProductId(String productId) {
//		this.productId = productId;
//	}
//
//	@Override
//	public String getProductId() {
//		return productId;
//	}
//
//	public void setLabels(String[] labels) {
//		this.labels = labels;
//	}
//
//	@Override
//	public String[] getLabels() {
//		return (labels == null ? new String[0] : labels);
//	}
//
//	public Object getTag(String tag) {
//		return getTags().get(tag);
//	}
//
//	@Override
//	public synchronized @Nonnull Map<String, String> getTags() {
//		if (tags == null) {
//			tags = new HashMap<String, String>();
//		}
//		return tags;
//	}
//
//	public void setTag(@Nonnull String key, @Nonnull String value) {
//		if (tags == null) {
//			tags = new HashMap<String, String>();
//		}
//		tags.put(key, value);
//	}
//
//	public synchronized void setTags(Map<String, String> properties) {
//		getTags().clear();
//		getTags().putAll(properties);
//	}
//
//	public void setProviderSubnetId(String providerSubnetId) {
//		this.providerSubnetId = providerSubnetId;
//	}
//
//	@Override
//	public String getProviderSubnetId() {
//		return providerSubnetId;
//	}
//
//	public void setProviderVlanId(String providerVlanId) {
//		this.providerVlanId = providerVlanId;
//	}
//
//	@Override
//	public String getProviderVlanId() {
//		return providerVlanId;
//	}
//
//	@Override
//	public String getProviderKeypairId() {
//		return providerKeypairId;
//	}
//
//	public void setProviderKeypairId(String providerKeypairId) {
//		this.providerKeypairId = providerKeypairId;
//	}
//
//	@Override
//	public String[] getProviderFirewallIds() {
//		return (providerFirewallIds == null ? new String[0] : providerFirewallIds);
//	}
//
//	public void setProviderFirewallIds(String[] providerFirewallIds) {
//		this.providerFirewallIds = providerFirewallIds;
//	}
//
//	@Override
//	public String[] getProviderNetworkInterfaceIds() {
//		return (providerNetworkInterfaceIds == null ? new String[0] : providerNetworkInterfaceIds);
//	}
//
//	public void setProviderNetworkInterfaceIds(String[] providerNetworkInterfaceIds) {
//		this.providerNetworkInterfaceIds = providerNetworkInterfaceIds;
//	}
//
//	@Override
//	public @Nullable String getProviderKernelImageId() {
//		return providerKernelImageId;
//	}
//
//	public void setProviderKernelImageId(@Nullable String providerKernelImageId) {
//		this.providerKernelImageId = providerKernelImageId;
//	}
//
//	@Override
//	public @Nullable String getProviderRamdiskImageId() {
//		return providerRamdiskImageId;
//	}
//
//	public void setProviderRamdiskImageId(@Nullable String providerRamdiskImageId) {
//		this.providerRamdiskImageId = providerRamdiskImageId;
//	}
//
//	public void setProviderShellKeyIds(@Nonnull String... keyIds) {
//		this.providerShellKeyIds = keyIds;
//	}
//
//	@Override
//	public @Nonnull String[] getProviderShellKeyIds() {
//		return (providerShellKeyIds == null ? new String[0] : providerShellKeyIds);
//	}
//
//	public @Nonnull String[] getProviderVolumeIds(@Nonnull CloudProvider provider) throws CloudException, InternalException {
//		if (providerVolumeIds == null) {
//			ComputeServices services = provider.getComputeServices();
//
//			if (services == null) {
//				throw new OperationNotSupportedException("No compute services are defined");
//			}
//			VolumeSupport support = services.getVolumeSupport();
//
//			if (support == null) {
//				providerVolumeIds = new String[0];
//			} else {
//				TreeSet<String> ids = new TreeSet<String>();
//
//				for (Volume v : support.listVolumes(VolumeFilterOptions.getInstance().attachedTo(providerVirtualMachineId))) {
//					ids.add(v.getProviderVolumeId());
//				}
//				providerVolumeIds = ids.toArray(new String[ids.size()]);
//			}
//		}
//		return providerVolumeIds;
//	}
//
//	public void setProviderVolumeIds(@Nonnull String... ids) {
//		providerVolumeIds = ids;
//	}
//
//	@Override
//	public @Nullable Volume[] getVolumes() {
//		return volumes;
//	}
//
//	public void setVolumes(@Nullable Volume[] volumes) {
//		this.volumes = volumes;
//	}
//
//	@Override
//	public boolean isIoOptimized() {
//		return ioOptimized;
//	}
//
//	public void setIoOptimized(boolean ioOptimized) {
//		this.ioOptimized = ioOptimized;
//	}
//
//	@Override
//	public boolean isIpForwardingAllowed() {
//		return ipForwardingAllowed;
//	}
//
//	public void setIpForwardingAllowed(boolean ipForwardingAllowed) {
//		this.ipForwardingAllowed = ipForwardingAllowed;
//	}
//
//	@Override
//	public String getProviderRoleId() {
//		return providerRoleId;
//	}
//
//	public void setProviderRoleId(String roleId) {
//		this.providerRoleId = roleId;
//	}
//
//	@Override
//	public VmStatus getProviderVmStatus() {
//		return providerVmStatus;
//	}
//
//	public void setProviderVmStatus(VmStatus vmStatus) {
//		this.providerVmStatus = vmStatus;
//	}
//
//	@Override
//	public VmStatus getProviderHostStatus() {
//		return providerHostStatus;
//	}
//
//	public void setProviderHostStatus(VmStatus vmStatus) {
//		this.providerHostStatus = vmStatus;
//	}
//
//	public void setVisibleScope(VisibleScope visibleScope) {
//		this.visibleScope = visibleScope;
//	}
//
//	@Override
//	public VisibleScope getVisibleScope() {
//		return this.visibleScope;
//	}
//
//	@Override
//	public VirtualMachineLifecycle getLifecycle() {
//		if (lifecycle == null) {
//			lifecycle = VirtualMachineLifecycle.NORMAL;
//		}
//		return lifecycle;
//	}
//
//	public void setLifecycle(VirtualMachineLifecycle lifecycle) {
//		this.lifecycle = lifecycle;
//	}
//
//	@Override
//	public String getSpotRequestId() {
//		return spotRequestId;
//	}
//
//	public void setSpotRequestId(String spotRequestId) {
//		this.spotRequestId = spotRequestId;
//	}
//
//	@Override
//	public String getResourcePoolId() {
//		return resourcePoolId;
//	}
//
//	public void setResourcePoolId(String resourcePoolId) {
//		this.resourcePoolId = resourcePoolId;
//	}
//
//	@Override
//	public String getClientRequestToken() {
//		return clientRequestToken;
//	}
//
//	public void setClientRequestToken(String clientRequestToken) {
//		this.clientRequestToken = clientRequestToken;
//	}
//
//	@Override
//	public String getConfigName() {
//		return configName;
//	}
//
//	public void setConfigName(String configName) {
//		this.configName = configName;
//	}
//
//	@Override
//	public String getConfigId() {
//		return configId;
//	}
//
//	public void setConfigId(String configId) {
//		this.configId = configId;
//	}
//
//}
