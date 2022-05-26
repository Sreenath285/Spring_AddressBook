package com.sreenath.addressbook.service;

import com.sreenath.addressbook.dto.AddressBookDTO;
import com.sreenath.addressbook.model.AddressBookData;

import java.util.List;

public interface IAddressBookService {
    List<AddressBookData> getAddressBookData();

    AddressBookData getAddressBookDataById(int contactId);

    AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);

    AddressBookData updateAddressBookData(int contactId, AddressBookDTO addressBookDTO);

    void deleteAddressBookData(int contactId);
}
