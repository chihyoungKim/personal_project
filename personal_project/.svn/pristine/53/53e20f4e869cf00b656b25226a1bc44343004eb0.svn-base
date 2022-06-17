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
			<c:if test="${cri.category < 3}">
            <div class="title">
                <h3 class="font-gd overflow">${board.title}</h3><h3 class="font-gd">${board.regDate}</h3>
                <h5>${board.writer}</h5>
                <c:if test="${board.attachs[0] != null}">
	                <h5 class="attach" id="attach">첨부파일</h5>
                </c:if>
                <button type="button" id="btns" class="float-right">댓글 등록</button>
            </div>
            <div class="content-box border-1">
                <textarea class="content">${board.content}</textarea>
            </div>
		    </c:if>
		    
		    
		    <c:if test="${cri.category >= 3}">
			<div class="center">
				<p class="font-gd galtitle">${board.title}</p>
			</div>
			<c:forEach items="${board.attachs}" var="attach">
				<c:if test="${attach.image}">
					<div class="center imgDetail" style="background-image: url('${cp}display?uuid=${attach.uuid}&path=${attach.path}'); background-size: cover;">
						<!-- <img class="galIma" src="${pageContext.request.contextPath}/display?uuid=${attach.uuid}&path=${attach.path}" alt="${attach.origin}"> -->
					</div>
				</c:if>
			</c:forEach>
            <div class="center content2-box">
                <textarea class="content2" readonly>
여행도시 : ${pack.city}
투어 소요 시간 : ${pack.time}
환불 가능 여부 : ${pack.refund}
최대혜택가 : ${pack.price}
                </textarea>
            </div>
			<div class="content-box">
                <textarea class="content" readonly>${board.content}</textarea>
            </div>
            <div class="replies">
	            <!-- Reply part -->
            </div>
		    </c:if>
            <div class="replies">
	            <!-- Reply part -->
            </div>
            <div>
                <ul class="center">
                    <c:if test="${member.id == board.writer}">
                    	<li><a href="modify${cri.params2}&bno=${board.bno}">수정</a></li>
	                    <li><a href="remove${cri.params2}&bno=${board.bno}" onclick="return confirm('삭제하시겠습니까?')">삭제</a></li>
                    </c:if>
                    <li><a href="list${cri.params2}">목록</a></li>
                </ul>
            </div>
        </div>
    </section>

    <!-- The attachModal -->
	<div class="modal" id="attachModal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title font-gd">첨부파일</h4>
	        <button type="button" class="btn-close" data-bs-dismiss="modal">X</button>
	      </div>
	      <!-- Modal body -->
	      <div class="modal-body">
			  <div class="mb-3">
				  <label for="attach" class="form-label"></label>
				  <ul>
				  <c:forEach items="${board.attachs}" var="attach">
				  	<li><a href="${cp}download${attach.params}" class="att-list">${attach.origin}</a></li>
				  </c:forEach>
				  </ul>
			  </div>
	      </div>
	      <!-- Modal footer -->
	      <div class="modal-footer">
	        
	      </div>
	    </div>
	  </div>
	</div>
    <!-- The replyModal -->
	<div class="modal" id="replyModal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title font-gd">댓글 등록</h4>
	        <button type="button" class="btn-close" data-bs-dismiss="modal">X</button>
	      </div>
	      <!-- Modal body -->
	      <div class="modal-body">
			  <div class="mb-3">
				  <textarea name="content" cols="30" rows="10" placeholder="내용 입력" class="reply-text" id="reply-content"></textarea>
				  <input type="hidden" id="reply-writer" value="${member.id}">
				  <input type="hidden" id="bno" value="${board.bno}">
				  <button class="btns" id="register">등록</button>
			  </div>
	      </div>
	      <!-- Modal footer -->
	      <div class="modal-footer">
	        
	      </div>
	    </div>
	  </div>
	</div>
    <script>
    	const bno = "${board.bno}";
    	const cp = "${pageContext.request.contextPath}";
    	
   		$("#attach").click(function() {
			$("#attachModal").modal("show");
		});
   		$("#btns").click(function() {
			$("#replyModal").modal("show");
			$("#reply-content").val("");
		});
    	
    	
    	$(function() {
	    	showList();
    		
	    	function showList() {
				replyService.list(bno, function(data){
					console.log(data);
					var str = "";
					for(var i in data) {
						str+='				<div class="content-box border-1" data-rno="' + data[i].rno + '">'
						str+='					<h5 class="float-left">' + data[i].writer + '</h5><h6 class="float-right">' + data[i].regDate + '</h6>'
						str+='						<input type="text" value="' + data[i].content + '" id="content">'
						str+='					<button class="detail clear" id="detail">detail</button>'
						str+='				</div>'
					}
					$(".replies").html(str);
				}, cp);
			}
	    	//댓글 등록 버튼 클릭 이벤트
			$("#register").click(function() {
				var reply = {bno:bno, content:$("#reply-content").val(), writer:$("#reply-writer").val()};
				replyService.add(reply, function(data){
					showList();
					$("#replyModal").modal("hide")
				}, cp)
			});
	    	
	    	//detail 버튼 클릭 이벤트
			$("#detail").click(function() {
	    		$("#content").hide();
	    	});
    	});
    	
    	
    </script>
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>