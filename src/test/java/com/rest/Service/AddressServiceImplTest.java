package com.rest.Service;

import com.rest.Model.Address;
import com.rest.Model.StudentGroup;
import com.rest.Repository.AddressRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AddressServiceImplTest {

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressServiceImpl addressService;

    public Address generateAddress(){
        Address address = new Address();
        address.setId(1);
        address.setCountry("USA");
        address.setCity("Boston");
        return address;
    }

    @Test
    public void shouldAddressCreate(){
        Address address = generateAddress();
        Address newAddress = addressService.saveAddress(address);
        Assertions.assertThat(newAddress.getId()).isNotEqualTo(null);
    }

    @Test
    public void shouldGetAllAddress(){
        Address address1 = generateAddress();
        Address address2 = generateAddress();
        when(addressRepository.findAll()).thenReturn(List.of(address1, address2));
        List<Address> addresses = addressService.getAllAddress();
        Assertions.assertThat(addresses.size()).isEqualTo(2);
    }
}
