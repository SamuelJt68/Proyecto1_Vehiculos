package Logica;

public class AdminLocal extends Empleado{

	private String usuario;
	private String contraseña;
	private String nombre;
	private Sede sede;
	
	public AdminLocal(String usuario, String contraseña, String nombre, Sede sede) {
		super(usuario, contraseña, nombre, Rol.ADMINISTRADORLOCAL, sede);
	}	
	
	public void crearEmpleado(String usuario, String contraseña, String nombre, Rol rol, Sede sede) {
		Empleado nuevoEmpleado = new Empleado(usuario,contraseña,nombre,rol,sede);
		sede.añadirEmpleado(nuevoEmpleado);
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}
	
}
