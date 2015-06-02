package datos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import modelos.Articulo;

public class CatalogoArticulo {

	public int AddArticulo(Articulo Articulo)
	{
		try{
			//Agrega un articulo a la Tabla Articulos
		String SQLCons= "INSERT INTO Articulos (cod_articulo,descrip_articulo, stock)"+ " VALUES (?,?,?)" ;/* +pDescripcion+","+ pColor +","+ pConsumo + "," + pPeso+ "," + pPrecio; */
	ConexionBD conecta = new ConexionBD();
	conecta.OpenConection();
	PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
	stmt.setInt(1,Articulo.getCodigo_articulo());
	stmt.setString(2, Articulo.getDescripcionArticulo());
	stmt.setFloat(3, Articulo.getStock());
	stmt.execute();
	conecta.CloseConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
									}
			return Statement.RETURN_GENERATED_KEYS;

	
	


	}
		
	
}
