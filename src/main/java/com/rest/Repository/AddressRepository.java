package com.rest.Repository;

import com.rest.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByCountry(String country);
    List<Address> findByCity(String city);
}
