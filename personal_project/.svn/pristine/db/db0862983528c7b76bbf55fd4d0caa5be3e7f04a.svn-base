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
        <div class="background">
            <table>
            	<c:if test="${param.category == 1}">
	                <caption class="title"><h3 class="font-gd">자유게시판</h3></caption>
            	</c:if>
            	<c:if test="${param.category == 2}">
	                <caption class="title"><h3 class="font-gd">공지사항</h3></caption>
            	</c:if>
                <tr>
                    <th class="col1">글번호</th>
                    <th class="col2">제목</th>
                    <th class="col3">작성자</th>
                    <th class="col4">작성일</th>
                    <th class="col5">조회수</th>
                </tr>
                <c:forEach items="${boards}" var="board">
	                <tr>
	                    <td>${board.bno}</td>
	                    <td><a href="get${page.cri.params2}&bno=${board.bno}">${board.title}</a></td>
	                    <td ${empty board.writer ? 'class="text-muted small"' : ''}>${empty board.writer ? '(탈퇴회원)' : board.writer}</td>
	                    <td>${board.regDate}</td>
	                    <td>${board.hitcount}</td>
	                </tr>
                </c:forEach>
            </table>
            <nav class="right">
            	<c:if test="${param.category != 1 }">
            		<c:if test="${member.auth == 2}">
	                	<a href="${cp}board/register?category=${page.cri.category}">글쓰기</a>
	                </c:if>
            	</c:if>
            	<c:if test="${param.category == 1 }">
                	<a href="${cp}board/register?category=${page.cri.category}">글쓰기</a>
            	</c:if>
            </nav>
            <nav>
                <div>
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
            </nav>
        </div>
    </section>
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>