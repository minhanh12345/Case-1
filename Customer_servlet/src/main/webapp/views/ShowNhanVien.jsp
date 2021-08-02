<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 29/07/2021
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">


    <h2>Show Customer</h2>
    <a href="/nhanvien?action=create" class="btn btn-success">Create</a>
    <a href="/nhanvien?action=showphongban" class="btn btn-success">Show phong ban</a>


<br>
<br>
    <table class="table">
        <thead>
        <tr>
            <th>Name</th>
            <th>BirthDay</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Phong ban</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listCustomer}" var="nhanVien" varStatus="loop">
        <tr>

            <td>${nhanVien.name}</td>
            <td>${nhanVien.birthDayDate}</td>
            <td>${nhanVien.address}</td>
            <td>${nhanVien.phone}</td>
            <td>${nhanVien.email}</td>
            <td>${nhanVien.phongban}</td>
            <td><a href="/nhanvien?action=edit&index=${loop.index}" class="btn btn-warning">Edit</a></td>
            <td><a href="/nhanvien?action=delete&index=${loop.index}" class="btn btn-danger">Delete</a></td>
        </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

</body>
</html>

