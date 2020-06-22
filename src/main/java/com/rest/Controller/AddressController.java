package com.rest.Controller;

import com.rest.Model.Address;
import com.rest.Service.AddressService;
import com.rest.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address){
        return addressService.saveAddress(address);
    }

    @PutMapping("{id}")
    public Address updateAddress(@PathVariable("id") Long id, @RequestBody Address address){
        return addressService.updateAddress(id, address);
    }
}
