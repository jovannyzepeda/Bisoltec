package Grafico;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

import PostgreSQL.Conexion;
import PostgreSQL.GraficaRubros;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Collections;

public class GraficarRubro extends JFrame {

	static String acryl="com.jtattoo.plaf.acryl.AcrylLookAndFeel";
	Conexion conexion=new Conexion();
	PostgreSQL.GraficaRubros graficarRubros=new GraficaRubros();
	
	String fecha=null;
	
	 DefaultPieDataset data = new DefaultPieDataset();
	
	private JPanel contentPane;
	private JPanel panel;
	private JTextField txtDiaInicial;
	private JTextField txtMesInicial;
	private JTextField txtAñoInicial;
	private JTextField txtDiaFinal;
	private JTextField txtMesFinal;
	private JTextField txtAñoFinal;
	private JButton button;
	private JLabel lblDia;
	private JLabel lblMes;
	private JLabel lblAo;
	private JButton btnGraficar;


	/**
	 * Create the frame.
	 */
	public GraficarRubro() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 724, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);

		
		
		 getContentPane().add(panel);
	        // Fuente de Datos
	       

	       
	      
	      
	       
	        //data.setValue("Casa $"+SumaRubro(), SumaRubro());
	       
	        // Creando el Grafico
	        JFreeChart chart = ChartFactory.createPieChart3D(
	        
	        
	        "Grafica Rubros",data, true, true, false);
	        PiePlot3D pieplot3d = (PiePlot3D)chart.getPlot();
	        pieplot3d.setDepthFactor(0.09);//angulo para mostrar
	        pieplot3d.setStartAngle(209D);//angulo donde comienza a graficar
	        pieplot3d.setDirection(Rotation.CLOCKWISE);//grafica hacia las maneillas del reloj
	        pieplot3d.setForegroundAlpha(0.8F);//transparencia en el grafico
	        panel.setLayout(null);


	
	        
	 
	        // Crear el Panel del Grafico con ChartPanel
	        ChartPanel chartPanel = new ChartPanel(chart);
	        chartPanel.setBounds(9, 5, 680, 420);
	        panel.add(chartPanel);
	        
	        txtDiaInicial = new JTextField();
	        txtDiaInicial.setBounds(109, 448, 21, 20);
	        panel.add(txtDiaInicial);
	        txtDiaInicial.setColumns(10);
	        
	        txtMesInicial = new JTextField();
	        txtMesInicial.setColumns(10);
	        txtMesInicial.setBounds(140, 448, 21, 20);
	        panel.add(txtMesInicial);
	        
	        txtAñoInicial = new JTextField();
	        txtAñoInicial.setColumns(10);
	        txtAñoInicial.setBounds(171, 448, 21, 20);
	        panel.add(txtAñoInicial);
	        
	        txtDiaFinal = new JTextField();
	        txtDiaFinal.setColumns(10);
	        txtDiaFinal.setBounds(109, 479, 21, 20);
	        panel.add(txtDiaFinal);
	        
	        txtMesFinal = new JTextField();
	        txtMesFinal.setColumns(10);
	        txtMesFinal.setBounds(140, 479, 21, 20);
	        panel.add(txtMesFinal);
	        
	        txtAñoFinal = new JTextField();
	        txtAñoFinal.setColumns(10);
	        txtAñoFinal.setBounds(171, 479, 21, 20);
	        panel.add(txtAñoFinal);
	        
	        JLabel lblFechaInicial = new JLabel("Fecha inicial");
	        lblFechaInicial.setBounds(10, 453, 89, 14);
	        panel.add(lblFechaInicial);
	        
	        JLabel lblFechaFinal = new JLabel("Fecha final");
	        lblFechaFinal.setBounds(10, 482, 89, 14);
	        panel.add(lblFechaFinal);
	        
	        button = new JButton("Hoy");
	        button.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		
	        		Calendar Fecha = Calendar.getInstance();
					String dia = Integer.toString(Fecha.get(Calendar.DATE));
					String mes = Integer.toString(Fecha.get(Calendar.MONTH)+1);
					String año = Integer.toString(Fecha.get(Calendar.YEAR));
					
					if(dia.length()==1){
						dia="0"+dia;
						
					}
					if(mes.length()==1){
						mes="0"+mes;
					}
					
					año=año.substring(2, año.length());
					
					
					fecha=dia+"-"+mes+"-"+año;
					
					txtDiaFinal.setText(dia);
					txtMesFinal.setText(mes);
					txtAñoFinal.setText(año);
	        		
	        	}
	        });
	        button.setHorizontalAlignment(SwingConstants.LEFT);
	        button.setBounds(202, 478, 36, 23);
	        panel.add(button);
	        
	        lblDia = new JLabel("Dia");
	        lblDia.setBounds(109, 433, 21, 14);
	        panel.add(lblDia);
	        
	        lblMes = new JLabel("Mes");
	        lblMes.setBounds(140, 433, 36, 14);
	        panel.add(lblMes);
	        
	        lblAo = new JLabel("A\u00F1o");
	        lblAo.setBounds(171, 433, 21, 14);
	        panel.add(lblAo);
	        
	        btnGraficar = new JButton("Graficar");
	        btnGraficar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		data.clear();
	        		String fechaInicial, diaInicial,mesInicial,añoInicial;
	        		String fechaFinal, diaFinal,mesFinal,añoFinal;
	        		
	        		diaInicial=txtDiaInicial.getText().toString();
	        		mesInicial=txtMesInicial.getText().toString();
	        		añoInicial=txtAñoInicial.getText().toString();
	        		
	        		fechaInicial="20"+añoInicial+"-"+mesInicial+"-"+diaInicial;
	        		
	        		diaFinal=txtDiaFinal.getText().toString();
	        		mesFinal=txtMesFinal.getText().toString();
	        		añoFinal=txtAñoFinal.getText().toString();
	        		
	        		fechaFinal="20"+añoFinal+"-"+mesFinal+"-"+diaFinal;
	        		
	        		 graficarRubros.setFechaFinal(fechaFinal);
	        		 graficarRubros.setFechaInicial(fechaInicial);
	        		 
	        		 
	        		 
	        		 graficarRubros.RecaudarDatos(conexion.conectar());
	        		 
	        		

	      	       String rubro = null;
	      	       float cantidad = 0;
	       	      int iterador=0;
	       	      
	       	     
	       	      while(iterador<graficarRubros.listaRubros.size()){
	       	    	
	       	    	rubro=graficarRubros.listaRubros.get(iterador).toString();
	       	    	cantidad=Float.parseFloat(graficarRubros.listaCantidad.get(iterador).toString());
	       	    	data.setValue(rubro+" $"+cantidad, cantidad);
	       	    	iterador++;
	       	    	
	       	      }
	       	      
	       	  
	       	     
	       	      
	       
	       	      graficarRubros.listaCantidad.clear();
	       	      graficarRubros.listaRubros.clear();
	       	      fechaFinal="";
	       	      fechaInicial="";
	     	      
	       	      
	     	      
	        		
	        	}
	        });
	        btnGraficar.setBounds(599, 461, 89, 23);
	        panel.add(btnGraficar);
	}
}
