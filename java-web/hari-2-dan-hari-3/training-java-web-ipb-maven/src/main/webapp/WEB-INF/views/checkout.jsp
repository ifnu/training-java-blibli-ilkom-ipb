<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Eccommerce Template</title>
        <!-- Custom styles for this template -->
        <link href="css/style.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
    </head>

    <body>

        <div class="container">

            <header>
                <div class="row">
                    <div class="col-md-4 col-sm-12">
                        <h1 class="logo"><i class="glyphicon glyphicon-tag"></i> Toko <span class="primary">MurahMurah</span></h1>
                        <p class="subtext">Harga Murah, Besok Sampe Rumah</p>
                    </div>
                    <div class="col-md-8 col-sm-12">
                        <c:if test="${not empty customer}">
                            <h3 class="subtext">Selamat datang ${customer.name} ke toko online murahmurah!!</h3>
                        </c:if>
                        <c:if test="${empty customer}">
                            <form class="form-inline" method="POST" action="process-login">
                                <div class="form-group">
                                    <label for="">Email</label>
                                    <input type="email" class="form-control" id="userName" name="userName" placeholder="enter email">
                                </div>
                                <div class="form-group">
                                    <label for="">Password</label>
                                    <input type="password" class="form-control" id="password" name="password" placeholder="password">
                                </div>
                                <button type="submit" class="btn btn-default">Login</button>
                            </form>
                        </c:if>
                    </div>
                </div>
            </header>
            <!-- Static navbar -->
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="http://localhost:8080/training-java-web-ipb-maven/">Home</a></li>
                            <li><a href="#">What's New</a></li>
                            <li><a href="http://localhost:8080/training-java-web-ipb-maven/cart">
                                    Shopping Cart
                                    <c:if test="${not empty cart}">
                                        &nbsp;(${fn:length(cart.orderItems)})
                                    </c:if>
                                </a>
                            </li>
                            <li><a href="#">My Account</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <form action="" class="navbar-form">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="search...">
                                </div>
                                <button type="submit" class="btn btn-default">Search</button>
                            </form>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </nav>

            <section>
                <div class="row">
                    <h2>Thank You for Your Transaction</h2>
                    <table class="table table-striped table-bordered table-hover table-condensed">
                        <tr>
                            <th>Product</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach items="${checkout.orderItems}" var="orderItem">
                            <tr>
                                <td>${orderItem.product.title}</td>
                                <td>Rp. ${orderItem.price}</td>
                                <td>${orderItem.quantity}</td>
                                <td><a href="#">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </table>

                </div>
        </div>
    </section>

</div> <!-- /container -->

<footer>
    <p>My Store Copyright &copy; 2015</p> &middot; <a href="#">Terms</a> &middot; <a href="#">Privacy</a>
</footer>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>
