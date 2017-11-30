package com.xus.sell.service;

import com.xus.sell.DTO.OrderDTO;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-27 13:43
 */
public interface BuyerService {

    // 查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    // 取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
