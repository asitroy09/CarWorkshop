 package com.hyundai.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.hyundai.web.entity.Job;
import com.hyundai.web.entity.SearchCriteria;
import com.hyundai.web.entity.ServiceResponseBody;
import com.hyundai.web.jsonview.Views;
import com.hyundai.web.service.JobService;

@RestController
public class JobSearchController {

	
	@Autowired
	 @Qualifier("jobServiceImpl")
	JobService jobService;
	List<Job> jobs;

	// @ResponseBody, not necessary, since class is annotated with @RestController
	// @RequestBody - Convert the json data into object (SearchCriteria) mapped by field name.
	// @JsonView(Views.Public.class) - Optional, limited the json data display to client.
	@JsonView(Views.Public.class)
	@RequestMapping(value = "/jobs")
	public ServiceResponseBody getJobs(@RequestBody SearchCriteria search) {

		ServiceResponseBody result = new ServiceResponseBody();

		if (isValidSearchCriteria(search)) {
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

}
