package com.service;

import org.apache.commons.lang3.StringUtils;

public class WriterService {
    public String write(String name){
       return prefix(name) + content(name) + suffix(name);
    }
    private String prefix(String name){
        return isCapitalized(name)&&name!="" ? "HELLO, " : "Hello, ";
    }
    private String content(String name){
        return StringUtils.isBlank(name)?"my friend":name;
    }
    private String suffix(String name){
        return isCapitalized(name)?"!":".";
    }
    private boolean isCapitalized(String name){
        return StringUtils.isNotBlank(name)&&name.toUpperCase().equals(name);
    }
}
