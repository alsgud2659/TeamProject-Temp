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
        <span id="modi" class="my-tit">비밀번호 변경</span>
    </h2>

    <h3 class="sub-tit">
        <span id="modi" class="my-tit">비밀번호를 변경합니다.</span>
    </h3>

    <section class="change-form">
        <form name="UpdatePW" action="${pageContext.request.contextPath}/user/controller/UserUpdatePwOK.us" onsubmit="return checkAll()">
            <table class="modi-table1">
                <tbody>
                    
                    <tr class="modi-table-tr">
                        <th class="modi-table-th">
                            <span class="col1-sp">새 비밀번호</span>
                        </th>
                        <td class="modi-table-td">
                            <div class="modi-item">
                                <input type="password" name="upw" id="modi-name" maxlength="25" class="form-control">
                                <div class="div_info_maroon">
                                    <span class="setSubTextColor"></span>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr class="modi-table-tr">
                        <th class="modi-table-th">
                            <span class="col1-sp">새 비밀번호 확인</span>
                        </th>
                        <td class="modi-table-td">
                            <div class="modi-item">
                                <input type="password" name="upwcheck" id="modi-name" maxlength="25" class="form-control">
                                <div class="div_info_maroon">
                                    <span class="setSubTextColor"></span>
                                </div>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
            <div>
                <span>
                    <ul>
                        <li>
                            영문 대문자, 소문자, 숫자를  사용하여 8 ~ 20자로 정해주셔야 합니다.
                        </li>
                        <li>
                            쉬운 비밀번호나 자주 쓰는 사이트의 비밀번호가 같을 경우, 도용되기 쉬우므로 주기적으로 변경하셔서 사용하는 것이 좋습니다.
                        </li>
                        <li>
                            아이디와 주민등록번호, 생일, 전화번호 등 개인정보와 관련된 숫자, 연속된 숫자, 반복된 문자 등 다른 사람이 쉽게 알아 낼 수 있는 비밀번호는 개인정보 유출의
                            위험이 높으므로 사용하지 않도록 주의부탁드립니다.
                        </li>
                    </ul>
                    <br>
                    <br>
                </span>
            </div>

            <div style="vertical-align: bottom; text-align: center; padding-bottom:10px">
                <input type="submit" name="" id="" value="확인" class="btn-custom">
                
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
    
    <script language="javascript">
                                        function checkAll() {
                                           
                                            if (!checkPassword(UpdatePW.upw.value,    UpdatePW.upwcheck.value)) {
                                                return false;
                                            }
                                            

                                            return true;
                                        }
                                     
                                        // 공백확인 함수
                                        function checkExistData(value, dataName) {
                                            if (value == "") {
                                                alert(dataName + " 입력해주세요!");
                                                return false;
                                            }
                                            return true;
                                        }
                                     
                                       
                                     
                                        function checkPassword(upw, upwcheck) {
                                            //비밀번호가 입력되었는지 확인하기
                                            if (!checkExistData(upw, "비밀번호를"))
                                                return false;
                                            //비밀번호 확인이 입력되었는지 확인하기
                                            if (!checkExistData(upwcheck, "비밀번호 확인을"))
                                                return false;
                                     
                                            var password1RegExp = /^[a-zA-z0-9]{8,20}$/; //비밀번호 유효성 검사
                                            if (!password1RegExp.test(upw)) {
                                                alert("비밀번호는 영문 대소문자와 숫자 8~20자리로 입력해야합니다!");
                                                UpdatePW.upw.value = "";
                                                UpdatePW.upwcheck.focus();
                                                return false;
                                            }
                                            //비밀번호와 비밀번호 확인이 맞지 않다면..
                                            if (upw != upwcheck) {
                                                alert("두 비밀번호가 맞지 않습니다.");
                                                UpdatePW.upw.value = "";
                                                UpdatePW.upwcheck.value = "";
                                                UpdatePW.upwcheck.focus();
                                                return false;
                                            }
  
                                            return true; //확인이 완료되었을 때
                                        }
                                     
                                        
                           
                                    </script>
    
      <jsp:include page="/footer/footer.jsp"/>
    
</body>

</html>