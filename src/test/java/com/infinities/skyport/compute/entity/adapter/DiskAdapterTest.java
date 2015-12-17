package com.infinities.skyport.compute.entity.adapter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infinities.skyport.compute.entity.Disk;

public class DiskAdapterTest {

	private DiskAdapter adapter;
	private Disk disk1, disk2;
	private String vmid = "vmid";
	private Set<Disk> set = new HashSet<Disk>();
	private List<Map<String, Disk>> list = new ArrayList<Map<String, Disk>>();


	@Before
	public void setUp() throws Exception {
		adapter = new DiskAdapter();
		disk1 = new Disk("desc", "snapshotId", 10L, 5L, 10L, 0D, 0D, "status", "volumeFormat", "volumeType", "diskType",
				new Date(), "internalDriveMapping", true, "diskInterface", "wipeAfterDelete", "propagateErrors", "diskId",
				"name", 5L);
		disk1.setConfig("config");
		disk1.setInstanceid(vmid);
		disk1.setInstancetype("vm");

		disk2 = new Disk("desc", "snapshotId", 10L, 5L, 10L, 0D, 0D, "status", "volumeFormat", "volumeType", "diskType",
				new Date(), "internalDriveMapping", true, "diskInterface", "wipeAfterDelete", "propagateErrors", "diskId2",
				"name", 5L);
		disk2.setConfig("config");
		disk2.setInstanceid(vmid);
		disk2.setInstancetype("vm");

		set.add(disk1);
		set.add(disk2);

		Map<String, Disk> map1 = new HashMap<String, Disk>();
		Map<String, Disk> map2 = new HashMap<String, Disk>();
		map1.put(disk1.getDiskid(), disk1);
		map2.put(disk2.getDiskid(), disk2);
		list.add(map1);
		list.add(map2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUnmarshalListOfMapOfStringDisk() throws Exception {
		Set<Disk> entrys = adapter.unmarshal(list);
		assertEquals(2, entrys.size());
		Iterator<Disk> iterator = entrys.iterator();
		Disk n1 = iterator.next();
		assertEquals(disk1, n1);
		Disk n2 = iterator.next();
		assertEquals(disk2, n2);

	}

	@Test
	public void testMarshalSetOfDisk() throws Exception {
		List<Map<String, Disk>> entrys = adapter.marshal(new HashSet<Disk>());
		assertEquals(0, entrys.size());
	}

	@Test
	public void testMarshalSetOfDisk2() throws Exception {
		List<Map<String, Disk>> entrys = adapter.marshal(set);
		assertEquals(2, entrys.size());
		Map<String, Disk> map1 = entrys.get(0);
		assertEquals(1, map1.size());
		assertTrue(map1.containsKey("diskId"));
		assertEquals(disk1, map1.get("diskId"));

		Map<String, Disk> map2 = entrys.get(1);
		assertEquals(1, map2.size());
		assertTrue(map2.containsKey("diskId2"));
		assertEquals(disk2, map2.get("diskId2"));
	}

}
