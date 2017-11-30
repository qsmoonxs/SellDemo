package com.xus.sell.service.Impl;

import com.xus.sell.DO.OrderDetail;
import com.xus.sell.DTO.OrderDTO;
import com.xus.sell.enums.OrderStatusEnum;
import com.xus.sell.enums.PayStatuEnum;
import com.xus.sell.enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-23 17:14
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String buyerOpenid = "110110";

    @Test
    public void list() {
        PageRequest request = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());

    }
    @Test
    public void create() throws Exception {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("xus");
        orderDTO.setBuyerAddress("HangZhou");
        orderDTO.setBuyerPhone("1572425508");
        orderDTO.setBuyerOpenid(buyerOpenid);

        // 购物车
        List<OrderDetail> orderDetails = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123456");
        o1.setProductQuantity(1);
        orderDetails.add(o1);
        OrderDetail o2 = new OrderDetail();
        o2.setProductId("123457");
        o2.setProductQuantity(4);
        orderDetails.add(o2);
        orderDTO.setOrderDetailList(orderDetails);
        OrderDTO result = orderService.create(orderDTO);

        log.info("创建订单 result={}",result);

    }

    @Test
    public void findOne() throws Exception {
        OrderDTO result = orderService.findOne("1511489489476888487");
        log.info("查询单个订单 result={}", result);
        //Assert.assertNotNull(result);
        Assert.assertEquals("1511489489476888487", result.getOrderId());
    }

    @Test
    public void findList() throws Exception {
        PageRequest request = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList("110110", request);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    public void cancle() throws Exception {

        OrderDTO orderDTO = orderService.findOne("1511489489476888487");
        OrderDTO result = orderService.cancle(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    public void finish() throws Exception {

        OrderDTO orderDTO = orderService.findOne("1511489654046598645");
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
    }

    @Test
    public void paid() throws Exception {

        OrderDTO orderDTO = orderService.findOne("1511489654046598645");
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatuEnum.SUCCESS.getCode(), result.getPayStatus());
    }

}