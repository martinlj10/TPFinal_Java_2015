package datos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import modelos.*;


public class CatalogoLineaPedido {

	public int AddLineaPedido(LineaPedido pLineaPedido)
	{ //se cargan los pedidos
		try{
			//Agrega una LineaPedido a la Tabla LineaPedido que corresponde a un Pedido
		String SQLCons= "INSERT INTO linea_pedido (id_linea, id_pedido, id_articulo, cantidad, subtotal)"+ " VALUES (?,?,?,?,?)" ;
	ConexionBD conecta = new ConexionBD();
	conecta.OpenConection();
	PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
	stmt.setInt(1,pLineaPedido.getNroLinea());
	stmt.setInt(2, pLineaPedido.getNroPedido());
	stmt.setInt(3, pLineaPedido.getArt().getCodigo_articulo());
	stmt.setInt(4, pLineaPedido.getCantidad());
	stmt.setFloat(5, ((pLineaPedido.getArt().getPrecio())*(pLineaPedido.getCantidad()))); 
	
	stmt.execute();
	
	conecta.CloseConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
									}
			return Statement.RETURN_GENERATED_KEYS;
	}
	
	public void DeleteLineaPedido(int pId_LineaPedido, int pId_Pedido)
	{
		String SQLCons= "DELETE FROM linea_pedidos where (?= id_linea AND ?=id_pedido)";
		try {
			ConexionBD conecta = new ConexionBD();
			conecta.OpenConection();
			PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
			stmt.setInt(1, pId_LineaPedido);
			stmt.setInt(2, pId_Pedido);
			int rta = stmt.executeUpdate();
			
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
	
	public int UpdateLineaPedido (LineaPedido LineaPedidoUPD)
	{
		/*Ver UPDATED DE LINEA DE PEDIDO*/
		String SQLCons= "UPDATE linea_Pedido SET id_articulo=? , cantidad=?, subtotal=?, WHERE (?=id_linea AND ?=id_pedido)";
		try{
			
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setInt(1, LineaPedidoUPD.getArt().getCodigo_articulo());
		stmt.setInt(2, LineaPedidoUPD.getCantidad());
		stmt.setFloat(3, ((LineaPedidoUPD.getCantidad())*(LineaPedidoUPD.getArt().getPrecio())));
		stmt.setInt(4, LineaPedidoUPD.getNroLinea()); 
		stmt.setInt(5, LineaPedidoUPD.getNroPedido());
		
		int rta = stmt.executeUpdate();
		}		
				 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return Statement.RETURN_GENERATED_KEYS;
	}
	
	public ArrayList<LineaPedido> GetAll(int pNroPedido)
	{//Devuelve las lineas de pedido correspondiente a un Pedido en particular
	ArrayList<LineaPedido> PedidosAll = new ArrayList<LineaPedido>();
		
		try {
			String SQLCons= "Select id_linea, id_articulo, cantidad, subtotal FROM linea_pedido  WHERE id_Pedido =? ORDER BY id_linea";
			ConexionBD conecta = new ConexionBD();
			conecta.OpenConection();
			PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
			stmt.setInt(1, pNroPedido);
			ResultSet rta = stmt.executeQuery();
			 	while(rta.next())
						{		LineaPedido LineaPedidoDev = new LineaPedido();
					 			LineaPedidoDev.setNroPedido(rta.getInt("nro_pedido"));
								LineaPedidoDev.setNroLinea(rta.getInt("id_linea"));
								//Ver como hacemos con el articulo
								LineaPedidoDev.setCantidad(rta.getInt("cantidad"));
								LineaPedidoDev.setSub_total(rta.getFloat("subtotal"));
								PedidosAll.add(LineaPedidoDev);
								
				}
		}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return PedidosAll;
	}

	public LineaPedido GetOne(int pIdLinea, int pIdPedido)
	{
		
		LineaPedido LineaPedidoDev = new LineaPedido();
		try{
			
		 
		
		String SQLCons= "SELECT id_cliente, cantidad, subtotal FROM Linea_Pedido WHERE (nro_pedido=? AND nro_linea=?)";
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setInt(1, pIdPedido);
		stmt.setInt(2, pIdLinea);
		ResultSet rta = stmt.executeQuery();
		while(rta.next())
		{
						LineaPedidoDev.setNroPedido(pIdPedido);
					    LineaPedidoDev.setCantidad(rta.getInt("cantidad"));
					    LineaPedidoDev.setSub_total(rta.getFloat("subtotal"));
												
		}
					rta.close();
					stmt.close();
						
						
						} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
								}
		return LineaPedidoDev;
	}
	
	
}
