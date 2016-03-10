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
package com.infinities.skyport;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.dasein.cloud.CloudException;
import org.dasein.cloud.CloudProvider;
import org.dasein.cloud.ContextRequirements;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.ProviderContext;
import org.dasein.cloud.admin.AdminServices;
import org.dasein.cloud.ci.CIServices;
import org.dasein.cloud.identity.IdentityServices;
import org.dasein.cloud.platform.PlatformServices;
import org.dasein.cloud.util.NamingConstraints;
import org.dasein.cloud.util.ResourceNamespace;

import com.infinities.skyport.compute.SkyportComputeServices;
import com.infinities.skyport.dc.SkyportDataCenterServices;
import com.infinities.skyport.network.SkyportNetworkServices;
import com.infinities.skyport.storage.SkyportStorageServices;

/**
 * This is a customized version of org.dasein.cloud.CloudService.
 * <p>
 * Created by Pohsun Huang: 12/23/15 10:57 AM
 * </p>
 * 
 * @author Pohsun Huang
 * @version 2015.12 initial version
 * @since 2015.12
 */
public interface ServiceProvider {

	void initialize() throws ConcurrentException;

	String testContext();

	boolean isConnected();

	boolean hasAdminServices();

	boolean hasCIServices();

	boolean hasComputeServices();

	boolean hasIdentityServices();

	boolean hasNetworkServices();

	boolean hasPlatformServices();

	boolean hasStorageServices();

	SkyportStorageServices getSkyportStorageServices() throws ConcurrentException;

	@Nullable
	AdminServices getAdminServices() throws ConcurrentException;

	CloudProvider getComputeCloud();

	@Nullable
	ProviderContext getContext();

	@Nonnull
	ContextRequirements getContextRequirements();

	@Nonnull
	String getCloudName();

	@Nonnull
	SkyportDataCenterServices getSkyportDataCenterServices() throws ConcurrentException;

	@Nullable
	CIServices getCIServices() throws ConcurrentException;

	@Nullable
	SkyportComputeServices getSkyportComputeServices() throws ConcurrentException;

	@Nullable
	IdentityServices getIdentityServices() throws ConcurrentException;

	@Nullable
	SkyportNetworkServices getSkyportNetworkServices() throws ConcurrentException;

	@Nullable
	PlatformServices getPlatformServices() throws ConcurrentException;

	@Nonnull
	String getProviderName();

	@Nullable
	String findUniqueName(@Nonnull String baseName, @Nonnull NamingConstraints constraints,
			@Nonnull ResourceNamespace namespace) throws CloudException, InternalException;

	void close();

}
