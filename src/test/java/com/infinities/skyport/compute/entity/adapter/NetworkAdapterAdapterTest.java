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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infinities.skyport.compute.entity.NetworkAdapter;
import com.infinities.skyport.compute.entity.NetworkStatistics;

public class NetworkAdapterAdapterTest {

	private NetworkAdapterAdapter adapter;
	private NetworkAdapter nic1, nic2;
	private String vmid = "vmid";
	private Set<NetworkAdapter> set = new HashSet<NetworkAdapter>();
	private List<Map<String, NetworkAdapter>> list = new ArrayList<Map<String, NetworkAdapter>>();


	@Before
	public void setUp() throws Exception {
		adapter = new NetworkAdapterAdapter();
		nic1 = new NetworkAdapter("desc", "macAddress", "name", 1000, 1000, "state", "type", "nicId", 0, "network",
				new NetworkStatistics(0D, 0D, 0D, 0D));
		nic1.setIp("ip");
		nic1.setConfig("config");
		nic1.setInstanceid(vmid);
		nic1.setInstancetype("vm");

		nic2 = new NetworkAdapter("desc", "macAddress", "name", 1000, 1000, "state", "type", "nicId2", 0, "network",
				new NetworkStatistics(0D, 0D, 0D, 0D));
		nic2.setIp("ip");
		nic2.setConfig("config");
		nic2.setInstanceid(vmid);
		nic2.setInstancetype("vm");

		set.add(nic1);
		set.add(nic2);
		Map<String, NetworkAdapter> map1 = new HashMap<String, NetworkAdapter>();
		Map<String, NetworkAdapter> map2 = new HashMap<String, NetworkAdapter>();
		map1.put(nic1.getNicid(), nic1);
		map2.put(nic2.getNicid(), nic2);
		list.add(map1);
		list.add(map2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUnmarshalListOfMapOfStringNetworkAdapter() throws Exception {
		Set<NetworkAdapter> entrys = adapter.unmarshal(list);
		assertEquals(2, entrys.size());
		Iterator<NetworkAdapter> iterator = entrys.iterator();
		NetworkAdapter n1 = iterator.next();
		assertEquals(nic1, n1);
		NetworkAdapter n2 = iterator.next();
		assertEquals(nic2, n2);
	}

	@Test
	public void testMarshalSetOfNetworkAdapter() throws Exception {
		List<Map<String, NetworkAdapter>> entrys = adapter.marshal(new HashSet<NetworkAdapter>());
		assertEquals(0, entrys.size());
	}

	@Test
	public void testMarshalSetOfNetworkAdapter2() throws Exception {
		List<Map<String, NetworkAdapter>> entrys = adapter.marshal(set);
		assertEquals(2, entrys.size());
		Map<String, NetworkAdapter> map1 = entrys.get(0);
		assertEquals(1, map1.size());
		assertTrue(map1.containsKey("nicId"));
		assertEquals(nic1, map1.get("nicId"));

		Map<String, NetworkAdapter> map2 = entrys.get(1);
		assertEquals(1, map2.size());
		assertTrue(map2.containsKey("nicId2"));
		assertEquals(nic2, map2.get("nicId2"));
	}

}
