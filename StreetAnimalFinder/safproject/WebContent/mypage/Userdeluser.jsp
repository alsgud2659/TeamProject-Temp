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
            <div class="topImageSection" style="height: 250px;">
                <div class="img_div">
                    <img src="https://prodkrsahsitappadminblob.blob.core.windows.net/2019-01-singleimage-production/279d2ded-3e88-4cc5-8e9b-d8638c3b35ee-일시후원2019.png" id="ctl00_topImage" style="min-width:1000px;height:250px;cursor:pointer;" onclick="move2TopImageLink()">
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
        <span id="modi" class="my-tit">회원 탈퇴</span>
    </h2>

    <h3 class="sub-tit">
        <span id="modi" class="my-tit">회원탈퇴를 합니다.</span>
    </h3>
    
    <section class="change-form">
        <form action="${pageContext.request.contextPath}/user/controller/UserDelUserOK.us">
            <table class="modi-table1">
                <tbody>
                    <tr class="modi-table-tr">
                        <th class="modi-table-th">
                            <span class="col1-sp">
                                회원탈퇴 사유
                            </span>
                        </th>
                        <td class="modi-table-td">
                            <div class="modi-item">
                                <table class="exit_reason">
                                    <tbody>
                                        <tr>
                                            <td>
                                                <input type="radio" checked="checked" id="leave_code0" class="leave_code" value="1000">
                                                <label for="leave_code0">운영 불만</label>
                                            </td>
                                            <td>
                                                <input type="radio" id="leave_code1" class="leave_code" value="1001">
                                                <label for="leave_code1">이유 없음</label>
                                            </td>
                                            <td>
                                                <input type="radio" id="leave_code2" class="leave_code" value="1002">
                                                <label for="leave_code2">기타</label>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </td>
                    </tr>
                    <tr class="modi-table-tr">
                        <th class="modi-table-th">
                            <span class="col1-sp">남기실 말씀</span>
                        </th>
                        <td class="modi-table-td">
                            <div class="modi-item">
                                <textarea name="leave_comment" id="leave_comment" cols="20" rows="2" class="text_control" style="height: 60px; resize:vertical"></textarea>
                                <span style="text-align: right;">100자 이내로 입력하세요.</span>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
            
            <span class="bottom_text">
                <div class="bt_div">
                    <span class="info_text">
                        탈퇴를 요청하는 즉시 탈퇴처리가 진행됩니다.
                        <br>
                        작성했던 작성글 및 댓글도 함께 삭제됩니다.
                    </span>
                </div>
            </span>

            <div class="btn-box">
                <input type="submit" name="leave_btn" id="leave_btn" value="탈퇴요청" class="btn-custom">
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