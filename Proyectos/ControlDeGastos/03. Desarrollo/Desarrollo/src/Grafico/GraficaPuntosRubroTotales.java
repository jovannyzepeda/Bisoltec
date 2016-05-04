package Grafico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

import PostgreSQL.Conexion;
import PostgreSQL.GraficaPuntosRubroTotal;
import PostgreSQL.GraficaSubrubro;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class GraficaPuntosRubroTotales extends JFrame {


	static String acryl="com.jtattoo.plaf.acryl.AcrylLookAndFeel";
	Conexion conexion=new Conexion();
	PostgreSQL.GraficaPuntosRubroTotal graficaPuntosRubroTotal=new GraficaPuntosRubroTotal();
	
	String fecha=null;
	
	 
	 DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
	
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnGraficar;
	private JTextField txtAño;
	private JComboBox cmbInicial;
	private JComboBox cmbFinal;


	/**
	 * Create the frame.
	 */
	public GraficaPuntosRubroTotales() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GraficaPuntosRubroTotales.class.getResource("/Imagenes/logoS.png")));
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
	        JFreeChart chart = ChartFactory.createLineChart("Todos Los Rubros","Mes","Cantidad $",line_chart_dataset,PlotOrientation.VERTICAL,true,true,false);  
	        
	        
	        CategoryPlot p = chart.getCategoryPlot(); 
	        p.setRangeGridlinePaint(Color.BLUE); 
	        panel.setLayout(null);


	
	        
	 
	        // Crear el Panel del Grafico con ChartPanel
	        ChartPanel chartPanel = new ChartPanel(chart);
	        chartPanel.setBounds(9, 5, 680, 420);
	        panel.add(chartPanel);
	        
	        btnGraficar = new JButton("Graficar");
	        btnGraficar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		line_chart_dataset.clear();
	        		String fechaInicial,año,mesIncial = null;
	        		String fechaFinal,mesFinal = null;
	        		
	        		switch(cmbInicial.getSelectedIndex())
	        		{
	        		case 1: mesIncial="01";
	        		break;
	        		case 2: mesIncial="02";
	        		break;
	        		case 3: mesIncial="03";
	        		break;
	        		case 4: mesIncial="04";
	        		break;
	        		case 5: mesIncial="05";
	        		break;
	        		case 6: mesIncial="06";
	        		break;
	        		case 7: mesIncial="07";
	        		break;
	        		case 8: mesIncial="08";
	        		break;
	        		case 9: mesIncial="09";
	        		break;
	        		case 10: mesIncial="10";
	        		break;
	        		case 11: mesIncial="11";
	        		break;
	        		case 12: mesIncial="12";
	        		break;
	        		default: mesIncial="00";
	        		break;
	        		}
	        		
	        		
	        		switch(cmbFinal.getSelectedIndex())
	        		{
	        		case 1: mesFinal="01";
	        		break;
	        		case 2: mesFinal="02";
	        		break;
	        		case 3: mesFinal="03";
	        		break;
	        		case 4: mesFinal="04";
	        		break;
	        		case 5: mesFinal="05";
	        		break;
	        		case 6: mesFinal="06";
	        		break;
	        		case 7: mesFinal="07";
	        		break;
	        		case 8: mesFinal="08";
	        		break;
	        		case 9: mesFinal="09";
	        		break;
	        		case 10: mesFinal="10";
	        		break;
	        		case 11: mesFinal="11";
	        		break;
	        		case 12: mesFinal="12";
	        		break;
	        		default: mesFinal="00";
	        		break;
	        		}
	        		
	        		año=txtAño.getText().toString();
	        		
	        		fechaInicial=año+"-"+mesIncial+"-"+"01";
	        		
	        		
	        		
	        		fechaFinal=año+"-"+mesFinal+"-"+"31";
	        		
	        		graficaPuntosRubroTotal.setFechaFinal(fechaFinal);
	        		graficaPuntosRubroTotal.setFechaInicial(fechaInicial);
	        		 
	        		 
	        		 
	        		graficaPuntosRubroTotal.RecaudarDatos(conexion.conectar());
	        		 
	        		

	      	       String mesLetra = null,mes=null;
	      	       float cantidad = 0;
	       	      int iterador=0;
	       	      
	       	      
	       	     
	       	      while(iterador<graficaPuntosRubroTotal.listaMes.size()){
	       	    	
	       	    	mes=graficaPuntosRubroTotal.listaMes.get(iterador).toString();
	       	    	cantidad=Float.parseFloat(graficaPuntosRubroTotal.listaCantidad.get(iterador).toString());
	       	    	switch(mes){
	       	    	case "1":mesLetra="Ene";
	       	    	break;
	       	    	case "2":mesLetra="Feb";
	       	    	break;
	       	    	case "3":mesLetra="Mar";
	       	    	break;
	       	    	case "4":mesLetra="Abr";
	       	    	break;
	       	    	case "5":mesLetra="May";
	       	    	break;
	       	    	case "6":mesLetra="Jun";
	       	    	break;
	       	    	case "7":mesLetra="Jul";
	       	    	break;
	       	    	case "8":mesLetra="Ago";
	       	    	break;
	       	    	case "9":mesLetra="Sep";
	       	    	break;
	       	    	case "10":mesLetra="Oct";
	       	    	break;
	       	    	case "11":mesLetra="Nov";
	       	    	break;
	       	    	case "12":mesLetra="Dic";
	       	    	break;
	       	    	default: mesLetra="ERROR";
	       	    		break;
	       	    	}
	       	    	line_chart_dataset.addValue(cantidad, "Rubros", mesLetra+" "+cantidad);
	       	    	System.out.println(cantidad+" cantidad"+"\n"+mes+" mes");
	       	    	iterador++;
	       	    	
	       	      }
	       	      
	       	  
	       	     
	       	      
	       
	       	   graficaPuntosRubroTotal.listaCantidad.clear();
	       	   graficaPuntosRubroTotal.listaMes.clear();
	       	      fechaFinal="";
	       	      fechaInicial="";
	     	      
	       	      
	     	      
	        		
	        	}
	        });
	        btnGraficar.setBounds(599, 461, 89, 23);
	        panel.add(btnGraficar);
	        
	        txtAño = new JTextField();
	        txtAño.setBounds(110, 436, 86, 20);
	        panel.add(txtAño);
	        txtAño.setColumns(10);
	        
	        JLabel lblAaaa = new JLabel("AAAA");
	        lblAaaa.setEnabled(false);
	        lblAaaa.setBounds(206, 439, 46, 14);
	        panel.add(lblAaaa);
	        
	        JLabel lblAo = new JLabel("A\u00F1o");
	        lblAo.setBounds(75, 439, 25, 14);
	        panel.add(lblAo);
	        
	        cmbInicial = new JComboBox();
	        cmbInicial.setModel(new DefaultComboBoxModel(new String[] {"-----", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
	        cmbInicial.setBounds(110, 462, 124, 20);
	        panel.add(cmbInicial);
	        
	        cmbFinal = new JComboBox();
	        cmbFinal.setModel(new DefaultComboBoxModel(new String[] {"-----", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
	        cmbFinal.setBounds(110, 493, 124, 20);
	        panel.add(cmbFinal);
	        
	        JLabel lblMesInicial = new JLabel("Mes Inicial");
	        lblMesInicial.setBounds(54, 465, 180, 14);
	        panel.add(lblMesInicial);
	        
	        JLabel lblMesFinal = new JLabel("Mes Final");
	        lblMesFinal.setBounds(54, 496, 180, 14);
	        panel.add(lblMesFinal);
	}
}
