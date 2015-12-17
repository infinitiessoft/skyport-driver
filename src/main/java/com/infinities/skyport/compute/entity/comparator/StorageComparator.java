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
package com.infinities.skyport.compute.entity.comparator;

import java.util.Comparator;

import org.dasein.util.uom.storage.Storage;

public class StorageComparator implements Comparator<Storage<?>> {

	@Override
	public int compare(Storage<?> a, Storage<?> b) {
		if (a == b) {
			return 0;
		}
		if (a == null) {
			return -1;
		}
		if (b == null) {
			return 1;
		}
		if (a.getUnitOfMeasure() == null) {
			return -1;
		}
		if (b.getUnitOfMeasure() == null) {
			return 1;
		}
		if (!a.getUnitOfMeasure().equals(b.getUnitOfMeasure())) {
			return -1;
		}

		if (a.getQuantity() == null) {
			return -1;
		}

		if (b.getQuantity() == null) {
			return 1;
		}
		if (a.getQuantity().doubleValue() != b.getQuantity().doubleValue()) {
			return -1;
		}

		return 0;
	}

}
