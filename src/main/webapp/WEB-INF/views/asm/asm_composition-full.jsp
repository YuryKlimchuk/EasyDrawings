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
    </body>  
</html>