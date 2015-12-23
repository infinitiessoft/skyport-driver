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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.dasein.cloud.network.IPVersion;

/**
 * This is a customized version of org.dasein.cloud.network.RawAddress for add
 * property 'networkName'
 * <p>
 * Created by Pohsun Huang: 12/23/15 10:57 AM
 * </p>
 * 
 * @author Pohsun Huang
 * @version 2015.12 initial version
 * @since 2015.12
 */
public class SkyportRawAddress {

	private String ipAddress;
	private IPVersion version;
	private String vlanName;


	/**
	 * Constructs a new raw addressed based on the specified IP address string
	 * and guesses at the version and vlan name.
	 * 
	 * @param ipAddress
	 *            the IP address string for the address
	 */
	public SkyportRawAddress(@Nonnull String ipAddress, @Nonnull String vlanName) {
		this.ipAddress = ipAddress;
		this.setVlanName(vlanName);
		String[] tmp = ipAddress.split("\\.");

		if (tmp.length == 4) {
			version = IPVersion.IPV4;
		} else {
			version = IPVersion.IPV6;
		}
	}

	/**
	 * Constructs a new raw address based on the specified IP address string,
	 * version and vlan name.
	 * 
	 * @param ipAddress
	 *            the IP address string of the address
	 * @param version
	 *            the IP version associated with the address
	 * @param netowkrName
	 *            the vlan name associated with the address
	 */
	public SkyportRawAddress(@Nonnull String ipAddress, @Nonnull IPVersion version, @Nonnull String vlanName) {
		this.ipAddress = ipAddress;
		this.version = version;
		this.setVlanName(vlanName);
	}

	@Override
	public boolean equals(@Nullable Object other) {
		return other != null
				&& (other == this || other.getClass().equals(getClass())
						&& vlanName.equalsIgnoreCase(((SkyportRawAddress) other).vlanName)
						&& ipAddress.equalsIgnoreCase(((SkyportRawAddress) other).ipAddress));
	}

	/**
	 * @return the IP address string
	 */
	@Nonnull
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * @return the IP version associated with this address
	 */
	@Nonnull
	public IPVersion getVersion() {
		return version;
	}

	@Override
	public int hashCode() {
		return ipAddress.hashCode();
	}

	/**
	 * Indicates whether this IP address is reserved for private address spaces
	 * or likely represents a publicly addressable IP address.
	 * 
	 * @return true if this address is in the publicly addressable address space
	 */
	public boolean isPublicIpAddress() {
		if (getVersion().equals(IPVersion.IPV4)) {
			if (ipAddress.startsWith("10.") || ipAddress.startsWith("192.168") || ipAddress.startsWith("169.254")) {
				return false;
			} else if (ipAddress.startsWith("172.")) {
				String[] parts = ipAddress.split("\\.");

				if (parts.length != 4) {
					return true;
				}
				int x = Integer.parseInt(parts[1]);

				if (x >= 16 && x <= 31) {
					return false;
				}
			}
		} else {
			if (ipAddress.startsWith("fd") || ipAddress.startsWith("fc00:")) {
				return false;
			}
		}
		return true;
	}

	@Override
	@Nonnull
	public String toString() {
		return ipAddress;
	}

	/**
	 * @return the vlanName
	 */
	public String getVlanName() {
		return vlanName;
	}

	/**
	 * @param vlanName
	 *            the vlanName to set
	 */
	public void setVlanName(String vlanName) {
		this.vlanName = vlanName;
	}
}
