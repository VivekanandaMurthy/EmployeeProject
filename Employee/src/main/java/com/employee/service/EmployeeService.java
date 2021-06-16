package com.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.employee.exception.CustomException;
import com.employee.model.Address;
import com.employee.model.Employee;
import com.employee.repository.AddressRepository;
import com.employee.repository.EmployeeRepository;

/**
 * 
 * 
 * @author Vivekananda Murthy
 * 
 *         Main Service class for Employee CRUD operations and can search the
 *         employee details based on different parameters using JPA repositories
 *         AddressRepository and EmployeeRepository for communication with
 *         address table and employee table
 */

@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	AddressRepository addressRepository;

	Logger lf = LoggerFactory.getLogger(EmployeeService.class);

	public boolean saveEmployee(Employee employee) {

		lf.info("Request to add employee details");

		if (employeeRepository.save(employee) != null) {

			lf.info("Employee details added successfully");

			employeeRepository.flush();

			return true;

		} else {

			lf.error(" Failed to add Employee details", HttpStatus.INTERNAL_SERVER_ERROR);

			throw new CustomException(" Failed to add Employee details", HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	public List<Employee> getEmployees() {

		lf.info("Employees details requested");

		List<Employee> ls = (List<Employee>) employeeRepository.findAll();

		if (ls.isEmpty()) {

			lf.error("Employees details not found, Please try again Dummy details are about to add in the database",
					HttpStatus.NOT_FOUND);

			createEmployees();

			throw new CustomException(
					"Employees details not found, Please try again, Dummy details are about to add in the database",
					HttpStatus.NOT_FOUND);

		} else {

			return ls;

		}
	}

	public boolean updateEmployee(Employee employee) {

		lf.info("Request to update employee details");

		if (employeeRepository.save(employee) != null) {

			lf.info("Employee details updated successfully");

			return true;

		} else {

			lf.error("Employee details not updated", HttpStatus.INTERNAL_SERVER_ERROR);

			throw new CustomException("Employee details not updated", HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	public void deleteEmployee(Long id) {

		lf.info("Delete request for Employee with id : " + id);

		if (findOneById(id)) {

			employeeRepository.delete(id);

			lf.info("Employee with id : " + id + " is deleted");

		} else {

			lf.error("Employee with id :" + id + "not exist", HttpStatus.NOT_FOUND);

			throw new CustomException("Employee with id :" + id + " not exist", HttpStatus.NOT_FOUND);

		}
	}

	public boolean findOneById(Long id) {

		lf.info("Employee details with id : " + id + " is requested");

		if (employeeRepository.findOne(id) != null) {

			return true;

		} else {

			lf.error("Employee not found with id : " + id, HttpStatus.NOT_FOUND);

			throw new CustomException("Employee not found with id : " + id, HttpStatus.NOT_FOUND);

		}

	}

	public Employee findByEmpid(String empid) {

		lf.info("Employee details with id : " + empid + " is requested");

		Employee employee = employeeRepository.findByEmpid(empid);

		if (Objects.nonNull(employee)) {

			return employee;

		} else {

			lf.error("Employee not found with employeeid : " + empid, HttpStatus.NOT_FOUND);

			throw new CustomException("Employee not found with employeeid : " + empid, HttpStatus.NOT_FOUND);

		}

	}

	public List<Employee> findByFirstname(String firstname) {

		lf.info("Employee details with firstname : " + firstname + " is requested");

		List<Employee> employee = employeeRepository.findByFirstname(firstname);

		if (!employee.isEmpty()) {

			return employee;

		} else {

			lf.error("Employee not found with firstname : " + firstname, HttpStatus.NOT_FOUND);

			throw new CustomException("Employee not found with firstname : " + firstname, HttpStatus.NOT_FOUND);

		}

	}

	public List<Employee> findByLastname(String lastname) {

		lf.info("Employee details with lastname : " + lastname + " is requested");

		List<Employee> employee = employeeRepository.findByLastname(lastname);

		if (!employee.isEmpty()) {

			return employee;

		} else {

			lf.error("Employee not found with lastname : " + lastname, HttpStatus.NOT_FOUND);

			throw new CustomException("Employee not found with lastname : " + lastname, HttpStatus.NOT_FOUND);

		}

	}

	public List<Employee> findByAddressline(String addressline) {

		lf.info("Employee details with addressline : " + addressline + " is requested");

		List<Address> address = addressRepository.findByAddressline(addressline);

		if (!address.isEmpty()) {

			return getEmployeeDetails(address);

		} else {

			lf.error("Employee not found with addressline : " + addressline, HttpStatus.NOT_FOUND);

			throw new CustomException("Employee not found with addressline : " + addressline, HttpStatus.NOT_FOUND);

		}

	}

	public List<Employee> findByCity(String city) {

		lf.info("Employee details with city : " + city + " is requested");

		List<Address> address = addressRepository.findByCity(city);

		if (!address.isEmpty()) {

			return getEmployeeDetails(address);

		} else {

			lf.error("Employee not found with city : " + city, HttpStatus.NOT_FOUND);

			throw new CustomException("Employee not found with city : " + city, HttpStatus.NOT_FOUND);

		}

	}

	public List<Employee> findByCountry(String country) {

		lf.info("Employee details with country : " + country + " is requested");

		List<Address> address = addressRepository.findByCountry(country);

		if (!address.isEmpty()) {

			return getEmployeeDetails(address);

		} else {

			lf.error("Employee not found with country : " + country, HttpStatus.NOT_FOUND);

			throw new CustomException("Employee not found with country : " + country, HttpStatus.NOT_FOUND);

		}

	}

	public List<Employee> findByPinCode(String pincode) {

		lf.info("Employee details with pincode : " + pincode + " is requested");

		List<Address> address = addressRepository.findByPinCode(pincode);

		if (!address.isEmpty()) {

			return getEmployeeDetails(address);

		} else {

			lf.error("Employee not found with pincode : " + pincode, HttpStatus.NOT_FOUND);

			throw new CustomException("Employee not found with pincode : " + pincode, HttpStatus.NOT_FOUND);

		}

	}

	public List<Employee> findByState(String state) {

		lf.info("Employee details with state : " + state + " is requested");

		List<Address> address = addressRepository.findByState(state);

		if (!address.isEmpty()) {

			return getEmployeeDetails(address);

		} else {

			lf.error("Employee not found with state : " + state, HttpStatus.NOT_FOUND);

			throw new CustomException("Employee not found with state : " + state, HttpStatus.NOT_FOUND);

		}

	}

	public List<Employee> getEmployeeDetails(List<Address> address) {

		List<Employee> ls = new ArrayList<Employee>();

		for (Address addr : address) {

			Employee employee = findByEmpid(addr.getEmpid());
			boolean exist = false;
			for (Employee emp : ls) {
				if ((emp.getId().equals(employee.getId()))) {
					exist = true;
				}
			}
			if (!exist) {
				ls.add(employee);
			}

		}

		return ls;
	}

	private void createEmployees() {
		lf.info("Started adding Dummy details in to the database");
		Employee employee = new Employee();
		employee.setId(Long.valueOf(1));
		employee.setEmpid("1");
		employee.setFirstname("Vivek");
		employee.setLastname("Murthy");

		List<Address> addresses = new ArrayList<Address>();

		Address address1 = new Address();
		address1.setAddressline("FirstLane");
		address1.setCity("Hyderabad");
		address1.setCountry("India");
		address1.setPinCode("500072");
		address1.setState("Telangana");
		address1.setEmpid("1");

		Address address2 = new Address();
		address2.setAddressline("FirstLane");
		address2.setCity("Hyderabad");
		address2.setCountry("India");
		address2.setPinCode("500072");
		address2.setState("Telangana");
		address2.setEmpid("1");

		addresses.add(address1);
		addresses.add(address2);
		employee.setAddress(addresses);

		saveEmployee(employee);
		lf.info("Dummy details added in to the database" + employee);

	}

}
