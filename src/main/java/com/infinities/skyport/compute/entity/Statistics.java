package com.infinities.skyport.compute.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.infinities.skyport.compute.entity.adapter.DoubleAdapter;

public class Statistics implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlJavaTypeAdapter(value = DoubleAdapter.class)
	private Double memusage = 0.00d;
	@XmlJavaTypeAdapter(value = DoubleAdapter.class)
	private Double cpuuser = 0.00d;
	@XmlJavaTypeAdapter(value = DoubleAdapter.class)
	private Double cpusys = 0.00d;


	public Statistics() {
		super();
	}

	public Statistics(Double memUsage, Double cpuUser, Double cpuSys) {
		super();
		this.memusage = memUsage;
		this.cpuuser = cpuUser;
		this.cpusys = cpuSys;
	}

	public Double getMemusage() {
		return memusage;
	}

	public void setMemusage(Double memusage) {
		this.memusage = memusage;
	}

	public Double getCpuuser() {
		return cpuuser;
	}

	public void setCpuuser(Double cpuuser) {
		this.cpuuser = cpuuser;
	}

	public Double getCpusys() {
		return cpusys;
	}

	public void setCpusys(Double cpusys) {
		this.cpusys = cpusys;
	}

}
