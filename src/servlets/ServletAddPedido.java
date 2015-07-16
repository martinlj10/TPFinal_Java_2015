package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelos.Cliente;
import modelos.LineaPedido;
import modelos.Pedido;
import negocio.ControladorLineaPedido;
import negocio.ControladorPedido;

@WebServlet("/ServletAddPedido")

public class ServletAddPedido extends HttpServlet {

private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAddPedido() {
        
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
		ControladorPedido controladorPedido =(ControladorPedido)session.getAttribute("controladorPedido");
		Pedido nuevoPedido = new Pedido();
		nuevoPedido.setNroPedido(Integer.parseInt(request.getParameter("id_pedido")));
		nuevoPedido.setFechaEntrega(java.sql.Date.valueOf((request.getParameter("fecha_entrega"))));
		nuevoPedido.setFechaPedido(java.sql.Date.valueOf((request.getParameter("fecha_pedido"))));
		nuevoPedido.setIVA(Float.parseFloat(request.getParameter("IVA")));
		nuevoPedido.setEstado(request.getParameter("estado"));
		Cliente ClientePedido = new Cliente();
		ClientePedido.setId_cliente(Integer.parseInt(request.getParameter("idCliente")));
		nuevoPedido.setCliente(ClientePedido);//ver si fuciona 
		//nuevoPedido.setDetalles(detalles); ver como recuperar la lista de lineas pedidos -- es necesario? si el insert se hace con la linea de pedido
				
		try{
		controladorPedido.AddPedido(nuevoPedido);
		response.sendRedirect("/ListaPedidos.jsp");/*Redirige a la lista completa de Pedidos*/
		}
		catch(Exception e)
		{
			response.sendRedirect("/ErrorAlta.html"); //No está creada esta vista1.
		}
		// TODO Auto-generated method stub
	}

	
}
