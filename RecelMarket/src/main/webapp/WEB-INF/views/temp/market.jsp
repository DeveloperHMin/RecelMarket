<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
<link rel="stylesheet" type="text/css" href="/res/css/market.css">
<c:forEach items="${css}" var="item">
	<link rel="stylesheet" type="text/css" href="/res/css/${item}.css">
</c:forEach>
</head>
</head>
<body>
	<div id="headerWrap">
		<header id="header">
			<h1>
				<a href="/recel/market"><img src="/res/img/프로젝트로고.PNG"></a>
			</h1>
			<nav>
				<form name="frm" action="/market/search" method="get">
					<input type="text" id="search" placeholder="물품명을 검색해보세요">
				</form>
			</nav>
			<nav id="right">
				<c:if test="${loginUser != null}">
					<c:choose>
						<c:when test="${loginUser.profile_img != null}">
							<img class="pImg"
								src="/res/img/user/${loginUser.i_user}/${loginUser.profile_img}">
						</c:when>
						<c:otherwise>
							<img class="pImg" src="/res/img/default_profile.jpg">
						</c:otherwise>
					</c:choose>
					<span class="ml5">${loginUser.nickname}님환영합니다.</span>
					<input type="button" value="글쓰기" class="m15"
						onclick="location.href='/recel/write'">
					<input type="button" value="로그아웃" class="m16"
						onclick="location.href='/user/logout'">
				</c:if>
				<c:if test="${loginUser == null}">
					<input type="button" value="로그인" class="m15"
						onclick="location.href='/user/login'">
					<input type="button" value="회원가입" class="m16"
						onclick="location.href='/user/join'">
				</c:if>
			</nav>
		</header>
	</div>
	<jsp:include page="/WEB-INF/views/${view}.jsp"></jsp:include>
	<div id="footerWrap">
		<footer id="footer">
			<p>프로젝트</p>
		</footer>
	</div>
	<script>
		function press(f) {
			if (f.keyCode == 13) {
				frm.submit
			}
		}
	</script>
</body>
</html>