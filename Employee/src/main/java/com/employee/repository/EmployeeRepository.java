package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.model.Employee;
import java.lang.String;
import java.util.List;

/**
 * 
 * 
 * @author Vivekananda Murthy
 * 
 *         EmployeeRepository to store and get Employees.
 * 
 */

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByEmpid(String empid);

	List<Employee> findByFirstname(String firstname);

	List<Employee> findByLastname(String lastname);

}
