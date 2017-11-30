package com.xus.sell.service.Impl;

import com.xus.sell.DO.SellerInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-29 11:52
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SellerServiceImplTest {

    @Autowired
    private SellerServiceImpl sellerService;

    @Test
    public void findSellerInfoByOpenid() throws Exception {

        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid("abc");
        Assert.assertEquals("abc",sellerInfo.getOpenid());
    }

}