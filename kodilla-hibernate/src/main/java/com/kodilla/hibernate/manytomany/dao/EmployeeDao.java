package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    @Query
    List<Employee> retrieveEmployeesByLastname(@Param("LASTNAME") String lastname);

    @Query("SELECT e FROM Employee e WHERE e.lastname LIKE %:LASTNAME%")
    List<Employee> retrieveEmployeeLike(@Param("LASTNAME") String lastname);
}
