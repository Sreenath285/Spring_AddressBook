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
        return addressBookRepository.findAll();
    }

    @Override
    public AddressBookData getAddressBookDataById(int contactId) {
        return addressBookRepository.findById(contactId)
                                    .orElseThrow(() -> new AddressBookCustomException("Contact with id " + contactId + " does not exists"));
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
        addressBookData.updateAddressBookData(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }

    @Override
    public void deleteAddressBookData(int contactId) {
        AddressBookData addressBookData = this.getAddressBookDataById(contactId);
        addressBookRepository.delete(addressBookData);
    }
}
