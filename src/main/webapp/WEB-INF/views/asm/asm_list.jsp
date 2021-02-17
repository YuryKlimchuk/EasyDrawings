<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Свои детали</title>
    </head>
    <body>
        <h1>Редактирование таблицы ASM</h1>
        <h2>Количество элементов: ${asms.size()}</h2>
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
						<th>Статус</th>
						<th>Версия</th>
						<th>Дата</th>
				  </tr>
			</thead>
			<tbody>
				<c:forEach var="asm" items="${asms}">
				  	<tr>
				  		<td><c:set var="index" value="${index + 1}"  scope="request" />${index}</td>
					    <td>${asm.getId()}</td>
						<td><a href="composition/${asm.getId()}">${asm.getNumber()}</a></td>
						<td>${asm.getName()}</td>
						<td>${asm.getStatus()}</td>
						<td>${asm.getVersion()}</td>
						<td>${asm.getUpdate()}</td>
				  	</tr>
				</c:forEach>
			</tbody>
		</table>
    </body>
</html>