/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.JogosControler;
import java.awt.Component;
import java.awt.Image;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import view.inforJogos;
import view.util.ManipularImagem;

/**
 *
 * @author Mayron
 */
public class jogosDisponiveis extends javax.swing.JInternalFrame {

    /**
     * Creates new form jogosDisponiveis2
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

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_jogos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        foto = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(890, 544));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 2, 14)); // NOI18N
        jLabel1.setText("Pesquise aqui um jogo");

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 0));
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 0));

        tb_jogos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_jogos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_jogosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_jogos);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/lupa_1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        foto.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(40, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(foto)
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(foto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tb_jogosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_jogosMouseClicked
        int linha_selecionada = tb_jogos.getSelectedRow();
        String id = tb_jogos.getValueAt(linha_selecionada, 0).toString();
        
        inforJogos inforjogos = new inforJogos(Integer.parseInt(id));
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
    private javax.swing.JLabel foto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tb_jogos;
    // End of variables declaration//GEN-END:variables
}
