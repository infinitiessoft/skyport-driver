package com.infinities.skyport.compute.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.infinities.skyport.compute.entity.adapter.BooleanAdapter;

@Entity
@Table(name = "NETWORK", schema = "PUBLIC", catalog = "PUBLIC")
public class Network extends AbstractVirtEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String networkid;
	private String name;
	private String status;
	private String datacenterid;
	@XmlJavaTypeAdapter(value = BooleanAdapter.class)
	private Boolean isdisplay;
	private String resourceid;

	// for cake
	@Transient
	@XmlTransient
	private String vmId;


	public Network() {
		super();
	}

	public Network(String networkId, String desc, String name, String status, String dataCenterId, boolean isDisplay) {
		super(desc);
		this.networkid = networkId;
		this.name = name;
		this.status = status;
		this.datacenterid = dataCenterId;
		this.isdisplay = isDisplay;
	}

	@Column(name = "NETWORKID", length = 150)
	public String getNetworkid() {
		return networkid;
	}

	public void setNetworkid(String networkid) {
		this.networkid = networkid;
	}

	@Column(name = "NAME", length = 150)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "STATUS", length = 256)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "DATACENTERID", length = 150)
	public String getDatacenterid() {
		return datacenterid;
	}

	public void setDatacenterid(String datacenterid) {
		this.datacenterid = datacenterid;
	}

	@Column(name = "ISDISPLAY")
	public Boolean getIsdisplay() {
		return isdisplay;
	}

	public void setIsdisplay(Boolean isdisplay) {
		this.isdisplay = isdisplay;
	}

	@Transient
	@XmlTransient
	public String getVmId() {
		return vmId;
	}

	@XmlTransient
	public void setVmId(String vmId) {
		this.vmId = vmId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((datacenterid == null) ? 0 : datacenterid.hashCode());
		result = prime * result + ((networkid == null) ? 0 : networkid.hashCode());
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
		Network other = (Network) obj;
		if (datacenterid == null) {
			if (other.datacenterid != null) {
				return false;
			}
		} else if (!datacenterid.equals(other.datacenterid)) {
			return false;
		}
		if (networkid == null) {
			if (other.networkid != null) {
				return false;
			}
		} else if (!networkid.equals(other.networkid)) {
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

	public String getResourceid() {
		return resourceid;
	}

	public void setResourceid(String resourceid) {
		this.resourceid = resourceid;
	}

}
