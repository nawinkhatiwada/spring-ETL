package com.example.advancejavaassignmentfetchandsave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AdvanceJavaAssignmentFetchAndSaveApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvanceJavaAssignmentFetchAndSaveApplication.class, args);
    }
}
