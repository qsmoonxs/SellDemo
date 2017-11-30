package com.xus.sell.service.Impl;

import com.xus.sell.DO.SellerInfo;
import com.xus.sell.repository.SellerInfoRepository;
import com.xus.sell.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-29 11:50
 */
@Service
@Slf4j
public class SellerServiceImpl implements SellerService{

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {

        return sellerInfoRepository.findByOpenid(openid);
    }
}
