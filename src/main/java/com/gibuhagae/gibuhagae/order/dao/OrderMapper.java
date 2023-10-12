package com.gibuhagae.gibuhagae.order.dao;

import com.gibuhagae.gibuhagae.order.dto.OrderManagementDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<OrderManagementDTO> selectNewOrderList();

    int updatePost(String deliveryCompany, String trackingNumber, String selectedOrderNo);
}
