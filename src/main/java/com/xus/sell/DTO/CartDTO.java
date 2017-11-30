package com.xus.sell.DTO;

import lombok.Data;

/**
 * @Author: xus
 * @Description: 购物车
 * @Date: Created in 2017-11-23 17:01
 */
@Data
public class CartDTO {

    private String productId;

    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
