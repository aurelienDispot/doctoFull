<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%-- ETAPE 5 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des évaluations</title>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/css/all.css"/>">
</head>
<body>
	<div class="container-fluid">
		<div class="card mt-3">
			<div class="card-header bg-info text-white">
				<h2>Liste des évaluations</h2>
			</div>
			<div class="card-body">
				<table id="evaluationTable" class="table table-striped">
					<thead>
						<tr>
							<th>Identifiant</th>
							<th>Comportementale</th>
							<th>Technique</th>
							<th>Commentaires</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${mesEvaluations}" var="eval">
							<c:url value="/evaluation/edit" var="editUrl">
								<c:param name="id" value="${eval.id}"/>
							</c:url>
							<c:url value="/evaluation/delete" var="deleteUrl">
								<c:param name="id" value="${eval.id}"/>
							</c:url>
							<tr>
								<td>${eval.id}</td>
								<td>${eval.comportemental}</td>
								<td>${eval.technique}</td>
								<td>${eval.commentaires}</td>
								<td><div class="btn-group btn-group-sm">
									<a href="${editUrl}" class="btn btn-primary"><i class="fa fa-edit"></i></a>
									<a href="${deleteUrl}" class="btn btn-danger"><i class="fa fa-trash"></i></a>
								</div></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<c:url value="evaluation/add" var="addUrl"/>
			<div class="card-footer">
				<a href="${addUrl}" class="btn btn-success btn-lg">
					<i class="fa fa-plus"></i>
				</a>
			</div>
		</div>
	</div>
	
	<script src="<c:url value="/js/jquery-3.5.0.min.js"/>"></script>
	<script src="<c:url value="/js/bootstrap.bundle.min.js"/>"></script>
</body>
</html>