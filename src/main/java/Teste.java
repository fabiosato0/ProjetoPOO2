

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import view.Principal; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Aluno
 */
public class Teste {
     public static void main(String[] args){
      java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new Principal().setVisible(true);
            }
        }
        );
     }
    /*
    static Connection conn = null;
    static String url = "jdbc:postgresql://localhost:5432/NorthCars";
    static String user = "postgres";
    static String senha = "utfpr";
    static String driver = "org.postgresql.Driver";
    
    public static void main(String[] args) {
        Statement st = null;
        String sql1 = "CREATE TABLE cliente("
                        + "id int primary key not null,"
                        + "nome text," 
                        + "email text)";
          
        
        
      

        try{ //bloco para registro do driver
            System.out.println("Carregando o driver...");
            Class.forName(driver);
            System.out.println("Driver carregado com sucesso!");
        }catch(Exception e){
            System.out.println("Falha na conexao!");
        }
        try{ //bloco para conexao com BD
            System.out.println("Conectando ao BD...");
            conn = DriverManager.getConnection(url,user,senha);
            System.out.println("Banco conectado com sucesso!");
            
            st = conn.createStatement();
            st.executeUpdate(sql1);
            System.out.println("Tabela criada com sucesso!");
            st.close();
            conn.close();
            
        }catch(Exception e){
            System.out.println("Falha na conexao!");
        }
        
        String sql2 = "INSERT INTO cliente VALUES(1,'Gisele', 'gi@utfpr.edu.br')";
        
        try{ //bloco para registro do driver
            System.out.println("Carregando o driver...");
            Class.forName(driver);
            System.out.println("Driver carregado com sucesso!");
        }catch(Exception e){
            System.out.println("Falha na conexao!");
        }
        try{ //bloco para conexao com BD
            
            conn = DriverManager.getConnection(url,user,senha);
            System.out.println("Inserindo dados....");
            st = conn.createStatement();
            st.executeUpdate(sql2);
            System.out.println("Dados inseridos com sucesso!");
            st.close();
            conn.close();
            
        }catch(Exception e){
            System.out.println("Falha na conexao!");
        }
      
/*
        String sql3 = "SELECT * FROM cliente";
        ResultSet rs = null;
        
        try{ //bloco para registro do driver
          Class.forName(driver);
          conn = DriverManager.getConnection(url,user,senha);
          st = conn.createStatement();
          rs = st.executeQuery(sql3);
          while(rs.next()){
              System.out.println("ID = "+rs.getInt(1));
              System.out.println("Nome = "+rs.getString(2));
              System.out.println("Email = "+rs.getString(3));
              
          }
          rs.close();
          st.close();
          conn.close();
        }catch(Exception e){
            System.out.println("Falha na conexao!");
        }
 */       

/*
        String sql4 = "DELETE FROM cliente WHERE id = 2";
        
        try{ //bloco para registro do driver
          Class.forName(driver);
          conn = DriverManager.getConnection(url,user,senha);
          st = conn.createStatement();
          st.executeUpdate(sql4);
          System.out.println("Excluido com sucesso");
          st.close();
          conn.close();
          
        }catch(Exception e){
            System.out.println("Falha na conexao!");
        }
       */ 
                
        ResultSet rs = null;
        /*
        String sql6 = "UPTADE Carro set Car_ano = 2012  WHERE Car_placa = {1}";
        
        try{ //alteração de dados de 1 registro
          Class.forName(driver);
          conn = DriverManager.getConnection(url,user,senha);
          st = conn.createStatement();
          st.executeUpdate(sql6);
          st.close();
          conn.close();
        }catch(Exception e){
            System.out.println("Falha na conexao!");
        }
        
    }   
*/
}


    





