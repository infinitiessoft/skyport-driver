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
package com.infinities.skyport.compute.entity;

import javax.annotation.Nonnull;

/**
 * Represents the id and name of a specific kind of resource. This class is used
 * to implement openstack's list Objects API style that only return id and name
 * of the resource.
 * <p>
 * Created by Pohsun Huang: 12/23/15 10:57 AM
 * </p>
 * 
 * @author Pohsun Huang
 * @version 2015.12 initial version
 * @since 2015.12
 */

public class MinimalResource {

	private String id;
	private String name;


	public MinimalResource(@Nonnull String id, @Nonnull String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the cloud provider's unique identifier for this resource
	 */
	@Nonnull
	public String getId() {
		return id;
	}

	/**
	 * @return the name of the target resource
	 */
	@Nonnull
	public String getName() {
		return name;
	}

	@Override
	@Nonnull
	public String toString() {
		return (id + " [" + name + "]");
	}
}
