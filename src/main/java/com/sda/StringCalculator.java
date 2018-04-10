package com.sda;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.IntStream;

public class StringCalculator {
    public int calculate(String input){
        int result=0;
        if(StringUtils.isBlank(input)){
            return 0;
        }
        String[] elements = input.split("[ ]+|[,]+|[;]+");
//      String textWithoutWhiteSpaces =   StringUtils.deleteWhitespace(input)
//      String[] elements = StringUtils.split(textWithoutWhiteSpaces,";");
//      elements=elements==null?new String[0] : elements;
        for(String number : elements){
            result+=Integer.valueOf(number);
        }
        return result;
    }
}
