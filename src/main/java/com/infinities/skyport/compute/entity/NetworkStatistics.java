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
package com.infinities.skyport.compute.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.infinities.skyport.compute.entity.adapter.DoubleAdapter;

public class NetworkStatistics implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6903916110193904183L;

	@XmlJavaTypeAdapter(value = DoubleAdapter.class)
	private Double rxdropped = 0.00d;
	@XmlJavaTypeAdapter(value = DoubleAdapter.class)
	private Double rxrate = 0.00d;
	@XmlJavaTypeAdapter(value = DoubleAdapter.class)
	private Double txdropped = 0.00d;
	@XmlJavaTypeAdapter(value = DoubleAdapter.class)
	private Double txrate = 0.00d;

	@XmlTransient
	@Transient
	private Calendar startTime;
	@XmlTransient
	@Transient
	private Calendar endTime;


	public NetworkStatistics() {
		super();
	}

	public NetworkStatistics(Double rxDropped, Double rxRate, Double txDropped, Double txRate) {
		this.rxdropped = rxDropped;
		this.rxrate = rxRate;
		this.txdropped = txDropped;
		this.txrate = txRate;
	}

	@Column(name = "RXDROPPED", length = 20)
	public Double getRxdropped() {
		return rxdropped;
	}

	public Double getRxdrop() {
		return rxdropped;
	}

	public void setRxdropped(Double rxdropped) {
		this.rxdropped = rxdropped;
	}

	@Column(name = "RXRATE", length = 20)
	public Double getRxrate() {
		return rxrate;
	}

	public void setRxrate(Double rxrate) {
		this.rxrate = rxrate;
	}

	@Column(name = "TXDROPPED", length = 20)
	public Double getTxdropped() {
		return txdropped;
	}

	@Transient
	public Double getTxdrop() {
		return txdropped;
	}

	public void setTxdropped(Double txdropped) {
		this.txdropped = txdropped;
	}

	@Column(name = "TXRATE", length = 20)
	public Double getTxrate() {
		return txrate;
	}

	public void setTxrate(Double txrate) {
		this.txrate = txrate;
	}

	@XmlTransient
	@Transient
	public Calendar getStartTime() {
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	@XmlTransient
	@Transient
	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

}
