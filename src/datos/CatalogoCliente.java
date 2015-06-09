package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelos.Clientes;

public class CatalogoCliente {
	
	public int AddCliente(Clientes newCliente)
	{
		try{
			//Agrega un articulo a la Tabla Clientes 
		String SQLCons= "INSERT INTO Clientes (cod_cliente,razon_social, alias, id_localidad)"+ " VALUES (?,?,?,?)";
	ConexionBD conecta = new ConexionBD();
	conecta.OpenConection();
	PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
	stmt.setInt(1,newCliente.getId_cliente());
	stmt.setString(2, newCliente.getRazon_social());
	stmt.setString(3, newCliente.getAlias());
	stmt.setInt(4, newCliente.getId_localidad());
	
	stmt.execute();
	
	conecta.CloseConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
									}
			return Statement.RETURN_GENERATED_KEYS;
	}
	public void DeleteCliente(int pId_cliente)
	{
		String SQLCons= "DELETE FROM Articulos where ?= cod_cliente";
		try {
			ConexionBD conecta = new ConexionBD();
			conecta.OpenConection();
			PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
			stmt.setInt(1, pId_cliente);
			int rta = stmt.executeUpdate();
			
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
	public int UpdateElect (Clientes ClienteUPD)
	{
		String SQLCons= "UPDATE Clientes SET razon_social=? , alias=? , id_localidad=? WHERE ?=cod_cliente";
		try{
			
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setString(1, ClienteUPD.getRazon_social());
		stmt.setString(2, ClienteUPD.getAlias());
		stmt.setInt(3, ClienteUPD.getId_localidad());
		stmt.setInt(4, ClienteUPD.getId_cliente());
		
		int rta = stmt.executeUpdate();
		}		
				 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return Statement.RETURN_GENERATED_KEYS;
	}


	public ArrayList<Clientes> GetAll()
	{
	ArrayList<Clientes> ClientesAll = new ArrayList<Clientes>();
		
		try {
			String SQLCons= "Select cod_cliente, razon_social, alias, nombre_localidad, descrip_zona FROM Clientes INNER JOIN localidades ON clientes.id_localidad = localidades.id_articulo INNER JOIN zonas ON localidades.id_zona =zonas.id_zona ORDER BY razon_social";
			ConexionBD conecta = new ConexionBD();
			conecta.OpenConection();
			PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
			ResultSet rta = stmt.executeQuery();
			 	while(rta.next())
						{		Clientes ClienteDev = new Clientes();
					 			ClienteDev.setId_cliente(rta.getInt("cod_cliente"));
								ClienteDev.setRazon_social(rta.getString("razon_social"));						
								ClienteDev.setAlias(rta.getString("alias"));
								ClienteDev.setLocalidad(rta.getString("nombre_localidad"));
								ClienteDev.setZona(rta.getString("descrip_zona"));
								ClientesAll.add(ClienteDev);
								
				}
		}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return ClientesAll;
	}



	public Clientes GetOne(int pIdCliente)
	{
		
		Clientes ClienteDev = new Clientes();
		try{
			
		 
		
		String SQLCons= "SELECT * FROM Clientes INNER JOIN localidades ON clientes.id_localidad=localidades.id_localidad INNER JOIN zonas ON zonas.id_zona=localidades.id_zona WHERE Clientes.cod_Cliente=?";
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setInt(1, pIdCliente);		
		ResultSet rta = stmt.executeQuery();
		while(rta.next())
		{
			ClienteDev.setId_cliente(rta.getInt("cod_cliente"));
			ClienteDev.setRazon_social(rta.getString("razon_social"));						
			ClienteDev.setAlias(rta.getString("alias"));
			ClienteDev.setLocalidad(rta.getString("nombre_localidad"));
			ClienteDev.setZona(rta.getString("descrip_zona"));
						
		}
					rta.close();
					stmt.close();
						
						
						} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
								}
		return ClienteDev;
	}

	
	
}
