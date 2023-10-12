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

    const $paymethod1 = document.getElementById('paymethod1');
    const $paymethod2 = document.getElementById('paymethod2');

    function togglePaymentDiv() {

        const $paycardInfo = document.getElementById('paycard-info');
        const $realtimePayment = document.getElementById('realtime-payment');

        if ($paymethod1.checked) {
            $paycardInfo.style.display = 'flex';
            $realtimePayment.style.display = 'none';
        } else if ($paymethod2.checked) {
            $paycardInfo.style.display = 'none';
            $realtimePayment.style.display = 'flex';
        }

    }

// 페이지 로드 시 초기화
    togglePaymentDiv();

// 라디오 버튼 변경 시 이벤트 처리
    const $selectPay = document.getElementsByName('select-pay');
    for (var i = 0; i < $selectPay.length; i++) {
        $selectPay[i].addEventListener('change', togglePaymentDiv);
    }

    function showCardPaymentDiv() {
        const $paycardInfo = document.getElementById('paycard-info');
        const $realtimePayment = document.getElementById('realtime-payment');

        $paycardInfo.style.display = 'flex';
        $realtimePayment.style.display = 'none';
    }

// 페이지 로드 시 초기화
    showCardPaymentDiv();

// 보더라인 색 변화
    const $payCard = document.getElementById('payment-card');
    const $payaccount = document.getElementById('payment-acount');

// 초기화 함수
    function initializePage() {
        // paymethod1을 기본 선택 상태로 설정
        $paymethod1.checked = true;

        // paymethod1의 부모 div에 파란색 보더라인 설정
        $payCard.style.border = '2px solid blue';
        $payaccount.style.border = '1px solid black';
    }

// 페이지 로드 시 초기화 함수 호출
    initializePage();

// 라디오 버튼 변경 시 이벤트 처리
    $paymethod1.addEventListener('change', () => {
        if ($paymethod1.checked) {
            // 선택된 경우 파란색 보더라인 설정
            $payCard.style.border = '2px solid blue';
            // 다른 라디오 버튼의 보더라인을 검정색으로 초기화
            $payaccount.style.border = '1px solid black';
        }
    });

    $paymethod2.addEventListener('change', () => {
        if ($paymethod2.checked) {
            // 선택된 경우 파란색 보더라인 설정
            $payaccount.style.border = '2px solid blue';
            // 다른 라디오 버튼의 보더라인을 검정색으로 초기화
            $payCard.style.border = '1px solid black';
        }
    });


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

}