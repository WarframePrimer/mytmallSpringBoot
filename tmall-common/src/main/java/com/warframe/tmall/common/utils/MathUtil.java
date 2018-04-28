package com.warframe.tmall.common.utils;

/**
 * @author yaojiabin
 * @Description'
 * @date 2018-04-27 15:49
 */
public class MathUtil {

    public static int toIntExact(long value) {
        if ((int)value != value) {
            throw new ArithmeticException("integer overflow");
        }
        return (int)value;
    }
}
