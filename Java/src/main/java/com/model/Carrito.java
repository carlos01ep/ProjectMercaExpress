package com.model;

public class Carrito {
	private String nombre_pro;
	private String fotografia;
	private String unidades_disponibles;
	private String precio;
    private String codigoUsuario;
	/**
	 * @return the nombre_pro
	 */
	public String getNombre_pro() {
		return nombre_pro;
	}
	/**
	 * @param nombre_pro the nombre_pro to set
	 */
	public void setNombre_pro(String nombre_pro) {
		this.nombre_pro = nombre_pro;
	}
	/**
	 * @return the fotografia
	 */
	public String getFotografia() {
		return fotografia;
	}
	/**
	 * @param fotografia the fotografia to set
	 */
	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}
	/**
	 * @return the unidades_disponibles
	 */
	public String getUnidades_disponibles() {
		return unidades_disponibles;
	}
	/**
	 * @param unidades_disponibles the unidades_disponibles to set
	 */
	public void setUnidades_disponibles(String unidades_disponibles) {
		this.unidades_disponibles = unidades_disponibles;
	}
	/**
	 * @return the precio
	 */
	public String getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	/**
	 * @return the codigoUsuario
	 */
	public String getCodigoUsuario() {
		return codigoUsuario;
	}
	/**
	 * @param codigoUsuario the codigoUsuario to set
	 */
	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	/**
	 * @param nombre_pro
	 * @param fotografia
	 * @param unidades_disponibles
	 * @param precio
	 * @param codigoUsuario
	 */
	public Carrito(String nombre_pro, String fotografia, String unidades_disponibles, String precio,
			String codigoUsuario) {
		super();
		this.nombre_pro = nombre_pro;
		this.fotografia = fotografia;
		this.unidades_disponibles = unidades_disponibles;
		this.precio = precio;
		this.codigoUsuario = codigoUsuario;
	}
    
    
}

