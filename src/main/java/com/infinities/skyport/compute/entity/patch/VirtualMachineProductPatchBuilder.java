package com.infinities.skyport.compute.entity.patch;

import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.dasein.cloud.compute.VirtualMachineProduct;

public class VirtualMachineProductPatchBuilder implements PatchBuilder<VirtualMachineProduct> {

	@Override
	public DiffResult diff(VirtualMachineProduct old, VirtualMachineProduct updated) {
		DiffResult diff = new DiffBuilder(old, updated, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("cpuCount", old.getCpuCount(), updated.getCpuCount())
				.append("standardHourlyRate", old.getStandardHourlyRate(), updated.getStandardHourlyRate())
				.append("architectures", old.getArchitectures(), updated.getArchitectures())
				.append("dataCenterId", old.getDataCenterId(), updated.getDataCenterId())
				.append("description", old.getDescription(), updated.getDescription())
				.append("name", old.getName(), updated.getName())
				.append("providerMetadata", old.getProviderMetadata(), updated.getProviderMetadata())
				.append("providerProductId", old.getProviderProductId(), updated.getProviderProductId())
				.append("ramSize", old.getRamSize(), updated.getRamSize())
				.append("rootVolumeSize", old.getRootVolumeSize(), updated.getRootVolumeSize())
				.append("status", old.getStatus(), updated.getStatus())
				.append("visibleScope", old.getVisibleScope(), updated.getVisibleScope()).build();
		return diff;
	}

}
