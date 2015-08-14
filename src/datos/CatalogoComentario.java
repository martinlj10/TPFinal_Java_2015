package datos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelos.Comentario;

public class CatalogoComentario {
	private final static String CAMPOS = " cod_auto, cod_auto, fecha_public, comentario";
	public static int AddComentario(Comentario newComentario)
	{
		try{
			//Agrega un comentario a la Tabla Comentarios 
		String SQLCons= "INSERT INTO comentario ("+CAMPOS+")"+ " VALUES (?,?,?,?)";
	ConexionBD conecta = new ConexionBD();
	conecta.OpenConection();
	PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
	stmt.setInt(1,newComentario.getCod_auto());
	stmt.setInt(2, newComentario.getCod_auto());
	stmt.setDate(3, newComentario.getFecha_public());
	stmt.setString(4, newComentario.getComentario());
	
	stmt.execute();
	
	conecta.CloseConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
									}
			return Statement.RETURN_GENERATED_KEYS;
	}
	public static void DeleteComentario(int pCod_Auto, int pCod_Usuario, Date pFecha_public)
	{
		String SQLCons= "DELETE FROM comentario where (?= cod_cliente AND ?=cod_usuario AND ?=fecha_public)";
		try {
			ConexionBD conecta = new ConexionBD();
			conecta.OpenConection();
			PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
			stmt.setInt(1, pCod_Auto);
			stmt.setInt(1, pCod_Usuario);
			stmt.setDate(1, pFecha_public);
			int rta = stmt.executeUpdate();
			
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
	public static int UpdateComentario (Comentario ComentarioUPD)
	{
		String SQLCons= "UPDATE Comentario SET comentario=? WHERE (?=cod_auto AND ?= cod_usuario, ?=fecha_public)";
		try{
			
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setString(1, ComentarioUPD.getComentario());
		stmt.setInt(2, ComentarioUPD.getCod_auto());
		stmt.setInt(3, ComentarioUPD.getCod_usuario());
		stmt.setDate(4, ComentarioUPD.getFecha_public());
		
		int rta = stmt.executeUpdate();
		}		
				 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return Statement.RETURN_GENERATED_KEYS;
	}


	public static ArrayList<Comentario> GetAll(int pCodAuto)
	{//Devuelve todos los comentarios sobre un Auto en particular
	ArrayList<Comentario> ComentariosAll = new ArrayList<Comentario>();
		
		try {
			String SQLCons= "Select "+CAMPOS+" FROM Comentario WHERE cod_usuario = ? ORDER BY fecha_public";
			ConexionBD conecta = new ConexionBD();
			conecta.OpenConection();
			PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
			stmt.setInt(1, pCodAuto);
			ResultSet rta = stmt.executeQuery();
			 	while(rta.next())
						{		Comentario comentarioDev = new Comentario();
					 			comentarioDev.setCod_auto(rta.getInt("cod_auto"));
								comentarioDev.setCod_usuario(rta.getInt("cod_usuario"));						
								comentarioDev.setFecha_public(rta.getDate("fecha_public"));
								comentarioDev.setComentario(rta.getString("comentario"));
								ComentariosAll.add(comentarioDev);
								
				}
		}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return ComentariosAll;
	}

	
	
}
