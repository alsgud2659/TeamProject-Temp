// 사이드바
$(document).ready(function(){
    $(".btn_menu_open").click(function(){
        $("#mask").fadeIn(100);
        $(".slide_menu").show().animate({left: "0"});
    });
    $("#mask, .btn_menu_close").click(function(){
        $("#mask").fadeOut(100);
        $(".slide_menu").hide().animate({left: "0"});
    });

    $(".btn_menu_open1").click(function(){
        $("#mask1").fadeIn(100);
        $(".slide_menu1").show().animate({right: "0"});
    });
    $("#mask1, .btn_menu_close1").click(function(){
        $("#mask1").fadeOut(100);
        $(".slide_menu1").hide().animate({right: "0"});
    });
});




let name = sessionStorage.getItem("user");

if(!(name==null || name.length<=0)) {
// 로그인 여부에 따른 header 변경사항
    $("#islogin").text(name + "!");
    $("#islogin").attr("style", "font-weight:bold;");
    $(".header_content").html(
        "<h2>Hej" +
        `   <sapn class="header__username" style='color:#ffdb00;'>${name}</sapn>` +
        "</h2>" +
        '<a role="button" class="btn btn--small btn--primary-inverse logout" id="header__button"' +
        'style="display: flex; justify-content: end;">' +
        '    <span class="btn__inner">로그아웃</span>' +
        '</a>'
    );
    $(".sidebar_tag-content-text").html(
        '   <h3>KOINONIA 계정</h3>'
    )
    $("#btnGoToJoin").click(() => {
        location.href = '/user/mypage'
    })
    $(".slide_menu1 .menu_list").html(
        '<li><a href="/board/register">내 여행다이어리 작성하러가기</a></li>' +
        '<li><a href="/product/register">내 여행기념품 판매하러가기</a></li>' +
        '<li><a href="/request/register">갖고 싶은 여행기념품 요청하기</a></li>' +
        '<li><a href="/user/logout" class="logout">로그아웃</a></li>'
    )
}else{
    $("#btnGoToJoin").click(() => {
        location.href = '/user/join'
    })
}

// 로그아웃
$(".logout").click(()=>{
    sessionStorage.clear();
    location.href = '/user/logout'
})



