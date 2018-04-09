package com.service;

import org.apache.commons.lang3.StringUtils;

public class WriterService {
    public String write(String name){
       return prefix(name) + content(name) + suffix(name);
    }
    private String prefix(String name){
        return isCapitalized(name) ? "HELLO" : "Hello";
    }
    private String content(String name){
        int i;
        String conj;   //conjunction
        StringBuilder sb = new StringBuilder();

        try {
            String[]tmp = name.split(", ");
             conj = isCapitalized(name)?" AND ":" and ";
        if(tmp.length>1) {
            for (i = 0; i < tmp.length - 1; i++) {
                sb.append(", " + tmp[i]);
            }
            sb.append(conj + tmp[i]);
        }else{
            sb.append(", ");
            sb.append(name);
        }
        }catch(NullPointerException e){
        }
        return StringUtils.isBlank(name)?", my friend":sb.toString();
    }
    private String suffix(String name){
        return isCapitalized(name)?"!":".";
    }
    private boolean isCapitalized(String name){
        return StringUtils.isNotBlank(name)&&name.toUpperCase().equals(name);
    }

}
