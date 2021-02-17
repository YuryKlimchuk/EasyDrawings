<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Свои детали</title>
    </head>
    <body>
        <h1>Редактирование таблицы VZK</h1>
        <h2>Количество элементов: ${vzks.size()}</h2>
        <a href="index">Возврат назад</a>
		<br>
		<p>Форму сюда еще надо на фильтры</p>
		<table border="2px">
			<c:set var="index" value="${0}" scope="request"/>
			<thead>
				  <tr>
					  	<th>#</th>
					    <th>ID</th>
					    <th>Обозначение</th>
						<th>Наименование</th>
				  </tr>
			</thead>
			<tbody>
				<c:forEach var="vzk" items="${vzks}">
				  	<tr>
				  		<td><c:set var="index" value="${index + 1}"  scope="request" />${index}</td>
					    <td>${vzk.getId()}</td>
						<td><a href="composition/${vzk.getId()}">${vzk.getNumber()}</a></td>
						<td>${vzk.getName()}</td>
				  	</tr>
				</c:forEach>
			</tbody>
		</table>
    </body>
</html>