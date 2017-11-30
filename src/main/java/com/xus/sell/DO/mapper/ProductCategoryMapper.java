package com.xus.sell.DO.mapper;

import org.apache.ibatis.annotations.Insert;

import java.util.Map;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-29 21:43
 */
public interface ProductCategoryMapper {

    @Insert("insert into product_category(category_name,category_type) values (#{category_name,jdbcType=VARCHAR}, #{category_type,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);
}
