package com.pakar.form;

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
import com.pakar.component.PopupEditDataPegawai;
import com.pakar.component.PopupFormEditPegawai;
import com.pakar.db.Select;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Form1 extends javax.swing.JPanel implements ActionListener {

     DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public void load_table() {
       
//        jTable1.setModel(model);
        model.addColumn("NIK");
        model.addColumn("Nama");
        model.addColumn("Pekerjaan");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Alamat");
        model.addColumn("Nomor HP");
        model.addColumn("Card Code");
        TableRowSorter myTableRowSorter = new TableRowSorter(model);
        jTable1.setRowSorter(myTableRowSorter);
        addDataTable();
        
    }
    private void addDataTable(){
         int row = model.getRowCount();
        for (int i = 0; i < row; i++) {
            model.removeRow(0);
        }

        try {
            
            int no = 1;
            String sql = "Select * from karyawan";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1),
                    rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getString(6), rs.getString(7)});
                jTable1.setModel(model);
                jTable1.validate();
                jTable1.repaint();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
//    PopupEditDataPegawai poep = new PopupEditDataPegawai();

    public Form1() {
        initComponents();
        setOpaque(false);
//        initData();
        btn_export.addActionListener(this);
        message.setText("Siap Export");
        load_table();
        setBackground(new Color(0, 0, 0, 0));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setFont(new Font("Montserrat", Font.BOLD, 14));
        jTable1.setGridColor(new Color(230, 230, 230));
        jTable1.setRowHeight(40);
        jTable1.setShowHorizontalLines(true);
    }

    private boolean showMessage(String message) {
        Message obj = new Message(Main.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        progress = new javax.swing.JProgressBar();
        message = new javax.swing.JLabel();
        btn_export = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

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
        jLabel5.setText("Data Pegawai");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 195, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIK", "Nama", "Pekerjaan", "Jenis Kelamin", "Alamat", "Nomor HP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setFocusable(false);
        jTable1.setRowHeight(40);
        jTable1.setRowMargin(0);
        jTable1.setSelectionBackground(new java.awt.Color(64, 194, 255));
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        message.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        message.setText("jLabel1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(816, Short.MAX_VALUE)
                .addComponent(message)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(message)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 127, 1040, 460));

        btn_export.setBackground(new java.awt.Color(0, 153, 255));
        btn_export.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        btn_export.setForeground(new java.awt.Color(255, 255, 255));
        btn_export.setText("Export");
        btn_export.setBorder(null);
        btn_export.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportActionPerformed(evt);
            }
        });
        add(btn_export, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 90, 100, 30));

        jButton2.setBackground(new java.awt.Color(64, 194, 255));
        jButton2.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("TAMBAH");
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 90, 100, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyReleased
       
        String cari = txt_cari.getText();
        int row = model.getRowCount();
        for (int i = 0; i < row; i++) {
            model.removeRow(0);
        }

        try {
            int no = 1;
            String sql = "Select * from karyawan Where nama LIKE '%" + cari + "%'";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1),
                    rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getString(6)});
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

        String nik = model.getValueAt(index, 0).toString();
        PopupFormEditPegawai pofep = new PopupFormEditPegawai((JFrame) SwingUtilities.getWindowAncestor(this), nik);
        pofep.setVisible(true);
        addDataTable();

//        jButton2.setEnabled(true);
//        jButton3.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void export() throws SQLException, IOException {
        String dir = FileUtils.getUserDirectoryPath();
        XSSFWorkbook workbook = new XSSFWorkbook();
        DataFormat dataFormat = workbook.createDataFormat();
        CellStyle style;
        CellStyle style2;
        style = workbook.createCellStyle();
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());

        style2 = workbook.createCellStyle();
        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style2.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style2.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style2.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style2.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style2.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        XSSFSheet spreadsheet = workbook.createSheet("Data Barang");
        XSSFRow row = spreadsheet.createRow(1);
        XSSFCell cell;

        cell = row.createCell(1);
        cell.setCellValue("NIK");
        cell.setCellStyle(style2);

        cell = row.createCell(2);
        cell.setCellValue("Nama Karyawan");
        cell.setCellStyle(style2);

        cell = row.createCell(3);
        cell.setCellValue("Jabatan");
        cell.setCellStyle(style2);

        cell = row.createCell(4);
        cell.setCellValue("Jenis Kelamin");
        cell.setCellStyle(style2);

        cell = row.createCell(5);
        cell.setCellValue("Alamat");
        cell.setCellStyle(style2);

        cell = row.createCell(6);
        cell.setCellValue("No HP");
        cell.setCellStyle(style2);
        
        cell = row.createCell(7);
        cell.setCellValue("Card Code");
        cell.setCellStyle(style2);

        int i = 2;

        Select select = new Select();
        ResultSet rs = select.all("karyawan");

        while (rs.next()) {
            spreadsheet.autoSizeColumn(i);
            row = spreadsheet.createRow(i);
            cell = row.createCell(1);
            cell.setCellValue(rs.getString(1));
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue(rs.getString(2));
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue(rs.getString(3));
            cell.setCellStyle(style);

            cell = row.createCell(4);
            cell.setCellValue(rs.getString(4));
            cell.setCellStyle(style);

            cell = row.createCell(5);
            cell.setCellValue(rs.getString(5));
            cell.setCellStyle(style);

            cell = row.createCell(6);
            cell.setCellValue(rs.getString(6));
            cell.setCellStyle(style);
            
            cell = row.createCell(7);
            cell.setCellValue(rs.getString(7));
            cell.setCellStyle(style);
            i++;
        }
        String path = dir + "/Pakar/Export/Karyawan.xlsx";
        try (FileOutputStream fileOut = new FileOutputStream(new File(path))) {
            workbook.write(fileOut);
        }
        JOptionPane.showMessageDialog(null, "Berhasil di export", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
    }
    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        if (evt.getButton() == MouseEvent.BUTTON3) {
            if (evt.isPopupTrigger() && jTable1.getSelectedRowCount() != 0) {
                jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_jTable1MouseReleased

    public void actionPerformed(ActionEvent e) {

        int i = 0;
        if (e.getSource() == btn_export) {
            progress.setVisible(true);
            try {
                while (i <= 100) {
                    Thread.sleep(30);
                    progress.paintImmediately(0, 0, 200, 200);
                    progress.setValue(i);

                    i++;
                }
            } catch (InterruptedException e1) {
                System.out.print("Exception =" + e1);
            }
            progress.setValue(0);
            message.setText("Export Selesai");

        }
    }
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
        addDataTable();
    }//GEN-LAST:event_popup_deleteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       PopupInsertPegawai poptmbah = new PopupInsertPegawai((JFrame) SwingUtilities.getWindowAncestor(this));
       poptmbah.setVisible(true);
       addDataTable();
//       load_table();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportActionPerformed
        try {
            this.export();
        } catch (SQLException ex) {
            Logger.getLogger(Form1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Form1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_exportActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_export;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTable1;
    private javax.swing.JLabel message;
    private javax.swing.JMenuItem popup_delete;
    private javax.swing.JProgressBar progress;
    private javax.swing.JTextField txt_cari;
    // End of variables declaration//GEN-END:variables
}
