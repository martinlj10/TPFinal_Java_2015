package datos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import modelos.*;

public class CatalogoPedido {

	public int AddPedido(Pedido pPedido)
	{ //se cargan los pedidos
		try{
			//Agrega un pedido a la Tabla Pedido 
		String SQLCons= "INSERT INTO Pedido (nro_pedido, id_cliente, fecha_pedido, fecha_entrega, descuento)"+ " VALUES (?,?,?,?,?) " ;
	ConexionBD conecta = new ConexionBD();
	conecta.OpenConection();
	PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
	stmt.setInt(1,pPedido.getNroPedido());
	stmt.setInt(2, pPedido.getCliente().getId_cliente());
	stmt.setDate(3, pPedido.getFechaPedido());
	stmt.setDate(4, pPedido.getFechaEntrega());
	//stmt.setInt(5, pPedido.get); ****Faltaria Incluir un descuento.
	
	stmt.execute();
	
	conecta.CloseConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
									}
			return Statement.RETURN_GENERATED_KEYS;
	}
	
	public void DeletePedido(int pId_Pedido)
	{
		String SQLCons= "DELETE FROM pedidos where ?= nro_Pedido";
		try {
			ConexionBD conecta = new ConexionBD();
			conecta.OpenConection();
			PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
			stmt.setInt(1, pId_Pedido);
			int rta = stmt.executeUpdate();
			
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
	
	public int UpdatePedido (Pedido PedidoUPD)
	{
		
		String SQLCons= "UPDATE Pedido SET id_cliente=? , fecha_pedido=?, fecha_entrega=?, descuento=? WHERE ?=nro_pedido ";
		try{
			
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setInt(1, PedidoUPD.getCliente().getId_cliente());
		stmt.setDate(2, PedidoUPD.getFechaPedido());
		stmt.setDate(3, PedidoUPD.getFechaEntrega());
		//stmt.setDate(4, ArticuloUPD.getFechaDesde_precio()); Ver Descuento
		stmt.setInt(5, PedidoUPD.getNroPedido());
		
		int rta = stmt.executeUpdate();
		}		
				 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return Statement.RETURN_GENERATED_KEYS;
	}
	
	public ArrayList<Pedido> GetAll()
	{
	ArrayList<Pedido> PedidosAll = new ArrayList<Pedido>();
		
		try {
			String SQLCons= "Select nro_Pedido, fecha_pedido, fecha_entrega, FROM pedido ORDER BY nro_pedido";
			ConexionBD conecta = new ConexionBD();
			conecta.OpenConection();
			PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
			ResultSet rta = stmt.executeQuery();
			 	while(rta.next())
						{		Pedido PedidoDev = new Pedido();
					 			PedidoDev.setNroPedido(rta.getInt("nro_pedido"));
								PedidoDev.setFechaPedido(rta.getDate("fecha_pedido"));
								PedidoDev.setFechaEntrega(rta.getDate("fecha_entrega"));
								PedidosAll.add(PedidoDev);
								
				}
		}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return PedidosAll;
	}

	public Pedido GetOne(int pId)
	{
		
		Pedido PedidoDev = new Pedido();
		try{
			
		 
		
		String SQLCons= "SELECT nro_pedido, fecha_pedido, fecha_entrega FROM Pedido WHERE nro_pedido=?";
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setInt(1, pId);		
		ResultSet rta = stmt.executeQuery();
		while(rta.next())
		{
						PedidoDev.setNroPedido(rta.getInt("nro_pedido"));
					    PedidoDev.setFechaEntrega(rta.getDate("fecha_entrega"));
					    PedidoDev.setFechaPedido(rta.getDate("fecha_pedido"));
												
		}
					rta.close();
					stmt.close();
						
						
						} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
								}
		return PedidoDev;
	}
	
}
