package com.xus.sell.repository;

import com.xus.sell.DO.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-29 11:39
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String>{

    SellerInfo findByOpenid(String openid);
}
