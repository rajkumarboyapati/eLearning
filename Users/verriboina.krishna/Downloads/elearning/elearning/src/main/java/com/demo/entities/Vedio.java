package com.demo.entities;

import java.util.Arrays;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Vedio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vedioId;
	
	private String vedioName;
	
	private String contentType;
	
	private String contentName;
	

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Modules moduleRef;
	
	
	
	public Vedio() {}



	public int getVedioId() {
		return vedioId;
	}



	public void setVedioId(int vedioId) {
		this.vedioId = vedioId;
	}



	public String getVedioName() {
		return vedioName;
	}



	public void setVedioName(String vedioName) {
		this.vedioName = vedioName;
	}



	public String getContentType() {
		return contentType;
	}



	public void setContentType(String contentType) {
		this.contentType = contentType;
	}



	public String getContentName() {
		return contentName;
	}



	public void setContentName(String contentName) {
		this.contentName = contentName;
	}





	public Modules getModuleRef() {
		return moduleRef;
	}



	public void setModuleRef(Modules moduleRef) {
		this.moduleRef = moduleRef;
	}



	@Override
	public String toString() {
		return "Vedio [vedioId=" + vedioId + ", vedioName=" + vedioName + ", contentType=" + contentType
				+ ", contentName=" + contentName + ", moduleRef=" + moduleRef + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(contentName, contentType, moduleRef, vedioId, vedioName);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vedio other = (Vedio) obj;
		return Objects.equals(contentName, other.contentName) && Objects.equals(contentType, other.contentType)
				&& Objects.equals(moduleRef, other.moduleRef) && vedioId == other.vedioId
				&& Objects.equals(vedioName, other.vedioName);
	}



	

}
