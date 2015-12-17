package com.infinities.skyport.compute.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class AddressResolution implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "MacAddress")
	private String macAddress;

	@XmlElement(name = "IpAddress")
	private String ipAddress;


	public AddressResolution() {
		super();
	}

	public AddressResolution(String macAddress, String ipAddress) {
		super();
		this.macAddress = macAddress;
		this.ipAddress = ipAddress;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

}
