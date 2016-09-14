<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<title>URL Shortener API Demo</title>

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="${pageContext.request.contextPath}/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

</head>
<body>
	<div class="container">
      <div class="starter-template">
        <h1>URL Shortener API Demo</h1>
        <br/>
		<form class="form-horizontal">
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="customerId">Captured Customer Id</label>
		      ${customerId}
		    </div>
		    <div class="form-group">
	      		<label class="control-label col-sm-2" for="name">Name:</label>
		      	<div class="col-sm-10">
		        	<input type="text" class="form-control" name="name" id="name" placeholder="Name" value=""/>
		      	</div>
			</div>
			<div class="form-group">
		      	<label class="control-label col-sm-2" for="name">Contact Number:</label>
		      	<div class="col-sm-10">
		        	<input type="text" class="form-control" name="contactNumber" id="contactNumber" placeholder="Contanct Number" value=""/>
		      	</div>
			</div>
		</form>
		<a href="${pageContext.request.contextPath}">Click Here to go to Home page</a>
      </div>
    </div><!-- /.container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-min.js"></script>
    <script>window.jQuery || document.write('<script src="js/jquery.min.js"><\/script>')</script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${pageContext.request.contextPath}/js/ie10-viewport-bug-workaround.js"></script>
    <script type="text/javascript">
    $(document).ready(function(){
    });
    </script>
</body>
</html>