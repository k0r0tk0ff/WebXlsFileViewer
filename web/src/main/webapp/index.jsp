<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <script src="<c:url value="/bootstrap/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
</head>
<body>
<div class="container">
  <h2>XLS file viewer</h2>
  <a href="MainServlet" class="btn btn-primary btn-lg btn-block">Parse XLS file</a>
</div>

<div class="container">
    <table class="table table-striped">
        <tbody>
            <thead>
                <tr>
                <th>Full Name</th>
                <th>Salary</th>
                </tr>
            </thead>
        <c:forEach var="list" items="${lists}">
            <tr valign="top">
            </tr>
            <tr>
                <c:forEach var="element" items="${list}">
                    <td><c:out value="${element}"/></td>
                </c:forEach>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>