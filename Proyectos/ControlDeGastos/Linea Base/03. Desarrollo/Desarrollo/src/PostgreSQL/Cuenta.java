package PostgreSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Cuenta {

	public ArrayList<Object> listaCuentas=new ArrayList<Object>();
	
	
	int pk_cuenta,max;
	String nombre_cuenta;
	float saldo;
	
	
	ResultSet rst;
	
	//GETTERS AN SETTERS
	public int getPk_cuenta() {
		return pk_cuenta;
	}
	public void setPk_cuenta(int pk_cuenta) {
		this.pk_cuenta = pk_cuenta;
	}
	public String getNombre_cuenta() {
		return nombre_cuenta;
	}
	public void setNombre_cuenta(String nombre_cuenta) {
		this.nombre_cuenta = nombre_cuenta;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	//METODOS PARA BUSCAR, INSERTAR Y ELIMINAR
	
	public void insertarCuenta(Connection conexion){
		
		
		
		try {
			Statement stmtl=conexion.createStatement();
			stmtl.executeUpdate("insert into cuenta values('"+this.pk_cuenta+"','"+this.nombre_cuenta+"','"+this.saldo+"')");
			JOptionPane.showMessageDialog(null, "Su Cuenta ha sido Creada");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public int ultimaCuenta(Connection conexion){
		try {
			try(Statement estatuto= conexion.createStatement()){
				
				//con executeQuery REALIZA LAS CONSULTAS ESPECIFICAS
				estatuto.executeQuery("SELECT max(pk_cuenta) FROM cuenta");

				rst=estatuto.getResultSet();
				int i=0;
				
				while(rst.next()){
					
					max=rst.getInt(1);
					
				}
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return max+1;
	}
	
	
	public void modificarCuenta(Connection conn){
		 try {
	            try (Statement estatuto = conn.createStatement()) {
	          estatuto.executeUpdate("UPDATE cuenta SET nombre ='"+this.nombre_cuenta+"', saldo = '"+this.saldo+"' WHERE PK_cuenta = '"+this.pk_cuenta+"'");
	          
	          JOptionPane.showMessageDialog(null, "Cuenta Modificada");
				listaCuentas.clear();
	            }
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);;
	    		

	        }
	}
	
	
	public void eliminarCuenta(Connection conexion){
		 try {
	            try (Statement estatuto = conexion.createStatement()) {

	              estatuto.executeUpdate("DELETE FROM cuenta WHERE PK_cuenta='" + this.pk_cuenta + "'");
	              JOptionPane.showMessageDialog(null, "Su Cuenta ha sido eliminada");
	              

	            }
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);;
	        }
	}
	
	
public void buscarCuenta(Connection conexion){
		
		try {
			try(Statement estatuto= conexion.createStatement()){
				
				//con executeQuery REALIZA LAS CONSULTAS ESPECIFICAS
				
				
				estatuto.executeQuery("SELECT * FROM cuenta WHERE nombre='"+this.nombre_cuenta+"'");
				
				
				rst=estatuto.getResultSet();
				
			
					
				while(rst.next()){
					
					setNombre_cuenta(rst.getString("nombre"));
					setPk_cuenta(rst.getInt("PK_cuenta"));
					setSaldo(rst.getFloat("saldo"));
				}
				
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha provocado un error EN cuenta "+e, "Error", JOptionPane.ERROR_MESSAGE);;
		}
		
	}
	
	public void AgregarSugerenciaCuenta(Connection conexion){
		try {
			try(Statement estatuto= conexion.createStatement()){
				String nombre2;
				int i=0;
				//con executeQuery REALIZA LAS CONSULTAS ESPECIFICAS
				estatuto.executeQuery("SELECT * FROM cuenta;");
				
				
				rst=estatuto.getResultSet();
				while(rst.next()){
					i++;
					nombre2=rst.getString("nombre");
					listaCuentas.add(nombre2);
				}
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);;
		}
	}
	
	
public void buscarCuentaPorPK(Connection conexion){
		
		try {
			try(Statement estatuto= conexion.createStatement()){
				
				//con executeQuery REALIZA LAS CONSULTAS ESPECIFICAS
				
				
				estatuto.executeQuery("SELECT * FROM cuenta WHERE PK_cuenta='"+this.pk_cuenta+"'");
				
				
				rst=estatuto.getResultSet();
				
			
					
				while(rst.next()){
					
					setNombre_cuenta(rst.getString("nombre"));
					setSaldo(Float.parseFloat(rst.getString("saldo")));
					
				}
				
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);;
		}
		
	}
	
}
