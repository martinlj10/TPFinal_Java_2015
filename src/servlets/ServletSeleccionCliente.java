package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelos.Cliente;
import negocio.ControladorCliente;

/**
 * Servlet implementation class ServletSeleccionCliente
 */
@WebServlet("/ServletSeleccionCliente")

public class ServletSeleccionCliente extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSeleccionCliente() {
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
		ControladorCliente controlador=(ControladorCliente)session.getAttribute("controlador");
		Cliente cli=controlador.getOne(Integer.parseInt(request.getParameter("idCliente")));
		//continuar
// TODO Auto-generated method stub
	}


}