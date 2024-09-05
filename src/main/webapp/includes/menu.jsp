<%@page import="com.ipartek.modelo.I_Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%
    String pagActual=(String)session.getAttribute("s_pagina_actual");
    %>
    
    
    
    <nav>
		<ul id="menu">
			<li class="elem_menu">
				<%if(pagActual.equals(I_Conexion.JSP_INDEX)){ %>
				<a href="MenuProductos" class="seleccionado">Productos</a>
				<%}else {%>
				<a href="MenuProductos">Productos</a>
				<%}%>
			</li>
			<li class="elem_menu">
				<a href="MenuCategorias" 
				<%if(pagActual.equals(I_Conexion.JSP_CATEGORIAS)){ %>
				class="seleccionado" 
				<%}%>
				>Categorias</a>
			</li>
		</ul>
	</nav>
	
	
	
	
	
	