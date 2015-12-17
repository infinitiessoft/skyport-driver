package com.infinities.skyport.compute.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "RESOURCEPOOL", schema = "PUBLIC", catalog = "PUBLIC")
public class ResourcePool extends AbstractVirtEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public enum Status {
		Up, Down, Unknown
	}


	private String name;
	private String resourceid;
	private String datacenterid;
	private String hypervisortype;
	@Enumerated(EnumType.STRING)
	private Status status;


	public ResourcePool() {
		super();
	}

	public ResourcePool(String name, String resourceId, String description, String dataCenterId, String hypervisorType,
			Status status) {
		super(description);
		this.name = name;
		this.resourceid = resourceId;
		this.datacenterid = dataCenterId;
		this.hypervisortype = hypervisorType;
		this.status = status;
	}

	@Column(name = "NAME", length = 150)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "RESOURCEID", length = 150)
	public String getResourceid() {
		return resourceid;
	}

	public void setResourceid(String resourceid) {
		this.resourceid = resourceid;
	}

	@Column(name = "DATACENTERID", length = 150)
	public String getDatacenterid() {
		return datacenterid;
	}

	public void setDatacenterid(String datacenterid) {
		this.datacenterid = datacenterid;
	}

	@Column(name = "HYPERVISORTYPE", length = 150)
	public String getHypervisortype() {
		return hypervisortype;
	}

	public void setHypervisortype(String hypervisortype) {
		this.hypervisortype = hypervisortype;
	}

	@Column(name = "STATUS", length = 20)
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((datacenterid == null) ? 0 : datacenterid.hashCode());
		result = prime * result + ((hypervisortype == null) ? 0 : hypervisortype.hashCode());
		result = prime * result + ((resourceid == null) ? 0 : resourceid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ResourcePool other = (ResourcePool) obj;
		if (datacenterid == null) {
			if (other.datacenterid != null) {
				return false;
			}
		} else if (!datacenterid.equals(other.datacenterid)) {
			return false;
		}
		if (hypervisortype == null) {
			if (other.hypervisortype != null) {
				return false;
			}
		} else if (!hypervisortype.equals(other.hypervisortype)) {
			return false;
		}
		if (resourceid == null) {
			if (other.resourceid != null) {
				return false;
			}
		} else if (!resourceid.equals(other.resourceid)) {
			return false;
		}
		return true;
	}

}
