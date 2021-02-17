<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>O-Rings list</title>
    </head>
    
    <body>
        <h2>Добавление нового O-Ring</h2>
        <h2>${msg}</h2>
        <a href="index">Возврат назад</a>
        <br>
		<form method="post">
			<fieldset>
			<legend>Параметры нового элемента</legend>
											
				<!-- Text input-->
				<br>
				<div>
					<label>Сечение, мм</label>
					<div>  
						<input type="text" name="crossSection">
					</div>
				</div>
				<br>
				<!-- ****************** -->
				<!-- Text input-->
				<div>
					<label>Внутренний диаметр, мм</label>  
					<div>
						<input type="text" name="internalDiameter">
					</div>
				</div>
				<!-- Text input-->
				<br>
				<div>
					<label>Обозначение</label> 
					<div>
						<input type="text" name="number">
					</div>
				</div>
				<br>
				<div>
					<label>Стандарт</label> 
					<div>
						<input type="text" name="standart">
					</div>
				</div>
				<br>	
				<div>
					<br>
				    <button type="submit">Добавить</button>
				</div>
			</fieldset>
		</form>
		<br>
    </body>
</html>