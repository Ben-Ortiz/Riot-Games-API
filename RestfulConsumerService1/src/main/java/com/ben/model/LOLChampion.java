package com.ben.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class LOLChampion {
	
	private long id;
	private String champName;

	public LOLChampion(long id, String name) {
		super();
		this.id = id;
		this.champName = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return champName;
	}
	public void setName(String name) {
		this.champName = name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, champName);
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
		return id == other.id && Objects.equals(champName, other.champName);
	}
	@Override
	public String toString() {
		return "LOLChampion [id=" + id + ", name=" + champName + "]";
	}
	
	

}
