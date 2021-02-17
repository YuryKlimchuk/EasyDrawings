<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>O-Rings list</title>
    </head>
    
    <body>
        <h1>Редактирование таблицы O-Rings</h1>
        <h2>Количество элементов: ${orings.size()}</h2>
        <a href="index">Возврат назад</a>
		<br>
		<table border="2px">
			<c:set var="index" value="${0}" scope="request"/>
			<thead>
			  <tr>
			  	<th>#</th>
			    <th>ID</th>
			    <th>Обозначение</th>
			    <th>Сечение, мм</th>
			    <th>Внутренний диаметр, мм</th>
			    <th>Стандарт</th>
				<th>Действие 1</th>
				<th>Действие 2</th>
			  </tr>
			</thead>
			<tbody>
				<c:forEach var="oring" items="${orings}">
				  	<tr>
				  		<td><c:set var="index" value="${index + 1}"  scope="request" />${index}</td>
					    <td>${oring.getId()}</td>
					    <td>${oring.getNumber()}</td>
					    <td>${oring.getCrossSection()}</td>
					    <td>${oring.getInternalDiameter()}</td>
					    <td>${oring.getStandart()}</td>
					    <td><a href="item-edit/${oring.getId()}">Редактировать</a></td>
					    <td><a href="item-delete/${oring.getId()}">Удалить</a></td>
				  	</tr>
				</c:forEach>
			</tbody>
		</table>
    </body>
</html>