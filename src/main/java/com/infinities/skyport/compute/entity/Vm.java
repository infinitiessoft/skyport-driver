package com.infinities.skyport.compute.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonView;
import com.infinities.skyport.compute.IVm;
import com.infinities.skyport.view.Views;

@Entity
@Table(name = "VM", schema = "PUBLIC", catalog = "PUBLIC"
// , uniqueConstraints = { @UniqueConstraint(columnNames = { "CONFIG",
// "VMID" }) }
)
public class Vm extends ComputeObject implements IVm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String UP = "Up";
	public static final String POWERING_UP = "Powering_up";
	public static final String DOWN = "Down";
	// property for icloud
	// or hostId
	@JsonView(Views.Short.class)
	private String vmid;
	// hostId
	@JsonView(Views.Basic.class)
	private String runningonhostid;
	// hostName
	@JsonView(Views.Basic.class)
	private String runningonhost;
	@JsonView(Views.Basic.class)
	private String ip;
	@JsonView(Views.Basic.class)
	private String cdisopath;
	@JsonView(Views.Basic.class)
	private String info;

	@JsonView(Views.Basic.class)
	@Transient
	@JsonUnwrapped
	private Statistics statistics = new Statistics();

	// rhevm
	@Transient
	@XmlTransient
	private String domain;
	@Transient
	@XmlTransient
	private String displayType;
	@Transient
	@XmlTransient
	private String bootDevice;

	// openstack
	@Transient
	@XmlTransient
	private String flavorId;
	@Transient
	@XmlTransient
	private String keyName;

	// ec2
	@Transient
	@XmlTransient
	private String type;
	@Transient
	@XmlTransient
	private String group;
	@Transient
	@XmlTransient
	private String key;

	// azure
	@Transient
	@XmlTransient
	private String deploymentName;
	@Transient
	@XmlTransient
	private String adminUserName;
	@Transient
	@XmlTransient
	private String adminPassword;
	@Transient
	@XmlTransient
	private String storageAccountName;
	@Transient
	@XmlTransient
	private String storageAccountContainer;
	@Transient
	@XmlTransient
	private String userName;
	@Transient
	@XmlTransient
	private String userPassword;
	@Transient
	@XmlTransient
	private String osVHarddiskName;


	public Vm() {
		super();
	}

	public Vm(String templateId, String name, long memorySize, String operatingSystem, int numOfSockets, Date creationDate,
			String description, String hostclusterId, String vmType, String hypervisorType, String vmId, String status,
			String runningOnHostId, String ip, String cdIsoPath, String info, Statistics statistics) {
		super(numOfSockets, memorySize, creationDate, templateId, hostclusterId, operatingSystem, name, hypervisorType,
				vmType, status, description);
		this.vmid = vmId;
		this.runningonhostid = runningOnHostId;
		this.ip = ip;
		this.cdisopath = cdIsoPath;
		this.info = info;
		this.statistics = statistics;
	}

	@Override
	@Column(name = "VMID", length = 100)
	public String getVmid() {
		return vmid;
	}

	public void setVmid(String vmid) {
		this.vmid = vmid;
	}

	@Override
	@Transient
	public String getRunningonhostid() {
		return runningonhostid;
	}

	public void setRunningonhostid(String runningonhostid) {
		this.runningonhostid = runningonhostid;
	}

	@Override
	@Transient
	public String getRunningonhost() {
		return runningonhost;
	}

	public void setRunningonhost(String runningonhost) {
		this.runningonhost = runningonhost;
	}

	@Override
	@Column(name = "IP", length = 20)
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	@Transient
	public String getCdisopath() {
		return cdisopath;
	}

	public void setCdisopath(String cdisopath) {
		this.cdisopath = cdisopath;
	}

	@Override
	@Transient
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	@Transient
	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}

	@Transient
	@XmlTransient
	public String getDomain() {
		return domain;
	}

	@XmlTransient
	public void setDomain(String domain) {
		this.domain = domain;
	}

	@Transient
	@XmlTransient
	public String getDisplayType() {
		return displayType;
	}

	@XmlTransient
	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	@Transient
	@XmlTransient
	public String getBootDevice() {
		return bootDevice;
	}

	@XmlTransient
	public void setBootDevice(String bootDevice) {
		this.bootDevice = bootDevice;
	}

	@Transient
	@XmlTransient
	public String getFlavorId() {
		return flavorId;
	}

	@XmlTransient
	public void setFlavorId(String flavorId) {
		this.flavorId = flavorId;
	}

	@Transient
	@XmlTransient
	public String getKeyName() {
		return keyName;
	}

	@XmlTransient
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	@Transient
	@XmlTransient
	public String getType() {
		return type;
	}

	@XmlTransient
	public void setType(String type) {
		this.type = type;
	}

	@Transient
	@XmlTransient
	public String getGroup() {
		return group;
	}

	@XmlTransient
	public void setGroup(String group) {
		this.group = group;
	}

	@Transient
	@XmlTransient
	public String getKey() {
		return key;
	}

	@XmlTransient
	public void setKey(String key) {
		this.key = key;
	}

	@Transient
	@XmlTransient
	public String getDeploymentName() {
		return deploymentName;
	}

	@XmlTransient
	public void setDeploymentName(String deploymentName) {
		this.deploymentName = deploymentName;
	}

	@Transient
	@XmlTransient
	public String getAdminUserName() {
		return adminUserName;
	}

	@XmlTransient
	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	@Transient
	@XmlTransient
	public String getAdminPassword() {
		return adminPassword;
	}

	@XmlTransient
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Transient
	@XmlTransient
	public String getStorageAccountName() {
		return storageAccountName;
	}

	@XmlTransient
	public void setStorageAccountName(String storageAccountName) {
		this.storageAccountName = storageAccountName;
	}

	@Transient
	@XmlTransient
	public String getStorageAccountContainer() {
		return storageAccountContainer;
	}

	@XmlTransient
	public void setStorageAccountContainer(String storageAccountContainer) {
		this.storageAccountContainer = storageAccountContainer;
	}

	@Transient
	@XmlTransient
	public String getUserName() {
		return userName;
	}

	@XmlTransient
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Transient
	@XmlTransient
	public String getUserPassword() {
		return userPassword;
	}

	@XmlTransient
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Transient
	@XmlTransient
	public String getOsVHarddiskName() {
		return osVHarddiskName;
	}

	@XmlTransient
	public void setOsVHarddiskName(String osVHarddiskName) {
		this.osVHarddiskName = osVHarddiskName;
	}

	@Override
	public String toString() {
		return "Vm [vmid=" + vmid + ", runningonhostid=" + runningonhostid + ", ip=" + ip + ", cdisopath=" + cdisopath
				+ ", info=" + info + ", statistics=" + statistics + ", domain=" + domain + ", displayType=" + displayType
				+ ", bootDevice=" + bootDevice + ", flavorId=" + flavorId + ", keyName=" + keyName + ", type=" + type
				+ ", group=" + group + ", key=" + key + ", getCpunum()=" + getCpunum() + ", getMemorysize()="
				+ getMemorysize() + ", getCreationdate()=" + getCreationdate() + ", getOs()=" + getOs() + ", getName()="
				+ getName() + ", getResourceid()=" + getResourceid() + ", getTemplateid()=" + getTemplateid()
				+ ", getVmtype()=" + getVmtype() + ", getHypervisortype()=" + getHypervisortype() + ", getStatus()="
				+ getStatus() + ", getTimeZone()=" + getTimeZone() + ", getConfig()=" + getConfig() + ", getPool()="
				+ getPool() + ", getDesc()=" + getDesc() + ", getVersion()=" + getVersion() + ", getId()=" + getId()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((vmid == null) ? 0 : vmid.hashCode());
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
		Vm other = (Vm) obj;
		if (vmid == null) {
			if (other.vmid != null) {
				return false;
			}
		} else if (!vmid.equals(other.vmid)) {
			return false;
		}
		return true;
	}

}
