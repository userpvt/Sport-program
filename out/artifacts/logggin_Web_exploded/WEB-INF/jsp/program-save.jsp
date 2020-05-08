<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        * {
            box-sizing: border-box;
        }

        input[type=text], select, textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;
        }

        label {
            padding: 12px 12px 12px 0;
            display: inline-block;
        }

        input[type=submit] {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            float: right;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        .container {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }

        .col-25 {
            float: left;
            width: 25%;
            margin-top: 6px;
        }

        .col-75 {
            float: left;
            width: 75%;
            margin-top: 6px;
        }

        /* Clear floats after the columns */
        .row:after {
            content: "";
            display: table;
            clear: both;
        }

        /* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
        @media screen and (max-width: 600px) {
            .col-25, .col-75, input[type=submit] {
                width: 100%;
                margin-top: 0;
            }
        }
    </style>
    <style type="text/css">
        body{
            margin: 0;
            background-image: url(https://wallpaper-mania.com/wp-content/uploads/2018/09/High_resolution_wallpaper_background_ID_77700362404.jpg);
            background-repeat: no-repeat;
        }
    </style>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        .btn {
            border: none;
            color: white;
            padding: 14px 10px;
            font-size: 20px;
            cursor: pointer;
        }

        .warning {background-color: #f44336;}
        .warning:hover {background: #e68a00;}

    </style>
</head>
<body>
<h2>Создать свою программу</h2>
<p>Здесь вы можете дать описание и задать параметры своей программе</p>
<form action="${pageContext.request.contextPath}/program-save" method="post">
    <label for="name">Название тренировки:
        <input type="text" name="name" id="name" placeholder="Your name training...">
    </label><br>
    <label for="author">Ваша электронная почта:
        <input type="text" name="author" id="author" placeholder="Your email...">
    </label><br>
        <label for="days">Количество дней:
            <input type="number" name="days" id="days">
        </label><br>
        <div class="row">
            <div class="col-25">
                <label for="gender">Выберите пол</label>
            </div>
            <div class="col-75">
                <select id="gender" name="gender">
                    <option value="MALE">Мужчина</option>
                    <option value="FEMALE">Женщина</option>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="level">Уровень сложности</label>
            </div>
            <div class="col-75">
                <select id="level" name="level">
                    <option value="EASY">Лёгкий</option>
                    <option value="MEDIUM">Средний</option>
                    <option value="HARD">Тяжёлый</option>
                    <option value="HARDCORE">Гладиатор</option>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="period">Тренировочный период</label>
            </div>
            <div class="col-75">
                <select id="period" name="period">
                    <option value="WEEKLY">Недельный</option>
                    <option value="MONTHLY">Месячный</option>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="category">Выбрать категорию</label>
            </div>
            <div class="col-75">
                <select id="category" name="category">
                    <c:forEach var="category" items="${requestScope.categories}">
                        <option value="${category.id}">${category.name}</option>
                    </c:forEach>
                </select><br>
                <button type="submit" value="Сохранить" class="btn warning">Сохранить</button>
            </div>
        </div>
        <br>
</form>
</body>
</html>