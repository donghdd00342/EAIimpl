<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="main">
            <form action="Login">
                <h1><span>ADMIN</span><lable> Login </lable></h1>
                <div class="inset">
                    <p>
                        <label for="email">USERNAME</label>
                        <input type="text" name="username" placeholder="" required/>
                    </p>
                    <p>
                        <label for="password">PASSWORD</label>
                        <input type="password" placeholder="" name="password" required/>
                    </p>
                    <p>
                        <input type="checkbox" name="remember" id="remember">
                        <label for="remember">Remember me </label>
                    </p>
                </div> 
                <p class="p-container"> <span><a href="#">Forgot password ?</a></span>
                    <input type="submit" value="Login"></p>
            </form>
        </div>
        <div class="copy-right">
            <p>Design by <a href="#">fpt-Aptech</a></p>
        </div> 
    </body>
</html>
