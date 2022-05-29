package com.merca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.http.HttpSession;

import com.model.Carrito;
import com.model.Categorias;
import com.model.Productos;
import com.model.Usuario;
import com.bbdd.ConexionBBDD;

public class Controller {

	public static LinkedList<Productos> getproductoCategoria(String sNombreProducto) {
		String sConsultaBusqCategoria = "SELECT p.nombre_pro,p.marca,p.origen,p.dimensiones,p.fotografia,p.unidades_disponibles,p.Nombrecategoria,p.precio,p.codigo_categoria FROM producto p INNER JOIN categoria c ON p.codigo_categoria= c.codigo_categoria WHERE c.nombre_categoria='"
				+ sNombreProducto + "';";
//Objeto con la lista de jugadoresf
		LinkedList<Productos> listaProductos = new LinkedList<Productos>();
//Primero conectamos a la BBDD
		ConexionBBDD miConexion = new ConexionBBDD();
		try {
			miConexion.conectar();
//Lanzamos la consulta
			ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaBusqCategoria);
			if (rsResultado != null) {
//Si hay resultado recuperamos los datos (como un FETCHde un CURSOR)

				while (rsResultado.next()) {
					// Creamos un objeto jugador por cada fila de la tabla(cada jugador)

					Productos producto = new Productos(rsResultado.getString("nombre_pro"),
							rsResultado.getString("marca"), rsResultado.getString("origen"),
							rsResultado.getString("dimensiones"), rsResultado.getString("fotografia"),
							String.valueOf(rsResultado.getInt("unidades_disponibles")),
							rsResultado.getString("Nombrecategoria"), String.valueOf(rsResultado.getDouble("precio")),
							String.valueOf(rsResultado.getInt("codigo_categoria")));
					// Lo insertamos en la lista
					listaProductos.add(producto);
				}
			} else {
				System.out.println("La consulta no devuelve resultados");
			}
			System.out.println("Número de productos=" + listaProductos.size());
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
			sqlex.printStackTrace();
		} finally {
			miConexion.desconectar();
		}
		for (int i = 0; i < listaProductos.size(); i++) {
			listaProductos.get(i).getNombre_pro();
		}
		return listaProductos;
	}



	public static LinkedList<Categorias> getCategorias() {
		String sConsultaCategoria = "SELECT nombre_categoria, condiciones_de_almacenamiento, observaciones FROM categoria;";
		// Objeto con la lista de jugadores
		LinkedList<Categorias> listaCategorias = new LinkedList<Categorias>();
		// Primero conectamos a la BBDD
		ConexionBBDD miConexion = new ConexionBBDD();
		try {
			miConexion.conectar();
			// Lanzamos la consulta
			ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaCategoria);
			if (rsResultado != null) {
				// Si hay resultado recuperamos los datos (como un FETCH de un CURSOR)
				while (rsResultado.next()) {
					// Creamos un objeto jugador por cada fila de la tabla (cada jugador)
					Categorias categoria = new Categorias(rsResultado.getString("nombre_categoria"),
							rsResultado.getString("condiciones_de_almacenamiento"),
							rsResultado.getString("observaciones"));
					// Lo insertamos en la lista
					listaCategorias.add(categoria);
				}
			} else {
				System.out.println("La consulta no devuelve resultados");
			}
			System.out.println("Número de categorias=" + listaCategorias.size());
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
			sqlex.printStackTrace();
		} finally {
			miConexion.desconectar();
		}
		return listaCategorias;
	}
<<<<<<< HEAD

	public static LinkedList<Productos> getAllProductos() {
		// Objeto con la lista de jugadores
		String sConsultaProductos = "SELECT p.nombre_pro,p.marca,p.origen,p.dimensiones,p.fotografia,p.unidades_disponibles,p.Nombrecategoria,p.precio,p.codigo_categoria FROM producto p;";
		LinkedList<Productos> listaProductos = new LinkedList<Productos>();
		// Primero conectamos a la BBDD
		ConexionBBDD miConexion = new ConexionBBDD();
		try {
			miConexion.conectar();
			// Lanzamos la consulta
			ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaProductos);
			if (rsResultado != null) {
				// Si hay resultado recuperamos los datos (como un FETCHde un CURSOR)

				while (rsResultado.next()) {
					// Creamos un objeto jugador por cada fila de la tabla(cada jugador)

					Productos producto = new Productos(rsResultado.getString("nombre_pro"),
							rsResultado.getString("marca"), rsResultado.getString("origen"),
							rsResultado.getString("dimensiones"), rsResultado.getString("fotografia"),
							String.valueOf(rsResultado.getInt("unidades_disponibles")),
							rsResultado.getString("Nombrecategoria"), String.valueOf(rsResultado.getDouble("precio")),
							String.valueOf(rsResultado.getInt("codigo_categoria")));
					// Lo insertamos en la lista
					listaProductos.add(producto);
				}
			} else {
				System.out.println("La consulta no devuelve resultados");
			}
			System.out.println("Número de jugadores=" + listaProductos.size());
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
			sqlex.printStackTrace();
		} finally {
			miConexion.desconectar();
		}
		
		return listaProductos;
		
	}

	public static LinkedList<Productos> getproducto(String sNombreProducto) {
		String sConsultaBusq = "SELECT nombre_pro,marca,origen,dimensiones,fotografia,unidades_disponibles,Nombrecategoria,precio,codigo_categoria FROM producto where nombre_pro like '%"
				+ sNombreProducto + "%';";
//Objeto con la lista de jugadores
		LinkedList<Productos> listaProductos = new LinkedList<Productos>();
//Primero conectamos a la BBDD
		ConexionBBDD miConexion = new ConexionBBDD();
		try {
			miConexion.conectar();
//Lanzamos la consulta
			ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaBusq);
			if (rsResultado != null) {
//Si hay resultado recuperamos los datos (como un FETCHde un CURSOR)

				while (rsResultado.next()) {
					// Creamos un objeto jugador por cada fila de la tabla(cada jugador)

					Productos producto = new Productos(rsResultado.getString("nombre_pro"),
							rsResultado.getString("marca"), rsResultado.getString("origen"),
							rsResultado.getString("dimensiones"), rsResultado.getString("fotografia"),
							String.valueOf(rsResultado.getInt("unidades_disponibles")),
							rsResultado.getString("Nombrecategoria"), String.valueOf(rsResultado.getDouble("precio")),
							String.valueOf(rsResultado.getInt("codigo_categoria")));
					// Lo insertamos en la lista
					listaProductos.add(producto);
				}
			} else {
				System.out.println("La consulta no devuelve resultados");
			}
			System.out.println("Número de jugadores=" + listaProductos.size());
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
			sqlex.printStackTrace();
		} finally {
			miConexion.desconectar();
		}
		for (int i = 0; i < listaProductos.size(); i++) {
			listaProductos.get(i).getNombre_pro();
		}
		return listaProductos;
	}

	public static LinkedList<Productos> getproductos(String sNombreProducto) {
		String sConsultaBusq = "SELECT nombre_pro,marca,origen,dimensiones,fotografia,unidades_disponibles,Nombrecategoria,precio,codigo_categoria FROM producto where nombre_pro like '%"
				+ sNombreProducto + "%';";
//Objeto con la lista de jugadores
		LinkedList<Productos> listaProductos = new LinkedList<Productos>();
//Primero conectamos a la BBDD
		ConexionBBDD miConexion = new ConexionBBDD();
		try {
			miConexion.conectar();
//Lanzamos la consulta
			ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaBusq);
			if (rsResultado != null) {
//Si hay resultado recuperamos los datos (como un FETCHde un CURSOR)

				while (rsResultado.next()) {
					// Creamos un objeto jugador por cada fila de la tabla(cada jugador)

					Productos producto = new Productos(rsResultado.getString("nombre_pro"),
							rsResultado.getString("marca"), rsResultado.getString("origen"),
							rsResultado.getString("dimensiones"), rsResultado.getString("fotografia"),
							String.valueOf(rsResultado.getInt("unidades_disponibles")),
							rsResultado.getString("Nombrecategoria"), String.valueOf(rsResultado.getDouble("precio")),
							String.valueOf(rsResultado.getInt("codigo_categoria")));
					// Lo insertamos en la lista
					listaProductos.add(producto);
				}
			} else {
				System.out.println("La consulta no devuelve resultados");
			}
			System.out.println("Número de jugadores=" + listaProductos.size());
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
			sqlex.printStackTrace();
		} finally {
			miConexion.desconectar();
		}
		for (int i = 0; i < listaProductos.size(); i++) {
			listaProductos.get(i).getNombre_pro();
		}
		return listaProductos;
	}

=======
	
//public static Productos getproducto(String sNombreProducto) {
//		
//		String sConsultaBusq = "SELECT nombre_pro,marca,origen,dimensiones,fotografia,unidades_disponibles,Nombrecategoria,precio FROM producto where nombre_pro like '"+sNombreProducto+"%';";
//		
//		Productos producto = null;
//		ConexionBBDD miConexion = new ConexionBBDD();
//		try {
//		/**1- conectar a la base de datos */
//			miConexion.conectar();
//		/**2- lanzar la consulta*/
//			ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaBusq);
//		/**3-recuperar los datos*/
//			if (rsResultado != null) {
//				// Si hay resultado recuperamos los datos (como un FETCHde un CURSOR)
//
//								while (rsResultado.next()) {
//									// Creamos un objeto jugador por cada fila de la tabla(cada jugador)
//
//									 producto = new Productos(rsResultado.getString("nombre_pro"),
//											 rsResultado.getString("marca"),rsResultado.getString("origen"),
//											 rsResultado.getString("dimensiones"),rsResultado.getString("fotografia"),
//											 String.valueOf(rsResultado.getInt("unidades_disponibles")),rsResultado.getString("Nombrecategoria"),
//											String.valueOf(rsResultado.getDouble("precio")));
//									// Lo insertamos en la lista
//								
//								}
//							} else {
//								System.out.println("La consulta no devuelve resultados");
//							}
//		/**4-cerrar conexion*/
//		}catch (SQLException sqlex) {
//			System.out.println("Error: " + sqlex.getMessage());
//			sqlex.printStackTrace();
//		} finally {
//			miConexion.desconectar();
//		}
//		return producto;
//	}
	
	 

	public static LinkedList<Productos> getproducto(String sNombreProducto) {
		String sConsultaBusq= "SELECT nombre_pro,marca,origen,dimensiones,fotografia,unidades_disponibles,Nombrecategoria,precio FROM producto where nombre_pro like '"+sNombreProducto+"%';";
//Objeto con la lista de jugadores
	LinkedList<Productos> listaProductos = new LinkedList<Productos>();
//Primero conectamos a la BBDD
	ConexionBBDD miConexion = new ConexionBBDD();
	try {
		miConexion.conectar();
//Lanzamos la consulta
		ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaBusq);
		if (rsResultado != null) {
//Si hay resultado recuperamos los datos (como un FETCHde un CURSOR)

			while (rsResultado.next()) {
				// Creamos un objeto jugador por cada fila de la tabla(cada jugador)

				Productos producto = new Productos(rsResultado.getString("nombre_pro"),
						 rsResultado.getString("marca"),rsResultado.getString("origen"),
						 rsResultado.getString("dimensiones"),rsResultado.getString("fotografia"),
						 String.valueOf(rsResultado.getInt("unidades_disponibles")),rsResultado.getString("Nombrecategoria"),
						String.valueOf(rsResultado.getDouble("precio")));
				// Lo insertamos en la lista
				listaProductos.add(producto);
			}
		} else {
			System.out.println("La consulta no devuelve resultados");
		}
		System.out.println("Número de jugadores=" + listaProductos.size());
	} catch (SQLException sqlex) {
		System.out.println("Error: " + sqlex.getMessage());
		sqlex.printStackTrace();
	} finally {
		miConexion.desconectar();
	}
	for (int i = 0; i < listaProductos.size(); i++) {
		listaProductos.get(i).getNombre_pro();
	}
	return listaProductos;
}
>>>>>>> f23708f26c4182a7b5ba5cb563893ec1c31a5f99
	public static boolean insertarProducto(Productos producto) {
		boolean bRes = true;
		// primero conectamos a la BBDD
		ConexionBBDD miConexion = new ConexionBBDD();
		try {
			miConexion.conectar();
			int iRes = miConexion.insertar(producto);
		} catch (SQLException sqlex) {
			// TODO: handle exception
			System.out.println("Error" + sqlex.getMessage());
			sqlex.printStackTrace();
		} finally {
			miConexion.desconectar();
		}
		return bRes;
	}

	public static Usuario getUsuario(String email) {
		// Objeto con la lista de jugadores
		Usuario usuario = null;
		// Primero conectamos a la BBDD
		ConexionBBDD miConexion = new ConexionBBDD();
		String sConsultaBuscaJugador = "SELECT email, dni, nombre,direccion,codigo_postal,telefono,contraseña FROM usuarios WHERE email = '"
				+ email + "';";
		try {
			miConexion.conectar();
			// Lanzamos la consulta
			ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaBuscaJugador);
			if (rsResultado != null) {
				// Si hay resultado recuperamos los datos (como un FETCH de un CURSOR)
				while (rsResultado.next()) {
					// Creamos un objeto jugador por cada fila de la tabla (cada jugador)
					usuario = new Usuario(rsResultado.getString("email"), rsResultado.getString("dni"),
							rsResultado.getString("nombre"), rsResultado.getString("direccion"),
							rsResultado.getString("codigo_postal"), rsResultado.getString("telefono"),
							rsResultado.getString("contraseña"));
				}
			} else {
				System.out.println("La consulta no devuelve resultados");
			}
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
			sqlex.printStackTrace();
		} finally {
			miConexion.desconectar();
		}
		return usuario;
	}

	public static boolean insertarProductoCarrito(Carrito carrito) {
		boolean bRes = true;
		// primero conectamos a la BBDD
		ConexionBBDD miConexion = new ConexionBBDD();
		try {
			miConexion.conectar();
			int iRes = miConexion.insertarCarrito(carrito);
		} catch (SQLException sqlex) {
			// TODO: handle exception
			System.out.println("Error" + sqlex.getMessage());
			sqlex.printStackTrace();
		} finally {
			miConexion.desconectar();
		}
		return bRes;
	}

	public static boolean insertarUsuario(Usuario usuario) {
		boolean bRes = true;
		// primero conectamos a la BBDD
		ConexionBBDD miConexion = new ConexionBBDD();
		try {
			miConexion.conectar();
			int iRes = miConexion.insertarUsuario(usuario);
		} catch (SQLException sqlex) {
			// TODO: handle exception
			System.out.println("Error" + sqlex.getMessage());
			sqlex.printStackTrace();
		} finally {
			
			miConexion.desconectar();
		}
		return bRes;
	}

	public static int carritoNumProductos(String email) {
		// Objeto con la lista de jugadores
		int num = 0;

		String sConsultaNumProductos = "SELECT COUNT(c.codigo_carrito) FROM carrito c WHERE c.codigoUsuario = '" + email
				+ "';";

		// Primero conectamos a la BBDD
		ConexionBBDD miConexion = new ConexionBBDD();
		try {
			miConexion.conectar();
			// Lanzamos la consulta
			ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaNumProductos);
			if (rsResultado != null) {
				// Si hay resultado recuperamos los datos (como un FETCHde un CURSOR)

				while (rsResultado.next()) {
					// Creamos un objeto jugador por cada fila de la tabla(cada jugador)
					String resultado = rsResultado.getString("COUNT(c.codigo_carrito)");
					num = Integer.parseInt(resultado);
				}
			} else {
				System.out.println("La consulta no devuelve resultados");
			}
			System.out.println("Número de productos=" + num);
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
			sqlex.printStackTrace();
		} finally {
			
			miConexion.desconectar();
		}
		return num;
	}



	public static Usuario getUsuarios(String usuario1) {
		System.out.println("asdfasdfasdfasdf" + usuario1);
		String sConsultaBusq = "SELECT u.email,u.dni,u.nombre,u.direccion,u.codigo_postal,u.telefono,u.contraseña FROM usuarios u WHERE u.email='"
				+ usuario1 + "';";

		Usuario usuario = null;
		ConexionBBDD miConexion = new ConexionBBDD();
		try {
			/** 1- conectar a la base de datos */
			miConexion.conectar();
			/** 2- lanzar la consulta */
			ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaBusq);
			/** 3-recuperar los datos */
			if (rsResultado != null) {
				// Si hay resultado recuperamos los datos (como un FETCHde un CURSOR)

				while (rsResultado.next()) {
					// Creamos un objeto jugador por cada fila de la tabla(cada jugador)

					usuario = new Usuario(rsResultado.getString("email"), rsResultado.getString("dni"),
							rsResultado.getString("nombre"), rsResultado.getString("direccion"),
							rsResultado.getString("codigo_postal"), rsResultado.getString("telefono"),
							rsResultado.getString("contraseña"));
					// Lo insertamos en la lista

				}
			} else {
				System.out.println("La consulta no devuelve resultados");
			}
			/** 4-cerrar conexion */
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
			sqlex.printStackTrace();
		} finally {
			miConexion.desconectar();
		}
		return usuario;
	}

public static LinkedList<Carrito> getProductosCarrito(String usuario1) {
	// Objeto con la lista de jugadores
	LinkedList<Carrito> listaCarrito = new LinkedList<Carrito>();
	// Primero conectamos a la BBDD
	ConexionBBDD miConexion = new ConexionBBDD();
	try {
		miConexion.conectar();
		// Lanzamos la consulta
		String sConsultaProductos = "SELECT c.codigo_carrito,c.nombre_pro,c.fotografia,c.unidades_disponibles,c.precio,c.codigoUsuario FROM carrito c WHERE c.codigoUsuario = '"+ usuario1 +"';";
		ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaProductos);
		if (rsResultado != null) {
			// Si hay resultado recuperamos los datos (como un FETCHde un CURSOR)

			while (rsResultado.next()) {
				// Creamos un objeto jugador por cada fila de la tabla(cada jugador)

				Carrito carrito = new Carrito (rsResultado.getString("nombre_pro"), rsResultado.getString("fotografia"),
						String.valueOf(rsResultado.getInt("unidades_disponibles")), String.valueOf(rsResultado.getDouble("precio")),
						rsResultado.getString("codigoUsuario"));

				// Lo insertamos en la lista
						listaCarrito.add(carrito);
			}
		} else {
			System.out.println("La consulta no devuelve resultados");
		}
		System.out.println("Número de jugadores=" + listaCarrito.size());
	} catch (SQLException sqlex) {
		System.out.println("Error: " + sqlex.getMessage());
		sqlex.printStackTrace();
	} finally {
		miConexion.desconectar();
	}
	return listaCarrito;
}
public static double getTotalCarrito(String email) {
	// Objeto con la lista de jugadores
	double num = 0;

	String sConsultaNumProductos = "SELECT SUM(c.precio) FROM carrito c WHERE c.codigoUsuario = '"+ email +"';";

	// Primero conectamos a la BBDD
	ConexionBBDD miConexion = new ConexionBBDD();
	try {
		miConexion.conectar();
		// Lanzamos la consulta
		ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaNumProductos);
		if (rsResultado != null) {
			// Si hay resultado recuperamos los datos (como un FETCHde un CURSOR)

			while (rsResultado.next()) {
				// Creamos un objeto jugador por cada fila de la tabla(cada jugador)
				String resultado = rsResultado.getString("SUM(c.precio)");
				num = Double.parseDouble(resultado);
				System.out.println("total: " + num);
			}
		} else {
			System.out.println("La consulta no devuelve resultados");
		}
		System.out.println("Total=" + num);
	} catch (SQLException sqlex) {
		System.out.println("Error: " + sqlex.getMessage());
		sqlex.printStackTrace();
	} finally {
		miConexion.desconectar();
	}
	return num;
}

public static boolean vaciarCarrito(String email) {
	boolean bRes = true;
	// Objeto con la lista de jugadores
	String sConsultaNumUsuarios = "DELETE FROM carrito WHERE codigoUsuario = '"+ email +"';";
	// Primero conectamos a la BBDD
	ConexionBBDD miConexion = new ConexionBBDD();
	try {
		miConexion.conectar();
		// Lanzamos la consulta
		miConexion.ejecutarBorrar(sConsultaNumUsuarios);
		
	} catch (SQLException sqlex) {
		System.out.println("Error: " + sqlex.getMessage());
		sqlex.printStackTrace();
	} finally {
		miConexion.desconectar();
	}
	return bRes;
}

public static boolean vaciarProductoCarrito(String email, String producto) {
	boolean bRes = true;
	String sConsultaNumUsuarios = "DELETE FROM carrito WHERE codigoUsuario = '"+ email +"' AND nombre_pro = '"+ producto +"' ;";
	ConexionBBDD miConexion = new ConexionBBDD();
	try {
		miConexion.conectar();
		miConexion.ejecutarBorrar(sConsultaNumUsuarios);
		
	} catch (SQLException sqlex) {
		System.out.println("Error: " + sqlex.getMessage());
		sqlex.printStackTrace();
	} finally {
		miConexion.desconectar();
	}
	return bRes;
}

public static Usuario getUsUarioCompleto(String email) {
	Usuario usuario = null;
	ConexionBBDD miConexion = new ConexionBBDD();
	String sConsultaBuscaJugador = "SELECT email, dni, nombre,direccion,codigo_postal,telefono,contraseña,rol FROM usuarios WHERE email = '"
			+ email + "';";
	try {
		miConexion.conectar();
		// Lanzamos la consulta
		ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaBuscaJugador);
		if (rsResultado != null) {
			// Si hay resultado recuperamos los datos (como un FETCH de un CURSOR)
			while (rsResultado.next()) {
				usuario = new Usuario(rsResultado.getString("email"), rsResultado.getString("dni"),
						rsResultado.getString("nombre"), rsResultado.getString("direccion"),
						rsResultado.getString("codigo_postal"), rsResultado.getString("telefono"),
						rsResultado.getString("contraseña"));
				usuario.setRol(String.valueOf(rsResultado.getInt("rol")));
				System.out.println("rol " + String.valueOf(rsResultado.getInt("rol")));
			}
		} else {
			System.out.println("La consulta no devuelve resultados");
		}
	} catch (SQLException sqlex) {
		System.out.println("Error: " + sqlex.getMessage());
		sqlex.printStackTrace();
	} finally {
		miConexion.desconectar();
	}
	return usuario;
}

}
