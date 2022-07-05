
$("#pw + button").click(() => {
  let eye = $("#pw + button").children("img");
  let see = "/images/eye_see.png";
  let nosee = "/images/eye_nosee.png";
  if (eye.attr("src") == see) {
    eye.attr("src", nosee);
    $("#pw").attr("type", "text");
  } else {
    eye.attr("src", see);
    $("#pw").attr("type", "password");
  }
});
//////////////////////////////////////////////////////
$("#pw1 + button").click(() => {
  let eye = $("#pw1 + button").children("img");
  let see = "/images/eye_see.png";
  let nosee = "/images/eye_nosee.png";
  if (eye.attr("src") == see) {
    eye.attr("src", nosee);
    $("#pw1").attr("type", "text");
  } else {
    eye.attr("src", see);
    $("#pw1").attr("type", "password");
  }
});
///////////////////////////////////////////////////////
// 유효성 검사
// null 여부 확인
const isNull = (target) => {
  console.log(target.val().length);
  if (target.val() == null || target.val().length == 0) {
    return true;
  } else {
    return false;
  }
};
// 구성 조건
let spc = /[~!@#$%^&*()_+|<>?:{}]/;
let pw = /^(?=.*[a-zA-Z])(?=.*[0-9]).{4,12}$/;
let email =
  /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
// 중복 확인
const checkDuplication = (target) => {
  target.on("change", () => {
    joinService.checkDuplication(target.val(), (result) => {
      if (result) {
        // 사용가능
      } else {
        // 중복
      }
    });
  });
};

const checkPw = () => {
  // null 여부 확인
  if (isNull($("#pw"))) {
    $("#pw").attr("style", "border-color:#e00751;");
    $("#pwGuidMsg").text("비밀번호를 입력해주세요.");
    $("#pwGuidMsg").attr("style", "display:block;");
    return false;
  } else {
    $("#pw").removeAttr("style");
    $("#pwGuidMsg").removeAttr("style");
  }

  // 구성 조건
  console.log(pw.test($("#pw").val()));
  if ($("#pw").val().length < 8 || $("#pw").val().length > 12) {
    $("#pw").attr("style", "border-color:#e00751;");
    $("#pwGuidMsg").text("비밀번호는 8~12자리를 입력해야합니다.");
    $("#pwGuidMsg").attr("style", "display:block;");
    return false;
  } else {
    $("#pw").removeAttr("style");
    $("#pwGuidMsg").removeAttr("style");
  }
  return true;
};
const checkPw1 = () => {
  // null 여부 확인
  if (isNull($("#pw1"))) {
    $("#pw1").attr("style", "border-color:#e00751;");
    $("#pwGuidMsg1").text("비밀번호를 입력해주세요.");
    $("#pwGuidMsg1").attr("style", "display:block;");
    return false;
  } else {
    $("#pw1").removeAttr("style");
    $("#pwGuidMsg1").removeAttr("style");
  }

  // 구성 조건
  console.log(pw.test($("#pw1").val()));
  if ($("#pw").val() !=$("#pw1").val()) {
    $("#pw1").attr("style", "border-color:#e00751;");
    $("#pwGuidMsg1").text("비밀번호가 일치하지않습니다.");
    $("#pwGuidMsg1").attr("style", "display:block;");
    return false;
  } else {
    $("#pw1").removeAttr("style");
    $("#pwGuidMsg1").removeAttr("style");
  }
  return true;
};
$(document).ready(() => {
  // 비밀번호
  $("#pw1").on("change", () => {
    console.log(checkPw1());
  });
  // 비밀번호
  $("#pw").on("change", () => {
    console.log(checkPw());
  });
});
const dobuleCheck = () => {
  if (checkPw1() && checkPw()) {
    return true;
  }
  return false;
};

