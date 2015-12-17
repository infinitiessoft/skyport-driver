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
import org.dasein.cloud.compute.ComputeServices;
import org.dasein.cloud.dc.DataCenterServices;
import org.dasein.cloud.identity.IdentityServices;
import org.dasein.cloud.network.NetworkServices;
import org.dasein.cloud.platform.PlatformServices;
import org.dasein.cloud.storage.StorageServices;
import org.dasein.cloud.util.NamingConstraints;
import org.dasein.cloud.util.ResourceNamespace;

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

	StorageServices getStorageServices() throws ConcurrentException;

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
	DataCenterServices getDataCenterServices() throws ConcurrentException;

	@Nullable
	CIServices getCIServices() throws ConcurrentException;

	@Nullable
	ComputeServices getComputeServices() throws ConcurrentException;

	@Nullable
	IdentityServices getIdentityServices() throws ConcurrentException;

	@Nullable
	NetworkServices getNetworkServices() throws ConcurrentException;

	@Nullable
	PlatformServices getPlatformServices() throws ConcurrentException;

	@Nonnull
	String getProviderName();

	@Nullable
	String findUniqueName(@Nonnull String baseName, @Nonnull NamingConstraints constraints,
			@Nonnull ResourceNamespace namespace) throws CloudException, InternalException;

	void close();

}
