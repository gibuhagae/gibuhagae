package com.gibuhagae.gibuhagae.myPage.controller;

import com.gibuhagae.gibuhagae.member.dto.CustomUserDTO;
import com.gibuhagae.gibuhagae.member.dto.MemberDTO;
import com.gibuhagae.gibuhagae.member.service.MemberService;
import com.gibuhagae.gibuhagae.myPage.dto.MyPageOrderDetailDTO;
import com.gibuhagae.gibuhagae.myPage.service.MyPageService;
import com.gibuhagae.gibuhagae.order.dto.OrderManagementDTO;
import com.gibuhagae.gibuhagae.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/myPage")
public class MyPageController {
    private final MyPageService myPageService;
    private final MemberService memberService;
    private OrderService orderService;

    public MyPageController(MyPageService myPageService, MemberService memberService, OrderService orderService) {
        this.myPageService = myPageService;
        this.memberService = memberService;
        this.orderService = orderService;
    }

    @GetMapping("/MyPage")
    public void moveMyPage() {
        System.out.println("moveMyPage");
    }

    @GetMapping("/CancelReturnExchange")
    public void moveCancelReturnExchange() {
        System.out.println("CancelReturnExchange");
    }

    @GetMapping("/InterestProduct")
    public void moveInterestProduct() {
        System.out.println("InterestProduct");
    }

    @GetMapping("/MemberInformationModify")
    public void moveMemberInformationModify(@AuthenticationPrincipal CustomUserDTO member, Model model) {
        System.out.println(member.toString());
        System.out.println("MemberInformationModify");

        // 회원 정보를 가져온다.
        MemberDTO findMember = memberService.getMemberById(member.getUsername());

        // view에 보낼 데이터를 취합한다.
        // id, 이름, 휴대전화, 주소, 이메일
        model.addAttribute("userId", findMember.getUserId());
        model.addAttribute("userName", findMember.getMemberName());

        String phones[] = memberService.generateSplitStr(findMember.getMemberPhone(), " - ");
        model.addAttribute("userPhone1", phones[0]);
        model.addAttribute("userPhone2", phones[1]);
        model.addAttribute("userPhone3", phones[2]);

        model.addAttribute("userZipcode", findMember.getZipcode());

        String addrs[] = memberService.generateSplitStr(findMember.getAddress(), "\\*");
        model.addAttribute("userAddr1", addrs[0]);
        model.addAttribute("userAddr2", addrs[1]);
        model.addAttribute("userEmail", findMember.getEmail());
    }

    @PostMapping("/MemberInformationModify")
    public String modifyMemberInformationModify(String id, String pwd, String phone1, String phone2, String phone3,
                                                String zipCode, String addr1, String addr2, String email) {
        if (memberService.modifyMemberInfo(id, pwd, phone1, phone2, phone3, zipCode, addr1, addr2, email))
            System.out.println("회원 수정 성공!");
        else
            System.out.println("회원 수정 실패!");

        return "redirect:/myPage/MyPage";
    }

    @GetMapping("/OrderDetail")
    public void moveOrderDetail(Model model) {

        System.out.println("moveOrderDetail Call before");

        // 주문 상세 정보를 가져온다.
        List<OrderManagementDTO> orderManagementList = orderService.selectNewOrderList();

        // 전송 전용 주문상세DTO 선언
        List<MyPageOrderDetailDTO> myPageOrderDetailDTOList = new ArrayList<>();

        // 전송 전용 주문상세DTO에 적재적소한다.
        for (OrderManagementDTO orderManagement : orderManagementList) {

            MyPageOrderDetailDTO myPageOrderDetail = new MyPageOrderDetailDTO();

            // 주문일자/주문번호
            myPageOrderDetail.setOrderDateAndN(orderManagement.getOrderDate().toString() + "/ " + orderManagement.getOrderNo());

            // 이미지
            myPageOrderDetail.setImageSrc("");

            // 상품정보
            myPageOrderDetail.setItemInfo(orderManagement.getItemName() + orderManagement.getOptionName());

            // 수량
            myPageOrderDetail.setItemCnt(orderManagement.getOrderCount());

            // 상품구매금액
            myPageOrderDetail.setPaymentPrice(orderManagement.getPaymentPrice());

            // 주문처리상태
            myPageOrderDetail.setOrderStatus(orderManagement.getOrderStatus());

            // 취소/교환/반품 중 하나의 현재 상태
            myPageOrderDetail.setStatusOfCER(orderManagement.getCerStatus());

            // 리스트에 담기
            myPageOrderDetailDTOList.add(myPageOrderDetail);
        }

        //model에 담아 view에 전달한다.
        model.addAttribute("myPageOrderDetailList", myPageOrderDetailDTOList);

        System.out.println("moveOrderDetail Call after");
    }

    @PostMapping("/OrderDetail")
    public ResponseEntity<List<String>> modifyOrderDetail(@RequestBody HashMap<String, Object> orderDatas) {

        List<String> orderDetailCodeList = new ArrayList<>();

        System.out.println("modifyOrderDetail POST Call before");

        String orderStatus = orderDatas.get("orderStatusName").toString();
        List<String> orderNs = (ArrayList<String>)orderDatas.get("orderN_List");

        // 주문 처리 상태를 갱신한다.
        for(String code : orderNs) {
            boolean retB = orderService.modifyOrderDetailStatus(Long.parseLong(code), orderStatus);
            if (!retB) {
                orderDetailCodeList = null;
                break;
            }

           List<Integer> orderDetailPkList = orderService.selectOrderDetailPK(Integer.parseInt(code));
            // 각 주문상세 pk 값들을 전달할 데이터에 집어넣는다.
            for(int odPkVal : orderDetailPkList){
                orderDetailCodeList.add(Integer.toString(odPkVal));
            }
        }

        System.out.println("modifyOrderDetail POST Call after");

        return ResponseEntity.ok(orderDetailCodeList);
    }

    @GetMapping("/RecentViewedProduct")
    public void moveRecentViewedProduct() {
        System.out.println("RecentViewedProduct");
    }

    @GetMapping("/SavedMoney")
    public void moveSavedMoney() {
        System.out.println("SavedMoney");
    }
}
