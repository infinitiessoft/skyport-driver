package com.infinities.skyport.compute.entity.adapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.infinities.skyport.compute.entity.NetworkAdapter;

public class NetworkAdapterAdapter extends XmlAdapter<List<Map<String, NetworkAdapter>>, Set<NetworkAdapter>> implements
		Serializable {

	// private Logger logger =
	// LoggerFactory.getLogger(NetworkAdapterAdapter.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Set<NetworkAdapter> unmarshal(List<Map<String, NetworkAdapter>> v) throws Exception {
		if (v == null) {
			return null;
		}

		Set<NetworkAdapter> nics = new HashSet<NetworkAdapter>();
		for (Map<String, NetworkAdapter> entry : v) {
			for (NetworkAdapter nic : entry.values()) {
				nics.add(nic);
			}
		}

		return nics;
	}

	@Override
	public List<Map<String, NetworkAdapter>> marshal(Set<NetworkAdapter> v) throws Exception {
		List<Map<String, NetworkAdapter>> entrys = new ArrayList<Map<String, NetworkAdapter>>();
		for (NetworkAdapter nic : v) {
			Map<String, NetworkAdapter> map = new HashMap<String, NetworkAdapter>();
			map.put(nic.getNicid(), nic);
			entrys.add(map);
		}

		return entrys;
	}

}
