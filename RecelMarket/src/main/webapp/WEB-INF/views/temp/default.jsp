<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/res/css/${css}.css">
<title>${title}</title>
</head>
<body>
		<jsp:include page="/WEB-INF/views/${view}.jsp"></jsp:include>
</body>
</html>