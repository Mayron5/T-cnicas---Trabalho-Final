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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

    public int logar(String usuario, String senha, boolean isAdmin) {

        FileReader fr = null;

        usuarioLogado.setEmail(usuario);
        usuarioLogado.setSenha(senha);

        try {

            if (isAdmin) {
                fr = new FileReader("src/controler/administradores.txt");
            } else {
                fr = new FileReader("src/controler/usuarios.txt");
            }

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

    public String novo_usuario(String nome, String email, String senha, String confirmacao, String genero) {

        nome = nome.replace(" ", "_");
        usuarioLogado.setNome(nome);
        usuarioLogado.setEmail(email);
        usuarioLogado.setSenha(senha);
        usuarioLogado.setGenero(genero);
        usuarioLogado.setId(this.novo_id());

        if (usuarioLogado.getNome().equals("") || usuarioLogado.getEmail().equals("") || usuarioLogado.getSenha().equals("")) {
            return "Preenchar todos os dados";
        }

        if (this.verificar_email(usuarioLogado.getEmail())) {
            return "O email informado já está cadastrado";
        }

        if (!this.verificar_senha(senha, confirmacao)) {
            return "As senhas devem ser iguais";
        }

        BufferedWriter bw = null;
        try {

            bw = new BufferedWriter(new FileWriter("src/controler/usuarios.txt", true));
            String linha = Integer.toString(usuarioLogado.getId()) + " " + usuarioLogado.getNome() + " " + usuarioLogado.getEmail() + " " + usuarioLogado.getSenha() + " " + usuarioLogado.getGenero();
            bw.write(linha);
            bw.newLine();
            return "Cadastrado com sucesso!";

        } catch (IOException ex) {
            Logger.getLogger(PessoaControler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(PessoaControler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "Não foi possível cadastrar, tente novamente";
    }

    public boolean verificar_email(String email) {

        FileReader fr = null;

        try {

            fr = new FileReader("src/controler/usuarios.txt");
            BufferedReader br = new BufferedReader(fr);

            String linha = null;

            while ((linha = br.readLine()) != null) {
                String dados[] = linha.split(" ");

                if (dados[2].equals(email)) {
                    return true;
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
        return false;
    }

    public boolean verificar_senha(String senha, String confirmacao) {
        if (senha.equals(confirmacao)) {
            return true;
        }
        return false;
    }

    public Pessoa dados_pessoa(int id_pessoa) {

        FileReader fr = null;

        usuarioLogado.setId(id_pessoa);

        try {

            fr = new FileReader("src/controler/usuarios.txt");
            BufferedReader br = new BufferedReader(fr);

            String linha;

            while ((linha = br.readLine()) != null) {

                String dados[] = linha.split(" ");
                if (Integer.parseInt(dados[0]) == usuarioLogado.getId()) {
                    usuarioLogado.setNome(dados[1]);
                    usuarioLogado.setEmail(dados[2]);
                    usuarioLogado.setSenha(dados[3]);
                    usuarioLogado.setGenero(dados[4]);
                }

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PessoaControler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PessoaControler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarioLogado;
    }

    public String retornar_nome(Pessoa dados) {
        return dados.getNome().replace("_", " ");
    }

    public String atualizar_pessoa(int id, String nome, String email, String senha, String genero) {
        
        nome = nome.replace(" ", "_");
        usuarioLogado.setNome(nome);
        usuarioLogado.setEmail(email);
        usuarioLogado.setSenha(senha);
        usuarioLogado.setGenero(genero);
        usuarioLogado.setId(id);

        if (usuarioLogado.getNome().equals("") || usuarioLogado.getEmail().equals("") || usuarioLogado.getSenha().equals("")) {
            return "Preenchar todos os dados";
        }


        BufferedReader br = null;
        FileReader fr = null;

        BufferedWriter bw = null;
        FileWriter fw = null;

        List infor = new ArrayList();

        try {

            fr = new FileReader("src/controler/usuarios.txt");
            br = new BufferedReader(fr);

            String linha;

            while ((linha = br.readLine()) != null) {
                String dados[] = linha.split(" ");
                if (dados[0].equals(Integer.toString(id))) {
                    linha = id + " " + nome + " " + email + " " + senha + " " + genero;
                }
                infor.add(linha);
            }
            fr.close();
            br.close();

            fw = new FileWriter("src/controler/usuarios.txt");
            bw = new BufferedWriter(fw);

            Iterator it = infor.iterator();
            Object element = null;

            while (it.hasNext()) {
                element = it.next();
                bw.write(element.toString());
                bw.newLine();
            }
            return "Atualizado com sucesso!";
        } catch (IOException ex) {
            Logger.getLogger(JogosControler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(JogosControler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "Não foi possível atualizar os dados";
    }

    public static PessoaControler getInstance() {
        if (Controler == null) {
            Controler = new PessoaControler();
        }
        return Controler;
    }
}
