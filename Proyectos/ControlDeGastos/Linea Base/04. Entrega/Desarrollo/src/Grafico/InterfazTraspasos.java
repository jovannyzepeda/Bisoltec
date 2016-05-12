package Grafico;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import PostgreSQL.Conexion;
import PostgreSQL.Traspasos;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class InterfazTraspasos extends JFrame {
	
	PostgreSQL.Conexion conexion=new Conexion();
	PostgreSQL.Traspasos traspasos=new Traspasos();
	int filas=0;
	DefaultTableModel modeloTraspasos,modeloLimpioTraspasos;
	Vector<String> nombreColumnas=new Vector<String>();
	
	private JPanel contentPane;
	private JTable table;
	private JButton btnCargar;

	public InterfazTraspasos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InterfazTraspasos.class.getResource("/Imagenes/logoS.png")));
		
		nombreColumnas.addElement("ID");
		nombreColumnas.addElement("Cuenta Origen");
		nombreColumnas.addElement("Cuenta Destino");
		nombreColumnas.addElement("Monto");
		
		modeloLimpioTraspasos=new DefaultTableModel(nombreColumnas, filas);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 404, 229);
		panel.add(scrollPane);
		
		table = new JTable();
		
		modeloTraspasos=new DefaultTableModel(nombreColumnas, 0);
		traspasos.buscarTodosTraspaso(conexion.conectar(),modeloTraspasos);
		
		table.setModel(modeloTraspasos);
		
		
		
		scrollPane.setViewportView(table);
		
		btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modeloTraspasos=new DefaultTableModel(nombreColumnas, 0);
				traspasos.buscarTodosTraspaso(conexion.conectar(),modeloTraspasos);
				
				table.setModel(modeloTraspasos);
			}
		});
		btnCargar.setBounds(325, 251, 89, 23);
		panel.add(btnCargar);
	}
}
