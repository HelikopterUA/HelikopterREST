package com.rest.Service;

import com.rest.Model.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddress();
    Address saveAddress(Address address);
    Address updateAddress(Long id,Address address);
}
