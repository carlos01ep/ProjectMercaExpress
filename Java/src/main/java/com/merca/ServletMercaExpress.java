package com.merca;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.merca.Controller;
import com.model.Jugadores;
import com.model.Productos;

/**
 * Servlet implementation class ServletMercaExpress
 */
@WebServlet("/ServletMercaExpress")
public class ServletMercaExpress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMercaExpress() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			if (request.getParameter("email") != null) {
				loginUsuario(request, response);
			
			}else if (request.getParameter("buscanombre") != null) {
				Buscarproducto(request, response);
			} else if (request.getParameter("nombre") != null) {
				altaProducto(request, response);
			}
		} catch (Exception ex) {
			System.out.println("Error en servlet");
			ex.printStackTrace();
			mostrarError(response,"Error en el serlet");
		}
	}

	private static void loginUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession sesion = request.getSession();
		String usu, pass;
		String sEmail = request.getParameter("email");
		String sPwd = request.getParameter("pwd");
		// deberaamos buscar el usuario en la base de datos, pero 
		//ponemos un ejemplo en el mismo cadigo
		if (sEmail.equals("micorreo@gmail.com") && sPwd.equals("password") 
					&& sesion.getAttribute("email") == null) {
			// si coincide email y password y ademas no hay sesian iniciada
			sesion.setAttribute("email", sEmail);
			// redirijo a pagina con informacian de login exitoso
			response.sendRedirect("loginExito.jsp");
		} else {
			// lagica para login invalido
			mostrarError(response,"El usuario "+sEmail+"no sirve");
		}

	}

	
	
	private static void altaProducto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/** 1- recogida de datos */
		Productos producto = new Productos(request.getParameter("nombre_pro"), request.getParameter("marca"),
				request.getParameter("origen"), request.getParameter("dimensiones"), request.getParameter("fotografia"),
				request.getParameter("unidades_disponibles"),request.getParameter("Nombrecategoria"),request.getParameter("precio"));

		/** 2- Insertar jugador en la base de datos */
		boolean bRes = Controller.insertarProducto(producto);

		/** 3- Mostrar resultado por pantalla */
		if (bRes) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<HTML>\n" + "<HEAD><TITLE>Pagina de JAGD</TITLE>" + "  <meta charset=\"utf-8\">\r\n"
					+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
					+ "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
					+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
					+ "</HEAD>\n" + "<BODY>\n" + "<div class=\"container mt-3\">\n"
					+ "<h2 class=\"text-success\">Producto insertado correctamente<h2>\n"
					+ "<ul class=\"list-group\"> \n" + "  <LI class=\"list-group-item\">nombre: " + producto.getNombre_pro()
					+ "</li>\n" + "  <LI class=\"list-group-item\">Marca: " + producto.getMarca() + "</li>\n"
					+ "  <LI class=\"list-group-item\">Origen: " + producto.getOrigen() + "</li>\n"
					+ "  <LI class=\"list-group-item\">Dimensiones: " + producto.getDimensiones() + "</li>\n"
					+ "  <LI class=\"list-group-item\">URL Fotografia: " + producto.getFotografia() + "</li>\n"
					+ "  <LI class=\"list-group-item\">Unidades disponibles: " + producto.getUnidades_disponibles() + "</li>\n"
					+ "  <LI class=\"list-group-item\">Categoria: " + producto.getNombrecategoria() + "</li>\n"
					+ "  <LI class=\"list-group-item\">Precio: " + producto.getPrecio() + "</li>\n"
					+ "</UL>\n" + "</div></BODY></HTML>");
			out.close();

		} else {
			// Mostramos que se ha producido un error
			mostrarError(response, "Error al dar de alta el jugador");

		}
	}
	private static void Buscarproducto (HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		/**1- regogida de datos de la pagina*/
		String sNombre = request.getParameter("buscanombre");
		/**2- buscar jugadores en la BBDD */
	
		LinkedList<Productos> producto = Controller.getproducto(sNombre);
	
		
		if(producto != null) {
			HttpSession sesion = request.getSession();
			sesion.setAttribute("sNombre", sNombre);
			response.sendRedirect("Tiendabusqueda.jsp");
		}
		else {
			mostrarError(response, "producto "+sNombre+" no encontrado");
		}
	}
	private static void mostrarError(HttpServletResponse response, String sMensaje) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>\n" + "<HEAD><TITLE>Pagina de JAGD</TITLE>" + "  <meta charset=\"utf-8\">\r\n"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
				+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
				+ "</HEAD>\n" + "<BODY>\n" + "<div class=\"container mt-3\">\n"
				+ "<h1 class=\"text-danger\">Error interno<h1>\n"
				+ "<h2 class=\"text-danger\">"+sMensaje+"<h2>\n"
				+ "<img src=\"img/error.jpg\" class=\"rounded\" alt=\"error interno\">" + "</div></BODY></HTML>");
		out.close();
	}

}


