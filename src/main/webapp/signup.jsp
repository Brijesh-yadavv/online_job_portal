<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<%@include file="all_component/all_css.jsp"%>
</head>
<body style="background-color: #f0f1f2;">

	<%@include file="all_component/nav_bar.jsp"%>
	<div class="container-fluid">
		<div class="row p-5">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<div class="text-center">
							<i class="fa fa-user-plus fa-2x" aria-hidden="true"> </i>
							<h5>Registration.....</h5>
							
							<c:if test="${ not empty succMsg }">
								<h4 class="text-center text-success">${succMsg }</h4>
								<c:remove var="succMsge" />
							</c:if>


							<form action="add_user" method="post">
								<div class="form-group">
									<label>Enter Full Name</label> <br>
									<input type="text" required="required" class="form control"
										id="exampleInputName" aria-describedby="emailHelp" name="name">
								</div>
								<div class="form-group">
									<label>Enter Qualification</label> <br>
									<input type="text" required="required" class="form control"
										id="exampleInputQua" aria-describedby="emailHelp" name="qua">
								</div>
								<div class="form-group">
									<label>Enter Email</label><br> <input type="email"
										required="required" class="form control"
										id="exampleInputEmail" aria-describedby="emailHelp"
										name="email">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Enter Password</label><br>
									<input type="password" required="required" class="form control"
										id="exampleInputPassword1" name="password">
								</div>

								<button type="submit"
									class="btn btn-primary badge-pill btn-block">Register</button>


							</form>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

</body>
</html>