// 메인페이지 스크롤 위치에 따른 버튼 생성
$(function (){
    $("#pageMoveButton").hide();

    $(window).scroll(function (){
       if($(this).scrollTop() > 600){$("#pageMoveButton").fadeIn();}
       else{$("#pageMoveButton").fadeOut();}
    });
});