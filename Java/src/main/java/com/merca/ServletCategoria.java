package com.merca;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class ServletIndex
 */
@WebServlet("/ServletCategoria")
public class ServletCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCategoria() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			if (request.getParameter("libros") != null) {
				abrir_categoria(request, response, "Libros");
			} else if (request.getParameter("deporte") != null) {
				abrir_categoria(request, response,"Deporte");
			} else if (request.getParameter("videojuegos") != null) {
				abrir_categoria(request, response, "Videojuegos");
			} else if (request.getParameter("juguetes") != null) {
				abrir_categoria(request, response, "Juguetes");
			} else if (request.getParameter("ropa") != null) {
				abrir_categoria(request, response, "Ropa");
			} else if (request.getParameter("hogar") != null) {
				abrir_categoria(request, response, "Hogar");
			} else if (request.getParameter("zapatos") != null) {
				abrir_categoria(request, response, "Zapatos");
			} else if (request.getParameter("electronica") != null) {
				abrir_categoria(request, response, "Electronica");
			} else if (request.getParameter("bebidas") != null) {
				abrir_categoria(request, response, "Bebidas");
			}

		} catch (Exception ex) {
			System.out.println("Error en servlet");
			ex.printStackTrace();
			mostrarError(response, "Error en servlet");
		}
	}

	private static void abrir_categoria(HttpServletRequest request, HttpServletResponse response, String categoria) throws Exception {

		if (categoria != null) {
			HttpSession sesionindex = request.getSession();
			sesionindex.setAttribute("categoria", categoria);
			response.sendRedirect("TiendaCategoria.jsp");
		} else {
			mostrarError(response, "categoria " + categoria + "no encontrada");
		}
	}

	private static void mostrarError(HttpServletResponse response, String sMensaje) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>\n" + "<HEAD><TITLE>P�gina de JAGD</TITLE>" + "  <meta charset=\"utf-8\">\r\n"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
				+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
				+ "</HEAD>\n" + "<BODY>\n" + "<div class=\"container mt-3\">\n"
				+ "<h1 class=\"text-danger\">Error interno<h1>\n" + "<h2 class=\"text-danger\">" + sMensaje + "<h2>\n"
				+ "<img src=\"img/error.jpg\" class=\"rounded\" alt=\"error interno\">" + "</div></BODY></HTML>");
		out.close();
	}
}
