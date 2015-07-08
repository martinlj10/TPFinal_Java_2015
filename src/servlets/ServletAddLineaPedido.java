package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelos.LineaPedido;

import negocio.ControladorLineaPedido;


@WebServlet("/ServletAddLineaPedido")


public class ServletAddLineaPedido extends HttpServlet{
	
private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAddLineaPedido() {
        
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
		ControladorLineaPedido controladorLineaPedido =(ControladorLineaPedido)session.getAttribute("controladorLineaPedido");
		LineaPedido nuevaLineaPedido = new LineaPedido();
		nuevaLineaPedido.setNroPedido(Integer.parseInt(request.getParameter("id_pedido")));
		nuevaLineaPedido.setNroLinea(Integer.parseInt(request.getParameter("nro_linea")));
		nuevaLineaPedido.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
		//nuevaLineaPedido.setArt(); Ver como setear el articulo
		nuevaLineaPedido.setSub_total(Float.parseFloat(request.getParameter("subtotal")));
		
		try{
		controladorLineaPedido.AddLineaPedido(nuevaLineaPedido);
		response.sendRedirect("/PedidoActual.jsp");/*Redirige al Pedido completo */
		}
		catch(Exception e)
		{
			response.sendRedirect("/ErrorAlta.html"); //No está creada esta vista1.
		}
		// TODO Auto-generated method stub
	}

}
