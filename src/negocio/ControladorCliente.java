package negocio;
import java.util.ArrayList;

import modelos.*;
import datos.*;

import java.sql.*;


public class ControladorCliente {

	private CatalogoComentario catCliente = new CatalogoComentario();
	
	public int AddCliente(Comentario nuevoCliente)
	{
		//Validaciones de Negocio
		
		int idClienteNuevo = catCliente.AddCliente(nuevoCliente);
		
		return idClienteNuevo;
	}

	public void DeleteCliente(int pIdCliente)
	{
		
		catCliente.DeleteCliente(pIdCliente);
		
	}

	public Comentario getOne(int pIdCliente)
	{
		Comentario ClienteDev = new Comentario();/*Crea la estructura del Cliente a devolver*/
		ClienteDev = catCliente.GetOne(pIdCliente);/*Obtiene el Cliente a devolver por Id*/
		
		return ClienteDev;
	}
	
	public int UpdateCliente(int pCliente, String pAlias, int pIdLocalidad, String pLocalidad, String pRazon_Social, String pZona)
	{
		int rowAffect;
		Comentario modifCliente = new Comentario();
		modifCliente.setAlias(pAlias);
		modifCliente.setId_cliente(pCliente);
		modifCliente.setId_localidad(pIdLocalidad);
		modifCliente.setLocalidad(pLocalidad);
		modifCliente.setRazon_social(pRazon_Social);
		modifCliente.setZona(pZona);
		rowAffect = catCliente.UpdateCliente(modifCliente);
		return rowAffect;/*Devuelve la cantidad de filas afectadas por el update*/
		
	}
	
	public ArrayList<Comentario> getAll()
	{
		ArrayList<Comentario> ClienteAll = new ArrayList<Comentario>();
		ClienteAll = catCliente.GetAll();
		
		return ClienteAll;
		
	}
	
	
}
