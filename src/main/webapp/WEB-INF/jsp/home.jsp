<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Comisiones</title>

	<!-- Jquery -->
	<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
	
	<!-- AngularJS -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
		
	<!-- Complementos JS para Bootstrap -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.3.1/angular-ui-router.js"></script>
	
	<style type="text/css">
		.grid{
			margin-bottom: 20px;
		}
		.row:nth-child(even) {background-color: #f2f2f2}
		
		.grid-header{
			background-color: #69bf6c;
    		color: white;
		}
		.navbar-brand img{
			width: 27px;
		}
		.add-pet{
			max-width: 500px;
		}
	</style>
</head>
<body ng-app="app">
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">
	        <img alt="Brand" src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQoqFHxX1SRTRrU6vLie92-cPmfJvR5g5bpdZ8Y6uAaHZVS2LGk">
	      </a>
	    </div>
	  </div>
	</nav>

	<ui-view></ui-view>
	
</body>

<script type="text/javascript" src="<%= request.getContextPath() %>/static/app.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/static/petsController.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/static/petFormController.js"></script>
<script type="text/javascript"> var pageContext = '<%= request.getContextPath() %>';</script>

</html>