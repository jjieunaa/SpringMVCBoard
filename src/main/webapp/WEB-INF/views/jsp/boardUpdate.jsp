<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../jsp/includes/header.jsp"%>

<script src="/resources/js/reply.js"></script>

<script>
	var bnoValue = "<c:out value='${boardVO.bno}' />";

	// insert 테스트
	/*
	$(function() {	
		replyService.insertReplyVO(
			{reply:"JS Test", replyer:"tester", bno:bnoValue},
			function(result) {
				alert("result: " + result);
			}
		);		
	});
	*/
	
	// list 테스트
	/*
	replyService.listReplyVO(
			{bno:bnoValue, page:1},
			function(list) {
				var listLenth =list.length;
				for (var i=0, len=listLenth||0; i<len; i++) {
					console.log(list[i]);
				}
			}
	);
	*/
	
	// delete 테스트
	/*
	replyService.deleteReplyVO(
		9,
		function(count) {
			console.log(count);
		}
	);
	*/
	
	// update 테스트
	/*
	replyService.updateReplyVO({
		rno: 10,
		bno: bnoValue,
		reply: "수정된 댓글",
		replyer: "수정한 사람"
	}, function(result) {
		alert(result);
	})
	*/
	
	// selecet 테스트
	replyService.selectReplyVO(10, function(data) {
		console.log(data);
	})
</script>

<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Update</h1>
  </div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">

			<div class="panel-heading">Board Update</div>
			<div class="panel-body">

				<form id="updateForm" role="form" action="/board/updateProc" method="post">
		      
					<input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum }"/>'>
			        <input type='hidden' name='amount' value='<c:out value="${cri.amount }"/>'>
				    <input type='hidden' name='type' value='<c:out value="${cri.type }"/>'>
					<input type='hidden' name='keyword' value='<c:out value="${cri.keyword }"/>'>
					<input type='hidden' name='mappingURI' value='update' />
					
					<div class="form-group">
					  <label>Bno</label> 
					  <input class="form-control" name='bno' 
					     value='<c:out value="${boardVO.bno }"/>' readonly="readonly">
					</div>
			
					<div class="form-group">
					  <label>Title</label> 
					  <input class="form-control" name='title' 
					    value='<c:out value="${boardVO.title }"/>' >
					</div>
			
					<div class="form-group">
					  <label>Text area</label>
					  <textarea class="form-control" rows="3" name='content' ><c:out value="${boardVO.content}"/></textarea>
					</div>
			
					<div class="form-group">
					  <label>Writer</label> 
					  <input class="form-control" name='writer'
					    value='<c:out value="${boardVO.writer}"/>' readonly="readonly">            
					</div>
			
					<div class="form-group">
					  <label>RegDate</label> 
					  <input class="form-control" name='regDate'
					    value='<fmt:formatDate pattern = "yyyy/MM/dd" value = "${boardVO.regdate}" />'  readonly="readonly">            
					</div>
			
					<div class="form-group">
					  <label>Update Date</label> 
					  <input class="form-control" name='updateDate'
					    value='<fmt:formatDate pattern = "yyyy/MM/dd" value = "${boardVO.updateDate}" />'  readonly="readonly">            
					</div>
			
					<button id="updateBtn" class="btn btn-default">Update</button>
					<button id="deleteBtn" bno="${boardVO.bno}" class="btn btn-danger">Delete</button>
					<button id="listBtn" pagenum="${param.pageNum}" class="btn btn-info">List</button>
				</form>
			</div>
		</div>
	</div>
</div>

<%@include file="../jsp/includes/footer.jsp"%>
