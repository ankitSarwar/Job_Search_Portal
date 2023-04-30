package com.example.Job.Search.Portal.service;

import com.example.Job.Search.Portal.model.Job;
import com.example.Job.Search.Portal.model.JobType;
import com.example.Job.Search.Portal.repository.IJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class JobService {

    @Autowired
    IJobRepository jobRepository;


    public String addUsingInbuildtMethod(List<Job> job) {
        Iterable<Job> list =jobRepository.saveAll(job);
        if(list!=null){
            return "added";
        }else{
            return "Not added!!!";
        }
    }


    public Iterable<Job> getUsingInbuildMethod() {
        Iterable<Job> allJob=jobRepository.findAll();
        return allJob;
    }

    public void removeJobById(Long id) {
        jobRepository.deleteById(id);
    }


    public List<Job> getallUsingCustomFinder(String title) {
        return jobRepository.findByTitle(title);
    }

    public List<Job> fetchJobBYName(String title) {

        return jobRepository.findByTitle(title);
    }

    public List<Job> getBySalary(Double salary){
       return jobRepository.findBySalaryGreaterThan(salary);
    }

    public List<Job> JobTypeAndSalaryGreaterThan(JobType jobType,Double Salary){
//        String enumValue=jobType.name();
       return jobRepository.findByJobTypeAndSalaryGreaterThan( jobType, Salary);
    }

    public List<Job> getAllJobSorted() {
        return jobRepository.GetAllJobsBySalary();
    }

    public List<Job>searchBy(String Title){
        return jobRepository.searchByTitle(Title);
    }

    @Transactional
    public void updateSalary(Long id, Double salary) {
        jobRepository.putSalary(id,salary);
    }

    @Transactional
    public void deleteLowSalary(Double salary) {
        jobRepository.deleteBasedOnSalary(salary);
    }
}
