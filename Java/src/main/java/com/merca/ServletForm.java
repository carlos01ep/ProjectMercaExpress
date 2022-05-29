package com.merca;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Carrito;
//import com.model.Carrito;
import com.model.Productos;
import com.model.Usuario;

/**
 * Servlet implementation class ServletForm
 */
@WebServlet("/ServletForm")
public class ServletForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Error: la llamadas GET no est�n permitidas").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			if (request.getParameter("email") != null) {
				loginUsuario(request, response);
			} else if (request.getParameter("marca") != null) {
				insertarProducto(request, response);
			} else if (request.getParameter("logout") != null) {
				cerrarSesion(request, response);
			} else if (request.getParameter("perfil") != null) {
				abrirPerfil(request, response);
			} else if (request.getParameter("tramitar") != null) {
				pagarCarrito(request, response);
			} else if (request.getParameter("carrito") != null) {
				abrirCarrito(request, response);
			} else if (request.getParameter("buscanombre") != null) {
				buscarProducto(request, response);
			} else if (request.getParameter("ProductoForm") != null) {
				abrirAltaProducto(request, response);
			} else if (request.getParameter("idProducto") != null) {
				altaProductoCarrito(request, response);
			} else if (request.getParameter("codigo_postal") != null) {
				altaUsuario(request, response);
			} else if (request.getParameter("eliminarProducto") != null) {
				modificarCarrito(request, response);
			} else if (request.getParameter("PagarTarjeta") != null) {
				pagarTarjeta(request, response);
			} else {
				System.out.println("Error en servlet: opci�n no v�lida");
			}
		} catch (

		Exception ex) {
			System.out.println("Error en servlet");
			ex.printStackTrace();
			mostrarError(response, ex.getMessage());
		}
	}

	private static void insertarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/** 1- recogida de datos */
		System.out.println("Inicio altaProducto");
		Productos producto = new Productos(request.getParameter("nombre_pro"), request.getParameter("marca"),
				request.getParameter("origen"), request.getParameter("dimensiones"), request.getParameter("fotografia"),
				request.getParameter("unidades_disponibles"), request.getParameter("Nombrecategoria"),
				request.getParameter("precio"), request.getParameter("codigo_categoria"));

		System.out.println("Producto recogido: " + producto);
		/** 2- Insertar jugador en la base de datos */
		boolean bRes = Controller.insertarProducto(producto);

		/** 3- Mostrar resultado por pantalla */
		if (bRes) {
			System.out.println("bRes true");
			response.sendRedirect("./Tienda.jsp");
			
		} else {
			// Mostramos que se ha producido un error
			mostrarError(response, "Error al dar de alta el producto");

		}
	}

	private static void loginUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Inicio loginUsuario()");
		// Podemos guardar informaci�n en la sesi�n del usuario
		HttpSession sesion = request.getSession();
		String sEmail = request.getParameter("email");
		String sPwd = request.getParameter("password");
		Usuario usuarios = Controller.getUsuario(sEmail);

		if (usuarios != null) {
			if (usuarios.getContraseña().equals(sPwd)) {
				// si coincide email y password y adem�s no hay sesi�n iniciada
				sesion.setAttribute("email", sEmail);
				// redirijo a p�gina con informaci�n de login exitoso
				response.sendRedirect("./index.jsp");

			} else {
				// l�gica para login inv�lido
				mostrarError(response, "usuario " + sEmail + " contraseña no valida");
				response.sendRedirect("./Registro.html");
			}
		} else {
			// l�gica para login inv�lido
			mostrarError(response, "usuario " + sEmail + " no registrado");
			response.sendRedirect("./Registro.html");
		}
	}

	private static void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("cerrando sesión");
		HttpSession sesion = request.getSession();
		sesion.removeAttribute("email");
		response.sendRedirect("index.jsp");
	}

	private static void mostrarError(HttpServletResponse response, String sMensaje) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>\n" + "<HEAD><TITLE>P�gina de JAGD</TITLE>" + "  <meta charset=\"utf-8\">\r\n"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
				+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
				+ "</HEAD>\n" + "<BODY>\n" + "<div class=\"container mt-3\">\n"
				+ "<h1 class=\"text-danger\">Error<h1>\n" + "<h2 class=\"text-danger\">" + sMensaje + "<h2>\n"
				+ "<img src=\"img/error.jpg\" class=\"rounded\" alt=\"error interno\">" + "</div></BODY></HTML>");
		out.close();
	}

	private static void buscarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("-------------------------------------llega a busca producto");
		/** 1- regogida de datos de la pagina */
		String sNombre = request.getParameter("buscanombre");
		/** 2- buscar jugadores en la BBDD */

		LinkedList<Productos> producto = Controller.getproductos(sNombre);

		if (producto != null) {
			HttpSession sesion = request.getSession();
			sesion.setAttribute("sNombre", sNombre);
			response.sendRedirect("Tiendabusqueda.jsp");
		} else {
			mostrarError(response, "producto " + sNombre + " no encontrado");
		}
	}

	private static void altaProductoCarrito(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/** 1- recogida de datos */
		System.out.println("Inicio altaProductoCarrito");

		LinkedList<Productos> productoLista = Controller.getAllProductos();
		HttpSession sesion = request.getSession();
		String emailCarrito = null;
		if (sesion.getAttribute("email") == null) {
			emailCarrito = (String) sesion.getAttribute("cuentatemporal");
		} else {
			emailCarrito = (String) sesion.getAttribute("email");
		}
		sesion.setAttribute("emailcarritofinal", emailCarrito);
		System.out.println("hay email" + emailCarrito);
		int idProducto = Integer.parseInt(request.getParameter("idProducto"));
		Carrito carrito = new Carrito(productoLista.get(idProducto).getNombre_pro(),
				productoLista.get(idProducto).getFotografia(), productoLista.get(idProducto).getUnidades_disponibles(),
				productoLista.get(idProducto).getPrecio(), emailCarrito);

		System.out.println("Producto recogido: " + carrito);
		/** 2- Insertar jugador en la base de datos */
		boolean bRes = Controller.insertarProductoCarrito(carrito);

		/** 3- Mostrar resultado por pantalla */
		if (bRes) {
			System.out.println("bRes true");
			response.sendRedirect("Tienda.jsp");

		} else {
			// Mostramos que se ha producido un error
			mostrarError(response, "Error al añadir producto a carrito");
		}
	}

	private static void altaUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/** 1- recogida de datos */
		System.out.println("Inicio altaProducto");
		Usuario usuario = new Usuario(request.getParameter("emailRegistro"), request.getParameter("dni"),
				request.getParameter("nombre"), request.getParameter("direccion"),
				request.getParameter("codigo_postal"), request.getParameter("telefono"),
				request.getParameter("contrasena"));

		System.out.println("Producto recogido: " + usuario);
		/** 2- Insertar jugador en la base de datos */
		boolean bRes = Controller.insertarUsuario(usuario);

		/** 3- Mostrar resultado por pantalla */
		if (bRes) {
			System.out.println("bRes true");
			response.sendRedirect("InicioSesion.html");

		} else {
			// Mostramos que se ha producido un error
			mostrarError(response, "Error al dar de alta el producto");

		}
	}

	private static void abrirPerfil(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("PerfilUsuario.jsp");

	}

	private static void pagarTarjeta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sesion = request.getSession();

		if (sesion.getAttribute("numProductos") == null) {
			String num = (String) sesion.getAttribute("numProductos");
			if (!num.equals("0")) {
				response.sendRedirect("PedidoPago.jsp");
			} else {
				response.sendRedirect("Tienda.jsp");
			}
		}

	}

	private static void abrirCarrito(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.sendRedirect("carrito.jsp");
	}

	private static void abrirAltaProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.sendRedirect("AltaProducto.html");
	}

	private static void pagarCarrito(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/** 1- recogida de datos */
		System.out.println("Inicio vaciar carrito");
		HttpSession sesion = request.getSession();
		String emailCarrito = null;
		if (sesion.getAttribute("email") == null) {
			emailCarrito = (String) sesion.getAttribute("cuentatemporal");
		} else {
			emailCarrito = (String) sesion.getAttribute("email");
		}
		boolean bRes = Controller.vaciarCarrito(emailCarrito);

		if (bRes) {
			response.sendRedirect("TramitarPedido.jsp");
		} else {
			// Mostramos que se ha producido un error
			mostrarError(response, "Error al vaciar carrito");
		}

	}

	private static void modificarCarrito(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/** 1- recogida de datos */
		System.out.println("eliminarProductoCarrito");
		HttpSession sesion = request.getSession();
		String emailCarrito = null;
		if (sesion.getAttribute("email") == null) {
			emailCarrito = (String) sesion.getAttribute("cuentatemporal");
		} else {
			emailCarrito = (String) sesion.getAttribute("email");
		}
		String producto = request.getParameter("eliminarProducto");
		boolean bRes = Controller.vaciarProductoCarrito(emailCarrito, producto);
		if (bRes) {
			response.sendRedirect("carrito.jsp");
		} else {
			// Mostramos que se ha producido un error
			mostrarError(response, "Error al eliminar producto del carrito");
		}

	}

}
