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
	
	// 리스트 페이지에서 제목 클릭 시 조회 페이지로 이동
	formSetting(".selectLink", ["select"], "/board/select");
	
	// 리스트 페이지에서 페이지 번호 링크 처리
	formSetting(".pageNumLink", ["list"], "/board/list");
	
	// 조회 페이지에서 목록 버튼 클릭 처리
	formSetting("#listBtn", ["list"], "/board/list");
	
	// 검색 버튼 클릭 시 검색 폼 submit
	$("#searchBtn").click(function(event){
		$("#searchForm").submit();
	});
});

// 엘리먼트 타입, CSS 클래스 명, Input 엘리먼트의 name 속성의 값들, 이동할 경로
function formSetting(cssType, nameValues, actionURI) {
	$(cssType).click(function(event){
		event.preventDefault();
		$("input[name='pageNum']").val($(this).attr("pagenum"));
		$("input[name='action']").val(nameValues[0]);
		$("input[name='bno']").val($(this).attr("bno"));
		$("#actionForm").attr("action", actionURI);
		$("#actionForm").submit();
	});
}