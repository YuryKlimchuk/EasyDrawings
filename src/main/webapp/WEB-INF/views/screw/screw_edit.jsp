<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>БОЛОТЫ И ВИНТЫ</title>
    </head>
    <body>
        <h1>Редактирование таблицы БОЛТЫ</h1>
        <h2>Количество элементов: ${screws.size()}</h2>
        <a href="index">Возврат назад</a>
		<br>
		<table border="2px">
			<c:set var="index" value="${0}" scope="request"/>
			<thead>
				  <tr>
					  	<th>#</th>
					    <th>ID</th>
					    <th>Обозначение</th>
						<th>Наименование</th>
						<th>Стандарт</th>
						<th>Действие 1</th>
						<th>Действие 2</th>
				  </tr>
			</thead>
			<tbody>
				<c:forEach var="screw" items="${screws}">
				  	<tr>
				  		<td><c:set var="index" value="${index + 1}"  scope="request" />${index}</td>
					    <td>${screw.getId()}</td>
						<td>${screw.getNumber()}</td>
						<td>${screw.getName()}</td>
						<td>${screw.getStandart()}</td>
					    <td><a href="item-edit/${screw.getId()}">Редактировать</a></td>
					    <td><a href="item-delete/${screw.getId()}">Удалить</a></td>
				  	</tr>
				</c:forEach>
			</tbody>
		</table>
    </body>
</html>