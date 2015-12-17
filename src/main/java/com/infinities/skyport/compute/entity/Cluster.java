package com.infinities.skyport.compute.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class Cluster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public enum Status {
		Up, Down, Unknown
	}


	@XmlElement(name = "Name")
	private String name;

	@XmlElement(name = "ClusterId")
	private String clusterId;

	@XmlElement(name = "Description")
	private String description;

	@XmlElement(name = "DataCenterId")
	private String dataCenterId;

	@XmlElement(name = "HypervisorType")
	private String hypervisorType;

	@XmlElement(name = "Config")
	private String config;

	@XmlElement(name = "Status")
	private Status status;

	@XmlElement(name = "ConfigId")
	private String configid;


	public Cluster() {
		super();
	}

	public Cluster(String name, String clusterId, String description, String dataCenterId, String hypervisorType,
			Status status) {
		super();
		this.name = name;
		this.clusterId = clusterId;
		this.description = description;
		this.dataCenterId = dataCenterId;
		this.hypervisorType = hypervisorType;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClusterId() {
		return clusterId;
	}

	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDataCenterId() {
		return dataCenterId;
	}

	public void setDataCenterId(String dataCenterId) {
		this.dataCenterId = dataCenterId;
	}

	public String getHypervisorType() {
		return hypervisorType;
	}

	public void setHypervisorType(String hypervisorType) {
		this.hypervisorType = hypervisorType;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getConfigid() {
		return configid;
	}

	public void setConfigid(String configid) {
		this.configid = configid;
	}
}
