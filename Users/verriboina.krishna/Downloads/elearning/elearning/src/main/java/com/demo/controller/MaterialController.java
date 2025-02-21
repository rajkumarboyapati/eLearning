package com.demo.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.entities.Material;
import com.demo.service.MaterialService;
@CrossOrigin("*")
@RestController
@RequestMapping("/mat")
public class MaterialController {
	@Autowired
	MaterialService materialService;
	@PostMapping("upload")
	public ResponseEntity<?> uploadFile(@RequestParam("file") File file){
		try {
			Material f=materialService.storeFile(file);
			 return ResponseEntity.ok("File uploaded successfully! ID: " + f.getId());
		}catch(Exception e) {
			   return ResponseEntity.status(500).body("File upload failed");
		}
	}
	 @GetMapping ("/{id}")
	    public ResponseEntity<byte[]> downloadFile(@PathVariable int id) {
	        Material wordFile = materialService.getFileUpload(id);
 
	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(wordFile.getFileType()))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + wordFile.getFileName() + "\"")
	                .body(wordFile.getData());
	    }

}
