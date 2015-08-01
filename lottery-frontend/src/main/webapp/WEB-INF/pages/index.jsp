<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">

    <title>Lottery Registration</title>

    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
    <spring:url value="/resources/css/registration.css" var="registrationCss" />
    <spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
    <spring:url value="/resources/js/lottery.js" var="lotteryJs" />
    <spring:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" var="jqueryJs" />

    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${registrationCss}" rel="stylesheet" />
</head>
<body>

	<!-- Form to register/create new lottery contender -->
    <div class="container">
        <form name="registrationForm" class="form-resgistration">
            <h2 class="form-resgistration-heading">Lottery Registration</h2>
            <br>
            <label for="inputFirstname" class="sr-only">Firstname</label>
            <input type="text" id="inputFirstname" class="form-control" placeholder="Firstname" required autofocus>
            <label for="inputLastname" class="sr-only">Lastname</label>
            <input type="text" id="inputLastname" class="form-control" placeholder="Lastname" required autofocus>
            <br>
            <button id='registrationButton' class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
        </form>
        <div id="successAlert" class="alert alert-success" role="alert" hidden="true">Contender registered!</div>
    </div>

	<!-- Modal to show lottery winner -->
  	<div id="winnerModal" class="modal fade" id="myModal" role="dialog">
    	<div class="modal-dialog modal-sm">
      		<div class="modal-content">
        		<div class="modal-header">
          			<button type="button" class="close" data-dismiss="modal">&times;</button>
          			<h4 class="modal-title">LOTTERY WINNER</h4>
        		</div>
        		<div class="modal-body">
        			<p></p>
        		</div>
        		<div class="modal-footer">
          			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        		</div>
      		</div>
    	</div>
  	</div>

    <script src="${jqueryJs}"></script>
    <script src="${bootstrapJs}"></script>
    <script src="${lotteryJs}"></script>
</body>
</html>