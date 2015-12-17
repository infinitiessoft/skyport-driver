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

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.infinities.skyport.compute.entity.adapter.DoubleAdapter;

public class Statistics implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlJavaTypeAdapter(value = DoubleAdapter.class)
	private Double memusage = 0.00d;
	@XmlJavaTypeAdapter(value = DoubleAdapter.class)
	private Double cpuuser = 0.00d;
	@XmlJavaTypeAdapter(value = DoubleAdapter.class)
	private Double cpusys = 0.00d;


	public Statistics() {
		super();
	}

	public Statistics(Double memUsage, Double cpuUser, Double cpuSys) {
		super();
		this.memusage = memUsage;
		this.cpuuser = cpuUser;
		this.cpusys = cpuSys;
	}

	public Double getMemusage() {
		return memusage;
	}

	public void setMemusage(Double memusage) {
		this.memusage = memusage;
	}

	public Double getCpuuser() {
		return cpuuser;
	}

	public void setCpuuser(Double cpuuser) {
		this.cpuuser = cpuuser;
	}

	public Double getCpusys() {
		return cpusys;
	}

	public void setCpusys(Double cpusys) {
		this.cpusys = cpusys;
	}

}
