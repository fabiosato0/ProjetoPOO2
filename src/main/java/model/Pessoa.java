/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author fasat
 */
public abstract class Pessoa {
/*vc vai fazer conta com esse valor, se sim inteiro float. O resto não*/
    private String cpf;
    private String nome;
    private String telefone;	  
    private int idade;
    
    public Pessoa() {
        cpf = "";
        nome = "";
        telefone ="";
        idade = 0;        
    }

    public Pessoa(String cpf, String nome, String telefone, int idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
}
