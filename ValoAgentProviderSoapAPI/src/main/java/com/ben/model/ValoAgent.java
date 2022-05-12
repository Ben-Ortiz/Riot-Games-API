package com.ben.model;

import java.util.Objects;

/**
 * This class is the model class of ValoAgent, and with the annotations @Entity which makes the table,
 * and the @Id makes the primary key the id to be automatically made in the database connected without creating the 
 * database yourself.
 * @author benor
 *
 */

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ValoAgent {

	@Id
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
