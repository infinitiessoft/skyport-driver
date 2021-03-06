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

import javax.persistence.Entity;
import javax.persistence.Table;

import com.infinities.skyport.compute.ITemplate;

@Entity
@Table(name = "TEMPLATE", schema = "PUBLIC", catalog = "PUBLIC"
// , uniqueConstraints = { @UniqueConstraint(columnNames = {
// "CONFIG", "TEMPLATEID" }) }
)
public class Template extends ComputeObject implements ITemplate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Template() {
		super();
	}

	public Template(String templateId, String name, long memorySize, String operatingSystem, int numOfSockets,
			Date creationDate, String desc, String hostclusterId, String vmType, String hypervisorType, String status) {
		super(numOfSockets, memorySize, creationDate, templateId, hostclusterId, operatingSystem, name, hypervisorType,
				vmType, status, desc);
	}

}
