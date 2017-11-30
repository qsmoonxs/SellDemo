package com.xus.sell.DO;

import com.xus.sell.enums.OrderStatusEnum;
import com.xus.sell.enums.PayStatuEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-23 14:30
 */
@Entity
@Data
public class OrderMaster {

    @Id
    private String orderId;

    private String buyerName;

    private  String buyerPhone;

    private String buyerAddress;

    /** 买家微信openid .*/
    private String buyerOpenid;

    private BigDecimal orderAmount;

    /** 订单状态，默认新下单 */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态，默认为未支付 */
    private  Integer payStatus = PayStatuEnum.WAIT.getCode();

    private Date createTime;

    private Date updateTime;

}
