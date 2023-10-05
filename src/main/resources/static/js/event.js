window.onload = function() {

    /* 화면에 랜더링 된 태그들이 존재하지 않는 경우 에러 발생 가능성이 있어서 if문으로 태그가 존재하는지 부터 확인하고 이벤트를 연결한다. */

    if(document.getElementById("login")) {
        const $login = document.getElementById("login");
        $login.onclick = function() {
            location.href = "/login/Login";
        }

    }

    if(document.getElementById("join")) {
        const $join = document.getElementById("join");
        $join.onclick = function() {
            location.href = "/join/Join";
        }
    }

    if(document.getElementById("myPage")) {
        const $myPage = document.getElementById("myPage");
        $myPage.onclick = function() {
            location.href = "/myPage/MyPage";
        }
    }
}