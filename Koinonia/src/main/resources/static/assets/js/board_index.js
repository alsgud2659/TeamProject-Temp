let pageNum = 1;
let type = "";
let keyword = "";
let realEnd;
//리스트를 넣을 요소
const $resultBox = $(".result-list-box")

//페이지 진입시 리스트 뿌리기
$(document).ready(function(){
    getList();
});

//검색 버튼 클릭 이벤트
$(".search-btn").on("click", function () {
    type = $("select[name='type']").val();
    keyword = $("input[name='keyword']").val();
    //기존 리스트 제거
    $resultBox.html("");
    //검색 결과는 다시 1페이지 부터
    pageNum=1;
    getList(type, keyword);
})

//스크롤 이벤트
let timer;
$(window).scroll(function () {
    // 현 스크롤 탑의 위치
    let windowTop = $(window).scrollTop();
    // 결과 리스트를 감싸는 요소 높이
    let contentHeight = $(".result-list-box").height();
    // 창의 전체 높이
    let windowHeight = $(window).height();


    // 스크롤이 마지막 이면 데이터 가져오기
    if (windowTop > (contentHeight - windowHeight)) {
        if (timer) {
            clearTimeout(timer);
        }
        timer = setTimeout(() => {
            if(pageNum > realEnd){ return; }
            getList(type, keyword);
        }, 500);
    } else {
    }
});


//리스트 뿌리는 함수(타입, 키워드)
function getList(type, keyword){
    boardService.getSearchList({
        pageNum : pageNum,
        type : type,
        keyword : keyword,
        amount : 9
    }, function (boardList) {
        let str = "";
        let filePath = "";
        console.log(boardList);
        if(boardList == null || boardList.length == 0) { console.log("등록된 게시물이 없습니다."); return; }
        realEnd = Math.ceil(boardList[0].total / 9.0);
        console.log(realEnd);
        boardList.forEach((board,i) => {
            //이미지 경로 썸네일 이름에 s_ 붙인다는 가정하고 만듬
            filePath = board.uploadPath + "/s_" + board.uuid + "_" + board.fileName;
            str +=
                "<div class=\"col-md-4 col-sm-4 col-xs-6 col-xs-v12 col-tiny\">" +
                "<div class=\"thumbnail\">" +
                "<div class=\"image\"" +
                "style=\"background-image:url('/board/display?fileName=" + filePath + "');\"" +
                "onclick=\"location.href='/board/detail?bno=" + board.bno + "';\">" +
                "<div class=\"label-wrap\">" +
                "</div>" +
                "</div>" +
                "<div class=\"caption\" onclick=\"location.href='/board/detail?bno=" + board.bno + "';\">" +
                "<div class=\"title ellipsis st-font1\">" +
                board.title +
                "</div>" +
                "</div>" +
                // "<div class=\"desc\">" +
                // board.content +
                // "</div>" +
                "<div class=\"info text-right\">" +
                "<i class=\"user_icon\"></i>" + board.name + "&nbsp;&nbsp;&nbsp;<i></i>" + board.updateDate +
                "</div>" +
                "</div>" +
                "</div>"
        });
        $resultBox.append(str);
    });
    pageNum++;
}
// ============= ajax ======================
boardService = (function(){
    function getSearchList(searchInfo, callback, error) {
        $.ajax({
            url : "/board/getListBySearch",
            type : "post",
            data : JSON.stringify(searchInfo),
            contentType : "application/json",
            dataType : "json",
            success : function(result){
                if(callback) { callback(result); }
            },
            error : function (xhr, status, er) {
                if(error) { error(er); }
            }
        })
    }
    return {getSearchList:getSearchList};
})();