<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../jsp/includes/header.jsp"%>

<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Select</h1>
  </div>
</div>

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">Board Select Page</div>
      <div class="panel-body">

          <div class="form-group">
          <label>Bno</label> <input class="form-control" name='bno'
            value='<c:out value="${boardVO.bno }"/>' readonly="readonly">
        </div>

        <div class="form-group">
          <label>Title</label> <input class="form-control" name='title'
            value='<c:out value="${boardVO.title }"/>' readonly="readonly">
        </div>

        <div class="form-group">
          <label>Text area</label>
          <textarea class="form-control" rows="3" name='content'
            readonly="readonly"><c:out value="${boardVO.content}" /></textarea>
        </div>

        <div class="form-group">
          <label>Writer</label> <input class="form-control" name='writer'
            value='<c:out value="${boardVO.writer }"/>' readonly="readonly">
        </div>

		<button data-oper='modify' class="btn btn-default">Modify</button>
		<button data-oper='list' class="btn btn-info">List</button>

		<form id='operForm' action="/boad/update" method="get">
  			<input type='hidden' id='bno' name='bno' value='<c:out value="${boardVO.bno}"/>'>
  			<input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum}"/>'>
  			<input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
  			<input type='hidden' name='keyword' value='<c:out value="${cri.keyword}"/>'>
  			<input type='hidden' name='type' value='<c:out value="${cri.type}"/>'>  
		</form>
      </div>
    </div>
  </div>
</div>

<%@include file="../jsp/includes/footer.jsp"%>
