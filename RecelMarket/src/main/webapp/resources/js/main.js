var id = document.querySelector('#id');

let del_email = null;

let notMove = 0;

var pw1 = document.querySelector('#pswd1');
var pwMsg = document.querySelector('#alertTxt');
var pwImg1 = document.querySelector('#pswd1_img1');

var pw2 = document.querySelector('#pswd2');
var pwImg2 = document.querySelector('#pswd2_img1');
var pwMsgArea = document.querySelector('.int_pass');

var userName = document.querySelector('#name');

var chk_adress = document.querySelector('#chk_adress');

var yy = document.querySelector('#yy');
var mm = document.querySelector('#mm');
var dd = document.querySelector('#dd');

var gender = document.querySelector('#gender');

var email = document.querySelector('#email');

var mobile = document.querySelector('#mobile');

var error = document.querySelectorAll('.error_next_box');

var chk_email = document.querySelector('#chk_email');

var chk_id = document.querySelector('#chk_id');

var nickname = document.querySelector('#nickname');


var ajaxIdchk = 0;


var ajaxEmailchk = 0;
/*이벤트 핸들러 연결*/


id.addEventListener("focusout", checkId);
chk_id.addEventListener("click", function(){
	const chk = checkId()
	if(chk != 1){alert("아이디 형식을 다시한번 확인해주세요"); return }
	var user_id = frm.user_id.value
	axios.post('/user/ajaxIdChk', {
		user_id : user_id
	}).then(function(res) {	
		if(res.data == '2') { //아이디 없음
			ajaxIdchk = 1;
			error[0].style.color = "#08A600";
			error[0].innerHTML = "사용 할 수 있는 아이디 입니다";
	        error[0].style.display = "block";
		} else if(res.data == '3') { //아이디 중복됨
			error[0].innerHTML = "아이디가 중복됩니다.";
	        error[0].style.display = "block";
		}
	})
});
pw1.addEventListener("focusout", checkPw);
pw2.addEventListener("focusout", comparePw);
userName.addEventListener("focusout", checkName);
nickname.addEventListener("focusout", checkNickName);
yy.addEventListener("focusout", isBirthCompleted);
mm.addEventListener("focusout", isBirthCompleted);
dd.addEventListener("focusout", isBirthCompleted);
gender.addEventListener("focusout", genderchk);
email.addEventListener("focusout", isEmailCorrect);
chk_email.addEventListener("click", function(){
	if(del_email != null){
		if(confirm("새로운 이메일로 인증코드를 보내겠습니까?")){
			del_Email()
		}
	}	
	const chk = isEmailCorrect()
	if(chk != 1){alert("유효한 이메일이 아닙니다!"); return }
	del_email = frm.email.value
	axios.post('/user/signUp', {
		email: del_email
	}).then(function(res) {
		
		if(res.data != 1){
			alert('이미 가입되있는 이메일입니다!')
		}else{
			error[7].innerHTML = "해당 이메일로 인증코드를 보내드렸습니다.";
	        error[7].style.color = "#08A600";
	        error[7].style.display = "block";
		}
	})
});

chk_adress.addEventListener("click", function(){
 new daum.Postcode({
             oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
 
                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수
 
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }
 
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                console.log(data.zonecode);
                console.log(fullRoadAddr);
                
                
				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				document.getElementById('addr1').value = data.zonecode; //5자리 새우편번호 사용
				document.getElementById('addr2').value = fullRoadAddr;
                
                /* document.getElementById('signUpUserPostNo').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('signUpUserCompanyAddress').value = fullRoadAddr;
                document.getElementById('signUpUserCompanyAddressDetail').value = data.jibunAddress; */
            }
         }).open();
});

function checkId() {
    var idPattern = /[a-zA-Z0-9_-]{5,20}/;
    if(id.value === "") {
        error[0].innerHTML = "필수 정보입니다.";
        error[0].style.display = "block";
    } else if(!idPattern.test(id.value)) {
        error[0].innerHTML = "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.";
        error[0].style.display = "block";
    } else {
        error[0].innerHTML = "멋진 아이디네요!";
        error[0].style.color = "#08A600";
        error[0].style.display = "block";
		return 1;
    }
}

function checkPw() {
    var pwPattern = /[a-zA-Z0-9~!@#$%^&*()_+|<>?:{}]{8,16}/;
    if(pw1.value === "") {
        error[1].innerHTML = "필수 정보입니다.";
        error[1].style.display = "block";
    } else if(!pwPattern.test(pw1.value)) {
        error[1].innerHTML = "8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.";
        pwMsg.innerHTML = "사용불가";
        pwMsgArea.style.paddingRight = "93px";
        error[1].style.display = "block";
        
        pwMsg.style.display = "block";
        pwImg1.src = "/res/img/m_icon_not_use.png";
    } else {
        error[1].style.display = "none";
        pwMsg.innerHTML = "안전";
        pwMsg.style.display = "block";
        pwMsg.style.color = "#03c75a";
        pwImg1.src = "/res/img/m_icon_safe.png";
		return 1;
    }
}

function comparePw() {
    if(pw2.value === pw1.value && pw2.value != "") {
        pwImg2.src = "/res/img/m_icon_check_enable.png";
        error[2].style.display = "none";
		return 1;
    } else if(pw2.value !== pw1.value) {
        pwImg2.src = "/res/img/m_icon_check_disable.png";
        error[2].innerHTML = "비밀번호가 일치하지 않습니다.";
        error[2].style.display = "block";
    } 

    if(pw2.value === "") {
        error[2].innerHTML = "필수 정보입니다.";
        error[2].style.display = "block";
    }
}



function checkName() {
    var namePattern = /[a-zA-Z가-힣]/;
    if(userName.value === "") {
        error[3].innerHTML = "필수 정보입니다.";
        error[3].style.display = "block";
    } else if(!namePattern.test(userName.value) || userName.value.indexOf(" ") > -1) {
        error[3].innerHTML = "한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)";
        error[3].style.display = "block";
    } else {
        error[3].style.display = "none";
		return 1;
    }
}

function checkNickName() {
    var namePattern = /[a-zA-Z가-힣]/;
	console.log(nickname.value)
    if(nickname.value === "") {
        error[4].innerHTML = "필수 정보입니다.";
        error[4].style.display = "block";
    } else if(!namePattern.test(nickname.value) || nickname.value.indexOf(" ") > -1) {
        error[4].innerHTML = "한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)";
        error[4].style.display = "block";
    } else {
        error[4].style.display = "none";
		return 1;
    }
}


function isBirthCompleted() {
    var yearPattern = /[0-9]{4}/;

    if(!yearPattern.test(yy.value)) {
        error[5].innerHTML = "태어난 년도 4자리를 정확하게 입력하세요.";
        error[5].style.display = "block";
    } else {
        isMonthSelected();
		return 1;
    }


    function isMonthSelected() {
        if(mm.value === "월") {
            error[5].innerHTML = "태어난 월을 선택하세요.";
        } else {
            isDateCompleted();
			return 1;
        }
    }

    function isDateCompleted() {
        if(dd.value === "") {
            error[5].innerHTML = "태어난 일(날짜) 2자리를 정확하게 입력하세요.";
        } else {
            isBirthRight();
			return 1;
        }
    }
}



function isBirthRight() {
    var datePattern = /\d{1,2}/;
    if(!datePattern.test(dd.value) || Number(dd.value)<1 || Number(dd.value)>31) {
        error[4].innerHTML = "생년월일을 다시 확인해주세요.";
    } else {
        checkAge();
		return 1;
    }
}

function checkAge() {
    if(Number(yy.value) < 1920) {
        error[4].innerHTML = "정말이세요?";
        error[4].style.display = "block";
    } else if(Number(yy.value) > 2020) {
        error[4].innerHTML = "미래에서 오셨군요. ^^";
        error[4].style.display = "block";
    } else if(Number(yy.value) > 2005) {
        error[4].innerHTML = "만 14세 미만의 어린이는 보호자 동의가 필요합니다.";
        error[4].style.display = "block";
    } else {
        error[4].style.display = "none";
		return 1;
    }
}

function genderchk() {
    if(gender.value === "성별") {
		error[6].innerHTML = "성별을 선택해주세요"
        error[6].style.display = "block";
    } else {
        error[6].style.display = "none";
		return 1;
    }
}



function isEmailCorrect() {
    var emailPattern = /[a-z0-9]{2,}@[a-z0-9-]{2,}\.[a-z0-9]{2,}/;
    if(email.value == ""){
		error[7].innerHTML = "필수 정보입니다"; 
        error[7].style.display = "block"; 
    } else if(!emailPattern.test(email.value)) {
		error[7].innerHTML = "이메일 형식을 다시 한번 확인해주세요"; 
        error[7].style.display = "block";
    } else {
        error[7].style.display = "none";
		return 1;
    }

}







function chk_auth(){
	del_email = frm.email.value
	axios.post('/user/chk_auth', {
		email: del_email
	}).then(function(res) {
		console.log(res.data);
		if(res.data != 1){
			alert('본인인증을 해주세요!')
		}else{
			ajaxEmailchk =1;
		}
	})
}

function del_Email(){
	axios.post('/user/delEmail',{
		email : del_email 
	}).then(function(res){
		
	})
}



 document.querySelector('#frm').onsubmit = function(event){
	console.log(ajaxIdchk)
	if(checkId() != 1){alert('아이디를 확인해주세요'); return false;}
	if(ajaxIdchk != 1) {alert('아이디 중복확인 해주세요'); return false;}
	if(checkPw() != 1){alert('비밀번호를 확인해주세요'); return false;}
	if(comparePw() != 1){alert('비밀번호 재확인을 확인해주세요'); return false;}
	if(checkName() != 1){alert('이름을 확인해주세요'); return false;}
	if(checkNickName() != 1){alert('활동명을 확인해주세요'); return false;}	
	if(isBirthCompleted() != 1){alert('출생년도를 확인해주세요'); return false;}
	if(checkAge() != 1){alert('나이를 확인해주세요'); return false;}
	if(genderchk() != 1){alert('성별을 입력해주세요'); return false;}
	chk_auth();
	if(ajaxEmailchk != 1) {return false;}
	notMove = 1;
}




window.onbeforeunload = function() {
	if(del_Email != null && notMove == 0){
		return del_Email();
	}
}

