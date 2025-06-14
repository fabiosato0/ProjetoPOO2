/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.sql. *;
import model.Carro;
import java.util.List;
import java.util.ArrayList;

public class ControladorCarro {
    static Connection conn = null;
    static String url = "jdbc:postgresql://localhost:5432/NorthCars";
    static String user = "postgres";
    static String senha = "utfpr";
    static String driver = "org.postgresql.Driver";
    
    public void inserir(Carro carro){
        PreparedStatement ps = null;
        
        String sql1 = "INSERT INTO carro("
                + " placa,"
                + " modelo,"
                + " ano,"
                + " passageiro,"
                + " capacidade,"
                + " litros)"
                + " VALUES(?,?,?,?,?,?)";
        
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,senha);
            ps = conn.prepareStatement(sql1);
            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getModelo());
            ps.setInt(3, carro.getAno());
            ps.setInt(4,carro.getPassageiro());
            ps.setFloat(5, carro.getCapacidade());
            ps.setFloat(6, carro.getLitros());
            ps.execute();
            ps.close();
            conn.close();
            
        }catch(Exception e){
            System.out.println("Falha na conexao!");
        }
    }
    
    public void deletar(int idCarro){
        PreparedStatement ps = null;
        String sql2 = "DELETE FROM carro WHERE idCarro = ?";
        
        try{
          Class.forName(driver);
          conn = DriverManager.getConnection(url,user,senha);
          ps = conn.prepareStatement(sql2);
          ps.setInt(1,idCarro);
          ps.executeUpdate();
          ps.close();
          conn.close();
          
        }catch(Exception e){
            System.out.println("Falha na conexao!");
        }
    }
    
    public List<Carro> listarTodos() {
        PreparedStatement ps = null;
        String sql = "SELECT * FROM carro";
        
        List<Carro> carrosEncontrados = new ArrayList<>();

        try{   
             conn = DriverManager.getConnection(url, user, senha);
             ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Carro carro = new Carro();
                carro.setPlaca(rs.getString("placa"));
                carro.setModelo(rs.getString("modelo"));
                carro.setAno(rs.getInt("ano"));
                carro.setPassageiro(rs.getInt("passageiro"));
                carro.setCapacidade(rs.getFloat("capacidade"));
                carro.setLitros(rs.getFloat("litros"));
                carrosEncontrados.add(carro);
            }

        } catch (Exception e) {
            System.out.println("ERRO ao listar carros!");
        
        }
        return carrosEncontrados;
    }
    
    public void modificar(Carro carro) {
    PreparedStatement ps = null;
    String sql3 = "UPDATE carro SET"
            + "placa = ?, "
            + "modelo = ?, "
            + "disponivel = ?, "
            + "ano = ?, "
            + "passageiro = ?, "
            + "capacidade = ?, "
            + "litros = ? "
            + "WHERE idCarro = ?";

    try{   
             conn = DriverManager.getConnection(url, user, senha);
            ps = conn.prepareStatement(sql3);
            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getModelo());
            ps.setInt(3, carro.getAno());
            ps.setInt(4,carro.getPassageiro());
            ps.setFloat(5, carro.getCapacidade());
            ps.setFloat(6, carro.getLitros());
            ps.executeUpdate();

    } catch (Exception e) {
        System.out.println("ERRO ao modificar carro:");
    }
    }
}