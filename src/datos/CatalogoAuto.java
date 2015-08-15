package datos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import modelos.Auto;

public class CatalogoAuto {

	private final static String CAMPOS = " cod_auto, descripcion, precio_sug, valoracion, nombre_auto, cod_marca, ano_fabric";
	public static int AddAuto(Auto Auto)
	{ //se cargan los autos
		try{
			
			String SQLCons= "INSERT INTO Auto ("+CAMPOS+") VALUES (?,?,?,?,?,?,?)"; 
	ConexionBD conecta = new ConexionBD();
	conecta.OpenConection();
	PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
	stmt.setInt(1,Auto.getCod_auto());
	stmt.setString(2, Auto.getDescripcionAuto());
	stmt.setFloat(3, Auto.getPrecio());
	stmt.setInt(4, Auto.getValoracion());
	stmt.setString(5, Auto.getNombre_auto());
	stmt.setInt(6, Auto.getCod_marca());
	stmt.setInt(7, Auto.getAnoFabricacion());
	
	stmt.execute();
	
	conecta.CloseConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
									}
			return Statement.RETURN_GENERATED_KEYS;
	}
	public static void DeleteAuto(int pCod_Auto)
	{
		String SQLCons= "DELETE FROM Auto where ? = cod_auto";
		try {
			ConexionBD conecta = new ConexionBD();
			conecta.OpenConection();
			PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
			stmt.setInt(1, pCod_Auto);
			int rta = stmt.executeUpdate();
			
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
	public static int UpdateAuto (Auto AutoUPD)
	{
		String SQLCons= "UPDATE Auto SET descripcion=? , precio_sug=?, valoracion=?, nombre_auto=?, cod_marca=?, ano_fabric=? WHERE ?=cod_auto ";
		try{
			
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setString(1, AutoUPD.getDescripcionAuto());
		stmt.setFloat(2, AutoUPD.getPrecio());
		stmt.setInt(3, AutoUPD.getValoracion());
		stmt.setString(4, AutoUPD.getNombre_auto());
		stmt.setInt(5, AutoUPD.getCod_marca());
		stmt.setInt(6, AutoUPD.getAnoFabricacion());
		stmt.setInt(7, AutoUPD.getCod_auto());
		
		int rta = stmt.executeUpdate();
		}		
				 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return Statement.RETURN_GENERATED_KEYS;
	}


	public static ArrayList<Auto> GetAll()
	{
	ArrayList<Auto> AutosAll = new ArrayList<Auto>();
		
		try {
			String SQLCons= "Select "+CAMPOS+" FROM Auto";
			ConexionBD conecta = new ConexionBD();
			conecta.OpenConection();
			PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
			ResultSet rta = stmt.executeQuery();
			 	while(rta.next())
						{		Auto AutoDev = new Auto();
					 			AutoDev.setDescripcionAuto(rta.getString("descripcion"));
					 			AutoDev.setCod_auto(rta.getInt("cod_auto"));
								AutoDev.setPrecio(rta.getFloat("precio_sug"));						
								AutoDev.setValoracion(rta.getInt("valoracion"));
								AutoDev.setNombre_auto(rta.getString("nombre_auto"));
								AutoDev.setCod_marca(rta.getInt("cod_marca"));
								AutoDev.setAnoFabricacion(rta.getInt("ano_fabric"));
								
								AutosAll.add(AutoDev);
								
				}
		}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return AutosAll;
	}

	public static Auto GetOne(int pId)
	{
		
		Auto AutoDev = new Auto();
		try{
			
		 
		
		String SQLCons= "SELECT "+CAMPOS+" FROM Auto WHERE cod_auto=?";
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setInt(1, pId);		
		ResultSet rta = stmt.executeQuery();
		while(rta.next())
		{
					AutoDev.setDescripcionAuto(rta.getString("descripcion"));
		 			AutoDev.setCod_auto(rta.getInt("cod_auto"));
					AutoDev.setPrecio(rta.getFloat("precio_sug"));						
					AutoDev.setValoracion(rta.getInt("valoracion"));
					AutoDev.setNombre_auto(rta.getString("nombre_auto"));
					AutoDev.setCod_marca(rta.getInt("cod_marca"));
					AutoDev.setAnoFabricacion(rta.getInt("ano_fabric"));
		}
					rta.close();
					stmt.close();
						
						
						} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
								}
		return AutoDev;
	}
	
	public static int ActualizaValoracion(int pIdCod_Auto, int pValoracion)
	{
		String SQLCons= "UPDATE auto SET valoracion=?  WHERE ?=cod_auto ";
		try{
			
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setFloat(1, pValoracion);
		stmt.setInt(2, pIdCod_Auto);
		int rta = stmt.executeUpdate();
		}		
				 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return Statement.RETURN_GENERATED_KEYS;
	}
		
	}
	
	

