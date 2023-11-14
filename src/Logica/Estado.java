//import java.sql.Date;
package Logica;

import java.sql.Date;

public abstract class Estado {

	private Date fecha;
	private Sede sede;

	public Estado(Sede sede, Date fecha) {
		super();
		this.sede = sede;
		this.fecha = fecha;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
