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

import javax.annotation.Nullable;

import org.dasein.cloud.compute.AffinityGroupSupport;
import org.dasein.cloud.compute.AutoScalingSupport;
import org.dasein.cloud.compute.MachineImageSupport;
import org.dasein.cloud.compute.SnapshotSupport;
import org.dasein.cloud.compute.VolumeSupport;

/**
 * This is a extended version of org.dasein.cloud.compute.ComputeServices for
 * customization porpuse.
 * <p>
 * Created by Pohsun Huang: 12/23/15 10:57 AM
 * </p>
 * 
 * @author Pohsun Huang
 * @version 2015.12 initial version
 * @since 2015.12
 */
public interface SkyportComputeServices {

	/**
	 * @return access to support for affinity groups in the cloud provider
	 */
	@Nullable
	AffinityGroupSupport getAffinityGroupSupport();

	/**
	 * @return access to support for auto-scaling capabilities native to the
	 *         cloud provider
	 */
	@Nullable
	AutoScalingSupport getAutoScalingSupport();

	/**
	 * @return access to support for images/templates in the cloud provider
	 */
	@Nullable
	MachineImageSupport getImageSupport();

	/**
	 * @return access to support for volume snapshots in the cloud provider
	 */
	@Nullable
	SnapshotSupport getSnapshotSupport();

	/**
	 * @return access to support for virtual machines in the cloud provider
	 */
	@Nullable
	SkyportVirtualMachineSupport getSkyportVirtualMachineSupport();

	/**
	 * @return access to support for volumes in the cloud provider
	 */
	@Nullable
	VolumeSupport getVolumeSupport();

	/**
	 * @return indicates whether or not the cloud provider supports affinity
	 *         groups
	 */
	boolean hasAffinityGroupSupport();

	/**
	 * @return indicates whether or not the cloud provider supports native
	 *         auto-scaling capabilities
	 */
	boolean hasAutoScalingSupport();

	/**
	 * @return indicates whether or not the cloud provider supports
	 *         images/templates
	 */
	boolean hasImageSupport();

	/**
	 * @return indicates whether or not the cloud provider supports snapshotting
	 *         volumes
	 */
	boolean hasSnapshotSupport();

	/**
	 * @return indicates whether or not the cloud provider supports virtual
	 *         machines
	 */
	boolean hasVirtualMachineSupport();

	/**
	 * @return indicates whether or not the cloud provider supports block or
	 *         network volumes
	 */
	boolean hasVolumeSupport();

}
