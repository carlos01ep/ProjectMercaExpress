package com.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Carrito;
import com.model.Productos;
import com.model.Usuario;

/**
 * Clase que centraliza los métodos de acceso a BBDD
 * 
 * @author JAGD
 * @since 27/05/2021
 */

public class ConexionBBDD {

	Connection conexion;
	int port = 3306;
	String host = "localhost";
	String db = "supermercado";
	String user = "root";
	String password = "0123456789";

	String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, port, db);

	public void conectar() throws SQLException {
		conexion = DriverManager.getConnection(url, user, password);
	}

	public void desconectar() {
		try {
			conexion.close();
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
		}
	}

	public ResultSet ejecutarConsulta(String sentencia) {
		ResultSet rsResultado = null;
		try {
			System.out.println("Ejecutando: " + sentencia);
			PreparedStatement prepStatement = conexion.prepareStatement(sentencia);
			rsResultado = prepStatement.executeQuery();
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
		}
		return rsResultado;
	}
	
	

	public int insertarVehiculo(String sentencia, String sMatricula, String sMarca, String sModelo) {
		int iRes = 0;

		try {
			System.out.println("Ejecutando: " + sentencia);
			PreparedStatement prepStatement = conexion.prepareStatement(sentencia);
			prepStatement.setString(1, sMatricula);
			prepStatement.setString(2, sMarca);
			prepStatement.setString(3, sModelo);
			iRes = prepStatement.executeUpdate();
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
		}
		return iRes;
	}

	public int insertar(Productos producto) {
		int iRes = 0;
		String sInsert = "insert into producto (nombre_pro, marca, origen, dimensiones, fotografia, unidades_disponibles,Nombrecategoria,precio) values (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			System.out.println("Ejecutando " + sInsert);
			System.out.println("Datos " + producto);
			PreparedStatement prepStatement = conexion.prepareStatement(sInsert);
			prepStatement.setString(1, producto.getNombre_pro());
			prepStatement.setString(2, producto.getMarca());
			prepStatement.setString(3, producto.getOrigen());
			prepStatement.setString(4, producto.getDimensiones());
			prepStatement.setString(5, producto.getFotografia());
			prepStatement.setInt(6, Integer.parseInt(producto.getUnidades_disponibles()));
			prepStatement.setString(7, producto.getNombrecategoria());
			prepStatement.setDouble(8, Double.parseDouble(producto.getPrecio()));
			iRes = prepStatement.executeUpdate();

		} catch (SQLException sqlex) {
			// TODO: handle exception
			System.out.println("Error: " + sqlex.getMessage());
			sqlex.printStackTrace();
		}
		return iRes;
	}

	public int insertarCarrito(Carrito carrito) {
		int iRes = 0;
		String sInsert = "insert into carrito (nombre_pro,fotografia, unidades_disponibles,precio,codigoUsuario) values (?, ?, ?, ?, ?)";
		try {
			System.out.println("Ejecutando " + sInsert);
			System.out.println("Datos " + carrito);
			PreparedStatement prepStatement = conexion.prepareStatement(sInsert);
			prepStatement.setString(1, carrito.getNombre_pro());
			prepStatement.setString(2, carrito.getFotografia());
			prepStatement.setInt(3, Integer.parseInt(carrito.getUnidades_disponibles()));
			prepStatement.setDouble(4, Double.parseDouble(carrito.getPrecio()));
			prepStatement.setString(5, carrito.getCodigoUsuario());
			iRes = prepStatement.executeUpdate();

		} catch (SQLException sqlex) {
			// TODO: handle exception
			System.out.println("Error: " + sqlex.getMessage());
			sqlex.printStackTrace();
		}
		return iRes;
	}

	public int insertarUsuario(Usuario usuario) {
		int iRes = 0;
		String sInsert = "insert into usuarios (email,dni,nombre,direccion,codigo_postal,telefono,contraseña) values (?, ?, ?, ?, ?, ?, ?)";
		try {
			System.out.println("Ejecutando " + sInsert);
			System.out.println("Datos " + usuario);
			PreparedStatement prepStatement =
					conexion.prepareStatement(sInsert);
					prepStatement.setString(1,usuario.getEmail());
					prepStatement.setString(2,usuario.getDni());
					prepStatement.setString(3,usuario.getNombre());
					prepStatement.setString(4,usuario.getDireccion());
					prepStatement.setString(5,usuario.getCodigo_postal());
					prepStatement.setString(6,usuario.getTelefono());
					prepStatement.setString(7,usuario.getContraseña());
					iRes = prepStatement.executeUpdate();

		} catch (SQLException sqlex) {
			// TODO: handle exception
			System.out.println("Error: " + sqlex.getMessage());
			sqlex.printStackTrace();
		}
		return iRes;
	}
	
	public int ejecutarBorrar(String sentencia) {
		int iRes = 0;
		try {
			System.out.println("Ejecutando: " + sentencia);
			PreparedStatement prepStatement = conexion.prepareStatement(sentencia);
			iRes = prepStatement.executeUpdate();
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
		}
		return iRes;
	}
	
		
}
