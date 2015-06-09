package negocio;

import java.util.ArrayList;
import modelos.*;
import datos.*;
import java.sql.*;
public class ControladorArticulo {
	
	private CatalogoArticulo catArticulo = new CatalogoArticulo();
	
	public int AddArticulo(Articulo nuevoArticulo)
	{
		//Validaciones de Negocio
		
		int idArticuloNuevo = catArticulo.AddArticulo(nuevoArticulo);
		
		return idArticuloNuevo;
	}

	public void DeleteArticulo(int pIdArticulo)
	{
		
		catArticulo.DeleteArticulo(pIdArticulo);
		
	}

	public Articulo getOne(int pIdArticulo)
	{
		Articulo ArticuloDev = new Articulo();/*Crea la estructura del articulo a devolver*/
		ArticuloDev = catArticulo.GetOne(pIdArticulo);/*Obtiene el articulo a devolver por Id*/
		
		return ArticuloDev;
	}
	
	public int UpdateArticulo(int pCodArt, String pDescripcion, int pStock, Date pFecha_precio, float pPrecio)
	{
		int rowAffect;
		Articulo modifArticulo = new Articulo();
		modifArticulo.setDescripcionArticulo(pDescripcion);
		modifArticulo.setCodigo_articulo(pCodArt);
		modifArticulo.setFechaDesde_precio(pFecha_precio);
		modifArticulo.setPrecio(pPrecio);
		modifArticulo.setStock(pStock);
		rowAffect = catArticulo.UpdateElect(modifArticulo);
		return rowAffect;/*Devuelve la cantidad de filas afectadas por el update*/
		
	}
	
	public ArrayList<Articulo> getAll()
	{
		ArrayList<Articulo> ArticulosAll = new ArrayList<Articulo>();
		ArticulosAll = catArticulo.GetAll();
		
		return ArticulosAll;
		
	}

}
