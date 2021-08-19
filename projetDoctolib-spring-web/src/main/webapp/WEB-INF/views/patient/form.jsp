<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edition de l'évaluation</title>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/css/all.css"/>">
</head>
<body>
	<div class="container-fluid">
		<div id="evaluationForm" class="card mt-3">
			<form action="<c:url value="/evaluation/save"/>" method="post">
				<input type="hidden" name="version" value="${eval.version}">
				<div class="card-header bg-info text-white">
					<h3>Edition de l'évaluation</h3>
				</div>
				<div class="card-body">
					<div class="form-group">
						<label for="id">Identifiant:</label> <input type="number" readonly
							class="form-control" id="id" name="id" value="${eval.id}">
					</div>
					<div class="form-group">
						<label for="comportemental">Note comportementale:</label> <input type="number"
							class="form-control" id="comportemental" name="comportemental"
							value="${eval.comportemental}">
					</div>
					<div class="form-group">
						<label for="promotion">Note technique:</label> <input type="number"
							class="form-control" id="technique" name="technique"
							value="${eval.technique}">
					</div>
					<div class="form-group">
						<label for="commentaires">Commentaires:</label> <input type="text"
							class="form-control" id="commentaires" name="commentaires"
							value="${eval.commentaires}">
					</div>
				</div>
				<div class="card-footer">
					<div class="btn-group btn-group-lg float-right">
						<button type="submit" class="btn btn-success">
							<i class="fa fa-check"></i>
						</button>
						<c:url value="/evaluation/cancel" var="cancelUrl"/>
						<a href="${cancelUrl}" type="button" class="btn btn-warning">
							<i class="fa fa-undo"></i>
						</a>
					</div>
				</div>
			</form>
		</div>

	</div>

	<script src="<c:url value="/js/jquery-3.5.0.min.js"/>"></script>
	<script src="<c:url value="/js/bootstrap.bundle.min.js"/>"></script>
</body>
</html>