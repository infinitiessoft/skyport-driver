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
package com.infinities.skyport.diff;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.DiffResult;
import org.dasein.cloud.VisibleScope;
import org.dasein.cloud.compute.Architecture;
import org.dasein.cloud.compute.ImageClass;
import org.dasein.cloud.compute.MachineImage;
import org.dasein.cloud.compute.MachineImageFormat;
import org.dasein.cloud.compute.MachineImageState;
import org.dasein.cloud.compute.MachineImageType;
import org.dasein.cloud.compute.MachineImageVolume;
import org.dasein.cloud.compute.Platform;
import org.dasein.cloud.compute.Snapshot;
import org.dasein.cloud.compute.SnapshotState;
import org.dasein.cloud.compute.VirtualMachine;
import org.dasein.cloud.compute.VirtualMachineLifecycle;
import org.dasein.cloud.compute.VirtualMachineProduct;
import org.dasein.cloud.compute.VmState;
import org.dasein.cloud.compute.VmStatus;
import org.dasein.cloud.compute.Volume;
import org.dasein.cloud.compute.VolumeFormat;
import org.dasein.cloud.compute.VolumeProduct;
import org.dasein.cloud.compute.VolumeState;
import org.dasein.cloud.compute.VolumeType;
import org.dasein.cloud.network.RawAddress;
import org.dasein.util.uom.storage.Gigabyte;
import org.dasein.util.uom.storage.Megabyte;
import org.dasein.util.uom.storage.Storage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infinities.skyport.compute.entity.comparator.MachineImageComparator;
import com.infinities.skyport.compute.entity.comparator.SnapshotComparator;
import com.infinities.skyport.compute.entity.comparator.VirtualMachineComparator;
import com.infinities.skyport.compute.entity.comparator.VirtualMachineProductComparator;
import com.infinities.skyport.compute.entity.comparator.VolumeComparator;
import com.infinities.skyport.compute.entity.comparator.VolumeProductComparator;
import com.infinities.skyport.compute.entity.patch.MachineImagePatchBuilder;
import com.infinities.skyport.compute.entity.patch.SnapshotPatchBuilder;
import com.infinities.skyport.compute.entity.patch.VirtualMachinePatchBuilder;
import com.infinities.skyport.compute.entity.patch.VirtualMachineProductPatchBuilder;
import com.infinities.skyport.compute.entity.patch.VolumePatchBuilder;
import com.infinities.skyport.compute.entity.patch.VolumeProductPatchBuilder;

public class PatchUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testApplyNewVirtualMachine() throws Exception {
		VirtualMachine vm = new VirtualMachine();
		vm.setProviderRegionId("");
		vm.setProviderVirtualMachineId("");
		VirtualMachine updated = new VirtualMachine();
		updated.setAffinityGroupId("affinityGroupId");
		updated.setArchitecture(Architecture.I32);
		updated.setClientRequestToken("clientRequestToken");
		updated.setClonable(false);
		updated.setCreationTimestamp(0);
		updated.setCurrentState(VmState.ERROR);
		updated.setDescription("description");
		updated.setImagable(false);
		updated.setIoOptimized(false);
		updated.setIpForwardingAllowed(false);
		updated.setLabels(new String[] { "label" });
		updated.setLastBootTimestamp(0);
		updated.setLastPauseTimestamp(0);
		updated.setLifecycle(VirtualMachineLifecycle.NORMAL);
		updated.setName("name");
		updated.setPausable(false);
		updated.setPersistent(false);
		updated.setPlatform(Platform.CENT_OS);
		updated.setPrivateAddresses(new RawAddress("0.0.0.0"));
		updated.setPrivateDnsAddress("old.private.dns");
		updated.setProductId("productId");
		updated.setProviderAssignedIpAddressId("providerAssignedIpAddressId");
		updated.setProviderDataCenterId("providerDataCenterId");
		updated.setProviderFirewallIds(new String[] { "providerFirewallid" });
		updated.setProviderHostStatus(VmStatus.IMPAIRED);
		updated.setProviderKernelImageId("providerKernelImageId");
		updated.setProviderKeypairId("providerKeypairId");
		updated.setProviderMachineImageId("providerMachineImageId");
		updated.setProviderNetworkInterfaceIds(new String[] { "providerNetworkInterfaceId" });
		updated.setProviderOwnerId("providerOwnerId");
		updated.setProviderRamdiskImageId("providerRamdiskImageId");
		updated.setProviderRegionId("providerRegionId");
		updated.setProviderRoleId("roleId");
		updated.setProviderShellKeyIds("keyIds");
		updated.setProviderSubnetId("providerSubnetId");
		updated.setProviderVirtualMachineId("providerVirtualMachineId");
		updated.setProviderVlanId("providerVlanId");
		updated.setProviderVmStatus(VmStatus.IMPAIRED);
		updated.setProviderVolumeIds("id");
		updated.setPublicAddresses(new RawAddress("0.0.0.0"));
		updated.setPublicDnsAddress("old.public.dns");
		updated.setRebootable(false);
		updated.setResourcePoolId("resourcePoolId");
		updated.setRootPassword("rootPassword");
		updated.setRootUser("rootUser");
		updated.setSpotRequestId("spotRequestId");
		updated.setStateReasonMessage("stateReasonMessage");
		updated.setTag("key", "value");
		updated.setTerminationTimestamp(0);
		updated.setVisibleScope(VisibleScope.ACCOUNT_DATACENTER);
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
		updated.setVolumes(new Volume[] { volume });

		DiffResult diffResult = new VirtualMachinePatchBuilder().diff(vm, updated);
		VirtualMachine destination = new VirtualMachine();
		PatchUtil.apply(diffResult, destination);
		assertEquals(0, new VirtualMachineComparator().compare(updated, destination));
	}

	@Test
	public void testApplyUpdateVirtualMachine() throws Exception {
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

		DiffResult diffResult = new VirtualMachinePatchBuilder().diff(old, updated);
		PatchUtil.apply(diffResult, old);
		assertEquals(0, new VirtualMachineComparator().compare(updated, old));
	}

	@Test
	public void testApplyNewVirtualMachineProduct() throws Exception {
		VirtualMachineProduct vmp = new VirtualMachineProduct();
		vmp.setProviderProductId("");
		VirtualMachineProduct updated = new VirtualMachineProduct();
		updated.setArchitectures(Architecture.I32);
		updated.setCpuCount(0);
		updated.setDataCenterId("dataCenterId");
		updated.setDescription("description");
		updated.setName("name");
		Map<String, String> providerMetadata = new HashMap<String, String>();
		providerMetadata.put("key", "value");
		updated.setProviderMetadata(providerMetadata);
		updated.setProviderProductId("providerProductId");
		updated.setRamSize(new Storage<Megabyte>(1, new Megabyte()));
		updated.setRootVolumeSize(new Storage<Gigabyte>(1, new Gigabyte()));
		updated.setStandardHourlyRate(0);
		updated.setStatusDeprecated();
		updated.setVisibleScope(VisibleScope.ACCOUNT_DATACENTER);

		DiffResult diffResult = new VirtualMachineProductPatchBuilder().diff(vmp, updated);
		VirtualMachineProduct destination = new VirtualMachineProduct();
		PatchUtil.apply(diffResult, destination);
		assertEquals(0, new VirtualMachineProductComparator().compare(updated, destination));
	}

	@Test
	public void testApplyUpdateVirtualMachineProduct() throws Exception {
		VirtualMachineProduct old = new VirtualMachineProduct();
		old.setArchitectures(Architecture.I32);
		old.setCpuCount(0);
		old.setDataCenterId("dataCenterId");
		old.setDescription("description");
		old.setName("name");
		Map<String, String> providerMetadata = new HashMap<String, String>();
		providerMetadata.put("key", "value");
		old.setProviderMetadata(providerMetadata);
		old.setProviderProductId("providerProductId");
		old.setRamSize(new Storage<Megabyte>(1, new Megabyte()));
		old.setRootVolumeSize(new Storage<Gigabyte>(1, new Gigabyte()));
		old.setStandardHourlyRate(0);
		old.setVisibleScope(VisibleScope.ACCOUNT_DATACENTER);

		VirtualMachineProduct updated = new VirtualMachineProduct();
		updated.setArchitectures(Architecture.I64);
		updated.setCpuCount(1);
		updated.setDataCenterId("dataCenterId1");
		updated.setDescription("description1");
		updated.setName("name1");
		Map<String, String> providerMetadata1 = new HashMap<String, String>();
		providerMetadata1.put("key1", "value1");
		updated.setProviderMetadata(providerMetadata1);
		updated.setProviderProductId("providerProductId1");
		updated.setRamSize(new Storage<Megabyte>(2, new Megabyte()));
		updated.setRootVolumeSize(new Storage<Gigabyte>(2, new Gigabyte()));
		updated.setStandardHourlyRate(1);
		updated.setStatusDeprecated();
		updated.setVisibleScope(VisibleScope.ACCOUNT_GLOBAL);

		DiffResult diffResult = new VirtualMachineProductPatchBuilder().diff(old, updated);
		PatchUtil.apply(diffResult, old);
		assertEquals(0, new VirtualMachineProductComparator().compare(updated, old));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testApplyNewMachineImage() throws Exception {
		MachineImage mi = new MachineImage();
		mi.setProviderRegionId("");
		mi.setProviderMachineImageId("");
		mi.setProviderOwnerId("");

		MachineImage updated = new MachineImage();
		updated.setArchitecture(Architecture.I32);
		// updated.setCreationTimestamp(0);
		updated.setCurrentState(MachineImageState.ACTIVE);
		updated.setDescription("description");
		updated.setImageClass(ImageClass.KERNEL);
		updated.associatedWith("kernelImageId");
		updated.setMinimumDiskSizeGb(0);
		updated.setName("name");
		updated.setPlatform(Platform.CENT_OS);
		updated.setProviderMachineImageId("providerMachineImageId");
		updated.setProviderOwnerId("providerOwnerId");
		updated.setProviderRegionId("providerRegionId");
		updated.withSoftware("software");
		updated.withStorageFormat(MachineImageFormat.AWS);
		updated.setTag("key", "value");
		updated.withType(MachineImageType.STORAGE);
		updated.withVisibleScope(VisibleScope.ACCOUNT_DATACENTER);
		Map<String, String> providerMetadata = new HashMap<String, String>();
		providerMetadata.put("key", "value");
		updated.withProviderMetadata(providerMetadata);
		updated.constrainedTo("dataCenterId");
		updated.createdAt(0);
		MachineImageVolume volume = MachineImageVolume.getInstance("deviceName", "snapshotId", 1, "volumeType", 1);
		List<MachineImageVolume> volumes = new ArrayList<MachineImageVolume>();
		volumes.add(volume);
		updated.withVolumes(volumes);

		DiffResult diffResult = new MachineImagePatchBuilder().diff(mi, updated);
		MachineImage destination = new MachineImage();
		PatchUtil.apply(diffResult, destination);
		assertEquals(0, new MachineImageComparator().compare(updated, destination));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testApplyUpdateMachineImage() throws Exception {
		MachineImage old = new MachineImage();
		old.setArchitecture(Architecture.I32);
		// updated.setCreationTimestamp(0);
		old.setCurrentState(MachineImageState.ACTIVE);
		old.setDescription("description");
		old.setImageClass(ImageClass.KERNEL);
		old.associatedWith("kernelImageId");
		old.setMinimumDiskSizeGb(0);
		old.setName("name");
		old.setPlatform(Platform.CENT_OS);
		old.setProviderMachineImageId("providerMachineImageId");
		old.setProviderOwnerId("providerOwnerId");
		old.setProviderRegionId("providerRegionId");
		old.withSoftware("software");
		old.withStorageFormat(MachineImageFormat.AWS);
		old.setTag("key", "value");
		old.withType(MachineImageType.STORAGE);
		old.withVisibleScope(VisibleScope.ACCOUNT_DATACENTER);
		Map<String, String> providerMetadata = new HashMap<String, String>();
		providerMetadata.put("key", "value");
		old.withProviderMetadata(providerMetadata);
		old.constrainedTo("dataCenterId");
		old.createdAt(0);
		MachineImageVolume volume = MachineImageVolume.getInstance("deviceName", "snapshotId", 1, "volumeType", 1);
		List<MachineImageVolume> volumes = new ArrayList<MachineImageVolume>();
		volumes.add(volume);
		old.withVolumes(volumes);

		MachineImage updated = new MachineImage();
		updated.setArchitecture(Architecture.I64);
		// updated.setCreationTimestamp(0);
		updated.setCurrentState(MachineImageState.DELETED);
		updated.setDescription("description1");
		updated.setImageClass(ImageClass.MACHINE);
		updated.associatedWith("kernelImageId1");
		updated.setMinimumDiskSizeGb(1);
		updated.setName("name1");
		updated.setPlatform(Platform.COREOS);
		updated.setProviderMachineImageId("providerMachineImageId1");
		updated.setProviderOwnerId("providerOwnerId1");
		updated.setProviderRegionId("providerRegionId1");
		updated.withSoftware("software1");
		updated.withStorageFormat(MachineImageFormat.NIMBULA);
		updated.setTag("key1", "value1");
		updated.withType(MachineImageType.VOLUME);
		updated.withVisibleScope(VisibleScope.ACCOUNT_GLOBAL);
		Map<String, String> providerMetadata1 = new HashMap<String, String>();
		providerMetadata1.put("key1", "value1");
		updated.withProviderMetadata(providerMetadata1);
		updated.constrainedTo("dataCenterId1");
		updated.createdAt(1);
		MachineImageVolume volume1 = MachineImageVolume.getInstance("deviceName1", "snapshotId1", 2, "volumeType1", 2);
		List<MachineImageVolume> updagedVolumes = new ArrayList<MachineImageVolume>();
		updagedVolumes.add(volume1);
		updated.withVolumes(updagedVolumes);

		DiffResult diffResult = new MachineImagePatchBuilder().diff(old, updated);
		PatchUtil.apply(diffResult, old);
		assertEquals(0, new MachineImageComparator().compare(updated, old));
	}

	@Test
	public void testApplyNewVolume() throws Exception {
		Volume v = new Volume();
		v.setProviderRegionId("");
		v.setProviderVolumeId("");
		Volume updated = new Volume();
		updated.setCreationTimestamp(0);
		updated.setCurrentState(VolumeState.AVAILABLE);
		updated.setDeleteOnVirtualMachineTermination(false);
		updated.setDescription("description");
		updated.setDeviceId("deviceId");
		updated.setFormat(VolumeFormat.BLOCK);
		updated.setGuestOperatingSystem(Platform.CENT_OS);
		updated.setIops(0);
		updated.setMediaLink("mediaLink");
		updated.setName("name");
		updated.setProviderDataCenterId("dataCenterId");
		updated.setProviderProductId("providerProductId");
		updated.setProviderRegionId("regionId");
		updated.setProviderSnapshotId("snapshotId");
		updated.setProviderVirtualMachineId("serverId");
		updated.setProviderVlanId("providerVlanId");
		updated.setProviderVolumeId("providerVolumeId");
		updated.setRootVolume(false);
		updated.setSize(new Storage<Gigabyte>(5, new Gigabyte()));
		updated.setTag("key", "value");
		updated.setType(VolumeType.HDD);

		DiffResult diffResult = new VolumePatchBuilder().diff(v, updated);
		Volume destination = new Volume();
		PatchUtil.apply(diffResult, destination);
		assertEquals(0, new VolumeComparator().compare(updated, destination));
	}

	@Test
	public void testApplyUpdateVolume() throws Exception {
		Volume old = new Volume();
		old.setCreationTimestamp(0);
		old.setCurrentState(VolumeState.AVAILABLE);
		old.setDeleteOnVirtualMachineTermination(false);
		old.setDescription("description");
		old.setDeviceId("deviceId");
		old.setFormat(VolumeFormat.BLOCK);
		old.setGuestOperatingSystem(Platform.CENT_OS);
		old.setIops(0);
		old.setMediaLink("mediaLink");
		old.setName("name");
		old.setProviderDataCenterId("dataCenterId");
		old.setProviderProductId("providerProductId");
		old.setProviderRegionId("regionId");
		old.setProviderSnapshotId("snapshotId");
		old.setProviderVirtualMachineId("serverId");
		old.setProviderVlanId("providerVlanId");
		old.setProviderVolumeId("providerVolumeId");
		old.setRootVolume(false);
		old.setSize(new Storage<Gigabyte>(5, new Gigabyte()));
		old.setTag("key", "value");
		old.setType(VolumeType.HDD);

		Volume updated = new Volume();
		updated.setCreationTimestamp(1);
		updated.setCurrentState(VolumeState.DELETED);
		updated.setDeleteOnVirtualMachineTermination(true);
		updated.setDescription("description1");
		updated.setDeviceId("deviceId1");
		updated.setFormat(VolumeFormat.NFS);
		updated.setGuestOperatingSystem(Platform.COREOS);
		updated.setIops(1);
		updated.setMediaLink("mediaLink1");
		updated.setName("name1");
		updated.setProviderDataCenterId("dataCenterId1");
		updated.setProviderProductId("providerProductId1");
		updated.setProviderRegionId("regionId1");
		updated.setProviderSnapshotId("snapshotId1");
		updated.setProviderVirtualMachineId("serverId1");
		updated.setProviderVlanId("providerVlanId1");
		updated.setProviderVolumeId("providerVolumeId1");
		updated.setRootVolume(true);
		updated.setSize(new Storage<Gigabyte>(6, new Gigabyte()));
		updated.setTag("key1", "value1");
		updated.setType(VolumeType.SSD);

		DiffResult diffResult = new VolumePatchBuilder().diff(old, updated);
		PatchUtil.apply(diffResult, old);
		assertEquals(0, new VolumeComparator().compare(updated, old));
	}

	@Test
	public void testApplyNewVolumeProduct() throws Exception {
		VolumeProduct vp = VolumeProduct.getInstance("id", "name", "description", VolumeType.SSD, new Storage<Gigabyte>(5,
				new Gigabyte()), "currency", 5, 5, new Float(5), new Float(5));
		VolumeProduct updated = VolumeProduct.getInstance("id", "name", "description", VolumeType.SSD,
				new Storage<Gigabyte>(5, new Gigabyte()), "currency", 5, 5, new Float(5), new Float(5));
		updated.withMaxIopsRatio(5);
		updated.withMaxVolumeSize(new Storage<Gigabyte>(100, new Gigabyte()));
		updated.withMinVolumeSize(new Storage<Gigabyte>(2, new Gigabyte()));
		DiffResult diffResult = new VolumeProductPatchBuilder().diff(vp, updated);
		VolumeProduct destination = VolumeProduct.getInstance("id", "name", "description", VolumeType.SSD,
				new Storage<Gigabyte>(5, new Gigabyte()), "currency", 5, 5, new Float(5), new Float(5));
		PatchUtil.apply(diffResult, destination);
		assertEquals(0, new VolumeProductComparator().compare(updated, destination));
	}

	@Test
	public void testApplyUpdatedVolumeProduct() throws Exception {
		VolumeProduct vp = VolumeProduct.getInstance("id", "name", "description", VolumeType.SSD, new Storage<Gigabyte>(5,
				new Gigabyte()), "currency", 5, 5, new Float(5), new Float(5));
		vp.withMaxIopsRatio(1);
		vp.withMaxVolumeSize(new Storage<Gigabyte>(1, new Gigabyte()));
		vp.withMinVolumeSize(new Storage<Gigabyte>(1, new Gigabyte()));
		VolumeProduct updated = VolumeProduct.getInstance("id", "name", "description", VolumeType.SSD,
				new Storage<Gigabyte>(5, new Gigabyte()), "currency", 5, 5, new Float(5), new Float(5));
		updated.withMaxIopsRatio(5);
		updated.withMaxVolumeSize(new Storage<Gigabyte>(100, new Gigabyte()));
		updated.withMinVolumeSize(new Storage<Gigabyte>(2, new Gigabyte()));
		DiffResult diffResult = new VolumeProductPatchBuilder().diff(vp, updated);
		PatchUtil.apply(diffResult, vp);
		assertEquals(0, new VolumeProductComparator().compare(updated, vp));
	}

	@Test
	public void testApplyNewSnapshot() throws Exception {
		Snapshot snapshot = new Snapshot();
		snapshot.setProviderSnapshotId("");
		snapshot.setOwner("");
		snapshot.setRegionId("");
		Snapshot updated = new Snapshot();
		updated.setCurrentState(SnapshotState.AVAILABLE);
		updated.setDescription("description");
		updated.setName("name");
		updated.setOwner("owner");
		updated.setProgress("progress");
		updated.setProviderSnapshotId("providerSnapshotId");
		updated.setRegionId("regionId");
		updated.setSizeInGb(0);
		updated.setSnapshotTimestamp(0);
		updated.setTag("key", "value");
		updated.setVisibleScope(VisibleScope.ACCOUNT_DATACENTER);
		updated.setVolumeId("volumeId");

		DiffResult diffResult = new SnapshotPatchBuilder().diff(snapshot, updated);
		Snapshot destination = new Snapshot();
		PatchUtil.apply(diffResult, destination);
		assertEquals(0, new SnapshotComparator().compare(updated, destination));
	}

	@Test
	public void testApplyUpdateSnapshot() throws Exception {
		Snapshot old = new Snapshot();
		old.setCurrentState(SnapshotState.AVAILABLE);
		old.setDescription("description");
		old.setName("name");
		old.setOwner("owner");
		old.setProgress("progress");
		old.setProviderSnapshotId("providerSnapshotId");
		old.setRegionId("regionId");
		old.setSizeInGb(0);
		old.setSnapshotTimestamp(0);
		old.setTag("key", "value");
		old.setVisibleScope(VisibleScope.ACCOUNT_DATACENTER);
		old.setVolumeId("volumeId");

		Snapshot updated = new Snapshot();
		updated.setCurrentState(SnapshotState.DELETED);
		updated.setDescription("description1");
		updated.setName("name1");
		updated.setOwner("owner1");
		updated.setProgress("progress1");
		updated.setProviderSnapshotId("providerSnapshotId1");
		updated.setRegionId("regionId1");
		updated.setSizeInGb(1);
		updated.setSnapshotTimestamp(1);
		updated.setTag("key1", "value1");
		updated.setVisibleScope(VisibleScope.ACCOUNT_GLOBAL);
		updated.setVolumeId("volumeId1");

		DiffResult diffResult = new SnapshotPatchBuilder().diff(old, updated);
		PatchUtil.apply(diffResult, old);
		assertEquals(0, new SnapshotComparator().compare(updated, old));
	}

}
