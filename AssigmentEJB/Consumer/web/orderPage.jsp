<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>order Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
        <!-- Google Fonts -->
        <link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
        <link href="main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="row main">
                <div class="panel-heading">
                    <div class="panel-title text-center">
                        <h1 class="title">Infor Order</h1>
                        <hr />
                    </div>
                </div> 
                <div class="main-login main-center">
                    <form class="form-horizontal" method="POST" action="/WebCustormer/order">
                        <div class="form-group">
                            <label for="codeOrder" class="cols-sm-2 control-label">Code Order</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="codeOrder"  placeholder="Enter Code Order"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="nameOrder" class="cols-sm-2 control-label">chosen Order</label>
                            <div class="cols-sm-10">        
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fab fa-jedi-order" aria-hidden="true"></i></span>
                                    <div class="form-control">
                                    <input style="margin-left: 10px;" type="radio" name="nameOrder" value="0" checked> your fee 
                                    <input style="margin-left: 10px;"type="radio" name="nameOrder" value="1"> Custormer's fee<br></div>
                                     
                                </div>
                            </div>
                        </div>
                                
                        <div class="form-group">
                            <label for="moneyOrder" class="cols-sm-2 control-label">Money Order</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fas fa-money-check-alt" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="moneyOrder" value="${moneyOrder}"  placeholder="Enter bills of money"/>
                                </div>
                            </div>
                        </div>        

                        <div class="form-group" >
                            <label for="codeCustomer" class="cols-sm-2 control-label">Username</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                                    <input hidden="true" type="text" class="form-control" name="codeCustomer" value="${sessionScope.codeCustormer}"  iplaceholder="Enter code khach hang"/>
                                </div>
                            </div>
                        </div>
                                
                        <div class="form-group">
                            <label for="codeUser" class="cols-sm-2 control-label">Code User</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="codeUser" value="${codeUser}"  placeholder="Enter your code"/>
                                </div>
                            </div>
                        </div>        

                        <div class="form-group">
                            <label for="codePin" class="cols-sm-2 control-label">code Pin</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                    <input type="password" class="form-control" name="codePin" value="${codePin}"  placeholder="Enter your pin"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group ">
                            <input type="submit" class="btn btn-primary btn-lg btn-block login-button" value="chuyen tien"/>
                        </div>
                        <div class="login-register">
                            <a href="index.jsp">Back to home</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
