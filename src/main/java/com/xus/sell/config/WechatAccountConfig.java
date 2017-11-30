package com.xus.sell.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-27 16:44
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

   // @Value("${wechat.mpAppId}")
    private String mpAppId;

    //@Value("${wechat.mpAppSecret}")
    private String mpAppSecret;

    /**
     * 商户号
     */
    private String mchId;

    /**
     * 商户秘钥
     */
    private String  mchKey;

    /**
     * 商户证书路径
     */
    private String keyPath;
}
