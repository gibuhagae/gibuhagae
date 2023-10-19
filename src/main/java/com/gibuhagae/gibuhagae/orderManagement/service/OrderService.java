package com.gibuhagae.gibuhagae.orderManagement.service;

import com.gibuhagae.gibuhagae.orderManagement.dao.OrderMapper;
import com.gibuhagae.gibuhagae.orderManagement.dto.OrderManagementDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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

    public void addOrderManagement(OrderManagementDTO orderManagementDTO) {

        orderMapper.addOrderManagement(orderManagementDTO);
    }
}

