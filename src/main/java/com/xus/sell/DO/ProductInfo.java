package com.xus.sell.DO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xus.sell.enums.ProductStatusEnum;
import com.xus.sell.util.EnumUtil;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-23 11:37
 */
@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    /** 状态， 0正常1下架. */
    private Integer productStatus;

    private Integer categoryType;

    private Date createTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }
}
