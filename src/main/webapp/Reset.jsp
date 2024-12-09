
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

    <div class="container mt-5">
        <div class="row">
            <!-- Image Column on the Left -->
            <div class="col-md-6 d-flex justify-content-center align-items-center">
                <img src="https://cdn.dribbble.com/users/611291/screenshots/1959754/train.gif" alt="Descriptive Alt Text" class="rounded float-start   " style="max-height: 400px;"/>
                    </div>

<div style="max-width: 500px; margin: auto;">
    <div class="mb-3">
        <h5 class="mb-0">Forgot Password</h5>
    </div>
    <div class="card">
        <div class="card-body">
        <form action="emailSent">
                            <div class="mb-3">
                                <label for="email" class="form-label">Email Address</label>
                                <span id="emailError" style="color:blue;"></span>
                                <input type="email" name="email" id="email" class="form-control" placeholder="name@example.com" value="${email.email}"  required/>
                                </div>
                                <div>
   <input type="submit"  value="Get Otp" class="btn btn-dark btn-sm" style="margin-left: 10px;">
   </form>
       </div>
                                         <form action="otp">
                                                        <div class="mb-3">
                                                       <input type="email" name="email" id="email" class="form-control" placeholder="name@example.com" value="${email.email}"  hidden/>
                                                        </div>
                                         <div class="mb-3">
                                        <span id="oName" style="color:pink; visibility:hidden;"></span>
                                         <label for="oName" class="form-label">Enter Valid Otp</label>
                                         <input type="text" name="otp" id="Otp"  class="form-control" placeholder="Enter your Otp" required/>
                                         </div>
                                    <div>
                                     <button type="submit"  class="btn btn-dark btn-sm" style="margin-left: 7px;">Verify Otp </button>

                               </div>
                            </div>
                     </form>
        </div>
    </div>
</div>

    <div class="fixed-bottom">
    <footer class="bg-dark text-white py-3">
        <div class="container text-center">
                        <p class="mb-0"><a href="MetroLogin" style="text-decoration: none"><h7>Back</h7></a></p>
        </div>
    </footer>
    </div>
    </form>
</body>
</html>


