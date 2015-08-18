package negocio;

import java.util.ArrayList;

import javax.swing.JOptionPane; 

import datos.CatalogoUsuarios;
import modelos.Usuario;

public class ControladorUsuario {
	

datos.CatalogoUsuarios catUsuarios;
Usuario user = new Usuario();	


public ControladorUsuario(){
 
 catUsuarios =new datos.CatalogoUsuarios();

}


public Usuario getUsuario(String pUsername)
{
	
	user =CatalogoUsuarios.GetOne(pUsername);
	
	return(user);	
	
	}
	



public boolean validarUsuario(String pUsername, String pPassword)
{
	
	user = this.getUsuario(pUsername);
	if((user.getUsername()==pUsername)&& (user.getPassword()==pPassword))
	{
		return true;
	}
	else
	{
		return false;
	}
}
}


