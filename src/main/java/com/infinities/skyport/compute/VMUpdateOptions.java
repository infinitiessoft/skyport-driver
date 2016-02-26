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
package com.infinities.skyport.compute;

import javax.annotation.Nonnull;

/**
 * @author pohsun
 *
 */
public class VMUpdateOptions {

	public static VMUpdateOptions getInstance(@Nonnull String name) {
		VMUpdateOptions options = new VMUpdateOptions();

		options.name = name;
		return options;
	}


	private String name;


	private VMUpdateOptions() {
	}

	@Nonnull
	public String getName() {
		return name;
	}

}
