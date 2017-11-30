package com.xus.sell.exception;

import com.xus.sell.enums.ResultEnum;
import lombok.Getter;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-23 16:37
 */
@Getter
public class SellException  extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {

        // 因为Runtime异常类本身有一个message属性
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
    public SellException(Integer code, String message) {

        super(message);
        this.code = code;
    }
}
