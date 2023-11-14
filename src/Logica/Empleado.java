package Logica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Empleado extends Usuario {
	
	private String usuario;
	private String contraseña;
	private String nombre;
	private Rol rol;
	private static Empresa empresa;
	private Sede sede;

	public Empleado(String usuario, String contraseña, String nombre, Rol rol, Sede sede) {
		super(usuario, contraseña, nombre);
		this.rol = rol;
		this.sede = sede;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public void confirmarReserva(Reserva reserva, Vehiculo vehiculo, Seguro seguro, ArrayList<Conductor> conductores) {

		Alquiler nuevoAlquiler = new Alquiler(reserva.getCliente(),reserva.getSedeRecogida() , reserva.getFechaEntrega(), reserva.getSedeEntrega(), vehiculo, seguro, conductores, reserva.getFechaRecogida());
		vehiculo.setEstadoActual(nuevoAlquiler);
		nuevoAlquiler.getCliente().agregarAlquiler(nuevoAlquiler);
		nuevoAlquiler.getCliente().eliminarReserva(reserva);
		nuevoAlquiler.getSede().eliminarReservaPendiente(reserva);
	}
	
}
