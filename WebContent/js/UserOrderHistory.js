function selectAll() {
    console.log($("#userId").val());
    // 전체검색
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

            // this.orderNo = orderNo;
            // this.orderPrice = orderPrice;
            // this.orderAddr = orderAddr;
            // this.orderZipCode = orderZipCode;
            // this.orderRecipientName = orderRecipientName;

            $.each(result, function (index, dto) {
                // alert(index + ", " + item + ", " + item.name);
                // alert(result); // [object] [object]
                var prodId = dto.orderNo;
                console.log(prodId);
                console.log(typeof prodId);
                str += `<tr>`;
                str += `<td style="color:black;">${dto.orderNo}(${prodId.toString().substr(0, 5)})</td>`;
                str += `<td style="color:black;">${dto.orderPrice}</td>`;
                str += `<td style="color:black;">결제완료</td>`;
                // str += `<td style="color:black;">${dto.orderZipCode}</td>`;
                str += `<td style="color:black;">${dto.orderAddr}</td>`;
                // str += `<td style="color:black;">${dto.orderRecipientName}</td>`;
                str += `</tr>`;
            });

            $("#cashListTable tr:gt(0)").remove();
            $("tbody").html(str);

        }, //성공했을 때 함수

        error: function (err) {
            alert(err + "발생했습니다.")
        }//오류발생했을 때 함수 callback함수
    });   // ajax 끝

};  // selectAll() 함수 끝