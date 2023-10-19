package com.gibuhagae.gibuhagae.orderManagement.dao;

import com.gibuhagae.gibuhagae.orderManagement.dto.OrderManagementDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderManagementMapper {

    List<OrderManagementDTO> selectNewOrderList();

    int updatePost(String deliveryCompany, String trackingNumber, String selectedOrderNo);

    int addOrderManagement(OrderManagementDTO orderManagementDTO);
}
