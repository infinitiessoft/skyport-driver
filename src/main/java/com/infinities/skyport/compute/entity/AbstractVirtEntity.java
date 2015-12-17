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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.JsonNode;
import com.infinities.skyport.JsonConstants;
import com.infinities.skyport.compute.IAbstractVirtEntity;
import com.infinities.skyport.util.JsonUtil;
import com.infinities.skyport.view.Views;

@MappedSuperclass
public abstract class AbstractVirtEntity extends AbstractEntity implements IAbstractVirtEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonView(Views.Basic.class)
	private String config;
	@JsonView(Views.Basic.class)
	private String configid;


	public AbstractVirtEntity() {
		super();
	}

	public AbstractVirtEntity(String desc) {
		super(desc);
		this.config = null;
	}

	@Column(name = "CONFIG", length = 20)
	public String getConfig() {
		return this.config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	@Column(name = "CONFIGID", length = 100)
	public String getConfigid() {
		return configid;
	}

	public void setConfigid(String configid) {
		this.configid = configid;
	}

	// TODO should be replace pool by config
	@Override
	@XmlElement(name = "pool")
	@Transient
	public String getPool() {
		return this.config;
	}

	@Override
	@XmlElement(name = "poolid")
	@Transient
	public String getPoolid() {
		return this.configid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((configid == null) ? 0 : configid.hashCode());
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
		AbstractVirtEntity other = (AbstractVirtEntity) obj;
		if (configid == null) {
			if (other.configid != null) {
				return false;
			}
		} else if (!configid.equals(other.configid)) {
			return false;
		}
		return true;
	}

	public static <T extends AbstractVirtEntity> List<T> covertToObjectList(String res, String config, Class<T> valueType)
			throws IOException {

		final JsonNode jsonResult = JsonUtil.readJson(res);

		final List<T> list = new ArrayList<T>();

		for (final Object node : jsonResult) {
			if (node instanceof JsonNode) {
				if (((JsonNode) node).has(JsonConstants.RES)) {
					continue;
				}
				T obj = JsonUtil.getObjectMapper().treeToValue((JsonNode) node, valueType);
				obj.setConfig(config);
				list.add(obj);
			}
		}

		return list;
	}

}
