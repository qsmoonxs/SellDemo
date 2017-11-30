package com.xus.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-23 13:51
 */
@Data
public class ProductInfoVO implements Serializable {


    private static final long serialVersionUID = 445290812212924949L;
    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String  productIcon;
}
