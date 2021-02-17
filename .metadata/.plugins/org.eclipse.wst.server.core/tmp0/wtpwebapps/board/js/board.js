/**
 * 
 */

currentPage = 1;

insertBoard = function () {
	$.post(
			'/board/Insert.do',
			$('#wform').serializeJSON(),
			function (res) {
				//alert(res.sw);
				//전송 성공 했을때 모달 창 닫기
				$('#writeModal').modal('hide');
				$('.txt').val("");
				readPageServer(1);
			},
			'json'
			
	)
}

readPageServer = function (cpage) {
	
	$.ajax({
		url : '/board/List.do',
		type : 'post',
		data : {'cpage' : cpage},
		success : function (res) {
			code = '<div class="panel-group" id="accordion">';

			$.each(res.datas, function (i, v) {
				code += '<div class="panel panel-default">';
				code += '	<div class="panel-heading">';
				code += '		<h4 class="panel-title">';
				code += '			<a data-toggle="collapse" data-parent="#accordion" href="#collapse' + v.num + '">' + v.subject + '</a>';
				code += '		</h4>';
				code += '	</div>';
				
				code += '	<div id="collapse' + v.num + '" class="panel-collapse collapse">';
				code += '	<div class="panel-body">';
				code += '		<p class="p1">';
				code += '			작성자 : ' + v.writer + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '			이메일 : ' + v.mail + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '			작성일 : ' + v.date + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '			조회수 : ' + 0 ;
				code += '		</p>';

				code += '		<p class="p2">';
				code += '			<button idx="' + v.num + '" type="button" name="modify" class="action">수정</button>';
				code += '			<button idx="' + v.num + '" type="button" name="delete" class="action">삭제</button>';
				code += '		</p>';

				code += '		<p class="p3">';
				code += 			v.cont;
				code += '		</p>';

				code += '		<p class="p4">';
				code += '			<textarea cols="60"></textarea>';
				code += '			<button idx="' + v.num + '" type="button" name="reply" class="action">등록</button>';
				code += '		</p>';

				code += ' 		</div>';
				code += '   </div>';
				code += ' </div>';
			})
			code += ' </div>';
			
			$('.box').html(code);
			
			//이전 버튼 출력 - 1보다 클 경우에만 출력
			$('#pagelist').empty();
			
			if(res.startp > 1){
			 pager ='<ul class="pul pager">';
			 pager +='<li><a class="prev" href="#">Previous</a></li>';
			 pager +='</ul>';
			 
			 $('#pagelist').append(pager);
				
			}
			
			//페이지 번호 출력
			pager = '<ul class="pul pagination pager">';
			for(i=res.startp; i<=res.endp; i++){
				if(currentPage == i){
					pager += '<li class="active"><a class="paging" href="#">' + i + '</a></li>';
				}else{
					pager += '<li><a class="paging" href="#">' + i + '</a></li>';
				}
			}
			
			pager +='</ul>';
			$('#pagelist').append(pager);
			
			//다음 버튼 출력
			if(res.endp < res.totalp){
				 pager ='<ul class="pager">';
				 pager +='<li><a class="next" href="#">Next</a></li>';
				 pager +='</ul>';
				 
				 $('#pagelist').append(pager);
					
				}
			
			
		},
		error : function (xhr) {
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
		
	})
}


readServer = function () {

	$.ajax({
		url : '/board/List.do',
		type : 'get',
		success : function (res) {
			code = '<div class="panel-group" id="accordion">';

			$.each(res, function (i, v) {
				code += '<div class="panel panel-default">';
				code += '	<div class="panel-heading">';
				code += '		<h4 class="panel-title">';
				code += '			<a data-toggle="collapse" data-parent="#accordion" href="#collapse' + v.num + '">' + v.subject + '</a>';
				code += '		</h4>';
				code += '	</div>';
				
				code += '	<div id="collapse' + v.num + '" class="panel-collapse collapse">';
				code += '	<div class="panel-body">';
				code += '		<p class="p1">';
				code += '			작성자 : ' + v.writer + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '			이메일 : ' + v.mail + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '			작성일 : ' + v.date + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '			조회수 : ' + 0 ;
				code += '		</p>';

				code += '		<p class="p2">';
				code += '			<button type="button" name="modify" class="action">수정</button>';
				code += '			<button type="button" name="delete" class="action">삭제</button>';
				code += '		</p>';

				code += '		<p class="p3">';
				code += 			v.cont;
				code += '		</p>';

				code += '		<p class="p4">';
				code += '			<textarea cols="60"></textarea>';
				code += '			<button type="button" name="reply" class="action">등록</button>';
				code += '		</p>';

				code += ' 		</div>';
				code += '   </div>';
				code += ' </div>';
			})
			code += ' </div>';
			
			$('.box').html(code);
		},
		error : function (xhr) {
			alert("상태" + xhr.status);
		},
		dataType : 'json'


	})
}