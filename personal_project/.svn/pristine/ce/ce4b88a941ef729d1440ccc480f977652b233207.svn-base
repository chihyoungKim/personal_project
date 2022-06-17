<%@page import="domain.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!-- 메인페이지 -->
<html lang="ko">
<jsp:include page="../common/head.jsp"></jsp:include>
<body>
    <jsp:include page="../common/nav.jsp"></jsp:include>
    <section>
        <div class="main">
            <article>
                <p>격리 걱정 없는 사이판</p>
                <ul>
                    <li><span>싱그러운</span> 에메랄드 빛 바다,</li>
                    <li>청정 휴양지 사이판</li>
                </ul>
                <ul>
                    <li>가족, 연인 또는 친구</li>
                    <li>누구와 함께라도 즐거운 여행지가 될 그곳으로</li>
                </ul>
                <ul>
                    <li>출입국 격리 걱정 없이</li>
                    <li>즐겁고 안전하게 떠나보세요.</li>
                </ul>
                <nav>
                    <a href="${cp}board/get?category=4&bno=9">자세히 보기</a>
                </nav>
            </article>
            <article>
                <h2>[지금바로]여행가능지역</h2>
                <c:forEach items="${boards}" var="board" varStatus="st">
	                <nav>
	                    <a href="${cp}board/get?category=5&bno=${board.bno}"><img src="${cp}display?uuid=${board.attachs[0].uuid}&path=${board.attachs[0].path}" alt="${board.attachs[0].origin}" class="domestic"></a>
	                    <div>${board.content}</div>
	                </nav> 
                </c:forEach>
            </article>
            <article>
                <nav>
                    <h3>출국 전 꼭 참고해야 할 입국 규정을 확인하세요.</h3>
                    <a href="${cp}board/get?&bno=1">국가별 <span>입국 규정</span> 안내</a>
                </nav>
            </article>
            <article>
                <div><img src="${cp}display?uuid=${phuket.attachs[0].uuid}&path=${phuket.attachs[0].path}" alt="${phuket.attachs[0].origin}" alt="phuket"></div>
                <nav class="center">
                    <a href="${cp}board/get?category=4&bno=7">[푸켓 4성 더 참 수페리어룸 5/6일] 가성비 + 자유일정1일 + 태국전통안마2시간 + 산호섬투어</a>
                </nav>
                <div><img src="${cp}display?uuid=${singapore.attachs[0].uuid}&path=${singapore.attachs[0].path}" alt="${singapore.attachs[0].origin}" alt="sigapore"></div>
                <nav class="center">
                    <a href="${cp}board/get?category=4&bno=6">[특가][안심케어/노쇼핑/노팁]싱가포르 3박5일[1일자유/월드체인특급 + 마리나베이샌즈1박]</a>
                </nav>
                <div><img src="${cp}display?uuid=${bangkok.attachs[0].uuid}&path=${bangkok.attachs[0].path}" alt="${bangkok.attachs[0].origin}" alt="bangkok"></div>
                <nav class="center">
                    <a href="${cp}board/get?category=4&bno=8">[3박5일 방콕1+파타야2]가성비최고+타이마사지 2시간+산호섬+악어농장+왓포사원관광</a>
                </nav>
            </article>
        </div>
        <div class="aside">
            <nav class="center">
            	<c:if test="${sessionScope.member == null}">
	                <a href="${cp}member/login">Humantour 로그인</a>
	                <ul class="center">
	                    <li><a href="${cp}member/contract">회원가입</a></li>
	                    <li><a href="${cp}member/findPw">ID/PW찾기</a></li>
	                </ul>
            	</c:if>
            	<c:if test="${sessionScope.member != null}">
            		<p><span>${sessionScope.member.name}</span>님 환영합니다.</p>
	                <ul class="center">
		                <li><a href="${cp}member/logout">Logout</a></li>
	                    <li><a href="${cp}member/mypage">MyPage</a></li>
	                </ul>
            	</c:if>
            </nav>
        </div>
    </section>
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>