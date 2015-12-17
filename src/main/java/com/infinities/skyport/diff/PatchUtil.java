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
package com.infinities.skyport.diff;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.builder.Diff;
import org.apache.commons.lang3.builder.DiffResult;
import org.dasein.cloud.Tag;
import org.dasein.cloud.VisibleScope;
import org.dasein.cloud.compute.Architecture;
import org.dasein.cloud.compute.ImageClass;
import org.dasein.cloud.compute.MachineImage;
import org.dasein.cloud.compute.MachineImageFormat;
import org.dasein.cloud.compute.MachineImageState;
import org.dasein.cloud.compute.MachineImageType;
import org.dasein.cloud.compute.MachineImageVolume;
import org.dasein.cloud.compute.Platform;
import org.dasein.cloud.compute.Snapshot;
import org.dasein.cloud.compute.VirtualMachine;
import org.dasein.cloud.compute.VirtualMachineProduct;
import org.dasein.cloud.compute.VirtualMachineProduct.Status;
import org.dasein.cloud.compute.Volume;
import org.dasein.cloud.compute.VolumeProduct;
import org.dasein.cloud.compute.VolumeType;
import org.dasein.util.uom.storage.Gigabyte;
import org.dasein.util.uom.storage.Megabyte;
import org.dasein.util.uom.storage.Storage;

public class PatchUtil {

	private static <T, E> void patch(List<Diff<?>> diffs, T destination) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		for (Diff<?> diff : diffs) {
			PropertyUtils.setProperty(destination, diff.getFieldName(), diff.getRight());
		}
	}

	public static void apply(DiffResult diffResult, VirtualMachine destination) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		patch(diffResult.getDiffs(), destination);
	}

	public static void apply(DiffResult diffResult, VirtualMachineProduct destination) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		patch(diffResult.getDiffs(), new VirtualMachineProductProxy(destination));
	}

	public static void apply(DiffResult diffResult, MachineImage destination) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		patch(diffResult.getDiffs(), new MachineImageProxy(destination));
	}

	public static void apply(DiffResult diffResult, Volume destination) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		patch(diffResult.getDiffs(), destination);
	}

	public static void apply(DiffResult diffResult, Snapshot destination) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		patch(diffResult.getDiffs(), destination);
	}

	public static void apply(DiffResult diffResult, VolumeProduct destination) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		patch(diffResult.getDiffs(), new VolumeProductProxy(destination));
	}


	public static class VolumeProductProxy {

		private VolumeProduct inner;


		public VolumeProductProxy(VolumeProduct inner) {
			super();
			this.inner = inner;
		}

		public VolumeProduct withMaxIopsRatio(float ratio) {
			return inner.withMaxIopsRatio(ratio);
		}

		public VolumeProduct withMinVolumeSize(Storage<Gigabyte> size) {
			return inner.withMinVolumeSize(size);
		}

		public VolumeProduct withMaxVolumeSize(Storage<Gigabyte> size) {
			return inner.withMaxVolumeSize(size);
		}

		public String getCurrency() {
			return inner.getCurrency();
		}

		public String getDescription() {
			return inner.getDescription();
		}

		public int getMaxIops() {
			return inner.getMaxIops();
		}

		public int getMinIops() {
			return inner.getMinIops();
		}

		public Float getIopsCost() {
			return inner.getIopsCost();
		}

		public String getName() {
			return inner.getName();
		}

		public Float getMonthlyGigabyteCost() {
			return inner.getMonthlyGigabyteCost();
		}

		public String getProviderProductId() {
			return inner.getProviderProductId();
		}

		public VolumeType getType() {
			return inner.getType();
		}

		@SuppressWarnings("deprecation")
		public Storage<Gigabyte> getVolumeSize() {
			return inner.getVolumeSize();
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

		public void setMaxIopsRatio(@Nonnull Float maxIopsRatio) {
			inner.withMaxIopsRatio(maxIopsRatio);
		}

		public void setMinVolumeSize(Storage<Gigabyte> size) {
			inner.withMinVolumeSize(size);
		}

		public void setMaxVolumeSize(Storage<Gigabyte> size) {
			inner.withMaxVolumeSize(size);
		}

	}

	public static class VirtualMachineProductProxy {

		private VirtualMachineProduct inner;


		public VirtualMachineProductProxy(VirtualMachineProduct inner) {
			this.inner = inner;
		}

		public String getName() {
			return inner.getName();
		}

		public void setName(String name) {
			inner.setName(name);
		}

		public int getCpuCount() {
			return inner.getCpuCount();
		}

		public void setCpuCount(int cpuCount) {
			inner.setCpuCount(cpuCount);
		}

		public String getDescription() {
			return inner.getDescription();
		}

		public void setDescription(String description) {
			inner.setDescription(description);
		}

		public String getProviderProductId() {
			return inner.getProviderProductId();
		}

		public void setProviderProductId(String providerProductId) {
			inner.setProviderProductId(providerProductId);
		}

		public org.dasein.util.uom.storage.Storage<Gigabyte> getRootVolumeSize() {
			return inner.getRootVolumeSize();
		}

		public void setRootVolumeSize(org.dasein.util.uom.storage.Storage<?> rootVolumeSize) {
			inner.setRootVolumeSize(rootVolumeSize);
		}

		public org.dasein.util.uom.storage.Storage<Megabyte> getRamSize() {
			return inner.getRamSize();
		}

		public void setRamSize(org.dasein.util.uom.storage.Storage<?> ramSize) {
			inner.setRamSize(ramSize);
		}

		public float getStandardHourlyRate() {
			return inner.getStandardHourlyRate();
		}

		public void setStandardHourlyRate(float standardHourlyRate) {
			inner.setStandardHourlyRate(standardHourlyRate);
		}

		public void setVisibleScope(VisibleScope visibleScope) {
			inner.setVisibleScope(visibleScope);
		}

		public VisibleScope getVisibleScope() {
			return inner.getVisibleScope();
		}

		public String getDataCenterId() {
			return inner.getDataCenterId();
		}

		public void setDataCenterId(String dataCenterId) {
			inner.setDataCenterId(dataCenterId);
		}

		public Status getStatus() {
			return inner.getStatus();
		}

		public void setStatusDeprecated() {
			inner.setStatusDeprecated();
		}

		public void setArchitectures(Architecture... architectures) {
			inner.setArchitectures(architectures);
		}

		public Architecture[] getArchitectures() {
			return inner.getArchitectures();
		}

		public Map<String, String> getProviderMetadata() {
			return inner.getProviderMetadata();
		}

		public void setProviderMetadata(Map<String, String> providerMetadata) {
			inner.getProviderMetadata().clear();
			inner.setProviderMetadata(providerMetadata);
		}

		public void setStatus(Status status) {
			if (Status.DEPRECATED.equals(status)) {
				inner.setStatusDeprecated();
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static class MachineImageProxy {

		private MachineImage inner;


		public MachineImageProxy(MachineImage inner) {
			this.inner = inner;
		}

		public MachineImage associatedWith(String kernelImageId) {
			return inner.associatedWith(kernelImageId);
		}

		public MachineImage constrainedTo(String dataCenterId) {
			return inner.constrainedTo(dataCenterId);
		}

		public MachineImage createdAt(long timestamp) {
			return inner.createdAt(timestamp);
		}

		public MachineImage withType(MachineImageType type) {
			return inner.withType(type);
		}

		public MachineImage withStorageFormat(MachineImageFormat format) {
			return inner.withStorageFormat(format);
		}

		public Architecture getArchitecture() {
			return inner.getArchitecture();
		}

		public long getCreationTimestamp() {
			return inner.getCreationTimestamp();
		}

		public MachineImageState getCurrentState() {
			return inner.getCurrentState();
		}

		public String getDescription() {
			return inner.getDescription();
		}

		public ImageClass getImageClass() {
			return inner.getImageClass();
		}

		public String getKernelImageId() {
			return inner.getKernelImageId();
		}

		public String getName() {
			return inner.getName();
		}

		public Platform getPlatform() {
			return inner.getPlatform();
		}

		public String getProviderDataCenterId() {
			return inner.getProviderDataCenterId();
		}

		public String getProviderMachineImageId() {
			return inner.getProviderMachineImageId();
		}

		public String getProviderOwnerId() {
			return inner.getProviderOwnerId();
		}

		public String getProviderRegionId() {
			return inner.getProviderRegionId();
		}

		public String getSoftware() {
			return inner.getSoftware();
		}

		public MachineImageFormat getStorageFormat() {
			return inner.getStorageFormat();
		}

		public Object getTag(String tag) {
			return inner.getTag(tag);
		}

		public Map<String, String> getTags() {
			return inner.getTags();
		}

		public MachineImageType getType() {
			return inner.getType();
		}

		public VisibleScope getVisibleScope() {
			return inner.getVisibleScope();
		}

		public MachineImage withVisibleScope(VisibleScope visibleScope) {
			return inner.withVisibleScope(visibleScope);
		}

		@Override
		public int hashCode() {
			return inner.hashCode();
		}

		public void setTag(String key, String value) {
			inner.setTag(key, value);
		}

		public void setTags(Map<String, String> properties) {
			inner.setTags(properties);
		}

		public Iterable<MachineImageVolume> getVolumes() {
			return inner.getVolumes();
		}

		public MachineImage withVolumes(Iterable<MachineImageVolume> volumes) {
			return inner.withVolumes(volumes);
		}

		@Override
		public String toString() {
			return inner.toString();
		}

		public MachineImage withSoftware(String software) {
			return inner.withSoftware(software);
		}

		public MachineImage sharedWithPublic() {
			return inner.sharedWithPublic();
		}

		public boolean isPublic() {
			return inner.isPublic();
		}

		public Map<String, String> getProviderMetadata() {
			return inner.getProviderMetadata();
		}

		public MachineImage withProviderMetadata(Map<String, String> providerMetadata) {
			return inner.withProviderMetadata(providerMetadata);
		}

		public void addTag(Tag t) {
			inner.addTag(t);
		}

		public void addTag(String key, String value) {
			inner.addTag(key, value);
		}

		public void setArchitecture(Architecture architecture) {
			inner.setArchitecture(architecture);
		}

		public void setCreationTimestamp(long creationTimestamp) {
			inner.setCreationTimestamp(creationTimestamp);
		}

		public void setCurrentState(MachineImageState currentState) {
			inner.setCurrentState(currentState);
		}

		public void setDescription(String description) {
			inner.setDescription(description);
		}

		public void setImageClass(ImageClass imageClass) {
			inner.setImageClass(imageClass);
		}

		public void setKernelImageId(String kernelImageId) {
			inner.setKernelImageId(kernelImageId);
		}

		public void setName(String name) {
			inner.setName(name);
		}

		public void setPlatform(Platform platform) {
			inner.setPlatform(platform);
		}

		public void setProviderMachineImageId(String providerMachineImageId) {
			inner.setProviderMachineImageId(providerMachineImageId);
		}

		public void setProviderOwnerId(String providerOwnerId) {
			inner.setProviderOwnerId(providerOwnerId);
		}

		public void setProviderRegionId(String providerRegionId) {
			inner.setProviderRegionId(providerRegionId);
		}

		public void setSoftware(String software) {
			inner.setSoftware(software);
		}

		public void setStorageFormat(MachineImageFormat storageFormat) {
			inner.setStorageFormat(storageFormat);
		}

		public void setType(MachineImageType type) {
			inner.setType(type);
		}

		public void setVisibleScope(VisibleScope visibleScope) {
			inner.setVisibleScope(visibleScope);
		}

		public long getMinimumDiskSizeGb() {
			return inner.getMinimumDiskSizeGb();
		}

		public void setMinimumDiskSizeGb(long minimumDiskSizeGb) {
			inner.setMinimumDiskSizeGb(minimumDiskSizeGb);
		}

		public void setProviderDataCenterId(String providerDataCenterId) {
			inner.constrainedTo(providerDataCenterId);
		}

		public void setProviderMetadata(Map<String, String> providerMetadata) {
			inner.getProviderMetadata().clear();
			inner.withProviderMetadata(providerMetadata);
		}

		public void setVolumes(Iterable<MachineImageVolume> volumes) {
			inner.withVolumes(volumes);
		}

	}

}
