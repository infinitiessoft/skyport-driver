package com.infinities.skyport.compute.entity.marker;

import javax.xml.bind.annotation.XmlTransient;

import com.infinities.skyport.compute.entity.Vm;

public class VmMarker {

	@XmlTransient
	private Vm vm;


	public VmMarker() {

	}

	public VmMarker(Vm vm) {
		this.vm = vm;
	}
	
	public String getType() {
		return "VM";
	}

	public String getId() {
		return vm.getVmid();
	}

	public double getCpusys() {
		return vm.getStatistics().getCpusys();
	}

	public double getCpuuser() {
		return vm.getStatistics().getCpuuser();
	}

	public double getMemusage() {
		return vm.getStatistics().getMemusage();
	}

	public String getName() {
		return vm.getName();
	}
	
	public String getStatus() {
		return vm.getStatus();
	}
}
