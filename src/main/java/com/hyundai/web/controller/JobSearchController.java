 package com.hyundai.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.hyundai.web.entity.Employee;
import com.hyundai.web.entity.Job;
import com.hyundai.web.entity.Jobline;
import com.hyundai.web.entity.SearchCriteria;
import com.hyundai.web.entity.ServiceResponseBody;
import com.hyundai.web.entity.Task;
import com.hyundai.web.jsonview.Views;
import com.hyundai.web.service.JobService;

@RestController
public class JobSearchController {

	
	@Autowired JobService jobService;
	List<Job> jobs;

	// @ResponseBody, not necessary, since class is annotated with @RestController
	// @RequestBody - Convert the json data into object (SearchCriteria) mapped by field name.
	// @JsonView(Views.Public.class) - Optional, limited the json data display to client.
	@JsonView(Views.Public.class)
	@RequestMapping(value = "/jobs")
	public ServiceResponseBody getJobs(@RequestBody SearchCriteria search) {

		ServiceResponseBody result = new ServiceResponseBody();

		if (isValidSearchCriteria(search)) {
			//List<Job> jobs = findByVehReg(search.getVehRegNo());
			List<Job> jobs = jobService.findAllJobs(search.getVehRegNo());

			if (jobs.size() > 0) {
				result.setCode("200");
				result.setMsg("");
				result.setResult(jobs);
			} else {
				result.setCode("204");
				result.setMsg("No jobs!");
			}

		} else {
			result.setCode("400");
			result.setMsg("Search criteria is empty!");
		}

		//AjaxResponseBody will be converted into json format and send back to client.
		return result;

	}

	private boolean isValidSearchCriteria(SearchCriteria search) {

		boolean valid = true;

		if (search == null) {
			valid = false;
		}

		if (StringUtils.isEmpty(search.getVehRegNo())){
			valid = false;
		}

		return valid;
	}

	// Init some users for testing
	//@PostConstruct
	private void iniDataForTesting() {
		
		Task task1 =new Task();
		task1.setTaskName("painting");
		
		Task task2 =new Task();
		task2.setTaskName("mechanical");
		
		Jobline jobline1 = new Jobline();
		jobline1.setId(1);
		jobline1.setTask(task1);
		
		Jobline jobline2 = new Jobline();
		jobline2.setId(2);
		jobline2.setTask(task2);
		
		Set<Jobline> jobLineSet = new HashSet<Jobline>();
		jobLineSet.add(jobline1);
		jobLineSet.add(jobline2);
		
		
		Employee emp1 = new Employee();
		emp1.setEmpName("John");
		
		
		Job job1 =new Job(1, emp1, "or02av7434", new Date(),"Completed", jobLineSet);
				
		
		Job job2 =new Job(2, emp1, "or02bz9000", new Date(),"inprogres",jobLineSet);
				
		
		Job job3 =new Job(3, emp1, "or02bk5630", new Date(),"inspection",jobLineSet);
				
		
		
		
		jobs = new ArrayList<Job>();
		jobs.add(job1);
		jobs.add(job2);
		jobs.add(job3);

	}

	// Simulate the search function
	private List<Job> findByVehReg(String vehRegno) {

		List<Job> result = new ArrayList<Job>();

		for (Job job : jobs) {

			if ((!StringUtils.isEmpty(vehRegno)) ) {

				if (vehRegno.equals(job.getVehRegNo()) ) {
					result.add(job);
					continue;
				} else {
					continue;
				}

			}
			


		}

		return result;

	}
}
