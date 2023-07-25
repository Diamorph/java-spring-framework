package org.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MyMathTest {

    private MyMath myMath = new MyMath();

    @Test
    public void calculateSumThreeMemberArray() {
        assertEquals(6, myMath.calculateSum(new int[]{1, 2, 3}));
    }

    @Test
    public void calculateSumFiveMemberArray() {
        assertEquals(15, myMath.calculateSum(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void checkEmptyArray() {
        assertEquals(0, myMath.calculateSum(new int[]{}));
    }
}
