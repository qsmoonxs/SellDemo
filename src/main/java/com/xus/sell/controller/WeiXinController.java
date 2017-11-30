package com.xus.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-27 15:53
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeiXinController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {

        log.info("进入auth方法");
        log.info("code={}",code);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx26855ba1b562591e&secret=9e2e7967d45b0591f8deadeffad036f6&code="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String respon = restTemplate.getForObject(url, String.class);
        log.info("response={}",respon);
    }
}

