package Logica;

import java.sql.Date;

public class Mantenimiento extends Estado {

	private String taller;
	private String descripcion;
	private Empleado reportador;
	
	public Mantenimiento(Sede sede, Date fecha,String taller, String descripcion, Empleado reportador) {
		super(sede, fecha);
		this.taller = taller;
		this.descripcion = descripcion;
		this.reportador = reportador;
	}

	public String getTaller() {
		return taller;
	}

	public void setTaller(String taller) {
		this.taller = taller;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Empleado getReportador() {
		return reportador;
	}

	public void setReportador(Empleado reportador) {
		this.reportador = reportador;
	}
	
}
