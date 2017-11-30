package com.xus.sell.repository;

import com.xus.sell.DO.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-23 14:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest() throws  Exception {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("231456");
        orderMaster.setBuyerName("yq");
        orderMaster.setBuyerPhone("15757827853");
        orderMaster.setBuyerAddress("A211");
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setOrderAmount(new BigDecimal(12));
        OrderMaster res = repository.save(orderMaster);
        Assert.assertNotNull(res);
    }

    @Test
    public void findByBuyerOpenid() throws Exception {

        PageRequest request = new PageRequest(0, 1);
        Page<OrderMaster> res = repository.findByBuyerOpenid("110110", request);
        //System.out.println(res.getTotalElements());
        Assert.assertNotEquals(0, res.getTotalElements());

    }

}