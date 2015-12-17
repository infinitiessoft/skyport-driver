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
