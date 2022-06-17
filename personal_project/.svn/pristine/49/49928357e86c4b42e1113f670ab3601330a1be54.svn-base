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
	<section class="galSec">
		<c:if test="${page.cri.category == 3}">
	        <p class="font-gd">대한민국 구석구석</p>
		</c:if>
		<c:if test="${page.cri.category == 4}">
	        <p class="font-gd">다시 떠나는 해외여행</p>
		</c:if>
		<c:if test="${page.cri.category == 5}">
	        <p class="font-gd">지금 바로 떠나고 싶다면</p>
		</c:if>
        <div class="galBack">
        	<!-- 130 x 90 pixel -->
            <c:forEach items="${boards}" var="board">
            	<div class="gallery">
	                <a href="get${page.cri.params2}&bno=${board.bno}"><img onerror="this.src='${cp}assets/images/noimage.png'" src="${cp}display?uuid=s_${board.attachs[0].uuid}&path=${board.attachs[0].path}" alt="${board.attachs[0].origin}"></a>
	                <h4>${board.title}</h4>
	                <textarea readonly>${board.content}</textarea>
            	</div>
           </c:forEach>
           <nav class="right">
           		<c:if test="${member.auth > 1}">
                	<a class="write1" href="${cp}board/register?category=${page.cri.category}">글쓰기</a>
                </c:if>
            </nav>
            <div class="pagination clear">
	           	<ul class="pagination">
	            	<c:if test="${page.prev}">
						<li><a href="list${page.cri.params}&pageNum=${page.cri.pageNum - 1}">prev</a></li>
	            	</c:if>
	  		            <c:forEach begin="${page.start}" end="${page.end}" var="p">
						<li><a href="list${page.cri.params}&pageNum=${p}">${p}</a></li>
	           	    </c:forEach>
	                <c:if test="${page.next}">
						<li><a href="list${page.cri.params}&pageNum=${page.cri.pageNum + 1}">next</a></li>
	                </c:if>
				</ul>
            </div>
        </div>
    </section>
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>