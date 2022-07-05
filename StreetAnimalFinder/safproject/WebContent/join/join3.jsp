<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/join/join.css">

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta content="no-cache" http-equiv="Pragma">
    <meta content="no-cache" http-equiv="Cache-Control">
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
    <meta content="no" http-equiv="Imagetoolbar">
    <meta content="text/css" http-equiv="Content-Style-Type">
    <meta content="text/javascript" http-equiv="Content-Script-Type">
    <style type="text/css">
        @font-face {
            font-family: custom-font;
            src: url('https://mrmweb-cdn.hsit.co.kr/v2/dist/210308.1/inc/fonts/NanumBarunGothic.eot') format('embedded-opentype'),
                url('https://mrmweb-cdn.hsit.co.kr/v2/dist/210308.1/inc/fonts/NanumBarunGothic.woff') format('woff'),
                url('https://mrmweb-cdn.hsit.co.kr/v2/dist/210308.1/inc/fonts/NanumBarunGothic.ttf') format('truetype');
        }
    </style>
    <link href="https://mrmweb-cdn.hsit.co.kr/v2/dist/210308.1/inc/lib/bootstrap-3.3.7/css/bootstrap.min.css"
        rel="stylesheet">
    <link href="https://mrmweb-cdn.hsit.co.kr/v2/dist/210308.1/inc/lib/bootstrap-3.3.7/css/bootstrap-theme.min.css"
        rel="stylesheet">
    <link href="https://mrmweb-cdn.hsit.co.kr/v2/dist/210308.1/inc/lib/jquery-confirm-3.2.0/jquery-confirm.min.css"
        rel="stylesheet">
    <link href="https://mrmweb-cdn.hsit.co.kr/v2/dist/210308.1/inc/lib/icheck-1.0.2/skins/all.css" rel="stylesheet">

    <style id="ctl00_setStyleBox">
        .setDefaultTextColor {
            color: #555555 !important;
        }

        .setSubTextColor {
            color: #999999 !important;
            font-size: 13px !important;
        }

        .setHighlightTextColor {
            color: #004ba0 !important;
        }

        .form-control {
            color: #555555 !important;
        }

        .setEssentialTextColor {
            color: #ff9216 !important;
            font-size: inherit !important;
        }

        .setThTextColor {
            color: #555555 !important;
            font-size: inherit !important;
        }

        .setQTextColor {
            color: #aaaaaa !important;
            font-size: inherit !important;
        }

        .setSelectedLeftMenuColor {
            color: #004ba0 !important;
        }

        .setMainBackgroundColor {
            background-color: #004ba0 !important;
        }

        .setMainBackgroundColorOn.on {
            background-color: #004ba0 !important;
        }

        .setQBackground {
            background-color: #ffffff !important;
        }

        .setThBackgroundColor {
            background-color: #f7f7f7 !important;
        }

        .setInfoTextBgColor {
            background-color: #ffffff !important;
        }

        .setDLinkTextBgColor {
            background-color: #ffffff !important;
        }

        .setMainBorderTop1 {
            border-top: 1px solid #004ba0 !important;
        }

        .setMainBorderLeft1 {
            border-left: 1px solid #004ba0 !important;
        }

        .setMainBorderRight1 {
            border-right: 1px solid #004ba0 !important;
        }

        .setMainBorderBottom1 {
            border-bottom: 1px solid #004ba0 !important;
        }

        .setMainBorder1 {
            border: 1px solid#004ba0 !important;
        }

        .setMainBorder1On.on {
            border: 1px solid #004ba0 !important;
        }

        .setQBorderBottom {
            border-bottom: 1px dotted #eeeeee !important;
        }

        .setQBorderBottom:last-child {
            border-bottom: 0px !important;
        }

        .setQBorder {
            border: 1px solid #efefef !important;
        }

        .setThBorderBottom {
            border-bottom: 1px solid #eeeeee !important;
        }

        .setStepBoxBorderTopOn {
            border-top: 1px solid #dddddd !important;
        }

        .setStepBoxBorderRight {
            border-right: 1px solid #dddddd !important;
        }

        .setStepBoxBorderBottom {
            border-bottom: 1px solid #dddddd !important;
        }

        .setStepBoxBorderLeft {
            border-left: 1px solid #dddddd !important;
        }

        .setMainBorderTop2 {
            border-top: 2px solid #004ba0 !important;
        }

        .setMainBorderLeft2 {
            border-left: 2px solid #004ba0 !important;
        }

        .setMainBorderRight2 {
            border-right: 2px solid #004ba0 !important;
        }

        .setMainBorderBottom2 {
            border-bottom: 2px solid #004ba0 !important;
        }

        .setMainBorder2 {
            border: 2px solid #004ba0 !important;
        }

        .setMainBorder2On.on {
            border: 2px solid #004ba0 !important;
        }

        .btn-custom {
            color: #ffffff !important;
            background: #004ba0 !important;
            border: 1px solid #004ba0 !important;
        }

        .btn-custom:hover,
        .btn-custom:focus {
            color: #ffffff !important;
            background: #004ba0 !important;
            border: 1px solid #004ba0 !important;
            opacity: 0.9
        }

        .btn-custom>span {
            color: #ffffff !important;
        }

        a.btn-custom {
            color: #ffffff !important;
            background: #004ba0 !important;
            border: 1px solid #004ba0 !important;
        }

        a.btn-custom:hover,
        .btn-custom:focus {
            color: #ffffff !important;
            background: #004ba0 !important;
            border: 1px solid #004ba0 !important;
            opacity: 0.9
        }

        a.btn-custom>span {
            color: #ffffff !important;
        }

        input[type='checkbox']:checked+label:before {
            color: #ffffff !important;
            background: #004ba0 !important;
            border-color: #004ba0 !important;
        }

        input[type='radio']:checked+label:before {
            color: #ffffff !important;
            background: #004ba0 !important;
            border-color: #004ba0 !important;
        }

        .roundRdo>input[type='radio']:checked+label:before {
            color: #004ba0 !important;
            background: #ffffff !important;
            border-color: #cacece !important;
        }

        body,
        div,
        span,
        p,
        h1,
        h2,
        h3,
        h4,
        h5,
        input,
        textarea,
        select,
        section,
        article,
        nav,
        i,
        ul,
        li,
        table,
        td,
        th,
        a,
        fieldset,
        label,
        legend,
        pre,
        body:hover,
        a:hover,
        a:focus {
            color: #555555;
        }
    </style>

    <title>스애파 회원가입</title>
</head>

<body>

  <jsp:include page="/header/header.jsp"/>

    <form name="join" method="post" id="join_form_id" onsubmit="return checkAll()" action="${pageContext.request.contextPath}/user/controller/UserJoinOk.us">
        <div class="join_container_fluid pa00">
            <div>
                <div id="ctl00_topimage" style="height:262px;">
                    <div id="ctl00_topimagediv" class="topimagediv">
                        <img src="../logo.svg" id="ctl00_topimage" style="min-width:1000px;height:262px;cursor:pointer;">
                    </div>

                </div>
            </div>
            <div class="join_container_fluid nm_h_underline smbc" id="join_nm_h_underline">
            </div>
        </div>

        <div class="join_container_fliud pa00" id="join_contentbody">
            <div class="join_container join_static_width por_r">
                <div id="join_l_image" class="join_l_img_div" style="top: 92.1979px; display: block;"></div>
                <div id="join_r_image" class="join_r_img_div" style="top: 92.1979px; display: block;"></div>
                <h2 class="join_title">
                    <span id="ctl00_title_textwd003" class="inherit_font">회원가입</span>
                </h2>
                <div class="join_form_con mb05"></div>
                <div class="join_form_main" id="form_main" style="display: block;">


                    <div class="row join_form_row">
                        <div class="col-sm-10">
                            <div id="ct100_holder_basicinfo">
                                <table class="join_table">
                                    <!--아이디-->
                                    <tr class="join_table_tr" id="tr_join_id">
                                        <th class="join_col_1_th stbc stbb sttc" id="th_join_id">
                                            <span id="join_placeholder_id" class="sttc">아이디</span>
                                        </th>
                                        <td class="join_col_2_td stbb">
                                            <div class="join_item">
                                                <input name="uid" type="text" maxlength="30" id="join_id"
                                                    class="join_form_control dlb wid200" placeholder="공백,특수문자 없이 4~12자"
                                                    style="ime-mode: disabled">
                                                <button id="checkIdBtn" type="button" class="btn btn-default">아이디 중복 확인</button>&nbsp;
                                                <span id="CheckID"></span>
                                                <div class="div_info_maroon sstc">
                                                    <span id="join_id_info" class="sstc helptext"></span>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>


                                    <!--비번-->
                                    <tr class="join_table_tr">
                                        <th class="join_col_1_th stbc stbb sttc">
                                            비밀번호
                                        </th>
                                        <td class="join_col_2_td  stbb">
                                            <div class="join_item">
                                                <input name="upw" type="password" maxlength="20" id="join_pw"
                                                    class="join_form_control dlb wid200"
                                                   
                                                    value>
                                                <div>
                                                    <span id="join_pw_validatepass">
                                                        <span class="join_text_color_2">
                                                             - 비밀번호는 영문 대소문자와 숫자 8~20자리로 입력해야합니다!
                                                            <br>
                                                             

                                                        </span>
                                                    </span>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <!--비번 확인-->
                                    <tr class="join_table_tr">
                                        <th class="join_col_1_th stbc stbb sttc">
                                            비밀번호 확인
                                        </th>
                                        <td class="join_col_2_td  stbb">
                                            <div class="join_item">
                                                <input name="upwcheck" type="password" maxlength="20" id="join_pw_check"
                                                    class="join_form_control dlb wid200"
                                                    
                                                    value="" />
                                                &nbsp;&nbsp;<span id="join_check_pass"><span
                                                        class='join_text_color_2'>확인을
                                                        위해 한 번 더
                                                        입력하세요.</span></span>
                                            </div>
                                        </td>

                                    </tr>


                            </div>
                            <!-- 이름 -->
                            <tr class="join_table_tr">
                                <th class="join_col_1_th stbc stbb sttc">
                                    <span id="join_name" class="join_text_color_1">이름</span>
                                </th>
                                <td class="join_col_2_td  stbb">
                                    <div class="join_item">
                                        <input name="uname" type="text" maxlength="25" id="join_uname"
                                            class="join_form_control dlb wid200">

                                        <div class="div_info_maroon sstc">
                                            <span id="join_name_info" class="sstc helptext"></span>
                                        </div>
                                    </div>
                                </td>
                            </tr>


                            </table>

                            <table class="join_table bt0">
                                <tbody>
                                   
                                    <tr class="join_table_tr" id="join_phone">
                                        <th class="join_col_1_th stbc stbb sttc">
                                            <span id="join_holder_phone" class="join_th_text">휴대전화번호</span>
                                        </th>
                                        <td class="join_col_2_td  stbb">
                                            <div class="join_item">
                                                <div>
                                                    <input name="uphone" type="text" maxlength="11" id="join_uphone1"
                                                        class="join_form_control dlb wid200"
                                                        placeholder="'-'를 제외하고 입력해주세요"
                                                        />
                                                    &nbsp;&nbsp;
                                                </div>

                                                <div style="clear: both; margin-top: 3px; margin-bottom: 3px;"><span
                                                        id="join_phone_text" class="sstc helptext">스트릿애니멀파인더 이용시 필요한
                                                        정보이므로 정확히
                                                        입력하세요.</span>
                                                </div>

                                                <div class="div_info_maroon sstc">
                                                    <span id="join_phone_info" class="sstc helptext"></span>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr class="join_table_tr" id="join_email">
                                        <th class="join_col_1_th stbc stbb sttc">
                                            <span id="join_holder_email" class="join_th_text">이메일</span>
                                        </th>
                                        <td class="join_col_2_td  stbb">
                                            <div class="join_item">
                                                <div class="join_email_box">
                                                    <div class="join_email_box1">
                                                        <input name="uemail" type="text" maxlength="30"
                                                            id="join_uemail_1" class="join_form_control wid300"
                                                            autocapitalize="off"
                                                            style="ime-mode:inactive" />

                                                    </div>


                                                </div>
                                                <div class="div_info_maroon sstc" style="clear: both; ">
                                                    <span id="join_holder_email_info" class="sstc helptext"></span>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>

                                    <tr class="join_table_tr" id="join_address">
                                        <th class="join_col_1_th stbc stbb sttc">
                                            <span id="join_holder_address" class="join_th_text">주소</span>&nbsp;
                                        </th>
                                        <td class="join_col_2_td  stbb">
                                            <div class="join_item pos_r">
                                                <table cellspacing="0" cellpadding="0">
                                                    <tbody>
                                                        <tr>
                                                            <td class="pb05">
                                                                <input name="uaddrpostcode" type="text"
                                                                    readonly="readonly" id="join_uaddrpostcode"
                                                                    title="직접입력 불가"
                                                                    class="join_form_control dlb wid80" />&nbsp;
                                                                <button type="button" class="btn btn-default"
                                                                    onclick="execDaumPostcode(); return false;">우편번호찾기</button>&nbsp;

                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td class="pb05">
                                                                <input name="uaddr1" type="text" readonly="readonly"
                                                                    id="join_uaddr1" class="join_form_control  dlb"
                                                                    style="width:450px;readOnly:true;" />
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <input name="uaddr2" type="text" maxlength="50"
                                                                    id="join_uaddr2" class="join_form_control dlb"
                                                                    style="width:450px;" placeholder="상세주소를 입력 해주세요" />
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>

                                                <div class="div_info_maroon sstc">
                                                    <span id="join_holder_addr_info" class="sstc helptext"></span>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>

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
                                    <script language="javascript">
                                        function checkAll() {
                                            if (!checkUserId(join.uid.value)) {
                                                return false;
                                            }
                                            if (!checkPassword(join.uid.value, join.upw.value,    join.upwcheck.value)) {
                                                return false;
                                            }
                                            if (!checkMail(join.uemail.value)) {
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
                                     
                                        function checkUserId(uid) {
                                            //Id가 입력되었는지 확인하기
                                            if (!checkExistData(uid, "아이디를"))
                                                return false;
                                     
                                            var idRegExp = /^[a-zA-z0-9]{4,12}$/; //아이디 유효성 검사
                                            if (!idRegExp.test(uid)) {
                                                alert("아이디는 영문 대소문자와 숫자를 사용하여 4~12자리로 입력해야합니다!");
                                                join.uid.value = "";
                                                join.uid.focus();
                                                return false;
                                            }
                                            return true; //확인이 완료되었을 때
                                        }
                                     
                                        function checkPassword(uid, upw, upwcheck) {
                                            //비밀번호가 입력되었는지 확인하기
                                            if (!checkExistData(upw, "비밀번호를"))
                                                return false;
                                            //비밀번호 확인이 입력되었는지 확인하기
                                            if (!checkExistData(upwcheck, "비밀번호 확인을"))
                                                return false;
                                     
                                            var password1RegExp = /^[a-zA-z0-9]{8,20}$/; //비밀번호 유효성 검사
                                            if (!password1RegExp.test(upw)) {
                                                alert("비밀번호는 영문 대소문자와 숫자 8~20자리로 입력해야합니다!");
                                                join.upw.value = "";
                                                join.upwcheck.focus();
                                                return false;
                                            }
                                            //비밀번호와 비밀번호 확인이 맞지 않다면..
                                            if (upw != upwcheck) {
                                                alert("두 비밀번호가 맞지 않습니다.");
                                                join.upw.value = "";
                                                join.upwcheck.value = "";
                                                join.upwcheck.focus();
                                                return false;
                                            }
                                     
                                            //아이디와 비밀번호가 같을 때..
                                            if (uid == upw) {
                                                alert("아이디와 비밀번호는 같을 수 없습니다!");
                                                join.upw.value = "";
                                                join.upwcheck.value = "";
                                                join.upwcheck.focus();
                                                return false;
                                            }
                                            return true; //확인이 완료되었을 때
                                        }
                                     
                                        function checkMail(uemail) {
                                            //mail이 입력되었는지 확인하기
                                            if (!checkExistData(uemail, "이메일을"))
                                                return false;
                                     
                                            var emailRegExp = /^[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}$/;
                                            if (!emailRegExp.test(uemail)) {
                                                alert("이메일 형식이 올바르지 않습니다!");
                                                join.uemail.value = "";
                                                join.uemail.focus();
                                                return false;
                                            }
                                            return true; //확인이 완료되었을 때
                                        }
                                     
                                        function checkName(uname) {
                                            if (!checkExistData(uname, "이름을"))
                                                return false;
                                     
                                            var nameRegExp = /^[가-힣]{2,4}$/;
                                            if (!nameRegExp.test(uname)) {
                                                alert("이름이 올바르지 않습니다.");
                                                return false;
                                            }
                                            return true; //확인이 완료되었을 때
                                        }
                                     
                                      
                                        
                                       
                                    </script>


                                </tbody>





                        </div>


                    </div>




                    </table>

                    <div class="join_footer_btnbox">
                        <input type="submit" class="btn btn_custom btn_lg wid150" value="회원가입">

                    </div>




                </div>


            </div>

        </div>
        </div>
        </div>
        </div>

    </form>
     <jsp:include page="/footer/footer.jsp"/>

    
</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
   $("button#checkIdBtn").on("click", function(){
      $.ajax({
         url: "${pageContext.request.contextPath}/user/controller/UserCheckIdOk.us",
         type: "get",
         data: {uid: $("input[name='uid']").val()},
         contextType: "application/json; charset=utf-8",
         dataType: "text",
         success: function(result){
            console.log(result);
            $("#CheckID").css("color", result.includes("가능") ? "blue" : "red");
            $("#CheckID").text(result.trim());
         }, error: function(a, b, c){
            console.log(a, b, c);
         }
      });      
   })

</script>
</html></html>





