package modelo.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class ConexaoBD {

	// <<<<<< CONEXÃO COM O BD >>>>>>
	private Connection conexao;
			
	public boolean conecta() {
		
		try {

			String driverName="oracle.jdbc.OracleDriver";
			String driver = "jdbc:oracle:thin:";
			int port = 1521;
			String servidor = "localhost";
		    String banco = "xe";
		    String urlConexao = driver + "@//" + servidor +  ":" + port + "/" + banco;
		    //String urlConexao = driver + usuario + "/" + senha + "@//" + servidor +  ":" + port + "/" + banco;		    
		    String usuario = "system";
		    String senha = "1234";
		    
		    // registra o Driver
		    Class.forName(driverName);
     	      		    
		    // cria conexão no banco
		    this.conexao = DriverManager.getConnection(urlConexao,usuario, senha);
		    this.conexao.setAutoCommit(true);
	    
		    JOptionPane.showConfirmDialog(null, "conectado");
            return true;            	        
	    } 

        catch(SQLException e ) {       
		    JOptionPane.showConfirmDialog(null, "não conectado " + e );

	    	return false;
	    	
        }  catch (ClassNotFoundException e) {
        	JOptionPane.showConfirmDialog(null, "não conectado " + e );
			return false;
		}	
		
	}
	
		
	public PreparedStatement preparaDeclaracao(String sql) {
		
		PreparedStatement declaracaoPrep = null;
      
        // executa um comando DML (update ou insert)
		try 
		{
			JOptionPane.showMessageDialog(null, sql);
			declaracaoPrep = this.conexao.prepareStatement(sql);	
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return declaracaoPrep;
		
	}
	
	


	
	

	
		
		
	public ResultSet consulta(String sql) {
			
		ResultSet dbResultado = null;
		
		try {
			
			Statement declaracao = this.conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);			
			
			dbResultado = declaracao.executeQuery(sql);	
			
			if (dbResultado != null)
			    dbResultado.first();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return dbResultado;
     
	}
	
	
}
