<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta
      http-equiv="X-UA-Compatible"
      content="width=device-width, initial-scale=1.0"
    />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/lostpet/find_write.css" />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
                 <script src="${pageContext.request.contextPath}/lostpet/find_write.js"></script>
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lostpet/find_write.css" />


    <title>실종동물 등록</title>
  </head>
  <body>
 <%-- <a href="${pageContext.request.contextPath}/lostpet/controller/LostPetWriteOk.lo">테스트</a> --%>
        <c:set var="unum" value="${unum}"/>
  <jsp:include page="/header/header.jsp"/>
    <main>
    
        
<div class="join_container_fluid pa00" style="    padding-right: 15px;
    padding-left: 15px;
    margin-right: auto;
    margin-left: auto;
        height: 30px;
    background: #05a4e8;
    margin-bottom: 20px;
        background-color: #019267 !important;">
            <div>
                <div id="ctl00_topimage" style="/* height:262px; */">
                    <div id="ctl00_topimagediv" class="topimagediv">
                        
                    </div>

                </div>
            </div>
            <div class="join_container_fluid nm_h_underline smbc" id="join_nm_h_underline">
            </div>
        </div>
        
        
        
      <section id="fine-write" class="wr-lay-1">
        <div class="container wr-lay-2">
          <h2 class="find-head">실종 동물 등록</h2>
        </div>
      </section>
      <section class="container">
        <h3 class="wr-title-h3">글 쓰기</h3>
        <form  method="post" action="${pageContext.request.contextPath}/lostpet/controller/LostPetWriteOk.lo" 
        onsubmit="return send()"
        name="findWriteForm" enctype="multipart/form-data">
          <div class="form-group">
            <div class="find-q">
              <label class="wr-title" for="">말머리 선택</label>
              <select class="form-control inputarea" name="lpstatus">
                <option value="none" selected style="color: #555">
                  말머리 선택
                </option>
                <option value="1">찾아요 (반려동물 찾아요)</option>
                <option value="2">봤어요 (동물을 목격했어요)</option>
              </select>
              <label class="error" for="">필수 입력 항목입니다.</label>
            </div>

            <div class="find-q">
              <label class="wr-title" for="">실종 지역</label>
              <div class="row">
                <input
                  
                  onkeydown="return captureReturnKey(event)"
                  id="sample6_postcode"
                  class="inputarea"
                  placeholder="우편번호"
                  style="display: none"
                />
                <div class="input addr">
                  <input
                  name="lparea1"
                    
                    onkeydown="return captureReturnKey(event)"
                    type="text"
                    class="form-control inputarea"
                    id="sample6_address"
                    placeholder="주소 검색"
                    onclick="sample6_execDaumPostcode()"
                  /><br />
                </div>
                <div class="input addr">
                  <input
                  name="lparea2"
                    
                    onkeydown="return captureReturnKey(event)"
                    type="text"
                    class="form-control inputarea"
                    id="sample6_extraAddress"
                    placeholder="읍면동"
                  />
                </div>
              </div>

              <input
              name="lparea3"
                
                onkeydown="return captureReturnKey(event)"
                type="text"
                class="width-place form-control inputarea"
                id="sample6_detailAddress"
                placeholder="상세 위치   ex) OO마트 주차장 앞"
                onkeydown="return captureReturnKey(event)"
              />
              <small class="form-text text-muted g-font-size-default g-mt-10"
                >20자 이하로 적어주세요.</small
              >
              <label class="error" for="">필수 입력 항목입니다.</label>
            </div>

            <div class="find-q">
              <label class="wr-title" for="">실종 (발견) 일시</label>
              <div class="row">
                <div class="time">
                  <input
                  id="dateTimeLocal"
                  onchange="setMinValue();"
                  name="lptime"
                  value="알 수 없음"
                    type="datetime-local"
                     min="2010-00-07T00:00"
                    class="form-control inputarea"
                    @bind:format="yyyy-MM-ddTHH:mm:ss"
                  />
                </div>
              </div>
            </div>
            <small class="form-text text-muted g-font-size-default g-mt-10"
                >생략 가능</small
              >
            <script>

          //시간 입력
            let dateElement = document.getElementById('dateTimeLocal');
            let date = new Date(new Date().getTime() - new Date().getTimezoneOffset() * 60000).toISOString().slice(0, 16);
            dateElement.value = date;
            dateElement.setAttribute("max", date);

            function setMinValue() {
                if(dateElement.value > date) {
                    alert('현재 시간보다 이후의 날짜는 설정할 수 없습니다.');
                    dateElement.value = date;
                }
            }

            </script>

            <div class="find-q">
              <label class="wr-title" for="">실종 동물 종 > 대분류</label>
              <select class="form-control inputarea" name="lpspecies">
                <option value="none" selected style="color: #555">
                  동물 종을 선택하세요.
                </option>
                <option value="개">개</option>
                <option value="고양이">고양이</option>
                <option value="기타">기타</option>
              </select>
              <label class="error" for="">필수 입력 항목입니다.</label>
            </div>

            <div class="find-q">
              <label class="wr-title" for="">실종 동물 종 > 소분류</label>
              <input
              name="lpbreed"
                onkeydown="return captureReturnKey(event)"
                type="text"
                class="width-small form-control inputarea"
                placeholder="ex) 말티즈"
              />
              <small class="form-text text-muted g-font-size-default g-mt-10"
                >생략 가능</small
              >
            </div>

            <div class="find-q">
              <label class="wr-title" for="">실종 동물 성별</label>
              <select class="form-control inputarea" name="lpgender">
                <option value="none" selected style="color: #555">
                  성별 (중성화 여부)를 선택하세요
                </option>
                <option value="암컷 중성화 O">암컷 중성화 O</option>
                <option value="암컷 중성화 X">암컷 중성화 X</option>
                <option value="수컷 중성화 O">수컷 중성화 O</option>
                <option value="수컷 중성화 X">수컷 중성화 X</option>
                <option value="알 수 없음">알 수 없음</option>
              </select>
              <label class="error" for="">필수 입력 항목입니다.</label>
            </div>
            
                        <div class="find-q">
              <label class="wr-title" for="">실종 동물 나이</label>
              <select class="form-control inputarea" name="lpage">
                <option value="none" selected style="color: #555">
                  나이를 선택하세요.
                </option>
                <option value="0~3세">0~3세</option>
                <option value="4~6세">4~6세</option>
                <option value="7~9세">7~9세</option>
                <option value="10세 이상">10세 이상</option>
                <option value="알 수 없음">모름</option>
              </select>
              <label class="error" for="">필수 입력 항목입니다.</label>
            </div> 

            <div class="find-q">
              <label class="wr-title" for="">실종 동물 색상</label>
              <input
              name="lpcolor"
                
                onkeydown="return captureReturnKey(event)"
                type="text"
                class="width-small form-control inputarea"
                placeholder="ex) 아이보리"
              />
              <label class="error" for="">필수 입력 항목입니다.</label>
              <small class="form-message">10자 이하로 적어주세요.</small>
            </div> 
<div style="clear:both;"></div>



                           <div class="find-q">
                           
                           <label class="wr-title" for="">실종 동물 사진</label>
                           <div  style="display:flex;">
                              <div class="files">
                                 <div>
                                     <label for="board_file1" style="display:inline;">
                                       <img id="board_file1Img" src="${pageContext.request.contextPath}/lostpet/images/filePlus.png" width="110px" height="110px" style="display:inline;">
                                    </label>
                                 </div>
                                 <input id="board_file1" name="lpimage1"  type="file"  accept='image/jpeg,image/gif,image/png' onchange="fileCheck(this);" >
                                 <input class="btn-img" type="button" onclick="cancelFile('board_file1');" value="첨부 삭제">
                              </div>
                              <div class="files">
                                 <div>
                                    <label for="board_file2" style="display:inline;">
                                       <img id="board_file2Img" src="${pageContext.request.contextPath}/lostpet/images/filePlus.png" width="110px" height="110px" style="display:inline;">
                                    </label>
                                 </div>
                                <input id="board_file2" name="lpimage2"  type="file"  accept='image/jpeg,image/gif,image/png' onchange="fileCheck(this);" >
                                 <input class="btn-img" type="button" onclick="cancelFile('board_file2')" value="첨부 삭제" >
                              </div>
                              <div class="files">
                                 <div>
                                    <label for="board_file3" style="display:inline;">
                                       <img id="board_file3Img" src="${pageContext.request.contextPath}/lostpet/images/filePlus.png" width="110px" height="110px" style="display:inline;">
                                    </label>
                                 </div>
                                 <input id="board_file3" name="lpimage3"  type="file"  accept='image/jpeg,image/gif,image/png' onchange="fileCheck(this);">
                                 <input class="btn-img" type="button" onclick="cancelFile('board_file3')" value="첨부 삭제" >
                              </div>
                               <div class="files">
                                 <div>
                                    <label for="board_file4" style="display:inline;">
                                       <img id="board_file4Img" src="${pageContext.request.contextPath}/lostpet/images/filePlus.png" width="110px" height="110px" style="display:inline;">
                                    </label>
                                 </div>
                                 <input id="board_file4" name="lpimage4"  type="file"  accept='image/jpeg,image/gif,image/png' onchange="fileCheck(this);">
                                 <input class="btn-img" type="button" onclick="cancelFile('board_file4')"value="첨부 삭제" >
                              </div>
                               <div class="files">
                                 <div>
                                    <label for="board_file5" style="display:inline;">
                                       <img id="board_file5Img" src="${pageContext.request.contextPath}/lostpet/images/filePlus.png"  width="110px" height="110px" style="display:inline;">
                                    </label>
                                 </div>
                                 <input id="board_file5" name="lpimage5"  type="file"  accept='image/jpeg,image/gif,image/png' onchange="fileCheck(this);">
                                 <input class="btn-img" type="button" onclick="cancelFile('board_file5')" value="첨부 삭제">
                              </div>
                           </div>
							</div>

                           <div style="clear:both;"></div>


            <div class="find-q">
              <label class="wr-title" for="">실종 동물 상세정보</label>
              <textarea name="lpcontent" class="width-place form-control inputarea"  style="width:60%; height:264px; resize: none;"></textarea>
              
             <!--  <div id="summernote">사진 및 기타 상세정보를 입력하세요.</div> -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
              <script>
                $(document).ready(function() {
                  $('#summernote').summernote({
                    placeholder: '실종동물 상태 및 기타를 입력해주세요. ex) 귀에 상처가 있음',
                    height: 500,
                    lang: 'ko-KR',
                    toolbar: [
                                // [groupName, [list of button]]
                                ['Font Style', ['fontname']],
                                ['style', ['bold', 'italic', 'underline']],
                                ['font', ['strikethrough']],
                                ['fontsize', ['fontsize']],
                                ['color', ['color']],
                                ['para', ['paragraph']],
                                ['height', ['height']],
                                ['Insert', ['picture']],
                                ['Insert', ['link']],
                                ['Misc', ['fullscreen']]
                             ]
                  });
                });
            </script>
              
              <label class="error" for="">필수 입력 항목입니다.</label>
            </div>
          </div>
          <div class="button">
            <input type="submit" value="글 등록" class="btn"/>
             <script src="${pageContext.request.contextPath}/lostpet/find_write.js"></script>
          </div>
        </form>
      </section>
      
    </main>


  <jsp:include page="/footer/footer.jsp"/>
  </body>
</html>
