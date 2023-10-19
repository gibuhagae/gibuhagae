window.onload = function() {

    /* 화면에 랜더링 된 태그들이 존재하지 않는 경우 에러 발생 가능성이 있어서 if문으로 태그가 존재하는지 부터 확인하고 이벤트를 연결한다. */

    var isDupClicked = false;
    var isDupChecked = false;

    console.log(localStorage.length);
    localStorage.setItem("1", 1);
    localStorage.setItem("2", 2);

    if(document.getElementById("indexLogBtn")) {
        const $login = document.getElementById("indexLogBtn");
        console.log("indexLogBtn before");
        $login.onclick = function() {
            console.log("indexLogBtn");

            // fetch("/login/Login", {
            //     method: "POST",
            //     headers: {
            //         'Content-Type': 'application/json;charset=UTF-8'
            //     },
            //     body: JSON.stringify()
            // })
            //     .then(result => result.text())
            //     .then((result) => {
            //         alert(result);
            //
            //     })
            //     .then((response) => {
            //         console.log('123456!');
            //         console.log(response);
            //     })

            location.href = "/login/Login";
        }
    }

    if(document.getElementById("login")) {
        const $login = document.getElementById("login");
        $login.onclick = function() {
            location.href = "/login/Login";
        }
    }

    if (document.getElementById("logout")) {
        const $logout = document.getElementById("logout");
        $logout.onclick = function() {
            location.href = "/member/logout";
        }

        // const logout = document.getElementById("logout");
        // logout.onclick = function () {
        //
        //     console.log("로그아웃 버튼 눌렀다.")
        //     const access_token = localStorage.getItem("naverToken");
        //
        //     // 로그아웃 기능 (토큰 삭제)
        //     if (access_token != null) {
        //
        //         console.log("로그아웃 합니다.")
        //
        //         var logoutURL = "https://nid.naver.com/oauth2.0/token?grant_type=delete&"
        //             +
        //             "client_id=PmDrXlVeXulX2pwGIV3c&"
        //             +
        //             "client_secret=duqRFFPRVk&"
        //             +
        //             "access_token=" + access_token + "&"
        //             +
        //             "service_provider=NAVER";
        //
        //         fetch(logoutURL,
        //             { mode: 'no-cors' }).
        //             then(() => {
        //                 localStorage.removeItem('naverMemberInfo');
        //                 setIsLoggedIn(false); // 로그인 상태 갱신
        //                 console.log('logout!');
        //             })
        //             .catch((e) => console.log('error!', e));
        //     }
        // }
    }

    if(document.getElementById("reasonNameBtn")) {
        const reasonNameBtn = document.getElementById("reasonNameBtn");
        reasonNameBtn.onclick = function() {



            fetch("/join/idDupCheck", {
                method: "POST",
                headers: {
                    'Content-Type': 'application/json;charset=UTF-8'
                },
                body: JSON.stringify({userId: userId})
            })
                .then(result => result.text())
                .then((result) => {
                    alert(result);
                    if (result === "사용 가능한 아이디입니다.") {
                        isDupChecked = true;
                    } else if (result === "중복 된 아이디가 존재합니다.") {
                        isDupChecked = false;
                    }

                    window.close();
                })
                .then((response) => {
                    console.log('123456!');
                    console.log(response);
                })
        }
    }

    if(document.getElementById("withdraw")) {
        const withdraw = document.getElementById("withdraw");
        withdraw.onclick = function() {
            location.href = "/login/delete";
        }
    }

    if(document.getElementById("join")) {
        const $join = document.getElementById("join");
        $join.onclick = function() {
            location.href = "/join/Join";
        }
    }

    if(document.getElementById("indexMyPageBtn")) {
        const $myPage = document.getElementById("indexMyPageBtn");
        console.log("indexMyPageBtn Before");

        $myPage.onclick = function() {
            console.log("indexMyPageBtn After");
            location.href = "/myPage/MyPage";
        }
    }

    if(document.getElementById("duplicationCheck")) {

        const $duplication = document.getElementById("duplicationCheck");

        console.log("중복체크 확인");

        isDupClicked = false;

        $duplication.onclick = function() {
            isDupClicked = true;

            console.log("멤버 아이디 확인: " + document.getElementById("inputId").value);

            let userId = document.getElementById("inputId").value.trim();

            console.log("멤버 아이디 확인2: " + userId);

            fetch("/join/idDupCheck", {
                method: "POST",
                headers: {
                    'Content-Type': 'application/json;charset=UTF-8'
                },
                body: JSON.stringify({userId: userId})
            })
                .then(result => result.text())
                .then((result) => {
                    alert(result);
                    if (result === "사용 가능한 아이디입니다.") {
                        isDupChecked = true;
                    } else if (result === "중복 된 아이디가 존재합니다.") {
                        isDupChecked = false;
                    }
                })
                .then((response) => {
                    console.log('123456!');
                    console.log(response);
                })
        }
    }

    var joinFormId = document.getElementById('joinFormId');
    var id = document.getElementById('inputId');
    var idSpan = document.getElementById('idSpan');
    var pwd = document.getElementById('inputPwd');
    var pwdSpan = document.getElementById('pwdSpan');
    var pwdChk = document.getElementById('inputPwdChk');
    var pwdChkSpan = document.getElementById('pwdChkSpan');
    var name = document.getElementById('inputName');
    var nameSpan = document.getElementById('nameSpan');
    var phone1 = document.getElementById('inputPhone1');
    var phone2 = document.getElementById('inputPhone2');
    var phone3 = document.getElementById('inputPhone3');
    var phoneSpan = document.getElementById('phoneSpan');
    var zipCode = document.getElementById('inputPost');
    var addr = document.getElementById('inputBasicAddr');
    var rAddr = document.getElementById('inputRAddr');
    var email = document.getElementById('inputEmail');

    function checkReg() {
        // 아이디 체크
        if (0 < id.value.length ) {
            var idReg = /^[a-z][a-zA-Z0-9]{4,16}$/;
            if (idReg.test(id.value)) {
                idSpan.innerHTML = id.value + "는 사용 가능한 아이디입니다. (영문소문자/숫자, 4~16자)";
            } else {
                idSpan.innerHTML =
                    "대문자/공백/특수문자가 포함되었거나, 숫자로 시작 또는 숫자로만 이루어진 아이디는 사용할 수 없습니다. (영문소문자/숫자, 4~16자)";
                isAuth = false;
            }
        }

        // 비밀번호 체크
        let pwdVal = pwd.value;
        pwdSpan.innerHTML = "대소문자/숫자/특수문자 중 3가지 이상 조합, 8자~16자 검사";

        if (0 < pwdVal.length ) {
            var inputLeg = /(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[~"!@#$%^()*_/{}|;:<>,.?\-\[\]])[A-Za-z\d~`!@#$%^()*_/{}|;:<>,.?\-\[\]]{8,16}$/;
            var gapLeg = /[\s]/;
            let isPwdSpanChanged = false;

            // 대소문자/숫자/특수문자 중 3가지 이상 조합, 8자~16자 검사
            if (inputLeg.test(pwdVal)) {
                pwdSpan.innerHTML = "비번 입력 조건 통과";
            } else {
                pwdSpan.innerHTML = "비번 입력 조건 불통과";
                isAuth = false;
                isPwdSpanChanged = true;
            }

            // 공백 포함일 경우
            if (gapLeg.test(pwdVal)) {
                pwdSpan.innerHTML = "공백이 포함";
                isAuth = false;
                isPwdSpanChanged = true;
            }

            // // 연속된 문자, 숫자 혹은 동일한 문자, 숫자를 반복해서 사용 불가능
            // for(let i = 0; i < pwdVal.length - 2; i++) {
            //     let selectedVal = pwdVal.charAt(i);
            //     console.log(i + "는" + selectedVal + 1);
            //
            //     // let cnt = 0;
            //     // while(true) {
            //     //     let nextVal = pwdVal.charAt(i + 1);
            //     //     if (selectedVal === nextVal || )
            //     // }
            //
            // }

            // 아이디 포함 불가능
            if (pwdVal === id.val) {
                pwdSpan.innerHTML = "아이디 포함 불가능";
                isAuth = false;
                isPwdSpanChanged = true;
            }

            if (!isPwdSpanChanged)
                pwdSpan.innerHTML = "";
        }

        // 이름 체크
        if (0 < name.value.length ) {
            let nameReg = /^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]{2,4}$/;
            if (nameReg.test(name.value)) {
                nameSpan.innerHTML = "";
            } else {
                nameSpan.innerHTML = "한글 이름만 가능합니다";
                isAuth = false;
            }
        }

        // 휴대전화 체크
        if (0 < pwd.value.length ) {
            var phoneReg = /^[0-9]{4}$/
            if (!phoneReg.test(phone2.value) || !phoneReg.test(phone3.value)) {
                isAuth = false;
                phoneSpan.innerHTML = "숫자 4자리를 입력하세요."
            } else {
                phoneSpan.innerHTML = "";
            }
        }

        // 이메일 체크
        if (0 < pwd.value.length ) {
            var emailReg = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-.]+$/
            if (!emailReg.test(email.value)) {
                emailSpan.innerHTML = "@붙여 다시 입력해 주세요";
                isAuth = false;
            } else {
                emailSpan.innerHTML = "";
            }
        }
    }

    function checkPwd() {
        if (1 <= pwdChk.value.length) {
            if (pwd.value != pwdChk.value) {
                pwdChkSpan.innerHTML = "    비밀번호가 일치하지 않습니다.";
                isAuth = false;
            } else {
                pwdChkSpan.innerHTML = "    비밀번호가 일치합니다.";
            }
        }
    }

    var isAuth = true;
    if(document.getElementById("joinFormId")) {
        joinFormId.addEventListener('mouseover', (event) => {
            isAuth = true;

            checkReg();
            checkPwd();

        });
    }

    if(document.getElementById("joinBtn")) {
        const joinBtn = document.getElementById("joinBtn");
        joinBtn.onclick = function() {

            // alert(isDupClicked + "클릭 before");
            // alert(isDupChecked + "체크 before");

            // 입력 조건들이 통과가 되는가?
            if (isAuth == false) {
                alert("입력 조건을 확인하세요.");
                return;
            }

            // 중복확인 버튼을 눌렀는가?
            if (isDupClicked && isDupChecked) {

                // alert(isDupClicked + "클릭");
                // alert(isDupChecked + "체크");
                //
                // alert(id.value);
                // alert(pwd.value);
                // alert(name.value);
                // alert(phone1.value);
                // alert(phone2.value);
                // alert(phone3.value);
                // alert(zipCode.value);
                // alert(addr.value);
                // alert(rAddr.value);
                // alert(email.value);

                const joinInfo = {
                    id : id.value,
                    pwd : pwd.value,
                    name : name.value,
                    phone1 : phone1.value,
                    phone2 : phone2.value,
                    phone3 : phone3.value,
                    zipcode : zipCode.value,
                    addr : addr.value,
                    rAddr : rAddr.value,
                    email : email.value
                };

                // alert(joinInfo.id);
                // alert(joinInfo.pwd);
                // alert(joinInfo.name);
                // alert(joinInfo.phone1);
                // alert(joinInfo.phone2);
                // alert(joinInfo.phone3);
                // alert(joinInfo.zipcode);
                // alert(joinInfo.addr);
                // alert(joinInfo.rAddr);
                // alert(joinInfo.email);

                fetch("/join/Join", {
                    method: "POST",
                    headers: {
                        'Content-Type': 'application/json;charset=UTF-8'
                    },
                    body: JSON.stringify(joinInfo),
                })
                    .then(result => result.text())
                    .then((result) => {
                        alert(result);

                        location.href = "/";
                    })
            }
            // 중복된 아이디가 있거나, 중복 버튼을 누르지 않았다
            else {
                alert("중복된 아이디가 있거나, 중복 버튼을 누르지 않았다");
            }
        }
    }
}