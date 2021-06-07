<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>  

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YouNeeds - OrderPay</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<link href="${path}/resources/css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="${path}/resources/css/bootstrap.css" rel="stylesheet" type="text/css">
<script>
function open_import() {
	IMP.init('imp36070952');
	var msg;
	
	IMP.request_pay({
	    pg : 'kakaopay',
	    pay_method : 'card',
	    merchant_uid : 'merchant_' + new Date().getTime(),
	    name : '주문명:결제테스트',
	    amount : $("#order_pay").val(),
	    buyer_email : '${orderDto.order_email}',
	    buyer_name : $("#order_name").val(),
	    buyer_tel : $("#order_phone").val(),
	    buyer_addr : $("input[name=order_addr1]").val()+" "+$("input[name=order_addr2]").val(),
	    buyer_postcode : '123-456'
	}, function(rsp) {
	    if ( rsp.success ) {
	    	//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
	    	jQuery.ajax({
	    		url: "/payments/complete", //cross-domain error가 발생하지 않도록 주의해주세요
	    		type: 'POST',
	    		dataType: 'json',
	    		data: {
		    		imp_uid : rsp.imp_uid
		    		//기타 필요한 데이터가 있으면 추가 전달
	    		}
	    	}).done(function(data) {
	    		//[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
	    		if ( everythings_fine ) {
	    			var msg = '결제가 완료되었습니다.';
	    			msg += '\n고유ID : ' + rsp.imp_uid;
	    			msg += '\n상점 거래ID : ' + rsp.merchant_uid;
	    			msg += '\결제 금액 : ' + rsp.paid_amount;
	    			msg += '카드 승인번호 : ' + rsp.apply_num;
	    			
	    			alert(msg);
	    		} else {
	    			//[3] 아직 제대로 결제가 되지 않았습니다.
	    			//[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
	    		}
	    	});
	    	$("input[name=imp_uid]").val(rsp.imp_uid);
	    	var form = document.orderForm;
	    	form.submit();
	    } else {
	        var msg = '결제에 실패하였습니다.';
	        msg += '에러내용 : ' + rsp.error_msg;
	        
	        alert(msg);
	    }
	});
}
</script>
<script type="text/javascript">
function requestInform(){
	$.ajax({
		url : '${path}/requestMyInform',
		type : 'POST',
		dataType : 'json',
		data: 'm_uid='+${sessionScope.member.m_uid},
		success : function(data){
			$('#order_name').val(data.m_nickname);
			$('#order_email').val(data.m_email);
			$('input[name=order_addr1]').val(data.m_addr);
			$('input[name=order_addr2]').val(data.m_addr_detail);
		},
		error : function(){
			alert('데이터를 가져오는 중에 문제가 발생했습니다.');
		}
	});
}

</script>
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
            $("input[name=order_addr1]").eq(0).val(data.address);
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
			<input type="button"  id="myinfo_add" class="btn btn-info" type="button" onclick="requestInform();" value="나의 정보 가져오기">
			<form action="OrderSuccess" method="post" name="orderForm">
				<input type="hidden" name="p_id" value="${param.p_id}">
				<input type="hidden" name="imp_uid" value="">
				<div class="form_group">
					<label for="order_name" class="form_label"><h5>결제자 이름</h5></label>
					<input id="order_name" name="order_name" class="order_input_text form-control" type="text" required="required" placeholder="이름을 입력해주세요." style="float: right;">
				</div>
				<div class="form_group">
					<label for="order_pay" class="form_label"><h5>결제 금액</h5></label>
					<input id="order_pay" name="order_pay" class="order_input_text form-control" type="text" required="required" placeholder="금액을 입력해주세요." style="float: right;">
				</div>
				<div class="form_group">
					<label for="order_phone" class="form_label"><h5>연락처</h5></label>
					<input id="order_phone" name="order_phone" class="order_input_text form-control" type="text" required="required" placeholder="연락처를 입력해주세요." style="float: right;">
				</div>
				<div class="form_group">
					<label for="order_email" class="form_label"><h5>이메일</h5></label>
					<input id="order_email" name="order_email" class="order_input_text form-control" type="email" required="required" placeholder="이메일을 입력해주세요." style="float: right;">
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
				
				<div>
					<input type="button" class="btn btn-info" onclick="open_import();" value="결제하기" style="text-align: center;">
				</div>
			</form>
		</div>
		
	</div>
	


	<!-- include footer -->
	<jsp:include page="../../pages/form/footer.jsp"></jsp:include>
<script src="${path}/resources/js/bootstrap.js"></script>
</body>
</html>