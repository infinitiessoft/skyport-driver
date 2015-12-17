package com.infinities.skyport.compute.entity.comparator;

import static org.junit.Assert.assertEquals;

import org.dasein.cloud.compute.VolumeProduct;
import org.dasein.cloud.compute.VolumeType;
import org.dasein.util.uom.storage.Gigabyte;
import org.dasein.util.uom.storage.Storage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VolumeProductComparatorTest {

	private VolumeProductComparator comparator = new VolumeProductComparator();
	private VolumeProduct o1, o2;


	@Before
	public void setUp() throws Exception {
		o1 = VolumeProduct.getInstance("id", "name", "description", VolumeType.SSD,
				new Storage<Gigabyte>(5, new Gigabyte()), "currency", 5, 5, new Float(5), new Float(5));
		o2 = VolumeProduct.getInstance("id", "name", "description", VolumeType.SSD,
				new Storage<Gigabyte>(5, new Gigabyte()), "currency", 5, 5, new Float(5), new Float(5));
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
	public void testCompareMaxIopsRatio() {
		o1.withMaxIopsRatio(1);
		int result = comparator.compare(o1, o2);
		assertEquals(-1, result);
	}

	@Test
	public void testCompareMaxVolumeSize() {
		o1.withMaxVolumeSize(new Storage<Gigabyte>(1, new Gigabyte()));
		int result = comparator.compare(o1, o2);
		assertEquals(0, result);
	}

	@Test
	public void testCompareMinVolumeSize() {
		o1.withMinVolumeSize(new Storage<Gigabyte>(1, new Gigabyte()));
		int result = comparator.compare(o1, o2);
		assertEquals(0, result);
	}

}
