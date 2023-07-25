package com.diamorph.learnspringaop.aopexample.business;

import com.diamorph.learnspringaop.aopexample.data.DataService2;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService2 {

    private DataService2 dataService;

    public BusinessService2(DataService2 dataService2) {
        this.dataService = dataService2;
    }

    public int calculateMin() {
        int[] data = dataService.retrieveData();

//        try {
//            Thread.sleep(30);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        throw new RuntimeException("Something went wrong!");
        return Arrays.stream(data).min().orElse(0);
    }
}
