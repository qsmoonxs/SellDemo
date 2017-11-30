package com.xus.sell.controller;

import com.xus.sell.DTO.OrderDTO;
import com.xus.sell.enums.ResultEnum;
import com.xus.sell.exception.SellException;
import com.xus.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Author: xus
 * @Description: 卖家端注解
 * @Date: Created in 2017-11-28 10:07
 */

@Controller
@RequestMapping(value = "/seller/order")
@Slf4j
public class SellerOrderController {

    @Autowired
    private OrderService orderService;
    /**
     * 订单列表
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map) {

        PageRequest request = new PageRequest(page - 1, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        map.put("orderDTOPage", orderDTOPage);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("order/list",map);

    }

    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {

        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.cancle(orderDTO);
        } catch (SellException e) {
                log.error("【卖家端取消订单】 发生异常");
                map.put("msg", e.getMessage());
                map.put("u","/sell/seller/order/list");
                return new ModelAndView("common/error", map);

        }
        map.put("msg", "SUCCESS");
        map.put("u","/sell/seller/order/list");
        return new ModelAndView("common/success");
    }

    /**
     * 订单详情
     * @param orderId
     * @param map
     * @return
     */
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {

        OrderDTO orderDTO = new OrderDTO();
        try {
             orderDTO = orderService.findOne(orderId);
        } catch (SellException e) {
            log.error("【卖家端查询订单】 发生异常 {}",e);
            map.put("msg", e.getMessage());
            map.put("u","/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("orderDTO", orderDTO);
        return new ModelAndView("order/detail",map);

    }

    /**
     * 完结订单
     * @param orderId
     * @param map
     * @return
     */
    @GetMapping(value = "/finish")
    public ModelAndView finish(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {

        OrderDTO orderDTO = new OrderDTO();
        try {
             orderDTO = orderService.findOne(orderId);
            orderService.finish(orderDTO);
        }catch (SellException e) {
            log.error("【卖家端完结订单】 发生异常 {}",e);
            map.put("msg", e.getMessage());
            map.put("u","/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", "success");
        map.put("u","/sell/seller/order/list");
        return new ModelAndView("common/success",map);
    }
}
