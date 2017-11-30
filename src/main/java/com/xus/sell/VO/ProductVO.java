package com.xus.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: xus
 * @Description: 商品（包含类目）
 * @Date: Created in 2017-11-23 13:48
 */
@Data
public class ProductVO implements Serializable {


    private static final long serialVersionUID = -4223226336998873732L;
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
