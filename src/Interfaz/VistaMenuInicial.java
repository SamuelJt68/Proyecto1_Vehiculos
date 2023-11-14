package Interfaz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

		
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

	public class VistaMenuInicial extends JFrame implements ActionListener{
		
		private JPanel contenPanel; 
		private VistaMenuInicial vistaMenuInicial;
		private VistaInicioSesion vistaInicioSesion;
		private VistaInicioSesionCliente vistaInicioSesionCliente;
		private VistaMenuEmpleado vistaMenuEmpleado;
		private VistaNuevaCuenta vistaNuevaCuenta;
		private VistaMenuCliente vistaMenuCliente;
		private Image imagen;
		private InterfazEmpresa interfaz;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String grito = e.getActionCommand();
				
			if (grito.equals("Empleado")) {
				interfaz.InicioEmpleado();	
			}
			else if (grito.equals("Cliente")) {
				interfaz.InicioCliente();
			}
				
		}
		
		
		public VistaMenuInicial(InterfazEmpresa interfazEmpresa){

			this.interfaz = interfazEmpresa;
		
			contenPanel = new JPanel();
			contenPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contenPanel);
			contenPanel.setLayout(new CardLayout(0,0));
			
			
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
	
	
	}
