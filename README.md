
<h1 align="center"> 👤Job_Search_Portal🎉</h1>

>### Framework Used 
 * ![SpringBoot](https://img.shields.io/badge/SpringBoot-White?style=flat&logoColor=Blue)

>### Language Used
* ![Java](https://img.shields.io/badge/Java-White?style=flat&logoColor=Blue)


>## Data Structure used in my project
    This document outlines the steps to create a student model and an event model (Id,name,department,branch,location,description,starttime,endtime,date)
    Student model will have-
    * StudentId
    * first name
    * last name
    * age
    * department
      
>## 1.Controller-
        *JobController - exposes REST endpoints for creating, updating, deleting, and searching jobs.
        Service:
>## 2. Service-
       *JobService - implements business logic for validating inputs, performing search queries, and executing CRUD operations.
        Repository:
>## 3. Repository
       * IJobRepository - defines interface for data access operations on the Job entity.
         IJobRepository extends CrudRepository
  
>## 4. Model
       1.Job-
        *Job table with columns:
                id (Long)
                title (String)
                description (String)
                location (String)
                salary (Double)
                companyName (String)
                employerName (String)
                jobType (String)
                appliedDate (LocalDate)
         2.JobType(Enum class)-
                  IT,HR ,Sales, Marketing
                  
>## Project Summary
            1.crud operations using inbuilt @CrudRepo methods,
            2.custom get methods using your own custom finders (No implementations, correct queries should be fired based on method names)
            3.write operations (update and delete) using Custom queries (using @Query) 
         
