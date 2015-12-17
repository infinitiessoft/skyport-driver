package com.infinities.skyport.compute.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.infinities.skyport.compute.entity.adapter.LongAdapter;

public class Storage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "Name")
	private String name;

	@XmlElement(name = "StorageDomainId")
	private String storageDomainId;

	@XmlElement(name = "DomainType")
	private String domainType;

	@XmlElement(name = "Type")
	private String type;

	@XmlElement(name = "AvailableDiskSize")
	@XmlJavaTypeAdapter(value = LongAdapter.class)
	private Long availableDiskSize;

	@XmlElement(name = "UsedDiskSize")
	@XmlJavaTypeAdapter(value = LongAdapter.class)
	private Long usedDiskSize;

	@XmlElement(name = "Config")
	private String config;

	@XmlElement(name = "ConfigId")
	private String configid;


	public Storage() {
		super();
	}

	public Storage(String name, String storageDomainId, String domainType, String type, Long availableDiskSize,
			Long usedDiskSize) {
		super();
		this.config = null;
		this.name = name;
		this.storageDomainId = storageDomainId;
		this.domainType = domainType;
		this.type = type;
		this.availableDiskSize = availableDiskSize;
		this.usedDiskSize = usedDiskSize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStorageDomainId() {
		return storageDomainId;
	}

	public void setStorageDomainId(String storageDomainId) {
		this.storageDomainId = storageDomainId;
	}

	public String getDomainType() {
		return domainType;
	}

	public void setDomainType(String domainType) {
		this.domainType = domainType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getAvailableDiskSize() {
		return availableDiskSize;
	}

	public void setAvailableDiskSize(Long availableDiskSize) {
		this.availableDiskSize = availableDiskSize;
	}

	public Long getUsedDiskSize() {
		return usedDiskSize;
	}

	public void setUsedDiskSize(Long usedDiskSize) {
		this.usedDiskSize = usedDiskSize;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public String getConfigid() {
		return configid;
	}

	public void setConfigid(String configid) {
		this.configid = configid;
	}

}
