package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employee.model.Address;
import java.lang.String;
import java.util.List;

/**
 * 
 * 
 * @author Vivekananda Murthy
 * 
 *         AddressRepository to store and get Employee Addresses.
 * 
 */

public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findByAddressline(String addressline);

	List<Address> findByCity(String city);

	List<Address> findByCountry(String country);

	List<Address> findByPinCode(String pincode);

	List<Address> findByState(String state);

}
