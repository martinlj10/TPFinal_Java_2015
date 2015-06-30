package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelos.Articulo;
import negocio.ControladorArticulo;

/**
 * ESTE ES EL QUE OBTIENE EL OBJETO SELECCIONADO Y REDIRIGE A LA VENTANA DE MODIFICACION
 * Servlet implementation class ServletModifArticuloSeleccionado
 */
@WebServlet("/ServletModifArticuloSeleccionado")
public class ServletModifArticuloSeleccionado extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifArticuloSeleccionado() {
        
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
		ControladorArticulo controladorArticulo =(ControladorArticulo)session.getAttribute("controladorArticulo");
				
		int pID =Integer.parseInt(request.getParameter("idArticuloSelected"));
		
		Articulo articuloSelect =controladorArticulo.getOne(pID);
		
		request.setAttribute("electroSelect", articuloSelect);
		
		request.getRequestDispatcher("/ModifArticulo.jsp").forward(request, response);
		
		// TODO Auto-generated method stub
	}

	
}
