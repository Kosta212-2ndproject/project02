var IMP = window.IMP; // 생략가능
IMP.init('imp31629503'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용

$(document).ready(function () {
    $('[name=address-insert]').click(function () {
        // if (!$("input:radio[id='address-insert']").is(":checked")) {
        //     alert("체크 해주세요.");
        // }
        alert(1);
    });
});


function isChecked() {
    if (!$("input:checkbox[name='agree']").on('click')) {
        alert("약관을 동의해주세요.");
    } else if ( $(".mr-2 pay-method").val() == null) {
        console.log($(".mr-2 pay-method").val());
        alert("결제 방식을 선택해주세요.");
    } else {
        // productBuy();
    }
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

            error:function(request,status,error){
                alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
            }
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

        error:function(request,status,error){
            alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
        }
    });   // ajax 끝

    return false;
}


function productBuy() {

    IMP.request_pay({
        pg: 'html5_inicis',   // pg사 KG이니시스
        pay_method: $('input[class="mr-2 pay-method"]:checked').val(),   // 결제 방식
        merchant_uid: $('[name=prodId]').val() + new Date().getTime(),
        name: '주문명: ' + $('#prodName').val(),  // 주문명 주문명은 16글자 이내를 권장한다.
        amount: $("#totalPrice").val(), // 가격
        display: {card_quota: [1, 2, 3, 4, 5, 6]}, // 할부개월수
        digital: true, // 휴대폰 소액결제를 위한 param속성 false 일경우 콘텐츠, true일 경우 실물
        buyer_email: 'iampo@ggg.com',
        buyer_name: $("#userName").val(),
        buyer_tel: $("#phoneNum").val(),
        buyer_addr: $("#address").val() + $("#extraAddress").val() + $("#detail-address").val(),
        buyer_postcode: $("#post-code").val(),
    }, function (rsp) {
        if (rsp.success) {
            // [1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
            $.ajax({
                url: "../payQty", //cross-domain error가 발생하지 않도록 동일한 도메인으로 전송
                type: 'get',
                dataType: 'text',
                data: {
                    prodId: $('[name=prodId]').val(),
                    qty: $('[name=frontQty]').val()
                    //기타 필요한 데이터가 있으면 추가 전달
                },
                success: function (result) {
                    alert("sucess: " + rsp.paid_at);
                    orderInsert(rsp.merchant_uid, rsp.paid_amount, rsp.paid_at);
                    location.href='../successPay.jsp';
                    //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
                },
                error:function(request,status,error){
                    console.log("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
                }
            });
            // alert("결제 성공");


        } else {
            var msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;

            alert(msg);
        }
    });
}

function orderInsert(orderNum, price, payTime) {
    alert(payTime);
    $.ajax({
        url: "../orderInsert", // 서버요청주소
        type: "get",  // 전송방식(get.post, put, delete)
        dataType: "text",   // 서버가 응답해주는 데이터의 타입(html, text, xml, json 중의 한 개 )
        data: {
            orderNum: orderNum,
            userId: 'kim',
            orderPrice: price,
            addr: $('#address').val() + $('#extraAddress').val() + $('#detail-address').val(),
            zipCode: $('#post-code').val(),
            orderName: $('#userName').val(),
            payTime: payTime

        },	// 폼전송 : 서버에게 보낼 parameter 정보
        success: function (result) { // result의 값은 가능 or 안됨

            alert("등록되었습니다. result: " + result);

        }, //성공했을 때 함수

        error:function(request,status,error){
            alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
        }
    });   // ajax 끝
}


function cartOrder() {
    IMP.request_pay({
        pg: 'html5_inicis',   // pg사 KG이니시스
        pay_method: $('input[class="mr-2 pay-method"]:checked').val(),   // 결제 방식
        merchant_uid: $('[name=prodId]').val() + new Date().getTime(),  // 전체주문번호
        name: '주문명: ' + $('#prodName').val(),  // 주문명 주문명은 16글자 이내를 권장한다.
        amount: $("#totalPrice").val(), // 가격
        display: {card_quota: [1, 2, 3, 4, 5, 6]}, // 할부개월수
        digital: true, // 휴대폰 소액결제를 위한 param속성 false 일경우 콘텐츠, true일 경우 실물
        buyer_email: 'iampo@ggg.com',
        buyer_name: $("#userName").val(),
        buyer_tel: $("#phoneNum").val(),
        buyer_addr: $("#address").val() + $("#extraAddress").val() + $("#detail-address").val(),
        buyer_postcode: $("#post-code").val(),
    }, function (rsp) {
        if (rsp.success) {
            // [1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
            $.ajax({
                url: "../payQty", //cross-domain error가 발생하지 않도록 동일한 도메인으로 전송
                type: 'get',
                dataType: 'text',
                data: {
                    prodId: $('[name=prodId]').val(),
                    qty: $('[name=frontQty]').val()
                    //기타 필요한 데이터가 있으면 추가 전달
                },
                success: function (result) {
                    alert("sucess: " + rsp.paid_at);
                    orderInsert(rsp.merchant_uid, rsp.paid_amount, rsp.paid_at);
                    location.href='../successPay.jsp';
                    //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
                },
                error:function(request,status,error){
                    console.log("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
                }
            });
            // alert("결제 성공");


        } else {
            var msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;

            alert(msg);
        }
    });
}
