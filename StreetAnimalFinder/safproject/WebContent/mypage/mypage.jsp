<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>마이페이지</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/mypage/mypage.css">
</head>

<body>
  <jsp:include page="/header/header.jsp"/>

    <div class="header-wrap">
        <div>
            <div class="topImageSection" style="height:250px;">
                <div class="img_div"> 
                    <img src="https://prodkrsahsitappadminblob.blob.core.windows.net/2019-01-singleimage-production/279d2ded-3e88-4cc5-8e9b-d8638c3b35ee-일시후원2019.png" id="ctl00_topImage" style="min-width:1000px; height:250px; cursor:pointer;" onclick="move2TopImageLink()">
                </div>
                <div class="logo_img">
                    <h1 id="logoImg" class="logo_title">
                        <a href="" style="padding-bottom: 95px; padding-left: 20px; cursor:pointer"><img src="logo.png" class="logo" alt="스트릿애니멀파인더" style="min-height: 60px; max-height:60px;" title="스트릿애니멀파인더"></a>
                    </h1>
                </div>
            </div>
        </div>
        <div class="header_bottom"></div>
    </div>

    <section class="mypage-menu">
        <div>
            <ul class="menu-wrap">
               <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/user/controller/UserUpdateProfile.us">내 프로필 보기</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/user/controller/UserUpdate.us">회원정보 수정</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/mypage/Userupdatepw.jsp">비밀번호 변경</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/mypage/Userdeluser.jsp">회원 탈퇴</a></li>
            </ul>
        </div>
    </section>

    <h2 class="tit">
        <span id="modi" class="my-tit">프로필 수정</span>
    </h2>

    <h3 class="sub-tit">
        <span id="modi" class="my-tit">스애파 프로필과 별명을 수정 하실 수 있습니다.</span>
    </h3>
    
    <section class="change-form">
        <form action="">
            <table class="modi-table1">
                <tbody>
                    <tr class="modi-table-tr">
                        <th class="modi-table-th" scope="row">
                            <span class="col1-sp">
                                프로필 사진
                            </span>
                        </th>
                        <td class="modi-table-td">
                            <div class="modi-item">
                                <div class="photo_box">
                                    <img src="https://static.nid.naver.com/images/web/user/default.png?type=s160" width="100" height="100" id="img_source">
                                    <span class="mask"></span>
                                </div>
                                <div class="btn_area">
                                    <span class="btn_file">
                                        <label for="inputImage" class="btn-in-form">사진변경</label>
                                        <input type="file" id="inputImage" name="profileImage" accept="image/*" style="display:none">
                                    </span>
                                    <a href="#" class="btn-in-form" style="margin-left: 8px; text-decoration: none;">삭제</a>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr class="modi-table-tr">
                        <th class="modi-table-th">
                            <span class="col1-sp">별명</span>
                        </th>
                        <td class="modi-table-td">
                            <div class="modi-item">
                                <input type="text" class="form-control" name="nickname" id="inputNick"> &nbsp;
                                12글자까지 입력할 수 있습니다.
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>

            <div style="vertical-align: bottom; text-align: center; padding-bottom:10px">
                <input type="submit" name="leave_btn" id="leave_btn" value="적용" class="btn-custom">
                <input type="submit" name="cancel_btn" id="leave_cancel_btn" value="취소" class="btn-custom" style="background-color: #ffffff; color:black">
            </div>
        </form>
    </section>

    

    <div class="footer-wrap">
        <div class="footer">
            <div class="footer_link">
                <span class="footer_btn">
                    <a href="#">로그아웃</a> &nbsp;&nbsp;
                    <b>|</b> &nbsp;&nbsp;
                </span>
                <span class="footer_btn">
                    <a style="cursor:pointer;" href="#">개인정보 처리방침</a>
                </span>
            </div>
            <div class="footer_container">
                <div class="footer_div">
                    <a href="#" style="cursor: pointer;"><img src="https://prodkrsahsitappadminblob.blob.core.windows.net/2019-02-singleimage-production/60d8b13b-edb6-4734-bd54-4a36fe355762-푸터_카라.gif" class="footer_img" style="cursor:default; max-width:100%;min-width:1000px"></a>
                </div>
            </div>
            <div>
                
            </div>
        </div>
    </div>
      <jsp:include page="/footer/footer.jsp"/>
    
</body>

</html>