/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.sql. *;
import model.Admin; // Trocado de Usuario para Admin
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author fasat
 */
public class ControladorAdmin { // Trocado de ControladorUsuario para ControladorAdmin
    static Connection conn = null;
    static String url = "jdbc:postgresql://localhost:5432/NorthCars";
    static String user = "postgres";
    static String senha = "utfpr";
    static String driver = "org.postgresql.Driver";

    public void inserir(Admin admin){ // Trocado de Usuario para Admin
        PreparedStatement ps = null;

        String sql1 = "INSERT INTO admin(cpf,nome,telefone,idade,idadmin) VALUES(?,?,?,?,?)"; // Trocado 'usuario' e 'idCliente'

        try{ //bloco para conexao com BD
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,senha);
            ps = conn.prepareStatement(sql1);
            ps.setString(1, admin.getCpf());
            ps.setString(2, admin.getNome());
            ps.setString(3, admin.getTelefone());
            ps.setInt(4,admin.getIdade());
            ps.setInt(5, admin.getIdAdmin()); // Supondo que o método seja getIdAdmin
            ps.execute();
            ps.close();
            conn.close();

        }catch(Exception e){
            System.out.println("Falha na conexao!");
        }
    }

    public void deletar(int idAdmin){ // Trocado de idCliente para idAdmin
        PreparedStatement ps = null;

        String sql2 = "DELETE FROM admin WHERE idadmin = ?"; // Trocado 'usuario' e 'idcliente'

        try{ //bloco para registro do driver
          Class.forName(driver);
          conn = DriverManager.getConnection(url,user,senha);
          ps = conn.prepareStatement(sql2);
          ps.setInt(1,idAdmin);
          ps.executeUpdate();
          ps.close();
          conn.close();

        }catch(Exception e){
            System.out.println("Falha na conexao!");
        }
    }

    public List<Admin> listarTodos() { // Trocado de Usuario para Admin
        // A query correta para buscar dados de admin
        PreparedStatement ps = null;
        String sql = "SELECT * FROM admin"; // Assumindo que a tabela é 'admin'

        // Crie uma lista vazia para guardar os admins encontrados
        List<Admin> adminsEncontrados = new ArrayList<>(); // Trocado

        // Use try-with-resources para garantir que a conexão e o statement fechem sozinhos
        try{
            conn = DriverManager.getConnection(url, user, senha);
            ps = conn.prepareStatement(sql);
            // Para um SELECT, usamos executeQuery(), que retorna um ResultSet
            ResultSet rs = ps.executeQuery();

            // O loop while(rs.next()) percorre cada linha retornada pelo banco
            while (rs.next()) {
                // Para cada linha, crie um novo objeto Admin
                Admin admin = new Admin(); // Trocado

                // Preencha o objeto com os dados da linha atual
                // Use os nomes exatos das colunas do seu banco de dados
                admin.setIdAdmin(rs.getInt("idadmin")); // Supondo que você tenha um ID de admin
                admin.setCpf(rs.getString("cpf"));
                admin.setNome(rs.getString("nome"));
                admin.setTelefone(rs.getString("telefone"));
                admin.setIdade(rs.getInt("idade"));

                // Adicione o admin preenchido à nossa lista
                adminsEncontrados.add(admin); // Trocado
            }

        } catch (Exception e) {
            System.out.println("ERRO ao listar admins!"); // Trocado

        }
        return adminsEncontrados;
    }

    public void modificar(Admin admin) { // Trocado de Usuario para Admin
    PreparedStatement ps = null;
    // O comando SQL UPDATE define quais colunas serão atualizadas
    // A cláusula WHERE é crucial para especificar QUAL registro será modificado
    String sql3 = "UPDATE admin SET nome = ?, cpf = ?, telefone = ?, idade = ? WHERE idadmin = ?"; // Trocado 'usuario' e 'idcliente'

    // Usando try-with-resources para garantir que a conexão feche automaticamente
    try{
        conn = DriverManager.getConnection(url, user, senha);
        ps = conn.prepareStatement(sql3);


        // Para um SELECT, usamos executeQuery(), que retorna um ResultSet


        // Agora, definimos os valores para cada '?' na ordem em que aparecem.
        // Parâmetros do SET
        ps.setString(1, admin.getNome());
        ps.setString(2, admin.getCpf());
        ps.setString(3, admin.getTelefone());
        ps.setInt(4, admin.getIdade());

        // Parâmetro do WHERE
        ps.setInt(5, admin.getIdAdmin()); // Supondo que o método seja getIdAdmin

        ps.executeUpdate();


    } catch (Exception e) {
        System.out.println("ERRO ao modificar admin:"); // Trocado
        // Imprimir o erro real ajuda muito a descobrir o que deu errado

    }
    }
}