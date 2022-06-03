package com.pakar.form;

import com.formdev.flatlaf.FlatLightLaf;
import com.pakar.component.PopupDeleteDataPegawai;
import com.pakar.component.PopupEditDataPegawai;
import com.pakar.component.PopupInsertPegawai;
import com.pakar.dialog.Message;
import com.raven.main.Main;
import com.raven.model.ModelCard;
import com.raven.model.ModelStudent;
import com.raven.model.StatusType;
import com.raven.swing.ScrollBar;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.raven.swing.noticeboard.ModelNoticeBoard;
import com.raven.swing.table.EventAction;
import com.pakar.koneksi.koneksi;
import com.pakar.component.PopupFormEditHariLibur;
import com.pakar.component.PopupInsertHariLibur;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Form4 extends javax.swing.JPanel {

    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public void load_table() {

//        jTable1.setModel(model);
        model.addColumn("No");
        model.addColumn("ID");
        model.addColumn("Hari");
        model.addColumn("Tanggal");
        model.addColumn("Keterangan");
        TableRowSorter myTableRowSorter = new TableRowSorter(model);
        jTable1.setRowSorter(myTableRowSorter);
        addDataTable();

    }

    private void addDataTable() {
        int row = model.getRowCount();
        for (int i = 0; i < row; i++) {
            model.removeRow(0);
        }
        try {

            int no = 1;
            String sql = "Select * from jadwal_libur ";

//                   cari.equals("") 
//                    : "Select * From karyawan Where karyawan.nik LIKE '%"+cari+"%'";
//            String sql = "SELECT karyawan.nik, karyawan.nama, karyawan.jabatan ,karyawan.jenis_kelamin, karyawan.alamat, karyawan.no_hp "
//                    + "FROM karyawan join jabatan on karyawan.jabatan_id = jabatan.id WHERE karyawan.nik LIKE '%"+cari+"%'";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                model.addRow(new Object[]{no++, rs.getString(1),
                    rs.getString(2), rs.getString(3), rs.getString(4)});
                jTable1.setModel(model);
                jTable1.validate();
                jTable1.repaint();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private boolean showMessage(String message) {
        Message obj = new Message(Main.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }

    public Form4() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {

        }
        initComponents();
        setOpaque(false);
        load_table();
        setBackground(new Color(0, 0, 0, 0));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setFont(new Font("Montserrat", Font.BOLD, 14));
        jTable1.setGridColor(new Color(230, 230, 230));
        jTable1.setRowHeight(40);
        jTable1.setShowHorizontalLines(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        popup_delete = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_cari = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        popup_delete.setBackground(new java.awt.Color(255, 255, 255));
        popup_delete.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        popup_delete.setForeground(new java.awt.Color(255, 0, 0));
        popup_delete.setText("DELETE");
        popup_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popup_deleteActionPerformed(evt);
            }
        });
        jPopupMenu1.add(popup_delete);

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon search.png"))); // NOI18N

        txt_cari.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        txt_cari.setForeground(new java.awt.Color(102, 102, 102));
        txt_cari.setBorder(null);
        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cariKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_cari)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 540, 40));

        jLabel5.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Data Hari Libur");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 220, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Hari dan Tanggal", "Keterangan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFocusable(false);
        jTable1.setRowHeight(40);
        jTable1.setRowMargin(0);
        jTable1.setSelectionBackground(new java.awt.Color(64, 194, 255));
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 127, -1, -1));

        jButton1.setBackground(new java.awt.Color(64, 194, 255));
        jButton1.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("TAMBAH");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 80, 150, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyReleased
//        DefaultTableModel model = new DefaultTableModel();
//                String cari = txt_cari.getText();
        int row = model.getRowCount();
        for (int i = 0; i < row; i++) {
            model.removeRow(0);
        }

        try {
            int no = 1;
            String sql = "Select * from jadwal_libur Where keterangan LIKE '%" + txt_cari.getText() + "%'";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                model.addRow(new Object[]{no++, rs.getString(1),
                    rs.getString(2), rs.getString(3), rs.getString(4)});
                jTable1.setModel(model);
                jTable1.validate();
                jTable1.repaint();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_txt_cariKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int baris = jTable1.rowAtPoint(evt.getPoint());
        int index = jTable1.getSelectedRow();

        TableModel model = jTable1.getModel();

        String id = model.getValueAt(index, 1).toString();
        PopupFormEditHariLibur pofep = new PopupFormEditHariLibur((JFrame) SwingUtilities.getWindowAncestor(this), id);
        pofep.setVisible(true);

        addDataTable();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        if (evt.getButton() == MouseEvent.BUTTON3) {
            if (evt.isPopupTrigger() && jTable1.getSelectedRowCount() != 0) {
                jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PopupInsertHariLibur pip = new PopupInsertHariLibur((JFrame) SwingUtilities.getWindowAncestor(this));
        pip.setVisible(true);
        addDataTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void popup_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popup_deleteActionPerformed
        int row = jTable1.getSelectedRow();
        if (row != -1) {
            String nik = jTable1.getValueAt(row, 0).toString();
            String sql = "DELETE FROM karyawan WHERE nik='" + nik + "'";
            try {
                java.sql.Connection conn = (Connection) koneksi.configDB();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "DELETE BERHASIL");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_popup_deleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem popup_delete;
    private javax.swing.JTextField txt_cari;
    // End of variables declaration//GEN-END:variables
}
