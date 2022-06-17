<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../common/nav.jsp"></jsp:include>
	<section>
        <form method="post">
            <div class="background center">
                <div class="clear">
                    <input class="font-gd" type="text" value="${board.title}" name="title">
                    <h3 class="font-gd">${board.regDate}</h3>
                </div>
                <textarea class="modify" name="content">${board.content}</textarea>
                <div>
                    <ul class="center">
                        <li><button>수정</button></li>
                        <li><a href="list${cri.params2}">목록</a></li>
                    </ul>
                </div>
            </div>
        </form>
    </section>
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>