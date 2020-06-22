package com.rest.Service;

import com.rest.Model.Address;
import com.rest.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    String chars = "!@#$%^&*()_+?><{}|\\=`~1234567890";

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Address saveAddress(Address address) {
        if (address.getCountry().length() < 3) {
            throw new IllegalStateException("Country name too short");
        }
        if (address.getCity().length() < 3) {
            throw new IllegalStateException("City name too short");
        }
        for (int i = 0; i < chars.length(); i++) {
            char j = chars.charAt(i);
            String symbol = String.valueOf(j);

            if (address.getCountry().contains(symbol)) {
                throw new IllegalStateException("Country Name contains special characters or numbers");
            }
            if (address.getCity().contains(symbol)) {
                throw new IllegalStateException("City Name contains special characters or numbers");
            }
        }

        Address address1 = addressRepository.save(address);
        return address1;
    }

    @Override
    public Address updateAddress(Long id, Address address) {
        Address newAddress = addressRepository.findById(id).get();
        if (address.getCity() != null) {
            for (int i = 0; i < chars.length(); i++) {
                char j = chars.charAt(i);
                String symbol = String.valueOf(j);
                if (address.getCity().contains(symbol)) {
                    throw new IllegalStateException("City Name contains special characters or numbers");
                } else if (address.getCity().length() < 3) {
                    throw new IllegalStateException("City name too short");
                }
            }
            newAddress.setCity(address.getCity());
        }
        if (address.getCountry() != null) {
            for (int i = 0; i < chars.length(); i++) {
                char j = chars.charAt(i);
                String symbol = String.valueOf(j);
                if (address.getCountry().contains(symbol)) {
                    throw new IllegalStateException("Country Name contains special characters or numbers");
                } else if (address.getCountry().length() < 3) {
                    throw new IllegalStateException("Country name too short");
                }
            }
            newAddress.setCountry(address.getCountry());
        }
        addressRepository.save(newAddress);
        return newAddress;
    }

}
