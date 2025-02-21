package com.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.entities.TestVideo;
import com.demo.repository.TestRepository;

@Service
public class TestVideoService {
	@Autowired
	private TestRepository testRepository;
	 
 
    public TestVideo uploadVideo(String title, MultipartFile file) throws Exception {
        TestVideo video = new TestVideo();
        video.setTitle(title);
        video.setFileName(file.getOriginalFilename());
        video.setData(file.getBytes());
        return testRepository.save(video);
    }
 
    public Optional<TestVideo> getVideo(Long id) {
        return testRepository.findById(id);
    }

}
