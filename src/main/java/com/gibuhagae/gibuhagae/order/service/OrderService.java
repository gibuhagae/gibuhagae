package com.gibuhagae.gibuhagae.order.service;

import com.gibuhagae.gibuhagae.order.dao.OrderMapper;
import com.gibuhagae.gibuhagae.order.dto.CancelListDTO;
import com.gibuhagae.gibuhagae.order.dto.OrderManagementDTO;
import com.gibuhagae.gibuhagae.order.dto.ReturnRequestDTO;
import com.gibuhagae.gibuhagae.order.dto.SwapRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    private final OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }


    public List<OrderManagementDTO> selectNewOrderList() {


        return orderMapper.selectNewOrderList();
    }


    @Transactional
    public int updatePost(String deliveryCompany, String registrationNo, Long selectedOrderNo) {


        int ret = orderMapper.updatePost(deliveryCompany, registrationNo, selectedOrderNo);


        return ret;
    }


    @Transactional
    public void updateOrderStatus(String orderStatus, Long selectedOrderNo) {
        orderMapper.updateOrderStatus(orderStatus, selectedOrderNo);
    }

    public List<OrderManagementDTO> OrderReadyList() {

        return orderMapper.OrderReadyList();
    }

    public List<OrderManagementDTO> selectShippingOrderList() {

        return orderMapper.selectShippingOrderList();
    }

    public List<OrderManagementDTO> orderCompleteList() {

        return orderMapper.orderCompleteList();
    }

    public List<OrderManagementDTO> orderCancelList() {

        return orderMapper.orderCancelList();
    }

    @Transactional
    public void cancelOrder(Long selectedOrderNo) {

        orderMapper.cancelOrder(selectedOrderNo);
    }

    public List<CancelListDTO> selectCancelOrderList() {

        return orderMapper.selectCancelOrderList();
    }

    public List<OrderManagementDTO> orderReturnList() {
        return orderMapper.orderReturnList();
    }

    public void returnOrder(Long selectedOrderNo) {

        orderMapper.returnOrder(selectedOrderNo);
    }

    public List<ReturnRequestDTO> returnDetailList() {
        return orderMapper.returnDetailList();
    }

    public List<OrderManagementDTO> orderSwapList() {
        return orderMapper.orderSwapList();
    }

    public void swapOrder(Long selectedOrderNo , String orderStatus) {
        orderMapper.swapOrder(selectedOrderNo ,orderStatus);
    }

    public List<SwapRequestDTO> swapDetailList() {
        return orderMapper.swapDetailList();
    }

    // summary 혁 2023-10-18
    public List<Integer> selectOrderDetailPK(int orderManageCode) {
        return orderMapper.selectOrderDetailPK(orderManageCode);
    }

    @Transactional
    public boolean modifyOrderDetailStatus(Long orderManageNo, String orderStatus) {
        int ret = orderMapper.modifyOrderDetailStatus(orderManageNo, orderStatus);
        System.out.println("modifyOrderDetailStatus 매핑 검사 후");
        return ret > 0;
    }

    @Transactional
    public boolean insertRefundManagement(String reasonText, String orderDetailCode) {
        int ret = orderMapper.insertRefundManagement(reasonText, orderDetailCode);
        return ret > 0;
    }

    @Transactional
    public boolean insertSwapManagement(String reasonText, String orderDetailCode) {
        int ret = orderMapper.insertSwapManagement(reasonText, orderDetailCode);
        return ret > 0;
    }

    public List<OrderManagementDTO> selectNewOrderList2() {
        return orderMapper.selectNewOrderList2();
    }
}

