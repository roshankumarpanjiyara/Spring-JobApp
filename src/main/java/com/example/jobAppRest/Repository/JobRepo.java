package com.example.jobAppRest.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.example.jobAppRest.model.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer>{

	List<JobPost> findByPostProfileContainingOrPostDescContaining(String keyword, String keyword2);

//
//	public List<JobPost>  getAllJobs(){
//		return jobs;
//	}
//	
//	public void addJob(JobPost job) {
//		jobs.add(job);
//		System.out.println(jobs);
//	}
//	
//	public JobPost getJobById(int id) {
//		for(JobPost job : jobs) {
//			if(job.getPostId() == id) {
//				return job;
//			}
//		}
//		return null;
//	}
//
//	public void updateJob(JobPost job) {
//		// TODO Auto-generated method stub
//		for(JobPost post : jobs) {
//			if(post.getPostId() == job.getPostId()) {
//				post.setPostDesc(job.getPostDesc());
//				post.setPostProfile(job.getPostProfile());
//				post.setReqExperience(job.getReqExperience());
//				post.setPostTechStack(job.getPostTechStack());
//				return;
//			}
//		}
//	}
//
//	public void deleteJob(int id) {
//		// TODO Auto-generated method stub
//		for(JobPost job : jobs) {
//			if(job.getPostId() == id) {
//				jobs.remove(job);
//				return;
//			}
//		}
//	}
}
