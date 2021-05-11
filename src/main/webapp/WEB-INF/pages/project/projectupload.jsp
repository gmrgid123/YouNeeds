<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 등록</title>
<!-- JAVASCRIPTS -->
<script type="text/javascript"
	src="${path}/resources/ckeditor/ckeditor.js"></script>
<script src="${path}/resources/js/jquery.min.js"></script>
<script src="${path}/resources/js/jquery.backtotop.js"></script>
<script src="${path}/resources/js/jquery.mobilemenu.js"></script>

<link href="${path}/resources/css/layout.css" rel="stylesheet"
	type="text/css" media="all">

<!-- -------------------------------------------------------------------------------- -->
<script type="text/javascript">
	$(document).ready(function() {
		// 저장버튼 클릭
		$("#btnSave").on("click", function() {
			fn_save();
		
		});
	});

	// 프로젝트 저장
	function fn_save() {
		var frm = document.frm;
		frm.action = "${path}/pjinsert.do";
		frm.method = "POST";
		frm.submit();
	}
</script>
<!-- --------------------------------------------------------------------- -->
<style type="text/css">


.title {
	width: 100%;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	background-color: #93C0C5;
	color: white;
}

.body {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	margin-bottom: 50px;
	text-align: center;
}

.top {
	width: 350px;
	height: 40px;
	text-align-last: center;
	border: 0.1px solid #93c0c549;
}

#cost {
	width: 350px;
	height: 40px;
	border: 0.1px solid #93c0c549;
}

#date {
	border: 0.1px solid #93c0c549;
}

#intro {
	width: 430px;
	height: 300px;
	border: 0.1px solid #93c0c549;
	border-radius: 10px 10px 10px 10px;
}

textarea {
	resize: none;
	border: 0.1px solid #93c0c549;
	border-radius: 10px 10px 10px 10px;
}

.P0 {
	margin-top: 40px;
}

.P1 {
	margin-top: 25px;
}

.P2 {
	margin-top: 25px;
}

.P3 {
	margin-top: 25px;
}

.P4 {
	margin-top: 30px;
}

.P5 {
	margin-top: 30px;
}

.P6 {
	margin-top: 30px;
	margin-bottom: 20px;
}

.btn {
	display: inline-block;
	width: 120px;
	height: 40px;
	border: 2px solid #93C0C5;
	text-align: center;
	color: #93C0C5;
	font-weight: bold;
}

</style>
</head>
<body>
	<!-- header -->
	<jsp:include page="../form/header.jsp"></jsp:include>

	<!-- --------------------------------------------------------------------------- -->

	<div class="title">
		<h1>프로젝트 등록</h1>
	</div>


	<!-- --------------------------------------------------------------------------- -->

	<form name="frm">
		<div class="body">
			<div class="P0">
				<h2>카테고리 선택</h2>
				 <select id="p_category" name="p_category" class="top">
					<option value="출판">출판</option>
					<option value="공예">공예</option>
					<option value="예술">예술</option>
					<option value="공연">공연</option>
					<option value="푸드">푸드</option>
					<option value="패션">패션</option>
				</select>
			</div>

			<!-- ------------------------------------------------------------------------------ -->

			<div class="P1">
				<h2>프로젝트 제목</h2>
				<input type="text" id="p_title" name="p_title"
					placeholder="프로젝트 제목을 입력하세요(최대40자)">
			</div>

			<!-- ------------------------------------------------------------------------------- -->

			<div class="P2">
				<h2>목표 금액</h2>
				<input type="text" id="target_amount" name="target_amount"
					placeholder="목표금액을 설정하세요">
			</div>

			<!-- ------------------------------------------------------------------------------ -->

			<div class="P3">
				<h2>프로젝트 개최 일시</h2>
				<input type="datetime-local" id="start_date" name="start_date">
				<h2>카테고리 마감 일시</h2>
				<input type="datetime-local" id="end_date" name="end_date">
			</div>

			<!-- ------------------------------------------------------------------------------ -->

			<div class="P4">
				<h2>프로젝트 대표 이미지</h2>
				 <input type="file" id="gdsImg" name="file" />
				 <div class="select_img"><img src="" /></div>
				<script>
					$("#gdsImg").change(
							function() {
								if (this.files && this.files[0]) {
									var reader = new FileReader;
									reader.onload = function(data) {
										$(".select_img img").attr("src",
												data.target.result).width(500);
									}
									reader.readAsDataURL(this.files[0]);
								}
							});
				</script>
			</div>

			<!-- ------------------------------------------------------------------------------ -->

			<div class="P5">
				<h2>프로젝트 소개</h2>
				<div>
					<div>
						<textarea class="form-control" id="p_content" name="p_content"
							required="required" style="resize: none;"></textarea>
						<script type="text/javascript">
							CKEDITOR.config.resize_enabled = false;
							CKEDITOR
									.replace(
											'p_content',
											{
												height : 500,
												filebrowserUploadUrl : '${pageContext.request.contextPath }/adm/fileupload.do'
											});
						</script>
					</div>
					<br>
				</div>
			</div>

			<!-- -------------------------------------------------------------------------------- -->

			<div class="P6">
				<h2>펀딩 안내</h2>
				<textarea cols="80" rows="15"> </textarea>
			</div>
			<div style="text-align: center;">
				<input type="submit" value="작성" id="btnSave" class="btn"> 
				<input type="button" value="취소" id="btnCancel" class="btn" onclick="location.href='notice_board'">
			</div>
		</div>
	</form>


	<!-- --------------------------------------------------------------------------- -->
	<!-- -------------------------------------------------------------------------------- -->
	<!-- footer include -->
	<jsp:include page="../form/footer.jsp"></jsp:include>




</body>
</html>