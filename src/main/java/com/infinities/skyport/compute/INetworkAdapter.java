package com.infinities.skyport.compute;

import com.infinities.skyport.compute.entity.NetworkStatistics;

public interface INetworkAdapter extends IAbstractVirtEntity {

	String getMac();

	String getName();

	Integer getSpeed();

	Integer getLinespeed();

	String getState();

	String getType();

	String getNicid();

	Integer getVlanid();

	String getNetwork();

	IComputeObject getTemplateBaseEntity();

	String getInstanceid();

	String getInstancetype();

	String getIp();

	NetworkStatistics getStatistics();
}
