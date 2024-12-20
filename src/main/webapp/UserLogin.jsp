<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title></title>
    <link rel="icon" type="image/x-icon" href="https://www.x-workz.in/Logo.png"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"/>
</head>
<body>
    <header class="bg-dark text-white text-center py-3">
        <div class="d-flex justify-content-between align-items-center">
            <!-- Logo -->
            <img src="https://www.x-workz.in/Logo.png" alt="Coders World Logo" style="max-height: 50px;">
            <!-- Heading -->
            <h1 class="text-center mb-0 flex-grow-1"></h1>
        </div>
    </header>

    <div class="container d-flex justify-content-center align-items-center my-5 flex-grow-1" style="position: relative; text-align: center;">
        <img src="https://www.constructionworld.in/assets/uploads/d5b9fd6228a2a26ed11bcf6fa1b615b0.jpg" style="width: 100%; height: 500px; object-fit: cover; opacity: 0.7;">

        <div style="position: absolute; top: 0; left: 0; right: 0; bottom: 0; background-color: rgba(0, 0, 0, 0.5); z-index: 1;"></div>

        <div style="position: absolute; top: 20%; left: 50%; transform: translateX(-50%); z-index: 2; background-color: rgba(0, 0, 0, 0.7); color: white; padding: 20px; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);">
            <h5 class="card-title text-center" style="color:green"><i>Admin Login:</i></h5>
            <p class="card-text text-center"><h7>Home</h7> > Login to Access Your Account</p>
            <nav class="text-center">
                <a href="inLogin" class="btn btn-sm btn-block rounded-pill" style="background-color: #D5006D; color: white;">Login</a>
            </nav>
        </div>

        <div style="position: absolute; top: 60%; left: 50%; transform: translateX(-50%); z-index: 2; background-color: rgba(0, 0, 0, 0.7); color: white; padding: 20px; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);">
            <h5 class="card-title text-center" style="color:green"><i>User Login:</i></h5>
            <p class="card-text text-center"><h7>Home</h7> > Login to Access Your Account </p>
            <nav class="text-center">
                <a href="userCanLoginHere" class="btn btn-sm btn-block rounded-pill" style="background-color: #D5006D; color: white;">Login</a>
            </nav>
        </div>
    </div>

    <div class="fixed-bottom">
        <footer class="bg-dark text-white text-center py-3 mt-4">
            <div class="container text-center">
                <p class="mb-0"><a href="index" style="text-decoration: none; color: white;"><h7>Back</h7></a></p>
            </div>
        </footer>
    </div>
</body>
</html>
