package com.ben.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class is the model class of LOLCHampion, and with the annotations @Entity which makes the table,
 * and the @Id makes the primary key the id to be automatically made in the database connected without creating the 
 * database yourself.
 * @author benor
 *
 */
@Entity
public class LOLChampion {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String champName;

	public LOLChampion() {
		super();
	}

	public LOLChampion(long id, String champName) {
		super();
		this.id = id;
		this.champName = champName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getChampName() {
		return champName;
	}

	public void setChampName(String champName) {
		this.champName = champName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(champName, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LOLChampion other = (LOLChampion) obj;
		return Objects.equals(champName, other.champName) && id == other.id;
	}

	@Override
	public String toString() {
		return "LOLChampions [id=" + id + ", champName=" + champName + "]";
	}

}
