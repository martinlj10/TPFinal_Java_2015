package servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import negocio.ControladorAuto;

/**
 * ESTE ES EL QUE MODIFICA
 * Servlet implementation class ServletModifArticulo
 */
@WebServlet("/ServletModificArticulo")
public class ServletModificArticulo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModificArticulo() {
        
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
		ControladorAuto controladorArticulo =(ControladorAuto)session.getAttribute("controladorArticulo");
		
		int pID=Integer.parseInt(request.getParameter("cod_articulo"));
		String pDescripcion =request.getParameter("descripcion").toUpperCase();
		Date pFechaDesde = java.sql.Date.valueOf((request.getParameter("fechaDesde_precio")));
		float pPrecio =Float.parseFloat(request.getParameter("precio"));
		int pStock = Integer.parseInt(request.getParameter("stock"));
		
		
		try{
			controladorArticulo.UpdateAuto(pID, pDescripcion, pStock, pFechaDesde, pPrecio);
		response.sendRedirect("/ModificacionArticuloExitosa.jsp"); //Vista no Creada
		}
		catch(Exception e)
		{
			response.sendRedirect("/ErrorModificacionArticulo.html"); //Vista no Creada.
		}
		// TODO Auto-generated method stub
	}


}
