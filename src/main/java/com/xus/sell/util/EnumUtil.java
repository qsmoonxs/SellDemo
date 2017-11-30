package com.xus.sell.util;

import com.xus.sell.enums.CodeEnum;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-28 11:36
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer  code, Class<T> enumClass) {

        for (T each: enumClass.getEnumConstants()) {
            if(code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
