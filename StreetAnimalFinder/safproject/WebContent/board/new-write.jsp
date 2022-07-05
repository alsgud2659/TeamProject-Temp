<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/board/new-write.css">
    <title>Document</title>

    <!-- summernote 가져온것 -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">

    <!-- summernote 가져온것 -->

<link rel="stylesheet" href="${pageContext.request.contextPath}/board/new-write.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/board/new-write.css">



</head>

<body>
  <jsp:include page="/header/header.jsp"/>

    <section class="container g-mb-120">

        <h3 class="h5 g-font-weight-600 g-mb-20">글 쓰기</h3>

        <form id="validate-form" class="" action="${pageContext.request.contextPath}/board/controller/BoardWriteOk.bo" method="post"
            novalidate="novalidate" name="writeForm">
            <input id="category" name="category" value="parttake" type="hidden">
            <input id="subcategory" name="subcategory" value="review" type="hidden">
            <input id="enabled" name="enabled" value="true" type="hidden">
            <input id="hit" name="hit" value="1" type="hidden">


            <div class="form-group g-mb-20">
                <label class="g-mb-10" for="btitle">제목</label>
                <input id="btitle" name="btitle" type="text" class="form-control form-control-md rounded-0" value="">
                <small class="form-text text-muted g-font-size-default g-mt-10">100자 이내로 입력해 주세요</small>
            </div>
            <div class="form-group g-mb-20">
                <label class="g-mb-10" for="burl">인스타그램 주소</label>
                <input id="burl" name="burl" type="text" class="form-control form-control-md rounded-0" value="" placeholder="https://www.instagram.com">
                <!--<small class="form-text text-muted g-font-size-default g-mt-10">100자 이내로 입력해 주세요</small>-->
            </div>
            
			<input type="hidden" name="bcontent">
            <div class="form-group g-mb-20">
                <label class="g-mb-10">내용</label>
            </div>


    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

            <!-- summernote 가져온 코드 -->
            <div id="summernote"></div>
            <!-- summernote 가져온 코드 -->

            <small class="form-text text-muted g-font-size-default g-mt-10">게시글 내에 이미지를 넣을 경우 원활한 로딩을 위해 가로 사이즈 1,000픽셀 이하로 올려 주세요</small>
            
            <!-- 글등록 -->
            <div class="row">
                <div class="col-md-6">
                    <div id="g-recaptcha"><div style="width: 304px; height: 78px;"></div>
                    <textarea id="g-recaptcha-response" name="g-recaptcha-response" class="g-recaptcha-response" required="required" style="width: 250px; height: 40px; border: 1px solid rgb(193, 193, 193); margin: 10px 25px; padding: 0px; resize: none; display: none;"></textarea></div><iframe style="display: none;"></iframe></div>
                    <!--<div id="g-recaptcha"><div style="width: 304px; height: 78px;"><div><iframe title="reCAPTCHA" src="https://www.google.com/recaptcha/api2/anchor?ar=1&amp;k=6LeV6ckUAAAAAJpFfNdcuIUZl15rljaAcfsOXkBt&amp;co=aHR0cHM6Ly93d3cuZWthcmEub3JnOjQ0Mw..&amp;hl=ko&amp;v=0aeEuuJmrVqDrEL39Fsg5-UJ&amp;size=normal&amp;cb=z8lu125cif32" width="304" height="78" role="presentation" name="a-c3wox1kwrxjk" frameborder="0" scrolling="no" sandbox="allow-forms allow-popups allow-same-origin allow-scripts allow-top-navigation allow-modals allow-popups-to-escape-sandbox"></iframe></div><textarea id="g-recaptcha-response" name="g-recaptcha-response" class="g-recaptcha-response" required="required" style="width: 250px; height: 40px; border: 1px solid rgb(193, 193, 193); margin: 10px 25px; padding: 0px; resize: none; display: none;"></textarea></div><iframe style="display: none;"></iframe></div>
                </div>-->
                <div class="col-md-6">
                    <div class="text-right">
                        <button class="btn u-btn-primary rounded-0" type="button" onclick="send()">글 등록 </button>	
                    </div>
                </div>
            </div>
            <!-- 글등록 -->

        </form>
    </section>


  <jsp:include page="/footer/footer.jsp"/>

</body>
<script>
function send(){
	$("input[name='bcontent']").val($("#summernote").summernote("code"));
	writeForm.submit();
}
  $('#summernote').summernote({
    tabsize: 2,
    height: 350,
    toolbar: [
      ['style', ['style']],
      ['font', ['bold', 'underline', 'clear']],
      ['color', ['color']],
      ['para', ['ul', 'ol', 'paragraph']],
      ['table', ['table']],
      ['insert', ['link', 'picture', 'video']],
      ['view', ['fullscreen', 'codeview', 'help']]
    ]
  });
</script>
</html>