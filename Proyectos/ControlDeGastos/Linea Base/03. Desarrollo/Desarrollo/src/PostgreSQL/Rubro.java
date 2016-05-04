package PostgreSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Rubro {

public ArrayList<Object> listaRubros=new ArrayList<Object>();
	
	
	int pk_rubro,max;
	String descripcion_rubro,tipoMovimiento_rubro;
	
	
	
	ResultSet rst;
	
	//GETTERS AN SETTERS
	public int getPk_rubro() {
		return pk_rubro;
	}

	public void setPk_rubro(int pk_rubro) {
		this.pk_rubro = pk_rubro;
	}

	public String getDescripcion_rubro() {
		return descripcion_rubro;
	}

	public void setDescripcion_rubro(String descripcion_rubro) {
		this.descripcion_rubro = descripcion_rubro;
	}

	public String getTipoMovimiento_rubro() {
		return tipoMovimiento_rubro;
	}

	public void setTipoMovimiento_rubro(String tipoMovimiento_rubro) {
		this.tipoMovimiento_rubro = tipoMovimiento_rubro;
	}
	
	//METODOS PARA BUSCAR, INSERTAR Y ELIMINAR
	
	public void insertarRubro(Connection conexion){
		
		
		
		try {
			Statement stmtl=conexion.createStatement();
			stmtl.executeUpdate("insert into rubro values('"+this.pk_rubro+"','"+this.descripcion_rubro+"','"+this.tipoMovimiento_rubro+"')");
			JOptionPane.showMessageDialog(null, "Su Rubro ha sido Creado");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public int ultimoRubro(Connection conexion){
		try {
			try(Statement estatuto= conexion.createStatement()){
				
				//con executeQuery REALIZA LAS CONSULTAS ESPECIFICAS
				estatuto.executeQuery("SELECT max(PK_rubro) FROM rubro");

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
	
	
	public void modificarRubro(Connection conexion){
		 try {
	            try (Statement estatuto = conexion.createStatement()) {
	          estatuto.executeUpdate("UPDATE rubro SET descripcion ='"+this.descripcion_rubro+"', tipoMovimiento = '"+this.tipoMovimiento_rubro+"' WHERE PK_rubro = '"+this.pk_rubro+"'");
	          
	          JOptionPane.showMessageDialog(null, "Rubro Modificado");
				listaRubros.clear();
	            }
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);;
	    		

	        }
	}
	
	
	public void eliminarRubro(Connection conexion){
		 try {
	            try (Statement estatuto = conexion.createStatement()) {

	              estatuto.executeUpdate("DELETE FROM rubro WHERE PK_rubro='" + this.pk_rubro + "'");
	              JOptionPane.showMessageDialog(null, "Su Rubro ha sido eliminado");
	              

	            }
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);;
	        }
	}
	
	
public void buscarRubro(Connection conexion){
		
		try {
			try(Statement estatuto= conexion.createStatement()){
				
				//con executeQuery REALIZA LAS CONSULTAS ESPECIFICAS
				
				
				estatuto.executeQuery("SELECT * FROM rubro WHERE descripcion='"+this.descripcion_rubro+"'");
				
				
				rst=estatuto.getResultSet();
				
			
					
				while(rst.next()){
					
					setDescripcion_rubro(rst.getString("descripcion"));
					setPk_rubro(rst.getInt("PK_rubro"));
					setTipoMovimiento_rubro(rst.getString("tipoMovimiento"));
				}
				
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);;
		}
		
	}
	
	public void AgregarSugerenciaRubro(Connection conexion){
		try {
			try(Statement estatuto= conexion.createStatement()){
				String nombre2;
				int i=0;
				//con executeQuery REALIZA LAS CONSULTAS ESPECIFICAS
				estatuto.executeQuery("SELECT * FROM rubro;");
				
				
				rst=estatuto.getResultSet();
				while(rst.next()){
					i++;
					nombre2=rst.getString("descripcion");
					listaRubros.add(nombre2);
				}
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);;
		}
	}

		
	public void AgregarRubroComboBox(Connection conexion){
		try {
			try(Statement estatuto= conexion.createStatement()){
				String nombre2;
				int i=0;
				//con executeQuery REALIZA LAS CONSULTAS ESPECIFICAS
				estatuto.executeQuery("SELECT * FROM rubro;");
				
				
				rst=estatuto.getResultSet();
				while(rst.next()){
					i++;
					nombre2=rst.getString("descripcion");
					listaRubros.add(nombre2);
				}
				
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);;
		}
	}

	
	
public void buscarRubroPorPK(Connection conexion){
		
		try {
			try(Statement estatuto= conexion.createStatement()){
				
				//con executeQuery REALIZA LAS CONSULTAS ESPECIFICAS
				
				
				estatuto.executeQuery("SELECT * FROM rubro WHERE PK_rubro='"+this.pk_rubro+"'");
				
				
				rst=estatuto.getResultSet();
				
			
					
				while(rst.next()){
					
					setDescripcion_rubro(rst.getString("descripcion"));
					setPk_rubro(rst.getInt("PK_rubro"));
					setTipoMovimiento_rubro(rst.getString("tipoMovimiento"));
				}
				
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);;
		}
		
	}
	
}
