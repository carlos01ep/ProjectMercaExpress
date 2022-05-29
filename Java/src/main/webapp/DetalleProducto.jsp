<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.model.Categorias"%>
<%@ page import="com.merca.Controller"%>
<%@ page import="java.util.LinkedList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- bootstrap-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- estilos -->
<link rel="stylesheet" href="css/style.css" type="text/css">
<!-- fuentes-->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">
<!-- iconos-->
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
<script src="https://kit.fontawesome.com/37f55263d2.js"></script>

<!-- carousel-->
<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">

<title>Supermercado</title>
</head>
<body>
	<!--cargando -->
	<!--     <div id="preloder"> -->
	<!--         <div class="loader"></div> -->
	<!--     </div> -->

	<!-- cabecera -->
	<header class="header">
		<div class="header__top">
			<div class="container">
				<div class="row">
					<div class="col-lg-6 col-md-6">
						<div class="header__top__left">
							<ul>
								<!-- 								<li><i class="fa fa-envelope"></i> admin@mercaexpress.com</li> -->
								<li>Gastos de envío gratuitos a partir de 30€</li>
							</ul>
						</div>
					</div>
					<div class="col-lg-6 col-md-6">
						<div class="header__top__right">
							<div class="header__top__right__auth">
								<a href="./InicioSesion.html">Cancelar &nbsp; <i class=" fa-solid fa-circle-xmark"></i>
									</a>
							</div>
							<div class="header__top__right__auth">
							
								<a href="./InicioSesion.html">Cerra sesión &nbsp; <i class="fa-solid fa-arrow-right-from-bracket"></i>
									</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row d-flex align-items-center">
				<div class="col-lg-3">
					<div class="header__logo">
						<a href="./index.jsp"><img src="img/logos/MercaExpress01.png"
							alt=""></a>
					</div>
				</div>
				<div class="col-lg-6">
					<nav class="header__menu">
						<ul>
							<li class="active"><a href="./index.html">Inicio</a></li>
							<li><a href="#">Tienda</a></li>
							<li><a href="#">Ofertas</a></li>
							<li><a href="#">los más vendidos</a></li>
						</ul>
					</nav>
				</div>
				<div class="col-lg-3">
					<div class="header__cart">
						<ul>
							<li><a href="#"><i class="fa-solid fa-cart-shopping"></i>
									<span>0</span></a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="humberger__open">
				<i class="fa fa-bars"></i>
			</div>
		</div>
	</header>
	<!-- fin cabecera -->

	<!-- Product Details Section Begin -->
	<section class="product-details spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6">
					<div class="product__details__pic">
						<div class="product__details__pic__item">
							<img class="product__details__pic__item--large"
								src="img/product/details/product-details-1.jpg" alt="">
						</div>
						<div class="product__details__pic__slider owl-carousel">
							<img data-imgbigurl="img/product/details/product-details-2.jpg"
								src="img/product/details/thumb-1.jpg" alt=""> <img
								data-imgbigurl="img/product/details/product-details-3.jpg"
								src="img/product/details/thumb-2.jpg" alt=""> <img
								data-imgbigurl="img/product/details/product-details-5.jpg"
								src="img/product/details/thumb-3.jpg" alt=""> <img
								data-imgbigurl="img/product/details/product-details-4.jpg"
								src="img/product/details/thumb-4.jpg" alt="">
						</div>
					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="product__details__text">
						<h3>Camiseta</h3>

						<div class="product__details__price">€9.99</div>
						<p>Lorem ipsum dolor sit amet, consectetur adip elit, sed do eiusmod tempor incididunt
                                    ut labore et dolore magna aliqua.
                                    </p>
						<div class="product__details__quantity">
							<div class="quantity">
								<div class="pro-qty">
									<input type="text" value="1">
								</div>
							</div>
						</div>
						<a href="#" class="primary-btn">Añadir al Carrito</a>
						<ul>
							<li><b>Availability</b> <span>In Stock</span></li>
							<li><b>Shipping</b> <span>01 day shipping. <samp>Free
										pickup today</samp></span></li>
							<li><b>Weight</b> <span>0.5 kg</span></li>

						</ul>
					</div>
				</div>
				<div class="col-lg-12">
					<div class="product__details__tab">
						<ul class="nav nav-tabs" role="tablist">
							<li class="nav-item"><a class="nav-link active"
								data-toggle="tab" href="#tabs-1" role="tab" aria-selected="true">Description</a>
							</li>

						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="tabs-1" role="tabpanel">
								<div class="product__details__tab__desc">
<!-- 									<h6></h6> -->
									<p>Lorem ipsum dolor sit amet, consectetur adip elit, sed do eiusmod tempor incididunt
                                    ut labore et dolore magna aliqua.
                                    </p>
                                    <p>Lorem ipsum dolor sit amet, consectetur adip elit, sed do eiusmod tempor incididunt
                                    ut labore et dolore magna aliqua.
                                    </p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
	</section>
	<!-- Product Details Section End -->

	<!-- inicio Footer -->
<footer class="footer spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="footer__about">
						<div class="footer__about__logo">
							<a href="./index.html"><img src="img/logos/MercaExpress.png"
								alt=""></a>
						</div>

					</div>
				</div>
				<div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
					<div class="footer__widget">
						<ul>
							<li>Dirección: C. Tolosa, 2, 4, 28041 Madrid</li>
							<li>Teléfono: +34 943 22 55 66</li>
							<li>Correo: MercaExpress@gmail.com</li>
						</ul>
					</div>
				</div>
				<div class="col-lg-4 col-md-12">
					<div class="footer__widget">
						<ul>
							<li>About us:</li>
							<li>Alberto Sanchez Garcia</li>
							<li>Carlos Escalera Pinto </li>
						</ul>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="footer__copyright"></div>
				</div>
			</div>
		</div>
	</footer>
	<!-- fin Footer -->

	<!-- Js Plugins -->
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	<script src="js/jquery.slicknav.js"></script>
	<script src="js/mixitup.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/main.js"></script>

</body>
</html>