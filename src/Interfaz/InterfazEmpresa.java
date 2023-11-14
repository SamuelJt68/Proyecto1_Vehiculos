package Interfaz;

import javax.swing.*;

import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.imageio.ImageIO;

import GestionArchivos.Carga;
import GestionArchivos.Escritura;
import Logica.DatosContacto;
import Logica.DatosLicencia;
import Logica.DatosPago;
import Logica.Empresa;
import Logica.Sede;

class BotonRedondeado extends JButton{

	public BotonRedondeado(String texto) {
        super(texto);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(true);
        setBackground(new Color(255, 0, 0)); 
        setForeground(Color.white);
        setBorderPainted(false);
        setFont(new Font("Arial", Font.PLAIN, 18));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setPreferredSize(new Dimension(150, 50));
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(new Color(220, 0, 0)); 
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
        super.paintComponent(g);
    }

	
}

public class InterfazEmpresa extends JFrame implements ActionListener{
	
	private JPanel contenPanel; 
	private VistaMenuInicial vistaMenuInicial;
	private VistaInicioSesion vistaInicioSesion;
	private VistaInicioSesionCliente vistaInicioSesionCliente;
	private VistaMenuEmpleado vistaMenuEmpleado;
	private VistaNuevaCuenta vistaNuevaCuenta;
	private VistaMenuCliente vistaMenuCliente;
	private VistaNuevaReserva vistaNuevaReserva;
	private VistaHistorial vistaHistorial;
	private VistaDispo vistaDispo;
	private VistaRealizarPago vistaRealizarPago;
	private VistaAdmiLocal vistaAdmiLocal;
	private VistaCrearCategoria vistaCrearCategoria;
	private VistaModCategoria vistaModCategoria;
	private VistaCrearEmpleado vistaCrearEmpleado;
	private VistaModificarEmpleado vistaModificarEmpleado;
	private VistaCrearSede vistaCrearSede;
	private VistaModSede vistaModSede;
	private VistaCrearVehiculo vistaCrearVehiculo;
	private VistaModVehiculo vistaModVehiculo;
	private VistaMenuAdmi vistaMenuAdmi;
	private VistaCrearSeguro vistaCrearSeguro;
	private VistaModSeguro vistaModSeguro;
	private Image imagen;
	private JPanel interfaz;
	
	private Empresa empresa;
	private Escritura escritura;
	private Carga carga;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String grito = e.getActionCommand();
			
		if (grito.equals("Empleado")) {
			//InicioEmpleado();	
		}
		else if (grito.equals("Cliente")) {
			InicioCliente();
		}
			
	}
	
	
	public InterfazEmpresa(){
		
		empresa = new Empresa();
		escritura = new Escritura();
		carga = new Carga(this);
//		carga.cargarClientes();
//		carga.cargarAdministrador();
//		carga.cargarSedes();
//		carga.cargarAdminsLocales();
//		carga.cargarCategorias();
//		carga.cargarVehiculos();
//		carga.cargarEmpleados();
//		empresa.getSedes().get(0).getEmpleados().get(0).setNombre("Manolo");
//		try {
//			escritura.escribirClientes(empresa.getClientes());
//			escritura.escribirSedes(empresa.getSedes());
//			escritura.escribirAdministradores(empresa.getSedes(), empresa.getAdministrador());
//			escritura.escribirCategorias(empresa.getCategorias());
//			escritura.escribirVehiculos(empresa.getVehiculos());
//			escritura.escribirEmpleados(empresa.getSedes());
//		} catch (FileNotFoundException | UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}

		vistaInicioSesion = new VistaInicioSesion(this);
		vistaInicioSesionCliente = new VistaInicioSesionCliente(this);
		vistaMenuEmpleado = new VistaMenuEmpleado(this);
		vistaNuevaCuenta = new VistaNuevaCuenta(this);
		vistaMenuCliente = new VistaMenuCliente(this);
		vistaMenuInicial = new VistaMenuInicial(this);
		vistaNuevaReserva = new VistaNuevaReserva(this);
		vistaHistorial = new VistaHistorial(this);
		vistaDispo = new VistaDispo(this);
		vistaRealizarPago = new VistaRealizarPago(this);
		vistaAdmiLocal = new VistaAdmiLocal(this);
		vistaCrearCategoria = new VistaCrearCategoria(this);
		vistaModCategoria = new VistaModCategoria(this);
		vistaAdmiLocal = new VistaAdmiLocal(this) ;
		vistaCrearCategoria = new VistaCrearCategoria(this) ;
		vistaModCategoria = new VistaModCategoria(this) ;
		vistaCrearEmpleado = new VistaCrearEmpleado(this) ;
		vistaModificarEmpleado = new VistaModificarEmpleado(this) ;
		vistaCrearSede = new VistaCrearSede(this) ;
		vistaModSede = new VistaModSede(this) ;
		vistaCrearVehiculo = new VistaCrearVehiculo(this) ;
		vistaModVehiculo = new VistaModVehiculo(this) ;
		vistaMenuAdmi = new VistaMenuAdmi(this) ;
		
		contenPanel = new JPanel();
		contenPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenPanel);
		contenPanel.setLayout(new CardLayout(0,0));
		setResizable(false);
		
		
		try {
			 
	           URL url = new URL("https://media.istockphoto.com/id/1273534607/es/vector/icono-del-coche-veh%C3%ADculo-autom%C3%A1tico-aislado-iconos-de-transporte-vista-frontal-de-silueta-de.jpg?s=612x612&w=0&k=20&c=5nvfZY_GALFA9V_n4oi3mauLQfdfaxB-QR2TQ30XJOE="); 
	           imagen = ImageIO.read(url);
	            
	        } catch (Exception e) {
	        	
	            e.printStackTrace();
	            
	        }
		
		setLayout(new BorderLayout());
		 
		JPanel panelDerecho = new JPanel(new BorderLayout());
		panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));
		
		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));

		BotonRedondeado botonCliente = new BotonRedondeado("Cliente");
		botonCliente.setActionCommand("Cliente");
		botonCliente.addActionListener(this);
        BotonRedondeado botonEmpleado = new BotonRedondeado("Empleado");
		botonEmpleado.addActionListener(this);

       
        panelBotones.add(botonCliente);
        panelBotones.add(Box.createRigidArea(new Dimension(20, 0))); 
        panelBotones.add(new JLabel());
        panelBotones.add(botonEmpleado);

        
        JLabel etiquetaBienvenido = new JLabel("Bienvenido");
        etiquetaBienvenido.setFont(new Font("Arial", Font.BOLD, 24));
       
        
        
        panelDerecho.add(Box.createVerticalGlue());
        panelDerecho.add(etiquetaBienvenido);
        panelDerecho.add(Box.createVerticalStrut(20)); 
        panelDerecho.add(panelBotones);
        panelDerecho.add(Box.createVerticalGlue());
        
        JPanel panelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.4;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panelCentral.add(panelDerecho, gbc);
        
        add(panelCentral, BorderLayout.EAST);

 
     
				
		setSize(1000, 700);
				
		setTitle("Empresa Vehiculos");
				
		setVisible(true);
		
		setLocationRelativeTo(null); 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
    @Override
    public void paint(Graphics g) {
    	
        super.paint(g);


        var contentPane = getContentPane();

     
        int anchoFondo = (int) (contentPane.getWidth() * 0.6);
        int alturaFondo = (int) (contentPane.getHeight());

        
        g.setColor(Color.RED);
        g.fillRect(0, 0, anchoFondo, alturaFondo);
        
        if (imagen != null) {
        	
            int xImagen = anchoFondo / 2 - imagen.getWidth(this) / 2;
            int yImagen = alturaFondo / 2 - imagen.getHeight(this) / 2;
            g.drawImage(imagen, xImagen, yImagen, this);
            
        }
        
    }


	
	/// Vistas
	
	public void nuevoPanel(JPanel vistaNueva) {
		this.interfaz = vistaNueva;
		contenPanel.removeAll();
		contenPanel.add(vistaNueva);
		contenPanel.repaint();
		contenPanel.revalidate();
	}
	
	public void InicioCliente() {
		nuevoPanel((JPanel) vistaInicioSesionCliente.getContentPane());
	}
	
	public void InicioEmpleado() {
		nuevoPanel(vistaInicioSesion);
	}
	
	public void nuevaCuenta() {
		nuevoPanel(vistaNuevaCuenta);
	}
	
	public void menuEmpleado() {
		nuevoPanel(vistaMenuEmpleado);
	}
	
	public void menuCliente() {
		nuevoPanel(vistaMenuCliente);
	}
	
	public void InterfazCerrar() {
		nuevoPanel((JPanel)vistaMenuInicial.getContentPane());
		
	}
	
	public void vistaNuevaReserva() {
		nuevoPanel(vistaNuevaReserva);
		
	}
	
	public void vistaHistorial() {
		nuevoPanel(vistaHistorial);
	}
	
	public void vistaDispo() {
		nuevoPanel(vistaDispo);
	}
	
	public void vistaPago() {
		nuevoPanel(vistaRealizarPago);
	}
	
	public void crearVehiclo() {
		nuevoPanel(vistaCrearVehiculo);
	}
	
	public void modVehiclo() {
		nuevoPanel(vistaModVehiculo);
	}
	
	public void crearEmpleado() {
		nuevoPanel(vistaCrearEmpleado);
	}
	
	public void modEmpleado() {
		nuevoPanel(vistaModificarEmpleado);
	}
	
	public void crearSeguro() {
		nuevoPanel(vistaCrearSeguro);
	}
	
	public void modSeguro() {
		nuevoPanel(vistaModSeguro);
	}
	
	public void menuAdmi() {
		nuevoPanel(vistaMenuAdmi);
	}
	
	public void crearSede() {
		nuevoPanel(vistaCrearSede);
	}
	
	public void modSede() {
		nuevoPanel(vistaModSede);
	}
	public void menuAdmiLocal() {
		nuevoPanel(vistaAdmiLocal);
	}
	
	public void crearCategoria() {
		nuevoPanel(vistaCrearCategoria);
	}
	
	public void modCategoria() {
		nuevoPanel(vistaModCategoria);
	}
	
	
	// Control
	
	public boolean buscarUsuario() {
		boolean k = true;
		return k;
	}
	
	public static void main(String[] args) {
		InterfazEmpresa IE = new InterfazEmpresa();
	}

}


