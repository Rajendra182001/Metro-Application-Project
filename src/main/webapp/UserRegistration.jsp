    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
<html>
<head>
    <title></title>
    <link rel="icon" type="image/x-icon" href="https://www.x-workz.in/Logo.png"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"/>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="https://unpkg.com/@nicesapien0/typewriter.js/typewriter.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <header class="bg-dark text-white text-center py-3">
        <div class="d-flex justify-content-between align-items-center">
            <!-- Logo -->
            <img src="https://www.x-workz.in/Logo.png" alt="Coders World Logo" class="img-fluid" style="max-height: 50px;">
            <h1 class="text-center mb-0 flex-grow-1"></h1>
        </div>
    </header>
    <div class="container mt-5">
        <div class="row">
            <!-- Image Column on the Left (Mobile Responsiveness) -->
            <div class="col-12 col-md-6 d-flex flex-column justify-content-start align-items-center" style="height: 100vh;">
                <img src="https://webtopup.bmrc.co.in/contents/images/bmrc-card-front.png" alt="Descriptive Alt Text" class="img-fluid" style="max-height: 400px;"/>
                <h3 style="margin-top: 20px; text-align: center;" id="typewriterText">
                    <i>Save Money, Save Time Use</i> <b><u>BMRC</u></b> Smart Card
                </h3>
            </div>

            <div class="col-12 col-md-6">
                <div class="card mx-auto" style="max-width: 100%;">
                    <div class="card-header">
                        <h5 class="mb-0">Register Here</h5>
                    </div>
                    <div class="card-body bg-light">
                        <h5>Create New Account</h5>
                        <form action="userRegistration" method="post" onSubmit="return validate(event)">
                        <div class="mb-3">
                            <label id="firstNameLabelId" for="firstName">
                                First Name :
                                <svg xmlns="http://www.w3.org/2000/svg" width="15" height="13" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                                  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0"/>
                                  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8m8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1"/>
                                </svg>
                            </label>
                            <input type="text" id="firstId" name="firstName" onBlur="checkFirstName()" class="form-control" placeholder="Enter only alphabets and spaces" value="${dto.firstName}" required/>
                        </div>

                            <div class="mb-3">
                                <label id="lastNameLabelId" for="lastName">Last Name :</label>
                                <input type="text" id="lastId" name="lastName" onBlur="checkLastName()" class="form-control" placeholder="Enter Your last Name" value="${dto.lastName}" required/>
                            </div>
                            <div class="mb-3">
                                <label id="dateLabelId">DateOfBirth :</label>
                                <input type="date" name="dateOfBirth" onBlur="checkDateOfBirth()" id="dateId" class="form-control" placeholder="Enter Your Date of Birth" required/>
                            </div>
                            <div class="mb-3">
                                <label id="emailLabelId" for="email">Email Address :</label>
                                <input type="email" id="emailId" name="email" onBlur="checkEmail()" class="form-control" placeholder="Enter valid Email address" value="${dto.email}" required/>
                            </div>
                            <div class="mb-3">
                                <label id="mobileLabelId" for="mobile">Mobile No :</label>
                                <input type="text" id="mobileId" name="mobileNumber" class="form-control" onBlur="checkMobileNumber()" placeholder="Enter 10 digit valid mobile number" value="${dto.mobileNumber}" required/>
                            </div>
                            <div class="mb-3">
                                <label id="labelId" for="password">Password :</label>
                                <input type="text" id="passId" name="password" onBlur="checkPassword()" class="form-control" placeholder="Enter Your password" value="${dto.password}" required/>
                            </div>
                            <div class="mb-3">
                                <label id="labelConfirmId" for="ConfirmPassword">ReType Password:</label>
                                <input type="text" id="confirmPasswordId" onBlur="checkConfirm()" class="form-control" name="confirmPassword" placeholder="Enter Your Confirm password" value="${dto.confirmPassword}" required/>
                            </div>
                            <div class="col-md-6 mb-1">
                                <label class="form-label">Gender :</label>
                                <div>
                                    <input type="radio" id="male" name="gender" value="male">
                                    <label for="male">Male</label>
                                    <input type="radio" id="female" name="gender" value="female">
                                    <label for="female">Female</label>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-dark btn-sm rounded-pill" style="background-color: purple; color: white;" onclick="checkGender()" id="btnId">Register</button>
                            <p class="mandatory-text">* Mandatory Fields</p>
                            <p class="terms-text"><i>Please read below Terms and Conditions</i></p>
                            <ul style="color: black; margin-top: 20px; font-size: 14px;">
                                <li>Smart Card Engraved Id that you want to register should be correct. BMRC will not be liable if you enter incorrect Engraved Id.</li>
                                <li>Your metro card balance can be updated immediately after successful recharge at Card Top-Up Terminals (CTTs) installed at all metro stations.</li>
                                <li>You can update the balance of your metro card at Card Top-Up Terminals (CTTs) till 15 days from the date of recharge.</li>
                                <li>Also, your metro card balance will be automatically updated on the AFC entry gate (during tapping of your card at AFC entry gates) at any Bangalore Metro station after 1 hour and before 7 days from the time of successful recharge.</li>
                                <li>If the smart card is not presented at CTT or Automatic gate for card balance update within 15 days from the date of recharge, the amount will be refunded automatically after deducting a service fee of 2.5% within 30 days.</li>
                            </ul>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="successModal" tabindex="-1" role="dialog" aria-labelledby="successModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="successModalLabel">Registration Success</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Registration completed successfully! Welcome aboard.
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

    <div class="fixed-bottom">
        <footer class="bg-dark text-white text-center py-3 mt-4">
            <p class="mb-0"></p>
        </footer>
    </div>


<script type="text/javascript">
    const button = document.getElementById("btnId");

const checkFirstName = () => {
    var regex = /^[A-Za-z\s]+$/;
    let firstName = document.getElementById("firstId").value;
    const button = document.getElementById("btnId");
    const label = document.getElementById("firstNameLabelId");

    if (firstName.length > 3 && firstName.length <= 20 && firstName.trim() !== '' && regex.test(firstName)) {
        console.log("valid first name");
        label.innerHTML = "First Name:";
         document.getElementById("firstId").style.border = "none";
        button.disabled = false;
    } else {
        console.log("Invalid first name");
        label.innerHTML = "<pre>Invalid</pre>";
         label.style.color = "";
         label.innerHTML = "First Name:";
        document.getElementById("firstId").style.border = "solid 1px red";
        button.disabled = true;
    }
};

document.getElementById("firstId").addEventListener("input", checkFirstName);

    const checkLastName = () => {
        var regex = /^[A-Za-z\s]+$/;
        let lastName = document.getElementById("lastId").value;
         let labelId = document.getElementById("labelId").value;
        const button = document.getElementById("btnId");
        if (lastName.length>0 && lastName.trim() !== '') {
        document.getElementById("lastlId").style.border = "none";
            button.disabled = false;
        } else {
            document.getElementById("lastId").style.border = "solid 1px red";
            document.getElementById("lastNameLabelId").style.visibility = "visible";
            document.getElementById("lastNameLabelId").style.color = "Black";
            button.disabled = true;
        }
    };

    const checkEmail = async () => {
        let emailId = document.getElementById("emailId").value;
         const button = document.getElementById("btnId");
        const response = await axios("http://localhost:8080/metro-application/FindEmail?email=" + emailId);
        if (response.data === "email user already existed") {
            document.getElementById("emailLabelId").innerText = response.data;
            button.disabled = true;
        } else if (emailId.length < 5 || !/\S+@\S+\.\S+/.test(emailId)) {
            document.getElementById("emailLabelId").innerHTML = "<i>Please enter a valid email</i>";
            document.getElementById("emailLabelId").style.color = "red";
            button.disabled = true;
        } else {
            document.getElementById("emailLabelId").innerText = "";
            console.log("valid email");
            button.disabled = false;
        }
    };

    const checkPassword = () => {
        let password = document.getElementById("passId").value;
         const button = document.getElementById("btnId");
        if (password.length > 5) {
            console.log("valid password");
            button.disabled = false;
        } else {
            document.getElementById("passId").style.border = "solid 1px red";
            document.getElementById("passId").style.color = "red";
            button.disabled = true;
            console.log("Invalid password");
        }
    };

    const checkMobileNumber = () => {
        let mobileNumber = document.getElementById("mobileId").value;
         const button = document.getElementById("btnId");
        if (mobileNumber.length === 10) {
            console.log("valid mobile number");
            button.disabled = false;
        } else {
            document.getElementById("mobileId").style.border = "solid 1px red";
            document.getElementById("mobileId").style.color = "red";
            button.disabled = true;
            console.log("invalid mobile number");
        }
    };

    const checkGender = () => {
        let male = document.getElementById("male");
        let female = document.getElementById("female");
        const button = document.getElementById("btnId");
        if (male.checked || female.checked) {
            button.disabled = false;
        } else {
            button.disabled = true;
            alert("Please select gender.");
        }
    };

const checkConfirm = () => {
    const password = document.getElementById("passId").value;
    const confirmPassword = document.getElementById("confirmPasswordId").value;
    const button = document.getElementById("btnId");

    if (password === confirmPassword && password !== "") {
        button.disabled = false;
        document.getElementById("confirmPasswordId").style.border = "";
        document.getElementById("confirmPasswordId").style.color = "";
    } else {
        button.disabled = true;
        document.getElementById("confirmPasswordId").style.border = "solid 1px red";
        document.getElementById("confirmPasswordId").style.color = "red";
        if (password === "" && confirmPassword === "") {
            alert("Password and Confirm Password do not match.");
        }
    }
};

    const checkDateOfBirth = () => {
        let dateOfBirth = document.getElementById("dateId").value;
        let today = new Date().toISOString().split('T')[0];
            const button = document.getElementById("btnId");
        if (dateOfBirth === today) {
            document.getElementById("dateLabelId").innerHTML = "<pre>Not a valid date</pre>";
            document.getElementById("dateId").style.border = "solid 1px red";
            document.getElementById("dateLabelId").style.color = "red";
            button.disabled = true;
        } else {
            document.getElementById("dateLabelId").innerText = "";
            document.getElementById("dateId").style.border = "solid 1px green";
            button.disabled = false;
        }
    };

</script>

</body>
</html>
