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