package com.hillel.denisov.homeworks.homeunitmav;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class getElementInTest {
    @Test
    public void testGetElInd(){
        int[] array = new int[]{1,2,3,4,5};
        assertEquals(3,HomeUnitMVN.getElementIn(array,4));
    }
    @Test
    public void testGetElIndMatrix(){
        int[][] array = new int[10][10];
        assertEquals(4,HomeUnitMVN.getElementInMatrix(array,5));
    }
}
