<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/header/header.css">
    <title>main</title>
  </head>
  <body>
    <header
      id=""
      class="u-header u-header__sticky-top u-header--toggle-section u-header--change-appearance"
      style="margin-top: 0px"
    >
      <!-- PC 탑바 레이아웃 1-1 -->
      <div
        class="u-header__section u-header__section--hidden u-header__section--dark g-bg-white g-transition-0_3 g-pt-10--sm g-pb-0"
      >
        <div class="g-hidden-xs-down">
            <!-- 탑바 레이아웃 3 -->
          <div class="container">
            <div class="row-head flex-md-row justyfy-content-between">
 
              <!-- 탑바 right 5-2 -->
              <div class="col-auto g-pos-rel g-px-15">
                <ul class="ul list-inline g-mt-minus-10">
                  <li class="list-inline-item"><a class="g-color-topbar" href="${pageContext.request.contextPath}/login/login.jsp">로그인</a></li>
                  <li class="list-inline-item g-color-topbar">|</li>
                  <li class="list-inline-item"><a class="g-color-topbar" href="${pageContext.request.contextPath}/join/join.jsp">회원가입</a></li>
                  <li class="list-inline-item g-color-topbar">|</li>
                  <li class="list-inline-item"><a class="g-color-topbar" href="${pageContext.request.contextPath}/user/controller/UserUpdate.us">마이페이지</a></li>
                </ul>

              </div>
            </div>
          </div>
        </div>
      </div>

      <!-- 모바일 -->
      <div></div>

      <!-- 헤더 local nav bar -->
      <!-- 로고 -->
      <div class="container container-header header justyfy-content-between">
      <div class="header-logo">
        <a href="${pageContext.request.contextPath}/mainpage/main.jsp"><img src="${pageContext.request.contextPath}/header/logo.svg" style="width: 240px; height: 60px;" alt="" class="logo"></a>
      </div>
      <!-- 목차 -->
      <div class="header-menu mouseover" data-animaion-in="fadeIn" data-animation-out="fadeOut">
        <ul class="ul mouseover">
          <li class="list-inline-header">
            <a href=""style="text-decoration:none; ">소개</a>
          </li>
          <li class="list-inline-header">
            <a href="${pageContext.request.contextPath}/lostpet/controller/LostPetListOk.lo"style="text-decoration:none; ">실종동물찾기</a>
<%--             <ul class="showmenu list-drop">
              <li class="hide-list"><a  class="drop-a"href="${pageContext.request.contextPath}/lostpet/find_write.jsp">동물 등록하기</a></li>
              <li class="hide-list"><a  class="drop-a"href="${pageContext.request.contextPath}/lostpet/LostPet.jsp">동물 / 주인 찾기</a></li>
            </ul> --%>
          </li>
          <li class="list-inline-header">
            <a href="${pageContext.request.contextPath}/faq/faq.jsp"style="text-decoration:none; ">전문가FAQ</a>
          </li>
          <li class="list-inline-header">
            <a href="${pageContext.request.contextPath}/board/controller/BoardListOk.bo"style="text-decoration:none; ">커뮤니티</a>
<%--             <ul class="showmenu list-drop">
              <li class="hide-list"><a  class="drop-a"href="${pageContext.request.contextPath}/board/new-list.jsp">소통해요</a></li>
              <li class="hide-list"><a  class="drop-a"href="${pageContext.request.contextPath}/board/new-list.jsp">내 반려동물 자랑</a></li>
            </ul> --%>
          </li>
        </ul>
        </div>
      </div>
<!--     <div class="lnb-bg showmenu"> -->
    </div>
    

</header>


    <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript">
      $(window).load(function(){
          $(function() {
              $('.showmenu').hide();
              $('.mouseover').hover(function() {
                  $('.showmenu').slideDown();
              }
            //  , function() {
            //    $('.showmenu').slideUp();
           // }
              );
           });
      });
      </script>
      
      <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

  
  
  </body>
</html>
