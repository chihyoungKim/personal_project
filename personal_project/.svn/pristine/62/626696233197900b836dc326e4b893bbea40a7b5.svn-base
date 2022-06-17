<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../common/nav.jsp"></jsp:include>
	<section>
        <div class="background">
            <form method="post" enctype="multipart/form-data">
            	<input type="hidden" name="category" value="${cri.category}">
            	<input type="hidden" name="pageNum" value="${cri.pageNum}">
            	<input type="hidden" name="amount" value="${cri.amount}">
                <div class="center"><h2 class="font-gd">게시글 작성</h2></div>
                <div class="center">
                    <input class="regText" type="text" name="title" autofocus>
                    <textarea class="regText" name="content"></textarea>
                    <c:if test="${cri.category >= 3}">
	                    <div class="left pack" id="package">
	                        <input id="city" type="text" placeholder="도시" name="city">
	                        <input id="time" type="text" placeholder="기간" name="time">
	                        <input id="price" type="text" placeholder="가격" name="price">
	                        <select name="refund" id="refund" class="m-0">
	                            <option value="환불 가능">환불 가능</option>
	                            <option value="환불 불가">환불 불가</option>
	                        </select>
	                    </div>
                    </c:if>
                    <div class="clear pack">
				    	<input type="file" id="file" name="file" multiple>
				  	</div>
                </div>
                <div class="center m-0">
                    <button><p>글쓰기</p></button>
                    <button><p>취소</p></button>
                </div>
            </form>
        </div>
    </section>
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>