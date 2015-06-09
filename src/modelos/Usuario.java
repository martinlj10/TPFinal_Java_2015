package modelos;

public class Usuario {

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getCod_rol() {
		return cod_rol;
	}

	public void setCod_rol(int cod_rol) {
		this.cod_rol = cod_rol;
	}

	public String getDescrip_rol() {
		return descrip_rol;
	}

	public void setDescrip_rol(String descrip_rol) {
		this.descrip_rol = descrip_rol;
	}

	private String username;
	
	private int cod_rol;

	private String password;
	
	private String descrip_rol;
}
