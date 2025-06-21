/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author fasat
 */
public class Pagamento {
    
    private final float precobase = (float) 340.0;
    
    public float calcLocacao(Carro carro) {
        float precoFinal = precobase;

        // Fator de ano do carro
        int anoAtual = java.time.Year.now().getValue();
        int idadeCarro = anoAtual - carro.getAno();
        
        if (idadeCarro <= 2) {
            precoFinal *= 1.20f; // +20% se for muito novo
        } else if (idadeCarro > 10) {
            precoFinal *= 0.85f; // -15% se for muito antigo
        }

        // Fator Capacidade de Litros 
        if (carro.getLitros() > 10.0f) {
            precoFinal *= 1.15f; // +15% se gastar mais de 10L/km
        }

        // Fator Passageiros
        if (carro.getPassageiro() > 4) {
            precoFinal *= 1.25f; // +25% para SUVs ou vans
        }

        // Fator Modelo
        if (carro.getModelo().toLowerCase().contains("bmw") || 
            carro.getModelo().toLowerCase().contains("mercedes")) {
            precoFinal *= 1.5f; // +50% para carros de luxo
        }

        return precoFinal;
        
        
    }
}
