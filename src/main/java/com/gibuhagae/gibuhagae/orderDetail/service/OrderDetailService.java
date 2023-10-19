package com.gibuhagae.gibuhagae.orderDetail.service;

import com.gibuhagae.gibuhagae.basket.dto.BasketDTO;
import com.gibuhagae.gibuhagae.orderDetail.dao.OrderDetailMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderDetailService {

    private final OrderDetailMapper orderDetailMapper;

    public OrderDetailService(OrderDetailMapper orderDetailMapper) {
        this.orderDetailMapper = orderDetailMapper;
    }


}
