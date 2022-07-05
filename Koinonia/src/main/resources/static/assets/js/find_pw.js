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

const checkEmail = () => {
  // null 여부 확인
  if (isNull($("#email"))) {
    $("#email").attr("style", "border-color:#e00751;");
    $("#emailGuidMsg").text("이메일을 입력해주세요.");
    $("#emailGuidMsg").attr("style", "display:block;");
    return false;
  } else {
    $("#email").removeAttr("style");
    $("#emailGuidMsg").removeAttr("style");
  }
  // 구성 조건
  if ($("#email").val().match(email) == null) {
    $("#email").attr("style", "border-color:#e00751;");
    $("#emailGuidMsg").text("유효한 이메일을 입력해주세요");
    $("#emailGuidMsg").attr("style", "display:block;");
    return false;
  } else {
    $("#email").removeAttr("style");
    $("#emailGuidMsg").removeAttr("style");
  }
  return true;
};

$(document).ready(() => {
  // 이메일
  $("#email").on("change", () => {
    console.log(checkEmail());
  });
});
const dobuleCheck = () => {
  if (checkEmail()) {
    return true;
  }
  return false;
};
