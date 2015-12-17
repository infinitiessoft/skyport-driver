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
import org.dasein.cloud.compute.VolumeProduct;
import org.dasein.util.uom.storage.Gigabyte;
import org.dasein.util.uom.storage.Storage;

public class VolumeProductPatchBuilder implements PatchBuilder<VolumeProduct> {

	@Override
	public DiffResult diff(VolumeProduct old, VolumeProduct updated) {
		float oldMaxIopsRatio = old.getMaxIopsRatio() == null ? 0 : old.getMaxIopsRatio().floatValue();
		float updatedMaxIopsRatio = updated.getMaxIopsRatio() == null ? 0 : updated.getMaxIopsRatio().floatValue();
		DiffResult diff = new DiffBuilder(new VolumeProductProxy(old), new VolumeProductProxy(updated),
				ToStringStyle.SHORT_PREFIX_STYLE).append("maxIopsRatio", oldMaxIopsRatio, updatedMaxIopsRatio)
				.append("maxVolumeSize", old.getMaxVolumeSize(), updated.getMaxVolumeSize())
				.append("minVolumeSize", old.getMinVolumeSize(), updated.getMinVolumeSize()).build();
		return diff;
	}


	private class VolumeProductProxy {

		private VolumeProduct inner;


		public VolumeProductProxy(VolumeProduct inner) {
			super();
			this.inner = inner;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((inner == null) ? 0 : inner.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			VolumeProductProxy other = (VolumeProductProxy) obj;
			if (inner == null) {
				if (other.inner != null) {
					return false;
				}
			} else if (!inner.equals(other.inner)) {
				return false;
			}
			if (inner != null && inner.getMaxIopsRatio() == null) {
				if (other.getMaxIopsRatio() != null) {
					return false;
				}
			} else if (!getMaxIopsRatio().equals(other.getMaxIopsRatio())) {
				return false;
			}
			if (inner.getMinVolumeSize() == null) {
				if (other.getMinVolumeSize() != null) {
					return false;
				}
			} else if (!getMinVolumeSize().equals(other.getMinVolumeSize())) {
				return false;
			}
			if (inner.getMaxVolumeSize() == null) {
				if (other.getMaxVolumeSize() != null) {
					return false;
				}
			} else if (!getMaxVolumeSize().equals(other.getMaxVolumeSize())) {
				return false;
			}

			return true;
		}

		public Storage<Gigabyte> getMinVolumeSize() {
			return inner.getMinVolumeSize();
		}

		public Storage<Gigabyte> getMaxVolumeSize() {
			return inner.getMaxVolumeSize();
		}

		public Float getMaxIopsRatio() {
			return inner.getMaxIopsRatio();
		}

		@Override
		public String toString() {
			return inner.toString();
		}

		private VolumeProductPatchBuilder getOuterType() {
			return VolumeProductPatchBuilder.this;
		}

	}

}
