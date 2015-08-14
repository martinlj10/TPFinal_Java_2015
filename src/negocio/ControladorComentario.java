package negocio;
import java.util.ArrayList;

import modelos.*;
import datos.*;

import java.sql.*;


public class ControladorComentario {

	//private CatalogoComentario catCliente = new CatalogoComentario();
	
	public int AddComentario(Comentario nuevoComentario)
	{
		//Validaciones de Negocio
		
		int idComentarioNuevo = CatalogoComentario.AddComentario(nuevoComentario);
		
		return idComentarioNuevo;
	}

	public void DeleteComentario(int pCod_Auto, int pCod_Usuario, Date pFecha_Public)
	{
		
		CatalogoComentario.DeleteComentario(pCod_Auto, pCod_Usuario, pFecha_Public);
		
	}

	public static ArrayList<Comentario> getAll(int pCod_Auto)
	{
		ArrayList<Comentario> ComentariosAll = new ArrayList<Comentario>();
		ComentariosAll = CatalogoComentario.GetAll(pCod_Auto);/*Obtiene los Comentarios a devolver por Claves*/
		
		return ComentariosAll;
	}
	
	public int UpdateComentario(int pCod_Auto, int pCod_Usuario, Date pFecha_Public, String pComentario)
	{
		int rowAffect;
		Comentario modifComentario = new Comentario();
		modifComentario.setCod_auto(pCod_Auto);
		modifComentario.setCod_usuario(pCod_Usuario);
		modifComentario.setFecha_public(pFecha_Public);
		modifComentario.setComentario(pComentario);
		rowAffect = CatalogoComentario.UpdateComentario(modifComentario);
		return rowAffect;/*Devuelve la cantidad de filas afectadas por el update*/
		
	}
	
		
	
}
