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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonView;
import com.infinities.skyport.compute.INetworkAdapter;
import com.infinities.skyport.compute.entity.adapter.IntegerAdapter;
import com.infinities.skyport.view.Views;

@Entity
@Table(name = "NIC", schema = "PUBLIC", catalog = "PUBLIC")
public class NetworkAdapter extends AbstractVirtEntity implements INetworkAdapter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonView(Views.Basic.class)
	private String mac;
	@JsonView(Views.Short.class)
	private String name;
	@JsonView(Views.Basic.class)
	private String ip;
	@JsonView(Views.Basic.class)
	@XmlJavaTypeAdapter(value = IntegerAdapter.class)
	private Integer speed;
	@JsonView(Views.Basic.class)
	@XmlJavaTypeAdapter(value = IntegerAdapter.class)
	private Integer linespeed;
	@JsonView(Views.Basic.class)
	private String state;
	@JsonView(Views.Basic.class)
	private String type;
	@JsonView(Views.Short.class)
	private String nicid;
	@JsonView(Views.Basic.class)
	@XmlJavaTypeAdapter(value = IntegerAdapter.class)
	private Integer vlanid;
	@JsonView(Views.Basic.class)
	private String network;
	@JsonView(Views.Basic.class)
	private String instanceid;
	@JsonView(Views.Basic.class)
	private String instancetype;
	private ComputeObject templateBaseEntity;

	@JsonView(Views.Basic.class)
	@JsonUnwrapped
	private NetworkStatistics statistics = new NetworkStatistics();

	@Transient
	@XmlTransient
	private String vmId;


	@Override
	@Transient
	public NetworkStatistics getStatistics() {
		return statistics;
	}

	public void setStatistics(NetworkStatistics statistics) {
		this.statistics = statistics;
	}

	public NetworkAdapter() {
		super();
	}

	public NetworkAdapter(String desc, String macAddress, String name, Integer speed, Integer lineSpeed, String state,
			String type, String nicId, Integer vlanId, String network, NetworkStatistics statistics) {
		super(desc);
		this.mac = macAddress;
		this.name = name;
		this.speed = speed;
		this.linespeed = lineSpeed;
		this.state = state;
		this.type = type;
		// this.id = id;
		this.nicid = nicId;
		this.vlanid = vlanId;
		this.network = network;
		this.statistics = statistics;
	}

	@Override
	@Column(name = "MAC", length = 25)
	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	@Override
	@Column(name = "NAME", length = 60)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	@Column(name = "SPEED", length = 5)
	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	@Override
	@Column(name = "LINESPEED", length = 5)
	public Integer getLinespeed() {
		return linespeed;
	}

	public void setLinespeed(Integer linespeed) {
		this.linespeed = linespeed;
	}

	@Override
	@Column(name = "STATE", length = 20)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	@Column(name = "TYPE", length = 20)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	@Column(name = "NICID", length = 60)
	public String getNicid() {
		return nicid;
	}

	public void setNicid(String nicid) {
		this.nicid = nicid;
	}

	@Override
	@Column(name = "VLANID", length = 10)
	public Integer getVlanid() {
		return vlanid;
	}

	public void setVlanid(Integer vlanid) {
		this.vlanid = vlanid;
	}

	@Override
	@Column(name = "NETWORK", length = 200)
	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	@Override
	@XmlTransient
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEMPLATEBASEENTITY")
	public ComputeObject getTemplateBaseEntity() {
		return this.templateBaseEntity;
	}

	@XmlTransient
	public void setTemplateBaseEntity(ComputeObject templateBaseEntity) {
		this.templateBaseEntity = templateBaseEntity;

	}

	@Override
	@Column(name = "INSTANCEID", length = 60)
	public String getInstanceid() {
		return this.instanceid;
	}

	public void setInstanceid(String instanceid) {
		this.instanceid = instanceid;
	}

	@Override
	@Column(name = "INSTANCETYPE", length = 10)
	public String getInstancetype() {
		return this.instancetype;
	}

	public void setInstancetype(String instancetype) {
		this.instancetype = instancetype;
	}

	@Override
	@Column(name = "IP", length = 20)
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Transient
	@XmlTransient
	public String getVmId() {
		return vmId;
	}

	@Transient
	@XmlTransient
	public void setVmId(String vmId) {
		this.vmId = vmId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nicid == null) ? 0 : nicid.hashCode());
		result = prime * result + ((templateBaseEntity == null) ? 0 : templateBaseEntity.hashCode());
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
		NetworkAdapter other = (NetworkAdapter) obj;
		if (nicid == null) {
			if (other.nicid != null) {
				return false;
			}
		} else if (!nicid.equals(other.nicid)) {
			return false;
		}
		if (templateBaseEntity == null) {
			if (other.templateBaseEntity != null) {
				return false;
			}
		} else if (!templateBaseEntity.equals(other.templateBaseEntity)) {
			return false;
		}
		return true;
	}

}
