package com.sreenath.addressbook.service;

import com.sreenath.addressbook.dto.AddressBookDTO;
import com.sreenath.addressbook.exceptions.AddressBookCustomException;
import com.sreenath.addressbook.model.AddressBookData;
import com.sreenath.addressbook.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService{
    @Autowired
    private AddressBookRepository addressBookRepository;

    private List<AddressBookData> addressBookDataList = new ArrayList<>();

    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBookDataList;
    }

    @Override
    public AddressBookData getAddressBookDataById(int contactId) {
        return addressBookDataList.stream()
                                  .filter(addressBookData -> addressBookData.getContactId() == contactId)
                                  .findFirst()
                                  .orElseThrow(() -> new AddressBookCustomException("Contact with id " + contactId + " not found"));
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(addressBookDTO);
        log.debug("Address book data : " + addressBookData.toString());
        return addressBookRepository.save(addressBookData);
    }

    @Override
    public AddressBookData updateAddressBookData(int contactId, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getAddressBookDataById(contactId);
        addressBookData.setFirstName(addressBookDTO.firstName);
        addressBookData.setLastName(addressBookDTO.lastName);
        addressBookData.setAddress(addressBookDTO.address);
        addressBookData.setCity(addressBookDTO.city);
        addressBookData.setState(addressBookDTO.state);
        addressBookData.setEmail(addressBookDTO.email);
        addressBookData.setPhoneNumber(addressBookDTO.phoneNumber);
        addressBookData.setZipCode(addressBookDTO.zipCode);
        addressBookDataList.set(contactId - 1, addressBookData);
        return addressBookData;
    }

    @Override
    public void deleteAddressBookData(int contactId) {
        addressBookDataList.remove(contactId - 1);
    }
}
