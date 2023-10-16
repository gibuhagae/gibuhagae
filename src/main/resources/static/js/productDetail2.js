// 상품상세리스트 내 문의하기 모달
$(function(){
    $("#confirm1").click(function(){
        modalClose();
        //컨펌 이벤트 처리
    });
    $("#modal-open1").click(function(){
        $("#popup1").css('display','flex');
    });

    $("#close1").click(function(){
        modalClose();
    });
    function modalClose(){
        $("#popup1").fadeOut();
    }
});

// 문의하기 유형 선택
//     document.getElementById('select').addEventListener('change', function() {
//     var selectedValue = document.getElementById('select').value;
//     if (selectedValue === '1') {
//     document.getElementById('inquiryTypeInput').value = '상품문의';
// } else if (selectedValue === '2') {
//     document.getElementById('inquiryTypeInput').value = '기타문의';
// } else {
//     document.getElementById('inquiryTypeInput').value = '';
// }
// });
