package PostgreSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Movimiento {

public ArrayList<Object> listaMovimientos=new ArrayList<Object>();
	
	
	int pk_movimiento,max,pk_subrubro,pk_cuenta;
	String descripcion_movimiento,fecha_movimiento;
	float cantidad_movimiento;
	
	
	ResultSet rst;
	
	//GETTERS AN SETTERS
	public String getFecha_movimiento() {
		return fecha_movimiento;
	}

	public void setFecha_movimiento(String fecha_movimiento) {
		this.fecha_movimiento = fecha_movimiento;
	}
	public int getPk_movimiento() {
		return pk_movimiento;
	}

	public void setPk_movimiento(int pk_movimiento) {
		this.pk_movimiento = pk_movimiento;
	}

	public int getPk_subrubro() {
		return pk_subrubro;
	}

	public void setPk_subrubro(int pk_subrubro) {
		this.pk_subrubro = pk_subrubro;
	}

	public int getPk_cuenta() {
		return pk_cuenta;
	}

	public void setPk_cuenta(int pk_cuenta) {
		this.pk_cuenta = pk_cuenta;
	}

	public String getDescripcion_movimiento() {
		return descripcion_movimiento;
	}

	public void setDescripcion_movimiento(String descripcion_movimiento) {
		this.descripcion_movimiento = descripcion_movimiento;
	}

	public float getCantidad_movimiento() {
		return cantidad_movimiento;
	}

	public void setCantidad_movimiento(float cantidad_movimiento) {
		this.cantidad_movimiento = cantidad_movimiento;
	}
	
	//METODOS PARA BUSCAR, INSERTAR Y ELIMINAR
	
public void insertarMovimiento(Connection conexion){
		
		
		
		try {
			Statement stmtl=conexion.createStatement();
			stmtl.executeUpdate("insert into movimiento values('"+this.pk_movimiento+"','"+this.descripcion_movimiento+"','"+this.cantidad_movimiento+"','"+this.fecha_movimiento+"','"+this.pk_subrubro+"','"+this.pk_cuenta+"')");
			JOptionPane.showMessageDialog(null, "Su Movimiento ha sido Creado");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public int ultimoMovimiento(Connection conexion){
		try {
			try(Statement estatuto= conexion.createStatement()){
				
				//con executeQuery REALIZA LAS CONSULTAS ESPECIFICAS
				estatuto.executeQuery("SELECT max(pk_movimiento) FROM movimiento");

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
	
	
	public void modificarMovimiento(Connection conn){
		 try {
	            try (Statement estatuto = conn.createStatement()) {
	          estatuto.executeUpdate("UPDATE movimiento SET descripcion ='"+this.descripcion_movimiento+"', cantidad = '"+this.cantidad_movimiento+"', fecha = '"+this.fecha_movimiento+"', PK_subrubro = '"+this.pk_subrubro+"', PK_cuenta = '"+this.pk_cuenta+"' WHERE PK_movimiento = '"+this.pk_movimiento+"'");
	          
	          JOptionPane.showMessageDialog(null, "Movimiento Modificado");
				listaMovimientos.clear();
	            }
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);;
	    		

	        }
	}
	
	
	public void eliminarMovimiento(Connection conexion){
		 try {
	            try (Statement estatuto = conexion.createStatement()) {

	              estatuto.executeUpdate("DELETE FROM movimiento WHERE PK_movimiento='" + this.pk_movimiento + "'");
	              JOptionPane.showMessageDialog(null, "Su Movimiento ha sido eliminado");
	              

	            }
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);;
	        }
	}
	
	
public void buscarMovimiento(Connection conexion){
		
		try {
			try(Statement estatuto= conexion.createStatement()){
				
				//con executeQuery REALIZA LAS CONSULTAS ESPECIFICAS
				
				
				estatuto.executeQuery("SELECT * FROM movimiento WHERE descripcion='"+this.descripcion_movimiento+"'");
				
				
				rst=estatuto.getResultSet();
				
			
					
				while(rst.next()){
					
					setDescripcion_movimiento(rst.getString("descripcion"));
					setCantidad_movimiento(rst.getFloat("cantidad"));
					setFecha_movimiento(rst.getString("fecha"));
					setPk_subrubro(rst.getInt("Pk_subrubro"));
					setPk_cuenta(rst.getInt("PK_cuenta"));
					setPk_movimiento(rst.getInt("PK_movimiento"));
				}
				
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha provocado un error en Busqueda Movimiento "+e, "Error", JOptionPane.ERROR_MESSAGE);;
		}
		
	}
	
	public void AgregarSugerenciaMovimiento(Connection conexion){
		try {
			try(Statement estatuto= conexion.createStatement()){
				String nombre2;
				int i=0;
				//con executeQuery REALIZA LAS CONSULTAS ESPECIFICAS
				estatuto.executeQuery("SELECT * FROM movimiento");
				
				
				rst=estatuto.getResultSet();
				while(rst.next()){
					i++;
					nombre2=rst.getString("descripcion");
					listaMovimientos.add(nombre2);
				}
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);;
		}
	}
	
}
