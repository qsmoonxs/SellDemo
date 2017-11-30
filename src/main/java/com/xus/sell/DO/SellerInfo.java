package com.xus.sell.DO;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-29 11:37
 */
@Entity
@Data
public class SellerInfo {

    @Id
    private String id;

    private String username;

    private String password;

    private String openid;



}
