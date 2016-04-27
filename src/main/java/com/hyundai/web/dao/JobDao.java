package com.hyundai.web.dao;

import java.util.List;

import com.hyundai.web.entity.Job;

public interface JobDao  {

	 
    void savejob(Job job);
     
    void deleteJobByvehicle(String vehregNo);
     
    List<Job> findAllJobs();
 
    Job findJobById(Long id);
 

}
