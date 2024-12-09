<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
        <link rel="icon" type="image/x-icon" href="https://www.x-workz.in/Logo.png"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-..." crossorigin="anonymous">
</head>
<body>
    <header class="bg-dark text-white py-3">
        <div class="d-flex justify-content-between align-items-center">
            <!-- Logo -->
            <img src="https://www.x-workz.in/Logo.png" alt="Coders World Logo" style="max-height: 50px;">
            <!-- Heading -->
                                 <div class="d-flex justify-content-between align-items-center">
                                <form action="email" class="d-inline">
                                  <input type="text" name="email" class="form-control d-inline" style="width: auto;">
                                  <input type="submit" value="search By Email">
                                </form>
                                </div>
                                <nav>
                                <form action="trainNumber" class="d-inline">
                                  <input type="text" name="trainNumber" class="form-control d-inline" style="width: auto;">
                                  <input type="submit" value="search By Email">
                                </form>
                                </nav>

            <h1 class="text-center mb-0 flex-grow-1"></h1>
                </table>          <div class="d-flex justify-content-between align-items-center">
                                  <form action="searchUserName"  class="d-inline">
                                        <input type="text" name="userName" class="form-control d-inline" style="width: auto;">
                                    <input type="submit" value="search By UserName">
                                </form>
                                </div>

                </table>          <div class="d-flex justify-content-between align-items-center">
                                  <form action="train"  class="d-inline">
                                        <input type="text" name="trainType" class="form-control d-inline" style="width: auto;">
                                    <input type="submit" value="search">
                                </form>
                                </div>

        </div>
    </header>

<h1>${message}</h1>
    <h2>Trainee Details</h2>
    <h1 style="color: red;">${message}</h1>
        <h1 style="color: red;">${dto}</h1>
        <h1>${time}</h1>
    <table class="table table-bordered table-striped table-hover">
        <thead class="table-light">
            <tr>
                <th>ID</th>
                <th>firstName</th>
                <th>lastName</th>
                <th>userName</th>
                <th>password</th>
                <th>email</th>
                <th>mobileNumber</th>
                <th>gender</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${trainees}" var="dto">
                <tr>
                    <td>${dto.id}</td>
                    <td>${dto.firstName}</td>
                    <td>${dto.lastName}</td>
                    <td>${dto.userName}</td>
                    <td>${dto.password}</td>
                    <td>${dto.email}</td>
                    <td>${dto.mobileNumber}</td>
                     <td>${dto.gender}</td>



                </tr>
            </c:forEach>
                                                <tr>
                                                      <td>${single.id}</td>
                                                      <td>${single.firstName}</td>
                                                      <td>${single.lastName}</td>
                                                    <td>${single.userName}</td>
                                                    <td>${single.password}</td>
                            						 <td>${single.email}</td>
                            						 <td>${single.mobileNumber}</td>
                            						 <td>${single.gender}</td>
                                                </tr>
                                                <tr>
                                                      <td>${second.id}</td>
                                                      <td>${second.firstName}</td>
                                                      <td>${second.lastName}</td>
                                                    <td>${second.userName}</td>
                                                    <td>${second.password}</td>
                            						 <td>${second.email}</td>
                            						 <td>${second.mobileNumber}</td>
                            						 <td>${second.gender}</td>
                                                </tr>


        </tbody>
    </table>

    <div class="bottom">
    <footer class="bg-dark text-white py-3">
        <div class="container text-center">
            <p class="mb-0"></p>
        </div>
    </footer>
    </div>

</body>
</html>
