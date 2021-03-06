package com.sreenath.addressbook.controller;

import com.sreenath.addressbook.dto.AddressBookDTO;
import com.sreenath.addressbook.dto.ResponseDTO;
import com.sreenath.addressbook.model.AddressBookData;
import com.sreenath.addressbook.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookRestController {
    @Autowired
    private IAddressBookService iAddressBookService;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        List<AddressBookData> addressBookDataList = iAddressBookService.getAddressBookData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success", addressBookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{contactId}")
    public ResponseEntity<ResponseDTO> getAddressBookDataById(@PathVariable("contactId") int contactId) {
        AddressBookData addressBookData = iAddressBookService.getAddressBookDataById(contactId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success for Id", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/sortbycity")
    public ResponseEntity<ResponseDTO> sortAddressBookDataByCity() {
        List<AddressBookData> addressBookDataList = iAddressBookService.sortByCity();
        ResponseDTO responseDTO = new ResponseDTO("Get call success for sort by city", addressBookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/sortbystate")
    public ResponseEntity<ResponseDTO> sortAddressBookDataByState() {
        List<AddressBookData> addressBookDataList = iAddressBookService.sortByState();
        ResponseDTO responseDTO = new ResponseDTO("Get call success for sort by state", addressBookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = iAddressBookService.createAddressBookData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Address Book data", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{contactId}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("contactId") int contactId,
                                                             @Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = iAddressBookService.updateAddressBookData(contactId, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Address Book data for Id", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("contactId") int contactId) {
        iAddressBookService.deleteAddressBookData(contactId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Deleted Id : " + contactId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
