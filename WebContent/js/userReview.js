function payStateOp() {

    return $("#payState").val()
};

// $(document).on("change", "#payState", function () {
//     // let aa = $(this).val();
//     payList(1)
// });

$(document).on("change", "#payState", function () {
    // let aa = $(this).val();
    searchDateFunc(1);
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


    let payState = $("#payState").val();

    $.ajax({
        url: "../userPayment",   		 //서버요청주소
        type: "get",  								 //전송방식(get.post, put, delete)
        dataType: "json",   						//서버가 응답해주는 데이터의 타입(html, text, xml, json 중의 한 개 )
        data: {
            userId: $("#userId").val()
        },											//서버에게 보낼 parameter 정보
        success: function (result) {
            // alert(result);
            var str = "";

            $.each(result, function (index, dto) {
                // alert(index + ", " + item + ", " + item.name);
                str += `<tr>`;
                str += `<td>${index + 1}</td>`;
                str += `<td><a href="#">${dto.id}</a></td>`;
                str += `<td>${dto.name}</td>`;
                str += `<td>${dto.age}</td>`;
                str += `<td>${dto.tel}</td>`;
                str += `<td>${dto.addr}</td>`;
                str += `<td><input type="button" value="삭제" id="${dto.id}"></td>`;
                str += `</tr>`;
            });

            $("#listTable tr:gt(0)").remove();
            $("#listTable tr:eq(0)").after(str);

            $("a").css("textDecoration", "none");
        }, //성공했을 때 함수

        error: function (err) {
            alert(err + "발생했습니다.")
        }//오류발생했을 때 함수 callback함수
    });   // ajax 끝

}


