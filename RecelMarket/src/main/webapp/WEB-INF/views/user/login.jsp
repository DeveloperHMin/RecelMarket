<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="main-container">
		<div class="main-wrap">
		<header>
			<div class="logo-wrap">
				<img src="/res/img/프로젝트로고.PNG">
			</div>
		</header>
		<section class="login-input-section-wrap">
			<form action="/user/login" method="post" >
				<div class="login-input-wrap">	
					<input placeholder="아이디" type="text" name="user_id"></input>
				</div>
				<div class="login-input-wrap password-wrap">	
					<input placeholder="비밀번호" type="password" name="user_pw"></input>
				</div>
				<div class="login-button-wrap">
					<button>로그인</button>
				</div>
				<div class="login-stay-sign-in">
					<i class="far fa-check-circle"></i>
					<span><a href="/user/join">회원가입 </a> |</span>
					<span><a href="/user/join">아이디 찾기 </a> |</span>
					<span><a href="/user/join">비밀번호 찾기 </a></span>
				</div>
			</form>
		</section>
		</div>
	</div>
	<script type="text/javascript">
		console.log(`${data.msg}`)
		if(`${data.msg}` != ''){
			alert(`${data.msg}`)
		}
	</script>