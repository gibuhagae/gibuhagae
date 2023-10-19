package com.gibuhagae.gibuhagae.orderManagement.service;

import com.gibuhagae.gibuhagae.orderManagement.dao.OrderManagementMapper;
import com.gibuhagae.gibuhagae.orderManagement.dto.OrderManagementDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderManagementService {

    private final OrderManagementMapper orderMapper;

    public OrderManagementService(OrderManagementMapper orderMapper) { this.orderMapper = orderMapper;}


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

