package com.empapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

    @Query("Select e from Employee e where e.name like %:name%")
    List<Employee> findEmployee(@Param("name") String name);
}
