package com.infinities.skyport.compute.entity.patch;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.DiffResult;
import org.dasein.cloud.VisibleScope;
import org.dasein.cloud.compute.Architecture;
import org.dasein.cloud.compute.VirtualMachineProduct;
import org.dasein.util.uom.storage.Gigabyte;
import org.dasein.util.uom.storage.Megabyte;
import org.dasein.util.uom.storage.Storage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VirtualMachineProductPatchBuilderTest {

	private VirtualMachineProductPatchBuilder builder = new VirtualMachineProductPatchBuilder();


	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDiff() {
		VirtualMachineProduct old = new VirtualMachineProduct();
		old.setArchitectures(Architecture.I32);
		old.setCpuCount(0);
		old.setDataCenterId("dataCenterId");
		old.setDescription("description");
		old.setName("name");
		Map<String, String> providerMetadata = new HashMap<String, String>();
		providerMetadata.put("key", "value");
		old.setProviderMetadata(providerMetadata);
		old.setProviderProductId("providerProductId");
		old.setRamSize(new Storage<Megabyte>(1, new Megabyte()));
		old.setRootVolumeSize(new Storage<Gigabyte>(1, new Gigabyte()));
		old.setStandardHourlyRate(0);
		old.setVisibleScope(VisibleScope.ACCOUNT_DATACENTER);

		VirtualMachineProduct updated = new VirtualMachineProduct();
		updated.setArchitectures(Architecture.I64);
		updated.setCpuCount(1);
		updated.setDataCenterId("dataCenterId1");
		updated.setDescription("description1");
		updated.setName("name1");
		Map<String, String> providerMetadata1 = new HashMap<String, String>();
		providerMetadata1.put("key1", "value1");
		updated.setProviderMetadata(providerMetadata1);
		updated.setProviderProductId("providerProductId1");
		updated.setRamSize(new Storage<Megabyte>(2, new Megabyte()));
		updated.setRootVolumeSize(new Storage<Gigabyte>(2, new Gigabyte()));
		updated.setStandardHourlyRate(1);
		updated.setStatusDeprecated();
		updated.setVisibleScope(VisibleScope.ACCOUNT_GLOBAL);

		DiffResult diffResult = builder.diff(old, updated);
		assertEquals(12, diffResult.getNumberOfDiffs());
	}

}
