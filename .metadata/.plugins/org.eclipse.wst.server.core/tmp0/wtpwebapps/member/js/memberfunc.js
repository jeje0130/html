/**
 * 
 */
function okpro(vinput) {
		vsp = $(vinput).parents('.form-group').find('.sp');
		
		$(vsp).empty();
		$('<img>',{
			'src' : '../images/작은이미지.png',
			'width' : '20px',
			'height' : '20px'
		}).appendTo(vsp);
		
		//올바른 형식이 아닙니다 영역 지우기
		$(vinput).parents('.form-group').find('.msg').html("");
}
	
function nopro(vinput, text) {
		$(vinput).parents('.form-group').find('.msg').html(text).css('color','red');
		
		$(vinput).parents('.form-group').find('.sp').empty();
}



function idcheck() {
	idvalue = $('#id').val().trim();

	if(idvalue.length < 1){
		alert("id를 입력하세요");
		return false;
	}

	$.ajax({
		url : '/member/IDcheck',
		type : 'post',
		data : {"id" : idvalue},
		success : function (res) {
			$('#idspan').html(res.sw).css('color','red');
		},
		error : function (xhr) {
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	})
}

//우편번호 modal에서 돔 입력후 확인버튼 클릭 이벤트
function dongsearch() {
	//입력한 값 가져오기
	dongvalue = $('#dong').val().trim();

	//서버로 전송(요청)
	$.ajax({
		url : '/member/DongSearch.do',
		data : {'dong' : dongvalue},
		type : 'post',
		success : function (res) {

			code = "<table class='table table-bordered' border='1'>";
			code += "<tr><td>우편번호</td>";
			code += "<td>주소</td>";
			code += "<td>번지</td></tr>";

			$.each(res, function (i, v) {
				code += "<tr class='ziptr'><td>" + v.code + "</td>";
				code += "<td>" + v.addr + "</td>";
				code += "<td>" + v.bunji + "</td></tr>";
			})
			code += "</table>";

			$('#result1').html(code);

		},
		error : function (xhr) { 
			alert("상태 : "+ xhr.status); //200(응답 성공/데이터 형식 오류), 404, 403
		},
		dataType : 'json'
	})
}

//modal 결과에서 원하는 행(주소)를 선택했을때 이벤트
//동적으로 새롭게 생성된 요소 - delegate 방식 (부모선택 먼저!)
function zipselect(zip) {
	//선택
	zipcode = $('td:eq(0)', zip).text();
	addr = $('td:eq(1)', zip).text();

	//폼에  출력
	$('#zip').val(zipcode);
	$('#add1').val(addr);

	//모달 창 닫기
	$('#myModal').modal('hide');
	//모달 창 내용 지우기 input - val("") / div - empty() (remove()사용하면 나중에 못사용)
	$('#dong').val("");
	$('#result1').empty();

}


//제출버튼 클릭하면
//$('button[type=submit]')
//$('button:submit').on('click', function () {})
function fsubmit() {
	
	//submit의 고유 기능 방지
	event.preventDefault();

	/* 
			//입력한 모든 값(9개)을 가져온다 - val()
			idvalue = $('#id').val().trim();
			namevalue = $('#name').val().trim();
			passvalue = $('#pwd').val().trim();
			hpvalue = $('#hp').val().trim();
			mailvalue = $('#email').val().trim();
			birvalue = $('#bir').val().trim();
			zipvalue = $('#zip').val().trim();
			add1value = $('#add1').val().trim();
			add2value = $('#add2').val().trim();

			datas = {"mem_id" : idvalue, 
					 "mem_name" : namevalue,
					 "mem_pass" : passvalue,
					 "mem_hp" : hpvalue,
					 "mem_mail" : mailvalue,
					 "mem_bir" : birvalue,
					 "mem_zip" : zipvalue,
					 "mem_add1" : add1value,
					 "mem_add2" : add2value 
			}
			console.log(datas);

			datas = "mem_id=" + idvalue + "&mem_name=" + namevalue + "&mem_pass=" + passvalue +
			"&mem_hp=" + hpvalue + "&mem_mail=" + mailvalue + "&mem_bir=" + birvalue +
			"&mem_zip=" + zipvalue + "&mem_add1=" + add1value + "&mem_add2=" + add2value

			console.log(datas);
	 */

	/* console.log($('#ff').serialize());
			 console.log($('#ff').serializeArray());
			 console.log($('#ff').serializeJSON()); */


	$.ajax({
		url : '/member/Insert.do',
		method : 'post',
		data : $('#ff').serializeJSON(),
		success : function (res) {
			$('#subspan').html(res.b).css('color','red');
		},
		error : function (xhr) {
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	})

}


