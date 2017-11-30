package com.xus.sell.converter;

import com.xus.sell.DO.OrderMaster;
import com.xus.sell.DTO.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-24 11:07
 */
public class OrderMastet2OrderDToConverter {

    public static OrderDTO convert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasters) {
        return orderMasters.stream()
                .map(e -> convert(e)).collect(Collectors.toList());
    }
}
