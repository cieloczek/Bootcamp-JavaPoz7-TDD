package com.service;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

public class WriterService {
    public String write(String name) {
        return prefix(name) + content(name) + suffix(name);
    }

    private String prefix(String name) {
        return isCapitalized(name) ? "HELLO" : "Hello";
    }

    private String content(String name) {

        StringBuilder sb = new StringBuilder();
        if (StringUtils.isBlank(name)) {
            return ", my friend";
        }
        String[] tmp = name.split(", ");
        if (tmp.length > 1) {
            for (int i = 0; i < tmp.length - 1; i++) {
                sb.append(", " + tmp[i]);
            }
            sb.append((isCapitalized(name) ? " AND " : " and ") + tmp[tmp.length-1]);
        } else {
            sb.append(", ");
            sb.append(name);
        }

        return sb.toString();
    }

    private String suffix(String name) {
        return isCapitalized(name) ? "!" : ".";
    }

    private boolean isCapitalized(String name) {
        return StringUtils.isNotBlank(name) && name.toUpperCase().equals(name);
    }

}
