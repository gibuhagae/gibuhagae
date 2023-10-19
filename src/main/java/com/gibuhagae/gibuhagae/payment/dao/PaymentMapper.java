package com.gibuhagae.gibuhagae.payment.dao;

import com.gibuhagae.gibuhagae.payment.dto.PaymentDTO;
import com.gibuhagae.gibuhagae.payment.dto.PaymentDTOlist;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {
    int addPayment(PaymentDTO paymentDTO);

    int addOrderManagement(PaymentDTO paymentDTO);

    int addOrderDetail(PaymentDTOlist paymentDTOList);

    int addPost(PaymentDTO paymentDTO);

    void additem();
}
