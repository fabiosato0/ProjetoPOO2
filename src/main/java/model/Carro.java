/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author fasat
 */
public class Carro {
    private String placa;
    private String modelo;
    private boolean disponivel;
    private int ano;
    private int passageiro;
    private float capacidade;
    private float litros;

    public Carro(){
        placa = "";
        modelo = "";
        disponivel = false;
        ano = 0;
        passageiro = 0;
        capacidade = 0;
        litros = 0;
    }
    
    public Carro(String placa, String modelo, boolean disponivel, int ano, int passageiro, float capacidade, float litros) {
        this.placa = placa;
        this.modelo = modelo;
        this.disponivel = disponivel;
        this.ano = ano;
        this.passageiro = passageiro;
        this.capacidade = capacidade;
        this.litros = litros;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(int passageiro) {
        this.passageiro = passageiro;
    }

    public float getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(float capacidade) {
        this.capacidade = capacidade;
    }

    public float getLitros() {
        return litros;
    }

    public void setLitros(float litros) {
        this.litros = litros;
    }
    
}
