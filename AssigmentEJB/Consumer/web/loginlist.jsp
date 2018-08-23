<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <!-- Google Fonts -->
        <link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
        <link href="css/main1.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <div class="container w-75"  style="background-color: #eee;">
            <div class="panel-heading">
                <div class="panel-title text-center">
                    <h1 class="title1" align="center">Lựa chọn của bạn</h1>
                    <hr />
                </div>
            </div> 
            <div class="row">
                <div class="col-sm-6">
                    <div class="panel-heading">
                        <div class="panel-title text-center">
                            <h4 class="title1" align="center">lịch sử với mã giao dịch</h4>                    
                        </div>
                        <div class="main-login main-center">
                            <form class="form-horizontal" method="POST" action="/WebCustormer/getlist" name="codedg">
                                <div class="form-group">
                                    <label for="codedg" class="cols-sm-2 control-label">Code chermar</label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <span class="input-group-text"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                            <input type="text" class="form-control" name="codedg"  placeholder="Enter Code Custormer"/>
                                        </div>
                                    </div>
                                </div>       
                                <div class="form-group">
                                    <label for="passdg" class="cols-sm-2 control-label">pass chermar</label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <span class="input-group-text"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                            <input type="password" class="form-control" name="passdg" value="${passdg}"  placeholder="Enter pass dg"/>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="start" class="cols-sm-2 control-label">Start</label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <span class="input-group-text"><i class="fas fa-calendar-alt fa-lg" aria-hidden="true"></i></span>
                                            <input type="datetime" class="form-control" name="tripstart" value="2018-01-01" min="2018-01-01" max="2018-12-31"/>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="end" class="cols-sm-2 control-label">End</label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <span class="input-group-text"><i class="fas fa-calendar-alt fa-lg" aria-hidden="true"></i></span>
                                            <input type="datetime" class="form-control" name="tripend" value="2018-12-12" min="2018-01-01" max="2018-12-31"/>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group ">
                                    <input type="submit" class="btn btn-primary btn-lg btn-block login-button" name="buttonsm" value="Submit charmer"/>
                                </div>
                                <div class="login-register">
                                    <a href="index.jsp">Back</a>
                                </div>
                            </form>
                        </div>         
                    </div> 
                </div>

                <div class="col-sm-6">
                    <div class="panel-heading">
                        <div class="panel-title text-center">
                            <h4 class="title1" align="center">lịch sử với mã tài khoản</h4>                    
                        </div>
                        <div class="main-login main-center">
                            <form class="form-horizontal" method="POST" action="/WebCustormer/getlist" name="codeuser">
                                <div class="form-group">
                                    <label for="codeUser" class="cols-sm-2 control-label">Code User</label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <span class="input-group-text"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                            <input type="text" class="form-control" name="codeUser"  placeholder="Enter Code Custormer"/>
                                        </div>
                                    </div>
                                </div>       
                                <div class="form-group">
                                    <label for="codePin" class="cols-sm-2 control-label">code Pin</label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <span class="input-group-text"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                            <input type="password" class="form-control" name="codePin"  placeholder="Enter pass dg"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="start" class="cols-sm-2 control-label">Start</label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <span class="input-group-text"><i class="fas fa-calendar-alt fa-lg" aria-hidden="true"></i></span>
                                            <input type="date" class="form-control" name="tripstart" value="2018-01-01" min="2018-01-01" max="2018-12-31"/>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="end" class="cols-sm-2 control-label">End</label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <span class="input-group-text"><i class="fas fa-calendar-alt fa-lg" aria-hidden="true"></i></span>
                                            <input type="date" class="form-control" name="tripend" value="2018-12-12" min="2018-01-01" max="2018-12-31"/>
                                        </div>
                                    </div>
                                </div>        
                                <div class="form-group ">
                                    <input type="submit" class="btn btn-primary btn-lg btn-block login-button" name="buttonsm"value="Submit User"/>
                                </div>
                                <div class="login-register">
                                    <a href="index.jsp">Back</a>
                                </div>
                            </form>
                        </div>         
                    </div> 
                </div>
            </div>
        </div>
    </body>
</html>
