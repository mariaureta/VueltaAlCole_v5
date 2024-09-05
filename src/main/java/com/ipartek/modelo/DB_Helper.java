package com.ipartek.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.modelo.dto.Categoria;
import com.ipartek.modelo.dto.Producto;
import com.ipartek.modelo.dto.V_Producto;

public class DB_Helper implements I_Conexion, I_Metodos {

	@Override
	public Connection conectar() {

		Connection con = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONEXION, USUARIO, PASS);

			System.out.println("BD conectada");
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR DE BD");
			System.out.println("No se encontro el driver");
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("ERROR DE BD");
			System.out.println("No se pudo conectar a la BD");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR DE BD");
			System.out.println("Error desconocido");
			System.out.println(e.getMessage());
		}

		return con;
	}

	@Override
	public void desconectar(Connection con) {

		try {
			con.close();
			System.out.println("BD desconectada");
		} catch (SQLException e) {
			System.out.println("ERROR DE BD");
			System.out.println("No se pudo desconectar de la BD");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR DE BD");
			System.out.println("Error desconocido");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Categoria> obtenerTodasCategorias(Connection con) {
		List<Categoria> lista = new ArrayList<Categoria>();

		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_TODAS_CATEGORIAS);

			boolean tieneSelect = cStmt.execute();

			if (tieneSelect == true) {
				ResultSet rs = cStmt.getResultSet();

				while (rs.next()) {
					Categoria categ = new Categoria();

					categ.setId(rs.getInt(CATEGORIAS_ID));
					categ.setNombre(rs.getString(CATEGORIAS_NOMBRE));

					lista.add(categ);
				}

				System.out.println("Lista de todas las categorias obtenida:");
				System.out.println(lista);

				return lista;
			} else {
				System.out.println("No se pudo obtener una lista de categorias");
				System.out.println("El Stored procedure no tiene un RESULTSET");

				return new ArrayList<Categoria>();
			}

		} catch (SQLException e) {
			System.out.println("ERROR DE BD: CONSULTA");
			System.out.println("Error al obtener la lista de todas las categorias");
			System.out.println(e.getMessage());

			return new ArrayList<Categoria>();
		}
	}

	@Override
	public void insertarProducto(Connection con, Producto product) {

		try {
			CallableStatement cStmt = con.prepareCall(SP_INSERTAR_PRODUCTO);

			cStmt.setString(1, product.getNombre());
			cStmt.setDouble(2, product.getPrecio());
			cStmt.setInt(3, product.getFk_categoria());

			cStmt.execute();
		} catch (SQLException e) {
			System.out.println("ERROR DE BD: INSERTAR");
			System.out.println("No se pudo insertar el producto");
			System.out.println(e.getMessage());
		}

	}

	@Override
	public List<V_Producto> obtenerTodosVProductos(Connection con) {
		List<V_Producto> lista = new ArrayList<V_Producto>();

		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_TODOS_PRODUCTOS);

			boolean tieneSelect = cStmt.execute();

			if (tieneSelect == true) {
				ResultSet rs = cStmt.getResultSet();

				while (rs.next()) {
					V_Producto v_prod = new V_Producto();

					v_prod.setId(rs.getInt(V_PRODUCTOS_ID));
					v_prod.setNombre(rs.getString(V_PRODUCTOS_NOMBRE));
					v_prod.setPrecio(rs.getDouble(V_PRODUCTOS_PRECIO));
					v_prod.setFk_categoria(rs.getInt(V_PRODUCTOS_FK_CATEGORIA));
					v_prod.setCategoria(rs.getString(V_PRODUCTOS_CATEGORIA));

					lista.add(v_prod);
				}

				System.out.println("Lista de todos los V_Productos obtenida:");
				System.out.println(lista);

				return lista;
			} else {
				System.out.println("No se pudo obtener una lista de todos los V_Productos");
				System.out.println("El Stored procedure no tiene un RESULTSET");

				return new ArrayList<V_Producto>();
			}

		} catch (SQLException e) {
			System.out.println("ERROR DE BD: CONSULTA");
			System.out.println("Error al obtener la lista de todos los V_Productos");
			System.out.println(e.getMessage());

			return new ArrayList<V_Producto>();
		}
	}

	public void borrarProducto(Connection con, int id) {
		try {
			CallableStatement cStmt = con.prepareCall(SP_BORRAR_PRODUCTO);
			cStmt.setInt(1,id);

			cStmt.execute();
		} catch (SQLException e) {
			System.out.println("ERROR DE BD: BORRAR");
			System.out.println("No se pudo Borrar el producto");
			System.out.println(e.getMessage());
		}

	}

}
