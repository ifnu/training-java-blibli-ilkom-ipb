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
        <script>
            //add to cart ajax script
            
        </script>
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
                    <div class="col-md-8">
                        <div class="row">
                            <div class="col-md-4">
                                <img src="${product.imageUrl}" class="main-img">
                            </div>
                            <div class="col-md-8">
                                <h2>${product.title}</h2>
                                <div class="price">
                                    Rp. ${product.price}
                                </div>
                                <hr>
                                <p>Quantity: 
                                    <select class="form-control" id="quantitySelect">
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                    </select>
                                </p>
                                <a href="#" class="btn btn-success" id="buyNow" name="buyNow">Buy Now</a>
                                <br>
                                <br>
                                <br>
                                <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                                    <div class="panel panel-default">
                                        <div class="panel-heading" role="tab" id="headingOne">
                                            <h4 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                                    Description
                                                </a>
                                            </h4>
                                        </div>
                                        <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                                            <div class="panel-body">
                                                ${product.description}
                                            </div>
                                        </div>
                                    </div>
                                    <div class="panel panel-default">
                                        <div class="panel-heading" role="tab" id="headingTwo">
                                            <h4 class="panel-title">
                                                <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                                    Specifications
                                                </a>
                                            </h4>
                                        </div>
                                        <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                                            <div class="panel-body">
                                                ${product.specification}
                                            </div>
                                        </div>
                                    </div>
                                    <div class="panel panel-default">
                                        <div class="panel-heading" role="tab" id="headingThree">
                                            <h4 class="panel-title">
                                                <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                                    Related
                                                </a>
                                            </h4>
                                        </div>
                                        <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                                            <div class="panel-body">
                                                ${product.relatedInformation}
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="list-group">
                            <a href="#" class="list-group-item">Category One</a>
                            <a href="#" class="list-group-item">Category Two</a>
                            <a href="#" class="list-group-item">Category Three</a>
                            <a href="#" class="list-group-item">Category Four</a>
                        </div>
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
<script>
    $("#buyNow").click(
        function(e){
            e.preventDefault();
            var quantity = $('#quantitySelect').val();
            $.ajax({
                url:"http://localhost:8080/training-java-web-ipb-maven/add-to-cart",
                type:"POST",
                data : {'productId':'${product.id}', 'quantity': quantity}, 
                success : function(data){
                    if(!data.result){
                        alert(data.errorMessage);
                    } else {
                        window.location.reload();
                    }
                }
            });
        });
</script>
    </body>
</html>
