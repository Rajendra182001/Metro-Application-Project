<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="https://www.x-workz.in/Logo.png"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"/>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
    <header class="bg-dark text-white py-3">
        <div class="d-flex justify-content-between align-items-center">
            <!-- Logo -->
            <img src="https://www.x-workz.in/Logo.png" alt="Coders World Logo" style="max-height: 50px;">
        </div>
    </header>


    <div class="container d-flex justify-content-center align-items-center my-5 flex-grow-1">
        <div class="image-container" style="width: 100%; height: 500px; position: relative; border-radius: 10px;">
            <img src="https://www.constructionworld.in/assets/uploads/d5b9fd6228a2a26ed11bcf6fa1b615b0.jpg"
                 style="width: 100%; height: 100%; object-fit: cover; border-radius: 10px; opacity: 0.5;">
            <div class="overlay" style="position: absolute; top: 0; left: 0; right: 0; bottom: 0;
                 background-color: rgba(0, 0, 0, 0.5); border-radius: 10px;">
            </div>

            <div class="card" style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); width: 70%; height: 400px; background-color: rgba(0, 0, 0, 0.8); border: none; box-shadow: 0 8px 16px rgba(0, 0, 0, 0.5); border-radius: 10px; text-align: center;">
                <div class="card-body">
                    <h5 class="card-title" style="color: white;"><i>Registration</i></h5>
                    <p class="card-text" style="color: white; font-size: 1.2rem;">Home > Create New Account</p>
                    <nav class="text-center">
                        <a href="userRegister" class="btn btn-sm rounded-pill" style="background-color: #D5006D; color: white;">Register</a>
                    </nav>
                        <div class="container text-center mt-5">
                        <h1 id="welcomeMessage" style="font-family: 'Poppins', sans-serif; color:white;"></h1>

                        </div>

                </div>
            </div>

        </div>
    </div>

    <div class="fixed-bottom">
        <footer class="bg-dark text-white text-center py-3 mt-4">
            <p class="mb-0"></p>
        </footer>
    </div>

    <script>
        $(document).ready(function() {
            let message = "Welcome to Namma Metro";
            let index = 0;
            let typingSpeed = 150; // Speed of typing effect

            // Function to type the message
            function typeWriter() {
                if (index < message.length) {
                    $('#welcomeMessage').append(message.charAt(index));
                    index++;
                    setTimeout(typeWriter, typingSpeed);
                } else {
                    // Once typing is done, reset and repeat the effect
                    setTimeout(function() {
                        $('#welcomeMessage').text(''); // Clear the message
                        index = 0; // Reset the index
                        typeWriter(); // Start typing again
                    }, 1000); // Delay before restarting the effect
                }
            }

            typeWriter(); // Start the typing effect when the page is ready
        });
    </script>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

</body>
</html>
