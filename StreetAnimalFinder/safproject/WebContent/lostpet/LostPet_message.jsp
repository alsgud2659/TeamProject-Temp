<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/
    lostpet/LostPet.css" type="text/css">
    <script src="https://code.jquery.com/jquery-latest.js"></script> 
</head>

<body>
  <jsp:include page="/header/header.jsp"/>
    <div class="container te space-1">
        <div class="container">
            <h2 class="g-font-size-28 font-weight-bold g-line-height-1">주인 / 발견 신고하기</h2>
            <h3 class="h5 g-font-weight-600 g-mb-20" style="color: #9b111e;">여기에 쓰는 내용은 글쓴이의 핸드폰으로 발송됩니다. 내용에 주의해주세요. </h3>

            <div class="g-mb-20">
                <label class="g-mb-20" for="name">보내는 이</label>
                <input type="text" id="name" name="name" value="스트릿 애니멀 파인더"
                    class="form-control form-control-md rounded-0" readonly>
            </div>
            <form action="" name="messageForm" method="post">
                <div class="g-mb-20">
                    <label class="g-mb-20" for="name">제목</label>
                    <input type="text" id="name" name="name" class="form-control form-control-md rounded-0" required>
                </div>
                <div class="g-mb-20">
                    <label class="g-mb-20" for="name" >게시물 링크</label>
                    <select id="idContent" name="idContent" class="custom-select cs" onchange='printIdContent(this, 1)'>
                        <option value="">자신이 쓴 게시물 링크</option>
                        <option value="https://www.youtube.com/">게시물 제목</option>
                        <option value="https://drive.google.com/drive/my-drive">역삼동 / 개(비글)</option>
                        <option value=" ">직접 입력</option>
                    </select>
                    <input type="text" id="link" name="link" class="form-control form-control-md rounded-0" required readonly>
                </div>
                <div class="g-mb-20">
                    <label class="g-mb-20" for="content">내용</label>
                    <textarea id="content" class="form-control form-control-md rounded-0 messageBox" ></textarea>
                </div>
                <div class="text-right">
                    <button class="btn btn-primary  rounded-0" type="submit">보내기</button>
                </div>
            </form>
        </div>
    </div>
  <jsp:include page="/footer/footer.jsp"/>

</body>
<script type="text/javascript">

function printIdContent(s,no){
    form = document.messageForm;
    sel = s[s.selectedIndex].value;
    dis = 1;
 
    if(sel==" "){
        sel = "";
        dis = 0;
    }
 
    if(no==1){
        form.link.value = sel;
        form.link.disabled = dis;
    }
}


</script>
</html>