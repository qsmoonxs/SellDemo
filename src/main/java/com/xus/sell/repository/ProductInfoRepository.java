package com.xus.sell.repository;

import com.xus.sell.DO.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-23 11:42
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
