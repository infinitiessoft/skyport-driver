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
package com.infinities.skyport.network;

import javax.annotation.Nullable;

import org.dasein.cloud.network.DNSSupport;
import org.dasein.cloud.network.FirewallSupport;
import org.dasein.cloud.network.IpAddressSupport;
import org.dasein.cloud.network.LoadBalancerSupport;
import org.dasein.cloud.network.NetworkFirewallSupport;
import org.dasein.cloud.network.VpnSupport;

/**
 * @author pohsun
 *
 */
public interface SkyportNetworkServices {

	@Nullable
	DNSSupport getDnsSupport();

	@Nullable
	FirewallSupport getFirewallSupport();

	@Nullable
	IpAddressSupport getIpAddressSupport();

	@Nullable
	LoadBalancerSupport getLoadBalancerSupport();

	@Nullable
	NetworkFirewallSupport getNetworkFirewallSupport();

	@Nullable
	SkyportVLANSupport getSkyportVlanSupport();

	@Nullable
	VpnSupport getVpnSupport();

	boolean hasDnsSupport();

	boolean hasFirewallSupport();

	boolean hasIpAddressSupport();

	boolean hasLoadBalancerSupport();

	boolean hasNetworkFirewallSupport();

	boolean hasVlanSupport();

	boolean hasVpnSupport();
}
