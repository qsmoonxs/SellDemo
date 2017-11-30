package com.xus.sell.repository;

import com.xus.sell.DO.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 下午 8:53 2017-11-05
 */

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
