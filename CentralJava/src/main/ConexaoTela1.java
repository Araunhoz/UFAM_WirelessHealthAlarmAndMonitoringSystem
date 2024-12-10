
package main;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ConexaoTela1  extends BDE{
    String out;
	//Listagem de Aluguel
    public void listarTela1(String s){
   	 try{
                out = "";
   		Statement st = conexao.createStatement(); 
   		ResultSet rs = st.executeQuery("select * from Suphendrio" );
   		while(rs.next()){
                    String nome = rs.getString(1);
                    if (nome.equals(s)){
   			/*out = "NomePaciente: " +rs.getString(1)+ "\nNomeMedico:"+rs.getString(2)+
   					           "\nXbee: " +rs.getString(3)+"\nAlarme:"+rs.getInt(4)+"\nSensor1:"
   					+rs.getString(5)+"\nSensor2:"+rs.getString(6)+"";*/
                        
                        out = out + rs.getString(5)+"\n";
                     }
                    }
   		 
   	 }
   	 catch(SQLException e){}
    }
	

    // Adição de Categoria
    
    public boolean adicionarDado(NewSick.Paciente c){
   	 
   	 try{
   		 Statement st = conexao.createStatement();
   		 st.executeUpdate("insert into Suphendrio values ('" +c.nome+"',"
   		 		+ "  ' "+c.medico+" ', '"+c.xbee+
   		 		" ', '"+c.alarme+" ', '"+c.sensor1+" ', '"+c.sensor2+"') "); 
   				 	
   				 
   	  return true;	 
   	 
   	 } catch(Exception e){
   		 System.out.println(e.getMessage());
   		  return false;
   	 }
   	 finally {
	}
   	 
    }

    //Altera aluguel
    


}