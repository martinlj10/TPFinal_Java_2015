package datos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import modelos.Articulo;

public class CatalogoArticulo {

	public int AddArticulo(Articulo Articulo)
	{ //se cargan los articulos
		try{
			//Agrega un articulo a la Tabla Articulos y tambien agrega el precio del articulo con la fecha de vigencia en la tabla Precios_Articulos
		String SQLCons= "INSERT INTO Articulos (cod_articulo,descrip_articulo, stock)"+ " VALUES (?,?,?); INSERT INTO precio_articulos (id_articulo,fecha_vigencia, valor)"+ " VALUES (?,?,?)" ;
	ConexionBD conecta = new ConexionBD();
	conecta.OpenConection();
	PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
	stmt.setInt(1,Articulo.getCodigo_articulo());
	stmt.setString(2, Articulo.getDescripcionArticulo());
	stmt.setFloat(3, Articulo.getStock());
	stmt.setInt(4, Articulo.getCodigo_articulo());
	stmt.setDate(5, Articulo.getFechaDesde_precio());
	stmt.setFloat(6, Articulo.getPrecio());
	
	stmt.execute();
	
	conecta.CloseConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
									}
			return Statement.RETURN_GENERATED_KEYS;
	}
	public void DeleteArticulo(int pCod_arti)
	{
		String SQLCons= "DELETE FROM Articulos where ?= cod_articulo";
		try {
			ConexionBD conecta = new ConexionBD();
			conecta.OpenConection();
			PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
			stmt.setInt(1, pCod_arti);
			int rta = stmt.executeUpdate();
			
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
	public int UpdateElect (Articulo ArticuloUPD)
	{
		String SQLCons= "UPDATE Articulos SET descrip_articulo=? , stock=? WHERE ?=cod_articulo ; UPDATE precio_articulos SET fecha_vigencia=? , valor=? WHERE ?=cod_articulo";
		try{
			
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setString(1, ArticuloUPD.getDescripcionArticulo());
		stmt.setInt(2, ArticuloUPD.getStock());
		stmt.setInt(3, ArticuloUPD.getCodigo_articulo());
		stmt.setDate(4, ArticuloUPD.getFechaDesde_precio());
		stmt.setFloat(5, ArticuloUPD.getPrecio());
		stmt.setInt(6, ArticuloUPD.getCodigo_articulo());
		int rta = stmt.executeUpdate();
		}		
				 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return Statement.RETURN_GENERATED_KEYS;
	}


	public ArrayList<Articulo> GetAll()
	{
	ArrayList<Articulo> ArticulosAll = new ArrayList<Articulo>();
		
		try {
			String SQLCons= "Select cod_articulo, descrip_articulo, stock, fecha_vigencia, valor FROM Articulos INNER JOIN Precio_Articulos ON cod_articulo = id_articulo ORDER BY descrip_articulo";
			ConexionBD conecta = new ConexionBD();
			conecta.OpenConection();
			PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
			ResultSet rta = stmt.executeQuery();
			 	while(rta.next())
						{		Articulo ArticuloDev = new Articulo();
					 			ArticuloDev.setDescripcionArticulo(rta.getString("descrip_articulo"));
								ArticuloDev.setStock(rta.getInt("stock"));						
								ArticuloDev.setFechaDesde_precio(rta.getDate("fecha_vigencia"));
								ArticuloDev.setPrecio(rta.getFloat("precio")); 
								ArticulosAll.add(ArticuloDev);
								
				}
		}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return ArticulosAll;
	}



	public Articulo GetOne(int pId)
	{
		
		Articulo ArticuloDev = new Articulo();
		try{
			
		 
		
		String SQLCons= "SELECT * FROM Articulos INNER JOIN Precio_articulos ON cod_articulo=id_articulo WHERE Articulos.cod_articulo=?";
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setInt(1, pId);		
		ResultSet rta = stmt.executeQuery();
		while(rta.next())
		{
						ArticuloDev.setDescripcionArticulo(rta.getString("descrip_articulo"));
					    ArticuloDev.setStock(rta.getInt("stock"));
						ArticuloDev.setFechaDesde_precio(rta.getDate("fecha_vigencia"));
						ArticuloDev.setCodigo_articulo(rta.getInt("id_articulo"));
						ArticuloDev.setPrecio(rta.getFloat("valor"));
						
		}
					rta.close();
					stmt.close();
						
						
						} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
								}
		return ArticuloDev;
	}
	
	
	
	
}
