/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pessoa;

/**
 *
 * @author Mayron
 */
public class PessoaControler {

    Pessoa usuarioLogado = new Pessoa();

    private static PessoaControler Controler;

    public int logar(String usuario, String senha) {

        FileReader fr = null;

        usuarioLogado.setEmail(usuario);
        usuarioLogado.setSenha(senha);

        try {
            fr = new FileReader("src/controler/usuarios.txt");
            BufferedReader br = new BufferedReader(fr);

            String linha;

            while ((linha = br.readLine()) != null) {
                String dados[] = linha.split(" ");

                if (dados[2].equals(usuarioLogado.getEmail()) && dados[3].equals(usuarioLogado.getSenha())) {
                    usuarioLogado.setId(Integer.parseInt(dados[0]));
                    return usuarioLogado.getId();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PessoaControler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PessoaControler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(PessoaControler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    public int novo_id() {
        FileReader fr = null;
        int novo_id = 1;

        try {
            fr = new FileReader("src/controler/usuarios.txt");
            BufferedReader br = new BufferedReader(fr);

            String dados;

            while ((dados = br.readLine()) != null) {
                novo_id++;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PessoaControler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PessoaControler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return novo_id++;
    }

    public boolean novo_usuario(String nome, String email, String senha, String genero) {

        BufferedWriter bw = null;
        try {
            int novo_id = this.novo_id();
            
            bw = new BufferedWriter(new FileWriter("src/controler/usuarios.txt", true));
            String linha = Integer.toString(novo_id) + " " + nome + " " + email + " " + senha + " " + genero;
            bw.write(linha);
            bw.newLine();
            
        } catch (IOException ex) {
            Logger.getLogger(PessoaControler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(PessoaControler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public static PessoaControler getInstance() {
        if (Controler == null) {
            Controler = new PessoaControler();
        }
        return Controler;
    }
}
