///*******************************************************************************
// * Copyright 2015 InfinitiesSoft Solutions Inc.
// *
// * Licensed under the Apache License, Version 2.0 (the "License"); you may
// * not use this file except in compliance with the License. You may obtain
// * a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
// * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
// * License for the specific language governing permissions and limitations
// * under the License.
// *******************************************************************************/
//package com.infinities.skyport.compute.entity.marker;
//
//import javax.xml.bind.annotation.XmlTransient;
//
//import com.infinities.skyport.compute.entity.Host;
//
//public class HostMarker {
//
//	@XmlTransient
//	private Host host;
//
//
//	public HostMarker() {
//
//	}
//
//	public HostMarker(Host host) {
//		this.host = host;
//	}
//
//	public String getType() {
//		return "HOST";
//	}
//
//	public String getId() {
//		return host.getHostid();
//	}
//
//	public double getCpusys() {
//		return host.getStatistics().getCpusys();
//	}
//
//	public double getCpuuser() {
//		return host.getStatistics().getCpuuser();
//	}
//
//	public double getMemusage() {
//		return host.getStatistics().getMemusage();
//	}
//
//	public String getName() {
//		return host.getName();
//	}
//
//	public String getStatus() {
//		return host.getStatus();
//	}
// }
