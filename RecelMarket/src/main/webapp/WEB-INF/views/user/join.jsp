<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="header">
	<a href="#" target="_blank" title="회원가입 페이지 보러가기"><img
		src="/res/img/프로젝트로고.PNG" id="logo"></a>
</div>
<!-- wrapper -->
<div id="wrapper">

	<!-- content-->
	<div id="content">
		<form id="frm" action="/user/join" method="post"
			onsubmit="return chk()">
			<!-- ID -->
			<div>
				<h3 class="join_title">
					<label for="id">아이디</label>
				</h3>
				<span class="box int_id"> <input type="text" id="id"
					name="user_id" class="int" maxlength="20">
					<button type="button" id="chk_id" class="btn_position">
						<span>중복확인</span>
					</button>
				</span> <span class="error_next_box"></span>
			</div>
			<!-- PW1 -->
			<div>
				<h3 class="join_title">
					<label for="pswd1">비밀번호</label>
				</h3>
				<span class="box int_pass"> <input type="password" id="pswd1"
					name="user_pw" class="int" maxlength="20"> <span
					id="alertTxt">사용불가</span> <img src="/res/img/m_icon_pass.png"
					id="pswd1_img1" class="pswdImg">
				</span> <span class="error_next_box"></span>
			</div>

			<!-- PW2 -->
			<div>
				<h3 class="join_title">
					<label for="pswd2">비밀번호 재확인</label>
				</h3>
				<span class="box int_pass_check"> <input type="password"
					name="user_pwre" id="pswd2" class="int" maxlength="20"> <img
					src="/res/img/m_icon_check_disable.png" id="pswd2_img1"
					class="pswdImg">
				</span> <span class="error_next_box"></span>
			</div>

			<!-- NAME -->
			<div>
				<h3 class="join_title">
					<label for="name">이름</label>
				</h3>
				<span class="box int_name"> <input type="text" id="name"
					name="nm" class="int" maxlength="20">
				</span> <span class="error_next_box"></span>
			</div>

			<!-- NICKNAME -->
			<div>
				<h3 class="join_title">
					<label for="name">활동명</label>
				</h3>
				<span class="box int_name"> <input type="text" id="nickname"
					name="nickname" class="int" maxlength="20">
				</span> <span class="error_next_box"></span>
			</div>

			<!-- 주소 -->
			<div>
				<h3 class="join_title">
					<label for="id">주소 ※필수사항</label>
				</h3>
				<span class="box int_id"> <input type="text" id="addr1"
					name="zip_cord" class="int" maxlength="20" readonly>
					<input placeholder="도로명 주소" name="addr" id="addr2" type="hidden" readonly/>
					<button type="button" id="chk_adress" class="btn_position">
						<span>주소찾기</span>
					</button>
				</span>
			</div>
			<!-- BIRTH -->
			<div>
				<h3 class="join_title">
					<label for="yy">생년월일</label>
				</h3>

				<div id="bir_wrap">
					<!-- BIRTH_YY -->
					<div id="bir_yy">
						<span class="box"> <input type="text" id="yy" class="int"
							name="bir_yy" maxlength="4" placeholder="년(4자)">
						</span>
					</div>

					<!-- BIRTH_MM -->
					<div id="bir_mm">
						<span class="box"> <select id="mm" class="sel"
							name="bir_mm">
								<option>월</option>
								<option value="01">1</option>
								<option value="02">2</option>
								<option value="03">3</option>
								<option value="04">4</option>
								<option value="05">5</option>
								<option value="06">6</option>
								<option value="07">7</option>
								<option value="08">8</option>
								<option value="09">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
						</select>
						</span>
					</div>

					<!-- BIRTH_DD -->
					<div id="bir_dd">
						<span class="box"> <input type="text" id="dd" class="int"
							name="bir_dd" maxlength="2" placeholder="일">
						</span>
					</div>

				</div>
				<span class="error_next_box"></span>
			</div>

			<!-- GENDER -->
			<div>
				<h3 class="join_title">
					<label for="gender">성별</label>
				</h3>
				<span class="box gender_code"> <select id="gender"
					name="gender" class="sel">
						<option>성별</option>
						<option value="M">남자</option>
						<option value="F">여자</option>
				</select>
				</span> <span class="error_next_box">필수 정보입니다.</span>
			</div>

			<!-- EMAIL -->
			<div>
				<h3 class="join_title">
					<label for="email">본인확인 이메일<span class="optional">(필수!)</span></label>
				</h3>
				<span class="box int_email"> <input type="text" id="email"
					name="email" class="int" maxlength="100">
					<button type="button" id="chk_email" class="btn_position">
						<span>본인확인</span>
					</button>
				</span> <span class="error_next_box"></span>
			</div>
			<!-- JOIN BTN-->
			<div class="btn_area">
				<button type="submit" id="btnJoin">
					<span>가입하기</span>
				</button>
			</div>
		</form>
	</div>
	<!-- content-->
</div>
<!-- wrapper -->
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="/res/js/main.js"></script>