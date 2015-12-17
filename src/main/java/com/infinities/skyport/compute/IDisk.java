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
