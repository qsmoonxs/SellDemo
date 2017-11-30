package com.xus.sell.repository;

import com.xus.sell.DO.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-11-23 14:48
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);
}
