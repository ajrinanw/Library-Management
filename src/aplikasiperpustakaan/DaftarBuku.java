/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiperpustakaan;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import mysql.Connect;
/**
 *
 * @author TOSHIBA
 */
public class DaftarBuku extends javax.swing.JFrame {

    /**
     * Creates new form DaftarBuku
     */
    public DaftarBuku() {
        initComponents();
        loadTable();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        booksData = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Daftar Buku");

        booksData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No", "Kategori", "Judul", "Pengarang", "Penerbit", "Tahun Terbit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        booksData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booksDataMouseClicked(evt);
            }
        });
        booksData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                booksDataKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                booksDataKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(booksData);
        if (booksData.getColumnModel().getColumnCount() > 0) {
            booksData.getColumnModel().getColumn(0).setResizable(false);
        }

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Ketikkan Buku Yang Anda Cari :");

        jLabel3.setText("* Edit data dengan mengubah isinya langsung di table lalu klik Enter 2x");

        jLabel4.setText("* Hapus data dengan klik row kemudian klik Del / Delete di keyboard");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(258, 258, 258)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 263, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void booksDataKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_booksDataKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_booksDataKeyTyped

    private void booksDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_booksDataKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                DefaultTableModel model = (DefaultTableModel)booksData.getModel();
                java.sql.Connection conn=(Connection)Connect.ConfigDB();
                java.sql.Statement stm=conn.createStatement();
                
                for(int i = 0; i < model.getRowCount(); i++) {
                    int id = Integer.valueOf(model.getValueAt(i, 0).toString());
                    String judul = model.getValueAt(i, 2).toString();
                    String pengarang = model.getValueAt(i, 3).toString();
                    String penerbit = model.getValueAt(i, 4).toString();
                    String tahun_terbit = model.getValueAt(i, 5).toString();
                    
                    String updateQuery = "update books set `judul`='"+judul+"', `pengarang`='"+pengarang+"', `penerbit`='"+penerbit+"', `tahun_terbit`='"+tahun_terbit+"' where id_book='"+id+"' ";
                    
                    stm.addBatch(updateQuery);
                    int[] updatedRow = stm.executeBatch();
                    System.out.println(updatedRow.length);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaftarBuku.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(evt.getKeyCode() == KeyEvent.VK_DELETE) {
            try {
                DefaultTableModel model = (DefaultTableModel)booksData.getModel();
                java.sql.Connection conn=(Connection)Connect.ConfigDB();
                java.sql.Statement stm=conn.createStatement();
                
                int id = Integer.valueOf(model.getValueAt(booksData.getSelectedRow(), 0).toString());
                
                String deleteQuery = "delete from `books` where id_book='"+id+"' ";
                    
                stm.addBatch(deleteQuery);
                int[] updatedRow = stm.executeBatch();
                System.out.println(updatedRow.length);
                
                loadTable();
            } catch (SQLException ex) {
                Logger.getLogger(DaftarBuku.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_booksDataKeyPressed

    private void booksDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksDataMouseClicked

    }//GEN-LAST:event_booksDataMouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:z
        String key = jTextField1.getText();
        loadTableSearch(key);
    }//GEN-LAST:event_jTextField1KeyReleased
    private void loadTable(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Kategori");
        model.addColumn("Judul");
        model.addColumn("Pengarang");
        model.addColumn("Penerbit");
        model.addColumn("Tahun Terbit");
    
        try {
            String sql ="select books.id_book, categories.category, books.judul, books.pengarang, books.penerbit, books.tahun_terbit from books, categories where categories.id_category = books.id_kategori";
            java.sql.Connection conn=(Connection)Connect.ConfigDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while (res.next()){
                model.addRow(new Object[] {res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getInt(6)} );

        }
            booksData.setModel(model);   
        }
        catch (Exception e){}
    }
    
    private void loadTableSearch(String key) {
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Kategori");
        model.addColumn("Judul");
        model.addColumn("Pengarang");
        model.addColumn("Penerbit");
        model.addColumn("Tahun Terbit");
    
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel> (model);
        booksData.setRowSorter(tr);

        tr.setRowFilter(RowFilter.regexFilter("(?i)" +key));
        try {
            String sql ="select books.id_book, categories.category, books.judul, books.pengarang, books.penerbit, books.tahun_terbit from books, categories where categories.id_category = books.id_kategori ";
            java.sql.Connection conn=(Connection)Connect.ConfigDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while (res.next()){
                model.addRow(new Object[] {res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getInt(6)} );

        }
            booksData.setModel(model);   
        }
        catch (Exception e){}
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DaftarBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DaftarBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DaftarBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DaftarBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DaftarBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable booksData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
