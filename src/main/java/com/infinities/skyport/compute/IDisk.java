package com.infinities.skyport.compute;

import java.util.Date;

public interface IDisk extends IAbstractVirtEntity {

	String getSnapshotid();

	Long getSizegb();

	Long getTruesize();

	Long getApparentsize();

	Double getReadrate();

	Double getWriterate();

	String getStatus();

	String getVolumeformat();

	String getVolumetype();

	String getDisktype();

	Date getCreationdate();

	String getInternaldrivemapping();

	Boolean getBoot();

	String getDiskinterface();

	String getWipeafterdelete();

	String getPropagateerrors();

	String getDiskid();

	String getName();

	Long getActualsizegb();

	String getInstanceid();

	String getInstancetype();

	IComputeObject getTemplateBaseEntity();
}
