package com.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.model.EmployeesDTO;
import com.employee.service.EmployeeService;
import com.employee.service.EmployeeServiceInterface;

/**
 * 
 * 
 * @author Vivekananda Murthy
 * 
 *         Main Controller for Employee CRUD operations and can search the
 *         employee details based on different parameters
 */

@RestController
public class EmployeeController {

	Logger lf = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeServiceInterface employeeService;

	@RequestMapping(value = "/getemployees", method = RequestMethod.GET)
	public List<Employee> getEmployees() {

		lf.info("Employees details requested");

		return employeeService.getEmployees();

	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	@ResponseBody
	public String addEmployee(@RequestBody EmployeesDTO employee) {

		lf.info("Requested to add employee details");

		if (employeeService.saveEmployee(employee.getEmployee())) {

			lf.info("Employee added Successfully");

			return "Employee added Successfully :" + employee;

		} else {

			lf.error("Failed to add employee");

			return "Failed to add employee";

		}
	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT)
	@ResponseBody
	public String updateEmployee(@RequestBody EmployeesDTO employee) {

		System.out.println(employee);

		lf.info("Requested to update employee details");

		employeeService.updateEmployee(employee.getEmployee());

		lf.info("Employee updated Successfully with details " + employee);

		return "Employee updated Successfully with details " + employee;

	}

	@DeleteMapping("/deleteEmployee/{id}")
	@ResponseBody
	public String deleteEmployee(@PathVariable Long id) {

		lf.info("Requested to delete employee details with id : " + id);

		employeeService.deleteEmployee(id);

		lf.info("Employee deleted Successfully with id " + id);

		return "Employee deleted Successfully with id " + id;

	}

	@RequestMapping(value = "/getemployeeByEmpId/{empid}", method = RequestMethod.GET)
	public Employee findByEmpid(@PathVariable String empid) {

		lf.info("Employees details requested");

		return employeeService.findByEmpid(empid);

	}

	@RequestMapping(value = "/getemployeesByFirstName/{firstname}", method = RequestMethod.GET)
	public List<Employee> findByFirstname(@PathVariable String firstname) {

		lf.info("Employees details requested");

		return employeeService.findByFirstname(firstname);

	}

	@RequestMapping(value = "/findByLastname/{lastname}", method = RequestMethod.GET)
	public List<Employee> findByLastname(@PathVariable String lastname) {

		lf.info("Employees details requested");

		return employeeService.findByLastname(lastname);

	}

	@RequestMapping(value = "/findByAddressline/{addressline}", method = RequestMethod.GET)
	public List<Employee> findByAddressline(@PathVariable String addressline) {

		lf.info("Employees details requested");

		return employeeService.findByAddressline(addressline);

	}

	@RequestMapping(value = "/findByCity/{city}", method = RequestMethod.GET)
	public List<Employee> findByCity(@PathVariable String city) {

		lf.info("Employees details requested");

		return employeeService.findByCity(city);

	}

	@RequestMapping(value = "/findByCountry/{country}", method = RequestMethod.GET)
	public List<Employee> findByCountry(@PathVariable String country) {

		lf.info("Employees details requested");

		return employeeService.findByCountry(country);

	}

	@RequestMapping(value = "/findByPinCode/{pincode}", method = RequestMethod.GET)
	public List<Employee> findByPinCode(@PathVariable String pincode) {

		lf.info("Employees details requested");

		return employeeService.findByPinCode(pincode);

	}

	@RequestMapping(value = "/findByState/{state}", method = RequestMethod.GET)
	public List<Employee> findByState(@PathVariable String state) {

		lf.info("Employees details requested");

		return employeeService.findByState(state);

	}

}
