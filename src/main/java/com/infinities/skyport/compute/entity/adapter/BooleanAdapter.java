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
package com.infinities.skyport.compute.entity.adapter;

import java.io.Serializable;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infinities.skyport.util.FormatUtil;

public class BooleanAdapter extends XmlAdapter<String, Boolean> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(BooleanAdapter.class);


	@Override
	public Boolean unmarshal(String arg0) throws Exception {
		try {
			return Boolean.parseBoolean(arg0);
		} catch (Exception e) {
			logger.debug("Failed to parse string {}", arg0);
			throw new RuntimeException(e);
		}
	}

	@Override
	public String marshal(Boolean arg0) throws Exception {
		if (arg0 == null) {
			return null;
		}
		try {
			return FormatUtil.ucFirst(String.valueOf(arg0));
		} catch (Exception e) {
			logger.warn("Failed to format float {}", arg0);
			throw new RuntimeException(e);
		}

	}
}
