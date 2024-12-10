package main;

import java.sql.*;

public class BDE{
    
    private static String url = "jdbc:postgresql://localhost:5432/Redes"; //local aonde meu BD está
    private static String user = "postgres";                            // usuário do BD
    private static String pass = "123";		                      //senha do BD 
    protected static Connection conexao = null;
    //Conecta ao BD
    public BDE(){
        if(conexao == null) conecta();
    }
    
    //Acessando Conexao ao BD
    
    protected static boolean conecta(){
	  try{
              conexao = DriverManager.getConnection(url,user, pass);
              return true;
          } catch(SQLException e){
              e.printStackTrace();
              return false;
          }
    }
    //Desconectando Conexao do BD
    public static boolean desconecta(){
        try{
            conexao.close();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
