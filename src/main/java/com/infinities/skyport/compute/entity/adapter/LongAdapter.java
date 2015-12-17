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
import java.text.NumberFormat;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongAdapter extends XmlAdapter<String, Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(LongAdapter.class);


	@Override
	public Long unmarshal(String arg0) throws Exception {
		if (arg0 == null) {
			return 0L;
		}

		try {
			NumberFormat numFormat = NumberFormat.getNumberInstance();
			return numFormat.parse(arg0).longValue();
		} catch (Exception e) {
			logger.debug("Failed to parse string {}", arg0);
			return null;
		}
	}

	@Override
	public String marshal(Long arg0) throws Exception {
		try {
			NumberFormat numFormat = NumberFormat.getNumberInstance();
			numFormat.setGroupingUsed(false);
			return numFormat.format(arg0);
		} catch (Exception e) {
			logger.warn("Failed to format float {}", arg0);
			return "0";
		}

	}

}
