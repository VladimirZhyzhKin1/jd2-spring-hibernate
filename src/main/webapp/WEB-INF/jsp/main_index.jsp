<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         import="java.util.List, by.htp.task.entity.News" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}resources/css/style.css"/>

</head>
<body>
<div class="header" align="center" style="font-size: 200%">
    <h1>The local news</h1>
</div>

<a href="AnonymousController?command=localization&language=en&commandRedirect=AnonymousController%3Fcommand%3Dgotoindexpage"><spring:message
        code="en.button"/></a><br>
<a href="AnonymousController?command=localization&language=ru&commandRedirect=AnonymousController%3Fcommand%3Dgotoindexpage"><spring:message
        code="ru.button"/></a><br>

<c:if test="${param.message != 'null'}">
    <div align="center">
        <font color="green">
            <c:out value="${param.message}"/>
        </font>
    </div>
</c:if>

<br/>

<form:form style="text-align: center" action="login" modelAttribute="user">
    <spring:message code="index.login"/>: <br>
    <form:input path="login"/>
    <br><br>
    <spring:message code="index.password"/>:<br>
    <form:input path="password"/>
    <br/><br/>
    <input type="submit" value="<spring:message code='index.send' />"/>
</form:form>

<br/>

<div align="center">
    <a href="AnonymousController?command=registration"><spring:message code="index.registration"/></a>
    <table border="2">
        <c:forEach var="n" items="${requestScope.news}">
            <tr>
                <td><font size="16" color="black" align="center"> <c:out value="${n.title}"/>
                    <div style="font-size: 40%">
                        <c:out value="${n.brief}"/>
                    </div>
                </font></td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="footer" style="height: 10%; position: absolute; bottom: 0px;">
    <h2>
        <spring:message code="index.contacts"/>: 2021 &copy; Vladimir Zhyzhkin
    </h2>
</div>
</body>
</html>