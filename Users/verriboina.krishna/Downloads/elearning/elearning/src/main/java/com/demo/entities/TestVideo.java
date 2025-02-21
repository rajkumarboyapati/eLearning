package com.demo.entities;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class TestVideo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String title;
    private String fileName;
    
    @Lob
    private byte[] data;  // Store video as binary

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public TestVideo(Long id, String title, String fileName, byte[] data) {
		super();
		this.id = id;
		this.title = title;
		this.fileName = fileName;
		this.data = data;
	}

	public TestVideo() {
		super();
	}

	@Override
	public String toString() {
		return "TestVideo [id=" + id + ", title=" + title + ", fileName=" + fileName + ", data=" + Arrays.toString(data)
				+ "]";
	}
    


}
