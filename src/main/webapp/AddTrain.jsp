<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
                <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
            <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
    <header class="bg-dark text-white py-3">
        <div class="d-flex justify-content-between align-items-center">
            <!-- Logo -->
            <img src="https://www.x-workz.in/Logo.png" alt="Coders World Logo" style="max-height: 50px;">
                        <nav class="d-flex justify-content-center">
                        <a href="addLocations?email=${dto.email}" class="btn btn-dark btn-sm mx-2 ">Locations</a>
                        <a href="addTimings?email=${dto.email}" class="btn btn-dark btn-sm mx-2">Timings</a>
                        <a href="addTrainType?email=${dto.email}" class="btn btn-dark btn-sm mx-2">Add Train</a>
                         <a href="addPriceList?email=${dto.email}" class="btn btn-dark btn-sm mx-2">Price</a>
                         <a href="readTrain?email=${dto.email}" class="btn btn-dark btn-sm mx-2">View Data</a>
                        </nav>
            <!-- Heading -->
            <h1 class="text-center mb-0 flex-grow-1"></h1>
                        <div class="dropdown">
                   <img src="${pageContext.servletContext.contextPath}/getImage/${dto.imageName}" class="rounded-circle" alt="img" width=90/>
                   <a class="btn btn-sm btn-secondary dropdown-toggle dropdown-toggle-split mx-3" href="" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                   ${dto.userName} </a>
                            <div class="dropdown-menu" aria-labelledby="${dto.userName}">
                                <a class="dropdown-item" href="UpdateProfile?email=${dto.email}">Profile</a>
                                <a class="dropdown-item" href="MetroLogin">Log out</a>
                                <a class="dropdown-item" href="index.jsp">Home</a>
                            </div>
                        </div>
                    </div>
        </div>
    </header>
<h5 style="text-align:center;">${success}</h5>
<h5 style="text-align:center;">${Unsaved}</h5>
           <br>
           <nav class="d-flex align-items-center justify-content-center" >
            <img src="https://webtopup.bmrc.co.in/contents/images/banner-inner.jpg" alt="Descriptive Alt Text" class="img-fluid" style="max-height: 200px; width:1000px">
        </nav>

    <div style="max-width: 1000px; margin: auto;">
        <div class="mb-3">
            <h5 class="mb-0"></h5>
        </div>
        <div class="d-flex align-items-center justify-content-center" style="border-radius: 15px; overflow: hidden;">
            <div class="card-body" style="background-color: black;">
            <form action="addTrain" method="post">
       <div class="col-md-6 mb-1">
         <div class="mb-3">
        <div>
         <h5 class="text-right" style="color:white">ADD TrainType And Train Number</h5>
        </div>
       <label for="email" class="form-label" hidden>email</label>
       <input type="text"  name="email" id="email" class="form-control" placeholder="Enter the email" value="${dto.email}" hidden>
       </div>

           <div class="mb-3">
           <label for="trainNumber" class="form-label" style="color:white">Train Number</label>
           <input type="text"  name="trainNumber" id="trainNumber" class="form-control" placeholder="Enter the Train Number" required/>
            </div>
            <div class="mb-3">
                <label for="addTrainType" class="form-label" style="color:white">Add Train Type</label>
                <select name="trainType" id="trainType" class="form-control form-control select2" required>
                    <option value="">Select Train Type</option>
                    <option value="Purple">Purple</option>
                    <option value="Green">Green</option>
                </select>
            </div>
                    <button type="submit" id="button" class="btn btn-danger btn-sm btn- rounded-sm ">Add</button>
           </div>
            </form>
            </div>
        </div>
    </div>

                                  <form action="trainType"hidden>
                                        <input type="text" name="trainType" class="form-control d-inline" style="width: auto;"  hidden>
                                </form>
                                    <form action="number"hidden>
                                          <input type="text" name="trainNumber" class="form-control d-inline" style="width: auto;"  hidden>
                                  </form>

        <div class="fixed-bottom">
        <footer class="bg-dark text-white py-3">
            <div class="container text-center">
                <p class="mb-0"></p>
            </div>
        </footer>
        </div>

        <script type="text/javascript">
              $('.select2').select2();
        </script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

</body>
</html>