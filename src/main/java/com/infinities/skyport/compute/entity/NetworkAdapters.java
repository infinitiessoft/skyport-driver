package com.infinities.skyport.compute.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.infinities.skyport.compute.entity.comparator.INetworkAdapterComparator;

public class NetworkAdapters implements Set<NetworkAdapter>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Set<NetworkAdapter> delegate;


	public NetworkAdapters() {
		delegate = new HashSet<NetworkAdapter>();
	}

	public NetworkAdapters(int size) {
		delegate = new HashSet<NetworkAdapter>(size);
	}

	public NetworkAdapters(Collection<NetworkAdapter> set) {
		delegate = new HashSet<NetworkAdapter>(set);
	}

	@Override
	public boolean add(NetworkAdapter e) {
		return delegate.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends NetworkAdapter> c) {
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
	public Iterator<NetworkAdapter> iterator() {
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
	public String toString() {
		return delegate.toString();
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
		NetworkAdapters other = (NetworkAdapters) obj;
		if (delegate == null) {
			if (other.delegate != null) {
				return false;
			}
		} else {
			if (this.size() != other.size()) {
				return false;
			} else {
				Map<String, NetworkAdapter> aDiskMap = new HashMap<String, NetworkAdapter>();
				Map<String, NetworkAdapter> bDiskMap = new HashMap<String, NetworkAdapter>();
				for (NetworkAdapter nic : this) {
					aDiskMap.put(nic.getNicid(), nic);
				}
				for (NetworkAdapter nic : other) {
					bDiskMap.put(nic.getNicid(), nic);
				}
				int basic = aDiskMap.keySet().containsAll(bDiskMap.keySet()) ? 0 : 1;
				if (basic != 0) {
					return false;
				}
				for (NetworkAdapter nic : this) {
					NetworkAdapter bnic = bDiskMap.get(nic.getNicid());
					basic = comparaDisk(nic, bnic);
					if (basic != 0) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private int comparaDisk(NetworkAdapter nic, NetworkAdapter bnic) {
		return new INetworkAdapterComparator().compare(nic, bnic);
	}
}
