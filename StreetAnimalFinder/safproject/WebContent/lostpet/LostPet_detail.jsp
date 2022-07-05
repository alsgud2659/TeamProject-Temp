<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lostpet/LostPet.css" type="text/css">
    <script src="https://code.jquery.com/jquery-latest.js"></script>
</head>

<body>


  <jsp:include page="/header/header.jsp"/>
 
<div class="join_container_fluid pa00" style="    padding-right: 15px;
    padding-left: 15px;
    margin-right: auto;
    margin-left: auto;
        height: 30px;
    background: #05a4e8;
    margin-bottom: 20px;
        background-color: #019267 !important;">
            <div>
                <div id="ctl00_topimage" style="/* height:262px; */">
                    <div id="ctl00_topimagediv" class="topimagediv">
                        
                    </div>

                </div>
            </div>
            <div class="join_container_fluid nm_h_underline smbc" id="join_nm_h_underline">
            </div>
        </div>
         <c:set var="lostpet" value="${lostpet}"/>
         <c:set var="files" value="${files}"/>
    <div class="bg-light space-1">
        <div class="container g-mt-30 py-1 ">
            <div class="shadow-sm p-0">
                <h2 id="breadcrumb-title" class="h2 g-font-size-28 font-weight-bold g-line-height-1">실종동물 ${lostpet.getLparea2()}
                                            <span style="color: #019267 !important;">
                        <script>
      if ( '<c:out value="${lostpet.getLpstatus()}"/>' == '1' ) {
        document.write ( '찾아요' );
      } else if ( '<c:out value="${lostpet.getLpstatus()}"/>' == '2' ) {
        document.write ( '봤어요' );
      } </script>
      </span>
</h2>

                <div class="row te py-1">

                    <div class="col-lg-6">
                        <div  id="img" class="js-slide g-bg-cover g-bg-black-opacity-0_1--after slick-slide"
                            style="height: 500px; width:100%;">
                            <!-- <img class="img-fluid w-100" src="/file/getBlob/23490.png" alt="Image Description"> -->
                        </div>




                    </div>

                    <div class="col-lg-6 g-pl-50--lg">


                        <h1 class="h3 g-color-primary font-weight-bold mt-4">
                            <!-- GA 클래스 추가 -->
                            <span class="animal_name">${lostpet.getLparea2()} / ${lostpet.getLpspecies()} (${lostpet.getLpbreed()})</span>
<br>

                    

                        </h1>

                        <hr class="my-5">

                        <ul class="list-unstyled mb-0">
                            <li class="media mb-1">
                                <div class="d-flex w-40 w-sm-30">
                                    <small class="text-muted"> 종/품종 </small>
                                </div>
                                <div class="media-body">
                                    <h3 class="h6"> ${lostpet.getLpspecies()} / ${lostpet.getLpbreed()}</h3>
                                </div>
                            </li>
                            <li class="media mb-1">
                                <div class="d-flex w-40 w-sm-30">
                                    <small class="text-muted"> 성별(중성화) </small>
                                </div>
                                <div class="media-body">
                                    <h3 class="h6">${lostpet.getLpgender()}</h3>
                                </div>
                            </li>
                            <li class="media mb-1">
                                <div class="d-flex w-40 w-sm-30">
                                    <small class="text-muted"> 추정나이 </small>
                                </div>
                                <div class="media-body">


                                    <h3 class="h6">
                                        ${lostpet.getLpage()}
                                    </h3>
                                </div>
                            </li>
                            <li class="media mb-1">
                                <div class="d-flex w-40 w-sm-30">
                                    <small class="text-muted"> 몸무게 </small>
                                </div>
                                <div class="media-body">
                                    <h3 class="h6">모름</h3>
                                </div>
                            </li>
                            <li class="media mb-1">
                                <div class="d-flex w-40 w-sm-30">
                                    <small class="text-muted"> 털색 </small>
                                </div>
                                <div class="media-body">
                                    <h3 class="h6">${lostpet.getLpcolor()}</h3>
                                </div>
                            </li>
                            <li class="media mb-0">
                                <div class="d-flex w-40 w-sm-30">
                                    <small class="text-muted"> 발견 장소 </small>
                                </div>
                                <div class="media-body">
                                    <h3 class="h6 mb-0">${lostpet.getLparea3()}</h3>
                                </div>
                            </li>

                        </ul>

                        <hr class="my-5">



                        <div class="g-mt-10">
                            <!--버튼 -->

                            <button class="btn btn-block btn-primary openBtn" type="button">주인 /
                                발견
                                신고하기</button>
                    <ul class="list-inline mb-0 f-0" style="justify-content: space-around !important;">
                        <li class="list-inline-item float-left">
                            <a href="${pageContext.request.contextPath}/lostpet/controller/LostPetDeleteOk.lo?lpnumber=${lostpet.getLpnumber()}" aria-label="목록">찾았어요</a>
                        </li>
                    </ul>
                        </div>

                    </div>
                </div>

            </div>

            <div class="container te">
                <h2 class="h5 text-dark font-weight-bold mb-3">설명</h2>
                <div class="row shadow-sm">
                    <div class="content te p-0">
                     <!-- 첨부파일 목록 -->
                           <c:choose>
                              <c:when test="${files != null and fn:length(files) > 0}">
                              <c:forEach var="file" items="${files}">
                              <img class="img" src="${pageContext.request.contextPath}/lostpet/images/${file.getFileName()}"
                            style="height: 350px; width: 350px;">
                                 
                                 </a>
                                 <br>
                              </c:forEach>
                             </c:when>
                             <c:otherwise>
                             </c:otherwise>
                           </c:choose>
                        <hr />
                       ${lostpet.getLpcontent()} 
                    </div>

                </div>

            </div>

            <div class="container te">
                <nav class="text-center " aria-label="Page Navigation">
                    <ul class="list-inline mb-0 f-0" style="justify-content: space-around !important;">
                        <li class="list-inline-item float-left">
                            <a href="${pageContext.request.contextPath}/lostpet/controller/LostPetListOk.lo" aria-label="목록">목록</a>
                        </li>
                    </ul>
                </nav>

            </div>




        </div>

    </div>

    <div class="modal hidden">
        <div class="bg"></div>
        <div class="modalBox">
            <div class=" container  space-1  ">
                 <h3>신고 문자 보내기</h3>
                <div class="g-mb-20">
                    <label class="g-mb-20" for="name">보내는 이</label>
                    <input type="text" id="name" name="name" value="스트릿 애니멀 파인더"
                        class="form-control form-control-md rounded-0" readonly>
                </div>
                <form action="" method="get">
                    <div class="g-mb-20">
                        <label class="g-mb-20" for="content">내용</label>
                        <textarea id="content" class="form-control form-control-md rounded-0 "></textarea>
                    </div>
                    <div class="text-right center">
                        <button class="btn btn-primary  rounded-0 closeBtn" type="button">닫기</button>
                        <button class="btn btn-primary  rounded-0" type="reset">초기화</button>
                        <button class="btn btn-primary  rounded-0" type="submit">보내기</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
      <jsp:include page="/footer/footer.jsp"/>
    
</body>
            <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6cf3e9ffc133b6ee746032c7a1b992c7&libraries=services"></script>
               <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6cf3e9ffc133b6ee746032c7a1b992c7"></script>
<script>
console.log('<c:out value="${lostpet.getLparea1()}"/>');
var mapContainer = document.getElementById('img'), // 지도를 표시할 div 
mapOption = {
   center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
   draggable : false,
   level : 3
// 지도의 확대 레벨
};

var map = new kakao.maps.Map(mapContainer, mapOption);
// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();
// 주소로 좌표를 검색합니다
geocoder.addressSearch('<c:out value="${lostpet.getLparea1()}"/>', function(result, status) {
    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {
        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
        var circle = new kakao.maps.Circle({
         center : coords, // 원의 중심좌표 입니다 
         radius : 100, // 미터 단위의 원의 반지름입니다 
         strokeWeight : 5, // 선의 두께입니다 
         strokeColor : '#75B8FA', // 선의 색깔입니다
         strokeOpacity : 1, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
         strokeStyle : 'dashed', // 선의 스타일 입니다
         fillColor : '#CFE7FF', // 채우기 색깔입니다
         fillOpacity : 0.7
      // 채우기 불투명도 입니다   
      });
      
      circle.setMap(map);
        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
}); 



    // 모달 
const open = () => {
        document.querySelector(".modal").classList.remove("hidden");
    }

    const close = () => {
        document.querySelector(".modal").classList.add("hidden");
    }

    document.querySelector(".openBtn").addEventListener("click", open);
    document.querySelector(".closeBtn").addEventListener("click", close);
    document.querySelector(".bg").addEventListener("click", close);
    
    
    function send(){   
          if(!findReplyWriteForm.reply.value){
             alert("댓글을 입력해주세요.");
             return false;
          }
          else return true;
       }
</script>

</html>