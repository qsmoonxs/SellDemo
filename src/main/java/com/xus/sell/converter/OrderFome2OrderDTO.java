package com.xus.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xus.sell.DO.OrderDetail;
import com.xus.sell.DTO.OrderDTO;
import com.xus.sell.enums.ResultEnum;
import com.xus.sell.exception.SellException;
import com.xus.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-24 14:53
 */
@Slf4j
public class OrderFome2OrderDTO {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("【对象转换】 错误, string = {}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }

}
