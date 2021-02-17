<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Винты болты</title>
    </head>
    
    <body>
        <h2>Добавление нового Винта</h2>
        <h2>${msg}</h2>
        <a href="index">Возврат назад</a>
        <br>
		<form method="post">
			<fieldset>
			<legend>Параметры нового винта-болта</legend>
											
				<!-- ****************** -->
				<!-- Text input-->
				<div>
					<label>Обозначение</label> 
					<div>
						<input type="text" name="number">
					</div>
				</div>
				<br>
				<div>
					<label>Наименование</label> 
					<div>
						<input type="text" name="name">
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