package com.example.jobAppRest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobAppRest.model.JobPost;
import com.example.jobAppRest.service.JobService;

@RestController
public class JobRestController {
	
	@Autowired
	private JobService service;
	
	@GetMapping("/jobPosts")
//	@ResponseBody
	public List<JobPost> getAllJobs() {
		return service.getAllJobs();
	}
	
	@GetMapping("/jobPost/{id}")
	public JobPost getJob(@PathVariable int id) {
		return service.getJobById(id);
	}
	
	@PostMapping("/jobPost")
	public void addJobPost(@RequestBody JobPost job) {
		service.addJob(job);
	}
	
	@PutMapping("/jobPost")
	public void updateJobPost(@RequestBody JobPost job) {
		service.updateJob(job);
	}
	
	@DeleteMapping("/jobPost/{id}")
	public String deleteJob(@PathVariable int id) {
		service.deleteJob(id);
		return "Deleted";
	}
	
	@GetMapping("load")
	public String loadData() {
		service.load();
		return "Success";
	}
	
	@GetMapping("jobPost/search/{keyword}")
	public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
		return service.search(keyword);
	}
}
