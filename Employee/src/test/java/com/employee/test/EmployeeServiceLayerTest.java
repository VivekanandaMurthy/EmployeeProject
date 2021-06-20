package com.employee.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.employee.model.Address;
import com.employee.model.Employee;
import com.employee.repository.AddressRepository;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class EmployeeServiceLayerTest {

	@Configuration
	static class EmployeeServiceTestContextConfiguration {
		@Bean
		public EmployeeService employeeService() {
			return new EmployeeService();
		}

		@Bean
		public EmployeeRepository employeeRepository() {
			return Mockito.mock(EmployeeRepository.class);
		}

		@Bean
		public AddressRepository addressRepository() {
			return Mockito.mock(AddressRepository.class);
		}
	}

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private AddressRepository addressRepository;

	private Employee createEmployees() {
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

		return employee;
	}

	private List<Employee> getEmployeesList() {
		Employee e = createEmployees();
		List<Employee> elist = new ArrayList<Employee>();
		elist.add(e);
		return elist;
	}

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getEmployees() throws Exception {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(createEmployees());
		Mockito.when(employeeRepository.findAll()).thenReturn(employees);
		assertEquals(1, employees.size());
	}

	@Test
	public void saveEmployee() {
		Employee employee = createEmployees();
		when(employeeRepository.save(ArgumentMatchers.any(Employee.class))).thenReturn(employee);
		boolean created = employeeService.saveEmployee(employee);
		assertEquals(true, created);
		verify(employeeRepository).save(employee);
	}

	@Test
	public void updateEmployee() throws Exception {
		Employee employee = createEmployees();
		Mockito.when(employeeRepository.save(ArgumentMatchers.any(Employee.class))).thenReturn(employee);
		boolean created = employeeService.updateEmployee(employee);
		assertEquals(true, created);
		verify(employeeRepository).save(employee);
	}

	@Test
	public void findByFirstname() throws Exception {
		Employee employee = createEmployees();
		Mockito.when(employeeRepository.findByFirstname(employee.getFirstname())).thenReturn(getEmployeesList());
		List<Employee> created = employeeService.findByFirstname(employee.getFirstname());
		Optional<Employee> firstEmployee = created.stream().filter(e -> e.getFirstname().equalsIgnoreCase("Vivek"))
				.findFirst();
		assertEquals("Vivek", (firstEmployee.get().getFirstname()));
		verify(employeeRepository).findByFirstname(employee.getFirstname());
	}

	@Test
	public void findByLastname() throws Exception {
		Employee employee = createEmployees();
		Mockito.when(employeeRepository.findByLastname(employee.getLastname())).thenReturn(getEmployeesList());
		List<Employee> created = employeeService.findByLastname(employee.getLastname());
		Optional<Employee> firstEmployee = created.stream().filter(e -> e.getLastname().equalsIgnoreCase("Murthy"))
				.findFirst();
		assertEquals("Murthy", (firstEmployee.get().getLastname()));
		verify(employeeRepository).findByLastname(employee.getLastname());
	}

	@Test
	public void findByEmpid() throws Exception {
		Employee employee = createEmployees();
		Mockito.when(employeeRepository.findByEmpid(employee.getEmpid())).thenReturn(employee);
		Employee created = employeeService.findByEmpid(employee.getEmpid());
		assertEquals("1", created.getEmpid());
		verify(employeeRepository).findByEmpid(employee.getEmpid());
	}

}
