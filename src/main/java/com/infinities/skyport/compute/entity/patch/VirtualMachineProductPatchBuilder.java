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
