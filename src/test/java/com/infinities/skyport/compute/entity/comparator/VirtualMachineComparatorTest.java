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

import static org.junit.Assert.assertEquals;

import org.dasein.cloud.VisibleScope;
import org.dasein.cloud.compute.Architecture;
import org.dasein.cloud.compute.Platform;
import org.dasein.cloud.compute.VirtualMachine;
import org.dasein.cloud.compute.VirtualMachineLifecycle;
import org.dasein.cloud.compute.VmState;
import org.dasein.cloud.compute.VmStatus;
import org.dasein.cloud.network.RawAddress;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class VirtualMachineComparatorTest {
	
	private VirtualMachineComparator comparator = new VirtualMachineComparator();
	private VirtualMachine o1, o2;

	@Before
	public void setUp() throws Exception {
		o1 = new VirtualMachine();
		o2 = new VirtualMachine();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCompare() {
		int result = comparator.compare(o1, o2);
		assertEquals(0, result);
	}
	
	@Test
	public void testCompareProviderVirtualMachineId() {
		o1.setProviderVirtualMachineId("providerVirtualMachineId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareProviderVmStatus() {
		o1.setProviderVmStatus(VmStatus.IMPAIRED);
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareAffinityGroupId() {
		o1.setAffinityGroupId("affinityGroupId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}
	
	@Test
	public void testCompareArchitecture() {
		o1.setArchitecture(Architecture.I32);
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareClientRequestToken() {
		o1.setClientRequestToken("clientRequestToken");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareClonable() {
		o1.setClonable(true);
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}
	
	@Test
	public void testCompareCreationTimestamp() {
		o1.setCreationTimestamp(1);
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@Test
	public void testCompareCurrentState() {
		o1.setCurrentState(VmState.ERROR);
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareDescription() {
		o1.setDescription("description");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareImagable() {
		o1.setImagable(true);
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@Test
	public void testCompareIoOptimized() {
		o1.setIoOptimized(true);
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@Test
	public void testCompareIpForwardingAllowed() {
		o1.setIpForwardingAllowed(true);
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}
	
	@Test
	public void testCompareLastBootTimestamp() {
		o1.setLastBootTimestamp(1);
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@Test
	public void testCompareLastPauseTimestamp() {
		o1.setLastPauseTimestamp(1);
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@Test
	public void testCompareLifecycle() {
		o1.setLifecycle(VirtualMachineLifecycle.NORMAL);
		int result = comparator.compare(o1, o2);
		assertEquals(0, result);
	}

	@Test
	public void testCompareName() {
		o1.setName("name");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testComparePausable() {
		o1.setPausable(true);
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@Test
	public void testComparePersistent() {
		o1.setPersistent(true);
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}
	
	@Test
	public void testComparePlatform() {
		o1.setPlatform(Platform.CENT_OS);
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareProductId() {
		o1.setProductId("productId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareProviderAssignedIpAddressId() {
		o1.setProviderAssignedIpAddressId("providerAssignedIpAddressId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}
	
	@Test
	public void testCompareProviderDataCenterId() {
		o1.setProviderDataCenterId("providerDataCenterId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareProviderHostStatus() {
		o1.setProviderHostStatus(VmStatus.IMPAIRED);
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareProviderKernelImageId() {
		o1.setProviderKernelImageId("providerKernelImageId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}
	
	@Test
	public void testCompareProviderKeypairId() {
		o1.setProviderKeypairId("providerKeypairId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareProviderMachineImageId() {
		o1.setProviderMachineImageId("providerMachineImageId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareProviderOwnerId() {
		o1.setProviderOwnerId("providerOwnerId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}
	
	@Test
	public void testCompareProviderRamdiskImageId() {
		o1.setProviderRamdiskImageId("providerRamdiskImageId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareProviderRegionId() {
		o1.setProviderRegionId("providerRegionId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareProviderRoleId() {
		o1.setProviderRoleId("roleId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}
	
	@Test
	public void testCompareProviderSubnetId() {
		o1.setProviderSubnetId("providerSubnetId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareProviderVlanId() {
		o1.setProviderVlanId("providerVlanId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareRebootable() {
		o1.setRebootable(true);
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}
	
	@Test
	public void testCompareResourcePoolId() {
		o1.setResourcePoolId("resourcePoolId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareRootPassword() {
		o1.setRootPassword("rootPassword");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareRootUser() {
		o1.setRootUser("rootUser");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}
	
	@Test
	public void testCompareSpotRequestId() {
		o1.setSpotRequestId("spotRequestId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareStateReasonMessage() {
		o1.setStateReasonMessage("stateReasonMessage");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareTerminationTimestamp() {
		o1.setTerminationTimestamp(1);
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}
	
	@Test
	public void testCompareVisibleScope() {
		o1.setVisibleScope(VisibleScope.ACCOUNT_DATACENTER);
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareLabels() {
		o1.setLabels(new String[] { "label" });
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@Test
	public void testComparePrivateAddresses() {
		o1.setPrivateAddresses(new RawAddress("0.0.0.0"));
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}
	
	@Test
	public void testComparePrivateDnsAddress() {
		o1.setPrivateDnsAddress("old.private.dns");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareProviderFirewallIds() {
		o1.setProviderFirewallIds(new String[] { "providerFirewallid" });
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@Test
	public void testCompareProviderNetworkInterfaceIds() {
		o1.setProviderNetworkInterfaceIds(new String[] { "providerNetworkInterfaceId" });
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}
	
	@Test
	public void testCompareProviderShellKeyIds() {
		o1.setProviderShellKeyIds("keyIds");
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@Test
	public void testComparePublicAddresses() {
		o1.setPublicAddresses(new RawAddress("0.0.0.0"));
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@Test
	public void testComparePublicDnsAddress() {
		o1.setPublicDnsAddress("old.public.dns");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}
	
	@Test
	public void testCompareTag() {
		o1.setTag("key", "value");
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}
}
