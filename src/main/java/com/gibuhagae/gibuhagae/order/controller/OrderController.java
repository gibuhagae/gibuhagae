package com.gibuhagae.gibuhagae.order.controller;


import com.gibuhagae.gibuhagae.order.dto.CancelListDTO;
import com.gibuhagae.gibuhagae.order.dto.OrderManagementDTO;
import com.gibuhagae.gibuhagae.order.dto.ReturnRequestDTO;
import com.gibuhagae.gibuhagae.order.dto.SwapRequestDTO;
import com.gibuhagae.gibuhagae.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;



    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }



    @GetMapping("/order-new")
    public String getNewOrderList(Model model) {


        List<OrderManagementDTO> newOrderList = orderService.selectNewOrderList();


        log.info(newOrderList.toString());

        model.addAttribute("newOrderList", newOrderList);

        return "order/order-new";

    }

    @PostMapping("/order-new")
    public String updatePost(@RequestParam(required = false) String deliveryCompany,
                             @RequestParam(required = false) String registrationNo,
                             @RequestParam(required = false) Long selectedOrderNo,
                             @RequestParam(required = false) String orderStatus,
                             Model model) {



        orderService.updatePost(deliveryCompany, registrationNo, selectedOrderNo);
        orderService.updateOrderStatus(orderStatus, selectedOrderNo);



        model.addAttribute("deliveryCompany", deliveryCompany);
        model.addAttribute("registrationNo", registrationNo);



        return "redirect:/order/order-new";
    }




    @GetMapping("/order-ready")
    public String getOrderReady(Model model) {

        List<OrderManagementDTO> orderReadyList = orderService.OrderReadyList();

        model.addAttribute("orderList" , orderReadyList);

        return "order/order-ready";
    }

    @PostMapping("/order-ready")
    public String updateReadyPost(@RequestParam("deliveryCompany") String deliveryCompany,
                             @RequestParam("registrationNo") String registrationNo,
                             @RequestParam("selectedOrderNo") Long selectedOrderNo,
                             @RequestParam("orderStatus") String orderStatus,
                             Model model) {



        orderService.updatePost(deliveryCompany, registrationNo, selectedOrderNo);
        orderService.updateOrderStatus(orderStatus, selectedOrderNo);


        model.addAttribute("deliveryCompany", deliveryCompany);
        model.addAttribute("trackingNumber", registrationNo);
        model.addAttribute("orderStatus", orderStatus);



        return "redirect:/order/order-ready";
    }




    @GetMapping("/order-shipping")
    public String getOderShipping(Model model) {

        List<OrderManagementDTO> orderList = orderService.selectShippingOrderList();

        model.addAttribute("orderList" , orderList);

        return "order/order-shipping";
    }

    @PostMapping("/order-shipping")
    public String updateShippingOrderStatus(@RequestParam("selectedOrderNo") Long selectedOrderNo,
                                            @RequestParam("orderStatus") String orderStatus,
                                             Model model) {


        orderService.updateOrderStatus(orderStatus, selectedOrderNo);


        model.addAttribute("orderStatus", orderStatus);



        return "redirect:/order/order-shipping";
    }


    @GetMapping("/order-complete")
    public String getOderComplete(Model model) {

        List<OrderManagementDTO> orderList = orderService.orderCompleteList();

        model.addAttribute("orderList", orderList);

        return "order/order-complete";
    }

    @PostMapping("/order-complete")
    public String updateCompleteOrderStatus(@RequestParam("selectedOrderNo") Long selectedOrderNo,
                                            @RequestParam("orderStatus") String orderStatus,
                                            Model model) {


        orderService.updateOrderStatus(orderStatus, selectedOrderNo);


        model.addAttribute("orderStatus", orderStatus);


        return "redirect:/order/order-complete";
    }

    @GetMapping("/order-cancel")
    public String getOderCancel(Model model) {

        List<OrderManagementDTO> orderCancelList = orderService.orderCancelList();
        List<CancelListDTO> cancelList = orderService.selectCancelOrderList();

        model.addAttribute("orderCancelList", orderCancelList);
        model.addAttribute("cancelList", cancelList);

        return "order/order-cancel";
    }

    @PostMapping("/order-cancel")
    public String cancelOrder(@RequestParam("selectedOrderNo") Long selectedOrderNo) {

        orderService.cancelOrder(selectedOrderNo);

        return "redirect:/order/order-cancel";
    }

    @GetMapping("/order-return")
    public String getOrderReturn(Model model) {

    List<OrderManagementDTO> returnList = orderService.orderReturnList();
    List<ReturnRequestDTO> returnDetailList = orderService.returnDetailList();

    model.addAttribute("returnList" , returnList);
    model.addAttribute("returnDetailList", returnDetailList);

        return "/order/order-return";
    }

    @PostMapping("/order-return")
    public String returnOrder(@RequestParam("selectedOrderNo") Long selectedOrderNo) {

        orderService.returnOrder(selectedOrderNo);

        return "redirect:/order/order-return";
    }


    @GetMapping("/order-swap")
    public String getOrderSwap(Model model) {

        List<SwapRequestDTO> swapDetailList = orderService.swapDetailList();
        List<OrderManagementDTO> swapRequestList = orderService.orderSwapList();

        model.addAttribute("swapRequestList" , swapRequestList);
        model.addAttribute("swapDetailList", swapDetailList);

        return "/order/order-swap";
    }

    @PostMapping("/order-swap")
    public String swapOrder(@RequestParam("selectedOrderNo") Long selectedOrderNo,
                            @RequestParam("orderStatus") String orderStatus) {

        orderService.swapOrder(selectedOrderNo, orderStatus);

        return "redirect:/order/order-swap";
    }
}
