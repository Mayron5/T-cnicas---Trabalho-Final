/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.util;

import javax.swing.JOptionPane;

/**
 *
 * @author Mayron
 */
public class Auxiliares {
    
    public static int JOptionConfirm(String titulo, String mensagem) {
        Object[] options = {"Confirmar", "Cancelar"};
        int opcao = JOptionPane.showOptionDialog(null, mensagem, titulo, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        return opcao;
    }
    
}
