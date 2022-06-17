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
            <form name="frm" method="post">
                <div class="center">
                    <img src="${cp}assets/images/airplane.png" alt="airplane-icon">
                    <h2 class="font-gd">MyPage</h2>
                </div>
                <div class="join-frm">
                    <div>
                        <label for="id">ID</label>
                        <input type="text" id="id" name="id" value="${member.id}" readonly>
                    </div>
                    <div>
                        <label for="pw" class="pw">비밀번호</label>
                        <input type="password" id="pw" name="pw" placeholder="변경할 비밀번호 입력">
                    </div>
                    <div>
                        <label for="name">이름</label>
                        <input type="text" id="name" name="name" value="${member.name}">
                    </div>
                    <div>
                        <label for="email">email</label>
                        <input type="text" id="email" name="email" value="${memberInfo.email}" readonly>
                        <c:if test="${memberInfo.auth == 0}">
  	                    	<button class="btn btn-danger" type="button" id="btnEmail">이메일 인증</button>
  	                    </c:if>
						<c:if test="${memberInfo.auth == 1}">
							<button class="btn btn-success" type="button" id="cfedEmail">인증된 이메일</button>
                        </c:if>
                        <input type="hidden" id="chkEmail" value="1">
                    </div>
                    <div>
                        <button type="button" id="searchAddr">주소 검색</button>
                        <label for="roadAddr">주소</label>
                        <input type="text" id="roadAddr" value="${memberInfo.roadAddr}" name="roadAddr" readonly>
                    </div>
                    <div>
                        <label for="addrDetail">상세주소</label>
                        <input type="text" id="addrDetail" value="${memberInfo.addrDetail}" name="addrDetail" readonly>
                    </div>
                    <input type="hidden" id="si" name="si" value="${memberInfo.si}">
                    <input type="hidden" id="sgg" name="sgg" value="${memberInfo.sgg}">
                    <input type="hidden" id="emd" name="emd" value="${memberInfo.emd}">
                    <input type="hidden" id="zipNo" name="zipNo" value="${memberInfo.zipNo}">
                    <input type="hidden" id="roadFullAddr" name="roadFullAddr" value="${memberInfo.roadFullAddr}">
                    <input type="hidden" id="jibunAddr" name="jibunAddr" value="${memberInfo.jibunAddr}">
                    <div class="center">
                        <button id="btn-join"><p>수정</p></button>
                        <button id="btn-secession" formaction="secession" onclick="return confirm('정말 탈퇴하시겠습니까?')"><p>탈퇴</p></button>
                    </div>
            	</div>
            </form>
        </div>
        <script>
        
        window.onload = function() {
    	    document.frm.onsubmit = function() {
    	    	var pw = document.frm.pw;
    	        if(!pw.value) {
    	            $("#pw").val(${member.pw});
    	        }
    	    }
    	}
        
        
        $(function() {
        	var cp = '${pageContext.request.contextPath}'
        	
	        $("#searchAddr").click(function() {
	            var pop = window.open("${cp}juso", "pop", "width=570,height=420, scrollbars=yes, resizable=yes");
	        });
			
	        $("#btnEmail").click(function() {
	    		var $btnEmail = $(this);
	    		
	    		var str = '<img src="https://i.stack.imgur.com/qq8AE.gif" width="20">';
	    		
	    		var data = {email : $("#email").val(), id : $("#id").val()}
	    		 $.ajax(cp + "/member/memberAuth", {
	    			data : data,
	    			method : "get",
	    			beforeSend : function() {
	    				$btnEmail.prop("disabled", true).html(str + " 발송중");
	    			},
	    			success : function(data) {
	    				$btnEmail.prop("disabled", false).html("이메일 인증");
	    				console.log(data);
	    			}
	    		})
	    	});
        });
        
        $("#btn-join").click(function() {
        	var pw = prompt("기존비밀번호를 입력해주세요.");
        	if(pw != ${member.pw}) {
        		alert("비밀번호가 틀렸습니다.");
        		return false;
        	}
        })

        function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo){
	        $("#si").val(siNm);
	        $("#sgg").val(sggNm);
	        $("#emd").val(emdNm);
	        $("#roadAddr").val(roadAddrPart1);
	        $("#addrDetail").val(addrDetail);
	        $("#zipNo").val(zipNo);
	        $("#roadFullAddr").val(roadFullAddr);
	        $("#jibunAddr").val(jibunAddr);
		}
        
        
        </script>
    </section>
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>