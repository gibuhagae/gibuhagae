window.onload = function () {

    <!-- 버튼 클릭시 컬러 유지 -->
    const newOrder = document.getElementById("new-order");
    const postReady = document.getElementById("post-ready");
    const postIng = document.getElementById("post-shipping");
    const postClear = document.getElementById("post-complete");
    const postCancel = document.getElementById("post-cancel");
    const postReturn = document.getElementById("post-return");
    const postSwap = document.getElementById("post-swap");

    newOrder.addEventListener("click", () => selectMenu(newOrder));
    postReady.addEventListener("click", () => selectMenu(postReady));
    postIng.addEventListener("click", () => selectMenu(postIng));
    postClear.addEventListener("click", () => selectMenu(postClear));
    postCancel.addEventListener("click", () => selectMenu(postCancel));
    postReturn.addEventListener("click", () => selectMenu(postReturn));
    postSwap.addEventListener("click", () => selectMenu(postSwap));

    function selectMenu(menu) {
        newOrder.classList.remove("selected");
        postReady.classList.remove("selected");
        postIng.classList.remove("selected");
        postClear.classList.remove("selected");
        postCancel.classList.remove("selected");
        postReturn.classList.remove("selected");
        postSwap.classList.remove("selected");

        menu.classList.add("selected");
    }

    <!-- 페이지 로드 시 버튼 이벤트(컬러) 활성화-->
    function activateNewOrderEvent() {
        const newOrder = document.getElementById("new-order");
        if (newOrder) {
            newOrder.click();
        }
    }

    function activateOrderReady() {
        const ready = document.getElementById("post-ready")
        if (ready) {
            ready.click();
        }
    }

    function activateOrderShipping() {
        const shipping = document.getElementById("post-shipping")
        if (shipping) {
            shipping.click();
        }
    }

    function activateOrderComplete() {
        const complete = document.getElementById("post-complete")
        if (complete) {
            complete.click();
        }
    }

    function activateOrderCancel() {
        const cancel = document.getElementById("post-cancel")
        if (cancel) {
            cancel.click();
        }
    }

    function activateOrderReturn() {
        const Return = document.getElementById("post-return")
        if (Return) {
            Return.click();
        }
    }

    function activateOrderSwap() {
        const swap = document.getElementById("post-swap")
        if (swap) {
            swap.click();
        }
    }

    const currentURL = window.location.href;

    if (currentURL.includes('/order-new')) {
        activateNewOrderEvent();
    } else if (currentURL.includes('/order-ready')) {
        activateOrderReady()

    } else if (currentURL.includes('/order-shipping')) {
        activateOrderShipping()

    } else if (currentURL.includes('/order-complete')) {
        activateOrderComplete()

    } else if (currentURL.includes('/order-cancel')) {
        activateOrderCancel()

    } else if (currentURL.includes('/order-return')) {
        activateOrderReturn()

    } else if (currentURL.includes('/order-swap')) {
        activateOrderSwap()
    }


    <!-- ---------------------------------------------------------------------------------------- -->

// 페이지 이동 이벤트
    function OrderNewPage() {
        window.location.href = 'http://localhost:8080/order/order-new';
    }

    const orderNew = document.getElementById("new-order");
    if (orderNew) {
        orderNew.addEventListener("click", OrderNewPage);
    }

    function OrderReadyPage() {
        window.location.href = 'http://localhost:8080/order/order-ready';
    }

    const ready = document.getElementById('post-ready');
    if (ready) {
        ready.addEventListener('click', OrderReadyPage);
    }

    function OrderShippingPage() {
        window.location.href = 'http://localhost:8080/order/order-shipping';
    }

    const orderShipping = document.getElementById("post-shipping");
    if (orderShipping) {
        orderShipping.addEventListener("click", OrderShippingPage);
    }

    function OrderCompletePage() {
        window.location.href = 'http://localhost:8080/order/order-complete';
    }

    const orderComplete = document.getElementById("post-complete");
    if (orderComplete) {
        orderComplete.addEventListener("click", OrderCompletePage);
    }

    function OrderCancelPage() {
        window.location.href = 'http://localhost:8080/order/order-cancel';
    }

    const orderCancel = document.getElementById("post-cancel");
    if (orderCancel) {
        orderCancel.addEventListener("click", OrderCancelPage);
    }

    function OrderReturnPage() {
        window.location.href = 'http://localhost:8080/order/order-return';
    }

    const orderReturn = document.getElementById("post-return");
    if (orderReturn) {
        orderReturn.addEventListener("click", OrderReturnPage);
    }

    function OrderSwapPage() {
        window.location.href = 'http://localhost:8080/order/order-swap';
    }

    const orderSwap = document.getElementById("post-swap");
    if (orderSwap) {
        orderSwap.addEventListener("click", OrderSwapPage);
    }



}


