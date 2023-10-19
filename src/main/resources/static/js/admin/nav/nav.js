// 현재 페이지의 URL 가져오는 코드
const currentPageUrl = window.location.pathname;

// includes 로 주소 찾아서 버튼에 컬러 추가
/* --------------------------------주문 관리 --------------------------------------*/
const orderButton = document.querySelector(".order");

if (currentPageUrl.includes("/order/order-new")) {
    orderButton.style.background = "linear-gradient(270deg, rgba(77, 94, 246, 0.20) 2.54%, rgba(246, 77, 77, 0.20) 100%)";

} else if (currentPageUrl.includes("/order/order-ready")) {
    orderButton.style.background = "linear-gradient(270deg, rgba(77, 94, 246, 0.20) 2.54%, rgba(246, 77, 77, 0.20) 100%)";

} else if (currentPageUrl.includes("/order/order-shipping")) {
    orderButton.style.background = "linear-gradient(270deg, rgba(77, 94, 246, 0.20) 2.54%, rgba(246, 77, 77, 0.20) 100%)";

} else if (currentPageUrl.includes("/order/order-complete")) {
    orderButton.style.background = "linear-gradient(270deg, rgba(77, 94, 246, 0.20) 2.54%, rgba(246, 77, 77, 0.20) 100%)";

} else if (currentPageUrl.includes("/order/order-cancel")) {
    orderButton.style.background = "linear-gradient(270deg, rgba(77, 94, 246, 0.20) 2.54%, rgba(246, 77, 77, 0.20) 100%)";

} else if (currentPageUrl.includes("/order/order-return")) {
    orderButton.style.background = "linear-gradient(270deg, rgba(77, 94, 246, 0.20) 2.54%, rgba(246, 77, 77, 0.20) 100%)";

} else if (currentPageUrl.includes("/order/order-swap")) {
    orderButton.style.background = "linear-gradient(270deg, rgba(77, 94, 246, 0.20) 2.54%, rgba(246, 77, 77, 0.20) 100%)";
}

/* ----------------------------------------------------------------------------*/


if (currentPageUrl.includes("/member/member-admin")){
    const memberButton = document.querySelector(".member");
    memberButton.style.background = "linear-gradient(270deg, rgba(77, 94, 246, 0.20) 2.54%, rgba(246, 77, 77, 0.20) 100%)";
}
if (currentPageUrl.includes("/productManagement/product-admin")){
    const itemButton = document.querySelector(".item");
    itemButton.style.background = "linear-gradient(270deg, rgba(77, 94, 246, 0.20) 2.54%, rgba(246, 77, 77, 0.20) 100%)";
}
if (currentPageUrl.includes("/buyManagement/buy-admin")){
    const buyButton = document.querySelector(".buy");
    buyButton.style.background = "linear-gradient(270deg, rgba(77, 94, 246, 0.20) 2.54%, rgba(246, 77, 77, 0.20) 100%)";
}
if (currentPageUrl.includes("/donate/donate-admin")){
    const donationButton = document.querySelector(".donation");
    donationButton.style.background = "linear-gradient(270deg, rgba(77, 94, 246, 0.20) 2.54%, rgba(246, 77, 77, 0.20) 100%)";
}
if (currentPageUrl.includes("/settlementManagement/settlement")){
    const statisticsButton = document.querySelector(".statistics");
    statisticsButton.style.background = "linear-gradient(270deg, rgba(77, 94, 246, 0.20) 2.54%, rgba(246, 77, 77, 0.20) 100%)";
}