package com.infinities.skyport.compute;

import java.util.Date;
import java.util.Set;

public interface IComputeObject extends IAbstractVirtEntity {

	Integer getCpunum();

	Long getMemorysize();

	Set<? extends IDisk> getDisks();

	Set<? extends INetworkAdapter> getNics();

	Date getCreationdate();

	String getOs();

	String getName();

	String getResourceid();

	String getTemplateid();

	String getVmtype();

	String getHypervisortype();

	String getStatus();

}
