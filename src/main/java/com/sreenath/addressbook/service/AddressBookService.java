package com.sreenath.addressbook.service;

import com.sreenath.addressbook.dto.AddressBookDTO;
import com.sreenath.addressbook.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService{
    @Override
    public List<AddressBookData> getAddressBookData() {
        List<AddressBookData> addressBookDataList = new ArrayList<>();
        addressBookDataList.add(new AddressBookData(1, new AddressBookDTO("Sreenath", "Emidi",
                                                                                  "Hanuman Nagar", "Adoni",
                                                                                  "Andhra Pradesh", "sree@gmail.com",
                                                                                  "9988776655", "518301")));
        return addressBookDataList;
    }

    @Override
    public AddressBookData getAddressBookDataById(int contactId) {
        AddressBookData addressBookData = new AddressBookData(1, new AddressBookDTO("Sreenath", "Emidi",
                                                                                            "Hanuman Nagar", "Adoni",
                                                                                            "Andhra Pradesh", "sree@gmail.com",
                                                                                            "9988776655", "518301"));
        return addressBookData;
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(1, addressBookDTO);
        return addressBookData;
    }

    @Override
    public AddressBookData updateAddressBookData(int contactId, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(contactId, addressBookDTO);
        return addressBookData;
    }

    @Override
    public void deleteAddressBookData(int contactId) {

    }
}
