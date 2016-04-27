package com.hyundai.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hyundai.web.entity.Job;

public interface JobService {

	void saveJob(Job job);
	 
    List<Job> findAllJobs(String vehregNo);
 
    void deleteJobs(String Id);
 
    Job findById(Long id);
 
    void updateJob(Job Job);
	

	

}
