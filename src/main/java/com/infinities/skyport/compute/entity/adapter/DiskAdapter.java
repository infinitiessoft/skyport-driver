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

import com.infinities.skyport.compute.entity.Disk;

public class DiskAdapter extends XmlAdapter<List<Map<String, Disk>>, Set<Disk>> implements Serializable {

	// private Logger logger = LoggerFactory.getLogger(DiskAdapter.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Set<Disk> unmarshal(List<Map<String, Disk>> v) throws Exception {
		if (v == null) {
			return null;
		}

		Set<Disk> disks = new HashSet<Disk>();
		for (Map<String, Disk> entry : v) {
			for (Disk disk : entry.values()) {
				disks.add(disk);
			}
		}

		return disks;
	}

	@Override
	public List<Map<String, Disk>> marshal(Set<Disk> v) throws Exception {
		List<Map<String, Disk>> entrys = new ArrayList<Map<String, Disk>>();
		for (Disk disk : v) {
			Map<String, Disk> map = new HashMap<String, Disk>();
			map.put(disk.getDiskid(), disk);
			entrys.add(map);
		}

		return entrys;
	}

}
