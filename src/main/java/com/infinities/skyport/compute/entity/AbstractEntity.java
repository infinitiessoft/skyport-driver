package com.infinities.skyport.compute.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonView;
import com.infinities.skyport.compute.IAbstractEntity;
import com.infinities.skyport.view.Views;

@MappedSuperclass
public abstract class AbstractEntity implements IAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlTransient
	private Long id;
	@JsonView(Views.Basic.class)
	private String desc;
	@XmlTransient
	private int version;


	public AbstractEntity() {
		super();
	}

	public AbstractEntity(String desc) {
		this.desc = desc;
	}

	@Override
	@Column(name = "DESCRIPTION", length = 150)
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@XmlTransient
	@Version
	@Column(name = "OPTLOCK")
	public int getVersion() {
		return version;
	}

	@XmlTransient
	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	@XmlTransient
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	@XmlTransient
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + version;
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
		AbstractEntity other = (AbstractEntity) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (version != other.version) {
			return false;
		}
		return true;
	}

}
