<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


	<!-- <h2>Bienvenue, ${ username } !</h2> -->
	<h2><spring:message code="home.welcome" arguments="${ username }" /></h2>
	
	<form method="GET" action="logout">
	    <button class="btn waves-effect waves-light" type="submit" name="action"><spring:message code="home.logout" />
    		<i class="material-icons right">power_settings_new</i>
  		</button>
	</form>

	

