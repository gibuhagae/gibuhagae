package com.gibuhagae.gibuhagae.order.service;

import com.gibuhagae.gibuhagae.order.dao.OrderMapper;
import com.gibuhagae.gibuhagae.order.dto.OrderManagementDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    private final OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper) { this.orderMapper = orderMapper;}


    public List<OrderManagementDTO> selectNewOrderList() {


        return orderMapper.selectNewOrderList();
    }


    @Transactional
    public int updatePost(String deliveryCompany, String trackingNumber, String selectedOrderNo) {
        int ret = orderMapper.updatePost(deliveryCompany,trackingNumber, selectedOrderNo);


      return ret;
    }
}

