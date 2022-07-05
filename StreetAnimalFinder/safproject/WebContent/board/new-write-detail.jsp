<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/board/LostPet.css"
      type="text/css"
    />    
</head>
<body>
  	<c:set var="board" value="${board}"/>
  	
    <jsp:include page="/header/header.jsp"/>
  	
    <div class="bg-light space-1">
        <div class="container g-mt-30 py-1 "></div>
   	</div>
 
    <div class="container te">
    	<h2 id="breadcrumb-title" class="h2 g-font-size-28 font-weight-bold g-line-height-1">${board.getBtitle()}</h2>
        <!--<h2 class="h2 text-dark font-weight-bold mb-3">제목제목제목 글씨 크기 크게</h2>-->
        <!-- height 늘리기 -->
        <div class="row-board shadow-sm">
            <div class="content te p-0">
                <div class="left lb3">
                    <div class="board-image">
                      	<img class="img" src="${pageContext.request.contextPath}/board/${board.getBimage()}" style="width: 350px;">
                    </div>
                    <div>
                    	${board.getBcontent()}
                    </div>                            
                </div>
            </div>
        </div>
    </div>
  
    <div style="clear:both;"></div>

  
    <div class="container te">
		<nav class="text-center " aria-label="Page Navigation">
            <ul class="list-inline mb-0 f-0">
              	
                <li class="list-inline-item float-left">
                    <a class="primary--hover shadow-sm" href="${pageContext.request.contextPath}/board/controller/BoardUpdate.bo?bnumber=${board.getBnumber()}" aria-label="이전글">수정</a>
                </li>
                <li class="list-inline-item float-left">
                    <a class="primary--hover shadow-sm" href="${pageContext.request.contextPath}/board/controller/BoardListOk.bo" aria-label="목록">목록</a>
                </li>
                <li class="list-inline-item float-left">
                    <a class="primary--hover shadow-sm" href="${pageContext.request.contextPath}/board/controller/BoardDeleteOk.bo?bnumber=${board.getBnumber()}" aria-label="다음글">삭제</a>
                </li>
            </ul>
        </nav>
    </div>

        
    <div style="clear:both;"></div>

  
      <div class="container te shadow-sm line-border">
          <div class="container te mb-5">
              <div class="mb-0">
                  <hr class="my-5">
                  <h3 class="h6 ">
                      댓글 1
                  </h3>
                  <hr class="my-4">
              </div>
              <div id="comment" class="media g-mb-30">
                  <div class="media-body">
                      <div class="d-flex">
                          <div class="d-block">
                              <h5 class="h6 g-color-black g-font-weight-600">
                                  김나라
                                  <span class="g-color-gray-dark-v5 g-font-size-12 g-font-weight-400">
                                      2022-05-15 19:20
                                  </span>
                              </h5>
                          </div>
                      </div>
                      <p>
                          앗 저 지나가다가 본거 같아요!!
                      </p>
                  </div>
              </div>
          </div>
      </div>
  
        
      <div style="clear:both;"></div>

  
      </div>
  
      </div>
        <jsp:include page="/footer/footer.jsp"/>
      
  </body>
  
  
  </html>
