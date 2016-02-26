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

public class Host implements Serializable {

	private static final long serialVersionUID = -9043785446229477796L;

	private boolean active;
	private String name;
	private String dataCenterId;
	private String providerHostId;
	private boolean compute = true;
	private boolean storage = true;


	/**
	 * Constructs an empty host object, only useful in marshalling and
	 * unmarshalling.
	 */
	public Host() {
	}

	/**
	 * Constructs a new host object from the specified state values.
	 * 
	 * @param providerHostId
	 *            the provider identifier for the host
	 * @param name
	 *            the name of the data center
	 * @param dataCenterId
	 *            the provider identifier for the data center
	 * @param active
	 *            whether or not the data center is currently in use with the
	 *            provider
	 * @param available
	 *            whether or not the data center is currently up and operating
	 *            normally
	 */
	public Host(String providerHostId, String name, String dataCenterId, boolean active, boolean available) {
		this.dataCenterId = dataCenterId;
		this.providerHostId = providerHostId;
		this.name = name;
		this.active = active;
		this.compute = true;
		this.storage = true;
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
		result = prime * result + ((providerHostId == null) ? 0 : providerHostId.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Host other = (Host) obj;
		if (providerHostId == null) {
			if (other.providerHostId != null) {
				return false;
			}
		} else if (!providerHostId.equals(other.providerHostId)) {
			return false;
		}
		return true;
	}

	/**
	 * A (hopefully) user-friendly name for the data center as known by the
	 * provider. If the provider does not support meta-data, this value should
	 * be the same as the data center ID.
	 * 
	 * @return the user-friendly name for the data center
	 */
	public String getName() {
		return name;
	}

	/**
	 * The unique ID as understood by the provider for representing this data
	 * center.
	 * 
	 * @return the provider's unique identifier for this data center
	 */
	public String getDataCenterId() {
		return dataCenterId;
	}

	/**
	 * @return the provider's unique identifier for host
	 */
	public String getProviderHostId() {
		return providerHostId;
	}

	/**
	 * A data center is considered to be active if it <em>should be</em>
	 * available. In other words, this value will be <code>false</code> only for
	 * discontinued data centers or for new data centers not quite released for
	 * production.
	 * 
	 * @return <code>true</code> if this data center should be operational
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Used only for marshalling and not to be used programmatically.
	 * 
	 * @param active
	 *            whether or not the marshalled data center is active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Used only for marshalling and not to be used programmatically.
	 * 
	 * @param name
	 *            the name of the marshalled data center
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Used only for marshalling and not to be used programmatically.
	 * 
	 * @param id
	 *            the unique ID of the marshalled data center
	 */
	public void setDataCenterId(String id) {
		dataCenterId = id;
	}

	/**
	 * Used only for marshalling and not to be used programmatically.
	 * 
	 * @param providerHostId
	 *            the unique ID of the host in which the marshalled data center
	 *            is located
	 */
	public void setProviderHostId(String providerHostId) {
		this.providerHostId = providerHostId;
	}

	@Override
	public String toString() {
		return name;
	}

	/**
	 * Indicates whether the data center supports compute operations
	 * 
	 * @return true if the data center supports compute
	 */
	public boolean isCompute() {
		return compute;
	}

	/**
	 * Indicates whether the data center supports compute operations
	 * 
	 * @param compute
	 *            true if the data center supports compute
	 */
	public void setCompute(boolean compute) {
		this.compute = compute;
	}

	/**
	 * Indicates whether the data center supports storage operations
	 * 
	 * @return true if the data center supports storage
	 */
	public boolean isStorage() {
		return storage;
	}

	/**
	 * Indicates whether the data center supports storage operations
	 * 
	 * @param storage
	 *            true if the data center supports storage
	 */
	public void setStorage(boolean storage) {
		this.storage = storage;
	}
}
