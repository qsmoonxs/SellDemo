package com.xus.sell.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xus.sell.DO.OrderDetail;
import com.xus.sell.enums.OrderStatusEnum;
import com.xus.sell.enums.PayStatuEnum;
import com.xus.sell.util.EnumUtil;
import com.xus.sell.util.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-23 16:26
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    private String orderId;

    private String buyerName;

    private  String buyerPhone;

    private String buyerAddress;

    /** 买家微信openid .*/
    private String buyerOpenid;

    private BigDecimal orderAmount;

    /** 订单状态，默认新下单 */
    private Integer orderStatus;

    /** 支付状态，默认为未支付 */
    private  Integer payStatus;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    private List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatuEnum getPayStatusEnum() {

        return EnumUtil.getByCode(payStatus, PayStatuEnum.class);
    }
}
