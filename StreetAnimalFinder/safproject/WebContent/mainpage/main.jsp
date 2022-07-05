<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>스트릿애니멀파인더</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='${pageContext.request.contextPath}/mainpage/main.css'>
    <script src='${pageContext.request.contextPath}/mainpage/main.js'></script>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
 
</head>
<body>
  <jsp:include page="/header/header.jsp"/>
	<section class="main_banner"> 
        <div class="back_div" style="height: 400px; background-color: #019267;">
            <div class="swiper-slide" style="background-color: #019267;"></div>
        </div>
        <div class="con_div">
            <div class="con_row" style="margin-top: -350px;">
                <div class="con_col1">
                        <div class="mySlides fade">
                            <img src="sb.jpg" alt="" class="img_fluid">
                        </div>
                        <div class="mySlides fade">
                            <img src="sb_1.jpg" alt="" class="img_fluid">
                        </div>
                        <div class="mySlides fade">
                            <div class="numbertext">1 / 3</div>
                            <img src="sb_2.jpg" alt="" class="img_fluid">
                        </div>
                        <div class="mySlides fade">
                            <img src="sb_3.jpg" alt="" class="img_fluid">
                        </div>
                        <div style="text-align:center">
                            <span class="dot"></span>
                            <span class="dot"></span>
                            <span class="dot"></span>
                            <span class="dot"></span>
                          </div>
                </div>
                <div class="con_col2">
                    <div class="col2_item" style="padding-top: 20px;">
                        <a href="#">
                            <span class="ci_tit">
                                우리가 함께 찾은 동물들 : 124,212 마리
                            </span>
                            <br>
                            <br>
                            <span class="ci_con">
                                스트릿애니멀파인더는 길잃은 반려동물을 조금이라도 빨리 찾아낼 수 있도록 도움을 드립니다.
                            </span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section class="find_animal">
        <div class="find_btn">
            <div class="find_text">
                <span class="f_text" style="padding-top: 40px; border: 2px solid;">
                    <a href="${pageContext.request.contextPath}/lostpet/LostPet.jsp" style="padding-top: 37px; color: #019267; text-decoration: none;">실종동물찾기</a>
                </span>
            </div>
        </div>
        <div class="find_desc" style="background-color: #00C879;">
            <div class="desc_row">
                <div class="desc_col">
                    <a href="${pageContext.request.contextPath}/lostpet/LostPet.jsp">
                        <span class="col_text" style="font-size: 15px;">
                            스트릿애니멀파인더는 여러분의 슬기로운 반려동물과의 생활을 응원합니다~<br/> 
                            잃어버린 반려동물을 찾아야 한다면 스트릿애니멀파인더와 함께!
                        </span>
                    </a>
                </div>
            </div>
        </div>
    </section>

    <section class="saf_activity">
        <p>스애파의 주요 활동</p>
        <div class="nav">
            <ul class="nav-bar">
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <img src="icon_5.png" style="width: 62px"><br />
                        <span class="g-font-size-12">전체보기</span>
                    </a>
                </li>
    
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/lostpet/LostPet.jsp">
                        <img src="icon_2.png" style="width: 62px"><br />
                        <span class="g-font-size-12">실종동물 찾기</span>
                    </a>
                </li>
    
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/board/new-list.jsp">
                        <img src="icon_3.png" style="width: 62px"><br />
                        <span class="g-font-size-12">커뮤니티</span>
                    </a>
                </li>
    
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/faq/faq.jsp" style="border-right: solid 1px transparent!important;">
                        <img src="icon_1.png" style="width: 62px"><br />
                        <span class="g-font-size-12">전문가FAQ</span>
                    </a>
                </li>
            </ul>
        </div>
    </section>
	

     <section class="make_change" style="background-color: #FDFFA9;">
        <div class="ch_tit">
            <p>현재 애타게 찾고있는 동물들</p>
            <div class="row">
                <div class="col">
                    <div class="info">
                        <a href="#">
                            <span class="block0">녹두</span>
                            <span class="block1">개(진도)</span>
                            <span class="block2">
                                암컷 (중성화) <br>
                                6살 6개월 / 25.0kg / 화이트
                            </span>
                        </a>
                    </div>
                    <a href="" class="img_a">
                        <div class="img-container">
                            <img src="nokdu.png" alt="" style="width: 350px; height: 400px;">
                        </div>
                    </a>
                </div>
                <div class="col">
                    <div class="info">
                        <a href="#">
                            <span class="block0">또자</span>
                            <span class="block1">개(믹스)</span>
                            <span class="block2">
                                암컷(중성화X) <br>
                                5개월 / 5.5kg / 화이트
                            </span>
                        </a>
                    </div>
                    <a href="" class="img_a">
                        <div class="img-container">
                            <img src="ddoja.jfif" alt="" style="width: 350px; height: 400px;">
                        </div>
                    </a>

                    
                </div>
                <div class="col">
                    <div class="info">
                        <a href="#">
                            <span class="block0">미일</span>
                            <span class="block1">개(진도)</span>
                            <span class="block2">
                                암컷(중성화 O) <br>
                                6살 6개월 / 20.0kg / 화이트
                            </span>
                        </a>
                    </div>
                    <a href="" class="img_a">
                        <div class="img-container">
                            <img src="meil.png" alt="" style="width: 350px; height: 400px;">
                        </div>
                    </a>
                    
                </div>
            </div>
        </div>

        <div class="subs_container">
            <a href="${pageContext.request.contextPath}/lostpet/LostPet.jsp" class="subs_btn" style="background-color: #6AAAE4;">실종동물 더 찾아보기</a>
        </div>
    </section>
    <div id="footer"></div>


    
    <script>
        var slideIndex = 0;
        showSlides();
    
        function showSlides() {
            var i;
            var slides = document.getElementsByClassName("mySlides");
            var dots = document.getElementsByClassName("dot");
            for (i = 0; i < slides.length; i++) {
                slides[i].style.display = "none";
            }
            slideIndex++;
            if (slideIndex > slides.length) { slideIndex = 1 }
            for (i = 0; i < dots.length; i++) {
                dots[i].className = dots[i].className.replace(" active", "");
            }
            slides[slideIndex - 1].style.display = "block";
            dots[slideIndex - 1].className += " active";
            setTimeout(showSlides, 2000); // Change image every 2 seconds
        }

    </script>
      <jsp:include page="/footer/footer.jsp"/>
    
</body>
</html>