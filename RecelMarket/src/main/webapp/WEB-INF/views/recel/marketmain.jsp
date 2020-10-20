<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<section class="content">
	<c:forEach items="${data.list}" var="item">
		<ol onclick="detail(${item.i_recel})">
			<li>
				<dl>
					<dt>${item.title}</dt>
					<dd>
						<img
							src="/res/img/recel/${item.i_recel}/recel_img/${item.recel_pic}">
					</dd>
					<dd>
						가격:
						<fmt:formatNumber type="number" value="${item.price}" />
						원
					</dd>
					<dd>카테고리: ${item.cm_nm} > ${item.cd_nm}</dd>
					<dd>거래지역</dd>
				</dl>
			</li>
		</ol>
	</c:forEach>
</section>
<div id="page">
	<c:forEach var="i" begin="1" end="${data.page}" step="1">
		<a href="/recel/market?page=${i}">${i }</a>
</c:forEach>
</div>
<script>
	function detail(i_recel){
		location.href = "/recel/detailMarket?i_recel=" + i_recel 
	}
</script>
