<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="css/index.css">
   <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-growl/1.0.0/jquery.bootstrap-growl.min.js"></script>
  <title>iManage</title>
</head>
<body>
    <section>
        <div class="form-box">
            <div class="form-value">
                <form action="LoginServelet" method="post" >
                    <h2>Login</h2>
                    <div class="inputbox">
                        <ion-icon name="mail-outline"></ion-icon>
                        <input type="text" name="Email" required>
                        <label for="">Username</label>
                    </div>
                    <div class="inputbox">
                        <ion-icon name="lock-closed-outline"></ion-icon>
                        <input type="password" name="Password" required>
                        <label for="">Password</label>
                    </div>
                    
                    <button style="color: #FFF">Log in</button>
                    
                </form>
            </div>
        </div>
    </section>
    <% 
    if( request.getAttribute("name1") != null){
    %><script>
    $(document).ready(function() {
        $.bootstrapGrowl(' Username / Password invalid !!', {
            type: 'error',
            offset: {from: 'top', amount: 75},
            align: 'right',
            width: 350,
            allow_dismiss: true,
            delay: 3000
        });
    });
</script><% }%>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    
</body>
</html>
