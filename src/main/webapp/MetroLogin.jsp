<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>


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
    <!-- Main content -->
        <div style="max-width: 600px; margin: auto;">
            <div class="mb-3">
                <h5 class="mb-0"></h5>
            </div>

            <main class="container my-4 ms-6"">
      <h5 class="text-center mb-0 flex-grow-1" style="letter-spacing: 1px;">Sign into your account</h5>
        <form action="onLogin" method="post" onSubmit="return login()">

            <div class="mb-3">
                  <span style="color:black";>UserName:</span>
                  <label id="ibluser" for="userName" class="form-label" style="color:red; visibility:hidden;"></label>
                <input type="text" onBlur="checkUserName()" id="userName" name="userName" placeholder="Enter a user name" class="form-control form-control-lg" value="${dto.userName}"/>
            </div>
            <div class="mb-3">
                <span id="pass" style="color:Red; visibility:hidden;"></span>
                <label  for="password" class="form-label">Password</label>
                <input type="password"  id="password" name="password" placeholder="Enter your password" class="form-control form-control-lg" value="${dto.password}">
            </div>
    <div class="col">
      <!-- Simple link -->
      <a href="Forgot" class="text-muted" style="text-decoration: none;">Forgot password?</a>
    </div>
                   <input type="submit" id="button" value="Sign in" class="btn btn-dark form-control form-control-lg"">
  <div class="text-left">
    <p>Not a member? <a href="MetroRegistration" class="link-danger" style="text-decoration: none;">Register</a></p>
    </div>
        </form>
    </main>




    <!-- Footer -->
    <div class="fixed-bottom">
        <footer class="bg-dark text-white text-center py-3 mt-4" >
        <div class="container text-center">
                <p class="mb-0"><a href="index" style="text-decoration: none"><h7>Back</h7></a></p>
        </div>
    </footer>
    </div>

           <script type="text/javascript">

        $(document).ready(function(){   // sliding image
            setInterval(()=> {
                $(".carousel").carousel('next');
            }, 1000);
    });

           const checkUserName=()=>{
           let UserName= document.getElementById("userName").value;
           var button =   document.getElementById("button");
           console.log(UserName)
           if(UserName.length>3&&UserName.length<=20&&UserName.trim()!=='')
           {
           document.getElementById("ibluser").innerHTML="";
           userName.style.border="solid 3px secondary";
           document.getElementById("ibluser").style.visibility ="visible";
           document.getElementById("ibluser").style.color ="";
           console.log("this is valid userName");
           button.disabled=false;
           }
           else{
           document.getElementById("ibluser").innerHTML ="Enter a valid UserName";
             userName.style.border="solid 1px red";
           document.getElementById("ibluser").style.visibility ="visible";
           document.getElementById("ibluser").style.color ="Red";
           button.disabled=true;
           console.log("Invalid userName");
            }
          }


     const checkEmail=async()=>{
     let emailId= document.getElementById("email").value;
     const response= await axios("http://localhost:8080/metro-application/email?email="+emailId);
     console.log(response.data);

      if(response.data==="email user already existed"){
      document.getElementById("emailError").innerText=response.data;
      }else if(emailId.length<5){
      document.getElementById("emailError").innerText="invalid";
      }else{
      document.getElementById("emailError").innerText="this email is not existed";
    }
    if(emailId.value.trim() == ""){
     alert("blank are not allowed")
     var but = document.getElementById("but");
     but.disabled= true;
      return false;
                        }
                        else
                        {
                        but.disabled = false;
                         return true;
                        }
   }

        function login(){
        var userName =   document.getElementById("userName");
        var password =   document.getElementById("password");
        var button =   document.getElementById("button");
        if(userName.value.trim() == ""){
        alert("blank is not allowed");
        document.getElementById("ibluser").style.visibility="visible";
        userName.style.border="solid 3px red";
        button.disabled = true;
        return false;
         }else if(password.value.trim()== ""){
           document.getElementById("pass").style.visibility="visible";
           password.style.border="solid 3px red";
                 alert("blank is not allowed");
                 button.disabled = true;
                 return false;
         }
         else if(password.value.trim().length<5)
         {
         alert("password too short");
            document.getElementById("pass").style.visibility="visible";
             password.style.border="solid 3px red";
         return false;
         button.disabled=true;
         }else{
         button.disabled = false;
          return true;
          }
          }



    function emailLogin() {
    var email = document.getElementById("email");
    var pass = document.getElementById("pass1");
    var but = document.getElementById("button1");

    if (email.value.trim() === "" || pass.value.trim() === "") {
        alert("Blank fields are not allowed");
        but.disabled = true;
        return false;
    } else {
        but.disabled = false;
        return true;
    }
}

    </script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>

</html>

