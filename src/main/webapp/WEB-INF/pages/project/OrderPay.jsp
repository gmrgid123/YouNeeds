<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>  
<c:set var="now" value="<%=new java.util.Date()%>" />
<c:set var="sysYear"><fmt:formatDate value="${now}" pattern="yyyy-MM-dd" /></c:set> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="${path}/resources/css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="${path}/resources/css/bootstrap.css" rel="stylesheet" type="text/css">
<style type="text/css">
.main_form{
	margin-top: 50px;
	margin-bottom: 50px;
	margin-right: 20%;
	margin-left: 20%;
}

.content_body{
	text-align:center;
	width: 900px;
	padding: 40px 40px 88px;
	border-radius: 4px;
    border: 1px solid rgb(230, 230, 230);
    margin: 0px auto;
}

.form_group{
	padding-left:20px;
	padding-right:20px;
	display: inline-block;
	margin: auto 0px;
	margin-bottom: 8px;
}

.order_input_text{
	width: 500px;
	height: 40px;
	vertical-align: middle;
}
.form_label{
	width:100px;
	text-align:right;
	float:left;
	margin-right: 10px;
	padding-top: 8px;
}
#myinfo_add{
	margin-bottom: 30px;
}

</style>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
function openApi_Addr(){

    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            $("input[name=order_addr1]").eq(0).val(data.address);
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
        }
    }).open();
    
}
</script>
</head>
<body>
	<!-- include header -->
	<jsp:include page="../../pages/form/header.jsp"></jsp:include>
	
	<hr>
	<div class="main_form">
		<div class="content_body">
			<button id="myinfo_add" class="btn btn-info" type="button" onclick="">나의 정보 가져오기</button>
			<form action="" method="post">
				<div class="form_group">
					<label for="order_name" class="form_label"><h5>결제자 이름</h5></label>
					<input id="order_name" name="order_name" class="order_input_text form-control" type="text" required="required" placeholder="이름을 입력해주세요." style="float: right;">
				</div>
				<div class="form_group">
					<label for="order_pay" class="form_label"><h5>결제 금액</h5></label>
					<input id="order_pay" name="order_pay" class="order_input_text form-control" type="text" required="required" placeholder="금액을 입력해주세요." style="float: right;">
				</div>
				<div class="form_group">
					<label for="order_email" class="form_label"><h5>이메일</h5></label>
					<input id="order_email" name="order_email" class="order_input_text form-control" type="email" required="required" placeholder="이메일 입력해주세요." style="float: right;">
				</div>
				<div class="form_group">
					<label for="order_addr" class="form_label"><h5>주소 정보</h5></label>
					<div id="order_addr" style="float: right;">
						<div class="input-group">
						<input name="order_addr1" class="order_input_text form-control" type="text" required="required" placeholder="주소를 입력해주세요.">
							<div class="input-group-append">
								<button  class="btn btn-info" type="button" onclick="openApi_Addr();">주소찾기</button>
							</div>
						</div>
						<input name="order_addr2" class="order_input_text form-control" type="text" placeholder="상세주소를 입력해주세요.">
					</div>
				</div>
				<div class="form_group">
					<label for="order_date" class="form_label"><h5>입금일자</h5></label>
					<input id="order_date" name="order_date" class="order_input_text form-control" type="date" min="${sysYear }" required="required" placeholder="이메일 입력해주세요." style="float: right;">
				</div>
				<div>
					<input type="submit"  class="btn btn-info" value="결제하기" style="text-align: center;">
				</div>
			</form>
		</div>
		
	</div>
	


	<!-- include footer -->
	<jsp:include page="../../pages/form/footer.jsp"></jsp:include>
<script src="${path}/resources/js/jquery.min.js"></script>
<script src="${path}/resources/js/jquery.backtotop.js"></script>
<script src="${path}/resources/js/jquery.mobilemenu.js"></script>
<script src="${path}/resources/js/bootstrap.js"></script>
</body>
</html>