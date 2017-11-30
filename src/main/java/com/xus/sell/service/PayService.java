package com.xus.sell.service;

import com.xus.sell.DTO.OrderDTO;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-28 9:12
 */
public interface PayService {

    void create(OrderDTO orderDTO);
}
