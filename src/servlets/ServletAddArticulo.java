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
import negocio.ControladorArticulo;;

@WebServlet("/ServletAddArticulo")
public class ServletAddArticulo extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAddArticulo() {
        
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
		Auto nuevoArticulo = new Auto();
		nuevoArticulo.setCodigo_articulo(Integer.parseInt(request.getParameter("cod_articulo")));
		nuevoArticulo.setDescripcionArticulo(request.getParameter("descripcion").toUpperCase());
		nuevoArticulo.setFechaDesde_precio(java.sql.Date.valueOf((request.getParameter("fechaDesde_precio"))));
		nuevoArticulo.setPrecio(Float.parseFloat(request.getParameter("precio")));
		nuevoArticulo.setStock(Integer.parseInt(request.getParameter("stock")));
		
		
		try{
		controladorArticulo.AddArticulo(nuevoArticulo);
		response.sendRedirect("/ListaArticulos.jsp");/*Redirige a la lista completa de articulos*/
		}
		catch(Exception e)
		{
			response.sendRedirect("/ErrorAlta.html"); //No está creada esta vista1.
		}
		// TODO Auto-generated method stub
	}

}
