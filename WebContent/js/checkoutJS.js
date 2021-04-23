function isChecked() {
    if (!$("input:checkbox[name='agree']").is(":checked")) {
        alert("약관을 동의해주세요.");
    } else if (!$("input:radio[id='card']").is(":checked")
        && !$("input:radio[id='phone']").is(":checked")
        && !$("input:radio[id='cultureland']").is(":checked")) {
        alert("결제 방식을 선택해주세요.");
    }

    return false;
};

function phoneNumCheck() {
    $(function () {
        $.ajax({
            url: "../phoneCheck",   		 //서버요청주소
            type: "post",  								 //전송방식(get.post, put, delete)
            dataType: "text",   						//서버가 응답해주는 데이터의 타입(html, text, xml, json 중의 한 개 )
            data: {id: $("#phoneNum").val()},											//서버에게 보낼 parameter 정보
            success: function (result) { // result의 값은 가능 or 안됨
                alert(typeof result);
                if(result == 'true') {
                    alert("해당하는 휴대폰 번호가 있습니다.");
                    addressUpdate();
                } else {
                    alert("해당하는 휴대폰 번호가 없습니다.");
                }

            }, //성공했을 때 함수

            error: function (err) {
                alert(err + "발생했습니다.")
            }//오류발생했을 때 함수 callback함수
        });   // ajax 끝

    })
}

function insertAddress() {
    // alert($("#post-code").val());

    // radio가 체크 되어 있는지 확인
    if (!$("input:radio[id='address-insert']").is(":checked")) {
        alert("체크를 해주세요.");
    }

    // 해당하는 회원의 휴대폰번호가 저장되어있는지 체크
    phoneNumCheck();

}

function addressUpdate() {
    // 해당하는 회원의 휴대폰번호가 있으면 주소 저장
    $.ajax({
        url: "../update", // 서버요청주소
        type: "post",  // 전송방식(get.post, put, delete)
        dataType: "text",   // 서버가 응답해주는 데이터의 타입(html, text, xml, json 중의 한 개 )
        data: {
            zipCode: $("#post-code").val(),
            address: $("#address").val() + $("#extraAddress").val(),
            detailAddress: $("#detail-address").val(),
            phoneNum: $("#phoneNum").val()
        },	// 폼전송 : 서버에게 보낼 parameter 정보
        success: function (result) { // result의 값은 가능 or 안됨
            alert("등록되었습니다.");
        }, //성공했을 때 함수

        error: function (err) {
            alert(err + "발생했습니다.")
        }//오류발생했을 때 함수 callback함수
    });   // ajax 끝

    return false;
}
