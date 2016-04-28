package Grafico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import PostgreSQL.Conexion;
import PostgreSQL.GraficaPuntosRubroTotal;
import PostgreSQL.GraficaPuntosUnRubroTotales;
import PostgreSQL.Rubro;

public class GraficaPuntosUnRubroTotal extends JFrame {

	static String acryl="com.jtattoo.plaf.acryl.AcrylLookAndFeel";
	Conexion conexion=new Conexion();
	PostgreSQL.GraficaPuntosUnRubroTotales graficaPuntosUnRubroTotales=new GraficaPuntosUnRubroTotales();
	
	String fecha=null;
	
	 
	 DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
	
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnGraficar;
	private JTextField txtAño;
	private JComboBox cmbInicial;
	private JComboBox cmbFinal;
	private JComboBox cmbRubro;
	private JLabel lblRubro;
	PostgreSQL.Rubro rubro=new Rubro();

	/**
	 * Create the frame.
	 */
	public GraficaPuntosUnRubroTotal() {
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
	        JFreeChart chart = ChartFactory.createLineChart("Un Solo Rubro","Mes","Cantidad $",line_chart_dataset,PlotOrientation.VERTICAL,true,true,false);  
	        
	        
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
	        		
	        		graficaPuntosUnRubroTotales.setFechaFinal(fechaFinal);
	        		graficaPuntosUnRubroTotales.setFechaInicial(fechaInicial);
	        		 
	        		String rubroNombre=cmbRubro.getSelectedItem().toString(); 
	        		graficaPuntosUnRubroTotales.setDescripcion(rubroNombre); 
	        		graficaPuntosUnRubroTotales.RecaudarDatos(conexion.conectar());
	        		 
	        		

	      	       String mesLetra = null,mes=null;
	      	       float cantidad = 0;
	       	      int iterador=0;
	       	      
	       	      
	       	     
	       	      while(iterador<graficaPuntosUnRubroTotales.listaMes.size()){
	       	    	
	       	    	mes=graficaPuntosUnRubroTotales.listaMes.get(iterador).toString();
	       	    	cantidad=Float.parseFloat(graficaPuntosUnRubroTotales.listaCantidad.get(iterador).toString());
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
	       	    	//System.out.println(cantidad+" cantidad"+"\n"+mes+" mes");
	       	    	iterador++;
	       	    	
	       	      }
	       	      
	       	  
	       	     
	       	      
	       
	       	   graficaPuntosUnRubroTotales.listaCantidad.clear();
	       	   graficaPuntosUnRubroTotales.listaMes.clear();
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
	        lblAaaa.setBounds(206, 439, 35, 14);
	        panel.add(lblAaaa);
	        
	        JLabel lblAo = new JLabel("A\u00F1o");
	        lblAo.setBounds(75, 439, 159, 14);
	        panel.add(lblAo);
	        
	        cmbInicial = new JComboBox();
	        cmbInicial.setModel(new DefaultComboBoxModel(new String[] {"-----", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
	        cmbInicial.setBounds(331, 436, 124, 20);
	        panel.add(cmbInicial);
	        
	        cmbFinal = new JComboBox();
	        cmbFinal.setModel(new DefaultComboBoxModel(new String[] {"-----", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
	        cmbFinal.setBounds(331, 467, 124, 20);
	        panel.add(cmbFinal);
	        
	        JLabel lblMesInicial = new JLabel("Mes Inicial");
	        lblMesInicial.setBounds(275, 439, 180, 14);
	        panel.add(lblMesInicial);
	        
	        JLabel lblMesFinal = new JLabel("Mes Final");
	        lblMesFinal.setBounds(275, 470, 180, 14);
	        panel.add(lblMesFinal);
	        
	        cmbRubro = new JComboBox();
	        cmbRubro.setModel(new DefaultComboBoxModel(new String[] {"-----"}));
	        cmbRubro.setBounds(110, 462, 124, 20);
	        panel.add(cmbRubro);
	        
	        lblRubro = new JLabel("Rubro");
	        lblRubro.setBounds(72, 465, 180, 14);
	        panel.add(lblRubro);
	        
	        rubro.listaRubros.clear();
			rubro.AgregarRubroComboBox(conexion.conectar());
			int i=0;
			while(rubro.listaRubros.size()!=i){
			cmbRubro.addItem(rubro.listaRubros.get(i));
			i++;
			}
	}

}
