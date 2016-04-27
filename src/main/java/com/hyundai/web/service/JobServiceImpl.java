package com.hyundai.web.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundai.web.dao.JobDao;
import com.hyundai.web.entity.Job;
@Service
public class JobServiceImpl implements JobService{
@Autowired 
JobDao jobDao ;


public void saveJob(Job job) {
	// TODO Auto-generated method stub
	
}

@Transactional
public List<Job> findAllJobs(String vehregNo ) {
	List<Job> jobs =jobDao.findAllJobs();
	List<Job> returnList = new ArrayList<Job>();
	Iterator<Job> itr= jobs.iterator();
	while(itr.hasNext())
	{
		Job job = itr.next();
		if(job.getVehRegNo().equalsIgnoreCase(vehregNo))
		{
			returnList.add(job);
		}
	}
	
	return returnList;
	
}


public void deleteJobs(String Id) {
	// TODO Auto-generated method stub
	
}


public Job findById(Long id) {
	// TODO Auto-generated method stub
	return null;
}


public void updateJob(Job Job) {
	// TODO Auto-generated method stub
	
}
	
	

}
