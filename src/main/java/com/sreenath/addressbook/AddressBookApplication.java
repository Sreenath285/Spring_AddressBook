package com.sreenath.addressbook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class AddressBookApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(AddressBookApplication.class, args);
        log.info("Address Book App started in {} environment",
                  applicationContext.getEnvironment().getProperty("environment"));
    }

}
