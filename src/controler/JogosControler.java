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
import model.Jogos;

/**
 *
 * @author Mayron
 */
public class JogosControler {

    Jogos jogo = new Jogos();
    private static JogosControler Controler;

    public int novo_id() {
        FileReader fr = null;
        int novo_id = 1;

        try {
            fr = new FileReader("src/controler/jogos.txt");
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

    public String adicionar_jogo(String nome, String genero, String valor, String tamanho, String classificacao, String requisitos, boolean ativo) {

        nome = nome.replace(" ", "_");
        genero = genero.replace(" ", "_");
        requisitos = requisitos.replace(" ", "_");
        
        float valorFT = 0;
        float tamanhoFT = 0;
        
        if (requisitos.isEmpty()) {
            requisitos = "Sem_Requisitos";
        }

        try {
            valorFT = Float.parseFloat(valor);

        } catch (NumberFormatException e) {
            return "Digite um valor válido";
        }
        
        try {
            
            tamanhoFT = Float.parseFloat(tamanho);
            
        } catch (NumberFormatException e) {
            return "Digite um tamanho válido";
        }

        if (nome.isEmpty()) {
            return "Preencha o nome";
        }

        if (this.verificar_jogo(nome)) {
            return "O jogo já está cadastrado";
        }

        jogo.setId(this.novo_id());
        jogo.setNome(nome);
        jogo.setGenero(genero);
        jogo.setValor(valorFT);
        jogo.setTamanho_jogo(tamanhoFT);
        jogo.setClassificacao_etaria(classificacao);
        jogo.setPre_requisitos(requisitos);
        jogo.setAtivo(ativo);

        BufferedWriter bw = null;
        try {

            bw = new BufferedWriter(new FileWriter("src/controler/jogos.txt", true));
            String linha = Integer.toString(jogo.getId()) + " " + jogo.getNome() + " " + jogo.getGenero() + " " + Float.toString(jogo.getValor()) + " " + Float.toString(jogo.getTamanho_jogo()) + " " + jogo.getClassificacao_etaria() + " " + jogo.getPre_requisitos() + " " + jogo.isAtivo();
            bw.write(linha);
            bw.newLine();
            return "Jogo cadastrado com sucesso";

        } catch (IOException ex) {
            Logger.getLogger(JogosControler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(JogosControler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "Erro ao cadastrar um jogo";
    }

    public boolean verificar_jogo(String nome) {

        FileReader fr = null;

        try {
            fr = new FileReader("src/controler/jogos.txt");
            BufferedReader br = new BufferedReader(fr);

            String linha;

            while ((linha = br.readLine()) != null) {
                String dados[] = linha.split(" ");
                if (dados[1].equals(nome)) {
                    return true;
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(JogosControler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JogosControler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(JogosControler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;
    }

    public static JogosControler getInstance() {
        if (Controler == null) {
            Controler = new JogosControler();
        }
        return Controler;
    }

}
