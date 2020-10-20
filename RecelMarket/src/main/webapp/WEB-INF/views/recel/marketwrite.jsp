<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css">
<div id="section_wrap">
	<form id="form1" action="/recel/write" method="post"
		onsubmit="return chk()" enctype="multipart/form-data"
		target="repacatFrame">
		<div id="title">
			<input type="text" placeholder="제목을 입력해주세요" name="title">
		</div>
		<div class="swiper-container swiper2">
			<div class="swiper-wrapper">
				<div class="swiper-slide">
					<img
						src="/res/img/sample.jpg">
				</div>
				<div class="swiper-slide">
					<img
						src="/res/img/sample.jpg">
				</div>
			</div>
			<div class="swiper-button-next"></div>
			<!-- 다음 버튼 (오른쪽에 있는 버튼) -->
			<div class="swiper-button-prev"></div>
			<!-- 이전 버튼 -->
			<!-- 페이징 -->
		</div>
		<main>
			<section>
				<div id="border-bottom">
					<input id="pic_up" type="file" name="file" multiple>
					&nbsp &nbsp &nbsp &nbsp &nbsp카테고리 : <select name="cm_category"
						onchange="selectvalue()">
						<option value="0">--선택--</option>
						<c:forEach items="${cdList}" var="item">
							<option value="${item.i_m}">${item.cd_nm}</option>
						</c:forEach>
					</select> <select id="selected" name="cd_category">
						<option value="0">--선택--</option>
					</select> &nbsp &nbsp &nbsp &nbsp &nbsp 가격: <input type="number"
						name="price">
				</div>
				<div id="write">
					<textarea name="ctnt"></textarea>
				</div>

			</section>
			<div id="posi_right">
				<button>등록</button>
				<button>취소</button>
			</div>
		</main>
	</form>
</div>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script>
	function selectvalue() {
		var i_m = form1.cm_category.value;
		console.log(i_m)
		axios.get('/recel/ajaxDetailCodeList', {
			params : {
				i_m : i_m
			}
		}).then(function(res) {
			const select = document.querySelector('#selected')
			select.innerHTML = ''
			for (var i = 0; i < res.data.length; i++) {
				let option = document.createElement('option');
				option.innerHTML = res.data[i].val;
				option.value = res.data[i].cd;
				select.append(option)
			}

		})

	}

	new Swiper('.swiper2', {
		loop : true, // 무한 루프 슬라이드, 반복이 되며 슬라이드가 끝이 없다.
		navigation : { // 네비게이션 설정
			nextEl : '.swiper-button-next', // 다음 버튼 클래스명
			prevEl : '.swiper-button-prev', // 이번 버튼 클래스명
		},
	});


/* 	function inputNumberAutoComma(obj) {

		// 콤마( , )의 경우도 문자로 인식되기때문에 콤마를 따로 제거한다.
		var deleteComma = obj.value.replace(/\,/g, "");

		// 콤마( , )를 제외하고 문자가 입력되었는지를 확인한다.
		if (isFinite(deleteComma) == false) {
			alert("문자는 입력하실 수 없습니다.");
			obj.value = "";
			return false;
		}

		// 기존에 들어가있던 콤마( , )를 제거한 이 후의 입력값에 다시 콤마( , )를 삽입한다.
		obj.value = inputNumberWithComma(inputNumberRemoveComma(obj.value));
	}

	// 천단위 이상의 숫자에 콤마( , )를 삽입하는 함수
	function inputNumberWithComma(str) {

		str = String(str);
		return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, "$1,");
	}

	// 콤마( , )가 들어간 값에 콤마를 제거하는 함수
	function inputNumberRemoveComma(str) {

		str = String(str);
		return str.replace(/[^\d]+/g, "");
	} */
	
</script>