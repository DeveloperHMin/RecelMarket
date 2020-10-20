<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css">
<div id="section_wrap">
	<div id="title">${data.title}</div>
	<div class="swiper-container swiper2">
		<div class="swiper-wrapper">
			<c:forEach items="${pic}" var="item">
				<div class="swiper-slide">
					<img src="/res/img/recel/${data.i_recel}/recel_img/${item.recel_pic}">
				</div>
			</c:forEach>
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
				<div>카테고리: ${data.cm_nm} > ${data.cd_nm}</div>
				<div>
					가격:
					<fmt:formatNumber type="number" value="${data.price}" />
					원
				</div>
				<div>
					작성자: ${data.nickname}
					<c:choose>
						<c:when test="${data.profile_img != null}">
							<img class="pImg"
								src="/res/img/user/${data.i_user}/${data.profile_img}">
						</c:when>
						<c:otherwise>
							<img class="pImg" src="/res/img/default_profile.jpg">
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div id="write">${data.ctnt}</div>

		</section>
	</main>
</div>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>
<script>
	new Swiper('.swiper2', {
		loop : true, // 무한 루프 슬라이드, 반복이 되며 슬라이드가 끝이 없다.
		navigation : { // 네비게이션 설정
			nextEl : '.swiper-button-next', // 다음 버튼 클래스명
			prevEl : '.swiper-button-prev', // 이번 버튼 클래스명
		},
	});
</script>