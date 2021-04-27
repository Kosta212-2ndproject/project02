$(document).ready(function () {
    $('[name=address-insert]').click(function () {
        // if (!$("input:radio[id='address-insert']").is(":checked")) {
        //     alert("체크 해주세요.");
        // }
        alert(1);
    });
});


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
                if (result == 'true') {
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

function addressUpdate() {
    // 해당하는 회원의 휴대폰번호가 있으면 주소 저장
    $.ajax({
        url: "../update", // 서버요청주소
        type: "post",  // 전송방식(get.post, put, delete)
        dataType: "text",   // 서버가 응답해주는 데이터의 타입(html, text, xml, json 중의 한 개 )
        data: {},	// 폼전송 : 서버에게 보낼 parameter 정보
        success: function (result) { // result의 값은 가능 or 안됨
            alert("등록되었습니다.");
        }, //성공했을 때 함수

        error: function (err) {
            alert(err + "발생했습니다.")
        }//오류발생했을 때 함수 callback함수
    });   // ajax 끝

    return false;
}

$(document).ready(function () {

    $("#payment").click()
    {
        IMP.request_pay({
            pg: 'html5_inicis',   // pg사 KG이니시스
            pay_method: $("[name=radio]").val(),   // 결제 방식
            // 주문번호는 : YYMMDD_{제품코드}{구매수량(3자리)}{넘버} + $(this).attr("id");
            merchant_uid: $(this).attr("id"), // + new Date().getTime(),
            name: '주문: ' + $(this).parent().prev().prev().text(),  // 주문명 주문명은 16글자 이내를 권장한다.
            amount: $(this).parent().prev().text(), // 가격
            display: {card_quota: [1, 2, 3, 4, 5, 6]}, // 할부개월수
            digital: true, // 휴대폰 소액결제를 위한 param속성 false 일경우 콘텐츠, true일 경우 실물
            buyer_email: 'iamport@siot.do',
            buyer_name: '구매자이름',
            buyer_tel: '010-1234-5678',
            buyer_addr: '서울특별시 강남구 삼성동',
            buyer_postcode: '123-456',
            m_redirect_url: 'https://localhost:8080/successPay.jsp'
        }, function (rsp) {
            if (rsp.success) {
                //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
                jQuery.ajax({
                    url: "../payHistory", //cross-domain error가 발생하지 않도록 동일한 도메인으로 전송
                    type: 'get',
                    dataType: 'json',
                    data: {
                        imp_uid: rsp.imp_uid
                        //기타 필요한 데이터가 있으면 추가 전달
                    }
                }).done(function (data) {
                    //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
                    if (everythings_fine) {
                        alert(data);
                    } else {
                        //[3] 아직 제대로 결제가 되지 않았습니다.
                        //[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
                    }
                });
            } else {
                var msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;

                alert(msg);
            }
        });
    }
});
