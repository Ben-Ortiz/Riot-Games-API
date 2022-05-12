package com.ben.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class allows the ValoAgent class to be represented in this Rest Consumer API. 
 * The field names have to be the same as the Soap Provider Service in order for this to work.
 * @author benor
 *
 */
public class ValoAgent {

	private long id;
	private String valoName;

	public ValoAgent() {
		super();
	}

	public ValoAgent(long id, String valoName) {
		super();
		this.id = id;
		this.valoName = valoName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getValoName() {
		return valoName;
	}

	public void setValoName(String valoName) {
		this.valoName = valoName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, valoName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValoAgent other = (ValoAgent) obj;
		return id == other.id && Objects.equals(valoName, other.valoName);
	}

	@Override
	public String toString() {
		return "ValoAgent [id=" + id + ", valoName=" + valoName + "]";
	}

}
