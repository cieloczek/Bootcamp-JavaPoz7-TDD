package com.sda;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @Before
    //given
    public void init(){
        this.calculator=new StringCalculator();
    }@Test
    public void testForBlank() {
        init();
        int substract = calculator.calculate(" ");
        Assert.assertEquals(0, substract);
    }@Test
    public void testForNull() {
        init();
        String a =null;
        int substract = calculator.calculate(a);
        Assert.assertEquals(0, substract);

    }@Test
    public void addMultipleNumbers(){
        init();
        int substract = calculator.calculate("4;;;2    2;2,,,1");
        Assert.assertEquals(11, substract);
    }
}
