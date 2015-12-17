package com.infinities.skyport.compute.entity.comparator;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.dasein.cloud.VisibleScope;
import org.dasein.cloud.compute.Architecture;
import org.dasein.cloud.compute.VirtualMachineProduct;
import org.dasein.util.uom.storage.Gigabyte;
import org.dasein.util.uom.storage.Megabyte;
import org.dasein.util.uom.storage.Storage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class VirtualMachineProductComparatorTest {
	
	private VirtualMachineProductComparator comparator = new VirtualMachineProductComparator();
	private VirtualMachineProduct o1, o2;

	@Before
	public void setUp() throws Exception {
		o1 = new VirtualMachineProduct();
		o1.setRamSize(new Storage<Megabyte>(1, new Megabyte()));
		o1.setRootVolumeSize(new Storage<Gigabyte>(1, new Gigabyte()));
		o2 = new VirtualMachineProduct();
		o2.setRamSize(new Storage<Megabyte>(1, new Megabyte()));
		o2.setRootVolumeSize(new Storage<Gigabyte>(1, new Gigabyte()));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCompare() {
		int result = comparator.compare(o1, o2);
		assertEquals(0, result);
	}
	
	@Test
	public void testCompareCpuCount() {
		o1.setCpuCount(1);
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@Test
	public void testCompareStandardHourlyRate() {
		o1.setStandardHourlyRate(1);
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@Test
	public void testCompareDataCenterId() {
		o1.setDataCenterId("dataCenterId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}
	
	@Test
	public void testCompareDescription() {
		o1.setDescription("description");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareName() {
		o1.setName("name");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareProviderProductId() {
		o1.setProviderProductId("providerProductId");
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}
	
	@Test
	public void testCompareStatus() {
		o1.setStatusDeprecated();
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@Test
	public void testCompareVisibleScope() {
		o1.setVisibleScope(VisibleScope.ACCOUNT_DATACENTER);
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	
	@Test
	public void testCompareArchitectures() {
		o1.setArchitectures(Architecture.I64);
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}
	
	@Test
	public void testCompareProviderMetadata() {
		Map<String, String> providerMetadata1 = new HashMap<String, String>();
		providerMetadata1.put("key1", "value1");
		o1.setProviderMetadata(providerMetadata1);
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}
	

	@Test
	public void testCompareRamSize() {
		o1.setRamSize(new Storage<Megabyte>(2, new Megabyte()));
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}

	@Test
	public void testCompareRootVolumeSize() {
		o1.setRootVolumeSize(new Storage<Gigabyte>(2, new Gigabyte()));
		int result = comparator.compare(o1, o2);
		assertEquals(1, result);
	}
	
}
