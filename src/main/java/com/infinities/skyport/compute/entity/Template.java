package com.infinities.skyport.compute.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.infinities.skyport.compute.ITemplate;

@Entity
@Table(name = "TEMPLATE", schema = "PUBLIC", catalog = "PUBLIC"
// , uniqueConstraints = { @UniqueConstraint(columnNames = {
// "CONFIG", "TEMPLATEID" }) }
)
public class Template extends ComputeObject implements ITemplate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Template() {
		super();
	}

	public Template(String templateId, String name, long memorySize, String operatingSystem, int numOfSockets,
			Date creationDate, String desc, String hostclusterId, String vmType, String hypervisorType, String status) {
		super(numOfSockets, memorySize, creationDate, templateId, hostclusterId, operatingSystem, name, hypervisorType,
				vmType, status, desc);
	}

}
