

(function ($) {
    // USE STRICT
    "use strict";

    /*==================================================================
    [ Slick1 ]*/
    $('.wrap-slick1').each(function(){
        var wrapSlick1 = $(this);
        var slick1 = $(this).find('.slick1');


        var itemSlick1 = $(slick1).find('.item-slick1');
        var layerSlick1 = $(slick1).find('.layer-slick1');
        var actionSlick1 = [];


        $(slick1).on('init', function(){
            var layerCurrentItem = $(itemSlick1[0]).find('.layer-slick1');

            for(var i=0; i<actionSlick1.length; i++) {
                clearTimeout(actionSlick1[i]);
            }

            $(layerSlick1).each(function(){
                $(this).removeClass($(this).data('appear') + ' visible-true');
            });

            for(var i=0; i<layerCurrentItem.length; i++) {
                actionSlick1[i] = setTimeout(function(index) {
                    $(layerCurrentItem[index]).addClass($(layerCurrentItem[index]).data('appear') + ' visible-true');
                },$(layerCurrentItem[i]).data('delay'),i);
            }
        });


        var showDot = false;
        if($(wrapSlick1).find('.wrap-slick1-dots').length > 0) {
            showDot = true;
        }

        $(slick1).slick({
            pauseOnFocus: false,
            pauseOnHover: false,
            slidesToShow: 1,
            slidesToScroll: 1,
            fade: true,
            speed: 1000,
            infinite: true,
            autoplay: true,
            autoplaySpeed: 6000,
            arrows: true,
            appendArrows: $(wrapSlick1),
            prevArrow:'<button class="arrow-slick1 prev-slick1"><i class="zmdi zmdi-caret-left"></i></button>',
            nextArrow:'<button class="arrow-slick1 next-slick1"><i class="zmdi zmdi-caret-right"></i></button>',
            dots: showDot,
            appendDots: $(wrapSlick1).find('.wrap-slick1-dots'),
            dotsClass:'slick1-dots',
            customPaging: function(slick, index) {
                var linkThumb = $(slick.$slides[index]).data('thumb');
                var caption = $(slick.$slides[index]).data('caption');
                return  '<img src="' + linkThumb + '">' +
                    '<span class="caption-dots-slick1">' + caption + '</span>';
            },
        });

        $(slick1).on('afterChange', function(event, slick, currentSlide){

            var layerCurrentItem = $(itemSlick1[currentSlide]).find('.layer-slick1');

            for(var i=0; i<actionSlick1.length; i++) {
                clearTimeout(actionSlick1[i]);
            }

            $(layerSlick1).each(function(){
                $(this).removeClass($(this).data('appear') + ' visible-true');
            });

            for(var i=0; i<layerCurrentItem.length; i++) {
                actionSlick1[i] = setTimeout(function(index) {
                    $(layerCurrentItem[index]).addClass($(layerCurrentItem[index]).data('appear') + ' visible-true');
                },$(layerCurrentItem[i]).data('delay'),i);
            }

        });

    });

    /*==================================================================
    [ Slick2 ]*/
    $('.wrap-slick2').each(function(){
        $(this).find('.slick2').slick({
            slidesToShow: 4,
            slidesToScroll: 4,
            infinite: false,
            autoplay: false,
            autoplaySpeed: 6000,
            arrows: true,
            appendArrows: $(this),
            prevArrow:'<button class="arrow-slick2 prev-slick2"><i class="fa fa-angle-left" aria-hidden="true"></i></button>',
            nextArrow:'<button class="arrow-slick2 next-slick2"><i class="fa fa-angle-right" aria-hidden="true"></i></button>',
            responsive: [
                {
                    breakpoint: 1200,
                    settings: {
                        slidesToShow: 4,
                        slidesToScroll: 4
                    }
                },
                {
                    breakpoint: 992,
                    settings: {
                        slidesToShow: 3,
                        slidesToScroll: 3
                    }
                },
                {
                    breakpoint: 768,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 2
                    }
                },
                {
                    breakpoint: 576,
                    settings: {
                        slidesToShow: 1,
                        slidesToScroll: 1
                    }
                }
            ]
        });
    });


    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
        var nameTab = $(e.target).attr('href');
        $(nameTab).find('.slick2').slick('reinit');
    });

    /*==================================================================
    [ Slick3 ]*/
    $('.wrap-slick3').each(function(){
        $(this).find('.slick3').slick({
            slidesToShow: 1,
            slidesToScroll: 1,
            fade: true,
            infinite: true,
            autoplay: false,
            autoplaySpeed: 6000,

            arrows: true,
            appendArrows: $(this).find('.wrap-slick3-arrows'),
            prevArrow:'<button class="arrow-slick3 prev-slick3"><i class="fa fa-angle-left" aria-hidden="true"></i></button>',
            nextArrow:'<button class="arrow-slick3 next-slick3"><i class="fa fa-angle-right" aria-hidden="true"></i></button>',

            dots: true,
            appendDots: $(this).find('.wrap-slick3-dots'),
            dotsClass:'slick3-dots',
            customPaging: function(slick, index) {
                var portrait = $(slick.$slides[index]).data('thumb');
                return '<img src=" ' + portrait + ' "/><div class="slick3-dot-overlay"></div>';
            },
        });
    });

})(jQuery);

// 댓글 페이징 처리
$("#formBtn").on("click", function(e){
    e.preventDefault();

    let formSerializeArray = $("#dataForm").serializeArray();
    let object = {};
    for (let i = 0; i < formSerializeArray.length; i++){
        object[formSerializeArray[i]['name']] = formSerializeArray[i]['value'];
    }

    let json = JSON.stringify(object);
    console.log(json);

    $.ajax({
        url: "/productReply/new",
        type: "post",
        data: json,
        contentType: "application/json",

        success: function(str) {
            alert(str)
            $("#content").val(""); // 댓글 등록 성공시 댓글내용 textarea 빈칸으로 초기화
            showList(1); // 자동으로 추가된 댓글 불러오기
        }
    });
})

let pageNum = 1;
let pno = $("#pno").val();

$("#reply").on("click", function() {
    showList(pageNum);
})

function getList(param, callback, error) {
    let page = param.page || 1;
    $.getJSON("/productReply/list/" + param.pno + "/" + page, function (replyPageDTO) {
        if (callback) {
            callback(replyPageDTO.total, replyPageDTO.list);
        }
    }).fail(function (xhr, status, er) {
        if (error) {
            error(er);
        }
    });
}



// 댓글 불러오기 최신순

function showList(page){
    getList({pno: pno, page: page}, function(total, list){
        pageNum = page;
        let str = "";

        if(list == null || list.length == 0) {
            list.replyUL.html("");
            return;
        }

        $.each(list, function(i, reply){
            str += "<li id='comment6468529' class='rp_general'>";
            str += "<span class='reply_content'>";
            str += "<span class='tit_nickname'>" + reply.name + "<span class='ico_skin ico_secret'></span></span>";
            str += "<span class='txt_reply'>" + reply.content + "<br></span>";
            str += "<span class='txt_date'>"
            str += reply.registerDate
            // str += "<a class='aInLi' href=''>신고</a></span>"
            str += "</span><div class='my_edit'>"
            // str += "<a href='#' class='link_edit'>수정</a>"
            str += "<a onclick='delelteReply(" + reply.prno + ")' class='link_edit'>삭제</a>"
        });

        $(".list_reply").html(str);
        showReplyPage(total);
    });
}


function showReplyPage(total){
    let endPage = Math.ceil(pageNum / 10.0) * 10;
    let startPage = endPage - 9;
    let realEnd = Math.ceil(total / 10.0);

    if(endPage > realEnd){
        endPage = realEnd;
    }

    let prev = startPage > 1;
    let next = endPage * 10 < total;
    let str = "";

    if(prev){
        str += "<a class='changePage' href='" + (startPage - 1) + "'><code>&lt;</code></a>"
    }
    for(let i = startPage; i <= endPage; i++){
        str += pageNum == i ? "<a class='link_page'><span class='selected'>" + i + "</span></a>" : "<a class='link_page' onclick='showList(" + i + ")'><span>" + i + "</span></a>";
    }
    if(next){
        str += "<a class='changePage' href='" + (endPage + 1) + "'><code>&gt;</code></a>"
    }
    $(".inner_paging").html(str);
}

function delelteReply(prno) {
    $.ajax({
        url: "/productReply/" + prno,
        type: "delete",
        contentType: "string",
        success: function(str) {
            alert(str);
            showList(pageNum); // 댓글을 다시 불러와서 삭제된 댓글 화면에서도 지우기(다시 불러오면 값이 지워지니 없어짐)
        }
    })

}
