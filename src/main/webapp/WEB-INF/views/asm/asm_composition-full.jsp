<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Состав сборочной единицы</title>
    </head>
    <body>
        <p id="demoFont">Развернутый состав сборки: ${asm.getNumber()} - ${asm.getName()}</p>
        <h1><a href="/asm/list">Назад вернуться</a></h1>
         <h1><a href="full-composition/${asm.getId()}">Развернутый список</a></h1>
        <br>
        <br>
 		<h2>${asm.getName()}</h2>
			 <div>
	        <p>Детали собственного производства</p>
	        <table border="2px">
				<c:set var="index" value="${0}" scope="request"/>
				<thead>
					  <tr>
						  	<th>#</th>
						    <th>Обозначение</th>
							<th>Наименование</th>
							<th>количество</th>
					  </tr>
				</thead>
				<tbody>
					<c:forEach var="opp" items="${opps_in_asm}">
					  	<tr>
					  		<td><c:set var="index" value="${index + 1}"  scope="request" />${index}</td>
							<td>${opp.getNumber()}</td>
							<td>${opp.getName()}</td>
							<td>${opp.getCountsInAsm()}</td>
					  	</tr>
					</c:forEach>
				</tbody>
			</table>
	        <br>
	       </div>
	       <div>
	        <p>Уплотнительные кольца O-Ring</p>
	        <table border="2px">
				<c:set var="index" value="${0}" scope="request"/>
				<thead>
					  <tr>
						  	<th>#</th>
						    <th>Обозначение</th>
							<th>количество</th>
					  </tr>
				</thead>
				<tbody>
					<c:forEach var="oring" items="${orings_in_asm}">
					  	<tr>
					  		<td><c:set var="index" value="${index + 1}"  scope="request" />${index}</td>
							<td>${oring.getNumber()}</td>
							<td>${oring.getCountsInAsm()}</td>
					  	</tr>
					</c:forEach>
				</tbody>
			</table>
	        <br>
	       </div>
	       <div>
	        <p>Взаимозаменяемые изделия (ВЗК)</p>
	        <table border="2px">
				<c:set var="index" value="${0}" scope="request"/>
				<thead>
					  <tr>
						  	<th>#</th>
						    <th>Обозначение</th>
						    <th>Наименование</th>
							<th>Количество</th>
					  </tr>
				</thead>
				<tbody>
					<c:forEach var="oring" items="${vzks_in_asm}">
					  	<tr>
					  		<td><c:set var="index" value="${index + 1}"  scope="request" />${index}</td>
							<td>${oring.getNumber()}</td>
							<td>${oring.getName()}</td>
							<td>${oring.getCountsInAsm()}</td>
					  	</tr>
					</c:forEach>
				</tbody>
			</table>
	        <br>
	       </div>
	       <div>
	        <p>Сборочные единицы (СБ)</p>
	        <table border="2px">
				<c:set var="index" value="${0}" scope="request"/>
				<thead>
					  <tr>
						  	<th>#</th>
						    <th>Обозначение</th>
						    <th>Наименование</th>
							<th>Количество</th>
					  </tr>
				</thead>
				<tbody>
					<c:forEach var="oring" items="${asms_in_asm}">
					  	<tr>
					  		<td><c:set var="index" value="${index + 1}"  scope="request" />${index}</td>
							<td><a href="${oring.getId()}">${oring.getNumber()}</a></td>
							<td>${oring.getName()}</td>
							<td>${oring.getCountsInAsm()}</td>
					  	</tr>
					</c:forEach>
				</tbody>
			</table>
	        <br>
	       </div>
    </body>  
</html>