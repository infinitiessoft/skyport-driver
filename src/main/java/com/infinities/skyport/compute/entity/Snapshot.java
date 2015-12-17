package com.infinities.skyport.compute.entity;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.infinities.skyport.compute.entity.adapter.ISO8601DateAdapter;

public class Snapshot implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "SnapshotId")
	private String snapshotId;

	@XmlElement(name = "Name")
	private String name;

	@XmlElement(name = "CreationDate")
	@XmlJavaTypeAdapter(value = ISO8601DateAdapter.class)
	private Date creationDate;

	@XmlElement(name = "Description")
	private String description;
	
	@XmlElement(name = "ResourceId")
	private String resourceId;

	@XmlTransient
	private String vmId;


	public Snapshot() {
		super();
	}

	public Snapshot(String snapshotId, String name, Date creationDate, String description) {
		super();
		this.snapshotId = snapshotId;
		this.name = name;
		this.creationDate = creationDate;
		this.description = description;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getSnapshotId() {
		return snapshotId;
	}

	public void setSnapshotId(String snapshotId) {
		this.snapshotId = snapshotId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVmId() {
		return vmId;
	}

	public void setVmId(String vmId) {
		this.vmId = vmId;
	}
}
