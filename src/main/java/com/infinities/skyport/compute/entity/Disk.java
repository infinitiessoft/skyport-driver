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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonView;
import com.infinities.skyport.compute.IDisk;
import com.infinities.skyport.compute.entity.adapter.BooleanAdapter;
import com.infinities.skyport.compute.entity.adapter.DoubleAdapter;
import com.infinities.skyport.compute.entity.adapter.ISO8601DateAdapter;
import com.infinities.skyport.compute.entity.adapter.LongAdapter;
import com.infinities.skyport.view.Views;

@Entity
@Table(name = "DISK", schema = "PUBLIC", catalog = "PUBLIC")
public class Disk extends AbstractVirtEntity implements IDisk {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// property for icloud
	@JsonView(Views.Basic.class)
	private String snapshotid;
	@JsonView(Views.Basic.class)
	@XmlJavaTypeAdapter(value = LongAdapter.class)
	private Long sizegb;
	@JsonView(Views.Basic.class)
	@XmlJavaTypeAdapter(value = LongAdapter.class)
	private Long truesize;
	// same as SizeInGB
	@JsonView(Views.Basic.class)
	@XmlJavaTypeAdapter(value = LongAdapter.class)
	private Long apparentsize;
	@JsonView(Views.Basic.class)
	@XmlJavaTypeAdapter(value = DoubleAdapter.class)
	private Double readrate;
	@JsonView(Views.Basic.class)
	@XmlJavaTypeAdapter(value = DoubleAdapter.class)
	private Double writerate;
	@JsonView(Views.Basic.class)
	private String status;
	// cow or raw
	@JsonView(Views.Basic.class)
	private String volumeformat;
	// sparse or preallocated
	@JsonView(Views.Basic.class)
	private String volumetype;
	// system or data
	@JsonView(Views.Basic.class)
	private String disktype;
	@JsonView(Views.Basic.class)
	@XmlJavaTypeAdapter(value = ISO8601DateAdapter.class)
	private Date creationdate;
	@JsonView(Views.Basic.class)
	private String internaldrivemapping;
	@JsonView(Views.Basic.class)
	@XmlJavaTypeAdapter(value = BooleanAdapter.class)
	private Boolean boot;
	@JsonView(Views.Basic.class)
	private String diskinterface;
	@JsonView(Views.Basic.class)
	private String wipeafterdelete;
	@JsonView(Views.Basic.class)
	private String propagateerrors;
	// same as snapshotId
	@JsonView(Views.Short.class)
	private String diskid;
	@JsonView(Views.Short.class)
	private String name;
	@JsonView(Views.Basic.class)
	private String instanceid;
	@JsonView(Views.Basic.class)
	private String instancetype;

	@JsonView(Views.Basic.class)
	@XmlJavaTypeAdapter(value = LongAdapter.class)
	private Long actualsizegb;
	private ComputeObject templateBaseEntity;

	@Transient
	@XmlTransient
	private String vmId;
	@Transient
	@XmlTransient
	private String storageId;


	public Disk() {
		super();
	}

	public Disk(String desc, String snapshotId, long sizeInGb, long trueSize, long apparentSize, double readRate,
			double writeRate, String status, String volumeFormat, String volumeType, String diskType, Date creationDate,
			String internalDriveMapping, boolean boot, String diskInterface, String wipeAfterDelete, String propagateErrors,
			String diskId, String name, long actualSizeInGb) {
		super(desc);
		this.snapshotid = snapshotId;
		this.sizegb = sizeInGb;
		this.truesize = trueSize;
		this.apparentsize = apparentSize;
		this.readrate = readRate;
		this.writerate = writeRate;
		this.status = status;
		this.volumeformat = volumeFormat;
		this.volumetype = volumeType;
		this.disktype = diskType;
		this.creationdate = creationDate;
		this.internaldrivemapping = internalDriveMapping;
		this.boot = boot;
		this.diskinterface = diskInterface;
		this.wipeafterdelete = wipeAfterDelete;
		this.propagateerrors = propagateErrors;
		this.diskid = diskId;
		this.name = name;
		this.actualsizegb = actualSizeInGb;
	}

	@Override
	@Column(name = "SNAPSHOTID", length = 60)
	public String getSnapshotid() {
		return snapshotid;
	}

	public void setSnapshotid(String snapshotid) {
		this.snapshotid = snapshotid;
	}

	@Override
	@Column(name = "SIZEGB", length = 10)
	public Long getSizegb() {
		return sizegb;
	}

	public void setSizegb(Long sizegb) {
		this.sizegb = sizegb;
	}

	@Override
	@Column(name = "TRUESIZE", length = 10)
	public Long getTruesize() {
		return truesize;
	}

	public void setTruesize(Long truesize) {
		this.truesize = truesize;
	}

	@Override
	@Column(name = "APPARENTSIZE", length = 10)
	public Long getApparentsize() {
		return apparentsize;
	}

	public void setApparentsize(Long apparentsize) {
		this.apparentsize = apparentsize;
	}

	@Override
	@Column(name = "READRATE", length = 60)
	public Double getReadrate() {
		return readrate;
	}

	public void setReadrate(Double readrate) {
		this.readrate = readrate;
	}

	@Override
	@Column(name = "WRITERATE", length = 60)
	public Double getWriterate() {
		return writerate;
	}

	public void setWriterate(Double writerate) {
		this.writerate = writerate;
	}

	@Override
	@Column(name = "STATUS", length = 30)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	@Column(name = "VOLUMEFORMAT", length = 60)
	public String getVolumeformat() {
		return volumeformat;
	}

	public void setVolumeformat(String volumeformat) {
		this.volumeformat = volumeformat;
	}

	@Override
	@Column(name = "VOLUMETYPE", length = 60)
	public String getVolumetype() {
		return volumetype;
	}

	public void setVolumetype(String volumetype) {
		this.volumetype = volumetype;
	}

	@Override
	@Column(name = "DISKTYPE", length = 50)
	public String getDisktype() {
		return disktype;
	}

	public void setDisktype(String disktype) {
		this.disktype = disktype;
	}

	@Override
	@Column(name = "CREATIONDATE")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	@Override
	@Column(name = "INTERNALDRIVEMAPPING", length = 60)
	public String getInternaldrivemapping() {
		return internaldrivemapping;
	}

	public void setInternaldrivemapping(String internaldrivemapping) {
		this.internaldrivemapping = internaldrivemapping;
	}

	@Override
	@Column(name = "BOOT", length = 10)
	public Boolean getBoot() {
		return boot;
	}

	public void setBoot(Boolean boot) {
		this.boot = boot;
	}

	@Override
	@Column(name = "INTERFACE", length = 50)
	public String getDiskinterface() {
		return diskinterface;
	}

	public void setDiskinterface(String diskinterface) {
		this.diskinterface = diskinterface;
	}

	@Override
	@Column(name = "WIPEAFTERDELETE", length = 50)
	public String getWipeafterdelete() {
		return wipeafterdelete;
	}

	public void setWipeafterdelete(String wipeafterdelete) {
		this.wipeafterdelete = wipeafterdelete;
	}

	@Override
	@Column(name = "PROPAGATEERRORS", length = 50)
	public String getPropagateerrors() {
		return propagateerrors;
	}

	public void setPropagateerrors(String propagateerrors) {
		this.propagateerrors = propagateerrors;
	}

	@Override
	@Column(name = "DISKID", length = 60)
	public String getDiskid() {
		return diskid;
	}

	public void setDiskid(String diskid) {
		this.diskid = diskid;
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
	@Column(name = "ACTUALSIZEGB", length = 10)
	public Long getActualsizegb() {
		return actualsizegb;
	}

	public void setActualsizegb(Long actualsizegb) {
		this.actualsizegb = actualsizegb;
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

	@Transient
	@XmlTransient
	public String getVmId() {
		return vmId;
	}

	@XmlTransient
	public void setVmId(String vmId) {
		this.vmId = vmId;
	}

	@Transient
	@XmlTransient
	public String getStorageId() {
		return storageId;
	}

	@XmlTransient
	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((diskid == null) ? 0 : diskid.hashCode());
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
		Disk other = (Disk) obj;
		if (diskid == null) {
			if (other.diskid != null) {
				return false;
			}
		} else if (!diskid.equals(other.diskid)) {
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
