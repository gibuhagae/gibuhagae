window.onload = function() {

// 도메인 직접 입력 or domain option 선택
    const $etcoption = document.querySelector('#etcoption');
    const $domain = document.querySelector('#domain');
// select 옵션 변경 시
    $etcoption.addEventListener('change', (event) => {
// option에 있는 도메인 선택 시
        if (event.target.value !== "etc") {
// 선택한 도메인을 input에 입력하고 disabled
            $domain.value = event.target.value;
            $domain.disabled = true;
        } else { // 직접 입력 시
// input 내용 초기화 & 입력 가능하도록 변경
            $domain.value = "";
            $domain.disabled = false;
        }

    })

    const $shippingOption = document.querySelector('#shipping-message-option');
    const $shippingArea = document.querySelector('#shipping-message-area');

    $shippingOption.addEventListener('change', (messaage) => {

        if (messaage.target.value == "message4") {

            $shippingArea.style.display = 'block';
            $shippingArea.value = "메세지를 입력하세요."
        } else {
            $shippingArea.style.display = 'none';
        }
    })

//     const $paymethod1 = document.getElementById('paymethod1');
//     const $paymethod2 = document.getElementById('paymethod2');
//
//     function togglePaymentDiv() {
//
//         const $paycardInfo = document.getElementById('paycard-info');
//         const $realtimePayment = document.getElementById('realtime-payment');
//
//         if ($paymethod1.checked) {
//             $paycardInfo.style.display = 'flex';
//             $realtimePayment.style.display = 'none';
//         } else if ($paymethod2.checked) {
//             $paycardInfo.style.display = 'none';
//             $realtimePayment.style.display = 'flex';
//         }
//
//     }
//
// // 페이지 로드 시 초기화
//     togglePaymentDiv();
//
// // 라디오 버튼 변경 시 이벤트 처리
//     const $selectPay = document.getElementsByName('select-pay');
//     for (var i = 0; i < $selectPay.length; i++) {
//         $selectPay[i].addEventListener('change', togglePaymentDiv);
//     }
//
//     function showCardPaymentDiv() {
//         const $paycardInfo = document.getElementById('paycard-info');
//         const $realtimePayment = document.getElementById('realtime-payment');
//
//         $paycardInfo.style.display = 'flex';
//         $realtimePayment.style.display = 'none';
//     }
//
// // 페이지 로드 시 초기화
//     showCardPaymentDiv();
//
// // 보더라인 색 변화
//     const $payCard = document.getElementById('payment-card');
//     const $payaccount = document.getElementById('payment-acount');
//
// // 초기화 함수
//     function initializePage() {
//         // paymethod1을 기본 선택 상태로 설정
//         $paymethod1.checked = true;
//
//         // paymethod1의 부모 div에 파란색 보더라인 설정
//         $payCard.style.border = '2px solid blue';
//         $payaccount.style.border = '1px solid black';
//     }
//
// // 페이지 로드 시 초기화 함수 호출
//     initializePage();
//
// // 라디오 버튼 변경 시 이벤트 처리
//     $paymethod1.addEventListener('change', () => {
//         if ($paymethod1.checked) {
//             // 선택된 경우 파란색 보더라인 설정
//             $payCard.style.border = '2px solid blue';
//             // 다른 라디오 버튼의 보더라인을 검정색으로 초기화
//             $payaccount.style.border = '1px solid black';
//         }
//     });
//
//     $paymethod2.addEventListener('change', () => {
//         if ($paymethod2.checked) {
//             // 선택된 경우 파란색 보더라인 설정
//             $payaccount.style.border = '2px solid blue';
//             // 다른 라디오 버튼의 보더라인을 검정색으로 초기화
//             $payCard.style.border = '1px solid black';
//         }
//     });


// 결제진행 동의
    const $agreeButton = document.getElementById('agree-button');
    const $agreeMessage = document.getElementById('agree-message');

    $agreeButton.addEventListener('click', () => {
        if ($agreeMessage.style.display === 'none' || $agreeMessage.style.display === '') {
            $agreeMessage.style.display = 'block';
        } else {
            $agreeMessage.style.display = 'none';
        }
    });

    const $searchAddr = document.getElementById('search-addr');

    $searchAddr.addEventListener('click', () => {
        new daum.Postcode({
            oncomplete: function (data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if (data.userSelectedType === 'R') {
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if (data.buildingName !== '' && data.apartment === 'Y') {
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if (extraAddr !== '') {
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("addr2").value = extraAddr;

                } else {
                    document.getElementById("addr2").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('zip-code-write').value = data.zonecode;
                document.getElementById("addr1").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("addr2").focus();
            }
        }).open();
    })

}