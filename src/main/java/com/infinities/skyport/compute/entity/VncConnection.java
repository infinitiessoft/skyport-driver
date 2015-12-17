package com.infinities.skyport.compute.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class VncConnection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "Info")
	private String info;

	@XmlElement(name = "Ticket")
	private String ticket;

	@XmlElement(name = "Type")
	private String type;

	@XmlElement(name = "VmId")
	private String vmId;

	@XmlElement(name = "Config")
	private String config;

	@XmlElement(name = "SSL")
	private boolean ssl;

	@XmlElement(name = "Username")
	private String username;

	@XmlElement(name = "Key")
	private String key;


	public VncConnection() {
		super();
	}

	public VncConnection(String config, String info, String ticket, String vmId, boolean ssl, String username, String key) {
		super();
		this.config = config;
		this.info = info;
		this.ticket = ticket;
		this.vmId = vmId;
		this.ssl = ssl;
		this.username = username;
		this.key = key;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVmId() {
		return vmId;
	}

	public void setVmId(String vmId) {
		this.vmId = vmId;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public boolean isSsl() {
		return ssl;
	}

	public void setSsl(boolean ssl) {
		this.ssl = ssl;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((config == null) ? 0 : config.hashCode());
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		result = prime * result + (ssl ? 1231 : 1237);
		result = prime * result + ((ticket == null) ? 0 : ticket.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((vmId == null) ? 0 : vmId.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		VncConnection other = (VncConnection) obj;
		if (config == null) {
			if (other.config != null) {
				return false;
			}
		} else if (!config.equals(other.config)) {
			return false;
		}
		if (info == null) {
			if (other.info != null) {
				return false;
			}
		} else if (!info.equals(other.info)) {
			return false;
		}
		if (ssl != other.ssl) {
			return false;
		}
		if (ticket == null) {
			if (other.ticket != null) {
				return false;
			}
		} else if (!ticket.equals(other.ticket)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		if (vmId == null) {
			if (other.vmId != null) {
				return false;
			}
		} else if (!vmId.equals(other.vmId)) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		if (key == null) {
			if (other.key != null) {
				return false;
			}
		} else if (!key.equals(other.key)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "VncConnection [info=" + info + ", ticket=" + ticket + ", type=" + type + ", vmId=" + vmId + ", config="
				+ config + ", ssl=" + ssl + ", username=" + username + ", key=" + key + "]";
	}

}
