package com.example.jobAppRest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobAppRest.Repository.JobRepo;
import com.example.jobAppRest.model.JobPost;

@Service
public class JobService {
	
	@Autowired
	private JobRepo jobRepo;
	
	
	public void addJob(JobPost jobPost) {
		jobRepo.save(jobPost);
	}
	
	public List<JobPost> getAllJobs(){
		return jobRepo.findAll();
	}
	
	public JobPost getJobById(int id) {
		return jobRepo.findById(id).orElse(new JobPost());
	}

	public void updateJob(JobPost job) {
		jobRepo.save(job);
		// TODO Auto-generated method stub
		
	}

	public void deleteJob(int id) {
		// TODO Auto-generated method stub
		jobRepo.deleteById(id);
	}

	public void load() {
		// TODO Auto-generated method stub
		// arrayList to store store JobPost objects
		List<JobPost> jobs = new ArrayList<>(List.of(
				new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2, List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
				new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3, List.of("HTML", "CSS", "JavaScript", "React")),
				new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4, List.of("Python", "Machine Learning", "Data Analysis")),
				new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5, List.of("Networking", "Cisco", "Routing", "Switching")),
				new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3, List.of("iOS Development", "Android Development", "Mobile App"))
			));
		System.out.println(jobs);
		jobRepo.saveAll(jobs);
	}

	public List<JobPost> search(String keyword) {
		// TODO Auto-generated method stub
		return jobRepo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
	}
}
