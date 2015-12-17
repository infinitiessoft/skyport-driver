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
