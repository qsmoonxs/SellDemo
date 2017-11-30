package com.xus.sell.repository;

import com.xus.sell.DO.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 下午 8:56 2017-11-05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.findOne(1);
        System.out.print(productCategory.toString());
    }
    @Test
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory();
      //  productCategory.setCategoryId(2);
        productCategory.setCategoryName("boys love");
        productCategory.setCategoryType(3);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2,3,4);

        //这种查询一定要一个无参的构造方法
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
    }
}