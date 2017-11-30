package com.xus.sell.repository;

import com.xus.sell.DO.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-23 15:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456789");
        orderDetail.setOrderId("111");
        orderDetail.setProductId("111");
        orderDetail.setProductName("111");
        orderDetail.setProductPrice(new BigDecimal(1));
        orderDetail.setProductQuantity(1);
        orderDetail.setProductIcon("http://xxxx.jpg");
        OrderDetail res = repository.save(orderDetail);
        Assert.assertNotNull(res);

    }

    @Test
    public void findByOrderId() throws Exception {

        List<OrderDetail> res = repository.findByOrderId("111");
        Assert.assertNotEquals(0, res.size());

    }

}