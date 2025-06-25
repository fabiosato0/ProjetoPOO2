/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.*;
import model.Carro;
import java.util.List;
import java.util.ArrayList;

public class ControladorCarro {

    static Connection conn = null;
    static String url = "jdbc:postgresql://localhost:5432/postgres";
    static String user = "postgres";
    static String senha = "utfpr";
    static String driver = "org.postgresql.Driver";

    public void inserir(Carro carro) {
        PreparedStatement ps = null;

        String sql1 = "INSERT INTO carro("
                + " car_idcarro,"
                + " car_placa,"
                + " car_modelo,"
                + " car_ano,"
                + " car_passageiross,"
                + " car_capacidade,"
                + " car_litros_tanque,"
                + " car_disponivel)"
                + " VALUES(?,?,?,?,?,?,?,?)";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, senha);
            ps = conn.prepareStatement(sql1);
            ps.setInt(1, carro.getIdCarro());
            ps.setString(2, carro.getPlaca());
            ps.setString(3, carro.getModelo());
            ps.setInt(4, carro.getAno());
            ps.setInt(5, carro.getPassageiro());
            ps.setFloat(6, carro.getCapacidade());
            ps.setFloat(7, carro.getLitros());
            ps.setBoolean(8, carro.isDisponivel());
            ps.execute();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Falha na conexao!");
        }
    }

    public void deletar(int idCarro) {
        PreparedStatement ps = null;
        String sql2 = "DELETE FROM carro WHERE car_idcarro = ?";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, senha);
            ps = conn.prepareStatement(sql2);
            ps.setInt(1, idCarro);
            ps.executeUpdate();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Falha na conexao!");
        }
    }

    public List<Carro> listarTodos() {
        PreparedStatement ps = null;
        String sql = "SELECT * FROM carro";

        List<Carro> carrosEncontrados = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(url, user, senha);
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Carro carro = new Carro();
                carro.setIdCarro(rs.getInt("car_idcarro"));
                carro.setPlaca(rs.getString("car_placa"));
                carro.setModelo(rs.getString("car_modelo"));
                carro.setAno(rs.getInt("car_ano"));
                carro.setPassageiro(rs.getInt("car_passageiross"));
                carro.setCapacidade(rs.getFloat("car_capacidade"));
                carro.setLitros(rs.getFloat("car_litros_tanque"));
                carro.setDisponivel(rs.getBoolean("car_disponivel"));
                carrosEncontrados.add(carro);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO ao listar carros!");

        }
        return carrosEncontrados;
    }

    public void modificar(Carro carro) {
        PreparedStatement ps = null;
        String sql3 = "UPDATE carro SET "
                + "car_placa = ?, "
                + "car_modelo = ?, "
                + "car_ano = ?, "
                + "car_passageiross = ?, "
                + "car_capacidade = ?, "
                + "car_litros_tanque = ?, "
                + "car_disponivel = ? "
                + "WHERE car_idcarro = ?";

        try {
            conn = DriverManager.getConnection(url, user, senha);
            ps = conn.prepareStatement(sql3);
            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getModelo());
            ps.setInt(3, carro.getAno());
            ps.setInt(4, carro.getPassageiro());
            ps.setFloat(5, carro.getCapacidade());
            ps.setFloat(6, carro.getLitros());
            ps.setBoolean(7, carro.isDisponivel());
            ps.setInt(8, carro.getIdCarro());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO ao modificar carro:");
        }
    }
}
