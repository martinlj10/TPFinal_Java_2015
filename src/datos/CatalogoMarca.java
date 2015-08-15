package datos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import modelos.Marca;

public class CatalogoMarca {

	private final static String CAMPOS = " cod_marca, descrip_marca";
	public static int AddMarca(Marca Marca)
	{ //se cargan los autos
		try{
			
			//Agrega una marca a la Tabla Marca 
		String SQLCons= "INSERT INTO Marca ("+CAMPOS+") VALUES (?,?)"; 
	ConexionBD conecta = new ConexionBD();
	conecta.OpenConection();
	PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
	stmt.setInt(1,Marca.getCod_marca());
	stmt.setString(2, Marca.getDescrip_marca());
	
	stmt.execute();
	
	conecta.CloseConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
									}
			return Statement.RETURN_GENERATED_KEYS;
	}
	public static void DeleteMarca(int pCod_Marca)
	{
		String SQLCons= "DELETE FROM Marca where ? = cod_marca";
		try {
			ConexionBD conecta = new ConexionBD();
			conecta.OpenConection();
			PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
			stmt.setInt(1, pCod_Marca);
			int rta = stmt.executeUpdate();
			
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
	public static int UpdateMarca (Marca MarcaUPD)
	{
		String SQLCons= "UPDATE Marca SET descrip_marca=? WHERE ?=cod_marca ";
		try{
			
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setString(1, MarcaUPD.getDescrip_marca());
		stmt.setInt(2, MarcaUPD.getCod_marca());
		
		int rta = stmt.executeUpdate();
		}		
				 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return Statement.RETURN_GENERATED_KEYS;
	}


	public static ArrayList<Marca> GetAll()
	{
	ArrayList<Marca> MarcasAll = new ArrayList<Marca>();
		
		try {
			String SQLCons= "Select "+CAMPOS+" FROM Marca";
			ConexionBD conecta = new ConexionBD();
			conecta.OpenConection();
			PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
			ResultSet rta = stmt.executeQuery();
			 	while(rta.next())
						{		Marca MarcaDev = new Marca();
					 			MarcaDev.setCod_marca(rta.getInt("cod_marca"));
					 			MarcaDev.setDescrip_marca(rta.getString("descrip_marca"));
								
								MarcasAll.add(MarcaDev);
								
				}
		}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return MarcasAll;
	}

	public static Marca GetOne(int pId)
	{
		
		Marca MarcaDev = new Marca();
		try{
			
		
		String SQLCons= "SELECT "+CAMPOS+" FROM Marca WHERE cod_marca=?";
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setInt(1, pId);		
		ResultSet rta = stmt.executeQuery();
		while(rta.next())
		{
					MarcaDev.setDescrip_marca(rta.getString("descrip_marca"));
		 			MarcaDev.setCod_marca(rta.getInt("cod_marca"));
					
					rta.close();
					stmt.close();
						
						
			}} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
								}
		return MarcaDev;
	}
	
	}
