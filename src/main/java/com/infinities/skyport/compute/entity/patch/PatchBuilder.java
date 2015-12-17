package com.infinities.skyport.compute.entity.patch;

import org.apache.commons.lang3.builder.DiffResult;

public interface PatchBuilder<T> {

	DiffResult diff(T old, T updated);

}
