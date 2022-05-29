package com.model;

public class Productos {

	private String nombre_pro;
	private String marca;
	private String origen;
	private String dimensiones;
	private String fotografia;
	private String unidades_disponibles;
	private String Nombrecategoria;
	private String precio;
	private String codigo_categoria;

	
	/**
	 * @return the codigo_categoria
	 */
	public String getCodigo_categoria() {
		return codigo_categoria;
	}

	/**
	 * @param codigo_categoria the codigo_categoria to set
	 */
	public void setCodigo_categoria(String codigo_categoria) {
		this.codigo_categoria = codigo_categoria;
	}

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
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the origen
	 */
	public String getOrigen() {
		return origen;
	}

	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}

	/**
	 * @return the dimensiones
	 */
	public String getDimensiones() {
		return dimensiones;
	}

	/**
	 * @param dimensiones the dimensiones to set
	 */
	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
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
	 * @return the nombrecategoria
	 */
	public String getNombrecategoria() {
		return Nombrecategoria;
	}

	/**
	 * @param nombrecategoria the nombrecategoria to set
	 */
	public void setNombrecategoria(String nombrecategoria) {
		Nombrecategoria = nombrecategoria;
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
	 * constructor de la clase Productos
	 * @param nombre_pro Nombre del jugador
	 * @param marca Nombre del jugador
	 * @param origen Nombre del jugador
	 * @param dimensiones Nombre del jugador
	 * @param fotografia Nombre del jugador
	 * @param unidades_disponibles Nombre del jugador
	 * @param Nombrecategoria precio
	 * @param precio precio
	 * @since April 2022
	 */

	
	public Productos(String nombre_pro, String marca, String origen, String dimensiones, String fotografia,
			String unidades_disponibles, String nombrecategoria, String precio,String codigo_categoria) {

		super();
		this.nombre_pro = nombre_pro;
		this.marca = marca;
		this.origen = origen;
		this.dimensiones = dimensiones;
		this.fotografia = fotografia;
		this.unidades_disponibles = unidades_disponibles;
		this.Nombrecategoria = nombrecategoria;
		this.precio = precio;
		this.codigo_categoria=codigo_categoria;
	}

	public String toString() {
		StringBuffer sbResultado = new StringBuffer();
		sbResultado.append(";");
		sbResultado.append(nombre_pro);
		sbResultado.append(";");
		sbResultado.append(marca);
		sbResultado.append(";");
		sbResultado.append(origen);
		sbResultado.append(";");
		sbResultado.append(dimensiones);
		sbResultado.append(";");
		sbResultado.append(fotografia);
		sbResultado.append(";");
		sbResultado.append(unidades_disponibles);
		sbResultado.append(";");
		sbResultado.append(Nombrecategoria);
		sbResultado.append(";");
		sbResultado.append(precio);
		sbResultado.append("\n");
		return sbResultado.toString();
	}
	
}
