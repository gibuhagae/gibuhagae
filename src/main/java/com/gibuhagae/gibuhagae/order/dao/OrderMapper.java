package com.gibuhagae.gibuhagae.order.dao;

import com.gibuhagae.gibuhagae.order.dto.CancelListDTO;
import com.gibuhagae.gibuhagae.order.dto.OrderManagementDTO;
import com.gibuhagae.gibuhagae.order.dto.ReturnRequestDTO;
import com.gibuhagae.gibuhagae.order.dto.SwapRequestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<OrderManagementDTO> selectNewOrderList();

    int updatePost(String deliveryCompany, String registrationNo, Long selectedOrderNo);

    void updateOrderStatus(String orderStatus, Long selectedOrderNo);

    List<OrderManagementDTO> selectShippingOrderList();

    List<OrderManagementDTO> OrderReadyList();

    List<OrderManagementDTO> orderCompleteList();

    List<OrderManagementDTO> orderCancelList();


    void cancelOrder(Long selectedOrderNo);

    List<CancelListDTO> selectCancelOrderList();

    List<OrderManagementDTO> orderReturnList();

    void returnOrder(Long selectedOrderNo);

    List<ReturnRequestDTO> returnDetailList();

    List<OrderManagementDTO> orderSwapList();

    void swapOrder(Long selectedOrderNo, String orderStatus);

    List<SwapRequestDTO> swapDetailList();
}

