package Logica;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

public class Empresa extends Cargar_Sede{

	private Administrador administrador;
	//	private ArrayList<Reserva> reservas;
    private ArrayList<Sede> sedes;
    private ArrayList<Categoria> categorias;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Seguro> seguros;

    public Empresa() {
        sedes = new ArrayList<Sede>();
        categorias = new ArrayList<Categoria>();
        vehiculos = new ArrayList<Vehiculo>();
        clientes = new ArrayList<Cliente>();
    }

    public void agregarSede(Sede sede) {
    	sedes.add(sede);
	}
    
    public ArrayList<Sede> getSedes() {
		return sedes;
	}
    
	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(String usuario, String contraseña, String nombre) {
		
		this.administrador = new Administrador(usuario,contraseña,nombre,this);
	}

	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}
	
	public void agregarCategoria(Categoria categoria) {
    	categorias.add(categoria);
	}
		
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	
	public void agregarVehiculo(Vehiculo vehiculo) {
		vehiculos.add(vehiculo);
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	public void nuevoCliente(String usuario, String contraseña, String nombre, Date fechaNacimiento, String nacionalidad,
			File imagenID, DatosContacto datosContacto, DatosLicencia datosLicencia, DatosPago datosPago) {
		Cliente nuevoCliente = new Cliente(usuario, contraseña, nombre, fechaNacimiento, nacionalidad, imagenID, datosContacto, datosLicencia, datosPago);
		clientes.add(nuevoCliente);
	}
	
	public ArrayList<Seguro> getSeguros(){
		return seguros;
	}
	
	public void agregarSeguro(Seguro seguro) {
		seguros.add(seguro);
	}
	
	public void cargarDatosVehiculos(String placa, String marca, String modelo, String color, String tipoTransmision, int capacidad, Categoria categoria, Estado estadoActual, String sede) {
        String directoryName = "data";
        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdir();
        }
        String csvFile = directoryName + File.separator + "vehiculos.csv";
        try {
            FileWriter writer = new FileWriter(csvFile, true);
            writer.append(placa);
            writer.append(",");
            writer.append(marca);
            writer.append(",");
            writer.append(modelo);
            writer.append(",");
            writer.append(color);
            writer.append(",");
            writer.append(tipoTransmision);
            writer.append(",");
            writer.append(String.valueOf(capacidad));
            writer.append(",");
            writer.append(categoria.toString());
            writer.append(",");
            writer.append(estadoActual.toString());
            writer.append(",");
            writer.append(sede);
            writer.append("\n");

            writer.flush();
            writer.close();
            System.out.println("Se agregaron los datos del vehículo al archivo CSV.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }
	
}
