<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="locale.jsp"%>
<div>
    <c:if test="${not empty sessionScope.currentUser}">
        <button>Смена</button>
    </c:if>
    <c:if test="${sessionScope.currentUser.role eq 'ADMIN'}">
        <a href="${pageContext.request.contextPath}/change-locale?language=ru_RU" class="btn btn-secondary btn-lg active" role="button">Русский</a>
        <a href="${pageContext.request.contextPath}/change-locale?language=en_US" class="btn btn-secondary btn-lg active" role="button">English</a>
    </c:if>
</div>