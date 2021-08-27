/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import model.Carrinho;

/**
 *
 * @author Windows
 */
public class CarrinhoControler {
    
    Carrinho carrinhoCompras = new Carrinho();
    private static CarrinhoControler Controler;
    
    
    
    public static CarrinhoControler getInstance() {
        if (Controler == null) {
            Controler = new CarrinhoControler();
        }
        return Controler;
    }
}
