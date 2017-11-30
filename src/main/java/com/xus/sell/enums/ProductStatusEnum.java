package com.xus.sell.enums;

import lombok.Getter;

/**
 * @Author: xus
 * @Description: 商品状态
 * @Date: Created in 2017-11-23 11:59
 */

@Getter
public enum ProductStatusEnum implements CodeEnum{
    UP(0, "上架"),
    DOWN(1, "下架")
    ;

    private Integer code;
    private String message;
    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
