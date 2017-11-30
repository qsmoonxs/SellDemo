package com.xus.sell.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-23 14:35
 */

@Getter
public enum OrderStatusEnum implements CodeEnum {

    NEW(0, "新订单"),
    FINISHED(1, "完成的订单"),
    CANCEL(2, "取消的订单")
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
