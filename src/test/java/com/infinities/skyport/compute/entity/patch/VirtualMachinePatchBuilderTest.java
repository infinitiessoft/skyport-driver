package com.infinities.skyport.compute.entity.patch;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.builder.DiffResult;
import org.dasein.cloud.VisibleScope;
import org.dasein.cloud.compute.Architecture;
import org.dasein.cloud.compute.Platform;
import org.dasein.cloud.compute.VirtualMachine;
import org.dasein.cloud.compute.VirtualMachineLifecycle;
import org.dasein.cloud.compute.VmState;
import org.dasein.cloud.compute.VmStatus;
import org.dasein.cloud.compute.Volume;
import org.dasein.cloud.compute.VolumeFormat;
import org.dasein.cloud.compute.VolumeState;
import org.dasein.cloud.compute.VolumeType;
import org.dasein.cloud.network.RawAddress;
import org.dasein.util.uom.storage.Gigabyte;
import org.dasein.util.uom.storage.Storage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VirtualMachinePatchBuilderTest {

	private VirtualMachinePatchBuilder builder;


	@Before
	public void setUp() throws Exception {
		builder = new VirtualMachinePatchBuilder();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDiff() {
		VirtualMachine old = new VirtualMachine();
		old.setAffinityGroupId("affinityGroupId");
		old.setArchitecture(Architecture.I32);
		old.setClientRequestToken("clientRequestToken");
		old.setClonable(false);
		old.setCreationTimestamp(0);
		old.setCurrentState(VmState.ERROR);
		old.setDescription("description");
		old.setImagable(false);
		old.setIoOptimized(false);
		old.setIpForwardingAllowed(false);
		old.setLabels(new String[] { "label" });
		old.setLastBootTimestamp(0);
		old.setLastPauseTimestamp(0);
		old.setLifecycle(VirtualMachineLifecycle.NORMAL);
		old.setName("name");
		old.setPausable(false);
		old.setPersistent(false);
		old.setPlatform(Platform.CENT_OS);
		old.setPrivateAddresses(new RawAddress("0.0.0.0"));
		old.setPrivateDnsAddress("old.private.dns");
		old.setProductId("productId");
		old.setProviderAssignedIpAddressId("providerAssignedIpAddressId");
		old.setProviderDataCenterId("providerDataCenterId");
		old.setProviderFirewallIds(new String[] { "providerFirewallid" });
		old.setProviderHostStatus(VmStatus.IMPAIRED);
		old.setProviderKernelImageId("providerKernelImageId");
		old.setProviderKeypairId("providerKeypairId");
		old.setProviderMachineImageId("providerMachineImageId");
		old.setProviderNetworkInterfaceIds(new String[] { "providerNetworkInterfaceId" });
		old.setProviderOwnerId("providerOwnerId");
		old.setProviderRamdiskImageId("providerRamdiskImageId");
		old.setProviderRegionId("providerRegionId");
		old.setProviderRoleId("roleId");
		old.setProviderShellKeyIds("keyIds");
		old.setProviderSubnetId("providerSubnetId");
		old.setProviderVirtualMachineId("providerVirtualMachineId");
		old.setProviderVlanId("providerVlanId");
		old.setProviderVmStatus(VmStatus.IMPAIRED);
		old.setProviderVolumeIds("id");
		old.setPublicAddresses(new RawAddress("0.0.0.0"));
		old.setPublicDnsAddress("old.public.dns");
		old.setRebootable(false);
		old.setResourcePoolId("resourcePoolId");
		old.setRootPassword("rootPassword");
		old.setRootUser("rootUser");
		old.setSpotRequestId("spotRequestId");
		old.setStateReasonMessage("stateReasonMessage");
		old.setTag("key", "value");
		old.setTerminationTimestamp(0);
		old.setVisibleScope(VisibleScope.ACCOUNT_DATACENTER);
		Volume volume = new Volume();
		volume.setCreationTimestamp(0);
		volume.setCurrentState(VolumeState.AVAILABLE);
		volume.setDeleteOnVirtualMachineTermination(false);
		volume.setDescription("description");
		volume.setDeviceId("deviceId");
		volume.setFormat(VolumeFormat.BLOCK);
		volume.setGuestOperatingSystem(Platform.CENT_OS);
		volume.setIops(0);
		volume.setMediaLink("mediaLink");
		volume.setName("name");
		volume.setProviderDataCenterId("dataCenterId");
		volume.setProviderProductId("providerProductId");
		volume.setProviderRegionId("regionId");
		volume.setProviderSnapshotId("snapshotId");
		volume.setProviderVirtualMachineId("serverId");
		volume.setProviderVlanId("providerVlanId");
		volume.setProviderVolumeId("providerVolumeId");
		volume.setRootVolume(false);
		volume.setSize(new Storage<Gigabyte>(5, new Gigabyte()));
		volume.setTag("key", "value");
		volume.setType(VolumeType.HDD);
		old.setVolumes(new Volume[] { volume });

		VirtualMachine updated = new VirtualMachine();
		updated.setAffinityGroupId("affinityGroupId1");
		updated.setArchitecture(Architecture.I64);
		updated.setClientRequestToken("clientRequestToken1");
		updated.setClonable(true);
		updated.setCreationTimestamp(1);
		updated.setCurrentState(VmState.PAUSED);
		updated.setDescription("description1");
		updated.setImagable(true);
		updated.setIoOptimized(true);
		updated.setIpForwardingAllowed(true);
		updated.setLabels(new String[] { "label1" });
		updated.setLastBootTimestamp(1);
		updated.setLastPauseTimestamp(1);
		updated.setLifecycle(VirtualMachineLifecycle.SPOT);
		updated.setName("name1");
		updated.setPausable(true);
		updated.setPersistent(true);
		updated.setPlatform(Platform.COREOS);
		updated.setPrivateAddresses(new RawAddress("0.0.0.1"));
		updated.setPrivateDnsAddress("old.private.dns1");
		updated.setProductId("productId1");
		updated.setProviderAssignedIpAddressId("providerAssignedIpAddressId1");
		updated.setProviderDataCenterId("providerDataCenterId1");
		updated.setProviderFirewallIds(new String[] { "providerFirewallid1" });
		updated.setProviderHostStatus(VmStatus.INSUFFICIENT_DATA);
		updated.setProviderKernelImageId("providerKernelImageId1");
		updated.setProviderKeypairId("providerKeypairId1");
		updated.setProviderMachineImageId("providerMachineImageId1");
		updated.setProviderNetworkInterfaceIds(new String[] { "providerNetworkInterfaceId1" });
		updated.setProviderOwnerId("providerOwnerId1");
		updated.setProviderRamdiskImageId("providerRamdiskImageId1");
		updated.setProviderRegionId("providerRegionId1");
		updated.setProviderRoleId("roleId1");
		updated.setProviderShellKeyIds("keyIds1");
		updated.setProviderSubnetId("providerSubnetId1");
		updated.setProviderVirtualMachineId("providerVirtualMachineId1");
		updated.setProviderVlanId("providerVlanId1");
		updated.setProviderVmStatus(VmStatus.INSUFFICIENT_DATA);
		updated.setProviderVolumeIds("id1");
		updated.setPublicAddresses(new RawAddress("0.0.0.1"));
		updated.setPublicDnsAddress("old.public.dns1");
		updated.setRebootable(true);
		updated.setResourcePoolId("resourcePoolId1");
		updated.setRootPassword("rootPassword1");
		updated.setRootUser("rootUser1");
		updated.setSpotRequestId("spotRequestId1");
		updated.setStateReasonMessage("stateReasonMessage1");
		updated.setTag("key1", "value1");
		updated.setTerminationTimestamp(1);
		updated.setVisibleScope(VisibleScope.ACCOUNT_GLOBAL);
		Volume updatedVolume = new Volume();
		updatedVolume.setCreationTimestamp(1);
		updatedVolume.setCurrentState(VolumeState.DELETED);
		updatedVolume.setDeleteOnVirtualMachineTermination(true);
		updatedVolume.setDescription("description1");
		updatedVolume.setDeviceId("deviceId1");
		updatedVolume.setFormat(VolumeFormat.NFS);
		updatedVolume.setGuestOperatingSystem(Platform.COREOS);
		updatedVolume.setIops(1);
		updatedVolume.setMediaLink("mediaLink1");
		updatedVolume.setName("name1");
		updatedVolume.setProviderDataCenterId("dataCenterId1");
		updatedVolume.setProviderProductId("providerProductId1");
		updatedVolume.setProviderRegionId("regionId1");
		updatedVolume.setProviderSnapshotId("snapshotId1");
		updatedVolume.setProviderVirtualMachineId("serverId1");
		updatedVolume.setProviderVlanId("providerVlanId1");
		updatedVolume.setProviderVolumeId("providerVolumeId1");
		updatedVolume.setRootVolume(true);
		updatedVolume.setSize(new Storage<Gigabyte>(6, new Gigabyte()));
		updatedVolume.setTag("key1", "value1");
		updatedVolume.setType(VolumeType.SSD);
		updated.setVolumes(new Volume[] { updatedVolume });

		DiffResult diffResult = builder.diff(old, updated);
		// ProviderVolumeIds cannot be got directly
		assertEquals(50, diffResult.getNumberOfDiffs());
	}
}
