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
import model.Jogos;

/**
 *
 * @author Mayron
 */
public class JogosControler {

    Jogos jogo = new Jogos();
    List<Jogos> jogosComprados = new ArrayList<>();
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

    public String adicionar_jogo(String nome, String genero, String valor, String tamanho, String classificacao, String requisitos, String descricao, boolean ativo) {

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
        
        if (valorFT < 0){
            return "Valor inválido";
        }
        if (tamanhoFT < 0){
            return "Tamanho inválido";
        }
        jogo.setId(this.novo_id());
        jogo.setNome(nome);
        jogo.setGenero(genero);
        jogo.setValor(valorFT);
        jogo.setTamanho_jogo(tamanhoFT);
        jogo.setClassificacao_etaria(classificacao);
        jogo.setPre_requisitos(requisitos);
        jogo.setAtivo(ativo);
        jogo.setDescricao(descricao);

        BufferedWriter bw = null;
        try {

            bw = new BufferedWriter(new FileWriter("src/controler/jogos.txt", true));
            String linha = Integer.toString(jogo.getId()) + ";" + jogo.getNome() + ";" + jogo.getGenero() + ";" + Float.toString(jogo.getValor()) + ";" + Float.toString(jogo.getTamanho_jogo()) + ";" + jogo.getClassificacao_etaria() + ";" + jogo.getPre_requisitos() + ";" + jogo.isAtivo() + ";" + jogo.getDescricao();
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

    public String atualizar_jogo(String id, String nome, String genero, String valor, String tamanho, String classificacao, String requisitos, boolean ativo) {
        

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
        
        if (valorFT < 0){
            return "Valor inválido";
        }
        if (tamanhoFT < 0){
            return "Tamanho inválido";
        }

        BufferedReader br = null;
        FileReader fr = null;

        BufferedWriter bw = null;
        FileWriter fw = null;

        List infor = new ArrayList();

        try {

            fr = new FileReader("src/controler/jogos.txt");
            br = new BufferedReader(fr);

            String linha;

            while ((linha = br.readLine()) != null) {
                String dados[] = linha.split(";");
                if (dados[0].equals(id)) {
                    linha = id + ";" + nome + ";" + genero + ";" + valor + ";" + tamanho + ";" + classificacao + ";" + requisitos + ";" + Boolean.toString(ativo);
                }
                infor.add(linha);
            }
            fr.close();
            br.close();

            fw = new FileWriter("src/controler/jogos.txt");
            bw = new BufferedWriter(fw);

            Iterator it = infor.iterator();
            Object element = null;

            while (it.hasNext()) {
                element = it.next();
                bw.write(element.toString());
                bw.newLine();
            }
            return "Concluido";
        } catch (IOException ex) {
            Logger.getLogger(JogosControler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(JogosControler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "Não foi possível atualizar o jogo";
    }

    public boolean verificar_jogo(String nome) {

        FileReader fr = null;

        try {
            fr = new FileReader("src/controler/jogos.txt");
            BufferedReader br = new BufferedReader(fr);

            String linha;

            while ((linha = br.readLine()) != null) {
                String dados[] = linha.split(";");
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

    public List retornar_jogos() {

        List dados = new ArrayList();
        FileReader fr = null;

        try {

            fr = new FileReader("src/controler/jogos.txt");
            BufferedReader br = new BufferedReader(fr);

            String linha;

            while ((linha = br.readLine()) != null) {
                dados.add(linha);
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

        return dados;
    }

    public Jogos retornar_dados_jogo(int id_jogo) {

        FileReader fr = null;
        
        try {

            fr = new FileReader("src/controler/jogos.txt");
            BufferedReader br = new BufferedReader(fr);

            String linha;

            while ((linha = br.readLine()) != null) {
                String dados[] = linha.split(";");

                if (dados[0].equals(Integer.toString(id_jogo))) {
                    jogo.setId(Integer.parseInt(dados[0]));
                    jogo.setNome(dados[1]);
                    jogo.setGenero(dados[2]);
                    jogo.setValor(Float.parseFloat(dados[3]));
                    jogo.setTamanho_jogo(Float.parseFloat(dados[4]));
                    jogo.setClassificacao_etaria(dados[5]);
                    jogo.setPre_requisitos(dados[6]);
                    jogo.setAtivo(Boolean.parseBoolean(dados[7]));
                    jogo.setDescricao(dados[8]);
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

        return jogo;
    }

    public static JogosControler getInstance() {
        if (Controler == null) {
            Controler = new JogosControler();
        }
        return Controler;
    }

}
