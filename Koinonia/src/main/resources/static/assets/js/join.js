// 비밀번호 보기/감추기
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

const checkName = () => {
  // null 여부 확인
  console.log(isNull($("#name")));
  if (isNull($("#name"))) {
    console.log(isNull($("#name")));
    $("#name").attr("style", "border-color:#e00751;");
    $("#nameGuidMsg").text("이름을 입력해주세요.");
    $("#nameGuidMsg").attr("style", "display:block;");
    return false;
  } else {
    $("#name").removeAttr("style");
    $("#nameGuidMsg").removeAttr("style");
  }
  // 구성 조건
  if (spc.test($("#name").val())) {
    $("#name").attr("style", "border-color:#e00751;");
    $("#nameGuidMsg").text("이름에는 특수문자를 사용할 수 없습니다.");
    $("#nameGuidMsg").attr("style", "display:block;");
    return false;
  } else {
    $("#name").removeAttr("style");
    $("#nameGuidMsg").removeAttr("style");
  }
  if ($("#name").val().length < 2 || $("#name").val().length > 12) {
    $("#name").attr("style", "border-color:#e00751;");
    $("#nameGuidMsg").text("이름은 2자이상 12자이하만 가능합니다.");
    $("#nameGuidMsg").attr("style", "display:block;");
    return false;
  } else {
    $("#name").removeAttr("style");
    $("#nameGuidMsg").removeAttr("style");
  }
  // 중복 확인
  joinService.checkDuplication($("#name").val(), "checkName",(result) => {
    if (result) {
      // 중복인 경우
      $("#name").attr("style", "border-color:#e00751;");
      $("#nameGuidMsg").text("중복된 이름이 존재합니다.");
      $("#nameGuidMsg").attr("style", "display:block;");
      console.log(result);
      return false;
    } else {
      $("#name").removeAttr("style");
      $("#nameGuidMsg").removeAttr("style");
    }
  });
  return true;
};
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
    $("#emailGuidMsg").text("올바른 이메일 주소를 입력해주세요");
    $("#emailGuidMsg").attr("style", "display:block;");
    return false;
  } else {
    $("#email").removeAttr("style");
    $("#emailGuidMsg").removeAttr("style");
  }
  // 중복 확인
  console.log($("#email").val());
  joinService.checkDuplication($("#email").val(), "checkEmail", (result) => {
    if (result) {
      // 중복인 경우
      $("#email").attr("style", "border-color:#e00751;");
      $("#emailGuidMsg").text("중복된 이메일이 존재합니다.");
      $("#emailGuidMsg").attr("style", "display:block;");
    }else {
      $("#email").removeAttr("style");
      $("#emailGuidMsg").removeAttr("style");
    }
  });
  return true;
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
  if (!pw.test($("#pw").val())) {
    $("#pw").attr("style", "border-color:#e00751;");
    $("#pwGuidMsg").text(
      "비밀번호는 영문 대소문,숫자 조합으로 4~12자리를 사용해야 합니다."
    );
    $("#pwGuidMsg").attr("style", "display:block;");
    return false;
  } else {
    $("#pw").removeAttr("style");
    $("#pwGuidMsg").removeAttr("style");
  }
  return true;
};
// 필수 체크사항 체크 확인
// 이용약관
const checkInputcheck01 = () => {
  if (!$("#check01").is(":checked")) {
    $("#check01GuidMsg").text("약관을 읽고 동의해야 합니다.");
    $("#check01GuidMsg").attr("style", "display:block;");
    return false;
  } else {
    $("#check01GuidMsg").removeAttr("style");
  }
  return true;
};
// 개인정보수집동의
const checkInputcheck02 = () => {
  if (!$("#check02").is(":checked")) {
    $("#check02GuidMsg").text("개인정보 수집ㆍ이용에 대한 동의를 해야합니다.");
    $("#check02GuidMsg").attr("style", "display:block;");
    return false;
  } else {
    $("#check02GuidMsg").removeAttr("style");
  }
  return true;
};

$(document).ready(() => {
  // 이름
  $("#name").on("change", () => {
    console.log(checkName());
  });
  // 이메일
  $("#email").on("change", () => {
    console.log(checkEmail());
  });
  // 비밀번호
  $("#pw").on("change", () => {
    console.log(checkPw());
  });
  // 체크박스
  $("#check01").on("change", () => {
    console.log(checkInputcheck01());
  });
  $("#check02").on("change", () => {
    console.log(checkInputcheck02());
  });
});
const doubleCheck = () => {
  console.log("d");
  if (
    checkName() &&
    checkEmail() &&
    checkPw() &&
    checkInputcheck01() &&
    checkInputcheck02()
  ) {
    return true;
  }
  return false;
};
