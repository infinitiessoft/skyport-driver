package com.infinities.skyport.compute.entity.comparator;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infinities.skyport.compute.entity.Disk;
import com.infinities.skyport.compute.entity.NetworkAdapter;
import com.infinities.skyport.compute.entity.NetworkStatistics;
import com.infinities.skyport.compute.entity.Statistics;
import com.infinities.skyport.compute.entity.Vm;
import com.infinities.skyport.util.FormatUtil;

public class VmComparatorTest {

	private IVmComparator comparator;
	private Vm vm, vm2;
	private NetworkAdapter nic1, nic2, nic3, nic4;
	private Disk disk1, disk2, disk3, disk4;


	@Before
	public void setUp() throws Exception {
		comparator = new IVmComparator();
		vm = new Vm("templateid", "name", 0L, "os", 0, FormatUtil.getDefaultCreationDate(), "desc", "resourceid", "vmtype",
				"hypervisortype", "vmid", "status", "runningonhost", "ip", "cdisopath", "info", new Statistics());
		vm.setConfig("config");
		vm.setId(-1L);

		vm2 = new Vm("templateid", "name", 0L, "os", 0, FormatUtil.getDefaultCreationDate(), "desc", "resourceid", "vmtype",
				"hypervisortype", "vmid", "status", "runningonhost", "ip", "cdisopath", "info", new Statistics());
		vm2.setConfig("config");
		vm2.setId(-1L);

		nic1 = new NetworkAdapter("desc", "macAddress", "name", 1000, 1000, "state", "type", "nicId", 0, "network",
				new NetworkStatistics(0D, 0D, 0D, 0D));
		nic1.setIp("ip");
		nic1.setConfig("config");
		nic1.setInstanceid(vm.getVmid());
		nic1.setInstancetype("vm");

		nic2 = new NetworkAdapter("desc", "macAddress", "name", 1000, 1000, "state", "type", "nicId2", 0, "network",
				new NetworkStatistics(0D, 0D, 0D, 0D));
		nic2.setIp("ip");
		nic2.setConfig("config");
		nic2.setInstanceid(vm.getVmid());
		nic2.setInstancetype("vm");

		nic3 = new NetworkAdapter("desc", "macAddress", "name", 1000, 1000, "state", "type", "nicId", 0, "network",
				new NetworkStatistics(0D, 0D, 0D, 0D));
		nic3.setIp("ip");
		nic3.setConfig("config");
		nic3.setInstanceid(vm.getVmid());
		nic3.setInstancetype("vm");

		nic4 = new NetworkAdapter("desc", "macAddress", "name", 1000, 1000, "state", "type", "nicId2", 0, "network",
				new NetworkStatistics(0D, 0D, 0D, 0D));
		nic4.setIp("ip");
		nic4.setConfig("config");
		nic4.setInstanceid(vm.getVmid());
		nic4.setInstancetype("vm");

		disk1 = new Disk("desc", "snapshotId", 10L, 5L, 10L, 0D, 0D, "status", "volumeFormat", "volumeType", "diskType",
				new Date(), "internalDriveMapping", true, "diskInterface", "wipeAfterDelete", "propagateErrors", "diskId",
				"name", 5L);
		disk1.setConfig("config");
		disk1.setInstanceid(vm.getVmid());
		disk1.setInstancetype("vm");

		disk2 = new Disk("desc", "snapshotId", 10L, 5L, 10L, 0D, 0D, "status", "volumeFormat", "volumeType", "diskType",
				new Date(), "internalDriveMapping", true, "diskInterface", "wipeAfterDelete", "propagateErrors", "diskId2",
				"name", 5L);
		disk2.setConfig("config");
		disk2.setInstanceid(vm.getVmid());
		disk2.setInstancetype("vm");

		disk3 = new Disk("desc", "snapshotId", 10L, 5L, 10L, 0D, 0D, "status", "volumeFormat", "volumeType", "diskType",
				new Date(), "internalDriveMapping", true, "diskInterface", "wipeAfterDelete", "propagateErrors", "diskId",
				"name", 5L);
		disk3.setConfig("config");
		disk3.setInstanceid(vm.getVmid());
		disk3.setInstancetype("vm");

		disk4 = new Disk("desc", "snapshotId", 10L, 5L, 10L, 0D, 0D, "status", "volumeFormat", "volumeType", "diskType",
				new Date(), "internalDriveMapping", true, "diskInterface", "wipeAfterDelete", "propagateErrors", "diskId2",
				"name", 5L);
		disk4.setConfig("config");
		disk4.setInstanceid(vm.getVmid());
		disk4.setInstancetype("vm");

		vm.getNics().add(nic1);
		vm.getNics().add(nic2);
		vm.getDisks().add(disk1);
		vm.getDisks().add(disk2);

		vm2.getNics().add(nic3);
		vm2.getNics().add(nic4);
		vm2.getDisks().add(disk3);
		vm2.getDisks().add(disk4);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCompareWithEquals() {
		assertEquals(0, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentVmid() {
		vm2.setVmid("changeit");
		assertEquals(1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentVmid2() {
		vm.setVmid("changeit");
		assertEquals(-1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentName() {
		vm2.setName("changeit");
		assertEquals(1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentName2() {
		vm.setName("changeit");
		assertEquals(-1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentDesc() {
		vm2.setDesc("change");
		assertEquals(1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentDesc2() {
		vm.setDesc("change");
		assertEquals(-1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentOs() {
		vm2.setOs("change");
		assertEquals(1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentOs2() {
		vm.setOs("change");
		assertEquals(-1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentCpu() {
		vm2.setCpunum(10);
		assertEquals(-1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentCpu2() {
		vm.setCpunum(10);
		assertEquals(1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentMemory() {
		vm2.setMemorysize(100L);
		assertEquals(-1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentMemory2() {
		vm.setMemorysize(100L);
		assertEquals(1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentDiskSize() {
		Disk disk5 = new Disk("desc", "snapshotId", 10L, 5L, 10L, 0D, 0D, "status", "volumeFormat", "volumeType",
				"diskType", new Date(), "internalDriveMapping", true, "diskInterface", "wipeAfterDelete", "propagateErrors",
				"diskId3", "name", 5L);
		disk5.setConfig("config");
		disk5.setInstanceid(vm.getVmid());
		disk5.setInstancetype("vm");
		vm2.getDisks().add(disk5);
		assertEquals(-1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentDiskSize2() {
		Disk disk5 = new Disk("desc", "snapshotId", 10L, 5L, 10L, 0D, 0D, "status", "volumeFormat", "volumeType",
				"diskType", new Date(), "internalDriveMapping", true, "diskInterface", "wipeAfterDelete", "propagateErrors",
				"diskId3", "name", 5L);
		disk5.setConfig("config");
		disk5.setInstanceid(vm.getVmid());
		disk5.setInstancetype("vm");
		vm.getDisks().add(disk5);
		assertEquals(1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentNic() {
		NetworkAdapter nic5 = new NetworkAdapter("desc", "macAddress", "name", 1000, 1000, "state", "type", "nicId5", 0,
				"network", new NetworkStatistics(0D, 0D, 0D, 0D));
		nic5.setIp("ip");
		nic5.setConfig("config");
		nic5.setInstanceid(vm.getVmid());
		nic5.setInstancetype("vm");
		vm2.getNics().add(nic5);
		assertEquals(-1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentNic2() {
		NetworkAdapter nic5 = new NetworkAdapter("desc", "macAddress", "name", 1000, 1000, "state", "type", "nicId5", 0,
				"network", new NetworkStatistics(0D, 0D, 0D, 0D));
		nic5.setIp("ip");
		nic5.setConfig("config");
		nic5.setInstanceid(vm.getVmid());
		nic5.setInstancetype("vm");
		vm.getNics().add(nic5);
		assertEquals(1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentDiskId() {
		disk3.setDiskid("change");
		assertEquals(1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentDiskId2() {
		disk1.setDiskid("change");
		assertEquals(1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentDiskName() {
		disk3.setName("change");
		assertEquals(1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentDiskName2() {
		disk1.setName("change");
		assertEquals(-1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentDiskDesc() {
		disk3.setDesc("change");
		assertEquals(1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentDiskDesc2() {
		disk1.setDesc("change");
		assertEquals(-1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentDiskInterface() {
		disk3.setDiskinterface("change");
		assertEquals(1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentDiskInterface2() {
		disk1.setDiskinterface("change");
		assertEquals(-1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentDisktype() {
		disk3.setDisktype("change");
		assertEquals(1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentDisktype2() {
		disk1.setDisktype("change");
		assertEquals(-1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentInternaldrivemapping() {
		disk3.setInternaldrivemapping("change");
		assertEquals(1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentInternaldrivemapping2() {
		disk1.setInternaldrivemapping("change");
		assertEquals(-1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentVolumeformat() {
		disk3.setVolumeformat("change");
		assertEquals(1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentVolumeformat2() {
		disk1.setVolumeformat("change");
		assertEquals(-1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentVolumetype() {
		disk3.setVolumetype("change");
		assertEquals(1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentVolumetype2() {
		disk1.setVolumetype("change");
		assertEquals(-1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentSizegb() {
		disk3.setSizegb(100L);
		assertEquals(-1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentSizegb2() {
		disk1.setSizegb(100L);
		assertEquals(1, comparator.compare(vm, vm2));
	}
	
	@Test
	public void testCompareWithDifferentNicId() {
		nic3.setNicid("change");
		assertEquals(1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentNicId2() {
		nic1.setNicid("change");
		assertEquals(1, comparator.compare(vm, vm2));
	}
	
	@Test
	public void testCompareWithDifferentNicName() {
		nic3.setName("change");
		assertEquals(1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentNicName2() {
		nic1.setName("change");
		assertEquals(-1, comparator.compare(vm, vm2));
	}
	
	@Test
	public void testCompareWithDifferentNicDesc() {
		nic3.setDesc("change");
		assertEquals(1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentNicDesc2() {
		nic1.setDesc("change");
		assertEquals(-1, comparator.compare(vm, vm2));
	}
	
	@Test
	public void testCompareWithDifferentNicNetwork() {
		nic3.setNetwork("change");
		assertEquals(1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentNicNetwork2() {
		nic1.setNetwork("change");
		assertEquals(-1, comparator.compare(vm, vm2));
	}
	
	@Test
	public void testCompareWithDifferentNicType() {
		nic3.setType("change");
		assertEquals(1, comparator.compare(vm, vm2));
	}

	@Test
	public void testCompareWithDifferentNicType2() {
		nic1.setType("change");
		assertEquals(-1, comparator.compare(vm, vm2));
	}

}
