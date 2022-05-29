package com.model;

public class Usuario {

	private String email;
	private String dni;
	private String nombre;
	private String direccion;
	private String codigo_postal;
	private String telefono;
	private String contraseña;
	private String rol;
	/**
	 * @param email, email del usuario
	 * @param dni, dni del usuario
	 * @param nombre, nombre del usuario
	 * @param direccion, dirección para el pedido
	 * @param codigo_postal, codigopostal de la dirección del pedido
	 * @param telefono, telefono del usuario
	 * @param contraseña, contraseña del ususario
	 *  @param rol, rol del usuario, valor 1 usuario común; valor 0 usuario admin  
	 */
	public Usuario(String email, String dni, String nombre, String direccion, String codigo_postal, String telefono,
			String contraseña) {
		super();
		this.email = email;
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.codigo_postal = codigo_postal;
		this.telefono = telefono;
		this.contraseña = contraseña;
		this.rol = "1"; 
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the codigo_postal
	 */
	public String getCodigo_postal() {
		return codigo_postal;
	}
	/**
	 * @param codigo_postal the codigo_postal to set
	 */
	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the contraseña
	 */
	public String getContraseña() {
		return contraseña;
	}
	/**
	 * @param contraseña the contraseña to set
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}
	/**
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

}
