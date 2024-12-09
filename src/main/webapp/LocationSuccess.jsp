<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>This is Coders World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>

<body>
    <header class="bg-dark text-white text-center py-3">
        <div class="d-flex justify-content-between align-items-center">
            <!-- Logo -->
            <img src="https://www.x-workz.in/Logo.png" alt="Coders World Logo" style="max-height: 50px;">
            <nav>
            <a href="addLocations" class="btn btn-dark btn-sm">Add Locations</a>
            </nav>
            <!-- Heading -->
            <h1 class="text-center mb-0 flex-grow-1">User Profile</h1>
            <!-- Dropdown -->
            <div class="dropdown">
                <img src="${pageContext.servletContext.contextPath}/getImage/${dto.imageName}" class="rounded-circle" alt="img" width=90/>
                <a class="btn btn-secondary dropdown-toggle" href="" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
       ${dto.userName}
                </a>
                <div class="dropdown-menu" aria-labelledby="${dto.userName}">
                    <a class="dropdown-item" href="UpdateProfile?email=${dto.email}">Profile</a>
                    <a class="dropdown-item" href="MetroLogin">Log out</a>
                    <a class="dropdown-item" href="index.jsp">Home</a>
                </div>
            </div>
        </div>
    </header>

<h1>${success}</h1>
<h1>${unsuccess}</h1>

        <div class="fixed-bottom">
        <footer class="bg-dark text-white py-3">
            <div class="container text-center">
                <p class="mb-0"></p>
            </div>
        </footer>
        </div>

            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>


</body>

</html>