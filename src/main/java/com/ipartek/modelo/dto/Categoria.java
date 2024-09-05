package com.ipartek.modelo.dto;

/**
 * <b> Clase Categoria </b>
 * 
 * <p> Clase Categoria que referencia a la tabla Categoria de la BBDD</p>
 * @author María
 *
 */

public class Categoria {
	/**
	 * Atributo ID:
	 * <b> A LA HORA DE INSERTAR EN LA BD ES AUTONUMERICO, NO MODIFICAR</b>
	 * 
	 */
	private int id;
	
	/**
	 * Atributo nombre:
	 * varchar(45) en la BD
	 */
	private String nombre;
	
	/**
	 * Constructor completo 
	 * @param id un integer, si no lo hemos recogido en la BD deberia ser un 0
	 * @param nombre
	 */
	public Categoria(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public Categoria() {
		super();
		this.id = 0;
		this.nombre = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}
