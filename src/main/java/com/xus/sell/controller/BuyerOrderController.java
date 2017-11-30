package com.xus.sell.controller;

import com.xus.sell.DTO.OrderDTO;
import com.xus.sell.VO.ResultVO;
import com.xus.sell.converter.OrderFome2OrderDTO;
import com.xus.sell.enums.ResultEnum;
import com.xus.sell.exception.ResponseBankException;
import com.xus.sell.exception.SellException;
import com.xus.sell.form.OrderForm;
import com.xus.sell.service.BuyerService;
import com.xus.sell.service.OrderService;
import com.xus.sell.util.ResultVoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-24 14:23
 */

@RestController
@RequestMapping(value = "/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    // 创建订单
    @PostMapping(value = "/create")
    public ResultVO create (@Valid OrderForm orderForm,
                            BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            log.error("【创建订单】 参数不正确, orderForm = {}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());

        }
        OrderDTO orderDTO = OrderFome2OrderDTO.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】 购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createrResult = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", createrResult.getOrderId());

        return ResultVoUtil.success(map);

    }

    // 订单列表
    @GetMapping(value = "/list")
    public ResultVO list(@RequestParam("openid") String openid,
                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if(StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】 openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
            //throw new ResponseBankException();
        }
        PageRequest request = new PageRequest(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);
        return ResultVoUtil.success(orderDTOPage.getContent());

    }

    // 订单详情
    @GetMapping(value = "/detail")
    public ResultVO detail(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {

        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
        return ResultVoUtil.success(orderDTO);

    }

    // 取消订单
    @PostMapping(value = "/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {

        buyerService.cancelOrder(openid, orderId);
        return ResultVoUtil.success();
    }

}
