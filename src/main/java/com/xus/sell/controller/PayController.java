package com.xus.sell.controller;

import com.xus.sell.DTO.OrderDTO;
import com.xus.sell.enums.ResultEnum;
import com.xus.sell.exception.SellException;
import com.xus.sell.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-28 9:09
 */

@Controller
@RequestMapping(value = "/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/create")
    public void create(@RequestParam("orderId") String orderId,
                       @RequestParam("returnUrl") String returnUrl) {
        // 1. 查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIT);
        }

        // 2. 发起支付


    }
}
