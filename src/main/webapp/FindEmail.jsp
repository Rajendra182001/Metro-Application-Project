<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="https://www.x-workz.in/Logo.png"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-..." crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

    <header class="bg-dark text-white py-3">
        <div class="d-flex justify-content-between align-items-center">
            <!-- Logo -->
            <img src="https://www.x-workz.in/Logo.png" alt="Coders World Logo" style="max-height: 50px;">
            <!-- Heading -->
                        </div>
                   </header>


                                 <div class="d-flex justify-content-between align-items-center">
                                <form action="FindEmail" class="d-inline">
                                  <input type="text" name="email" class="form-control d-inline" style="width: auto;">
                                  <input type="submit" value="search By Email">
                                </form>

                                 <div class="d-flex justify-content-between align-items-center">
                                <form action="price" class="d-inline">
                                  <input type="number" name="price" class="form-control d-inline" style="width: auto;">
                                  <input type="submit" value="search By price">
                                </form>



                                  <form action="findPriceBySourceAndDestination" class="d-inline">
                                 <input type="number" name="price" class="form-control d-inline" style="width: auto;">
                                <input type="text" name="source" class="form-control d-inline" style="width: auto;">
                                <input type="text" name="destination" class="form-control d-inline" style="width: auto;">
                               <input type="submit" value="search By price">
                                      </form>


<h1>${userRegistrationDto}<h1>
<h5 style="text-align:center; color:green;" >${success}</h5>
<h5 style="text-align:center; color:red;" >${failed}</h5>
<h5 style="text-align:center; color:red;" >${priceDto}</h5>

    <div class="fixed-bottom">
    <footer class="bg-dark text-white text-center py-3 mt-4" >
        <div class="container text-center">
                <p class="mb-0"><a href="MetroLogin" style="text-decoration: none"><h7>Back</h7></a></p>
                </div>
    </footer>
</div>
</body>
</html>