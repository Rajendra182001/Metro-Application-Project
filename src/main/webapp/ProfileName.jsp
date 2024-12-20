<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>This is Coders World</title>
    <link rel="icon" type="image/x-icon" href="https://www.x-workz.in/Logo.png"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-..." crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<title></title>
<body>
    <header class="bg-dark text-white text-center py-3">
        <div class="d-flex justify-content-between align-items-center">
       <img src="https://www.x-workz.in/Logo.png" alt="Coders World Logo" style="max-height: 50px;">
       <h1 class="text-center mb-0 flex-grow-1"></h1>
<div style="text-align: center;">
    <img src="${pageContext.servletContext.contextPath}/getImage/${dto.imageName}" class="rounded-circle" alt="img" width=100/>
</div>

    </header>



        <div class="card mx-auto" style="max-width: 400px;">
            <div class="card-header">
                <h5 class="mb-0"></h5>
            </div>
            <div class="card-body">
            <div style="text-align: center;">
                <img src="${pageContext.servletContext.contextPath}/getImage/${dto.imageName}" class="rounded-circle" alt="img" width=200/>
            </div>

                <form action="UpdateUser" method="post" enctype="multipart/form-data">
                 <input type="text" name="id" placeholder="enter a id" class="form-control form-control-lg" value="${dto.id}" hidden>
                    <div class="mb-1">
                        <span id="fName" style="color:pink; visibility:hidden;"></span>
                        <label for="firstName" class="form-label">First Name</label>
                        <input type="text" name="firstName" id="firstName"" class="form-control" placeholder="Enter your first name" value="${dto.firstName}" required/>
                    </div>
                    <div class="mb-1">
                          <span id="lName" style="color:pink; visibility:hidden;"></span>
                        <label for="lastName" class="form-label">Last Name</label>
                        <input type="text" name="lastName" id="lastName"  class="form-control" placeholder="Enter your last name" value="${dto.lastName}" required/>
                    </div>
                    <div class="mb-1">
                           <span id="uName" style="color:pink; visibility:hidden;" hidden></span>
                        <label for="userName" class="form-label" hidden>Username</label>
                        <input type="text" name="userName" id="userName" class="form-control" placeholder="Enter your username" value="${dto.userName}"hidden/>
                    </div>
                    <div class="mb-1">
                          <span id="passwordError" style="color:Red; visibility:hidden;"></span>
                        <label for="password" class="form-label" hidden>Password</label>
                        <input type="password" name="password" id="password"  class="form-control" placeholder="Enter your password" value="${dto.password}" hidden/>
                            <small id="passwordHelpInline" class="text-muted" hidden>
                              Must be 8-20 characters long.
                            </small>
                    </div>
                    <div class="mb-1">
                        <label for="email" class="form-label">Email Address</label>
                        <span id="emailError" style="color:blue;"></span>
                        <input type="email" name="email" onBlur="checkEmail()" id="email" class="form-control" placeholder="name@example.com" value="${dto.email}" required/>
                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                    </div>
                    <div class="mb-1">
                        <span id="mobile" style="color:blue; visibility:hidden;"> </span>
                        <label for="mobileNumber" class="form-label" >Mobile Number</label>
                        <input type="text" name="mobileNumber" id="mobileNumber" class="form-control" placeholder="Enter your phone number" value="${dto.mobileNumber}"required/>
                    </div>
                    <div class="mb-1">
                        <input type="text" name="gender" id="gender"  class="form-control" placeholder="Enter your gender" value="${dto.gender}" hidden>
                        </div>
                         <div class="mb-1">
                         <input type="file" name="file" /><br/>
                         </div>
                    <div class="mb-1">
                    <button type="submit" id="button" class="btn btn-dark btn-sm rounded-pill">Edit</button>
                    <div>
                </form>
            </div>
        </div>
</div>
</div>
    <footer class="bg-dark text-white py-3">
        <div class="container text-center">
        <p class="mb-0"><a href="index" style="text-decoration: none"><h7>Back</h7></a></p>
    </footer>
</div>

</body>
</html>