var IMP = window.IMP; // 생략가능
IMP.init('imp31629503'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용

$(function () {

    var prodId, prodName, prodPrice;

    function selectAll() {
        // 전체검색
        $.ajax({
            url: "../selectAll",   		 //서버요청주소
            type: "get",  								 //전송방식(get.post, put, delete)
            dataType: "json",   						//서버가 응답해주는 데이터의 타입(html, text, xml, json 중의 한 개 )
            // data: {id: $(this).val()},											//서버에게 보낼 parameter 정보
            success: function (result) {
                // alert(result);
                var str = "";
                $.each(result, function (index, dto) {
                    // alert(index + ", " + item + ", " + item.name);
                    prodId = dto.prodID;
                    prodName = dto.prodName;
                    prodPrice = dto.prodPrice;
                    str += `<tr>`;
                    str += `<td><a href="#">${prodId}</a></td>`;
                    str += `<td value="${prodName}">${prodName}</td>`;
                    str += `<td value="${prodPrice}">${prodPrice}</td>`;
                    str += `<td><input type="button" value="구입" id="${prodId}"></td>`;
                    str += `</tr>`;
                });

                // $("#listTable tr:gt(0)").remove();
                $("#produectTable tr:eq(0)").after(str);

                $("a").css("textDecoration", "none");
            }, //성공했을 때 함수

            error: function (err) {
                alert(err + "발생했습니다.")
            }//오류발생했을 때 함수 callback함수
        });   // ajax 끝
    };  // selectAll() 함수 끝
    $(document).on("click", "[value='구입']", function () {
        // alert();
        if (confirm("구입하실래요?")) {
            // ajax한다.
            IMP.request_pay({
                pg: 'html5_inicis',   // pg사 KG이니시스
                pay_method: 'card',   // 결제 방식
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

    selectAll();
    payList();
});  // ready 끝


function payList() {
    $.ajax({
        url: "../payList",   		 //서버요청주소
        type: "get",  								 //전송방식(get.post, put, delete)
        dataType: "json",   						//서버가 응답해주는 데이터의 타입(html, text, xml, json 중의 한 개 )
        // data: {id: $(this).val()},											//서버에게 보낼 parameter 정보
        success: function (result) {
            // alert(result);
            var str = "";
            $.each(result, function (index, dto) {
                str += `<tr>`;
                str += `<td>${dto.impUid}</td>`;
                str += `<td>${dto.merchantUid}</td>`;
                str += `<td>${dto.payStatus}</td>`;
                str += `<td>${dto.cardNumber}</td>`;
                str += `<td>${dto.cardName}</td>`;
                str += `<td>${dto.cardQuota}</td>`;
                str += `<td>${dto.payPrice}</td>`;
                str += `</tr>`;
            });

            // $("#listTable tr:gt(0)").remove();
            $("#cashListTable tr:eq(0)").after(str);

            $("a").css("textDecoration", "none");
        }, //성공했을 때 함수

        error: function (err) {
            alert(err + "발생했습니다.")
        }//오류발생했을 때 함수 callback함수
    });   // ajax 끝
}
