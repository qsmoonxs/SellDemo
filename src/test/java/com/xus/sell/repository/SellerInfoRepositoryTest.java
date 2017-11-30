package com.xus.sell.repository;

import com.xus.sell.DO.SellerInfo;
import com.xus.sell.util.KeyUtil;
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
 * @Date: Created in 2017-11-29 11:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository repository;

    @Test
    public void save() {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setOpenid("abc");
        sellerInfo.setId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("xus");
        sellerInfo.setPassword("xus");
        SellerInfo res = repository.save(sellerInfo);
        Assert.assertNotNull(res);

    }
    @Test
    public void findByOpenid() throws Exception {
        SellerInfo res = repository.findByOpenid("abc");
        Assert.assertEquals("abc",res.getOpenid());
    }

}