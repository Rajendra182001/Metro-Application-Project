<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title></title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
    <!-- Header -->
    <header class="bg-dark text-white py-3">
        <div class="d-flex justify-content-between align-items-center">
            <!-- Logo -->
            <img src="https://www.x-workz.in/Logo.png" alt="Coders World Logo" style="max-height: 50px;">

            <!-- Heading -->
            <h1 class="text-center mb-0 flex-grow-1"></h1>
    </header>

<br>
    <div style="max-width: 500px; margin: auto;">
        <div class="mb-3">
            <h5 class="mb-0"></h5>
        </div>
        <div class="card">
            <div class="card-body">
            <form action="confirm" method="post">
                                        <div class="mb-3">
                                          <label for="email" class="form-label">Email Address</label>
                                          <input type="email" name="email" id="email" class="form-control" placeholder="name@example.com" value="${success.email}" readonly>
                                         </div>

                          <div class="mb-3">
                          <label for="password" class="form-label">Enter New Password</label>
                          <input type="password" name="password" id="password" class="form-control" placeholder="Enter new password" required/>
                          </div>
                                   <div class="mb-3">
                                   <label for="confirmPassword" class="form-label">Confirm Password</label>
                                   <input type="text" name="confirmPassword" id="password"  class="form-control" placeholder="********"  required/>
                                   </div>
                          <button type="submit" id="button" class="btn btn-primary btn-sm rounded-pill">Submit</button>
            </form>
            </div>
        </div>
    </div>


    <div class="fixed-bottom">
    <footer class="bg-dark text-white py-3">
        <div class="container text-center">
                        <p class="mb-0"><a href="Forgot" style="text-decoration: none"><h7>Back</h7></a></p>
        </div>
    </footer>
    </div>
 <h1>${error}</h1>

</body>
</html>