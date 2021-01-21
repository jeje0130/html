/**
 * 
 */

function check() {
	
	//--------------------------이름체크----------------------------
	//입력한 값 가져오기 - 이름
	namevalue = document.getElementById('name').value;
	
	
	//공백 체크
	if(namevalue.trim().length < 1){ 	//trim() : 공백 방지
		alert("이름을 입력하세요");
		document.getElementById('name').focus();
		return false;
	}
	//정규식
	namereg = /^[가-힣]+$/;
	
	//비교 test() - true/false리턴
	
	if(!(namereg.test(namevalue))){
		alert("이름 형식오류");
		document.getElementById('name').focus();
		return false;
	}
	
	//길이 체크
	if(namevalue.trim().length < 2 || namevalue.trim().length > 7){
		alert("이름 2~7자리 사이로 입력하세요");
		return false;
	}
	
	//-------------------------아이디체크-----------------------------
	// 값 가져오기
	idvalue = document.getElementById('id').value;
	
	
	//공백
	if(idvalue.trim().length < 1){
		alert("아이디를 입력하세요");
		return false;
	}
	
	//길이체크
	if(idvalue.trim().length < 4 || idvalue.trim().length > 12){
		alert("아이디를 4~12자리 사이로 입력하세요");
		return false;
	}
	
	//정규식 - 소문자로 시작 + 소문자,대문자,숫자
	idreg = /^[a-z][a-zA-Z0-9]{3,11}$/;
	
	
	//비교 test() - true/false리턴
	if(!(idreg.test(idvalue))){
		alert("아이디 형식오류");
		return false;
	}
	
	//-------------------------이메일체크-----------------------------
	// 값 가져오기
	emailvalue = document.getElementById('email').value;
	
	
	//공백
	if(emailvalue.trim().length < 1){
		alert("이메일을 입력하세요");
		return false;
	}
	
	//정규식
	emailreg = /^[a-zA-Z0-9]+@[a-zA-Z0-9-_]+(\.[a-z]+){1,2}$/;
	
	//비교 test() - true/false리턴
	if(!(emailreg.test(emailvalue))){
		alert("이메일 형식오류");
		return false;
	}
	
	
	//-------------------------전화번호체크-----------------------------
	// 값 가져오기
	telvalue = document.getElementById('tel').value;
	
	
	//공백
	if(telvalue.trim().length < 1){
		alert("전화번호를 입력하세요");
		return false;
	}
	
	//정규식
	telreg = /^\d{3}-\d{4}-\d{4}$/;
	
	//비교 test() - true/false리턴
	if(!(telreg.test(telvalue))){
		alert("전화번호 형식오류");
		return false;
	}
	
	
	//-------------------------비밀번호체크-----------------------------
	// 값 가져오기
	passvalue = document.getElementById('pass').value;
	
	
	//공백
	if(passvalue.trim().length < 1){
		alert("비밀번호를 입력하세요");
		return false;
	}
	
	//길이체크
	if(passvalue.trim().length < 8 || passvalue.trim().length > 15){
		alert("비밀번호를 8~15자리 사이로 입력하세요");
		return false;
	}
	
	
	
	/* 전방 탐색 ==>   찾을 대상 ?= 기준점   
	 * (?=.*[a-z])   ==> Aasd 소문자앞에  0번이상오는 문자
	 * (?=.*[A-Z])   ==> asdGG  
	 * (?=.*[0-9])   ==> 9  k7 
	 * (?=.*[~!@#$%^&*()_+])   ==>  */
	
	//정규식 - 영문 대소문자, 숫자, 특수문자를 반드시 한대 이상씩 입력
	passreg = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[~!@#$%^&*()]).{8,15}$/;
	
	//비교 test() - true/false리턴
	if(!(passreg.test(passvalue))){
		alert("비밀번호 형식오류");
		return false;
	}

	
	//-------------------------생일 체크-----------------------------
	// 값 가져오기
	birvalue = document.getElementById('birthday').value;
	
	//공백
	if(birvalue.trim().length < 1){
		alert("생일을 입력하세요");
		return false;
	}
	//나이 체크
	birth = new Date(birvalue);
	today = new Date();
	
	//시간의 간격 - getTime();
	times = today.getTime()-birth.getTime();
	
	times = parseInt(times/1000/60/60/24/365);
	
	if(times < 13){
		alert("14세 이상 가능합니다");
		return false;
	}
	
	return true;
	
}
















