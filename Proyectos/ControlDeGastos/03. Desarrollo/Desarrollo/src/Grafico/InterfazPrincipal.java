package Grafico;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

import com.mxrck.autocompleter.TextAutoCompleter;

import PostgreSQL.Conexion;
import PostgreSQL.Cuenta;
import PostgreSQL.Movimiento;
import PostgreSQL.Rubro;
import PostgreSQL.Subrubro;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;


public class InterfazPrincipal extends JFrame {
	
	TextAutoCompleter AutoCompletarCuenta,AutoCompletarRubro,AutoCompletarSubrubro,AutoCompletarMovimiento;

	PostgreSQL.Conexion conexion=new Conexion();
	PostgreSQL.Cuenta cuenta=new Cuenta();
	PostgreSQL.Rubro rubro=new Rubro();
	PostgreSQL.Subrubro subrubro=new Subrubro();
	PostgreSQL.Movimiento movimiento=new Movimiento();
	
	Grafico.GraficarRubro graficaRubro;
	
	static String acryl="com.jtattoo.plaf.acryl.AcrylLookAndFeel";
	
	
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtSaldo;
	private JTextField txtMovimientoDescripcion;
	private JTextField txtMovimientoCantidad;
	private JTextField txtMovimientosDia;
	private JTextField txtMovimientosMes;
	private JTextField txtMovimientosAño;
	private JTextField txtSubrubroDescripcion;
	private JTextField txtRubroDescripcion;

	
	int pk_cuenta;
	int pk_rubro;
	int pk_subrubro;
	int pk_movimiento;
	
	String fecha=null;
	
	private JButton btnBuscar_1;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private JButton btnLimpiar;
	private JButton btnModificar;
	private JRadioButton rdbtnEntradaRubro;
	private JRadioButton rdbtnSalidaRubro;
	private JButton btnRubroBuscar;
	private JButton btnRubroNuevo;
	private JButton btnRubroGuardar;
	private JButton btnRubroEliminar;
	private JButton btnRubroCancelar;
	private JButton btnRubroModificar;
	private JComboBox cmbSubrubroRubro;
	private JButton btnSubrubroEliminar;
	private JButton btnSubrubroBuscar;
	private JButton btnSubrubroNuevo;
	private JButton btnSubrubroGuardar;
	private JButton btnSubrubroCancelar;
	private JButton btnSubrubroModificar;
	private JComboBox cmbMovimientosSubrubro;
	private JButton btnMovimientosCancelar;
	private JButton btnMovimientosModificar;
	private JButton btnMovimientosEliminar;
	private JButton btnMovimientosNuevo;
	private JButton btnMovimientosGuardar;
	private JButton btnMovimientosHoy;
	private JComboBox cmbMovimientosCuenta;
	private JButton btnMovimientosBuscar;
	private JLayeredPane layeredPane_2;
	private JCheckBox chckbxEntradas;
	private JCheckBox checkBox;
	private JTextField txtTraspasosSaldo;
	private JButton btnTraspasosGuardar;
	private JButton btnTraspasoBuscar;
	private JButton btnTraspasosEliminar;
	private JButton btnTraspasoCancelar;
	private JComboBox cmbTraspasosDestino;
	private JComboBox cmbTraspasosOrigen;
	private JButton btnTraspasosNuevo;
	private JButton btnTraspasosModificar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					try
					
					{
					    JFrame.setDefaultLookAndFeelDecorated(true);
					    JDialog.setDefaultLookAndFeelDecorated(true);
					    UIManager.setLookAndFeel(acryl);

					}

					catch (Exception e)

					{
					    e.printStackTrace();
					}
					
					
					InterfazPrincipal frame = new InterfazPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Nacho Martinez\\Desktop\\LogoBisoltecSimple.png"));
		setResizable(false);
		setTitle("Control De Gastos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 254, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 240, 370);
		panel.add(tabbedPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("1-Cuentas", null, layeredPane, null);
		layeredPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(64, 23, 140, 20);
		layeredPane.add(txtNombre);
		
		AutoCompletarCuenta=new TextAutoCompleter(txtNombre);
		
		txtSaldo = new JTextField();
		txtSaldo.setEnabled(false);
		txtSaldo.setColumns(10);
		txtSaldo.setBounds(86, 54, 118, 20);
		layeredPane.add(txtSaldo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 23, 45, 20);
		layeredPane.add(lblNombre);
		
		JLabel lblSaldo = new JLabel("Saldo      $");
		lblSaldo.setBounds(10, 54, 65, 20);
		layeredPane.add(lblSaldo);
		
		
		
		/*************************************************************************************************************
		 ***************************************** Boton GUARDAR CUENTA***********************************************
		 *************************************************************************************************************/
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nombre_cuenta;
				
				float saldo;
				
				
				nombre_cuenta=txtNombre.getText().toString();
				saldo=Float.parseFloat(txtSaldo.getText().toString());
				System.out.println(pk_cuenta);
				
				if(txtNombre.getText().isEmpty()||txtSaldo.getText().isEmpty()){
					
					
					JOptionPane.showMessageDialog(null, "Porfavor ingrese los Datos Solicitados ", "Error", JOptionPane.ERROR_MESSAGE);
				
				
				}
				else
				{
				
				cuenta.setNombre_cuenta(nombre_cuenta);
				cuenta.setPk_cuenta(pk_cuenta);
				cuenta.setSaldo(saldo);
				
				
				cuenta.insertarCuenta(conexion.conectar());
				
				
				
				LimpiarCuenta();
				}
				
			}
		});
		btnGuardar.setBounds(136, 272, 89, 23);
		layeredPane.add(btnGuardar);
		
		
		/*************************************************************************************************************
		 ***************************************** Boton NUEVO CUENTA***********************************************
		 *************************************************************************************************************/
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LimpiarCuenta();
				
				pk_cuenta=cuenta.ultimaCuenta(conexion.conectar());
				
				
				btnBuscar_1.setEnabled(false);
				btnNuevo.setEnabled(false);
				btnGuardar.setEnabled(true);
				btnLimpiar.setVisible(true);
				txtSaldo.setEnabled(true);
				
			}
		});
		btnNuevo.setBounds(136, 238, 89, 23);
		layeredPane.add(btnNuevo);
		
		
		/*************************************************************************************************************
		 ***************************************** Boton ELIMINAR CUENTA***********************************************
		 *************************************************************************************************************/
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int ventana=JOptionPane.showConfirmDialog(null, "¿Esta seguro que desa ELIMINAR la Cuenta?");
				
				if(ventana==JOptionPane.YES_OPTION){
				
					String nombre_cuenta=txtNombre.getText().toString();
					cuenta.setNombre_cuenta(nombre_cuenta);
					cuenta.buscarCuenta(conexion.conectar());
					
					pk_cuenta=cuenta.getPk_cuenta();
				
				
					cuenta.eliminarCuenta(conexion.conectar());

					LimpiarCuenta();
				}
			}
		});
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(21, 272, 89, 23);
		layeredPane.add(btnEliminar);
		
		
		/*************************************************************************************************************
		 ***************************************** Boton BUSCAR CUENTA***********************************************
		 *************************************************************************************************************/
		
		btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre_cuenta=txtNombre.getText().toString();
				
				
				
				cuenta.setNombre_cuenta(nombre_cuenta);
				cuenta.buscarCuenta(conexion.conectar());
				
				
				
				float saldo;
				
				nombre_cuenta=cuenta.getNombre_cuenta();
				saldo=cuenta.getSaldo();
				pk_cuenta=cuenta.getPk_cuenta();
				
			
				
				
				if(pk_cuenta>0){
				
					txtNombre.setText(nombre_cuenta);
					txtSaldo.setText(Float.toString(saldo));
					
					btnEliminar.setEnabled(true);
					btnModificar.setVisible(true);
					btnGuardar.setVisible(false);
					btnLimpiar.setVisible(true);
					btnNuevo.setEnabled(false);
					txtSaldo.setEnabled(true);
					
				
				}
				else{
					JOptionPane.showMessageDialog(null, "No se encontró la Cuenta");
				}
			}
		});
		btnBuscar_1.setBounds(136, 204, 89, 23);
		layeredPane.add(btnBuscar_1);
		
		/*************************************************************************************************************
		 ***************************************** Boton CANCELAR CUENTA***********************************************
		 *************************************************************************************************************/
		
		btnLimpiar = new JButton("Cancelar");
		btnLimpiar.setVisible(false);
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiarCuenta();
			}
		});
		btnLimpiar.setBounds(21, 204, 89, 23);
		layeredPane.add(btnLimpiar);
		
		
		/*************************************************************************************************************
		 ***************************************** Boton MODIFICAR CUENTA***********************************************
		 *************************************************************************************************************/
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre_cuenta;
				float saldo;
				
				nombre_cuenta=txtNombre.getText().toString();
				saldo=Float.parseFloat(txtSaldo.getText().toString());
				
				
				
				if(txtNombre.getText().isEmpty()||txtSaldo.getText().isEmpty()){
					
					
					JOptionPane.showMessageDialog(null, "Porfavor ingrese los Datos Solicitados ", "Error", JOptionPane.ERROR_MESSAGE);
				
				
				}
				else{
				
					cuenta.setNombre_cuenta(nombre_cuenta);
					cuenta.setSaldo(saldo);
					
					System.out.println("Boton Modificar PK_cuenta=" + pk_cuenta);
				
				
				cuenta.modificarCuenta(conexion.conectar());
				
				LimpiarCuenta();
				
				}
				
			}
		});
		btnModificar.setBounds(136, 272, 89, 23);
		layeredPane.add(btnModificar);
		
		JLayeredPane layeredPane_6 = new JLayeredPane();
		tabbedPane.addTab("2-Rubros", null, layeredPane_6, null);
		layeredPane_6.setLayout(null);
		
		txtRubroDescripcion = new JTextField();
		txtRubroDescripcion.setColumns(10);
		txtRubroDescripcion.setBounds(83, 24, 117, 20);
		layeredPane_6.add(txtRubroDescripcion);
		AutoCompletarRubro=new TextAutoCompleter(txtRubroDescripcion);
		
		JLabel lblDecripcin = new JLabel("Descripci\u00F3n");
		lblDecripcin.setBounds(6, 24, 77, 20);
		layeredPane_6.add(lblDecripcin);
		
		JLabel lblTipoDeMovimiento = new JLabel("Tipo de Movimiento");
		lblTipoDeMovimiento.setEnabled(false);
		lblTipoDeMovimiento.setBounds(62, 77, 111, 20);
		layeredPane_6.add(lblTipoDeMovimiento);
		
		btnRubroGuardar = new JButton("Guardar");
		btnRubroGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String descripcion_rubro,tipoMovimiento="";
				
				descripcion_rubro=txtRubroDescripcion.getText().toString();
				
				if(rdbtnEntradaRubro.isSelected()==true){
					tipoMovimiento="entrada";
				}
				if(rdbtnSalidaRubro.isSelected()==true){
					tipoMovimiento="salida";
				}
				
				System.out.println(pk_rubro);
				
				if(txtRubroDescripcion.getText().isEmpty()==true){
					
					
					JOptionPane.showMessageDialog(null, "Porfavor ingrese los Datos Solicitados ", "Error", JOptionPane.ERROR_MESSAGE);
				
				
				}
				else
				{
				
					rubro.setDescripcion_rubro(descripcion_rubro);
					rubro.setPk_rubro(pk_rubro);
					rubro.setTipoMovimiento_rubro(tipoMovimiento);
					
					rubro.insertarRubro(conexion.conectar());
					
					LimpiarRubro();
								
				
				}
				
			}
		});
		btnRubroGuardar.setEnabled(false);
		btnRubroGuardar.setBounds(136, 272, 89, 23);
		layeredPane_6.add(btnRubroGuardar);
		
		btnRubroNuevo = new JButton("Nuevo");
		btnRubroNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LimpiarRubro();
				
				pk_rubro=rubro.ultimoRubro(conexion.conectar());
				
				
				btnRubroBuscar.setEnabled(false);
				btnRubroNuevo.setEnabled(false);
				btnRubroGuardar.setEnabled(true);
				btnRubroCancelar.setVisible(true);
				rdbtnEntradaRubro.setEnabled(true);
				rdbtnSalidaRubro.setEnabled(true);
			}
		});
		btnRubroNuevo.setBounds(136, 241, 89, 23);
		layeredPane_6.add(btnRubroNuevo);
		
		btnRubroEliminar = new JButton("Eliminar");
		btnRubroEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int ventana=JOptionPane.showConfirmDialog(null, "¿Esta seguro que desa ELIMINAR el Rubro?");
				
				
				if(ventana==JOptionPane.YES_OPTION){
				
					String descripcion_rubro=txtRubroDescripcion.getText().toString();
					rubro.setDescripcion_rubro(descripcion_rubro);
					rubro.buscarRubro(conexion.conectar());
					
					pk_rubro=rubro.getPk_rubro();
				
					rubro.eliminarRubro(conexion.conectar());
					

					LimpiarRubro();
				}
				
			}
		});
		btnRubroEliminar.setEnabled(false);
		btnRubroEliminar.setBounds(21, 272, 89, 23);
		layeredPane_6.add(btnRubroEliminar);
		
		rdbtnEntradaRubro = new JRadioButton("Entrada");
		rdbtnEntradaRubro.setEnabled(false);
		rdbtnEntradaRubro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnSalidaRubro.setSelected(false);
			}
		});
		
		rdbtnEntradaRubro.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnEntradaRubro.setBounds(6, 118, 99, 23);
		layeredPane_6.add(rdbtnEntradaRubro);
		
		rdbtnSalidaRubro = new JRadioButton("Salida");
		rdbtnSalidaRubro.setEnabled(false);
		rdbtnSalidaRubro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnEntradaRubro.setSelected(false);
			}
		});
		
		rdbtnSalidaRubro.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnSalidaRubro.setBounds(122, 118, 99, 23);
		layeredPane_6.add(rdbtnSalidaRubro);
		
		btnRubroBuscar = new JButton("Buscar");
		btnRubroBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String descripcion_rubro=txtRubroDescripcion.getText().toString(),tipoMovimiento;
				
				
				rubro.setDescripcion_rubro(descripcion_rubro);
				rubro.buscarRubro(conexion.conectar());
				
				descripcion_rubro=rubro.getDescripcion_rubro();
				tipoMovimiento=rubro.getTipoMovimiento_rubro();
				pk_rubro=rubro.getPk_rubro();
				
				
				
				
				
				if(pk_rubro>0){
				
					txtRubroDescripcion.setText(descripcion_rubro);
					if(tipoMovimiento.equals("entrada")){
						rdbtnEntradaRubro.setSelected(true);
					}
					if(tipoMovimiento.equals("salida")){
						rdbtnSalidaRubro.setSelected(true);
					}
					
					btnRubroEliminar.setEnabled(true);
					btnRubroModificar.setVisible(true);
					btnRubroGuardar.setVisible(false);
					btnRubroCancelar.setVisible(true);
					btnRubroNuevo.setEnabled(false);
					
					rdbtnEntradaRubro.setEnabled(true);
					rdbtnSalidaRubro.setEnabled(true);
				
				}
				else{
					JOptionPane.showMessageDialog(null, "No se encontró el Rubro");
				}
				
			}
		});
		btnRubroBuscar.setBounds(136, 207, 89, 23);
		layeredPane_6.add(btnRubroBuscar);
		
		btnRubroCancelar = new JButton("Cancelar");
		btnRubroCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiarRubro();
			}
		});
		btnRubroCancelar.setVisible(false);
		btnRubroCancelar.setAutoscrolls(true);
		btnRubroCancelar.setBounds(21, 207, 89, 23);
		layeredPane_6.add(btnRubroCancelar);
		
		btnRubroModificar = new JButton("Modificar");
		btnRubroModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String descripcion_rubro,tipoMovimiento="";
				
				descripcion_rubro=txtRubroDescripcion.getText().toString();
				
				if(rdbtnEntradaRubro.isSelected()==true){
					tipoMovimiento="entrada";
				}
				if(rdbtnSalidaRubro.isSelected()==true){
					tipoMovimiento="salida";
				}
				
				System.out.println(pk_rubro+" pk_rubro Modificar");
				
				if(txtRubroDescripcion.getText().isEmpty()==true){
					
					
					JOptionPane.showMessageDialog(null, "Porfavor ingrese los Datos Solicitados ", "Error", JOptionPane.ERROR_MESSAGE);
				
				
				}
				else
				{
				
					rubro.setDescripcion_rubro(descripcion_rubro);
					rubro.setPk_rubro(pk_rubro);
					rubro.setTipoMovimiento_rubro(tipoMovimiento);
					
					rubro.modificarRubro(conexion.conectar());
					
					LimpiarRubro();
								
				
				}
				
			}
		});
		btnRubroModificar.setBounds(136, 272, 89, 23);
		layeredPane_6.add(btnRubroModificar);
		
		JLayeredPane layeredPane_5 = new JLayeredPane();
		tabbedPane.addTab("3-Subrubro", null, layeredPane_5, null);
		layeredPane_5.setLayout(null);
		
		txtSubrubroDescripcion = new JTextField();
		txtSubrubroDescripcion.setColumns(10);
		txtSubrubroDescripcion.setBounds(86, 21, 118, 20);
		layeredPane_5.add(txtSubrubroDescripcion);
		
		AutoCompletarSubrubro=new TextAutoCompleter(txtSubrubroDescripcion);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(10, 21, 82, 20);
		layeredPane_5.add(lblDescripcion);
		
		JLabel lblSubrubro = new JLabel("Rubro");
		lblSubrubro.setBounds(10, 52, 65, 20);
		layeredPane_5.add(lblSubrubro);
		
		btnSubrubroGuardar = new JButton("Guardar");
		btnSubrubroGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String descripcion_subrubro,tipoMovimiento="";
				String detalle_rubro;
				
				descripcion_subrubro=txtSubrubroDescripcion.getText().toString();
				
				detalle_rubro=cmbSubrubroRubro.getSelectedItem().toString();
				
				System.out.println(detalle_rubro);
				
				rubro.setDescripcion_rubro(detalle_rubro);
				rubro.buscarRubro(conexion.conectar());
				
				pk_rubro=rubro.getPk_rubro();
				
				if(txtSubrubroDescripcion.getText().isEmpty()==true||cmbSubrubroRubro.getSelectedIndex()==0){
					
					
					JOptionPane.showMessageDialog(null, "Porfavor ingrese los Datos Solicitados ", "Error", JOptionPane.ERROR_MESSAGE);
				
				
				}
				else
				{
				
					subrubro.setDescripcion_subrubro(descripcion_subrubro);
					subrubro.setPk_rubro(pk_rubro);
					subrubro.setPk_subrubro(pk_subrubro);
					
					
					subrubro.insertarSubrubro(conexion.conectar());
					
					LimpiarSubrubro();
								
				
				}
				
			}
		});
		btnSubrubroGuardar.setEnabled(false);
		btnSubrubroGuardar.setBounds(136, 272, 89, 23);
		layeredPane_5.add(btnSubrubroGuardar);
		
		btnSubrubroNuevo = new JButton("Nuevo");
		btnSubrubroNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				LimpiarSubrubro();
				
				pk_subrubro=subrubro.ultimoSubrubro(conexion.conectar());
				
				
				btnSubrubroBuscar.setEnabled(false);
				btnSubrubroNuevo.setEnabled(false);
				btnSubrubroGuardar.setEnabled(true);
				btnSubrubroCancelar.setVisible(true);
				
				cmbSubrubroRubro.setEnabled(true);
			}
		});
		btnSubrubroNuevo.setBounds(136, 241, 89, 23);
		layeredPane_5.add(btnSubrubroNuevo);
		
		btnSubrubroEliminar = new JButton("Eliminar");
		btnSubrubroEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int ventana=JOptionPane.showConfirmDialog(null, "¿Esta seguro que desa ELIMINAR el Rubro?");
				
				
				if(ventana==JOptionPane.YES_OPTION){
				
					String descripcion_subrubro=txtSubrubroDescripcion.getText().toString();
					subrubro.setDescripcion_subrubro(descripcion_subrubro);
					subrubro.buscarSubrubro(conexion.conectar());
					
					pk_subrubro=subrubro.getPk_subrubro();
				
					subrubro.eliminarSubrubro(conexion.conectar());
					

					LimpiarSubrubro();
				}
				
			}
		});
		btnSubrubroEliminar.setEnabled(false);
		btnSubrubroEliminar.setBounds(21, 272, 89, 23);
		layeredPane_5.add(btnSubrubroEliminar);
		
		cmbSubrubroRubro = new JComboBox();
		cmbSubrubroRubro.setEnabled(false);
		cmbSubrubroRubro.setModel(new DefaultComboBoxModel(new String[] {"-----"}));
		cmbSubrubroRubro.setBounds(86, 53, 117, 20);
		layeredPane_5.add(cmbSubrubroRubro);
		
		
		btnSubrubroBuscar = new JButton("Buscar");
		btnSubrubroBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String descripcion_subrubro=txtSubrubroDescripcion.getText().toString(),descripcion_rubro;
				
				
				subrubro.setDescripcion_subrubro(descripcion_subrubro);
				subrubro.buscarSubrubro(conexion.conectar());
				
				descripcion_subrubro=subrubro.getDescripcion_subrubro();
				
				
				pk_subrubro=subrubro.getPk_subrubro();
				
				pk_rubro=subrubro.getPk_rubro();
				
				rubro.setPk_rubro(pk_rubro);
				rubro.buscarRubroPorPK(conexion.conectar());
				
				descripcion_rubro=rubro.getDescripcion_rubro();
				System.out.println(descripcion_rubro+" descripcion Rubro");
				
				if(pk_subrubro>0){
				
					txtSubrubroDescripcion.setText(descripcion_subrubro);
					cmbSubrubroRubro.setSelectedItem(descripcion_rubro);
					
					btnSubrubroEliminar.setEnabled(true);
					btnSubrubroModificar.setVisible(true);
					btnSubrubroGuardar.setVisible(false);
					btnSubrubroCancelar.setVisible(true);
					btnSubrubroNuevo.setEnabled(false);
					cmbSubrubroRubro.setEnabled(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "No se encontró el Subrubro");
				}
				
				
			}
		});
		btnSubrubroBuscar.setBounds(136, 207, 89, 23);
		layeredPane_5.add(btnSubrubroBuscar);
		
		btnSubrubroModificar = new JButton("Modificar");
		btnSubrubroModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String descripcion_subrubro,tipoMovimiento="";
				String detalle_rubro;
				
				descripcion_subrubro=txtSubrubroDescripcion.getText().toString();
				
				detalle_rubro=cmbSubrubroRubro.getSelectedItem().toString();
				
				System.out.println(detalle_rubro);
				
				rubro.setDescripcion_rubro(detalle_rubro);
				rubro.buscarRubro(conexion.conectar());
				
				pk_rubro=rubro.getPk_rubro();
				
				if(txtSubrubroDescripcion.getText().isEmpty()==true||cmbSubrubroRubro.getSelectedIndex()==0){
					
					
					JOptionPane.showMessageDialog(null, "Porfavor ingrese los Datos Solicitados ", "Error", JOptionPane.ERROR_MESSAGE);
				
				
				}
				else
				{
				
					subrubro.setDescripcion_subrubro(descripcion_subrubro);
					subrubro.setPk_rubro(pk_rubro);
					subrubro.setPk_subrubro(pk_subrubro);
					
					
					subrubro.modificarSubrubro(conexion.conectar());
					
					LimpiarSubrubro();
								
				
				}
				
			}
		});
		btnSubrubroModificar.setBounds(136, 272, 89, 23);
		layeredPane_5.add(btnSubrubroModificar);
		
		btnSubrubroCancelar = new JButton("Cancelar");
		btnSubrubroCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiarSubrubro();
			}
		});
		btnSubrubroCancelar.setVisible(false);
		btnSubrubroCancelar.setBounds(21, 207, 89, 23);
		layeredPane_5.add(btnSubrubroCancelar);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("4-Movimientos", null, layeredPane_1, null);
		layeredPane_1.setLayout(null);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(10, 11, 85, 20);
		layeredPane_1.add(lblDescripcin);
		
		txtMovimientoDescripcion = new JTextField();
		txtMovimientoDescripcion.setColumns(10);
		txtMovimientoDescripcion.setBounds(105, 11, 99, 20);
		layeredPane_1.add(txtMovimientoDescripcion);
		
		AutoCompletarMovimiento=new TextAutoCompleter(txtMovimientoDescripcion);
		
		
		txtMovimientoCantidad = new JTextField();
		txtMovimientoCantidad.setEnabled(false);
		txtMovimientoCantidad.setColumns(10);
		txtMovimientoCantidad.setBounds(105, 42, 99, 20);
		layeredPane_1.add(txtMovimientoCantidad);
		
		JLabel lblCantidad = new JLabel("Cantidad    $");
		lblCantidad.setBounds(10, 42, 85, 20);
		layeredPane_1.add(lblCantidad);
		
		btnMovimientosNuevo = new JButton("Nuevo");
		btnMovimientosNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LimpiarMovimiento();
				
				
				
				btnMovimientosBuscar.setEnabled(false);
				btnMovimientosNuevo.setEnabled(false);
				btnMovimientosGuardar.setEnabled(true);
				btnMovimientosCancelar.setVisible(true);
				btnMovimientosHoy.setEnabled(true);
				
				txtMovimientoCantidad.setEnabled(true);
				txtMovimientosAño.setEnabled(true);
				txtMovimientosDia.setEnabled(true);
				txtMovimientosMes.setEnabled(true);
				
				cmbMovimientosCuenta.setEnabled(true);
				cmbMovimientosSubrubro.setEnabled(true);
				
				pk_movimiento=movimiento.ultimoMovimiento(conexion.conectar());
				
			}
		});
		btnMovimientosNuevo.setBounds(136, 241, 89, 23);
		layeredPane_1.add(btnMovimientosNuevo);
		
		btnMovimientosEliminar = new JButton("Eliminar");
		btnMovimientosEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int ventana=JOptionPane.showConfirmDialog(null, "¿Esta seguro que desa ELIMINAR el Rubro?");
				
				
				if(ventana==JOptionPane.YES_OPTION){
				
					String descripcion_movimiento=txtMovimientoDescripcion.getText().toString();
					movimiento.setDescripcion_movimiento(descripcion_movimiento);
					movimiento.buscarMovimiento(conexion.conectar());
					
					pk_movimiento=movimiento.getPk_movimiento();
					
					movimiento.eliminarMovimiento(conexion.conectar());
										

					LimpiarMovimiento();
				}
				
			}
		});
		btnMovimientosEliminar.setEnabled(false);
		btnMovimientosEliminar.setBounds(21, 272, 89, 23);
		layeredPane_1.add(btnMovimientosEliminar);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 73, 66, 20);
		layeredPane_1.add(lblFecha);
		
		txtMovimientosDia = new JTextField();
		txtMovimientosDia.setEnabled(false);
		txtMovimientosDia.setBounds(86, 73, 20, 20);
		layeredPane_1.add(txtMovimientosDia);
		txtMovimientosDia.setColumns(10);
		
		txtMovimientosMes = new JTextField();
		txtMovimientosMes.setEnabled(false);
		txtMovimientosMes.setColumns(10);
		txtMovimientosMes.setBounds(112, 73, 20, 20);
		layeredPane_1.add(txtMovimientosMes);
		
		txtMovimientosAño = new JTextField();
		txtMovimientosAño.setEnabled(false);
		txtMovimientosAño.setColumns(10);
		txtMovimientosAño.setBounds(138, 73, 20, 20);
		layeredPane_1.add(txtMovimientosAño);
		
		btnMovimientosHoy = new JButton("Hoy");
		btnMovimientosHoy.setEnabled(false);
		btnMovimientosHoy.addActionListener(new ActionListener() {
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
				
				txtMovimientosDia.setText(dia);
				txtMovimientosMes.setText(mes);
				txtMovimientosAño.setText(año);
				
				
			}
		});
		btnMovimientosHoy.setHorizontalAlignment(SwingConstants.LEFT);
		btnMovimientosHoy.setBounds(165, 73, 39, 23);
		layeredPane_1.add(btnMovimientosHoy);
		
		cmbMovimientosSubrubro = new JComboBox();
		cmbMovimientosSubrubro.setEnabled(false);
		cmbMovimientosSubrubro.setModel(new DefaultComboBoxModel(new String[] {"------"}));
		cmbMovimientosSubrubro.setBounds(86, 105, 118, 20);
		layeredPane_1.add(cmbMovimientosSubrubro);
		
		cmbMovimientosCuenta = new JComboBox();
		cmbMovimientosCuenta.setEnabled(false);
		cmbMovimientosCuenta.setModel(new DefaultComboBoxModel(new String[] {"------"}));
		cmbMovimientosCuenta.setBounds(86, 136, 118, 20);
		layeredPane_1.add(cmbMovimientosCuenta);
		
		JLabel label_1 = new JLabel("Cuenta");
		label_1.setBounds(10, 136, 72, 20);
		layeredPane_1.add(label_1);
		
		JLabel lblSubrubro_1 = new JLabel("Subrubro");
		lblSubrubro_1.setBounds(10, 104, 66, 20);
		layeredPane_1.add(lblSubrubro_1);
		
		btnMovimientosBuscar = new JButton("Buscar");
		btnMovimientosBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String descripcion_movimiento=txtMovimientoDescripcion.getText().toString(),fecha_movimiento,cantidad,descripcion_subrubro,nombre_cuenta,dia,mes,año;
				
				
				movimiento.setDescripcion_movimiento(descripcion_movimiento);
				movimiento.buscarMovimiento(conexion.conectar());
				
				pk_movimiento=movimiento.getPk_movimiento();
				cantidad=Float.toString(movimiento.getCantidad_movimiento());
				fecha_movimiento=movimiento.getFecha_movimiento();
				
			
				dia=fecha_movimiento.substring(8, 10);
				mes=fecha_movimiento.substring(5, 7);
				año=fecha_movimiento.substring(2, 4);
				
				pk_subrubro=movimiento.getPk_subrubro();
				subrubro.setPk_subrubro(pk_subrubro);
				subrubro.buscarSubrubroPorPK(conexion.conectar());
				descripcion_subrubro=subrubro.getDescripcion_subrubro();
				
				
				pk_cuenta=movimiento.getPk_cuenta();
				cuenta.setPk_cuenta(pk_cuenta);
				cuenta.buscarCuentaPorPK(conexion.conectar());
				nombre_cuenta=cuenta.getNombre_cuenta();
				
				
				
				if(pk_movimiento>0){
				
					txtMovimientoDescripcion.setText(descripcion_movimiento);
					txtMovimientoCantidad.setText(cantidad);
					txtMovimientosDia.setText(dia);
					txtMovimientosMes.setText(mes);
					txtMovimientosAño.setText(año);
					cmbMovimientosSubrubro.setSelectedItem(descripcion_subrubro);
					cmbMovimientosCuenta.setSelectedItem(nombre_cuenta);
					
					btnMovimientosEliminar.setEnabled(true);
					btnMovimientosModificar.setVisible(true);
					btnMovimientosGuardar.setVisible(false);
					btnMovimientosCancelar.setVisible(true);
					btnMovimientosNuevo.setEnabled(false);
					btnMovimientosHoy.setEnabled(true);
					
					txtMovimientoCantidad.setEnabled(true);
					txtMovimientosAño.setEnabled(true);
					txtMovimientosDia.setEnabled(true);
					txtMovimientosMes.setEnabled(true);
					
					cmbMovimientosCuenta.setEnabled(true);
					cmbMovimientosSubrubro.setEnabled(true);
					
				}
				else{
					JOptionPane.showMessageDialog(null, "No se encontró el Movimiento ");
				}
				
				
			}
		});
		btnMovimientosBuscar.setBounds(136, 207, 89, 23);
		layeredPane_1.add(btnMovimientosBuscar);
		
		btnMovimientosCancelar = new JButton("Cancelar");
		btnMovimientosCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LimpiarMovimiento();
			}
		});
		btnMovimientosCancelar.setVisible(false);
		btnMovimientosCancelar.setBounds(21, 207, 89, 23);
		layeredPane_1.add(btnMovimientosCancelar);
		
		btnMovimientosGuardar = new JButton("Guardar");
		btnMovimientosGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String descripcion_movimiento,fecha_movimiento = null,detalle_subrubro,nombre_cuenta;
				float cantidad_movimiento;
				
				descripcion_movimiento=txtMovimientoDescripcion.getText().toString();
				
				fecha_movimiento="20"+txtMovimientosAño.getText().toString()+"-"+txtMovimientosMes.getText().toString()+"-"+txtMovimientosDia.getText().toString();
				cantidad_movimiento=Float.parseFloat(txtMovimientoCantidad.getText().toString());
				
				
				detalle_subrubro=cmbMovimientosSubrubro.getSelectedItem().toString();
				
				
				subrubro.setDescripcion_subrubro(detalle_subrubro);
				subrubro.buscarSubrubro(conexion.conectar());
				
				pk_subrubro=subrubro.getPk_subrubro();
				
				
				nombre_cuenta=cmbMovimientosCuenta.getSelectedItem().toString();
				
				
				cuenta.setNombre_cuenta(nombre_cuenta);
				cuenta.buscarCuenta(conexion.conectar());
				
				pk_cuenta=cuenta.getPk_cuenta();
				
				if(txtMovimientoDescripcion.getText().isEmpty()==true||cmbMovimientosSubrubro.getSelectedIndex()==0||cmbMovimientosCuenta.getSelectedIndex()==0||txtMovimientosAño.getText().toString().isEmpty()||txtMovimientosDia.getText().toString().isEmpty()||txtMovimientosMes.getText().toString().isEmpty()){
					
					
					JOptionPane.showMessageDialog(null, "Porfavor ingrese los Datos Solicitados ", "Error", JOptionPane.ERROR_MESSAGE);
				
				
				}
				else
				{
				
					movimiento.setDescripcion_movimiento(descripcion_movimiento);
					movimiento.setCantidad_movimiento(cantidad_movimiento);
					movimiento.setFecha_movimiento(fecha_movimiento);
					movimiento.setPk_cuenta(pk_cuenta);
					movimiento.setPk_subrubro(pk_subrubro);
					movimiento.setPk_movimiento(pk_movimiento);
					
				
					
					movimiento.insertarMovimiento(conexion.conectar());
					
					
					LimpiarMovimiento();
								
				
				}
			
				
			}
		});
		btnMovimientosGuardar.setEnabled(false);
		btnMovimientosGuardar.setBounds(136, 272, 89, 23);
		layeredPane_1.add(btnMovimientosGuardar);
		
		btnMovimientosModificar = new JButton("Modificar");
		btnMovimientosModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String descripcion_movimiento,fecha_movimiento = null,detalle_subrubro,nombre_cuenta;
				float cantidad_movimiento;
				
				descripcion_movimiento=txtMovimientoDescripcion.getText().toString();
				
				fecha_movimiento="20"+txtMovimientosAño.getText().toString()+"-"+txtMovimientosMes.getText().toString()+"-"+txtMovimientosDia.getText().toString();
				cantidad_movimiento=Float.parseFloat(txtMovimientoCantidad.getText().toString());
				
				
				detalle_subrubro=cmbMovimientosSubrubro.getSelectedItem().toString();
				
				
				subrubro.setDescripcion_subrubro(detalle_subrubro);
				subrubro.buscarSubrubro(conexion.conectar());
				
				pk_subrubro=subrubro.getPk_subrubro();
				
				
				nombre_cuenta=cmbMovimientosCuenta.getSelectedItem().toString();
				
				
				cuenta.setNombre_cuenta(nombre_cuenta);
				cuenta.buscarCuenta(conexion.conectar());
				
				pk_cuenta=cuenta.getPk_cuenta();
				
				if(txtMovimientoDescripcion.getText().isEmpty()==true||cmbMovimientosSubrubro.getSelectedIndex()==0||cmbMovimientosCuenta.getSelectedIndex()==0||txtMovimientosAño.getText().toString().isEmpty()||txtMovimientosDia.getText().toString().isEmpty()||txtMovimientosMes.getText().toString().isEmpty()){
					
					
					JOptionPane.showMessageDialog(null, "Porfavor ingrese los Datos Solicitados ", "Error", JOptionPane.ERROR_MESSAGE);
				
				
				}
				else
				{
				
					movimiento.setDescripcion_movimiento(descripcion_movimiento);
					movimiento.setCantidad_movimiento(cantidad_movimiento);
					movimiento.setFecha_movimiento(fecha_movimiento);
					movimiento.setPk_cuenta(pk_cuenta);
					movimiento.setPk_subrubro(pk_subrubro);
					movimiento.setPk_movimiento(pk_movimiento);
					
				
					
					movimiento.modificarMovimiento(conexion.conectar());
					
					
					LimpiarMovimiento();
				
				}
		
			}
		});
		btnMovimientosModificar.setBounds(136, 272, 89, 23);
		layeredPane_1.add(btnMovimientosModificar);
		
		
		cmbMovimientosSubrubro.removeAllItems();
		cmbMovimientosSubrubro.addItem("-----");
		
		
		
		cmbMovimientosCuenta.removeAllItems();
		cmbMovimientosCuenta.addItem("-----");
		
		layeredPane_2 = new JLayeredPane();
		tabbedPane.addTab("5-Traspasos", null, layeredPane_2, null);
		layeredPane_2.setLayout(null);
		
		JLabel label = new JLabel("Saldo    $");
		label.setBounds(49, 39, 64, 27);
		layeredPane_2.add(label);
		
		txtTraspasosSaldo = new JTextField();
		txtTraspasosSaldo.setBounds(102, 42, 86, 20);
		layeredPane_2.add(txtTraspasosSaldo);
		txtTraspasosSaldo.setColumns(10);
		
		cmbTraspasosOrigen = new JComboBox();
		cmbTraspasosOrigen.setBounds(73, 93, 124, 20);
		cmbTraspasosOrigen.setModel(new DefaultComboBoxModel(new String[] {"-----"}));
		layeredPane_2.add(cmbTraspasosOrigen);
		
		cmbTraspasosDestino = new JComboBox();
		cmbTraspasosDestino.setBounds(73, 126, 124, 20);
		cmbTraspasosDestino.setModel(new DefaultComboBoxModel(new String[] {"-----"}));
		layeredPane_2.add(cmbTraspasosDestino);
		
		JLabel label_2 = new JLabel("Origen");
		label_2.setBounds(28, 93, 64, 20);
		layeredPane_2.add(label_2);
		
		JLabel label_3 = new JLabel("Destino");
		label_3.setBounds(28, 126, 64, 20);
		layeredPane_2.add(label_3);
		
		btnTraspasosGuardar = new JButton("Guardar");
		btnTraspasosGuardar.setEnabled(false);
		btnTraspasosGuardar.setBounds(136, 272, 89, 23);
		layeredPane_2.add(btnTraspasosGuardar);
		
		btnTraspasosNuevo = new JButton("Nuevo");
		btnTraspasosNuevo.setBounds(136, 238, 89, 23);
		layeredPane_2.add(btnTraspasosNuevo);
		
		btnTraspasoBuscar = new JButton("Buscar");
		btnTraspasoBuscar.setBounds(136, 204, 89, 23);
		layeredPane_2.add(btnTraspasoBuscar);
		
		btnTraspasoCancelar = new JButton("Cancelar");
		btnTraspasoCancelar.setVisible(false);
		btnTraspasoCancelar.setBounds(24, 204, 89, 23);
		layeredPane_2.add(btnTraspasoCancelar);
		
		btnTraspasosEliminar = new JButton("Eliminar");
		btnTraspasosEliminar.setEnabled(false);
		btnTraspasosEliminar.setBounds(28, 272, 89, 23);
		layeredPane_2.add(btnTraspasosEliminar);
		
		btnTraspasosModificar = new JButton("Modificar");
		btnTraspasosModificar.setBounds(136, 272, 89, 23);
		layeredPane_2.add(btnTraspasosModificar);
		
		JLayeredPane layeredPane_4 = new JLayeredPane();
		tabbedPane.addTab("6-Gr\u00E1ficos", null, layeredPane_4, null);
		layeredPane_4.setLayout(null);
		
		JButton btnGraficarPorRubro = new JButton("Rubro");
		btnGraficarPorRubro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				graficaRubro=new GraficarRubro();
				graficaRubro.setVisible(true);
				
			}
		});
		btnGraficarPorRubro.setBounds(136, 44, 89, 23);
		layeredPane_4.add(btnGraficarPorRubro);
		
		chckbxEntradas = new JCheckBox("Entradas");
		chckbxEntradas.setBounds(33, 29, 97, 23);
		layeredPane_4.add(chckbxEntradas);
		
		checkBox = new JCheckBox("Salidas");
		checkBox.setBounds(33, 56, 97, 23);
		layeredPane_4.add(checkBox);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 99, 215, 2);
		layeredPane_4.add(separator);
		
		
		
		cmbSubrubroRubro.removeAllItems();
		cmbSubrubroRubro.addItem("-----");
		rubro.AgregarRubroComboBox(conexion.conectar());
		int i=0;
		while(rubro.listaRubros.size()!=i){
		cmbSubrubroRubro.addItem(rubro.listaRubros.get(i));
		i++;
		}
		rubro.listaRubros.clear();
		subrubro.AgregarSubrubroComboBox(conexion.conectar());
		 i=0;
		while(subrubro.listaSubrubros.size()!=i){
		cmbMovimientosSubrubro.addItem(subrubro.listaSubrubros.get(i));
		i++;
		}
		subrubro.listaSubrubros.clear();
		cuenta.AgregarSugerenciaCuenta(conexion.conectar());
		 i=0;
		while(cuenta.listaCuentas.size()!=i){
		cmbMovimientosCuenta.addItem(cuenta.listaCuentas.get(i));
		i++;
		}
		cuenta.listaCuentas.clear();
		
		
		
		/*************************************************************************************************************
		 *******************************************Metodo para autocompletar*****************************************
		 *************************************************************************************************************/
		
		AutoCompletarCuenta.removeAllItems();
		cuenta.AgregarSugerenciaCuenta(conexion.conectar());
		AutoCompletarCuenta.addItems(cuenta.listaCuentas);
		

		
		AutoCompletarRubro.removeAllItems();
		rubro.AgregarSugerenciaRubro(conexion.conectar());
		AutoCompletarRubro.addItems(rubro.listaRubros);
		
		
		
		AutoCompletarSubrubro.removeAllItems();
		subrubro.AgregarSugerenciaSubrubro(conexion.conectar());
		AutoCompletarSubrubro.addItems(subrubro.listaSubrubros);
		
		AutoCompletarMovimiento.removeAllItems();
		movimiento. AgregarSugerenciaMovimiento(conexion.conectar());
		AutoCompletarMovimiento.addItems(movimiento.listaMovimientos);
		System.out.println(movimiento.listaMovimientos+" lista movimientos");
	}
	
	
	
	
	
	/*************************************************************************************************************
	 *******************************************Metodos FUERA DE CODIGO PRINCIPAL*********************************
	 *************************************************************************************************************/
	
	
	
	
	
	
	
	public void LimpiarCuenta(){
		
		txtNombre.setText("");
		txtSaldo.setText("");
		
		btnBuscar_1.setVisible(true);
		btnNuevo.setVisible(true);
		btnGuardar.setEnabled(false);
		btnLimpiar.setVisible(false);
		btnModificar.setVisible(false);
		btnGuardar.setVisible(true);
		btnNuevo.setEnabled(true);
		btnBuscar_1.setEnabled(true);
		btnEliminar.setEnabled(false);
		txtSaldo.setEnabled(false);
		
		cuenta.setPk_cuenta(0);
		
		AutoCompletarCuenta.removeAllItems();
		cuenta.listaCuentas.clear();
		cuenta.AgregarSugerenciaCuenta(conexion.conectar());
		AutoCompletarCuenta.addItems(cuenta.listaCuentas);
		
		
	}
	
public void LimpiarRubro(){
		
		txtRubroDescripcion.setText("");
		rdbtnEntradaRubro.setSelected(false);
		rdbtnSalidaRubro.setSelected(false);
		
		rdbtnEntradaRubro.setEnabled(false);
		rdbtnSalidaRubro.setEnabled(false);
		
		btnRubroBuscar.setVisible(true);
		btnRubroNuevo.setVisible(true);
		btnRubroGuardar.setEnabled(false);
		btnRubroCancelar.setVisible(false);
		btnRubroModificar.setVisible(false);
		btnRubroGuardar.setVisible(true);
		btnRubroNuevo.setEnabled(true);
		btnRubroBuscar.setEnabled(true);
		btnRubroEliminar.setEnabled(false);
		
		rubro.setPk_rubro(0);
		
		AutoCompletarRubro.removeAllItems();
		rubro.listaRubros.clear();
		rubro.AgregarSugerenciaRubro(conexion.conectar());
		AutoCompletarRubro.addItems(rubro.listaRubros);
		
		cmbSubrubroRubro.removeAllItems();
		cmbSubrubroRubro.addItem("-----");
		rubro.listaRubros.clear();
		rubro.AgregarRubroComboBox(conexion.conectar());
		int i=0;
		while(rubro.listaRubros.size()!=i){
		cmbSubrubroRubro.addItem(rubro.listaRubros.get(i));
		i++;
		}
		
	}

public void LimpiarSubrubro(){
	
	txtSubrubroDescripcion.setText("");
	cmbSubrubroRubro.setSelectedIndex(0);
	cmbSubrubroRubro.setEnabled(false);
	
	btnSubrubroBuscar.setVisible(true);
	btnSubrubroNuevo.setVisible(true);
	btnSubrubroGuardar.setEnabled(false);
	btnSubrubroCancelar.setVisible(false);
	btnSubrubroModificar.setVisible(false);
	btnSubrubroGuardar.setVisible(true);
	btnSubrubroNuevo.setEnabled(true);
	btnSubrubroBuscar.setEnabled(true);
	btnSubrubroEliminar.setEnabled(false);
	
	subrubro.setPk_subrubro(0);
	
	AutoCompletarSubrubro.removeAllItems();
	subrubro.listaSubrubros.clear();
	subrubro.AgregarSugerenciaSubrubro(conexion.conectar());
	AutoCompletarSubrubro.addItems(subrubro.listaSubrubros);
	
	cmbMovimientosSubrubro.removeAllItems();
	cmbMovimientosSubrubro.addItem("-----");
	subrubro.AgregarSubrubroComboBox(conexion.conectar());
	 int i=0;
	while(subrubro.listaSubrubros.size()!=i){
	cmbMovimientosSubrubro.addItem(subrubro.listaSubrubros.get(i));
	i++;
	}
	subrubro.listaSubrubros.clear();
	
	cmbMovimientosCuenta.removeAllItems();
	cmbMovimientosCuenta.addItem("-----");
	cuenta.AgregarSugerenciaCuenta(conexion.conectar());
	 i=0;
	while(cuenta.listaCuentas.size()!=i){
	cmbMovimientosCuenta.addItem(cuenta.listaCuentas.get(i));
	i++;
	}
	cuenta.listaCuentas.clear();
}

public void LimpiarMovimiento(){
	
	txtMovimientoDescripcion.setText("");
	txtMovimientoCantidad.setText("");
	txtMovimientosAño.setText("");
	txtMovimientosDia.setText("");
	txtMovimientosMes.setText("");
		
	btnMovimientosBuscar.setVisible(true);
	btnMovimientosNuevo.setVisible(true);
	btnMovimientosGuardar.setEnabled(false);
	btnMovimientosCancelar.setVisible(false);
	btnMovimientosModificar.setVisible(false);
	btnMovimientosGuardar.setVisible(true);
	btnMovimientosNuevo.setEnabled(true);
	btnMovimientosBuscar.setEnabled(true);
	btnMovimientosEliminar.setEnabled(false);
	btnMovimientosHoy.setEnabled(false);
	
	txtMovimientoCantidad.setEnabled(false);
	txtMovimientosAño.setEnabled(false);
	txtMovimientosDia.setEnabled(false);
	txtMovimientosMes.setEnabled(false);
	
	cmbMovimientosCuenta.setEnabled(false);
	cmbMovimientosSubrubro.setEnabled(false);
	
	cmbMovimientosCuenta.setSelectedIndex(0);
	cmbMovimientosSubrubro.setSelectedIndex(0);
	
	movimiento.setPk_movimiento(0);
	
	AutoCompletarMovimiento.removeAllItems();
	movimiento.listaMovimientos.clear();
	movimiento.AgregarSugerenciaMovimiento(conexion.conectar());
	AutoCompletarMovimiento.addItems(movimiento.listaMovimientos);

}


public void LimpiarTraspaso(){
	
	txtTraspasosSaldo.setText("");
	
	
	btnTraspasoBuscar.setVisible(true);
	btnTraspasosNuevo.setVisible(true);
	btnTraspasosGuardar.setEnabled(false);
	btnTraspasoCancelar.setVisible(false);
	btnTraspasosModificar.setVisible(false);
	btnTraspasosGuardar.setVisible(true);
	btnTraspasosNuevo.setEnabled(true);
	btnTraspasoBuscar.setEnabled(true);
	btnTraspasosEliminar.setEnabled(false);
	
	cuenta.setPk_cuenta(0);
	
	AutoCompletarCuenta.removeAllItems();
	cuenta.listaCuentas.clear();
	cuenta.AgregarSugerenciaCuenta(conexion.conectar());
	AutoCompletarCuenta.addItems(cuenta.listaCuentas);
	
	
}



}
