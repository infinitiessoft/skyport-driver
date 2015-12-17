package com.infinities.skyport.compute;

import com.infinities.skyport.compute.entity.Statistics;

public interface IVm extends IComputeObject {

	String LOCK = "Lock";


	String getVmid();

	String getRunningonhost();

	String getRunningonhostid();

	String getIp();

	String getCdisopath();

	String getInfo();

	Statistics getStatistics();

	// void setRunningonhostid(String runningonhostid);
}
