package com.xus.sell.service;

import com.xus.sell.DO.SellerInfo;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-29 11:50
 */
public interface SellerService {

    SellerInfo findSellerInfoByOpenid(String openid);
}
