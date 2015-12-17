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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.infinities.skyport.compute.entity.adapter.IntegerAdapter;

@Entity
@Table(name = "HOST", schema = "PUBLIC", catalog = "PUBLIC")
public class Host extends AbstractVirtEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// @JsonProperty("VmCount")
	// private String vmCount;
	// @JsonProperty("VmActive")
	// private String vmActive;
	// @JsonProperty("VmMigrating")
	// private String vmMigrating;
	private String hostid;
	private String ip;
	private String name;
	private String status;
	@XmlJavaTypeAdapter(value = IntegerAdapter.class)
	private Integer port = 0;
	@JsonUnwrapped
	@Transient
	private Statistics statistics = new Statistics();


	public Host() {
		super();
	}

	public Host(String desc, String hostId, String ip, String name, String status, int port, Statistics statistics) {
		super(desc);
		this.hostid = hostId;
		this.ip = ip;
		this.name = name;
		this.status = status;
		this.port = port;
		this.statistics = statistics;
	}

	@Column(name = "HOSTID", length = 150)
	public String getHostid() {
		return hostid;
	}

	public void setHostid(String hostId) {
		this.hostid = hostId;
	}

	@Column(name = "IP", length = 20)
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "NAME", length = 150)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "STATUS", length = 256)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "PORT", length = 5)
	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	@Transient
	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((hostid == null) ? 0 : hostid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Host other = (Host) obj;
		if (hostid == null) {
			if (other.hostid != null) {
				return false;
			}
		} else if (!hostid.equals(other.hostid)) {
			return false;
		}
		return true;
	}

}
