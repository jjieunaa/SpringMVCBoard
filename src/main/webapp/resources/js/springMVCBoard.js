$(function() {

	// form 안의 button은 기본적으로 submit 이벤트를 발생시킨다.
	// 기본 이벤트를 방지해야 한다.
	$("button").click(function(event) {
		event.preventDefault();
	});
	
	// 등록 버튼 클릭 시 등록 화면으로 이동
	$("#regBtn").click(function(event) {
		location.href = "/board/boardInsert";
	});
	
	// 수정 버튼 클릭 시 수정 처리
	$("#updateBtn").click(function(event) {
		if(confirm("정말 수정하실건가요?")) {
			$("#updateForm").submit();
		} else {
			return false;
		}	
	});
	
	// 삭제 버튼 클릭 시 삭제 처리
	$("#deleteBtn").click(function(event) {
		if(confirm("정말 삭제하실건가요?")) {
			location.href = "/board/delete?bno="+$(this).attr("bno");
		} else {
			return false;
		}
	});
	
	// 목록 버튼 클릭 시 목록 화면으로 이동
	$("#listBtn").click(function(event) {
		location.href = "/";
	});
	
});