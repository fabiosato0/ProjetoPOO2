/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author fasat
 */
public class Administrador extends Pessoa{
    	private int idAdmin;
    
    public Administrador(){
        super();
        idAdmin = 0;
    }

    public int getIdCliente() {
        return idAdmin;
    }

    public void setIdCliente(int idAdmin) {
        this.idAdmin = idAdmin;
    }

}