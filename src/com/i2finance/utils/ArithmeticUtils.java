package com.i2finance.utils;

import java.util.Random;

/**
 * @author 白昊天
 * @date 2018/1/20
 **/
public class ArithmeticUtils {

    public static int random(int begin,int end){
        if(begin>end){
            begin += end;
            end = begin - end;
            begin = begin - end;
        }
        int size = end - begin + 1;
        Random random = new Random();
        int i = random.nextInt(size)+1;

        return i;
    }

}
