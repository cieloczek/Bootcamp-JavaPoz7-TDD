package com.sda;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

public class
StringCalculator {
    public int calculate(String input){

        if(StringUtils.isBlank(input) || input == null){
            return 0;
        }
        String[] elements = input.split("[ ,.;']+");                            //my method
//      String textWithoutWhiteSpaces =   StringUtils.deleteWhitespace(input)       //made by classmates
//      String[] elements = StringUtils.split(textWithoutWhiteSpaces,";");
//      elements=elements==null?new String[0] : elements;
        return Arrays.stream(elements).mapToInt(e ->Integer.valueOf(e)).sum();

    }
}
