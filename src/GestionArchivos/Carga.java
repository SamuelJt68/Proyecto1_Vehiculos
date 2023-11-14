package GestionArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;

import Interfaz.InterfazEmpresa;
import Logica.Categoria;
import Logica.Cliente;
import Logica.DatosContacto;
import Logica.DatosLicencia;
import Logica.DatosPago;
import Logica.Estado;
import Logica.Rol;
import Logica.Sede;

public class Carga {

	private InterfazEmpresa intEmpresa; 
	
	public Carga(InterfazEmpresa interfazEmpresa) {
		super();
		intEmpresa = interfazEmpresa;
		
	}

	public void cargarClientes()
	{
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(new File("data\\Clientes.csv")));
				String linea = br.readLine();
				while (linea != null)
				{
					String[] partes = linea.split(";");
					String usuario = partes[0];
					String contraseña = partes[1];
					String nombre = partes[2];
					int diaNacimiento = Integer.parseInt(partes[3]);
					int mesNacimiento = Integer.parseInt(partes[4]);
					int anoNacimiento = Integer.parseInt(partes[5]);
					String nacionalidad = partes[6];
					String direccion = partes[7];
					String email = partes[8];
					String telefono = partes[9];
					String licenciaNumero = partes[10];
					String licenciaPais = partes[11];
					int licenciaDia = Integer.parseInt(partes[12]);
					int licenciaMes = Integer.parseInt(partes[13]);
					int licenciaAno = Integer.parseInt(partes[14]);
					String pagoNumero = partes[15];
					String pagoCVV = partes[16];
					String pagoExpiracion = partes[17];
					
					DatosContacto datosContacto = new DatosContacto(telefono, direccion, email);
					DatosLicencia datosLicencia = new DatosLicencia(licenciaNumero, licenciaPais, new Date(licenciaAno, licenciaMes, licenciaDia));
					DatosPago datosPago = new DatosPago(pagoNumero, pagoExpiracion, pagoCVV);
					
					intEmpresa.getEmpresa().nuevoCliente(usuario, contraseña, nombre,new Date(anoNacimiento, mesNacimiento, diaNacimiento) , nacionalidad, null, datosContacto, datosLicencia, datosPago);

					linea = br.readLine();
				}
				br.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("No encontr  el archivo ...");
				e.printStackTrace();
			}
			catch (IOException e)
			{
				System.out.println("Error de lectura ...");
				e.printStackTrace();
			}
			catch (NumberFormatException e)
			{
				System.out.println("Error en los datos: un n mero se pudo convertir a int ...");
				e.printStackTrace();
			}

		
	}
	
	public void cargarSedes()
	{
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(new File("data\\Sedes.csv")));
				String linea = br.readLine();
				while (linea != null)
				{
					String[] partes = linea.split(";");
					String nombre = partes[0];
					String direccion = partes[1];
					String horarios = partes[2];
					
					
					intEmpresa.getEmpresa().getAdministrador().crearSede(nombre, direccion, horarios, null);;

					linea = br.readLine();
				}
				br.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("No encontr  el archivo ...");
				e.printStackTrace();
			}
			catch (IOException e)
			{
				System.out.println("Error de lectura ...");
				e.printStackTrace();
			}
			catch (NumberFormatException e)
			{
				System.out.println("Error en los datos: un n mero se pudo convertir a int ...");
				e.printStackTrace();
			}
	}

	public void cargarAdministrador()
	{
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(new File("data\\Administradores.csv")));
				String linea = br.readLine();
				
				String[] partes = linea.split(";");
				String usuario = partes[0];
				String contraseña = partes[1];
				String nombre = partes[2];
					
				intEmpresa.getEmpresa().setAdministrador(usuario, contraseña, nombre);

				br.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("No encontr  el archivo ...");
				e.printStackTrace();
			}
			catch (IOException e)
			{
				System.out.println("Error de lectura ...");
				e.printStackTrace();
			}
			catch (NumberFormatException e)
			{
				System.out.println("Error en los datos: un n mero se pudo convertir a int ...");
				e.printStackTrace();
			}
	}
	
	public void cargarAdminsLocales()
	{
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(new File("data\\Administradores.csv")));
				String linea = br.readLine();
				linea = br.readLine();
				while (linea != null)
				{
					String[] partes = linea.split(";");
					String usuario = partes[0];
					String contraseña = partes[1];
					String nombre = partes[2];
					String sede = partes[3];
					
//					Sede tSede = null;
//					boolean encontroSede = true;
//					for (int i=0 ; (i<intEmpresa.getEmpresa().getSedes().size())&&encontroSede; i++ ) {
//						if (sede.equals(intEmpresa.getEmpresa().getSedes().get(i).getNombre())) {
//							tSede = intEmpresa.getEmpresa().getSedes().get(i);
//							encontroSede = false;
//						}
//					}
					
					int k = 1000000000;
					boolean encontroSede = true;
					for (int i=0 ; (i<intEmpresa.getEmpresa().getSedes().size())&&encontroSede; i++ ) {
						if (sede.equals(intEmpresa.getEmpresa().getSedes().get(i).getNombre())) {
							k =i;
							encontroSede = false;
						}
					}
					
					intEmpresa.getEmpresa().getAdministrador().asignarAdminLocal(usuario, contraseña, nombre, intEmpresa.getEmpresa().getSedes().get(k));
					linea = br.readLine();
				}
				br.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("No encontr  el archivo ...");
				e.printStackTrace();
			}
			catch (IOException e)
			{
				System.out.println("Error de lectura ...");
				e.printStackTrace();
			}
			catch (NumberFormatException e)
			{
				System.out.println("Error en los datos: un n mero se pudo convertir a int ...");
				e.printStackTrace();
			}
	}
	
	public void cargarCategorias()
	{
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(new File("data\\Categorias.csv")));
				String linea = br.readLine();
				while (linea != null)
				{
					String[] partes = linea.split(";");
					String nombre = partes[0];
					String gamma = partes[1];
					double tarifaAlta = Double.parseDouble(partes[2]);
					double tarifaBaja = Double.parseDouble(partes[3]);
					double extraSede = Double.parseDouble(partes[4]);
					double extraConductor = Double.parseDouble(partes[5]);
					
					intEmpresa.getEmpresa().getAdministrador().crearCategoria(nombre, gamma, tarifaAlta, tarifaBaja, extraSede, extraConductor);

					linea = br.readLine();
				}
				br.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("No encontr  el archivo ...");
				e.printStackTrace();
			}
			catch (IOException e)
			{
				System.out.println("Error de lectura ...");
				e.printStackTrace();
			}
			catch (NumberFormatException e)
			{
				System.out.println("Error en los datos: un n mero se pudo convertir a int ...");
				e.printStackTrace();
			}

		
	}

	public void cargarVehiculos()
	{
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(new File("data\\Vehiculos.csv")));
				String linea = br.readLine();
				while (linea != null)
				{
					
					String[] partes = linea.split(";");
					String placa = partes[0];
					String marca = partes[1];
					String modelo = partes[2];
					String color = partes[3];
					int capacidad = Integer.parseInt(partes[4]);
					String tipoTransmision = partes[5];
					String categoria = partes[6];

					Categoria tCat = null;
					boolean encontroCategoria = true;
					for (int i=0 ; (i<intEmpresa.getEmpresa().getCategorias().size())&&encontroCategoria; i++ ) {
						if (categoria.equals(intEmpresa.getEmpresa().getCategorias().get(i).getNombre())) {
							tCat = intEmpresa.getEmpresa().getCategorias().get(i);
							encontroCategoria = false;
						}
					}
					
					intEmpresa.getEmpresa().getAdministrador().crearVehiculo(placa, marca, modelo, color, tipoTransmision, capacidad, tCat);

					linea = br.readLine();
				}
				br.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("No encontr  el archivo ...");
				e.printStackTrace();
			}
			catch (IOException e)
			{
				System.out.println("Error de lectura ...");
				e.printStackTrace();
			}
			catch (NumberFormatException e)
			{
				System.out.println("Error en los datos: un n mero se pudo convertir a int ...");
				e.printStackTrace();
			}

		
	}

	public void cargarEmpleados()
	{
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(new File("data\\Empleados.csv")));
				String linea = br.readLine();
				while (linea != null)
				{
					String[] partes = linea.split(";");
					String usuario = partes[0];
					String contraseña = partes[1];
					String nombre = partes[2];
					String rol = partes[3];
					String sede = partes[4];
										
					Rol tRol = null;
					if (rol.equals(Rol.ATENCION)) {
						tRol = Rol .ATENCION;
					}
					if (rol.equals(Rol.LIMPEZA)) {
						tRol = Rol .LIMPEZA;
					}
					if (rol.equals(Rol.MANTENIMIENTO)) {
						tRol = Rol .MANTENIMIENTO;
					}
					
					int k = 1000000000;
					boolean encontroSede = true;
					for (int i=0 ; (i<intEmpresa.getEmpresa().getSedes().size())&&encontroSede; i++ ) {
						if (sede.equals(intEmpresa.getEmpresa().getSedes().get(i).getNombre())) {
							k =i;
							encontroSede = false;
						}
					}
					intEmpresa.getEmpresa().getSedes().get(k).getAdmin().crearEmpleado(usuario, contraseña, nombre, tRol, intEmpresa.getEmpresa().getSedes().get(k));

					linea = br.readLine();
				}
				br.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("No encontr  el archivo ...");
				e.printStackTrace();
			}
			catch (IOException e)
			{
				System.out.println("Error de lectura ...");
				e.printStackTrace();
			}
			catch (NumberFormatException e)
			{
				System.out.println("Error en los datos: un n mero se pudo convertir a int ...");
				e.printStackTrace();
			}

		
	}
}
