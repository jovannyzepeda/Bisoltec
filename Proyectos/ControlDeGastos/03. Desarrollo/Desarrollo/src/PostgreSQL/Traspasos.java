package PostgreSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Traspasos {

public ArrayList<Object> listaTraspasos=new ArrayList<Object>();
	
	
	
	Conexion conexion1=new Conexion();
	Cuenta cuenta=new Cuenta();
	int pk_cuenta,fk_original,fk_destino,max;
	float saldo;
	
	
	ResultSet rst;
	
	//GETTERS AN SETTERS
	
	public int getPk_cuenta() {
	return pk_cuenta;
}

public void setPk_cuenta(int pk_cuenta) {
	this.pk_cuenta = pk_cuenta;
}

public int getFk_original() {
	return fk_original;
}

public void setFk_original(int fk_original) {
	this.fk_original = fk_original;
}

public int getFk_destino() {
	return fk_destino;
}

public void setFk_destino(int fk_destino) {
	this.fk_destino = fk_destino;
}

public float getSaldo() {
	return saldo;
}

public void setSaldo(float saldo) {
	this.saldo = saldo;
}
	
	//METODOS PARA BUSCAR, INSERTAR Y ELIMINAR
	
public void insertarTraspaso(Connection conexion){
    
    
    
    try {
        Statement stmtl=conexion.createStatement();
        stmtl.executeUpdate("insert into traspasos values('"+this.pk_cuenta+"','"+this.fk_original+"','"+this.saldo+"','"+this.fk_destino+"')");
        JOptionPane.showMessageDialog(null, "Su Traspaso se realizó con Exito");
        
        
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}

public int ultimoTraspaso(Connection conexion){
    try {
        try(Statement estatuto= conexion.createStatement()){
            
            //con executeQuery REALIZA LAS CONSULTAS ESPECIFICAS
            estatuto.executeQuery("SELECT max(pk_cuenta) FROM traspasos");

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


public void modificarTraspaso(Connection conn){
     try {
            try (Statement estatuto = conn.createStatement()) {
          estatuto.executeUpdate("UPDATE traspasos SET fk_original = '"+this.fk_original+"', saldo = '"+this.saldo+"', fk_destino = '"+this.fk_destino+"'where pk_cuenta ='"+this.pk_cuenta+"'");
          
          JOptionPane.showMessageDialog(null, "Traspaso Modificado");
            listaTraspasos.clear();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);;
            

        }
}


public void eliminarTraspaso(Connection conexion){
    
	
	try {
            try (Statement estatuto = conexion.createStatement()) {

              estatuto.executeUpdate("DELETE FROM traspasos WHERE pk_cuenta='" + this.pk_cuenta + "'");
              JOptionPane.showMessageDialog(null, "Su Traspaso ha sido eliminado");
              

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);;
        }
}


public void buscarTodosTraspaso(Connection conexion,DefaultTableModel modeloTraspasos){
	

	
    try {
        try(Statement estatuto= conexion.createStatement()){
            
            //con executeQuery REALIZA LAS CONSULTAS ESPECIFICAS
            
            
            estatuto.executeQuery("SELECT * FROM traspasos");
            
            
            rst=estatuto.getResultSet();
            
        
                
            while(rst.next()){
            	String origen = null,destino = null;
            	int fk_original=rst.getInt("fk_original"),fk_destino=rst.getInt("fk_destino");
            	
            	cuenta.setPk_cuenta(fk_original);
            	cuenta.buscarCuentaPorPK(conexion1.conectar());
            	origen=cuenta.getNombre_cuenta();
            	
            	cuenta.setPk_cuenta(fk_destino);
            	cuenta.buscarCuentaPorPK(conexion1.conectar());
            	destino=cuenta.getNombre_cuenta();
            	
            	modeloTraspasos.addRow(new Object[]{rst.getInt("pk_cuenta"),origen,destino,rst.getFloat("saldo")});	
                
            
            }
            
            
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Se ha provocado un error en Busqueda Traspaso "+e, "Error", JOptionPane.ERROR_MESSAGE);;
    }
    
}

public void AgregarSugerenciaTraspaso(Connection conexion){
   
	try {
        try(Statement estatuto= conexion.createStatement()){
            String nombre2;
            int i=0;
            //con executeQuery REALIZA LAS CONSULTAS ESPECIFICAS
            estatuto.executeQuery("SELECT * FROM traspasos");
            
            
            rst=estatuto.getResultSet();
            while(rst.next()){
                i++;
                nombre2=rst.getString("descripcion");
                listaTraspasos.add(nombre2);
            }
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);;
    }
}

public void buscarTraspaso(Connection conexion){
	

	
    try {
        try(Statement estatuto= conexion.createStatement()){
            
            //con executeQuery REALIZA LAS CONSULTAS ESPECIFICAS
            
            
            estatuto.executeQuery("SELECT * FROM traspasos WHERE Pk_cuenta="+this.pk_cuenta+";");
            
            
            rst=estatuto.getResultSet();
            
        
                
            while(rst.next()){
            	setFk_original(rst.getInt("fk_original"));
            	setFk_destino(rst.getInt("fk_destino"));
            	setSaldo(rst.getFloat("saldo"));
            
            }
            
            
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Se ha provocado un error en Busqueda Traspaso "+e, "Error", JOptionPane.ERROR_MESSAGE);;
    }
}
}
