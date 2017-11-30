package com.xus.sell.controller;

import com.xus.sell.DO.ProductCategory;
import com.xus.sell.DO.ProductInfo;
import com.xus.sell.DTO.OrderDTO;
import com.xus.sell.exception.SellException;
import com.xus.sell.service.CategoryService;
import com.xus.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-29 9:31
 */

@Controller
@RequestMapping(value = "/seller/product")
public class SellerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map) {

        PageRequest request = new PageRequest(page - 1, size);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        map.put("productInfoPage", productInfoPage);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("product/list",map);

    }

    /**
     * 上架
     * @param productId
     * @param map
     * @return
     */
    @RequestMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productId") String productId,
                               Map<String, Object> map) {
        try {
            productService.onSale(productId);
        } catch (SellException e) {
            map.put("msg",e.getMessage());
            map.put("u", "/sell/seller/product/list");
            return new ModelAndView("common/error",map);
        }

        map.put("msg","Success");
        map.put("u", "/sell/seller/product/list");
        return new ModelAndView("common/success",map);

    }

    /**
     * 下架
     * @param productId
     * @param map
     * @return
     */
    @RequestMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                               Map<String, Object> map) {
        try {
            productService.offSale(productId);
        } catch (SellException e) {
            map.put("msg",e.getMessage());
            map.put("u", "/sell/seller/product/list");
            return new ModelAndView("common/error",map);
        }

        map.put("msg","Success");
        map.put("u", "/sell/seller/product/list");
        return new ModelAndView("common/success",map);

    }

    /**
     *
     * @param productId
     * @param map
     */
    @RequestMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId,
                       Map<String, Object>map) {
        if(!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo",productInfo);
        }

        // 查询所有类目
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("product/index",map);
    }
}
