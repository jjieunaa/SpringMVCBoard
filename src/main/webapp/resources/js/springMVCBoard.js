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
	
	// 목록 페이지에서 제목 클릭 시 조회 페이지로 이동
	addClickListener(".selectLink", "selectFromList", "/board/select");
	
	// 목록 페이지에서 페이지 번호 링크 처리
	addClickListener(".pageNumLink", "listFromPaging", "/board/list");
	
	// 조회 페이지에서 목록 버튼 클릭 시 목록 페이지로 이동
	addClickListener("#listBtn", "listFromSelect", "/board/list");
	
	// 목록 페이지에서 검색 버튼 클릭 시 목록 페이지로 이동
	addClickListener("#searchBtn", "listFromSearch", "/board/list");
	
	// 입력폼 submit/reset
	$(".boardInsertBtns").click(function() {
		if ($(this).attr("id")=="boardInsertSubmitBtn") {
			$("#boardInsertForm").submit();
		} else if ($(this).attr("id")=="boardInsertResetBtn") {
			document.forms["boardInsertForm"].reset();
		}		
	});

});

// 이벤트 타켓 엘리먼트, 명령, 이동할 경로
function addClickListener(element, command, action) {
	$(element).click(function(event){
		event.preventDefault();		
		$("input[name='pageNum']").val($(this).attr("pageNum"));
		$("input[name='bno']").val($(this).attr("bno"));
		$("input[name='type']").val($("select[name='type']").val());
		$("input[name='keyword']").val($("input[name='keyword']").val());		
		if (command=="listFromSearch") {
			$("input[name='pageNum']").val($("input[name='pn']").val());
		}		
		$("#actionForm").attr("action", action);
		$("#actionForm").submit();
	})
}
