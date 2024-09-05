package com.ipartek.menu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.modelo.I_Conexion;


@WebServlet("/MenuCategorias")
public class MenuCategorias extends HttpServlet implements I_Conexion{
	private static final long serialVersionUID = 1L;
   
    public MenuCategorias() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.setAttribute(S_PAGINA_ACTUAL, JSP_CATEGORIAS);
		
		request.getRequestDispatcher(JSP_CATEGORIAS).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
