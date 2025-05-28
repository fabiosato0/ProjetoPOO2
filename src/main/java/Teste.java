

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import view.Principal; 
/**
 *
 * @author Aluno
 */
public class Teste {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new Principal().setVisible(true);
            }
        }
        );
    }

    
}