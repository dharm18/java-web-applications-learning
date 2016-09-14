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
<script type="text/javascript">

</script>
<body>

	<div class="container">
      <div class="starter-template">
        <h1>URL Shortener API Demo</h1>
        <br/>
		<form class="form-horizontal">
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="url">URL:</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" name="url" id="url" placeholder="URL" value="${pageContext.request.requestURL}submitCustomerFeedback" readonly="readonly"/>
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="customerId">Customer Id:</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control"  id="customerId" name="customerId" value="10000008000000" placeholder="Customer Id">
		      </div>
		    </div>
		    <div class="form-group">
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-default" id="generateShortLink">Submit</button>
		      </div>
		    </div>
		    <div class="form-group" id="result">
		      <label class="control-label col-sm-2" for="customerId">Generated Url</label>
		      <div class="col-sm-10">
		        <a href="#" id="resultUrl"></a>
		      </div>
		    </div>
		</form>
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
    	
    	function ajaxindicatorstart(text)
    	{
    		if(jQuery('body').find('#resultLoading').attr('id') != 'resultLoading'){
    		jQuery('body').append('<div id="resultLoading" style="display:none"><div><img src="ajax-loader.gif"><div>'+text+'</div></div><div class="bg"></div></div>');
    		}

    		jQuery('#resultLoading').css({
    			'width':'100%',
    			'height':'100%',
    			'position':'fixed',
    			'z-index':'10000000',
    			'top':'0',
    			'left':'0',
    			'right':'0',
    			'bottom':'0',
    			'margin':'auto'
    		});

    		jQuery('#resultLoading .bg').css({
    			'background':'#000000',
    			'opacity':'0.7',
    			'width':'100%',
    			'height':'100%',
    			'position':'absolute',
    			'top':'0'
    		});

    		jQuery('#resultLoading>div:first').css({
    			'width': '250px',
    			'height':'75px',
    			'text-align': 'center',
    			'position': 'fixed',
    			'top':'0',
    			'left':'0',
    			'right':'0',
    			'bottom':'0',
    			'margin':'auto',
    			'font-size':'16px',
    			'z-index':'10',
    			'color':'#ffffff'

    		});

    	    jQuery('#resultLoading .bg').height('100%');
    	       jQuery('#resultLoading').fadeIn(300);
    	    jQuery('body').css('cursor', 'wait');
    	}
    	
    	function ajaxindicatorstop()
    	{
    	    jQuery('#resultLoading .bg').height('100%');
    	       jQuery('#resultLoading').fadeOut(300);
    	    jQuery('body').css('cursor', 'default');
    	}
    	
    	jQuery(document).ajaxStart(function () {
	     	//show ajax indicator
	    	ajaxindicatorstart('loading data.. please wait..');
	    }).ajaxStop(function () {
	    	//hide ajax indicator
	    	ajaxindicatorstop();
	    });
    	
    	$("#result").hide();
    	$('#generateShortLink').click(function(e){
    		$(this).prop('disabled',true);
    		e.preventDefault();
   			$.ajax({
   			  type: "POST",
   			  url: '${pageContext.request.contextPath}/GenerateShortUrl',
   			  data: {longurl:$('#url').val(),customerId:$('#customerId').val()},
   			  success: function(response){
   				var rep = JSON.parse(response);
   				console.log(rep);
   				console.log(rep.id);
   				$("#result").show();
   				$("#resultUrl").attr("href",rep.id)
   				$("#resultUrl").html(rep.id);
   			  }
   			});
    	});
    });
    </script>
</body>
</html>