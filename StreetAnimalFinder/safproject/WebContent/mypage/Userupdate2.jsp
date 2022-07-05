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
  <c:set var="user" value="${user}"/>
  
  
<form action="${pageContext.request.contextPath}/user/controller/UserUpdateOk.us" name="updateForm" method="post">
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
        <span id="modi" class="my-tit">회원정보 수정</span>
    </h2>

    <h3 class="sub-tit">
        <span id="modi" class="my-tit">회원정보를 수정합니다.</span>
    </h3>
    <section class="change-form">
        <div class="modi-row">
            <div class="modi-col">
                <div>
                    <table class="modi-table1">
                        <tbody>
                         <tr class="modi-table-tr">
                                <th class="modi-table-th">
                                    <span class="col1-sp">
                                        아이디
                                    </span>
                                </th>
                                <td class="modi-table-td">
                                    <div class="modi-item">
                                        <input type="text" name="uid" id="modi-id" placeholder="공백없이 4자 이상" class="form-control">
                                        <div class="div_info_maroon">
                                            <span class="setSubTextColor"></span>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            
                            <tr class="modi-table-tr">
                                <th class="modi-table-th">
                                    <span class="col1-sp">이름(닉네임)</span>
                                </th>
                                <td class="modi-table-td">
                                    <div class="modi-item">
                                        <input type="text" name="uname" id="modi-name" maxlength="25" class="form-control" value="${user.getUname()}">
                                        <div class="div_info_maroon">
                                            <span class="setSubTextColor"></span>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <table class="modi-table1">
                        <tbody>
                            
                            <tr class="modi-table-tr">
                                <th class="modi-table-th">
                                    <span class="setThTextColor">휴대전화번호</span>
                                </th>
                                <td class="modi-table-td">
                                    <div class="modi-item">
                                        <div>
                                            <input type="text" name="uphone" maxlength="11" id="mobile1" class="form-control" value="${user.getUphone()}">
                                        </div>
                                        <div>
                                            <span class="setSubTextColor">아이디/비밀번호 찾기 시 필요한 정보 이므로 정확히 입력해주세요.</span><br>
                                            <span class="setSubTextColor">&quot;-&quot;는 생략하고 입력해주세요.</span>
                                        </div>
                                        <div class="div_info_maroon">
                                            <span class="setSubTextColor"></span>
                                        </div>
                                    </div>
                                </td>
                            </tr>

                            <tr class="modi-table-tr">
                                <th class="modi-table-th">
                                    <span class="setThTextColor">이메일</span>
                                </th>
                                <td class="modi-table-td">
                                    <div class="modi-item">
                                        <div class="pos_r">
                                            <script></script>
                                            <div class="emailbox">
                                                <div class="emailbox1">
                                                    <input type="text" name="uemail" maxlength="30" class="form-control" autocapitalize="off" style="ime-mode: inactive;" value="${user.getUemail()}">
                                                </div><br><br>
                                                <span class="setSubTextColor">반드시 이메일 포맷에 맞게 입력해주세요.</span>
                                            </div>
                                        </div>
                                        <div class="div_info_maroon">
                                            <span class="setSubTextColor"></span>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr class="modi-table-tr">
                                <th class="modi-table-th">
                                    <span class="setThTextColor">주소</span>
                                </th>
                                <td class="modi-table-td">
                                    <div class="modi-item"> 
                                        <table cellspacing="0" cellpadding="0">
                                            <tbody>
                                                <tr>
                                                    <td class="td-addr">
                                                        <input type="text" title="직접입력불가" id="join_uaddrpostcode" class="form-control2" name="post-number" readonly="raedonly"> &nbsp;
                                                        <button type="button" class="btn-in-form" onclick="execDaumPostcode(); return false;">우편번호 찾기</button> &nbsp;
                                                        
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="td-addr">
                                                        <input input type="text" title="직접입력불가" id="join_uaddr1" class="form-control3" name="uaddr1" readonly="raedonly" value="${user.getUaddr1()}">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="td-addr">
                                                        <input input type="text" class="form-control3" id="join_uaddr2" name="uaddr2" maxlength="50" style="background-color: #ffffff;" value="${user.getUaddr2()}">
                                                    </td>
                                                </tr>
                                            </tbody>
                                             <script
                                        src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
                                    <script>
                                        //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
                                        function execDaumPostcode() {
                                            new daum.Postcode({
                                                oncomplete: function (data) {
                                                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                                                    // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                                                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                                                    var roadAddr = data.roadAddress; // 도로명 주소 변수
                                                    var extraRoadAddr = ''; // 참고 항목 변수

                                                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                                                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                                                    if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                                                        extraRoadAddr += data.bname;
                                                    }
                                                    // 건물명이 있고, 공동주택일 경우 추가한다.
                                                    if (data.buildingName !== '' && data.apartment === 'Y') {
                                                        extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                                                    }
                                                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                                                    if (extraRoadAddr !== '') {
                                                        extraRoadAddr = ' (' + extraRoadAddr + ')';
                                                    }

                                                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                                                    document.getElementById('join_uaddrpostcode').value = data.zonecode;
                                                    document.getElementById("join_uaddr1").value = roadAddr;

                                                    if (roadAddr !== '') {
                                                        document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                                                    } else {
                                                        document.getElementById("sample4_extraAddress").value = '';
                                                    }


                                                    var guideTextBox = document.getElementById("guide");
                                                    // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                                                    if (data.autoRoadAddress) {
                                                        var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                                                        guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                                                        guideTextBox.style.display = 'block';

                                                    } else if (data.autoJibunAddress) {
                                                        var expJibunAddr = data.autoJibunAddress;
                                                        guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                                                        guideTextBox.style.display = 'block';
                                                    } else {
                                                        guideTextBox.innerHTML = '';
                                                        guideTextBox.style.display = 'none';
                                                    }
                                                }
                                            }).open();
                                        }
                                    </script>
                                        </table>
                                        <div class="div_info_maroon">
                                            <span class="setSubTextColor"></span>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="btn-box">
                    <button type="submit" class="btn">수정완료</button>
                </div>
            </div>
        </div>
    </section>
    </form>
    

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