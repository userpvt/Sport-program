<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Start page</title>
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
            background-image: url(https://avatars.mds.yandex.net/get-pdb/1875351/f142d886-3d1e-4bbf-bdae-7ba0d5e52678/s1200);
            background-repeat: no-repeat;
        }
    </style>
</head>
<body>
<ul id="navbar">
    <li><a href="${pageContext.request.contextPath}/categories">Category</a></li>
    <li><a href="${pageContext.request.contextPath}/program-save">Create program</a></li>
    <li><a href="${pageContext.request.contextPath}/program-list">All user programs</a></li>
    <li><a href="${pageContext.request.contextPath}/description-list">Programs</a></li>
    <li><a href="${pageContext.request.contextPath}/counter">Hit counter</a></li>
    <li><a href="<c:url value = "https://www.sports.ru/stat/tags/all/sportsman/"/>">Our users</a></li>
    <li><a href="${pageContext.request.contextPath}/logout">Disconnect</a></li>
</ul>
</body>
</html>