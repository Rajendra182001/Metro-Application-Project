<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<html>
<head>
        <title>This is Coders World</title>
    <link rel="icon" type="image/x-icon" href="https://www.x-workz.in/Logo.png"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"/>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>

</head>
<body>
    <!-- Header -->
    <header class="bg-dark text-white text-center py-3">
        <div class="d-flex justify-content-between align-items-center">
            <!-- Logo -->
            <img src="https://www.x-workz.in/Logo.png" alt="Coders World Logo" style="max-height: 50px;">
            
            <!-- Heading -->
       <h1 class="text-center mb-0 flex-grow-1"></h1>
        </div>
    </header>

<div>
<h1></h1>
</div>
    <div style="text-align: center";>
        <img src="https://webtopup.bmrc.co.in/contents/images/banner-inner.jpg" style="max-height: 250px; max-width: 100%; height: auto;">
    </div>
<div class="text-center mb-2">
<h6><a href="index" style="text-decoration: none"><h7>Home</h7></a> > Create New Account</h6>
</div>

    <div class="container mt-5">
        <div class="row">
            <!-- Image Column on the Left -->
            <nav class="col-md-6 d-flex justify-content-center align-items-center">
                <img src="https://webtopup.bmrc.co.in/contents/images/bmrc-card-front.png" alt="Descriptive Alt Text" class="img-fluid" style="max-height: 700px;"/>
                <h2 style="margin-top: 20px; text-align: right;">
                          <i>Save Money,
                          Save Time
                          Use</i> <b>BMRC</b> Smart Card</h2></nav>
        <div class="card mx-auto" style="max-width: 400px;">
            <div class="card-header">
                <h5 class="mb-0">User Registration Form</h5>
            </div>
            <div class="card-body">
                <form action="onRegister" method="post" onSubmit="return validate()">
                    <div class="mb-3">
                        <span id="first"></span>
                        <label  id="fName" style="color green;visibility hidden"for="first" class="form-label">First Name*</label>
                        <input type="text" name="firstName" id="firstName" onBlur="checkFirstName()" class="form-control" placeholder="Enter your first name" value="${dto.firstName}" required/>
                    </div>
                    <div class="mb-3">
                          <span id="last" style="color:black; visibility:;"></span>
                      <label  id="lName" style="color green;visibility hidden"for="first" class="form-label">last Name*</label>
                        <input type="text" name="lastName" id="lastName" onBlur="checkLastName()" class="form-control" placeholder="Enter your last name" value="${dto.lastName}" required/>
                    </div>
                    <div class="mb-3">
                           <span id="user" style="color:black; visibility:hidden;"></span>
                        <label  id="uName" for="userName" class="form-label">Username*</label>
                        <input type="text" name="userName" id="userName" onBlur="checkUserName()" class="form-control" placeholder="Enter your username" value="${dto.userName}"required/>
                    </div>
                    <div class="mb-3">
                          <span id="passwordError"></span>
                        <label id="labelPassword"for="password" class="form-label">Password*</label>
                        <input type="password" name="password" id="password" onBlur="checkPassword()" class="form-control" placeholder="Enter your password" value="${dto.password}" required/>
                            <small id="passwordHelpInline" class="text-muted">
                              Must be 8-20 characters long.
                            </small>
               </div>

                    <div class="mb-3">
                          <span id="cId"></span>
                        <label id="lId" for="password" class="form-label">ReType Password*</label>
                        <input type="password" name="confirmPassword" id="confirmPassword" onBlur="checkConfirm()" class="form-control" placeholder="Reenter Password"required/>
               </div>


              <div class="mb-1">
                        <label for="email" class="form-label">Email Address*</label>
                        <span id="emailError" style="color:blue;"></span>
                        <input type="email" name="email" onBlur="checkEmail()" id="email" class="form-control" placeholder="name@example.com" value="${dto.email}" required/>
                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
              </div>
              <div class="mb-1">
                    <span id="mobile" style="color:blue; visibility:hidden;"> </span>
                    <label for="mobileNumber" class="form-label" >Mobile Number*</label>
                    <input type="text" name="mobileNumber" id="mobileNumber" onBlur="checkMobileNumber()" class="form-control" placeholder="Enter your phone number" value="${dto.mobileNumber}"required/>
              </div>

<div class="col-md-6 mb-1">
    <label class="form-label">Gender*</label>
    <div>
        <input type="radio" id="male" name="gender" value="male">
        <label for="male">Male</label>
        <input type="radio" id="female" name="gender" value="female">
        <label for="female">Female</label>
    </div>
</div>
                    <button type="submit" onclick="checkGender()" id="button" class="btn btn-dark btn-sm">Register</button>
                </form>
            </div>
          </div>
      </div>
    <div>
    <!-- Footer -->
        <div class="fixed-bottom">
         <footer class="bg-dark text-white text-center py-3 mt-4" >
    <p class="mb-0"></p>
    </footer>
    </div>

    <script>

    const checkFirstName=()=>{
    var regex = /[A-Za-z]/
     let firstName= document.getElementById("firstName").value;
     var button =   document.getElementById("button");
     console.log(firstName)
     if(firstName.length>3&&firstName.length<=20&&firstName.trim()!==''&&regex.test(firstName))
     {
     console.log("this is valid first name");
     console.log('first name');
             document.getElementById("fName").innerHTML = "FirstName";
             document.getElementById("firstName").style.border = "solid 1px secondary";
             document.getElementById("fName").style.visibility = "visible";
             document.getElementById("fName").style.color = "black";
             button.disabled = false;
              document.getElementById("first").innerHTML = "";
              document.getElementById("first").style.visibility = "hidden";
     }
        else{
             document.getElementById("first").innerHTML ="Invalid";
             document.getElementById("firstName").style.border = "solid 1px red";
             document.getElementById("first").style.visibility ="visible";
             document.getElementById("first").style.color ="Red";
             button.disabled =true;
             console.log("Invalid first  Name");
            }

    }

                   const checkLastName=()=>{
                   var regex = /[A-Za-z]/
                   var button =   document.getElementById("button");
                   let lastName= document.getElementById("lastName").value;
                   console.log("valid last name")
                   if(lastName.length>0&&lastName.trim()!==''&&regex.test(lastName))
                  {
                               document.getElementById("lName").innerHTML = "Last Name";
                               document.getElementById("lastName").style.border = "solid 1px secondary";
                               document.getElementById("lName").style.visibility = "visible";
                               document.getElementById("lName").style.color = "Black";
                               button.disabled = false;
                               document.getElementById("last").innerHTML = "";
                               document.getElementById("last").style.visibility = "hidden";
                   button.disabled=false;
                   }
                   else{
                        document.getElementById("lName").innerHTML ="Invalid";
                        document.getElementById("lastName").style.border = "solid 1px red";
                        document.getElementById("lName").style.visibility ="visible";
                        document.getElementById("lName").style.color ="Red";
                        button.disabled=true;
                        console.log("Invalid LastName");
                      }
                  }


     const checkUserName=()=>{
     let UserName= document.getElementById("userName").value;
     var button =  document.getElementById("button");
     console.log(UserName)
     if(UserName.length>3&&UserName.length<=20&&UserName.trim()!=='')
     {
     console.log("this is valid userName");
     document.getElementById("userName").style.border="solid 1px secondary";
     button.disabled=false;
                       document.getElementById("uName").innerHTML ="User Name";
                       document.getElementById("uName").style.color ="black";
                  document.getElementById("user").style.visibility ="hidden";

     }
     else{
                  document.getElementById("uName").innerHTML ="Invalid";
                  document.getElementById("userName").style.border = "solid 1px red";
                  document.getElementById("uName").style.visibility ="visible";
                  document.getElementById("uName").style.color ="Red";
                 button.disabled=true;
                 document.getElementById("user").style.visibility ="hidden";
     console.log("Invalid userName");
     }
      }


   const checkEmail=async()=> {
   let emailId= document.getElementById("email").value;
   const response= await axios("http://localhost:8080/metro-application/email?email="+emailId);
   console.log(response.data);

    if(response.data==="email user already existed"){
    document.getElementById("emailError").innerText=response.data;
    }else if(emailId.length<5){
    document.getElementById("emailError").innerText="Please enter valid email";
    document.getElementById("emailError").style.color="red";
    }else{
    document.getElementById("emailError").innerText="";
    console.log("valid email")
  }
 }

      const checkPassword=()=>{
      let password=document.getElementById("password").value;
     var button =  document.getElementById("button");
      console.log(password);
      if(password.length>5){
           document.getElementById("password").style.border="solid 1px green";
          document.getElementById("labelPassword").style.visibility ="visible";
        document.getElementById("passwordError").innerHTML ="";
       console.log("valid password");
       button.disabled=false;
      }else{
             document.getElementById("passwordError").style.color ="red";
             document.getElementById("password").style.border="solid 1px red";
                          document.getElementById("passwordError").innerHTML ="Please enter Valid Password";
              button.disabled=true;
              console.log("Invalid password");
      }
 }
       const checkMobileNumber=()=>{
       var button =   document.getElementById("button");
       let mobileNumber= document.getElementById("mobileNumber").value;
       console.log(mobileNumber)
       if(mobileNumber.length==10){
                document.getElementById("mobileNumber").style.border ="solid 1px green";
                                document.getElementById("mobileNumber").style.color ="secondary";
       button.disabled=false;
              document.getElementById("mobile").style.visibility ="hidden";
       console.log("valid mobile number")
       }else{
         document.getElementById("mobileNumber").style.border ="solid 1px red";
       document.getElementById("mobile").style.visibility ="visible";
       document.getElementById("mobile").style.color ="red";
              document.getElementById("mobile").innerHTML ="Please enter valid MobileNumber";
           button.disabled=true;
       console.log("invalid mobile number")
    }
 }
const checkGender = () => {
    var button = document.getElementById("button");
    let male = document.getElementById("male");
    let female = document.getElementById("female");

    if (male.checked) {
        alert("The male has been selected");
    } else if (female.checked) {
        alert("The female has been selected");
    } else {
        button.disabled = true;
        alert("Select the gender");
    }
};

   const checkConfirm = () => {
    var button = document.getElementById("button");
    let confirm = document.getElementById("confirmPassword").value;
    let password=document.getElementById("password").value;
  if(confirm==password){
        alert("correct");
        button.disabled=false;
  }else{
        alert("Confirm Password is not same as Password");
        button.disabled=true;
  }
};



   function validate(){

    var firstName = document.getElementById("firstName");
    var lastName = document.getElementById("lastName");
    var userName = document.getElementById("userName");
    var password = document.getElementById("password");
    var email = document.getElementById("email");
    var  mobileNumber   =document.getElementById("mobileNumber")
    var gender = document.getElementById("gender");
    var button =   document.getElementById("button");
    if(firstName.value.trim() == "" ||lastName.value.trim() == ""||userName.value.trim() == ""||password.value.trim() == "" || email.value.trim() == "" || mobileNumber.value.trim() == "" ||
    gender.value.trim() == ""){
    alert("no blanks are allowed");
    button.disabled = true;
    return false;
    }else
    {
     button.disabled =false;
    true;
    }
       if(password.value.trim().length<5){
        password.style.border ="solid 3px red";
        document.getElementById("passwordError").innerText="Invalid";
        alert("password too short");
        button.disabled = true;
        return false;
        }else{
        document.getElementById("passwordError").innerText="Valid";
         button.disabled =false;
         return true;
    }
         if(emailId.length>5){
         document.getElementById("emailError").innerText="";
         button.disabled =false;
         return true;
      }  else{
         document.getElementById("emailError").innerText="InValid";
         document.getElementById("emailError").style.visibility ="visible";
         document.getElementById("emailError").style.color ="red";
         button.disabled=true;
         return false;
      }
}
   </script>
</body>
</html>



