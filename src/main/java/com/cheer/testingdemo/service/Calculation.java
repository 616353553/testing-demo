package com.cheer.testingdemo.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Calculation {

    public Integer findMax(List<Integer> list) {
        if (list == null) {
            return null;
        }
        Integer max = null;
        for (Integer num: list) {
            if (max == null || max < num) {
                max = num;
            }
        }
        return max;
    }

    public Integer cube(Integer num) {
        if (num == null) {
            return null;
        }
        return num * num * num;
    }

    public String reverseString(String str) {
        if (str == null) {
            return null;
        }
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        char temp;
        while (left < right) {
            temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}
