package com.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WriterServiceTest {
    private WriterService writerService;
    @Before
    public void init(){
        this.writerService = new WriterService();
    }
    @Test
    public void testOne(){
        //given
        init();
        String name = "Mateusz";
        //when
        String result = writerService.write(name);

        //then
        Assert.assertEquals("Hello, Mateusz.",result);

    }
    @Test
    public void testSecond(){
        //given
        init();
        String name = null;
        //when
        String result = writerService.write(name);
        //then
        Assert.assertEquals("Hello, my friend.", result);
    }
    @Test
    public void testCapitalize(){
        //given
        init();
        String name = "MATEUSZ";
        //when
        String result = writerService.write(name);
        //then
        Assert.assertEquals("HELLO, MATEUSZ!", result);
    }
    @Test
    public void testEmptyString(){
        //given
        init();
        String name = "";
        //when
        String result = writerService.write(name);
        //then
        Assert.assertEquals("Hello, my friend.", result);
    }
    @Test
    public void isEmptyName(){
        //given
        String name = "   ";
        //when
        String result = writerService.write(name);
        //then
        Assert.assertEquals("Hello, my friend.",result);
    }

}
