<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Line chart</title>
<link href="resources/css/simple-sidebar.css" rel="stylesheet">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/jquery-ui.min.css">
<link rel="stylesheet" href="resources/css/jquery-ui.structure.min.css">
<link rel="stylesheet" href="resources/css/jquery-ui.theme.min.css">
<link rel="stylesheet" href="resources/css/dataTables.jqueryui.min.css">
<style>
#top-padding {
	padding-top: 50px;
}

#hidden {
	display: none;
}
</style>
</head>
<body>


	<!-- Sidebar -->

	<div class="container">
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="navbar-header">
				<ul class="nav navbar-nav">
					<li><a href="#"> NYC Causes of Death </a></li>
					<li><a href="/NYCLeadingCauses">Home</a></li>
					<li><a href="linechart">View Chart</a></li>
				</ul>
			</div>
		</nav>
	</div>


	<div id="top-padding">
		<table class="highchart" data-graph-container="#highchart-container"
			data-graph-type="line" data-graph-height="800"
			data-graph-container-before="1" class="display" id="hidden">

			<caption>NYC Leading Causes Of Death</caption>
			<thead>
				<tr>
					<th>Year</th>
					<c:forEach var="year" items='${years}'>
						<c:forEach var="yearlist" items='${map[year]}'>

							<c:if test="${year==2008}">
								<th data-graph-hidden="1"><c:out
										value="${yearlist.causeOfDeath}" /></th>
							</c:if>

						</c:forEach>
					</c:forEach>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="year" items='${years}'>
					<tr>
						<td><c:out value="${year}" /> <c:forEach var="yearsum"
								items='${map[year]}'>


								<td><c:out value="${yearsum.count}" /></td>

							</c:forEach>
					</tr>


				</c:forEach>

			</tbody>
		</table>
	</div>

	<script src="resources/js/jquery.js" type="text/javascript"></script>
	<script src="resources/js/highcharts.js" type="text/javascript"></script>
	<script src="resources/js/jquery.highchartTable.js"
		type="text/javascript"></script>

	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/dataTables.jqueryui.min.js"></script>
	<script src="resources/js/jquery.dataTables.min.js"></script>
	<script src="resources/js/jquery-ui.js"></script>
	<script>
		$(document).ready(function() {
			$('table.highchart').highchartTable();
		});
	</script>
</body>
</html>