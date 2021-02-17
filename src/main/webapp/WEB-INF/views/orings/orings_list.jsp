<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>O-Rings list</title>
    </head>
    
    <body>
        <h1>Список O-Rings</h1>
        <h2>Количество элементов: ${orings.size()}</h2>
        <a href="index">Возврат назад</a>
		<form method="post">
			<fieldset>
			<legend>Фильтр выбора</legend>
			
				<!-- Multiple Checkboxes -->
				<div>
					<label>Сечение, мм</label>
					<c:forEach var="crossSectionEnable" items="${crossSectionsEnableList}">
						<div>
							<label>
								
								<c:if test="${crossSectionEnable.isCheacked()}">
									<input 
									type="checkbox" 
									name="crossSectionsSelectedList" 
									value="${crossSectionEnable.getDiameter()}" 
									checked>
								</c:if>
								<c:if test="${!crossSectionEnable.isCheacked()}">
									<input 
									type="checkbox" 
									name="crossSectionsSelectedList" 
									value="${crossSectionEnable.getDiameter()}">
								</c:if>
								
								<b>${crossSectionEnable.getDiameter()}</b>
							</label>
						</div>
					</c:forEach>
				</div>
				<!-- ****************** -->																	
				
				<!-- Text input-->
				<br>
				<div>
					<label>Мин. внутренний диаметр, мм</label>  
					<div>
						<c:if test="${minInternalDiameter == -1.0}">
							<input type="text" name="minInternalDiameter">
						</c:if>
						<c:if test="${minInternalDiameter != -1.0}">
							<input type="text" name="minInternalDiameter" value="${minInternalDiameter}">
						</c:if>
					</div>
				</div>
				<!-- ****************** -->			
				
				<!-- Text input-->
				<div>
					<label>Макс. внутренний диаметр, мм</label>  
					<div>
						<c:if test="${maxInternalDiameter == -1.0}">
							<input type="text" name="maxInternalDiameter">
						</c:if>
						<c:if test="${maxInternalDiameter != -1.0}">
							<input type="text" name="maxInternalDiameter" value="${maxInternalDiameter}">
						</c:if>
					</div>
				</div>
				<!-- ****************** -->																							
				<!-- Button -->
				<div>
					<br>
				  	<div>
				    	<button type="submit">Обновить</button>
				  	</div>
				</div>
			</fieldset>
		</form>
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
				  	</tr>
				</c:forEach>
			</tbody>
		</table>
    </body>
</html>