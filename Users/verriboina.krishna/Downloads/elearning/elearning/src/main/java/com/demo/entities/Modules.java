package com.demo.entities;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Modules {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int moduleId;
	
	private String moduleName;
	
	private String moduleContent;
	
	private String materialType;
	
	private String materialName;
	@Lob
	private byte[] data;
	

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Course courseRef;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Quiz quizRef;
	@OneToMany(cascade = CascadeType.ALL)
private List<Vedio> vedioRef;
	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleContent() {
		return moduleContent;
	}

	public void setModuleContent(String moduleContent) {
		this.moduleContent = moduleContent;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	

	public Course getCourseRef() {
		return courseRef;
	}

	public void setCourseRef(Course courseRef) {
		this.courseRef = courseRef;
	}

	public Quiz getQuizRef() {
		return quizRef;
	}

	public void setQuizRef(Quiz quizRef) {
		this.quizRef = quizRef;
	}

	public List<Vedio> getVedioRef() {
		return vedioRef;
	}

	public void setVedioRef(List<Vedio> vedioRef) {
		this.vedioRef = vedioRef;
	}
	

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Modules(int moduleId, String moduleName, String moduleContent, String materialType, String materialName,
			byte[] data, Course courseRef, Quiz quizRef, List<Vedio> vedioRef) {
		super();
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		this.moduleContent = moduleContent;
		this.materialType = materialType;
		this.materialName = materialName;
		this.data = data;
		this.courseRef = courseRef;
		this.quizRef = quizRef;
		this.vedioRef = vedioRef;
	}

	public Modules() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Modules [moduleId=" + moduleId + ", moduleName=" + moduleName + ", moduleContent=" + moduleContent
				+ ", materialType=" + materialType + ", materialName=" + materialName + ", data="
				+ Arrays.toString(data) + ", courseRef=" + courseRef + ", quizRef=" + quizRef + ", vedioRef=" + vedioRef
				+ "]";
	}

	
	
	
	

}
