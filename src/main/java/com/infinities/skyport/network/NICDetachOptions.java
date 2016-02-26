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
package com.infinities.skyport.network;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author pohsun
 *
 */
public class NICDetachOptions {

	public static NICDetachOptions getInstanceForPort(@Nonnull String nicId, @Nonnull String vmId) {
		NICDetachOptions options = new NICDetachOptions();

		options.nicId = nicId;
		options.vmId = vmId;
		return options;
	}

	public static NICDetachOptions getInstanceForVlan(@Nonnull String vlanId, @Nonnull String vmId) {
		NICDetachOptions options = new NICDetachOptions();

		options.vlanId = vlanId;
		options.vmId = vmId;
		return options;
	}


	// NOTE: ADDING/REMOVING/CHANGING AN ATTRIBUTE? MAKE SURE YOU REFLECT THE
	// CHANGE IN THE copy() METHOD
	private String vmId;
	private String vlanId;
	private String nicId;
	private int index = -1;


	private NICDetachOptions() {
	}

	@Nonnull
	public String getVmId() {
		return vmId;
	}

	@Nullable
	public String getVlanId() {
		return vlanId;
	}

	@Nonnull
	public String getNicId() {
		return nicId;
	}

	@Nonnull
	public int getIndex() {
		return index;
	}

	@Nonnull
	public NICDetachOptions withIndex(@Nonnull int index) {
		this.index = index;
		return this;
	}
}
