package com.diamorph.learnspringaop.aopexample.data;


import com.diamorph.learnspringaop.aopexample.annotations.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {

    @TrackTime
    public int[] retrieveData() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new int[] {11, 22, 33, 44, 55};
    }
}
