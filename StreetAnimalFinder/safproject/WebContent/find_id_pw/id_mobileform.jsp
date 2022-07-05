<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>

<head><link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/find_id_pw/form.css" />
<title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA Compatible" content="IE=edge">
    <meta name="viewport" content="width=devic-width, initial-scale=1.0">
    <title>아이디 찾기</title>
</head>

<body>
      <jsp:include page="/header/header.jsp"/>
            <style type="text/css">
                .searchTypeBtnBox{
                    width:50%;
                    float:left;
                }
                .searchTypeBtn{         
                    border: none;
                    border-radius: 0;
                    height:60px;
                    width:200px;
                    font-size:16px;
                    font-weight:bold;
                }
                .findTypeRdoBox{
                    text-align:left;
                    padding:60px 20px 10px;
                }
            </style>
            
            <div style="margin:auto;width:560px;">
                
                <span id="searchID">
                   <div style="height:70px;margin-top:10px">
                    <div class="searchTypeBtnBox">
                         <button id="searchIdBtn" type="button" class="btn btn-lg btn-default searchTypeBtn" style="border-top:1px solid #019267;;cursor:default;" onclick="location.href='id_mobileform.jsp'" onclick="location.href='id_emailform.jsp'">아이디 찾기</button>
                    </div>
                    <div class="searchTypeBtnBox">
                        <button id="searchPwBtn" type="button" class="btn btn-lg btn-default searchTypeBtn" style="color:#9a9a9a;" onclick="location.href='pw_mobileform.jsp'" onclick="location.href='pw_emailform.jsp'">비밀번호 찾기</button>
                    </div>
                </div>
                </span>
        
                <div>
                    <div id="findTypeRdoBoxParent" style="border-top:1px solid gray">
                        <div id="findTypeRdoBox" class="findTypeRdoBox">
                              <span class="pr10 roundRdo"><input id="findByMobile" type="radio" name="searchFindType" value="FindByMobile" checked="checked" onclick="location.href='idform.jsp'"><label for="findByMobile">휴대폰번호로 찾기</label></span>
                            <span class="roundRdo"><input id="findByEMail" type="radio" name="searchFindType" value="FindByEMail" onclick="location.href='id_emailform.jsp'"><label for="findByEMail">이메일로 찾기</label></span>
                        </div>
                    </div>
                    <table class="pop_tableV2">
                        <colgroup>
                            <col style="width:20%">
                            <col style="width:80%">
                        </colgroup>
                        <tbody><tr><!-- 이름 -->
                            <th class="setThBackgroundColor setThBorderBottom setThTextColor">이름</th>
                            <td class="setThBorderBottom">
                                <input name="txtiName1" type="text" maxlength="20" id="txtiName" tabindex="10" class="form-control" style="width:170px;">
                            </td>
                        </tr>
                        
                        <tr id="mobileInputSec"><!-- 휴대폰번호 -->
                            <th class="setThBackgroundColor setThBorderBottom setThTextColor">휴대폰번호</th>
                            <td class="setThBorderBottom">
                                <input name="txtiMobile1" type="text" maxlength="4" id="txtiMobile" tabindex="30" class="form-control dinlineblock" onkeyup="" style="width:170px;">
                                <button id="MobileBtn" type="button" style="width:120px;font-weight:bold" class="btn btn-custom dinlineblock" onclick="" tabindex="50">아이디확인</button>
                            </td>
                        </tr>
        
                    </tbody></table>
                </div>         
   
            </div>
 
<jsp:include page="/footer/footer.jsp"/>
</body>

</html>

