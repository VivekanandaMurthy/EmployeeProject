package com.employee.service;

import java.util.List;

import com.employee.model.Address;
import com.employee.model.Employee;

public interface EmployeeServiceInterface {

	public boolean saveEmployee(Employee employee);

	public List<Employee> getEmployees();

	public boolean updateEmployee(Employee employee);

	public void deleteEmployee(Long id);

	public boolean findOneById(Long id);

	public Employee findByEmpid(String empid);

	public List<Employee> findByFirstname(String firstname);

	public List<Employee> findByLastname(String lastname);

	public List<Employee> findByAddressline(String addressline);

	public List<Employee> findByCity(String city);

	public List<Employee> findByCountry(String country);

	public List<Employee> findByPinCode(String pincode);

	public List<Employee> findByState(String state);

	public List<Employee> getEmployeeDetails(List<Address> address);
}
