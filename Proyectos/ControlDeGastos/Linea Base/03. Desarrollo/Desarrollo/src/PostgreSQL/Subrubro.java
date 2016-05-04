package PostgreSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Subrubro {
	
	
public ArrayList<Object> listaSubrubros=new ArrayList<Object>();

	
	
	int pk_subrubro,max,pk_rubro;
	String descripcion_subrubro;
	
	
	
	ResultSet rst;
	
	//GETTERS AN SETTERS

	public int getPk_subrubro() {
		return pk_subrubro;
	}

	public void setPk_subrubro(int pk_subrubro) {
		this.pk_subrubro = pk_subrubro;
	}

	public int getPk_rubro() {
		return pk_rubro;
	}

	public void setPk_rubro(int pk_rubro) {
		this.pk_rubro = pk_rubro;
	}

	public String getDescripcion_subrubro() {
		return descripcion_subrubro;
	}

	public void setDescripcion_subrubro(String descripcion_subrubro) {
		this.descripcion_subrubro = descripcion_subrubro;
	}
	
	//METODOS PARA BUSCAR, INSERTAR Y ELIMINAR
	
	public void insertarSubrubro(Connection conexion){
		
		
		
		try {
			Statement stmtl=conexion.createStatement();
			stmtl.executeUpdate("insert into subrubro values('"+this.pk_subrubro+"','"+this.descripcion_subrubro+"','"+this.pk_rubro+"')");
			JOptionPane.showMessageDialog(null, "Su Subrubro ha sido Creado");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public int ultimoSubrubro(Connection conexion){
		try {
			try(Statement estatuto= conexion.createStatement()){
				
				//con executeQuery REALIZA LAS CONSULTAS ESPECIFICAS
				estatuto.executeQuery("SELECT max(PK_subrubro) FROM subrubro");

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
	
	
	public void modificarSubrubro(Connection conexion){
		 try {
	            try (Statement estatuto = conexion.createStatement()) {
	          estatuto.executeUpdate("UPDATE subrubro SET descripcion ='"+this.descripcion_subrubro+"', PK_rubro = '"+this.pk_rubro+"' WHERE PK_subrubro = '"+this.pk_subrubro+"'");
	          
	          JOptionPane.showMessageDialog(null, "Subrubro Modificado");
				listaSubrubros.clear();
	            }
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);;
	    		

	        }
	}
	
	
	public void eliminarSubrubro(Connection conexion){
		 try {
	            try (Statement estatuto = conexion.createStatement()) {

	              estatuto.executeUpdate("DELETE FROM subrubro WHERE PK_subrubro='" + this.pk_subrubro + "'");
	              JOptionPane.showMessageDialog(null, "Su Subrubro ha sido eliminado");
	              

	            }
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);;
	        }
	}
	
	
public void buscarSubrubro(Connection conexion){
		
		try {
			try(Statement estatuto= conexion.createStatement()){
				
				//con executeQuery REALIZA LAS CONSULTAS ESPECIFICAS
				
				
				estatuto.executeQuery("SELECT * FROM subrubro WHERE descripcion='"+this.descripcion_subrubro+"'");
				
				
				rst=estatuto.getResultSet();
				
			
					
				while(rst.next()){
					
					setDescripcion_subrubro(rst.getString("descripcion"));
					setPk_subrubro(rst.getInt("PK_subrubro"));
					setPk_rubro(rst.getInt("PK_rubro"));
				}
				
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha provocado un error e SUBRURBO "+e, "Error", JOptionPane.ERROR_MESSAGE);;
		}
		
	}
	
	public void AgregarSugerenciaSubrubro(Connection conexion){
		try {
			try(Statement estatuto= conexion.createStatement()){
				String nombre2;
				int i=0;
				//con executeQuery REALIZA LAS CONSULTAS ESPECIFICAS
				estatuto.executeQuery("SELECT * FROM subrubro;");
				
				
				rst=estatuto.getResultSet();
				while(rst.next()){
					i++;
					nombre2=rst.getString("descripcion");
					listaSubrubros.add(nombre2);
				}
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);;
		}
	}

	public int getPk_cuenta() {
		// TODO Auto-generated method stub
		return 0;
	}
	



public void AgregarSubrubroComboBox(Connection conexion){
	try {
		try(Statement estatuto= conexion.createStatement()){
			String nombre2;
			int i=0;
			//con executeQuery REALIZA LAS CONSULTAS ESPECIFICAS
			estatuto.executeQuery("SELECT * FROM subrubro;");
			
			
			rst=estatuto.getResultSet();
			while(rst.next()){
				i++;
				nombre2=rst.getString("descripcion");
				listaSubrubros.add(nombre2);
			}
			
			
		}
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);;
	}
}


public void buscarSubrubroPorPK(Connection conexion){
	
	try {
		try(Statement estatuto= conexion.createStatement()){
			
			//con executeQuery REALIZA LAS CONSULTAS ESPECIFICAS
			
			
			estatuto.executeQuery("SELECT * FROM subrubro WHERE PK_subrubro='"+this.pk_subrubro+"'");
			
			
			rst=estatuto.getResultSet();
			
		
				
			while(rst.next()){
				
				setDescripcion_subrubro(rst.getString("descripcion"));
				
				
			}
			
			
		}
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Se ha provocado un error en buscar por PK subrubro "+e, "Error", JOptionPane.ERROR_MESSAGE);;
	}
	
}
	
}
