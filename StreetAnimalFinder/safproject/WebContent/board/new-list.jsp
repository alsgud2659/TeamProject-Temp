<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/board/LostPet.css" type="text/css">
    <c:set var="list" value="${boardList}"/>
</head>

<body>
  <jsp:include page="/header/header.jsp"/>

    <div class="dzsparallaxer auto-init height-is-based-on-content use-loading mode-scroll loaded dzsprx-readyall g-bg-cover"
        data-options="{direction: &quot;reverse&quot;, animation_duration: 25, direction: &quot;reverse&quot;}">
        <div class="divimage dzsparallaxer--target w-100 u-bg-overlay g-bg-img-hero g-bg-black-opacity-0_3--after"
            style="height: 130%; background-image: url(/file/getBlob/130690_90612_406.jpg); transform: translate3d(0px, -90px, 0px);">
            ::before
            ::after
        </div>
        <!--글쓰기 버튼-->
        <div class="container u-bg-overlay__inner g-py-100">
            <h2 class="g-color-white g-font-size-24 g-font-weight-600">게시판 목록</h2><br>
            <div class="g-color-white g-pt-10 g-pb-20">
                <p class="g-color-white g-font-size-18 g-pb-30">이웃과 함께 만드는 커뮤니티 <br> 주변 반려인의 이웃이 되어 주세요 <br> </p>
                <div class="row">
                    <!--<div class="col-4">
                        <a href="${pageContext.request.contextPath}/lostpet/find_write.jsp" class="btn btn-md btn-block btn-outline-light g-mr-10 g-mb-15">글쓰기</a>
                    </div>-->
                    <div class="col-4">
                        <!-- GA 클래스 추가 -->
                        <a href="${pageContext.request.contextPath}/board/controller/BoardWrite.bo"
                            class="btn btn-md btn-block btn-primary g-color-white g-mr-10 g-mb-15 g-brd-0 adopt_application_event">
                            글쓰기
                        </a>
                    </div>
                    
                </div>
            </div>
        </div>
        ::after
    </div>

    <!-- 목록 -->
    <div class="container space-1">
        
        <div class="row" style="display:flex; flex-wrap: wrap;">
        	<c:forEach var="board" items="${list}">
            <div class="col-sm-6 col-md-3 mb-7">
                <div class="card border-0 shadow-soft h-100">
                    <a href="${pageContext.request.contextPath}/board/controller/BoardDetailOk.bo">
                        <div id="img1" class="image-box card-img-top" name="img" style="width:100%;height:220px;">
                           <img class="image-thumbnail" src="${pageContext.request.contextPath}/board/${board.getBimage()}">
                        </div>
                    </a>
                    <div class="card-body p-3">
                        <h2 class="h5 font-weight-bold"><a href="${pageContext.request.contextPath}/board/controller/BoardDetailOk.bo?bnumber=${board.getBnumber()}">${board.getBtitle()}</a></h2>
                        <p class="text-secondary mb-0">
                            이름: ${board.getUnum()} <br>
                            작성시간: ${board.getBdate()}
                        </p>
                    </div>

                </div>
            </div>
            </c:forEach>
        </div>
    </div>


  <jsp:include page="/footer/footer.jsp"/>

</body>


</html>