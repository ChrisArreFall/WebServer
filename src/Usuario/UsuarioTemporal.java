package Usuario;

public class UsuarioTemporal {
	private String usuario;
	private String contrasena;
	
	
	public UsuarioTemporal(){
		super();
		usuario = null;
		contrasena = null;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
}
