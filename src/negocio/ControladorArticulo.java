package negocio;

import java.util.ArrayList;
import modelos.*;
import datos.*;
import java.sql.*;
public class ControladorArticulo {
	
	private CatalogoArticulo catArticulo = new CatalogoArticulo();
	
	public int AddArticulo(Auto nuevoArticulo)
	{
		//Validaciones de Negocio
		
		int idArticuloNuevo = catArticulo.AddArticulo(nuevoArticulo);
		
		return idArticuloNuevo;
	}

	public void DeleteArticulo(int pIdArticulo)
	{
		
		catArticulo.DeleteArticulo(pIdArticulo);
		
	}

	public Auto getOne(int pIdArticulo)
	{
		Auto ArticuloDev = new Auto();/*Crea la estructura del articulo a devolver*/
		ArticuloDev = catArticulo.GetOne(pIdArticulo);/*Obtiene el articulo a devolver por Id*/
		
		return ArticuloDev;
	}
	
	public int UpdateArticulo(int pCodArt, String pDescripcion, int pStock, Date pFecha_precio, float pPrecio)
	{
		int rowAffect;
		Auto modifArticulo = new Auto();
		modifArticulo.setDescripcionArticulo(pDescripcion);
		modifArticulo.setCodigo_articulo(pCodArt);
		modifArticulo.setFechaDesde_precio(pFecha_precio);
		modifArticulo.setPrecio(pPrecio);
		modifArticulo.setStock(pStock);
		rowAffect = catArticulo.UpdateArticulo(modifArticulo);
		return rowAffect;/*Devuelve la cantidad de filas afectadas por el update*/
		
	}
	
	public ArrayList<Auto> getAll()
	{
		ArrayList<Auto> ArticulosAll = new ArrayList<Auto>();
		ArticulosAll = catArticulo.GetAll();
		
		return ArticulosAll;
		
	}

}
