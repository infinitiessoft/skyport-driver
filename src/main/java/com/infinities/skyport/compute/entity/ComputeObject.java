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

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonView;
import com.infinities.skyport.compute.IComputeObject;
import com.infinities.skyport.compute.entity.adapter.DiskAdapter;
import com.infinities.skyport.compute.entity.adapter.ISO8601DateAdapter;
import com.infinities.skyport.compute.entity.adapter.IntegerAdapter;
import com.infinities.skyport.compute.entity.adapter.LongAdapter;
import com.infinities.skyport.compute.entity.adapter.NetworkAdapterAdapter;
import com.infinities.skyport.view.Views;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "OBJECTTYPE")
@Table(name = "TEMPLATEBASEENTITY", schema = "PUBLIC", catalog = "PUBLIC"
// , uniqueConstraints = { @UniqueConstraint(columnNames = { "CONFIG",
// "VMID" }) }
)
public class ComputeObject extends AbstractVirtEntity implements IComputeObject {

	private static final long serialVersionUID = 1L;

	@JsonView(Views.Basic.class)
	@XmlJavaTypeAdapter(value = IntegerAdapter.class)
	private Integer cpunum;
	@JsonView(Views.Basic.class)
	@XmlJavaTypeAdapter(value = LongAdapter.class)
	private Long memorysize;
	@JsonView(Views.Basic.class)
	@XmlJavaTypeAdapter(value = ISO8601DateAdapter.class)
	private Date creationdate;
	@JsonView(Views.Full.class)
	@XmlJavaTypeAdapter(value = DiskAdapter.class)
	private Disks disks = new Disks(0);
	@JsonView(Views.Full.class)
	@XmlJavaTypeAdapter(value = NetworkAdapterAdapter.class)
	private NetworkAdapters nics = new NetworkAdapters(0);
	@JsonView(Views.Short.class)
	private String name;
	@JsonView(Views.Short.class)
	private String resourceid;
	@JsonView(Views.Short.class)
	private String templateid;
	@JsonView(Views.Basic.class)
	private String os;
	@JsonView(Views.Basic.class)
	private String vmtype;
	@JsonView(Views.Basic.class)
	private String hypervisortype;
	@JsonView(Views.Basic.class)
	private String status;

	// rhevm,scvmm
	@Transient
	@XmlTransient
	private String timeZone;


	public ComputeObject() {
		super();

	}

	public ComputeObject(Integer numOfSockets, Long memorySize, Date creationDate, String templateid, String resourceid,
			String os, String name, String hypervisortype, String vmtype, String status, String desc) {
		super(desc);
		this.cpunum = numOfSockets;
		this.memorysize = memorySize;
		this.creationdate = creationDate;
		this.templateid = templateid;
		this.resourceid = resourceid;
		this.os = os;
		this.name = name;
		this.hypervisortype = hypervisortype;
		this.vmtype = vmtype;
		this.status = status;
	}

	@Override
	@Column(name = "CPUNUM", length = 5)
	public Integer getCpunum() {
		return cpunum;
	}

	public void setCpunum(Integer cpunum) {
		this.cpunum = cpunum;
	}

	@Override
	@Column(name = "MEMORYSIZE", length = 10)
	public Long getMemorysize() {
		return memorysize;
	}

	public void setMemorysize(Long memorysize) {
		this.memorysize = memorysize;
	}

	@Override
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "templateBaseEntity", cascade = CascadeType.ALL)
	public Disks getDisks() {
		return disks;
	}

	public void setDisks(Disks disks) {
		this.disks = disks;
	}

	@Override
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "templateBaseEntity", cascade = CascadeType.ALL)
	public NetworkAdapters getNics() {
		return nics;
	}

	public void setNics(NetworkAdapters nics) {
		this.nics = nics;
	}

	@Override
	@Column(name = "CREATIONDATE")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreationdate() {
		return this.creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	@Override
	@Column(name = "OS", length = 256)
	public String getOs() {
		return this.os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	@Override
	@Column(name = "NAME", length = 256)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	@Column(name = "RESOURCEID", length = 100)
	public String getResourceid() {
		return resourceid;
	}

	public void setResourceid(String resourceid) {
		this.resourceid = resourceid;
	}

	@Override
	@Column(name = "TEMPLATEID", length = 100)
	public String getTemplateid() {
		return templateid;
	}

	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}

	@Override
	@Column(name = "VMTYPE", length = 20)
	public String getVmtype() {
		return vmtype;
	}

	public void setVmtype(String vmtype) {
		this.vmtype = vmtype;
	}

	@Override
	@Column(name = "HYPERVISORTYPE", length = 100)
	public String getHypervisortype() {
		return hypervisortype;
	}

	public void setHypervisortype(String hypervisortype) {
		this.hypervisortype = hypervisortype;
	}

	@Override
	@Column(name = "STATUS", length = 40)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Transient
	@XmlTransient
	public String getTimeZone() {
		return timeZone;
	}

	@XmlTransient
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((hypervisortype == null) ? 0 : hypervisortype.hashCode());
		result = prime * result + ((resourceid == null) ? 0 : resourceid.hashCode());
		result = prime * result + ((templateid == null) ? 0 : templateid.hashCode());
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
		ComputeObject other = (ComputeObject) obj;
		if (hypervisortype == null) {
			if (other.hypervisortype != null) {
				return false;
			}
		} else if (!hypervisortype.equals(other.hypervisortype)) {
			return false;
		}
		if (resourceid == null) {
			if (other.resourceid != null) {
				return false;
			}
		} else if (!resourceid.equals(other.resourceid)) {
			return false;
		}
		if (templateid == null) {
			if (other.templateid != null) {
				return false;
			}
		} else if (!templateid.equals(other.templateid)) {
			return false;
		}
		return true;
	}

}
