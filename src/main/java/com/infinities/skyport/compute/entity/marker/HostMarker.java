package com.infinities.skyport.compute.entity.marker;

import javax.xml.bind.annotation.XmlTransient;

import com.infinities.skyport.compute.entity.Host;

public class HostMarker {

	@XmlTransient
	private Host host;


	public HostMarker() {

	}

	public HostMarker(Host host) {
		this.host = host;
	}

	public String getType() {
		return "HOST";
	}

	public String getId() {
		return host.getHostid();
	}

	public double getCpusys() {
		return host.getStatistics().getCpusys();
	}

	public double getCpuuser() {
		return host.getStatistics().getCpuuser();
	}

	public double getMemusage() {
		return host.getStatistics().getMemusage();
	}

	public String getName() {
		return host.getName();
	}

	public String getStatus() {
		return host.getStatus();
	}
}
