package com.diamorph.learnspringframework.exercises.ex1.dataservice;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessCalculationService {
    private DataService dataService;

//    public BusinessCalculationService(@Qualifier("mySQLDataServiceQualifier") DataService dataService) {
//        this.dataService = dataService;
//    }

    public BusinessCalculationService(DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax() {
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}
