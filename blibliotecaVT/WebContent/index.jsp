<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<!DOCTYPE html>
<f:view> 
<f:loadBundle basename="resources.application" var="msg"/>
<html>
  <head>
      <title><h:outputText value="#{msg.welcomeTitle}" /></title>
      <meta name="viewport" content="width=device-width, minimun-scale=1, maximun-scale=1">
      <link href="css/bt/bootstrap.min.css" rel="stylesheet" media="screen">
      <script src="http://code.jquery.com/jquery.js"></script>
      <script src="js/bootstrap.min.js"></script>
  </head>
  
  <body>
  	
  	<div id="windowTitleDialog" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="windowTitleLabel" aria-hidden="true">
		<div class="modal-header">
			<a href="#" class="close" data-dismiss="modal">&times;</a>
			<h3>Acesse sua conta</h3>
			</div>
		<div class="modal-body">
			<div class="divDialogElements">
				<input class="xlarge" type="text" required="required" placeholder="Usuário" />
				<input class="xlarge" type="password" required="required" placeholder="Senha"/>
				
			</div>
			<input type="checkbox"/> 
			<h:outputText value="Mantenha-me conectado"/>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn" onclick="closeDialog ();">Cancel</a>
			<a href="#" class="btn btn-primary" onclick="okClicked ();">Entrar</a>
		</div>
	</div>
	
  	<div class="navbar navbar-fixed-top">
	  <div class="navbar-inner">
	    <div class="container"><!-- Collapsable nav bar -->
	      <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </a>
	 
	      <a class="brand" href="#"><h:outputText value="#{msg.welcomeTitle}"/></a>
	      <div class="nav-collapse">
	        <ul class="nav pull-right">
	          <li class="divider-vertical"></li>
	          <li><a data-toggle="modal" href="#windowTitleDialog">Entrar <img src="img/login.png"/></a></li>
	        </ul>
	      </div>
	    </div>
	  </div>
	</div>
	<br><br><br><br>
	<div class="container">
		<div class="masthead">
			<div class="navbar">
		        <div class="navbar-inner">
		          <div class="container">
		               <ul class="nav">
		               <li class="active"><a href="#">Home</a></li>
		               <li><a href="#">Projects</a></li>
		               <li><a href="#">Services</a></li>
		               <li><a href="#">Downloads</a></li>
		               <li><a href="#">About</a></li>
		               <li><a href="#">Contact</a></li>
	              </ul>
		          </div>
		       </div>
		   </div>
	   </div>
   </div>
  </body>
</html>
</f:view>
