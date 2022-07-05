document.querySelectorAll("input").forEach(input => {
    input.addEventListener("invalid", () => {
      // 검증 후 폼 요소에 was-validated 클래스로 표시해 둔다
      document.forms[0].classList.add("was-validated")
    })
  })

$(document).ready(function(){ 
    $("#submit").click(function(){
            if($("#gen").val().length==0){ alert("필수 입력"); $("#gen").focus(); return false; }
            if($("#Email").val().length==0){ alert("이메일을 입력하세요."); $("#Email").focus(); return false; }
            if($("#Phone").val().length==0){ alert("휴대폰번호를 입력하세요."); $("#Phone").focus(); return false; }
            if($("#Message").val().length==0){ alert("메세지를 입력하세요."); $("#Message").focus(); return false; }
        });		
});


function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                //if(data.buildingName !== '' && data.apartment === 'Y'){
                //    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                //}
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                //if(extraAddr !== ''){
                //}
                
                // 조합된 참고항목을 해당 필드에 넣는다.
             document.getElementById("sample6_extraAddress").value = extraAddr.substr(0, extraAddr.length - 0);
            
            } else {
               document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("sample6_detailAddress").focus();
        }
    }).open();
}


 

function loadFile(input) {
    var file = input.files[0];	//선택된 파일 가져오기
    console.log("선택된 파일가져오기",file);
    //미리 만들어 놓은 div에 text(파일 이름) 추가
    var name = document.getElementById('fileName');
    name.textContent = file.name;

    //새로운 이미지 div 추가
    var newImage = document.createElement("img");
    newImage.setAttribute("class", 'img');

    //이미지 source 가져오기
    newImage.src = URL.createObjectURL(file);   

    newImage.style.width = "70%";
    newImage.style.height = "70%";
    // newImage.style.visibility = "hidden";   //버튼을 누르기 전까지는 이미지를 숨긴다
    newImage.style.objectFit = "contain";

    //이미지를 image-show div에 추가
    var container = document.getElementById('image-show');
    container.appendChild(newImage);
};



  
  
  // 유효성 검사
function send(){	
console.log("check");
	if(findWriteForm.lpstatus.value == 'none'){
		alert("말머리를 선택해주세요.");
		return false;
	}
	
	if(!findWriteForm.lparea1.value){
		alert("실종지역(시군구)을 선택해주세요.");
		return false;
	}
	
	if(!findWriteForm.lparea2.value){
		alert("실종지역(읍면동)을 작성해주세요.");
		return false;
	}
	
	if(!findWriteForm.lparea3.value){
		alert("실종지역(상세 위치)을 작성해주세요.");
		return false;
	}

	if(!findWriteForm.lpspecies.value){
		alert("실종 동물 종을 확인해주세요.");
		return false;
	}
	
	if(findWriteForm.lpgender.value == 'none'){
		alert("실종 동물 성별을 확인해주세요.");
		return false;
	}
	
		if(findWriteForm.lpage.value == 'none'){
		alert("실종 동물 나이 확인해주세요.");
		return false;
	}

		if(!findWriteForm.lpcolor.value){
		alert("실종 동물 색상을 확인해주세요.");
		return false;
	}
	

		if(!findWriteForm.lpcontent.value){
		alert("실종 동물 상세정보를 확인해주세요.");
		return false;
	}
	
	else return true;
}
  
  
  function fileCheck(obj) {
    pathpoint = obj.value.lastIndexOf('.');
    filepoint = obj.value.substring(pathpoint+1, obj.length);
    filetype=filepoint.toLowerCase();
    if(filetype=='jpg' || filetype=='gif'||filetype=='png'||filetype=='jpeg'||filetype=='bmp') {
      // 정상적인 이미지 확장자의 경우
      $(".files").change(function(e){
         		var file = e.target.files[0];
         		var img = $(this).find("img");
         		var reader = new FileReader();
         		reader.readAsDataURL(file);
         		
    	   		reader.onload = function(e){
    	   			if(e.target.result.indexOf("image") != -1){
    		   			img.attr("src", e.target.result)
    	   			}else{
    	   				img.attr("src", "${pageContext.request.contextPath}/images/no_img.jpg");
    	   			}
    	   		}
    	   	});
         	
         	
         	
         	
    } else {
      alert('이미지 파일만 선택할 수 있습니다.');
      parentObj = obj.parentNode
      node = parentObj.replaceChild(obj.cloneNode(true).obj);
      return false;
    }
    if(filetype=='bmp'){
      upload == confirm('BMP 파일은 웹상에서 사용하기엔 적절한 이미지 포맷이 아닙니다. \n그래도 계속 하시겠습니까?');
      if(!upload) return false;
    }
  }
  
         	
function cancelFile(fileName){
	$("input#" + fileName).val("");
	$("img#" + fileName + "Img").attr("src", "images/filePlus.png");
}

   