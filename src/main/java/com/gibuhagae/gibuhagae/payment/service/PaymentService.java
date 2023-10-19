package com.gibuhagae.gibuhagae.payment.service;
l

import com.gibuhagae.gibuhagae.member.dto.MemberDTO;

import com.gibuhagae.gibuhagae.payment.dao.PaymentMapper;
import com.gibuhagae.gibuhagae.payment.dto.PaymentDTO;
import com.gibuhagae.gibuhagae.payment.dto.PaymentDTOlist;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class PaymentService {

    private final PaymentMapper paymentMapper;

    public PaymentService(PaymentMapper paymentMapper) {
        this.paymentMapper = paymentMapper;
    }
    public void addPayment(PaymentDTO paymentDTO) {
        System.out.println("service " + paymentDTO);

        paymentMapper.addPayment(paymentDTO);
    }


    public void addOrderManagement(PaymentDTO paymentDTO) {

            if (paymentDTO.getCheckReward().equals("Y")) {
                paymentMapper.addOrderManagement(paymentDTO);
            } else if (paymentDTO.getCheckReward().equals("N")) {
                paymentDTO.setRewardAmount(0);
                paymentMapper.addOrderManagement(paymentDTO);
            }
    }

    public void addOrderDetail(PaymentDTO paymentDTO) {

        System.out.println("sibal" + paymentDTO);
        System.out.println("@@@@@paymentDTO :  " + paymentDTO) ;// 4

        for (int i = 0; i < paymentDTO.getItemCode().size(); i++) {
            PaymentDTOlist paymentDTOlist = new PaymentDTOlist();

            paymentDTOlist.setItemPrice(paymentDTO.getItemPrice().get(i));
            paymentDTOlist.setCount(paymentDTO.getCount().get(i));
            paymentDTOlist.setItemCode(paymentDTO.getItemCode().get(i));
            paymentDTOlist.setOptionCode(paymentDTO.getOptionCode().get(i));
            System.out.println(paymentDTOlist + "@@@@@@@@@");
            int result = paymentMapper.addOrderDetail(paymentDTOlist);


        System.out.println("@@@@@리절트값 :  " + result) ;// 4

        }
    }

    public void addPost(PaymentDTO paymentDTO) {

            paymentMapper.addPost(paymentDTO);

    }
}
