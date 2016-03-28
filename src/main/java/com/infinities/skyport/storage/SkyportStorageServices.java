package com.infinities.skyport.storage;

import javax.annotation.Nullable;

import org.dasein.cloud.storage.OfflineStoreSupport;

public interface SkyportStorageServices {

	@Nullable
	OfflineStoreSupport getOfflineStorageSupport();

	@Nullable
	SkyportBlobStoreSupport getSkyportOnlineStorageSupport();

	boolean hasOfflineStorageSupport();

	boolean hasOnlineStorageSupport();
}
