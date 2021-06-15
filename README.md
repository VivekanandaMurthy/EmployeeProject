# EmployeeProject

Employee project used to save employee details along with addresses of the Employee


Main API's : 

Get Employee details :
http://<ip|hostname>:<port>/Employee/getemployees will fetch all employee details if exist or creates a dummy record inside the database if empty.
  
Save Employee details :
http://<ip|hostname>:<port>/Employee/addEmployee will add employee details and accepts EmployeesDTO as requestbody.
  
Update Employee details :
http://<ip|hostname>:<port>/Employee/updateEmployee will update employee details and accepts EmployeesDTO as requestbody.
  
Delete Employee details :
http://<ip|hostname>:<port>/Employee/deleteEmployee/{id} will delete employee details and accepts Long as requestbody.
  
Remaining API's will fetch List<Employees> based on params provided

  1. http://<ip|hostname>:<port>/Employee/getemployeesByFirstName/{firstname} will fetch all employees details by firstname.
  2. http://<ip|hostname>:<port>/Employee/findByLastname/{lastname} will fetch all employees details bt lastname.
  3. http://<ip|hostname>:<port>/Employee/findByAddressline/{addressline} will fetch all employees details by addressline param.
  4. http://<ip|hostname>:<port>/Employee/findByCity/{city} will fetch all employees details by city param.
  5. http://<ip|hostname>:<port>/Employee/findByCountry/{country} will fetch all employees sdetails by country param.
  6. http://<ip|hostname>:<port>/Employee/findByPinCode/{pincode} will fetch all employees details by pincode param.
  7. http://<ip|hostname>:<port>/Employee/findByState/{state} will fetch all employees details by state param.
  8. http://<ip|hostname>:<port>/Employee/getemployeeByEmpId/{empid} will fetch employee details by empid. 
