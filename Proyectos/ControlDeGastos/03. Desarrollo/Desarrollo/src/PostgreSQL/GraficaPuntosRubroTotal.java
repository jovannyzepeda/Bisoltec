package PostgreSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GraficaPuntosRubroTotal {

	public ArrayList<Object> listaMes=new ArrayList<Object>();
	public ArrayList<Object> listaCantidad=new ArrayList<Object>();	
		
	String fechaInicial,fechaFinal;	
		ResultSet rst;	
		
		
		


		
		//GETTERS AN SETTERS
		public String getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
		
		//METODOS PARA BUSCAR, INSERTAR Y ELIMINAR
		
		
		

		
		public void RecaudarDatos(Connection conexion){
			try {
				try(Statement estatuto= conexion.createStatement()){
					String descripcion;
					float cantidad;
					int i=0;
					
					//con executeQuery REALIZA LAS CONSULTAS ESPECIFICAS
					
					
					estatuto.executeQuery("select  date_part('month'::text,m.fecha)as mes , sum(m.cantidad) as cantidadSumada from rubro r, movimiento m, subrubro sr where m.PK_subrubro=sr.PK_subrubro and r.tipomovimiento='salida' and sr.PK_rubro=r.PK_rubro and m.fecha between '"+this.fechaInicial+"' and '"+this.fechaFinal+"' GROUP BY  date_part('month'::text,m.fecha) order by date_part('month'::text,m.fecha)");
					
					rst=estatuto.getResultSet();
					
					
					
					while(rst.next()){
						i++;
						descripcion=rst.getString("mes");
						listaMes.add(descripcion);
						
						cantidad=rst.getFloat("cantidadSumada");
						listaCantidad.add(cantidad);
						
					}
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Se ha provocado un error "+e, "Error", JOptionPane.ERROR_MESSAGE);;
			}
		}
	
}
