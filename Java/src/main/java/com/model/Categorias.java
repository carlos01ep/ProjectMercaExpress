package com.model;

public class Categorias {


	private String nombre_categoria;
	private String condiciones_de_almacenamiento;
	private String observaciones;
	/**
	 * @param codigo_categoria codigo para identificar la categoria
	 * @param nombre_categoria nombre de la categoria
	 * @param condiciones_de_almacenamiento información sobre las condiciones de almacenamiento
	 * @param observaciones informacion adicional
	 */
	public void comprobar_tamaño() {
		
	}
	public Categorias(String nombre_categoria, String condiciones_de_almacenamiento,
			String observaciones) {
		super();

		this.nombre_categoria = nombre_categoria;
		this.condiciones_de_almacenamiento = condiciones_de_almacenamiento;
		this.observaciones = observaciones;
	}

	/**
	 * @return the nombre_categoria
	 */
	public String getNombre_categoria() {
		return nombre_categoria;
	}
	/**
	 * @param nombre_categoria the nombre_categoria to set
	 */
	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}
	/**
	 * @return the condiciones_de_almacenamiento
	 */
	public String getCondiciones_de_almacenamiento() {
		return condiciones_de_almacenamiento;
	}
	/**
	 * @param condiciones_de_almacenamiento the condiciones_de_almacenamiento to set
	 */
	public void setCondiciones_de_almacenamiento(String condiciones_de_almacenamiento) {
		this.condiciones_de_almacenamiento = condiciones_de_almacenamiento;
	}
	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}
	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public String toString() {
		StringBuffer sbResultado = new StringBuffer();
		sbResultado.append(";");
		sbResultado.append(nombre_categoria);
		sbResultado.append(";");
		sbResultado.append(condiciones_de_almacenamiento);
		sbResultado.append(";");
		sbResultado.append(observaciones);
		sbResultado.append("\n");
		return sbResultado.toString();
	}
}
