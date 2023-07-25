package com.diamorph.mockito.mockitodemo.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessImplStubTest {
    DataServiceStub dataServiceStub = new DataServiceStub();


    @Test
    void findTheGreatestFromAllDataBasicScenario() {
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(25, result);
    }

//    @Test
//    void findTheGreatestFromAllDataWithOneValue() {
//        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);
//        int result = businessImpl.findTheGreatestFromAllData();
//        assertEquals(25, result);
//    }
}

class DataServiceStub implements DataService {
    @Override
    public int[] retrieveAllData() {
        return new int[] {25, 15, 5};
    }
}