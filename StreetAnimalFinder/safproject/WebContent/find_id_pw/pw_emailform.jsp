<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>

<head><link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/find_id_pw/form.css" />
<title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA Compatible" content="IE=edge">
    <meta name="viewport" content="width=devic-width, initial-scale=1.0">
    <title>비밀번호 찾기</title>
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
                         <button id="searchIdBtn" type="button" class="btn btn-lg btn-default searchTypeBtn" style="color:#9a9a9a;" onclick="location.href='id_mobileform.jsp'" onclick="location.href='id_emailform.jsp'">아이디 찾기</button>
                    </div>
                    <div class="searchTypeBtnBox">
                        <button id="searchPwBtn" type="button" class="btn btn-lg btn-default searchTypeBtn" style="border-top:1px solid #019267;;cursor:default;" onclick="location.href='pw_mobileform.jsp'" onclick="location.href='pw_emailform.jsp'">비밀번호 찾기</button>
                    </div>
                </div>
                </span>
        
                <div>
                    <div id="findTypeRdoBoxParent" style="border-top:1px solid grey">
                        <div id="findTypeRdoBox" class="findTypeRdoBox">
                              <span class="pr10 roundRdo"><input id="findBypMobile" type="radio" name="searchFindType" value="FindBypMobile" onclick="location.href='pw_mobileform.jsp'"><label for="findByMobile">휴대폰으로 임시 비밀번호 받기</label></span>
                            <span class="roundRdo"><input id="findBypEMail" type="radio" name="searchFindType" value="FindBypEMail" checked="checked" onclick="location.href='pw_emailform.jsp'"><label for="findByEMail">이메일로 임시 비밀번호 받기</label></span>
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
                                <input name="txtName1" type="text" maxlength="20" id="txtName" tabindex="10" class="form-control" style="width:170px;">
                            </td>
                        </tr>

                        <tr><!-- 아이디 -->
                            <th class="setThBackgroundColor setThBorderBottom setThTextColor">아이디</th>
                            <td class="setThBorderBottom">
                                <input name="txtid1" type="text" maxlength="20" id="txtid" tabindex="10" class="form-control" style="width:170px;">
                            </td>
                        </tr>

                        <tr id="emailInputSec"><!-- 이메일 -->
                            <th class="setThBackgroundColor setThBorderBottom setThTextColor">이메일</th>
                            <td class="setThBorderBottom">
                                <input name="txtpEmai1" type="text" id="txtpEmai" tabindex="70" class="form-control dinlineblock" style="width:170px;" />
                                <button id="MobileBtn" type="button" style="width:120px;font-weight:bold" class="btn btn-custom dinlineblock" onclick="" tabindex="50">비밀번호확인</button>
                            </td>
                        </tr>
        
                    </tbody></table>
                </div>         
   
            </div>
     <jsp:include page="/footer/footer.jsp"/>

 

</body>

</html>