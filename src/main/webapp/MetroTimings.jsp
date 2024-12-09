<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
        <link rel="icon" type="image/x-icon" href="https://www.x-workz.in/Logo.png"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-..." crossorigin="anonymous">
              <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
            <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <header class="bg-dark text-white text-center py-3">
        <div class="d-flex justify-content-between align-items-center">
            <!-- Logo -->
            <img src="https://www.x-workz.in/Logo.png" alt="Coders World Logo" class="img-fluid" style="max-height: 50px;">
            <h1 class="text-center mb-0 flex-grow-1"></h1>
        </div>
    </header>
    <br>
<div class="image-container text-center my-4">
    <img src="https://metroride.in/img/namma_metro.png" alt="Metro Route" class="img-fluid" style="max-height:45px; width: auto;">
</div>

 <h5 style="text-align:center">Bangalore Metro Timings<h5>
    <table class=" table table-hover mx-auto rounded-3" style="width: 60%;">
        <thead class="table-light">
            <tr>
                <th>dayOfTheWeek</th>
                <th>fromTime</th>
                <th>toTime</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${timings}" var="dto">
                <tr>
                    <td>${dto.dayOfTheWeek}</td>
                    <td>${dto.fromTime}</td>
                    <td>${dto.toTime}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


    <div class="fixed-bottom">
        <footer class="bg-dark text-white text-center py-3 mt-4">
            <p class="mb-0"></p>
        </footer>
    </div>
</body>
</html>