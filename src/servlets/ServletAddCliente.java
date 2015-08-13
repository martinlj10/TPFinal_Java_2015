package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelos.Auto;
import modelos.Comentario;
import negocio.ControladorArticulo;
import negocio.ControladorCliente;

@WebServlet("/ServletAddCliente")

public class ServletAddCliente {

private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAddCliente() {
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		ControladorCliente controladorCliente =(ControladorCliente)session.getAttribute("controladorCliente");
		Comentario nuevoCliente = new Comentario();
		nuevoCliente.setAlias(request.getParameter("alias").toUpperCase());
		nuevoCliente.setId_cliente(Integer.parseInt(request.getParameter("id_cliente")));
		nuevoCliente.setId_localidad(Integer.parseInt(request.getParameter("id_localidad")));
		nuevoCliente.setLocalidad(request.getParameter("localidad").toUpperCase());//ver si ponemos localidad o id_localidad
		nuevoCliente.setRazon_social(request.getParameter("razon_social").toUpperCase());
		nuevoCliente.setZona(request.getParameter("zona").toUpperCase());
				
		try{
		//controladorCliente.(nuevoCliente);
		response.sendRedirect("/ListaArticulos.jsp");/*Redirige a la lista completa de articulos*/
		}
		catch(Exception e)
		{
			response.sendRedirect("/ErrorAlta.html"); //No está creada esta vista1.
		}
		// TODO Auto-generated method stub
	}

	
}
