<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Description info</title>
    <style>
        #navbar {
            margin: 0;
            padding: 0;
            list-style-type: none;
            width: 100px;
        }
        #navbar li {
            border-left: 10px solid #666;
            border-bottom: 1px solid #666;
        }
        #navbar a {
            background-color: #949494;
            color: #fff;
            padding: 5px;
            text-decoration: none;
            font-weight: bold;
            border-left: 5px solid #33ADFF;
            display: block;
        }
        #navbar a:hover {
            background-color: #666;
            border-left: 5px solid #3333FF;
        }
    </style>
    <style type="text/css">
        body{
            margin: 0;
            background-image: url(https://wallpaper-mania.com/wp-content/uploads/2018/09/High_resolution_wallpaper_background_ID_77700362285.jpg);
            background-repeat: no-repeat;
        }
    </style>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        p{ color: red; font-size: 20px;}
    </style>
</head>
<body>
<ul id="navbar">
    <li><a href="${pageContext.request.contextPath}/start">Start page</a></li>
    <li><a href="${pageContext.request.contextPath}/categories">Category</a></li>
    <li><a href="${pageContext.request.contextPath}/program-save">Create program</a></li>
    <li><a href="${pageContext.request.contextPath}/program-list">All user programs</a></li>
    <li><a href="${pageContext.request.contextPath}/description-list">Programs</a></li>
    <li><a href="${pageContext.request.contextPath}/counter">Hit counter</a></li>
    <li><a href="${pageContext.request.contextPath}/logout">Disconnect</a></li>
</ul>
<div class="container">
    <p class="text-center">Название тренировки: ${requestScope.description.name}</p>
    <p class="text-center">Количество дней: ${requestScope.description.days}</p>
    <p class="text-center">Период: ${requestScope.description.period}</p>
    <p class="text-center">Уровень сложности: ${requestScope.description.level}</p>
    <p class="text-center">Локация: ${requestScope.description.type}</p>
    <p class="text-center">Категория: ${requestScope.description.categoryName}</p>
    <p class="text-center"><a href="${requestScope.description.specification}">Описание Тренировки</a></p>
</div>
</body>
</html>