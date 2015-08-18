package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.Usuario;

public class CatalogoUsuarios {




	public static Usuario GetOne(String pUsername)
	{
		
		Usuario userBD = new Usuario();
		try{
			
		 
		String SQLCons= "SELECT * FROM usuarios WHERE username='?' ";
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setString(1, pUsername);
		ResultSet rta = stmt.executeQuery();
		while(rta.next())
		{
						
						userBD.setUsername(rta.getString("username"));
						userBD.setPassword(rta.getString("password"));
		}
					rta.close();
					stmt.close();
						
						
						} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
								}
		return userBD;
	}


}


