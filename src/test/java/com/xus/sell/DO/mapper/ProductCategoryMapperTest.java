package com.xus.sell.DO.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-29 21:47
 */

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;
    @Test
    public void insertByMap() throws Exception {

        Map<String, Object> map = new HashMap<>();
        map.put("category_name","old love");
        map.put("category_type",101);
        int res = mapper.insertByMap(map);
        Assert.assertEquals(1,res);
    }

}