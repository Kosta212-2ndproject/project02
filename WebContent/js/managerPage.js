function payStateOp() {

    return $("#payState").val()
};

$(document).on("change", "#payState", function () {
    // let aa = $(this).val();
    payList(1)
});

function cardStatus(status) {
    if (status == "paid") {
        return `<span class="badge badge-success" style="font: 13px bolid; font-weight: bold;">결제완료</span><br>`
    } else if (status == "cancelled") {
        return `<span class="badge badge-danger" style="font: 13px bold; font-weight: bold;">전액취소</span><br>`
    } else if (status == "failed") {
        return `<span class="badge badge-primary" style="font: 13px bold; font-weight: bold;">결제실패</span><br>`
    } else if (status == "ready") {
        return `<span class="badge badge-info" style="font: 13px bold; font-weight: bold;">미결제</span><br>`
    }
}

function unixTimeStampFunc(time) {
    var date = new Date(time);
    var year = date.getFullYear();
    var month = "0" + (date.getMonth() + 1);
    var day = "0" + date.getDate();
    var hour = "0" + date.getHours();
    var minute = "0" + date.getMinutes();
    var second = "0" + date.getSeconds();
    return year + "-" + month.substr(-2) + "-" + day.substr(-2) + " " + hour.substr(-2) + ":" + minute.substr(-2) + ":" + second.substr(-2);
}

function cardQuotaFunc(cardQuota) {
    switch (cardQuota) {
        case 0:
            cardQuota = "일시불";
            break;
        case 1:
            cardQuota = "1개월";
            break;
        case 2:
            cardQuota = "2개월";
            break;
        case 3:
            cardQuota = "3개월";
            break;
        case 4:
            cardQuota = "4개월";
            break;
        case 5:
            cardQuota = "5개월";
            break;
        case 6:
            cardQuota = "6개월";
            break;
    }
    return cardQuota;
}

function cancelAmount(amount) {
    return (amount > 0) ? amount.toLocaleString() : '0';
}

function payList(e) {
    console.log("clicked: " + e);
    // console.log($(states).val());
    let aa = $("#payState").val();
    $.ajax({
        url: "../payHistory",   		 //서버요청주소
        type: "get",  								 //전송방식(get.post, put, delete)
        dataType: "json",   						//서버가 응답해주는 데이터의 타입(html, text, xml, json 중의 한 개 )
        data: {
            option: aa,
            buttonOption: e
        },											//서버에게 보낼 parameter 정보
        success: function (result) {
            // console.log(result);
            var str = "";
            $.each(result.list, function (index, value) {
                // 가맹점 고유번호(주문번호)
                str += `<tr>`;
                str += `<td class="text-center">${index+1}</td>`;
                str += `<td class="text-left">${value.impUid}<br>${value.merchantUid}</td>`;

                // 결제금액(취소금액)
                str += `<td class="text-left">`
                str += `${cardStatus(value.status)}`;
                str += `<span style="font-size: 15px" id="totalPrice">￦${value.amount.toLocaleString()}</span><br>`;
                str += `<span style="color: red">(₩${cancelAmount(value.cancelAmount)})</span><br>`;
                str += `</td>`;

                // 구분(클릭)
                str += `<td class="text-left">`;
                str += `<button type="button" style="font: 12px bold; font-weight: bold;" class="badge badge-info" data-container="body" data-toggle="UserAgent" data-placement="right" data-content="${value.userAgent}">${value.channel}</button><br>`;
                if (value.cardType == 0) {
                    str += `<span class="badge badge-warning" style="font: 12px bold; font-weight: bold;">신용카드</span><br>`;
                } else {
                    str += `<span class="badge badge-warning" style="font: 12px bold; font-weight: bold;">카드</span><br>`;
                }
                str += `</td>`;

                // PG사 상점아이디
                str += `<td class="text-left">`;
                str += `<span class="badge badge-default" style="font: 12px bold; font-weight: bold;">${value.pgProvider}</span><br>`;
                str += `<span style="font: 13px bold; font-weight: bold;">(${value.pgId})</span>`;
                str += `</td>`;

                // PG승인번호 (카드사 승인번호)
                str += `<td class="text-left" style="font-size: 14px">`;
                if (value.status != 'failed') {
                    str += `<span>${value.pgTid}</span><br>`;
                    str += `<span>카드번호: ${value.cardNumber}</span>`;
                }
                str += `</td>`;

                // 결제상세
                str += `<td>`;
                if (value.status != 'failed') {
                    str += `${value.cardName}<br>(${cardQuotaFunc(value.cardQuota)})`;
                }
                str += `</td>`;

                // 주문명 구매자(이름/이메일/휴대폰/주소)
                str += `<td style="font-size: 13px">`;
                str += `<b>${value.name} <br>`;
                str += `${value.buyerName} <br>`;
                str += `${value.buyerEmail} <br>`;
                str += `${value.buyerTel} <br>`;
                str += `[${value.buyerPostcode}]<br>`;
                str += `<span style="font-size: 12px">${value.buyerAddr}<b/></span>`;
                str += `</td>`;

                // 결제시각
                if (value.status != 'failed') {
                    str += `<td> ${unixTimeStampFunc(value.paidAt.time)}</td>`;
                } else {
                    str += `<td></td>`;
                }

                // 상태
                str += `<td>`;
                if (value.status == 'cancelled') {
                    str += `<a href="javascript:void(window.open('${value.receiptUrl}', 'INICIS Receipt Auth','width=430, height=600'))" id="cancelReceipt" class="badge badge-warning" style="font-size: 13px">환불영수증</a><br>`;
                } else {
                    str += `${cardStatus(value.status)}`;
                }
                if (value.status == 'paid') {
                    str += `<a href="#" id="cancelBtn" name="${value.merchantUid}" class="badge badge-primary" data-toggle="modal" data-target="#exampleModal" style="font: 13px bold; font-weight: bold;">취소하기</a>`;
                } else if (value.status == 'cancelled') {
                    str += `[${unixTimeStampFunc(value.cancelledAt.time)}] ₩${value.cancelAmount}<br> (${value.cancelReason})`;
                } else if (value.status == 'failed') {
                    str += `사용자가 결제를 취소했습니다.`;
                }
                str += `</td>`;
                str += `</tr>`;

            });

            var totalCount = result.total;
            // var totalShow = `<span class="text-left" style="color: white; font: 15px bold">전체: ${totalCount}건</span>`;

            $("#totalShowTable").text("전체 : " + totalCount + " 건");
            //
            // $("#totalShow").empty();
            // $("#totalShow").append(totalShow);

            $("#cashListTable tr:gt(0)").remove();
            $("tbody").after(str);

            const itemLimit = 5;
            const pageLimit = 10;
            var pageTotalCount = Math.ceil(result.total / itemLimit); // 144 / 5 = 28.8; Math.ceil() 는 올림 즉 pageTotalCount = 29;
            var currentPage = result.previous + 1; // 0 + 1 = 1;

            var offset = Math.trunc(currentPage / (pageLimit + 0.1)); // 1 / 10.1 = 0.09
            var pageStartNumber = offset * pageLimit + 1; // 0 * 5 + 1 = 1;
            var pageEndNumber;

            if (pageStartNumber + pageLimit > pageTotalCount) // 1 + 5 > 6
                pageEndNumber = pageTotalCount;
            else
                pageEndNumber = pageStartNumber + pageLimit - 1; // pageEndNumber = 1 + 5 - 1;

            var left = pageStartNumber - 1;
            var right = pageEndNumber + 1;

            // var form = document.getElementById("button-page");
            $("#button-page").empty();
            $("#pageBtns").empty();
            // $("#pageBtns li:gt(0)").remove();

            if (pageStartNumber != 1) {
                // var btnLeft = document.createElement('button');
                // btnLeft.value = left;
                // btnLeft.innerText = "<";
                // btnLeft.onclick = function () {
                //     payList(left);
                //     return false;
                // };
                // form.appendChild(btnLeft);


                var btnLefts = `<li class="page-item "><a class="page-link" href="javascript:payList(${left});">Previous</a></li>`;
                $("#pageBtns").append(btnLefts);
            }

            // var arr = new Array();
            for (let i = pageStartNumber; i <= pageEndNumber; i++) {
                //
                // var btn = document.createElement('button');
                // btn.value = i;
                // btn.innerText = i;
                // btn.onclick = function () {
                //     payList(i);
                //     return false;
                // }
                // form.appendChild(btn);
                let btnNumber;
                var currentNum = i;
                if(e == i) {
                    btnNumber = `<li class="page-item active"><a class="page-link" href="javascript:payList(${i});">${i}</a></li>`;
                } else {
                    btnNumber = `<li class="page-item"><a class="page-link" href="javascript:payList(${i});">${i}</a></li>`;
                }

                // let btnNumber = `<li class="page-item"><a class="page-link" href="javascript:payList(${i});">${i}</a></li>`;
                $("#pageBtns").append(btnNumber);
            }


            if (pageEndNumber != pageTotalCount) {
                // var btnRight = document.createElement('button');
                // btnRight.value = right;
                // btnRight.innerText = ">";
                // btnRight.onclick = function () {
                //     payList(right);
                //     return false;
                // };
                // form.appendChild(btnRight);

                var btnRight = `<li class="page-item"><a class="page-link" href="javascript:payList(${right});">Next</a></li>`;
                $("#pageBtns").append(btnRight);
            }


        }, //성공했을 때 함수

        error: function (request, status, error) {
            alert("code = " + request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
        }
    });   // ajax 끝
}


$(function () {
    let orderNo;
    let totalPrice;
    $(document).on("click", "#cancelBtn", function () {
        orderNo = $(this).attr("name");
        totalPrice = $("#totalPrice").val();
        alert("orderNo: " + orderNo);
        alert("totalPrice: " + totalPrice);
        $("#exampleRadios2").prop("checked", true);
    });

    $('#r_cancel_all').on('click', function (e) {    // modal 버튼
        e.preventDefault();

        // alert("orderNao = " + orderNo)
        $.ajax({
            url: '../paymentCancel',
            type: 'post',
            data: {
                reason: $("#cancel_reason").val(),
                orderNo: orderNo,
            },
            success: function (data) {
                alert("result: " + data);
                alert("취소가 되었습니다.");
            }
        });
    });

    // $('[data-toggle="UserAgent"]').popover();

});
