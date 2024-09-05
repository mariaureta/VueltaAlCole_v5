package com.ipartek.modelo;

import java.sql.Connection;
import java.util.List;

import com.ipartek.modelo.dto.Categoria;
import com.ipartek.modelo.dto.Producto;
import com.ipartek.modelo.dto.V_Producto;

public interface I_Metodos {

	Connection conectar();
	void desconectar(Connection con);
	
	List<Categoria> obtenerTodasCategorias(Connection con);
	
	void insertarProducto(Connection con, Producto product);
	List<V_Producto> obtenerTodosVProductos(Connection con);
	
	
}
