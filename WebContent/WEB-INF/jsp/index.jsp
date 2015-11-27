<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NYC Leading Causes of Death</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/simple-sidebar.css" rel="stylesheet">
	<link rel="stylesheet" href="resources/css/jquery-ui.min.css">
	<link rel="stylesheet" href="resources/css/jquery-ui.structure.min.css">
	<link rel="stylesheet" href="resources/css/jquery-ui.theme.min.css">
	<link rel="stylesheet" href="resources/css/dataTables.jqueryui.min.css">
</head>
<body>
<div id="wrapper">

        <!-- Sidebar -->
   <div class="container">
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="navbar-header">
		<ul class="nav navbar-nav">
			<li ><a href="#"> NYC Causes of Death </a>
			</li>
			<li><a href="/NYCLeadingCauses">Home</a></li>
			<li><a href="linechart">View Chart</a></li>
		</ul>
		</div>
		</nav>
	</div>
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
						<table id="traineetable" class="display" cellspacing="0" width="100%">
							<thead>
								<tr>
									<th id="headerRequstID">Year</th>
									<th id="headerRequestType">Ethnicity</th>
									<th id="headerRequestType">Sex</th>
									<th id="headerRequstID">Cause of Death</th>
									<th id="headerRequestType">Count</th>
									<th id="headerRequestType">Percent</th>
								</tr>
							</thead>			
							<tfoot>
								<tr>
									<th id="headerRequstID">Year</th>
									<th id="headerRequestType">Ethnicity</th>
									<th id="headerRequestType">Sex</th>
									<th id="headerRequstID">Cause of Death</th>
									<th id="headerRequestType">Count</th>
									<th id="headerRequestType">Percent</th>
								</tr>
							</tfoot>
							<tbody>
								<c:forEach var="leadingcause" items='${dataset}'>	
								<tr>
									<td><c:out value="${leadingcause.year}"/></td>
									<td><c:out value="${leadingcause.ethnicity}"/></td>
									<td><c:out value="${leadingcause.sex}"/></td>
									<td><c:out value="${leadingcause.causeOfDeath}"/></td>
									<td><c:out value="${leadingcause.count}"/></td>
									<td><c:out value="${leadingcause.percentage}"/></td>
<%-- 									<td id="tddate"><c:out value="${fdmtrainee.fdmClass.endDate.timeInMillis}"/></td> --%>
								</tr>
								</c:forEach>
							</tbody>
						</table>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->
<script src="resources/js/jquery.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/jquery.js"></script>
<script src="resources/js/dataTables.jqueryui.min.js"></script>
<script src="resources/js/jquery.dataTables.min.js"></script>
<script src="resources/js/jquery-ui.js"></script>

<script type="text/javascript">



$(document).ready(function() {
    $('#traineetable').DataTable();
} );

$("#menu-toggle").click(function(e) {
    e.preventDefault();
    $("#wrapper").toggleClass("toggled");
});

</script >
</body>
</html>