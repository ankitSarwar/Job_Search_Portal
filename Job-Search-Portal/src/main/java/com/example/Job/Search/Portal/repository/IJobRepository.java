package com.example.Job.Search.Portal.repository;

import com.example.Job.Search.Portal.model.Job;
import com.example.Job.Search.Portal.model.JobType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobRepository extends CrudRepository<Job,Long> {

    // custom finder
    public List<Job> findByTitle(String title);

    public List<Job> findBySalaryGreaterThan(Double Salary);

    public List<Job> findByJobTypeAndSalaryGreaterThan(JobType jobType,Double Salary);


    // custom query
    @Query(value = "select * from job order by salary desc",nativeQuery = true)
    List<Job> GetAllJobsBySalary();

    @Query(value = "SELECT * FROM Job  WHERE description LIKE %:title%",nativeQuery = true)
    List<Job> searchByTitle(String title);



    @Modifying
    @Query(value = "update job set salary=:salary where id=:id",nativeQuery = true)
    void putSalary(Long id, Double salary);

    @Modifying
    @Query(value = "delete from job where SALARY<=:salary",nativeQuery = true)
    void deleteBasedOnSalary(Double salary);
}
