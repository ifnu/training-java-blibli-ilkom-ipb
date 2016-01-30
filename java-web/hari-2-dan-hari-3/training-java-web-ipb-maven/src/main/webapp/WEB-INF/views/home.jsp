<%-- 
    Document   : home
    Created on : Jan 28, 2016, 1:39:13 PM
    Author     : ifnu.b.fatkhan
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                        <h1 class="logo">
                            <i class="glyphicon glyphicon-tag"></i> 
                            Toko <span class="primary">MurahMurah</span>
                        </h1>
                        <p class="subtext">Harga Murah, Besok Sampe Rumah</p>
                    </div>
                    <div class="col-md-8 col-sm-12">
                        <c:if test="${not empty customer}">
                            <h3 class="subtext">
                                Selamat datang <i><b>${customer.name} (${customer.email}) </i></b>
                                ke Toko online MurahMurah
                            </h3>
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
                            <li class="active"><a href="#">Home</a></li>
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

            <!-- Main component for a primary marketing message or call to action -->
            <div class="jumbotron">

                <!-- Nav tabs -->
                <ul class="tablist" role="tablist">
                    <li role="presentation" class="active"><a href="#featured" aria-controls="featured" role="tab" data-toggle="tab">Featured Item</a></li>
                    <li role="presentation"><a href="#best" aria-controls="best" role="tab" data-toggle="tab">Best Seller</a></li>
                    <li role="presentation"><a href="#discount" aria-controls="discount" role="tab" data-toggle="tab">Summer Discount</a></li>
                    <li role="presentation"><a href="#premium" aria-controls="premium" role="tab" data-toggle="tab">Premium Product</a></li>
                    <li role="presentation"><a href="#gift" aria-controls="gift" role="tab" data-toggle="tab">Gift Idea</a></li>
                </ul>

                <!-- Tab panes -->
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="featured">
                        <div class="tab-text">
                            <h2>Apple iPhone 6</h2>
                            <p>This is a paragraph with a bunch of sample text, I am just going to grab real quick.</p>
                            <a href="product.html" class="btn btn-default">Read More</a>
                        </div>
                        <img src="img/iphone.png" class="slide-img">
                    </div>
                    <div role="tabpanel" class="tab-pane" id="best">
                        <div class="tab-text">
                            <h2>Xbox One</h2>
                            <p>This is a paragraph with a bunch of sample text, I am just going to grab real quick.</p>
                            <a href="product.html" class="btn btn-default">Read More</a>
                        </div>
                        <img src="img/xbox.png" class="slide-img">
                    </div>
                    <div role="tabpanel" class="tab-pane" id="discount">
                        <div class="tab-text">
                            <h2>Playstation 4</h2>
                            <p>This is a paragraph with a bunch of sample text, I am just going to grab real quick.</p>
                            <a href="product.html" class="btn btn-default">Read More</a>
                        </div>
                        <img src="img/ps4.png" class="slide-img">
                    </div>
                    <div role="tabpanel" class="tab-pane" id="premium">
                        <div class="tab-text">
                            <h2>Microsoft Surface</h2>
                            <p>This is a paragraph with a bunch of sample text, I am just going to grab real quick.</p>
                            <a href="product.html" class="btn btn-default">Read More</a>
                        </div>
                        <img src="img/surface.png" class="slide-img">
                    </div>
                    <div role="tabpanel" class="tab-pane" id="gift">
                        <div class="tab-text">
                            <h2>Vizio TV</h2>
                            <p>This is a paragraph with a bunch of sample text, I am just going to grab real quick.</p>
                            <a href="product.html" class="btn btn-default">Read More</a>
                        </div>
                        <img src="img/tv.png" class="slide-img">
                    </div>
                </div>

            </div>

            <section id="products">
                <div class="row">
                    <c:forEach items="${products}" var="product">
                    <div class="col-md-4">
                        <div class="thumbnail">
                            <a href="${product.productUrl}"><img src="${product.imageUrl}"></a>
                            <div class="caption">
                                <h4 class="pull-right">
                                    Rp. ${product.price}
                                </h4>
                                <h4>
                                    <a href="${product.productUrl}">${product.title}</a>
                                </h4>
                                <p>${product.description}</p>
                            </div>
                            <div class="ratings">
                                <p class="pull-right">15 Reviews</p>
                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                </p>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
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
