package com.xus.sell.enums;

import lombok.Getter;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-23 14:40
 */

@Getter
public enum PayStatuEnum implements CodeEnum{

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),

    ;

    private Integer code;

    private String message;

    PayStatuEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
