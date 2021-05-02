function payStateOp() {

    return $("#payState").val()
}

$(document).on("change", "#payState", function () {
    // let aa = $(this).val();
    payList(1)
})

function cardStatus(status) {
    switch (status) {
        case "ready":
            status = "미결제";
            break;
        case "paid":
            status = "결제완료";
            break;
        case "failed":
            status = "결제실패";
            break;
        case "cancelled":
            status = "결제취소";
            break;
    }
    return status;
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
            console.log(result);
            var str = "";
            $.each(result.list, function (index, value) {
                str += `<tr>`;
                str += `<td>${value.impUid}</td>`;
                str += `<td>${value.merchantUid}</td>`;
                str += `<td>${cardStatus(value.status)}</td>`;
                str += `<td>${value.cardNumber}</td>`;
                str += `<td>${value.cardName}</td>`;
                str += `<td>${cardQuotaFunc(value.cardQuota)}</td>`;
                str += `<td id="totalPrice">${value.amount.toLocaleString()}원</td>`;
                if (value.status == 'paid') {
                    str += `<td><button type="button" name="${value.merchantUid}" id="cancelBtn" class="btn btn-outline-secondary" data-toggle="modal" data-target="#staticBackdrop" >취소하기</button></td>`;
                }
                str += `</tr>`;


            });
            $("#cashListTable tr:gt(0)").remove();
            $("#cashListTable tr:eq(0)").after(str);

            const itemLimit = 15;
            const pageLimit = 5;
            var pageTotalCount = Math.ceil(result.total / itemLimit); // 77 / 15 = 5.13; Math.ceil() 는 올림 즉 pageTotalCount = 6;
            var currentPage = result.previous + 1; // 0 + 1 = 1;

            var offset = Math.trunc(currentPage / (pageLimit + 0.1)); //(0/5+0.1); = 0
            var pageStartNumber = offset * pageLimit + 1; // 0 * 5 + 1 = 1;
            var pageEndNumber;

            if (pageStartNumber + pageLimit > pageTotalCount) // 1 + 5 > 6
                pageEndNumber = pageTotalCount;
            else
                pageEndNumber = pageStartNumber + pageLimit - 1; // pageEndNumber = 1 + 5 - 1;

            var left = pageStartNumber - 1;
            var right = pageEndNumber + 1;

            var form = document.getElementById("button-page");
            $("#button-page").empty();

            console.log();
            if (pageStartNumber != 1) {
                var btnLeft = document.createElement('button');
                btnLeft.value = left;
                btnLeft.innerText = "<";
                btnLeft.onclick = function () {
                    payList(left);
                    return false;
                };
                form.appendChild(btnLeft);
            }

            for (let i = pageStartNumber; i <= pageEndNumber; ++i) {
                var btn = document.createElement('button');
                btn.value = i;
                btn.innerText = i;
                btn.onclick = function () {
                    payList(i);
                    return false;
                }
                form.appendChild(btn);

            }

            if (pageEndNumber != pageTotalCount) {
                var btnRight = document.createElement('button');
                btnRight.value = right;
                btnRight.innerText = ">";
                btnRight.onclick = function () {
                    payList(right);
                    return false;
                };
                form.appendChild(btnRight);
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
        alert("totalPrice: " + totalPrice);
    });

    $('#modal_btn_cancel').on('click', function (e) {    // modal 버튼
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
                $(this).modal('hide');
            }
        });
    });

});
