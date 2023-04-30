package com.example.Job.Search.Portal.controller;

import com.example.Job.Search.Portal.model.Job;
import com.example.Job.Search.Portal.model.JobType;
import com.example.Job.Search.Portal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/job")
public class JobController {

    @Autowired
    JobService jobService;

   // use Crud Repository

    @PostMapping(value = "/InbuildMethod/add")
    public String addUsingInbuildtMethod(@Valid @RequestBody List<Job> job)
    {
        return jobService.addUsingInbuildtMethod(job);
    }

    @GetMapping(value = "/InbuildMethod/get")
    public Iterable<Job> getUsingInbuildtMethod()
    {
        return jobService.getUsingInbuildMethod();
    }


    @DeleteMapping(value = "/InbuildMethod/{id}")
    public void deleteJobById(@PathVariable Long id)
    {
        jobService.removeJobById(id);
    }



   // using custom finder

    @GetMapping(value = "/customFinder/all/{title}")
    public List<Job> getallUsingCustomFinder(@PathVariable String title){
        return jobService.getallUsingCustomFinder(title);
    }

    @GetMapping(value = "/customFinder/salary/{salary}")
    public List<Job> getBySalary(@PathVariable Double salary){
        return jobService.getBySalary(salary);
    }

    @GetMapping(value = "/customFinder/jobType/{jobType}/salary/{Salary}")
    public List<Job> JobTypeAndSalaryGreaterThan(@PathVariable JobType jobType,@PathVariable Double Salary){
       return jobService.JobTypeAndSalaryGreaterThan(jobType,Salary);
    }


//    Use custom Query

    @GetMapping(value = "/JobSort")
    public List<Job> getOrderedJobs()
    {
        return jobService.getAllJobSorted();
    }

    @GetMapping(value = "/searchByTitle/{title}")
    public List<Job> searchBy(@PathVariable String title){
       return jobService.searchBy(title);
    }

    @PutMapping(value = "/update/id/{id}/salary/{salary}")
    public void updateSalary(@PathVariable Long id,@PathVariable Double salary){
        jobService.updateSalary(id,salary);
    }

    @DeleteMapping(value = "/delete/salary/{salary}")
    public void deleteLowSalary(@PathVariable Double salary){
        jobService.deleteLowSalary(salary);
    }
}


//[
//        {
//        "id": 1,
//        "title": "Software Developer",
//        "description": "We are looking for a talented software developer to join our team.",
//        "location": "New York",
//        "salary": 100000.0,
//        "companyName": "ABC Inc.",
//        "employerName": "onkar ",
//        "jobType": "IT",
//        "appliedDate": "2023-05-30T14:30:00"
//        },
//        {
//        "id": 2,
//        "title": "Data Analyst",
//        "description": "We are seeking a data analyst with strong SQL skills to support our business operations.",
//        "location": "San Francisco",
//        "salary": 80000.0,
//        "companyName": "XYZ Corp.",
//        "employerName": "suraj",
//        "jobType": "HR",
//        "appliedDate": "2022-04-30T14:30:00"
//        },
//        {
//        "id": 3,
//        "title": "Data Analyst",
//        "description": "We are seeking a data analyst with strong SQL skills to support our business operations.",
//        "location": "San Francisco",
//        "salary": 90000.0,
//        "companyName": "XYZ Corp.",
//        "employerName": "ankit sarwar",
//        "jobType": "Marketing",
//        "appliedDate": "2021-04-30T14:30:00"
//        },
//        {
//        "id": 4,
//        "title": "Marketing ",
//        "description": "We are seeking a highly motivated marketing and sales professional to join our team. The successful candidate will be responsible for developing and executing marketing campaigns, identifying new business opportunities, and building strong customer relationships.",
//        "location": "New York, NY",
//        "salary": 80000.0,
//        "companyName": "ABC Company",
//        "employerName": "John Smith",
//        "jobType": "Marketing",
//        "appliedDate": "2020-04-30T14:30:00"
//        },
//        {
//        "id": 5,
//        "title": "sales ",
//        "description": "We are seeking a highly motivated marketing and sales professional to join our team. The successful candidate will be responsible for developing and executing marketing campaigns, identifying new business opportunities, and building strong customer relationships.",
//        "location": "New York, NY",
//        "salary": 80000.0,
//        "companyName": "ABC Company",
//        "employerName": "abhi ",
//        "jobType": "Sales",
//        "appliedDate": "2019-04-30T14:30:00"
//        }
//
//]