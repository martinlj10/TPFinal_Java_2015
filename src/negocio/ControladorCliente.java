package negocio;
import java.util.ArrayList;

import modelos.*;
import datos.*;

import java.sql.*;


public class ControladorCliente {

	private CatalogoCliente catCliente = new CatalogoCliente();
	
	public int AddCliente(Cliente nuevoCliente)
	{
		//Validaciones de Negocio
		
		int idClienteNuevo = catCliente.AddCliente(nuevoCliente);
		
		return idClienteNuevo;
	}

	public void DeleteCliente(int pIdCliente)
	{
		
		catCliente.DeleteCliente(pIdCliente);
		
	}

	public Cliente getOne(int pIdCliente)
	{
		Cliente ClienteDev = new Cliente();/*Crea la estructura del Cliente a devolver*/
		ClienteDev = catCliente.GetOne(pIdCliente);/*Obtiene el Cliente a devolver por Id*/
		
		return ClienteDev;
	}
	
	public int UpdateCliente(int pCliente, String pAlias, int pIdLocalidad, String pLocalidad, String pRazon_Social, String pZona)
	{
		int rowAffect;
		Cliente modifCliente = new Cliente();
		modifCliente.setAlias(pAlias);
		modifCliente.setId_cliente(pCliente);
		modifCliente.setId_localidad(pIdLocalidad);
		modifCliente.setLocalidad(pLocalidad);
		modifCliente.setRazon_social(pRazon_Social);
		modifCliente.setZona(pZona);
		rowAffect = catCliente.UpdateCliente(modifCliente);
		return rowAffect;/*Devuelve la cantidad de filas afectadas por el update*/
		
	}
	
	public ArrayList<Cliente> getAll()
	{
		ArrayList<Cliente> ClienteAll = new ArrayList<Cliente>();
		ClienteAll = catCliente.GetAll();
		
		return ClienteAll;
		
	}
	
	
}
