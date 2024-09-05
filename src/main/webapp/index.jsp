<%@page import="com.ipartek.modelo.dto.V_Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.modelo.dto.Categoria"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%
 List<Categoria> listaCategorias = new ArrayList<Categoria>();
 if(request.getAttribute(I_Conexion.ATR_LISTA_CATEGORIAS)!=null){
	 listaCategorias=(List<Categoria>)request.getAttribute(I_Conexion.ATR_LISTA_CATEGORIAS);
 }
 
 List<V_Producto> listaProductos = new ArrayList<V_Producto>();
 if(request.getAttribute(I_Conexion.ATR_LISTA_V_PRODUCTOS)!=null){
	 listaProductos=(List<V_Producto>)request.getAttribute(I_Conexion.ATR_LISTA_V_PRODUCTOS);
 }
 
 %>   
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/style.css">
</head>
<body>
	<%@ include  file="includes/cabecera.jsp" %>
	<%@ include  file="includes/menu.jsp" %>
	
	<main>
	
	<section id="contenedor">
		<form action="GuardarProducto" method="get">
			<label for="p_prod">Producto</label>
			<input type="text" id="p_prod" name="p_prod"> <br>
			
			<label for="p_precio">Precio</label>
			<input type="text" id="p_precio" name="p_precio"> <br>
			
			<label for="p_categ">Categoria</label>
			<select id="p_categ" name="p_categ">
				<%for(Categoria elem : listaCategorias){ %>
				<option value="<%= elem.getId()%>"><%=elem.getNombre() %></option> 
				<%}%>
			</select> <br>
			
			<input type="submit" value="Guardar">
		</form>	
	</section>
	
	<section id="contenedor">
			<table border="1">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nombre</th>
						<th>Precio</th>
						<th>Categoría</th>
						<th>Opciones</th>
					</tr>
				</thead>
				<tbody>
					<%for(V_Producto elem :  listaProductos){ %>
					<tr>
						<td><%=elem.getId() %></td>
						<td><%=elem.getNombre() %></td>
						<td><%=elem.getPrecio() %></td>
						<td><%=elem.getCategoria() %></td>
						<td>
							<a href="#">Editar</a> 
							<a href="EliminarProducto?id=<%=elem.getId() %>">Eliminar</a>
						</td>
					</tr>
					<%} %>
				</tbody>
			</table>
		</section>
	
	</main>
	
	<footer>
	PIE
	</footer>
	
	
	
	
	
	
</body>
</html>