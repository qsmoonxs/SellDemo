package com.xus.sell.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: xus
 * @Description: HTTP请求返回的最外层对象
 * @Date: Created in 2017-11-23 13:42
 */
@Data
public class ResultVO<T> implements Serializable{


    private static final long serialVersionUID = -7129300688551327326L;
    /** 错误码 .*/
    private Integer code;

    /** 提示信息 .*/
    private String msg;

    /** 具体内容 .*/
    private T data;
}
