package com.xus.sell.service.Impl;

import com.xus.sell.DTO.OrderDTO;
import com.xus.sell.enums.ResultEnum;
import com.xus.sell.exception.SellException;
import com.xus.sell.service.BuyerService;
import com.xus.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-27 13:45
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {

        return checkOrderOwner(openid, orderId);

    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if(orderDTO == null) {
            log.error("【取消订单】查不到该订单, orderId={}",orderDTO.getOrderId());
            throw new SellException(ResultEnum.ORDER_NOT_EXIT);
        }
        return orderService.cancle(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId) {

        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null) {
            return null;
        }
        // 判断订单是否属于当前用户
        if(!orderDTO.getBuyerOpenid().equals(orderId)) {
            log.error("【查询订单】订单的openid不一致, openid = {}, orderDTO={}", openid, orderDTO.getBuyerOpenid());
            throw new SellException((ResultEnum.ORDER_OWNER_ERROR));
        }
        return orderDTO;
    }
}
