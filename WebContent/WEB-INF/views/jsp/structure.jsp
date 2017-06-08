<%@ page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<!-- Materialize -->
		<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
			rel="stylesheet">
		<link type="text/css" rel="stylesheet" href="/TetrisVersionJSP/Materialize/css/materialize.min.css"
			media="screen,projection" />
		<link type="text/css" rel="stylesheet" href="/TetrisVersionJSP/css/complements.css"
			media="screen,projection" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
		
		<!-- <title>${ pageTitle }</title>  -->
		<title><tiles:insertAttribute name="title" /></title>
	</head>
	
	
	
	<body>
	
	
		<tiles:insertAttribute name="navigation" />

		<div class="container">
			<tiles:insertAttribute name="body" />
		</div>
	
		
	  <script type="text/javascript" src="/TetrisVersionJSP/Materialize/js/materialize.min.js"></script>	
	  <script <tiles:insertAttribute name="js" /> ></script>		
	  <script type="text/javascript" src="/TetrisVersionJSP/js/verifEditionTetrimino.js"></script>
	  <script type="text/javascript" src="/TetrisVersionJSP/js/editBloc.js"></script>
	  
	</body>
</html>