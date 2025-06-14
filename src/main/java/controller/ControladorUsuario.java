/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.sql. *;
import model.Usuario;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author fasat
 */
public class ControladorUsuario {
    static Connection conn = null;
    static String url = "jdbc:postgresql://localhost:5432/NorthCars";
    static String user = "postgres";
    static String senha = "utfpr";
    static String driver = "org.postgresql.Driver";
    
    public void inserir(Usuario usuario){
        PreparedStatement ps = null;
        
        String sql1 = "INSERT INTO usuario(cpf,nome,telefone,idade,idCliente) VALUES(?,?,?,?,?)";
        
        try{ //bloco para conexao com BD
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,senha);
            ps = conn.prepareStatement(sql1);
            ps.setString(1, usuario.getCpf());
            ps.setString(2, usuario.getNome());
            ps.setString(3, usuario.getTelefone());
            ps.setInt(4,usuario.getIdade());
            ps.setInt(5, usuario.getIdCliente());
            ps.execute();
            ps.close();
            conn.close();
            
        }catch(Exception e){
            System.out.println("Falha na conexao!");
        }
    }
    
    public void deletar(int idCliente){
        PreparedStatement ps = null;
        
        String sql2 = "DELETE FROM usuario WHERE idcliente = ?";
        
        try{ //bloco para registro do driver
          Class.forName(driver);
          conn = DriverManager.getConnection(url,user,senha);
          ps = conn.prepareStatement(sql2);
          ps.setInt(1,idCliente);
          ps.executeUpdate();
          ps.close();
          conn.close();
          
        }catch(Exception e){
            System.out.println("Falha na conexao!");
        }
    }
    
    public List<Usuario> listarTodos() {
        // A query correta para buscar dados de usuário
        PreparedStatement ps = null;
        String sql = "SELECT * FROM usuario"; // Assumindo que a tabela é 'usuario'
        
        // Crie uma lista vazia para guardar os usuários encontrados
        List<Usuario> usuariosEncontrados = new ArrayList<>();

        // Use try-with-resources para garantir que a conexão e o statement fechem sozinhos
        try{   
             conn = DriverManager.getConnection(url, user, senha);
             ps = conn.prepareStatement(sql);
             // Para um SELECT, usamos executeQuery(), que retorna um ResultSet
             ResultSet rs = ps.executeQuery();

            // O loop while(rs.next()) percorre cada linha retornada pelo banco
            while (rs.next()) {
                // Para cada linha, crie um novo objeto Usuario
                Usuario usuario = new Usuario();

                // Preencha o objeto com os dados da linha atual
                // Use os nomes exatos das colunas do seu banco de dados
                usuario.setIdCliente(rs.getInt("idcliente")); // Supondo que você tenha um ID
                usuario.setCpf(rs.getString("cpf"));
                usuario.setNome(rs.getString("nome"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setIdade(rs.getInt("idade"));
                
                // Adicione o usuário preenchido à nossa lista
                usuariosEncontrados.add(usuario);
            }

        } catch (Exception e) {
            System.out.println("ERRO ao listar usuários!");
        
        }
        return usuariosEncontrados;
    }
}
    
 

