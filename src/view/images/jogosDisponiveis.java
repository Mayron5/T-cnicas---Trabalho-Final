/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.images;

import controler.JogosControler;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import view.inforJogos;

/**
 *
 * @author Mayron
 */
public class jogosDisponiveis extends javax.swing.JInternalFrame {

    /**
     * Creates new form jogosDisponiveis
     */
    DefaultTableModel tb_model = new DefaultTableModel();
    public jogosDisponiveis() {
        initComponents();
        iniciar_tabel_modelo();
        carregar_tabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_jogos = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(890, 544));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 2, 11)); // NOI18N
        jLabel1.setText("Pesquise aqui um jogo");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        tb_jogos.setAutoCreateRowSorter(true);
        tb_jogos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"God of war", "Jogo eletrônico de luta, RPG eletrônico, Jogo eletrônico de ação e aventura", "180 mangos  "},
                {"Spider man", "Ação e aventura, super hérois", "120 mangos "},
                {"The Legend of Zelda: Ocarina of Time ", "RPG de aventura", "80 mangos "},
                {"Super Mario World", "Plataforma, aventura", "Grátis"},
                {"Grand Theft Auto V", "Ação e aventura", "180 (100 vip) mangos"},
                {"Minecraft", "Sandbox e Sobrevivência", "80 mangos"},
                {"League of Legends", "MOBA", "Grátis"},
                {"The Legend of Zelda: Breath of the Wild", "RPG, Ação e aventura", "175 mangos "},
                {"Dark Souls Collection", "RPG de ação", "200 mangos(180 vip)"},
                {"The Witcher 3", " RPG de ação", "175 mangos"},
                {"Street Fighter 2 (1991)", "Luta, arcacde", "Grátis "},
                {"World of Warcraft", "MMORPG", "50 mangos (Grátis vip)"},
                {"The Last of Us 1 e 2", "Aventura, Sobrevivência e Horror", "220 mangos"},
                {"Red Dead Redemption 1 e 2", "Ação e aventura , faroeste", "200 mangos"},
                {"Grand Theft Auto: San Andreas ", "Ação e aventura", "Grátis "},
                {"Counter-Strike", "FPS", "Grátis"},
                {"Assassin's Creed legendary collection ", "Aventura e ação", "550 mangos (450 vip)"},
                {"Uncharted Ultimate Collection", "Ação e aventura, shooter", "200 mangos"},
                {"Overwatch", "FPS, hero shooter", "60 mangos"},
                {"The elder scrolls ultimate collection ", "RPG de ação", "150 mangos"}
            },
            new String [] {
                "Título do Jogo", "Gênero", "Preço"
            }
        ));
        tb_jogos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_jogosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_jogos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 893, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 31, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 32, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 14, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 15, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void tb_jogosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_jogosMouseClicked

        int linha_selecionada = tb_jogos.getSelectedRow();
        String id_jogo = tb_jogos.getValueAt(linha_selecionada, 0).toString();
        inforJogos inforjogos = new inforJogos(Integer.parseInt(id_jogo));
        inforjogos.setVisible(true);

    }//GEN-LAST:event_tb_jogosMouseClicked
    
     public void limparTabela() {
        while (tb_model.getRowCount() > 0) {
            tb_model.removeRow(0);
        }
        tb_jogos.setAutoCreateColumnsFromModel(false);
    }
    
    public void iniciar_tabel_modelo() {
        tb_model.addColumn("Id");
        tb_model.addColumn("Nome");
        tb_model.addColumn("Gênero");
        tb_model.addColumn("Preço");
        tb_model.addColumn("Tamanho");
        tb_model.addColumn("Classificação");
        tb_model.addColumn("Requisitos");
        tb_model.addColumn("Visivel");
        tb_jogos.setModel(tb_model);
    }

    public void carregar_tabela() {
        limparTabela();
        List dados = JogosControler.getInstance().retornar_jogos();
        Iterator it = dados.iterator();
        Object element = null;

        while (it.hasNext()) {
            element = it.next();
            String linha = element.toString();
            String infor[] = linha.split(";");

            infor[7] = infor[7].equals("true") ? "Sim" : "Não";
            tb_model.addRow(infor);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tb_jogos;
    // End of variables declaration//GEN-END:variables
}
