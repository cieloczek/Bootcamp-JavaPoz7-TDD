package com.sda;

import org.apache.commons.lang3.StringUtils;

public class Calculator {

    public int sum(int a, int b){
     return a+b;
    }public int subststract(int a, int b){
     return a-b;
    }public int divide(int a, int b){
     return a/b;
    }public int multiply(int a, int b){
     return a*b;
    }public int average(int a, int b){
     return (a+b)/2;
    }public int sumFromArray(String input){
        String[] elements = input.split("\\p{Punct}");
        int result=0;
        for(String number : elements){
            result+=Integer.valueOf(number);
        }return result;
    }
}
