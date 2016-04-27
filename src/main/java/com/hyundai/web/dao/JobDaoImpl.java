package com.hyundai.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hyundai.web.entity.Job;
@Repository("jobDao")
public class JobDaoImpl extends CrudDaoImpl<Job> implements JobDao{

	
	@Override
	public void savejob(Job job) {
		
		save(job);
	}

	@Override
	public void deleteJobByvehicle(String vehRegNo) {
		
		 Query query = getSession().createSQLQuery("delete from Job where vehRegNo = :vehRegNo");
		 query.setString("vehRegno", vehRegNo);
	        query.executeUpdate();
	}

	@Override
	public List<Job> findAllJobs() {
		 Criteria criteria = createEntityCriteria();
		 return (List<Job>) criteria.list();
	}

	@Override
	public Job findJobById(Long id) {
		 Criteria criteria = createEntityCriteria();
	        criteria.add(Restrictions.eq("id", id));
	        return (Job) criteria.uniqueResult();
	}

}
