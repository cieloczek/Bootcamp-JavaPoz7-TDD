package com.sda;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    //given
    public void init() {
        this.calculator = new Calculator();
    }@Test
    public void testAdd(){
      init();
//      //given
//      Calculator calculator = new Calculator();
        //when
        int sum = calculator.sum(3,6);
        //then
        Assert.assertEquals(9,sum);

    } @Test
    public void testSubstract(){
        init();
        int substract = calculator.subststract(3,6);
        Assert.assertEquals(-3,substract);

    } @Test
    public void testDivide(){
        init();
        int div   = calculator.divide(12,6);
        Assert.assertEquals(2,div);

    } @Test
    public void testMultiply(){
        init();
        int mult = calculator.multiply(3,6);
        Assert.assertEquals(18,mult);

    } @Test
    public void testAverage(){
        init();
        int avg = calculator.average(2,6);
        Assert.assertEquals(4,avg);
    }
    @Test
    public void sumFromArrayTest(){
        //given
        init();
        String i = "2.3:4]1'4[5";
        //when
        int result = calculator.sumFromArray(i);
        //then
        Assert.assertEquals(19,result);
    }
}
