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
    <h1>XLS file viewer</h1>
    <form id="translateform" action="MainServlet" method="post" class="form-horizontal" role="form">
        <div style="margin-bottom: 25px" class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
            <input id="MainServlet"
                   type="MainServlet"
                   class="form-control"
                   name="MainServlet"
                   placeholder="MainServlet">
        </div>

        <div style="margin-top:10px" class="form-group">
            <div class="col-sm-12 controls">
                <input type="submit" class="btn btn-default pull-right" value="Translate">
            </div>
        </div>

        <div class="panel panel-info">
            <div class="panel-heading">Translated word</div>
            <div class="panel-body"><c:out value="${result}"/></div>
        </div>
    </form>

    <div class="container">
        <h2>Striped Rows</h2>
        <p>The .table-striped class adds zebra-stripes to a table:</p>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Email</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>John</td>
                <td>Doe</td>
                <td>john@example.com</td>
            </tr>
            <tr>
                <td>Mary</td>
                <td>Moe</td>
                <td>mary@example.com</td>
            </tr>
            <tr>
                <td>July</td>
                <td>Dooley</td>
                <td>july@example.com</td>
            </tr>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>