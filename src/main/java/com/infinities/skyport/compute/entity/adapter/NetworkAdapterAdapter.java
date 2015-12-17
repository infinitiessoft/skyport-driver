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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.infinities.skyport.compute.entity.NetworkAdapter;

public class NetworkAdapterAdapter extends XmlAdapter<List<Map<String, NetworkAdapter>>, Set<NetworkAdapter>> implements
		Serializable {

	// private Logger logger =
	// LoggerFactory.getLogger(NetworkAdapterAdapter.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Set<NetworkAdapter> unmarshal(List<Map<String, NetworkAdapter>> v) throws Exception {
		if (v == null) {
			return null;
		}

		Set<NetworkAdapter> nics = new HashSet<NetworkAdapter>();
		for (Map<String, NetworkAdapter> entry : v) {
			for (NetworkAdapter nic : entry.values()) {
				nics.add(nic);
			}
		}

		return nics;
	}

	@Override
	public List<Map<String, NetworkAdapter>> marshal(Set<NetworkAdapter> v) throws Exception {
		List<Map<String, NetworkAdapter>> entrys = new ArrayList<Map<String, NetworkAdapter>>();
		for (NetworkAdapter nic : v) {
			Map<String, NetworkAdapter> map = new HashMap<String, NetworkAdapter>();
			map.put(nic.getNicid(), nic);
			entrys.add(map);
		}

		return entrys;
	}

}
