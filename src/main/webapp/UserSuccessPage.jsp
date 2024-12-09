    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html>
    <head>
        <link rel="icon" type="image/x-icon" href="https://www.x-workz.in/Logo.png"/>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-..." crossorigin="anonymous">
            <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
            <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet" />
            <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
            <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet" />
            <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
            <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>
            <script src="https://unpkg.com/axios/dist/axios.min.js"></script>

            <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <title></title>
    <body>
    <header class="bg-dark text-white py-3" style="display: flex; justify-content: space-between; align-items: center;">
        <div>
            <img src="https://www.x-workz.in/Logo.png" alt="Coders World Logo" style="max-height: 50px;">
        </div>
        <div class="dropdown mb-1" style="margin-left: auto;">
            <a class="mx-2" href="#" style="color: white; text-decoration: none;" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Travel Info
            </a>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                <a class="dropdown-item" href="fareRules">Tickets</a>
                <a class="dropdown-item" href="LostAndFound">Lost&Found</a>
                <a class="dropdown-item" href="MetroTimings">Metro Timings</a>
            </div>
        </div>
                    <nav class="mx-2">
                    <a href="info"  style="color: white; text-decoration: none">Information</a>
                      </nav>
    </header>

<br>
<div class="image-container" style="position: relative; width: 100%; text-align: center;">
    <img src="https://en-media.thebetterindia.com/uploads/2017/06/Relax37-1152x603.jpg" alt="Relaxing Image" style="width: 100%; height: auto;">
    <!-- Black transparent overlay on top of the image -->
    <div style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; background-color: rgba(0, 0, 0, 0.5); z-index: 1;"></div>
</div>

<!-- Card positioned above the image -->
<div class="card mx-auto" style="max-width: 800px; position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); z-index: 2; width: 90%;">
    <div class="card-body" style="background-color: rgba(255, 255, 255, 0.9); padding: 20px;">
        <h4 class="card-title" style="text-align: center; font-weight: bold;"><b>JOURNEY FARE CALCULATOR</b></h4>
        <form action="ticketForm" id="ticketForm">
            <div class="card mt-4">
                <div class="card-body bg-white" style="background-color: rgba(255, 255, 255, 0.9);">
                    <div class="row mb-3">
                        <input type="email" id="email" name="email" placeholder="user@gmail.com" id="emailId" value="${email.email}" hidden>
                        <input type="number" id="id" name="id" value="${email.id}" hidden>
                        <div class="col-md-4">
                            <label for="source" class="form-label">From:</label>
                            <select class="form-select form-control select2" id="sourceBox" onchange="updatePrice()" name="source" value="${source}" aria-label="Source selection">
                                <option selected>Select Source:</option>
                                <c:forEach var="source" items="${uniqueSources}">
                                    <option value="${source}">${source}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="col-md-4">
                            <label for="destination" class="form-label">To:</label>
                            <select class="form-select form-control select2" onchange="checkPrice()" id="selectBox" name="destination" aria-label="Destination selection">
                                <option selected>Select Destination:</option>
                                <c:forEach var="destination" items="${uniqueDestinations}">
                                    <option value="${destination}">${destination}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="col-md-4" id="priceResult">
                            <label for="price" name="labelPrice" id="labelPriceId" class="form-label">Price:</label>
                            <input type="number" name="price" id="priceId" value="${price.price}" class="form-control form-control-sm" readonly>
                            <p id="priceText"></p>
                        </div>
                    </div>

                    <div class="col-md-8">
                        <button type="submit" id="submitBtn" class="btn btn-danger active btn-sm form-control form-control-sm" style="background-color: purple; color: white;">Book a Ticket</button>
                    </div>
                </div>
                                    <pre style="text-align:center; color:green;">${booked}</pre>

            </div>
        </form>
    </div>
</div>

    <h5 style="text-align:center; color:green;">${price}</h5>
    <div class="container mt-5">
    <h3 style="font-family: Arial, sans-serif; color: black; text-align: center; text-transform: uppercase; letter-spacing: 2px;">
        Benefits Of Contactless Smart Cards
    </h3>
<div class="container mt-5">
    <div class="row">
        <!-- First Image and Information about Smart Cards -->
        <div class="col-md-4 d-flex flex-column align-items-start">
        <h8 style="font-family: Arial, sans-serif; color: green;">->Smart cards will be used to carry multiple trips</h8>
            <img src="https://english.bmrc.co.in/images/metro/tickets/tickets-logo.jpg" alt="Descriptive Alt Text" class="img-fluid" style="height: 200px;">
        </div>

        <div class="col-md-4 d-flex flex-column align-items-center">
        <h8 style="font-family: Arial, sans-serif; color: green;">->Tokens</h8>
            <img src="https://english.bmrc.co.in/images/metro/tickets/coin.jpg" alt="Descriptive Alt Text" class="img-fluid" style="max-height: 200px;">
        </div>

        <!-- Third Image about Smart Card -->
        <div class="col-md-4 d-flex flex-column align-items-end">
        <a href="smartCards" style="font-family: Arial, sans-serif; color: green;">->Smart cards</a>
            <img src="https://english.bmrc.co.in/images/metro/tickets/smartcard.jpg" alt="Descriptive Alt Text" class="img-fluid" style="max-height: 200px;">
        </div>
    </div>
</div>

<!-- Outer Card to hold the "Stored Value Ticket" Text -->
<div class="card mt-5">
    <div class="card-body">
        <!-- Inner Card for "Stored Value Ticket" Information -->
        <div class="card">
            <div class="card-body bg-light">
                <h4 class="card-title"><b>Stored Value Ticket (Varshik)</b></h4>
                <p><b>Smart cards will be used to carry multiple trips.</b></p>
                <p>The User can load an amount in multiples of Rs.50/- upto a maximum of Rs 3000/- into the Smart Card.</p>
                <p>The stored value in the ticket will be reduced to the range of managed trips.</p>
                <p>Get 5% discount for smart cards, over token fare.</p>
            </div>
        </div>
    </div>
</div>
</div>
<div class="card mt-5">
    <div class="card-body">
        <!-- Inner Card for QR Based Ticketing Information -->
        <div class="card">
            <div class="card-body bg-light">
                <h4 class="card-title"><b>BMRCL QR Based Ticketing System</b></h4>
                <p><b>BMRCL has launched QR based ticketing through Namma Metro App and WhatsApp instant messaging. BMRCL is the first Metro in the Global Transit space to introduce end-to-end ticketing system on WhatsApp.</b></p>
                <p>With this facility, commuters can purchase their travel ticket on their smartphone. The instant messaging service on WhatsApp shall also include a Chatbot service, and commuters can reach this chatbot through WhatsApp number 81055-56677. This facility is available in both English and Kannada. For more details, please see: <a href="https://youtu.be/dr66mPsgR3Y" target="_blank">YouTube Video</a></p>
                <h5><b>Purchasing Tickets:</b></h5>
                <p>The commuters can select their desired station of entry and exit on the Namma Metro App or WhatsApp Chatbot. After selecting stations, the fare for the travel is automatically calculated. The commuter can make the payment through their desired digital mode. After the successful payment, the QR ticket is generated on the platform (Namma Metro App or WhatsApp) as chosen by the commuter.</p>
                <h5><b>Gaining Entry and Exit:</b></h5>
                <p>Entry to the station shall be done through the QR ticket generated, and after the completion of the journey, the commuter can present the same QR ticket to the designated slot for QR ticket reading on the AFC gate.</p>
                <h5><b>Validity of the QR Ticket:</b></h5>
                <p>One QR ticket may be brought at a time, and it is valid for one day. The passenger may enter anytime during the day after purchasing a QR ticket.</p>
                <h5><b>Refund Policy:</b></h5>
                <p>The passenger may cancel the QR ticket before entering, if they desire a refund. For cancelled QR tickets, the money will be transferred back to the source account within seven days. In the event that the passenger has entered the AFC gate, no refund will be given. If the QR ticket is not cancelled within a day, no refund will be provided.</p>
                <p><b>Metro QR Code Tickets are also available on Paytm and Yatra App.</b></p>
            </div>
        </div>
    </div>
</div>

    <footer class="bg-dark text-white text-center py-3 mt-4">
        <div class="container text-center">
            <p class="mb-0">
                <a href="userCanLoginHere" style="text-decoration: none; color: white;">
                    Back
                </a>
            </p>
        </div>
    </footer>

    <script type="text/javascript">
      $('.select2').select2();

     function checkUserId(){
     var userId =  document.getElementById("userId").value;
     console.log(userId)
     }
     function updatePrice()
         {
         var select = document.getElementById("sourceBox");
        alert(select.options[select.selectedIndex].value);
         }
        function destination() {
        var select = document.getElementById("selectBox");
        alert(select.options[select.selectedIndex].value);
    }
        const checkPrice = async () => {
        const source = document.getElementById("sourceBox").value;
        const destination = document.getElementById("selectBox").value;
        const email = document.getElementById("email").value;
        const id=    document.getElementById("id").value;
        console.log("Source selected:", source);
        console.log("Destination selected:", destination)
        try {
            const response = await axios.get(`http://localhost:8080/metro-application/sourceAndDestination`, {
                params: {
                    source: source,
                    destination: destination,
                    email:email,
                    id:id
                }
            });
            console.log("Response from server:", response.data);
            const price = response.data;
            if (price===response.data) {
                document.getElementById("priceId").value = price;
                document.getElementById("priceText").innerText ="${price}";
            } else {
                document.getElementById("priceId").value = "";
                document.getElementById("priceText").innerText = "Price not found.";
            }

        } catch (error) {
            console.error("Error fetching price:", error);
        }
    };


    </script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
        </body>
    </html>
