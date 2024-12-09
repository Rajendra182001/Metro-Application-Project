<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>This is Coders World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <!-- Header -->
    <header class="bg-dark text-white py-3">
        <div class="d-flex justify-content-between align-items-center mb-0">
            <!-- Logo -->
            <img src="https://www.x-workz.in/Logo.png" alt="Coders World Logo" style="max-height: 50px;">
            <!-- Heading -->
        </div>
    </header>
    <h3 style="font-family: 'Arial', sans-serif; text-align: center; margin-right: -240px; margin-top: 35px; font-size: 20px; color: black; letter-spacing: 2px; text-transform: uppercase;">My Account</h3>

<h5 class="text-center" class="color red">${blocked}</h5>
    <div class="container mt-5">
        <div class="row">
            <!-- Image Column on the Left -->
            <div class="col-md-6 d-flex justify-content-center align-items-center">
    <div id="carouselExampleSlidesOnly" class="carousel" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
            <img src="https://www.tripsavvy.com/thmb/n2oAmjOEl-P3r8VXiuv2hu9bqZc=/960x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-1081803176-fd11b444454a416ca43a88be77eaeed6.jpg" class="d-flex justify-content-between align-items-center" style="max-height: 300px; max-width:4000px">
            </div>
            <div class="carousel-item">
                <img src="https://english.bmrc.co.in/images/metro/banner1.jpg"  style="max-height: 300px;">
            </div>
            <div class="carousel-item ">
                <img src="https://english.bmrc.co.in/images/metro/homepage/about-us.jpg"  style="max-height: 300px;">
            </div>
        </div>
    </div>
</div>


<div class="card mx-5" style="max-width: 500px;">
    <div class="card-body bg-light">
    <div style="max-width: 500px; margin: auto;">
        <div class="mb-3">
            <h5 class="mb-0"></h5>
        </div>
    <!-- Main content -->
    <main class="container my-4">
        <form action="inLogin" method="post" onsubmit="return emailLogin()">

            <div class="mb-3">
                <label for="email" class="form-label">Email Address</label>
                <span id="emailError" style="color:red; visibility:hidden"></span>
                <input type="text" id="email" name="email" onblur="checkEmail()" placeholder="Enter a user email" class="form-control form-control-lg" value="${dto.email}">
            </div>

            <div class="mb-3">
                <label  id="pass" for="password" class="form-label">Password <h7 class="text-center" style="color:red">${emailError}</h7></label>
                <input type="password" id="password" name="password" placeholder="Enter your password" class="form-control form-control-lg" value="${dto.password}">
            </div>
            <div class="col">
                <!-- Simple link -->
                <a href="Forgot" class="text-muted" style="text-decoration: none;">Forgot password?</a>
            </div>
            <input type="submit" id="button" value="Sign in"  style="background-color: rgba(50, 0, 50, 0.9);"class="btn btn-dark btn-sm  form-control-sm  rounded-pill">
            <div class="text-left">
                <p>Not a member? <a href="MetroRegistration" class="link-danger" style="text-decoration: none;">Register</a></p>
            </div>
        </form>
    </main>
    </div>
    </div>
    <!-- Footer -->
    <footer class="bg-dark text-white py-3 fixed-bottom">
        <div class="container text-center">
        <p class="mb-0"><a href="index" style="text-decoration: none"><h7>Back</h7></a></p>
        </div>
    </footer>

    <script type="text/javascript">

    const checkEmail = async () => {
    let emailId = document.getElementById("email").value;
    const emailError = document.getElementById("emailError");
    emailError.style.visibility = "hidden";

    const response = await axios.get("http://localhost:8080/metro-application/email", { params: { email: emailId } });
    if (response.data === "email user already existed") {
        emailError.innerText = response.data;
        emailError.style.visibility = "visible";
        document.getElementById("button").disabled = true;
    } else if (emailId.trim() === "") {
        document.getElementById("email").style.border = "solid 3px red";
        emailError.innerText = "Invalid email";
        emailError.style.visibility = "visible";
        alert("Blanks are not allowed");
        document.getElementById("button").disabled = true;
        return false;
    } else {
        emailError.innerText = "This email does not exist";
        emailError.style.visibility = "visible"; // Show if email does not exist
       document.getElementById("button").disabled = true;
               return false;
    }

    document.getElementById("button").disabled = emailId.trim() === "";
    return true;
};


const password= ()=>{
let password = document.getElementById("password").value;
let pass= document.getElementById("pass").value;
let button = document.getElementById("button");
if(password==="invalid login"){
document.getElementById("password").style.border = "solid 3px red";
document.getElementById("password").style.color="red"
password.innerText="Password didnot Match";
}
};

        function emailLogin() {
            var email = document.getElementById("email").value.trim();
            var pass = document.getElementById("password").value.trim();
            var but = document.getElementById("button");

            if (email === "" || pass === "") {
                alert("Blank fields are not allowed");
                but.disabled = true;
                return false;
            } else {
                but.disabled = false;
                return true;
            }
        }

                $(document).ready(function(){
                    setInterval(function() {
                        $(".carousel").carousel('next');
                    }, 1000);
            });
    </script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
