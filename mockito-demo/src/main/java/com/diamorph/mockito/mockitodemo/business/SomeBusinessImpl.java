package com.diamorph.mockito.mockitodemo.business;

import java.util.Arrays;
import java.util.stream.Stream;
public class SomeBusinessImpl {

    private DataService dataService;

    public SomeBusinessImpl(DataService dataService) {
        this.dataService = dataService;
    }

    public int findTheGreatestFromAllData() {
        int[] data = dataService.retrieveAllData();
        return Stream.of(data).flatMapToInt(Arrays::stream).max().orElse(Integer.MIN_VALUE);
    }
}

interface DataService {
    int[] retrieveAllData();
}
