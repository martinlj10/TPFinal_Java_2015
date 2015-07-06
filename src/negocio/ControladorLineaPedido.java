package negocio;

import java.util.ArrayList;

import modelos.*;
import datos.*;

import java.sql.*;

public class ControladorLineaPedido {

		private CatalogoLineaPedido catLineaPedido = new CatalogoLineaPedido();
		
		public int AddLineaPedido(LineaPedido nuevaLineaPedido)
		{
			//Validaciones de Negocio
			
			int idLineaPedidoNueva = catLineaPedido.AddLineaPedido(nuevaLineaPedido);
			
			return idLineaPedidoNueva;
		}

		public void DeleteLineaPedido(int pIdLineaPedido, int pIdPedido)
		{
			
			catLineaPedido.DeleteLineaPedido(pIdLineaPedido, pIdLineaPedido);
			
		}

		public LineaPedido getOne(int pIdLineaPedido, int pIdPedido)
		{
			LineaPedido LineaPedidoDev = new LineaPedido();/*Crea la estructura del LineaPedido a devolver*/
			LineaPedidoDev = catLineaPedido.GetOne(pIdLineaPedido, pIdPedido);/*Obtiene la linea Pedido de un Pedido a devolver por IdLinea e IdPedido*/
			
			return LineaPedidoDev;
		}
		
		public int UpdateLineaPedido(int pIdLinea, int pIdPedido, int pIdArticulo, int pCantidad, float pSubtotal)
		{
			int rowAffect;
			CatalogoArticulo catArticulo = new CatalogoArticulo();
			LineaPedido modifLineaPedido = new LineaPedido();
			modifLineaPedido.setNroPedido(pIdPedido);
			modifLineaPedido.setArt(catArticulo.GetOne(pIdArticulo));
			modifLineaPedido.setNroLinea(pIdLinea);
			modifLineaPedido.setCantidad(pCantidad);
			modifLineaPedido.setSub_total(pSubtotal);
			rowAffect = catLineaPedido.UpdateLineaPedido(modifLineaPedido);
			return rowAffect;
			
		}
		
		public ArrayList<LineaPedido> getAll(int pIdPedido)
		{
			ArrayList<LineaPedido> LineaPedidoAll = new ArrayList<LineaPedido>();
			LineaPedidoAll = catLineaPedido.GetAll(pIdPedido);
			
			return LineaPedidoAll;
			
		}
	
}
