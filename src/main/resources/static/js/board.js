// 공지사항 작성하기 모달
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

// 첨부파일
// const fileInput = document.getElementById("fileUpload");
// // 또는 const fileInput = $("#fileUpload").get(0);
//
// const handleFiles = () => {
//     const selectedFile = [...fileInput.files];
//     console.log(selectedFile);
// };
//
// fileInput.addEventListener("change", handleFiles);