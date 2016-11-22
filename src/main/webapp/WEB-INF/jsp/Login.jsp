<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/Style.css" media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
    	<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">Login</a>
							</div>
							<div class="col-xs-6">
								<a href="#" id="register-form-link">Register</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form:form id="login-form" action="${pageContext.request.contextPath}/login" method="post"  modelAttribute="command" style="display: block;">
									<div class="form-group">
									<form:label path="Nombre_Usuario">User Name</form:label> 
									<form:input path="Nombre_Usuario" type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value=""/>
										<!-- <input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value=""> -->
									</div>
									<div class="form-group">
									<form:label path="Password_Usuario">Password</form:label>
									<form:input path="Password_Usuario" type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password"/>
										<!-- <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password"> -->
									</div>
									<div class="form-group text-center">
										<input type="checkbox" tabindex="3" class="" name="remember" id="remember">
										<label for="remember"> Remember Me</label>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Log In">
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-lg-12">
												<div class="text-center">
													<a href="http://phpoll.com/recover" tabindex="5" class="forgot-password">Forgot Password?</a>
												</div>
											</div>
										</div>
									</div>
								</form:form>
								<form:form  id="register-form" action="${pageContext.request.contextPath}/register" method="post"  modelAttribute="command" style="display: none;">
									<div class="form-group">
									<form:label path="Nombre_Usuario">User Name</form:label> 
										<form:input path="Nombre_Usuario" type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value=""  />
									</div>
									<div class="form-group">
									<form:label path="Password_Usuario">Password</form:label> 
										<form:input path="Password_Usuario" type="password" name="password" id="password" tabindex="1" class="form-control" placeholder="password" value="" />
									</div>
									<div class="form-group">
									<form:label path="Nombre_Persona">Nombre</form:label> 
										<form:input path="Nombre_Persona" type="text" name="Nombre_Persona" id="Nombre_Persona" tabindex="2" class="form-control" placeholder="Name" />
									</div>
									<div class="form-group">
									<form:label path="Apellido_Persona">Apellido</form:label> 
										<form:input path="Apellido_Persona" type="text" name="Apellido_Persona" id="confirm-password" tabindex="2" class="form-control" placeholder="Confirm Password"/>
									</div>
									<form:label path="DNI_Persona">DNI_Persona</form:label> 
										<form:input path="DNI_Persona"  type="text" name="DNI_Persona" id="DNI_Persona" tabindex="2" class="form-control" placeholder="Confirm Password"/>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now">
											</div>
										</div>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>

</body>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/static/JavaScript.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    
</html>