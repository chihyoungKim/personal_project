<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../common/nav.jsp"></jsp:include>
	<section>
        <div class="background">
            <form method="post">
                <div class="center">
                    <img src="${cp}assets/images/airplane.png" alt="airplane-icon">
                    <h2 class="font-gd">다시 가고싶은 여행, 휴먼투어</h2>
                </div>
                <div>
                    <div>
                        <label for="name">이름</label>
                        <input type="text" id="name" name="name" autofocus required>
                    </div>
                    <div>
                        <label for="email">email</label>
                        <input type="email" id="email" name="email" required>
                    </div>
                </div>
                <div class="center">
                    <button type="button" id="confirmName"><p>확인<span>(필수)</span></p></button>
                    <button type="button" id="sendEmail"><p>메일발송</p></button>
                    <input type="hidden" id="chkName" value="0">
                </div>
            </form>
        </div>
        <script>
        $(function() {
        	var cp = '${pageContext.request.contextPath}'
        	
       		$("#email").change(function() {
        		$("#chkName").val(1);
        	});
       		$("#name").change(function() {
        		$("#chkName").val(1);
        	});
        	
        	$("#confirmName").click(function() {
        		var info = {email : $("#email").val(), name : $("#name").val()}
        		$.ajax(cp + "/member/findMember", {
        			data : info,
        			method : "get",
        			success : function(data) {
        				console.log(data);
        				$("#chkName").val(data);
        			}
        		})
        	});	
	        	
        	
	        $("#sendEmail").click(function() {
	        	
	        	if($("#chkName").val()) {
        			alert("이름과 email을 확인해주세요.")
        			return false;
        		}
	        	
	    		var $btnEmail = $(this);
	    		
	    		var str = '<img src="https://i.stack.imgur.com/qq8AE.gif" width="20">';
	    		
	    		var data = {email : $("#email").val(), name : $("#name").val()}
	    		 $.ajax(cp + "/member/sendTemporaryPw", {
	    			data : data,
	    			method : "get",
	    			beforeSend : function() {
	    				$btnEmail.prop("disabled", true).html(str + " 발송중");
	    			},
	    			success : function(data) {
	    				$btnEmail.prop("disabled", false).html("메일발송");
	    			}
	    		})
	    	});
        });
        
        </script>
    </section>
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>