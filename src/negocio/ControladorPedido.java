package negocio;
import java.util.ArrayList;

import modelos.*;
import datos.*;

import java.sql.*;

public class ControladorPedido {
	
private CatalogoPedido catPedido = new CatalogoPedido();
	
	public int AddPedido(Pedido nuevoPedido)
	{
		//Validaciones de Negocio
		
		int idPedidoNuevo = catPedido.AddPedido(nuevoPedido);
		
		return idPedidoNuevo;
	}

	public void DeletePedido(int pIdPedido)
	{
		
		catPedido.DeletePedido(pIdPedido);
		
	}

	public Pedido getOne(int pIdPedido)
	{
		Pedido PedidoDev = new Pedido();/*Crea la estructura del Pedido a devolver*/
		PedidoDev = catPedido.GetOne(pIdPedido);/*Obtiene el pedido a devolver por Id*/
		
		return PedidoDev;
	}
	
	public int UpdatePedido(int pIdPedido, int pIdCliente, Date pFecha_Pedido, Date pFecha_Entrega, int pDescuento)
	{
		int rowAffect;
		Pedido modifPedido = new Pedido();
		modifPedido.setNroPedido(pIdPedido);
		//modifPedido.setCliente; ver como setear cliente
		modifPedido.setFechaPedido(pFecha_Pedido);
		modifPedido.setFechaEntrega(pFecha_Entrega);
		//modifPedido. incluir descuento
		rowAffect = catPedido.UpdatePedido(modifPedido);
		return rowAffect;/*Devuelve la cantidad de filas afectadas por el update*/
		
	}
	
	public ArrayList<Pedido> getAll()
	{
		ArrayList<Pedido> PedidosAll = new ArrayList<Pedido>();
		PedidosAll = catPedido.GetAll();
		
		return PedidosAll;
		
	}


}
