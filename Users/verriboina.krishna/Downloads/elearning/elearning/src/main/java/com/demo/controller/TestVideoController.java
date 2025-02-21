package com.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.entities.TestVideo;
import com.demo.service.TestVideoService;
@CrossOrigin("*")
@RestController
@RequestMapping("/vedio")
public class TestVideoController {
	@Autowired
	TestVideoService testVideoService;
	// Upload video
    @PostMapping("/upload")
    public ResponseEntity<String> uploadVideo(@RequestParam("title") String title,
                                              @RequestParam("file") MultipartFile file) {
        try {
            TestVideo video = testVideoService.uploadVideo(title, file);
            return ResponseEntity.ok("Video uploaded successfully with ID: " + video.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Upload failed.");
        }
    }
 
    // View video
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getVideo(@PathVariable Long id) {
        Optional<TestVideo> video = testVideoService.getVideo(id);
        if (video.isPresent()) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "video/mp4");
            return new ResponseEntity<>(video.get().getData(), headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
