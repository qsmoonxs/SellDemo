package com.xus.sell.service.Impl;

import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.xus.sell.DTO.OrderDTO;
import com.xus.sell.service.PayService;
import org.springframework.stereotype.Service;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-28 9:13
 */
@Service
public class PayServiceImpl implements PayService {

    @Override
    public void create(OrderDTO orderDTO) {

        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
       // bestPayService.setWxPayH5Config();
    }
}
