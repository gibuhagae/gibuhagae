// 상품상세리스트 내 후기작성 모달
$(function(){
    $("#confirm").click(function(){
        modalClose();
        //컨펌 이벤트 처리
    });
    $("#modal-open").click(function(){
        $("#popup").css('display','flex');
    });

    $("#close").click(function(){
        modalClose();
    });
    function modalClose(){
        $("#popup").fadeOut();
    }
});


