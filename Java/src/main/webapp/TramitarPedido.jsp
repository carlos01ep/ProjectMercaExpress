<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.model.Categorias"%>
<%@ page import="com.model.Productos"%>
<%@ page import="com.merca.Controller"%>
<%@ page import="com.model.Usuario"%>
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
								<%
								HttpSession sesion = request.getSession();
								if (sesion.getAttribute("email") != null) {
									String userAdmin = (String) sesion.getAttribute("email");
									Usuario usuario = Controller.getUsUarioCompleto(userAdmin);
									if (usuario.getRol().equals("0")) {
										out.println("<li><form action=\"ServletForm\" method=\"POST\">"
										+ "<input class=\"btn btn-success\" type=\"submit\" name=\"ProductoForm\" value=\"Alta Producto\"></form></li>");
									} else {
										out.println("<li>Gastos de envío gratuitos a partir de 30€</li>");
									}

								} else {
									out.println("<li>Gastos de envío gratuitos a partir de 30€</li>");
								}
								%>


							</ul>
						</div>
					</div>
					<div class="col-lg-6 col-md-6">
						<div class="header__top__right">
							<%
							if (sesion.getAttribute("email") == null) {
								out.println("<div class=\"header__top__right__auth\">\r\n"
								+ "<a href=\"./InicioSesion.html\"><i class=\"fa fa-user\"></i>\r\n"
								+ "Inicio de sesión &nbsp; &nbsp;</a>\r\n" + "</div>" + "<div class=\"header__top__right__auth\">\r\n"
								+ "<a href=\"./Registro.html\">&nbsp;<i class=\"fa fa-id-card-o\"></i>\r\n" + " Registrarse &nbsp;</a>\r\n"
								+ "</div>");

							} else {
								// sesion.removeAttribute("cuentatemporal");
								out.println("<div class=\"header__top__right__auth\">\r\n" + "</div>\r\n" + "<div class=\"btn-group\">\r\n"
								+ "<button type=\"button\" class=\"btn btn-success dropdown-toggle\" data-bs-toggle=\"dropdown\"><i class=\"fa fa-user\"></i> &nbsp;&nbsp;&nbsp;"
								+ sesion.getAttribute("email") + "</button>\r\n" + "<ul class=\"dropdown-menu\">\r\n"
								//perfil
								+ "<li><a class=\"dropdown-item\" href=\".\\PerfilUsuario.jsp\"> \r\n"
								+ "<form action=\"ServletForm\" method=\"POST\"> \r\n"
								+ "<input class=\"btn btn-light\" type=\"submit\" id=\"perfil\" name=\"perfil\" value=\"Perfil\"></form>\r\n"
								+ "</a></li>\r\n"
								//carrito
								+ "<li><a class=\"dropdown-item\" href=\"ServletForm\"> \r\n"
								+ "<form action=\"ServletForm\" method=\"POST\"> \r\n"
								+ "<input class=\"btn btn-light\" type=\"submit\" id=\"carrito\" name=\"carrito\" value=\"Carrito\"></form>\r\n"
								+ "</a></li>\r\n"
								//tramitar pedido
								+ "<li><a class=\"dropdown-item\" href=\"#\"> \r\n" + "<form action=\"ServletForm\" method=\"POST\"> \r\n"
								+ "<input class=\"btn btn-light\" type=\"submit\" id=\"tramitar\" name=\"tramitar\" value=\"Tramitar Pedido\"></form>\r\n"
								+ "</a></li>\r\n"
								//cerrar sesión
								+ "<li><a class=\"dropdown-item\" href=\"#\"> \r\n" + "<form action=\"ServletForm\" method=\"POST\"> \r\n"
								+ "<input class=\"btn btn-light\" type=\"submit\" id=\"logout\" name=\"logout\" value=\"Cerrar sesión\"></form>\r\n"
								+ "</a></li>\r\n" + "</ul>\r\n" + "</div>\r\n");
							}
							%>
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
							<li class="active"><a href="./index.jsp">Inicio</a></li>
							<li><a href="./Tienda.jsp">Tienda</a></li>
							<li><a href="">Ofertas</a></li>
							<li><a href="">los más vendidos</a></li>
						</ul>
					</nav>
				</div>
				<div class="col-lg-3">
					<div class="header__cart">
						<ul>
							<li><form action="ServletForm" method="POST">
									<input class="btn btn-light" type="submit" id="carrito"
										name="carrito" value="CARRITO">
								</form></li>
							<li><a href="#"><i class="fa-solid fa-cart-shopping"></i>
									<%
									if ((sesion.getAttribute("email") == null)) {
										if (sesion.getAttribute("cuentatemporal") == null) {
											out.println("<span>" + 0 + "</span></a></li>");
										} else {
											String email = (String) sesion.getAttribute("cuentatemporal");
											int num = Controller.carritoNumProductos(email);
											out.println("<span>" + num + "</span></a></li>");
										}
									} else {
										String email = (String) sesion.getAttribute("email");
										int num = Controller.carritoNumProductos(email);
										out.println("<span>" + num + "</span></a></li>");
									}
									%></a></li>
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

	<div class="container mt-3">
		<div class="container mt-3">
    <h1>Pedido realizado correctamente</h1>

    <form action="Tienda.jsp" class="was-validated">
      <div class="mb-3 mt-3">
        <img src="img/logos/check.png" width="200" height="200">
        <hr>
	
    <button type="submit" class="btn btn-primary">Realizar otro pedido</button>
    </div>
    </form>
    </div>
	</div>
	<br>
<br><br><br><br><br>

	<!-- inicio Footer -->
	<footer class="footer spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="footer__about">
						<div class="footer__about__logo">
							<a href="./index.jsp"><img src="img/logos/MercaExpress01.png"
								alt=""></a>
						</div>

					</div>
				</div>
				<div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
					<div class="footer__widget">
						<ul>
							<li>ABOUT US:</li>
							<br>
							<li>Alberto Sanchez Garcia</li>
							<li>Carlos Escalera Pinto</li>

						</ul>
					</div>
				</div>
				<div class="col-lg-4 col-md-12">
					<div class="footer__widget">
						<ul>
							<li>Dirección: C. Tolosa, 2, 4, 28041 Madrid</li>
							<li>Teléfono: 943 22 55 66</li>
							<li>Correo: MercaExpress@gmail.com</li>
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
