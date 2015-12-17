package com.infinities.skyport.compute.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.infinities.skyport.compute.entity.comparator.IDiskComparator;

public class Disks implements Set<Disk>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Set<Disk> delegate;


	public Disks() {
		delegate = new HashSet<Disk>();
	}

	public Disks(Collection<Disk> c) {
		delegate = new HashSet<Disk>(c);
	}

	public Disks(int size) {
		delegate = new HashSet<Disk>(size);
	}

	@Override
	public boolean add(Disk e) {
		return delegate.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends Disk> c) {
		return delegate.addAll(c);
	}

	@Override
	public void clear() {
		delegate.clear();
	}

	@Override
	public boolean contains(Object o) {
		return delegate.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return delegate.containsAll(c);
	}

	@Override
	public boolean isEmpty() {
		return delegate.isEmpty();
	}

	@Override
	public Iterator<Disk> iterator() {
		return delegate.iterator();
	}

	@Override
	public boolean remove(Object o) {
		return delegate.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return delegate.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return delegate.retainAll(c);
	}

	@Override
	public int size() {
		return delegate.size();
	}

	@Override
	public Object[] toArray() {
		return delegate.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return delegate.toArray(a);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((delegate == null) ? 0 : delegate.hashCode());
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
		Disks other = (Disks) obj;
		if (delegate == null) {
			if (other.delegate != null) {
				return false;
			}
		} else {
			if (this.size() != other.size()) {
				return false;
			} else {
				Map<String, Disk> aDiskMap = new HashMap<String, Disk>();
				Map<String, Disk> bDiskMap = new HashMap<String, Disk>();
				for (Disk disk : this) {
					aDiskMap.put(disk.getDiskid(), disk);
				}
				for (Disk disk : other) {
					bDiskMap.put(disk.getDiskid(), disk);
				}
				int basic = aDiskMap.keySet().containsAll(bDiskMap.keySet()) ? 0 : 1;
				if (basic != 0) {
					return false;
				}
				for (Disk disk : this) {
					Disk bdisk = bDiskMap.get(disk.getDiskid());
					basic = comparaDisk(disk, bdisk);
					if (basic != 0) {
						return false;
					}
				}
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return delegate.toString();
	}

	private int comparaDisk(Disk disk, Disk bdisk) {
		return new IDiskComparator().compare(disk, bdisk);
	}
}
