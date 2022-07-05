<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/lostpet/LostPet.css"
   type="text/css">

<script src="https://code.jquery.com/jquery-latest.js"></script>

</head>

<jsp:include page="/header/header.jsp" />
<body class="lostpet">

   <c:set var="list" value="${lostpetList}" />

   <div id="headers"></div>
   <script>
/*    window.onload = function() {
      const arr = [[],[]];
      };
 */
   </script>
   <div
      class="dzsparallaxer auto-init height-is-based-on-content use-loading mode-scroll loaded dzsprx-readyall g-bg-cover"
      data-options="{direction: &quot;reverse&quot;, animation_duration: 25, direction: &quot;reverse&quot;}">
      <div
         class="divimage dzsparallaxer--target w-100 u-bg-overlay g-bg-img-hero g-bg-black-opacity-0_3--after"
         style="height: 130%; background-image: url(${pageContext.request.contextPath}/file/getBlob/130690_90612_406.jpg); transform: translate3d(0px, -90px, 0px);">
         ::before ::after</div>
      <!--글쓰기 버튼-->
      <div class="container u-bg-overlay__inner g-py-100">
         <h2 class="g-color-white g-font-size-24 g-font-weight-600">길거리의
            동물찾기</h2>
         <div class="g-color-white g-pt-10 g-pb-20">
            <p class="g-color-white g-font-size-18 g-pb-30">
               길거리를 돌아다니는 동물들. <br> 그들은 어쩌면 가족을 잃은 것일지도 모릅니다. <br> 당신의
               도움의 손길이, 그들에게 가족을 되찾아줄 수 있을지도 모릅니다.
            </p>
            <div class="row">
               <!-- <div class="col-4">
                        <a href="${pageContext.request.contextPath}/lostpet/find_write.jsp"
                            class="btn btn-md btn-block btn-outline-light g-mr-10 g-mb-15">임시 보호
                            등록</a>
                    </div> -->
               <div class="col-4">
                  <!-- GA 클래스 추가 -->
                  <a
                     href="${pageContext.request.contextPath}/lostpet/controller/LostPetWrite.lo"
                     class="btn btn-md btn-block btn-primary g-color-white g-mr-10 g-mb-15 g-brd-0 adopt_application_event">
                     내 동물 찾기 <i class="material-icons g-font-size-16">글쓰기</i>
                  </a>
               </div>
            </div>
         </div>
      </div>
      ::after
   </div>

   <!-- 목록 -->
   <div class="container space-1">

      <div class="row">


<c:forEach var="lostpet" items="${lostpetList}">
            <div class="col-sm-6 col-md-3 mb-7">
                <div class="card border-0 shadow-soft h-100">
                   <a href="${pageContext.request.contextPath}/lostpet/controller/LostPetDetailOk.lo?lpnumber=${lostpet.getLpnumber()}">
                        <div id="img${lostpet.getLpnumber()}" class="image-box card-img-top" name="img" style="width:100%;height:220px;">
                        </div>
                    </a>
                    <div class="card-body p-3">
                        <h2 class="h5 font-weight-bold">
                        <a href="${pageContext.request.contextPath}/lostpet/controller/LostPetDetailOk.lo?lpnumber=${lostpet.getLpnumber()}">
                       ${lostpet.getLpspecies()} / ${lostpet.getLparea2()} 
                       <span style="color: #019267 !important; font-size:1rem !important;">
                        <script>
      if ( '<c:out value="${lostpet.getLpstatus()}"/>' == '1' ) {
        document.write ( '찾아요' );
      } else if ( '<c:out value="${lostpet.getLpstatus()}"/>' == '2' ) {
        document.write ( '봤어요' );
      } </script>
      </span>
                        </a></h2>
                                                
                        <p class="text-secondary mb-0">
                           ${lostpet.getLpspecies()}(${lostpet.getLpbreed()})<br>
                           ${lostpet.getLpgender()} 추정<br>
                      ${lostpet.getLpage()} <br>
                      ${lostpet.getLpcolor()}<br>
                        </p>

                    </div>

                </div>
            </div>
            
            <script>
/*             arr[Number('<c:out value="${lostpet.getLpnumber()}"/>')][1] = '<c:out value="${lostpet.getLparea1()}"/>';
            console.log("넘버 테스트", arr); */

            </script>


            </c:forEach>
      </div>
   </div>
   
   


   <div id="footer"></div>
   <jsp:include page="/footer/footer.jsp" />




<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6cf3e9ffc133b6ee746032c7a1b992c7&libraries=services"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6cf3e9ffc133b6ee746032c7a1b992c7"></script>
<script>
var li_num = new Array();
var li_area = new Array();
var li_count = new Array();
var count = 0;
<c:forEach var="lostpet" items="${lostpetList}">
li_count.push(count);
count += 1;

li_num.push(Number('<c:out value="${lostpet.getLpnumber()}"/>'));
li_area.push('<c:out value="${lostpet.getLparea1()}"/>');
</c:forEach>
console.log("li_num",li_num);
console.log("li_area",li_area);
console.log("li_count",li_count);
/* 카카오맵 */

$.each(li_count, function(index, count){
   console.log("인덱스 잘 나오나? ", count);



   var id_name = 'img'+li_num[count];
   console.log("카운트는 ",count," id_name은 ", id_name);
   
var mapContainer = document.getElementById(id_name), // 지도를 표시할 div 
mapOption = {
   center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
   draggable : false,
   level : 3
// 지도의 확대 레벨
};

//지도를 생성합니다   
var map = new kakao.maps.Map(mapContainer, mapOption);
// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
    console.log("주소는 ", li_area[count]);
geocoder.addressSearch(li_area[count], function(result, status) {
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




});
</script>



</body>



</html>