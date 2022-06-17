<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/head.jsp"></jsp:include>
<script>
	window.onload = function() {
	    document.frm.onsubmit = function() {
	    	var id = document.frm.id;
	    	var pwd = document.frm.pw;
	    	var name = document.frm.name;
	    	var email = document.frm.email;
	        if(!id.value) {
	            alert("아이디를 입력하세요")
	            id.focus();
	            return false;
	        }
	        if(!pw.value) {
	            alert("비밀번호를 입력하세요")
	            pw.focus();
	            return false;
	        }
	        if(pw.value != pwConf.value) {
	            alert("비밀번호를 다시 입력하세요")
	            pwConf.focus();
	            return false;
	        }
	        if(!name.value) {
	            alert("이름을 입력하세요")
	            name.focus();
	            return false;
	        }
	        if(!email.value) {
	            alert("이메일을 입력하세요")
	            email.focus();
	            return false;
	        }
	    }
	}
</script>
</head>
<body>
	<jsp:include page="../common/nav.jsp"></jsp:include>
	<section>
        <div class="background">
            <form name="frm" method="post">
                <div class="center">
                    <img src="${cp}assets/images/airplane.png" alt="airplane-icon">
                    <h2 class="font-gd">다시 가고싶은 여행, 휴먼투어</h2>
                </div>
                <div class="join-frm">
                    <div>
                        <label for="id">ID</label>
                        <input type="text" id="id" autofocus name="id">
                        <button type="button" id="btn-cfId" class="btn-cfId">중복체크</button>
                        <input type="hidden" id="chkId" value="1">
                    </div>
                    <div>
                        <label for="pw" class="pw">비밀번호</label>
                        <input type="password" id="pw" name="pw">
                    </div>
                    <div>
                        <label for="pwConf">비밀번호 확인</label>
                        <input type="text" id="pwConf" name="pwConf">
                    </div>
                    <div>
                        <label for="name">이름</label>
                        <input type="text" id="name" name="name">
                    </div>
                    <div>
                        <label for="email">email</label>
                        <input type="text" id="email" name="email">
                        <button type="button" id="btn-cfEmail" class="btn-cfEmail">중복체크</button>
                        <input type="hidden" id="chkEmail" value="1">
                    </div>
                    <div>
                    	<button type="button" id="searchAddr">주소 검색</button>
                        <label for="roadAddr">주소</label>
                        <input type="text" id="roadAddr" name="roadAddr" readonly>
                    </div>
                    <div>
                        <label for="addrDetail">상세주소</label>
                        <input type="text" id="addrDetail" name="addrDetail" readonly>
                    </div>
                    <input type="hidden" id="si" name="si">
                    <input type="hidden" id="sgg" name="sgg">
                    <input type="hidden" id="emd" name="emd">
                    <input type="hidden" id="zipNo" name="zipNo">
                    <input type="hidden" id="roadFullAddr" name="roadFullAddr">
                    <input type="hidden" id="jibunAddr" name="jibunAddr">
	                <div class="center">
	                    <button id="btn-join"><p>가입하기</p></button>
	                </div>
                </div>
            </form>
        </div>
        <script>
        	$(function() {
	        	var cp = '${pageContext.request.contextPath}'
	        
	            $("#searchAddr").click(function() {
	                var pop = window.open("${cp}juso", "pop", "width=570,height=420, scrollbars=yes, resizable=yes");
	            })
	
	            $("#btn-cfId").click(function() {
	                var id = {id : $("#id").val()}
	                $.ajax(cp + "/member/findMember", {
	                    data : id,
	                    method : "post",
	                    success : function(data) {
	                        $("#chkId").val(data);
	                    }
	                })
	            })
				
				
	        	
	        	$("#btn-cfEmail").click(function() {
	        		var email = {email : $("#email").val()}
	        		$.ajax(cp + "/member/findMember", {
	        			data : email,
	        			method : "get",
	        			success : function(data) {
	        				console.log(data);
	        				$("#chkEmail").val(data);
	        			}
	        		})
	        	});
	        	
	        	$("#id").change(function() {
	        		$("#chkId").val(1);
	        	});
	        	
	        	$("#email").change(function() {
	        		$("#chkEmail").val(1);
	        	});
	        	
	        	$("form").submit(function() {
	        		if($("#chkId").val()) {
	        			alert("id 중복 체크 해라")
	        		return false;
	        		}
	        		if($("#chkEmail").val()) {
	        			alert("email 중복 체크 해라")
	        		return false;
	        		}
	        	});
            
            
        	});

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