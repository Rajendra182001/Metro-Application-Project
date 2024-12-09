<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Metro Official Front Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://unpkg.com/@nicesapien0/typewriter.js/typewriter.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> <!-- jQuery CDN -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/typescript/4.0.5/typescript.js"></script> <!-- TypeScript CDN -->

</head>
<body>
    <header class="bg-dark text-white text-center py-3">
        <div class="d-flex justify-content-between align-items-center">
            <!-- Logo -->
            <div>
            <img src="https://www.x-workz.in/Logo.png" alt="Coders World Logo" style="max-height: 50px;">
            </div>
            <!-- Heading -->
                 <h1 class="text-center mb-0 flex-grow-1" ></h1>
            <nav class="mx-0">
            <a href="MetroRegistration" class="btn btn-primary active btn-sm ">Metro Registration</a>
              </nav>
              <br>
            <nav class="mx-2">
            <a href="userLogin" class="btn btn-primary active btn-sm ">Login</a>
              </nav>
            <nav class="mx-2">
            <a href="readTimings" class="btn btn-primary active btn-sm ">Metro-Timings</a>
              </nav>

    </header>
<h1 style="text-align: center; font-size:25px; margin-top: 5px; margin-bottom: 5px;"><b>ನಮ್ಮ ಮೆಟ್ರೋಗೆ ಸುಸ್ವಾಗತ</b></h1>


   <div class="mt-5 text-center">
           <marquee><pre class="text-center mb-4 text-success">The Government of Karnataka announced extensions and routes for the Namma Metro on October 2, 2024. The new corridors will add 59 km of length to the system.</pre></marquee>
    </div>
        <div class="typewriter-effect">
        <div id="typewriter-text" class="text">
        </div>
        </div>
        <div class="text-center">
       <a href="MetroRegistration" class="btn btn-dark btn-sm">enroll now</a>
        </div>

<div class="text-center mt-3">
    <img src="https://english.bmrc.co.in/images/metro/footer-img.png" alt="Descriptive Alt Text" class="img-fluid">
</div>



    <!-- Overlay Card (Black Transparent) -->
    <div style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); background-color: rgba(0, 0, 0, 0.7); color: white; padding: 20px; border-radius: 15px; text-align: center; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);">
        <p style="font-size: 12px; margin: 0;">Want to book a ticket?</p>
                <a href="userLogin" style="text-decoration: none; color: white; background-color: rgba(0, 0, 0, 0.5); padding: 15px 30px; border-radius: 8px; font-size: 16px; display: inline-block; margin-top: 15px; width: auto; transition: background-color 0.3s ease-in-out;">Click Here</a>

    </div>

<div style="background-color: white; padding: 20px;">
    <!-- Main Card Layout -->
    <div style="display: flex; justify-content: space-between; background-color: rgba(0, 0, 0, 0.7); color: white; padding: 20px; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);">

        <div style="flex: 1; padding: 10px;">
            <div style="background-color: rgba(0, 0, 0, 0.5); color: white; border-radius: 10px; text-align: center; padding: 20px;">
                <h2 class="card-title mb-3"></h2>
                <img src="https://mir-s3-cdn-cf.behance.net/project_modules/disp/fb925221893757.5665bb0ba3c4d.gif" alt="GIF" style="width: 100%; height: auto; border-radius: 10px;">
            </div>
        </div>

        <div style="flex: 1; padding: 10px;">
            <div style="background-color: rgba(0, 0, 0, 0.5); color: white; border-radius: 10px; text-align: center; padding: 20px; display: flex;">
                <!-- Third Image on the Left Side of the Second Image -->
                <div style="flex: 1; padding: 10px;">
                    <img src="https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/681bbd21893757.5665bb0b6bdb3.jpg" alt="Image 1" style="width: 100%; height: auto; border-radius: 10px;">
                </div>
                <div style="flex: 1; padding: 10px;">
                    <img src="https://mir-s3-cdn-cf.behance.net/project_modules/disp/fb925221893757.5665bb0ba3c4d.gif" alt="GIF" style="width: 100%; height: auto; border-radius: 10px;">
                </div>
            </div>
        </div>
    </div>

    <div style="background-color: rgba(0, 0, 0, 0.5); color: white; border-radius: 10px; text-align: center; padding: 20px; margin-top: 20px;">
        <h2 class="card-title mb-3"></h2>
        <img src="https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/6fbd1f21893757.5665bb0b8536b.jpg" alt="Image 2" style="width: 100%; height: auto; border-radius: 10px;">
    </div>
</div>


<footer class="bg-dark text-white text-center py-3 mt-4" style="position: fixed; bottom: 0; width: 100%; z-index: 999;">
    <div class="container text-center">
        <nav>
        </nav>
        <div class="left">
            <h7 id="currentDateTime"></h7>
        </div>
    </div>
</footer>


          <script>

          let time=new Date();
          console.log()
          document.getElementById("currentDateTime").innerText=time.toLocaleDateString() + "  "+time.toLocaleTimeString();

   typewriterConfig = ["Click here to enroll ", true]
    typewriter();

          </script>

</div>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

</body>
</html>
