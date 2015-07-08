package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import negocio.ControladorPedido;

/**
 * Servlet implementation class ServletBajaPedido
 */
@WebServlet("/ServletBajaPedido")
public class ServletBajaPedido extends HttpServlet{

private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBajaPedido() {
      
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
		
		ControladorPedido controlador = (ControladorPedido)session.getAttribute("controladorPedido");
		int vIdPedido = Integer.parseInt(request.getParameter("idPedido"));
		controlador.DeletePedido(vIdPedido);
		response.sendRedirect("/ListaPedidos.jsp");/*Vista no creada*/
		
		
		// TODO Auto-generated method stub
	}

	
}
