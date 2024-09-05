package com.ipartek.modelo;

import java.sql.Connection;

/**
 * LA INTERFAZ
 * @author Java
 *
 */
public interface I_Conexion {
	
	//Conexion a la BD
	String BASE_DATOS = "vueltacole";
	String DRIVER = "com.mysql.jdbc.Driver";
	String CONEXION = "jdbc:mysql://localhost:3306/"+BASE_DATOS;
	String USUARIO = "root";
	String PASS = "1234";
	
	//tablas y views de la BD
	String TABLA_PRODUCTOS="productos";
	String PRODUCTOS_ID="id";
	String PRODUCTOS_NOMBRE="nombre";
	String PRODUCTOS_PRECIO="precio";
	String PRODUCTOS_FK_CATEGORIA="FK_categoria";
	
	String TABLA_CATEGORIAS="categorias";
	String CATEGORIAS_ID="id";
	String CATEGORIAS_NOMBRE="nombre";
	
	String VIEW_PRODUCTOS="productos";
	String V_PRODUCTOS_ID="id";
	String V_PRODUCTOS_NOMBRE="nombre";
	String V_PRODUCTOS_PRECIO="precio";
	String V_PRODUCTOS_FK_CATEGORIA="FK_categoria";
	String V_PRODUCTOS_CATEGORIA="categoria";
	
	//Archivos JSP
	String JSP_INDEX="index.jsp";
	String JSP_CATEGORIAS="categorias.jsp";

	//atributos
	String ATR_LISTA_CATEGORIAS="atr_lista_categorias";
	String ATR_LISTA_V_PRODUCTOS="atr_lista_v_productos";
	
	//sesiones
	String S_PAGINA_ACTUAL="s_pagina_actual";
	
	//stored procedures
	String SP_OBTENER_TODAS_CATEGORIAS="call sp_categorias_obtener_todas();";
	String SP_INSERTAR_PRODUCTO="call sp_productos_insertar(?, ?, ?);";
	String SP_OBTENER_TODOS_PRODUCTOS="call sp_productos_obtener_todos();";
	String SP_BORRAR_PRODUCTO="call sp_productos_borrar(?);";


}
