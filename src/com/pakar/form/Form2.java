package com.pakar.form;

import com.formdev.flatlaf.FlatLightLaf;
import com.pakar.component.PopupDetailPresensi;
import com.pakar.component.PopupTambahPresensi;
import com.pakar.db.Select;
import com.pakar.koneksi.koneksi;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Form2 extends javax.swing.JPanel implements ActionListener {

    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public void load_table() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        model.addColumn("ID");
        model.addColumn("Tanggal");
        model.addColumn("Nama");
        model.addColumn("Keterangan");
        String cari = txt_cari.getText();
        TableRowSorter myTableRowSorter = new TableRowSorter(model);
        jTable1.setRowSorter(myTableRowSorter);
        addDataTable();
    }

    private void addDataTable() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd");
        Date date = new Date();
        int row = model.getRowCount();
        for (int i = 0; i < row; i++) {
            model.removeRow(0);
        }
        try {
            int no = 1;
            String sql = "SELECT presensi.id,presensi.tanggal,karyawan.nama,presensi.keterangan \n"
                    + "FROM `presensi` \n"
                    + "JOIN karyawan \n"
                    + "ON nik = presensi.karyawan_nik where presensi.tanggal = '" + dateFormat.format(date) + "'";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);

//            ResultSet rs = new Select().all("presensi");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1),
                    rs.getString(2), rs.getString(3), rs.getString(4)});
                jTable1.setModel(model);
                jTable1.validate();
                jTable1.repaint();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public Form2() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {

        }
        initComponents();
        btn_export.addActionListener(this);
        message.setText("Siap Export");
        load_table();
        setBackground(new Color(0, 0, 0, 0));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setFont(new Font("Montserrat", Font.BOLD, 14));
//        jTable1.getTableHeader().setBackground(new Color(64, 149, 244));
//        jTable1.getTableHeader().setForeground(new Color(51, 51, 51));
        FlatLightLaf.install();
        jTable1.setGridColor(new Color(230, 230, 230));
        jTable1.setRowHeight(40);
        jTable1.setShowHorizontalLines(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_cari = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        progress = new javax.swing.JProgressBar();
        message = new javax.swing.JLabel();
        txt_tanggal1 = new com.toedter.calendar.JDateChooser();
        txt_tanggal2 = new com.toedter.calendar.JDateChooser();
        btn_export = new javax.swing.JButton();
        btn_tambah = new javax.swing.JButton();
        btn_filter = new javax.swing.JButton();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_cari)
                .addContainerGap())
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 49, -1, -1));

        jLabel5.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Data Presensi");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 0, 195, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Nama", "Pekerjaan", "Status", "Keterangan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFocusable(false);
        jTable1.setRowHeight(40);
        jTable1.setSelectionBackground(new java.awt.Color(64, 194, 255));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        progress.setForeground(new java.awt.Color(64, 194, 255));
        progress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        message.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        message.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(814, Short.MAX_VALUE)
                .addComponent(message)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(progress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 147, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 116, 1050, -1));

        txt_tanggal1.setDateFormatString("yyyy-M-dd");
        add(txt_tanggal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 140, 30));

        txt_tanggal2.setDateFormatString("yyyy-M-dd");
        add(txt_tanggal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 40, 140, 30));

        btn_export.setBackground(new java.awt.Color(0, 204, 204));
        btn_export.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btn_export.setForeground(new java.awt.Color(255, 255, 255));
        btn_export.setText("Export");
        btn_export.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        btn_export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportActionPerformed(evt);
            }
        });
        add(btn_export, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, 80, 30));

        btn_tambah.setBackground(new java.awt.Color(64, 194, 255));
        btn_tambah.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btn_tambah.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah.setText("Tambah");
        btn_tambah.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(64, 194, 255), 1, true));
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 80, 80, 30));

        btn_filter.setBackground(new java.awt.Color(64, 194, 255));
        btn_filter.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btn_filter.setForeground(new java.awt.Color(255, 255, 255));
        btn_filter.setText("Filter");
        btn_filter.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(64, 194, 255), 1, true));
        btn_filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filterActionPerformed(evt);
            }
        });
        add(btn_filter, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 80, 80, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void export() throws SQLException, FileNotFoundException, IOException {

        if (txt_tanggal1.getDateEditor().getDate() == null || txt_tanggal2.getDateEditor().getDate() == null) {
            JOptionPane.showMessageDialog(null, "Export Gagal \nDimohon untuk mengisi field tanggal", "Gagal", JOptionPane.ERROR_MESSAGE);
        } else {

            String pattern = "YYYY-M-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String tanggal1 = simpleDateFormat.format(txt_tanggal1.getDateEditor().getDate());
            String tanggal2 = simpleDateFormat.format(txt_tanggal2.getDateEditor().getDate());

            String dir = FileUtils.getUserDirectoryPath();
            XSSFWorkbook workbook = new XSSFWorkbook();
            DataFormat dataFormat = workbook.createDataFormat();
            XSSFFont font = workbook.createFont();
            font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
            font.setFontHeightInPoints((short) 10);
            font.setColor(IndexedColors.WHITE.getIndex());
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
            style2.setFillForegroundColor(IndexedColors.GREEN.getIndex());
            style2.setFont(font);
            style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

            XSSFSheet spreadsheet = workbook.createSheet("Data Presensi " + tanggal1 + " sd " + tanggal2);
            XSSFRow row = spreadsheet.createRow(1);
            XSSFCell cell;

            cell = row.createCell(1);
            cell.setCellValue("NIK");
            cell.setCellStyle(style2);

            cell = row.createCell(2);
            cell.setCellValue("Nama Karyawan");
            cell.setCellStyle(style2);

            cell = row.createCell(3);
            cell.setCellValue("Keterangan");
            cell.setCellStyle(style2);

            cell = row.createCell(4);
            cell.setCellValue("Tanggal");
            cell.setCellStyle(style2);

            int i = 2;
            int progressVal = 0;

            String sql = "SELECT presensi.id,karyawan.nama,presensi.keterangan,presensi.tanggal \n"
                    + "FROM `presensi` \n"
                    + "JOIN karyawan \n"
                    + "ON nik = presensi.karyawan_nik where presensi.tanggal between '" + tanggal1 + "' and"
                    + " '" + tanggal2 + "'";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);
            System.out.println(tanggal1 + " " + tanggal2);
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

                try {
                    Thread.sleep(2);//Pausing execution for 50 milliseconds
//                progress.setValue(20);
                    System.out.println(progressVal);
                    progress.setString("Exporting...");
                    progressVal += new Random().nextInt(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                i++;
            }
            String path = dir + "/Pakar/Export/Presensi/Data-Presensi_" + tanggal1 + "_" + tanggal2 + ".xlsx";
            try ( FileOutputStream fileOut = new FileOutputStream(new File(path))) {
                workbook.write(fileOut);
            }
            JOptionPane.showMessageDialog(null, "Berhasil di export", "Berhasil", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    @Override
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


    private void txt_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyReleased
        int row = model.getRowCount();
        for (int i = 0; i < row; i++) {
            model.removeRow(0);
        }
//         if (txt_tanggal1.getDateEditor().getDate() == null || txt_tanggal2.getDateEditor().getDate() == null) {
//            JOptionPane.showMessageDialog(null, "Export Gagal \nDimohon untuk mengisi field tanggal", "Gagal", JOptionPane.ERROR_MESSAGE);
//        }
        try {

            String pattern = "YYYY-M-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            LocalDate dateObj = LocalDate.now();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd");
            Date date = new Date();
            int no = 1;
            if (txt_tanggal1.getDateEditor().getDate() == null || txt_tanggal1.getDateEditor().getDate() == null) {
                String sql = "SELECT presensi.id,presensi.tanggal,karyawan.nama,presensi.keterangan \n"
                        + " FROM `presensi` \n"
                        + " JOIN karyawan \n"
                        + " ON nik = presensi.karyawan_nik where presensi.tanggal = '" + dateFormat.format(date) + "' and karyawan.nama LIKE '%" + txt_cari.getText() + "%'";
                java.sql.Connection conn = (Connection) koneksi.configDB();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet rs = stm.executeQuery(sql);

                while (rs.next()) {
                    model.addRow(new Object[]{rs.getString(1),
                        rs.getString(2), rs.getString(3), rs.getString(4)});
                    jTable1.setModel(model);
                    jTable1.validate();
                    jTable1.repaint();
                }
            } else {
                
            String tanggal1 = simpleDateFormat.format(txt_tanggal1.getDateEditor().getDate());
            String tanggal2 = simpleDateFormat.format(txt_tanggal2.getDateEditor().getDate());
                String sql = "SELECT presensi.id,presensi.tanggal,karyawan.nama,presensi.keterangan \n"
                        + " FROM `presensi` \n"
                        + " JOIN karyawan \n"
                        + " ON nik = presensi.karyawan_nik where presensi.tanggal between '" + tanggal1 + "'"
                        + " and '" + tanggal2 + "' and karyawan.nama LIKE '%" + txt_cari.getText() + "%'";
                java.sql.Connection conn = (Connection) koneksi.configDB();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet rs = stm.executeQuery(sql);

                while (rs.next()) {
                    model.addRow(new Object[]{rs.getString(1),
                        rs.getString(2), rs.getString(3), rs.getString(4)});
                    jTable1.setModel(model);
                    jTable1.validate();
                    jTable1.repaint();
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }


    }//GEN-LAST:event_txt_cariKeyReleased

    private void btn_exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportActionPerformed
        try {
            export();
        } catch (SQLException ex) {
            Logger.getLogger(Form2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Form2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_exportActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int baris = jTable1.rowAtPoint(evt.getPoint());
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();

        String nama = model.getValueAt(index, 2).toString();
        String tanggal = model.getValueAt(index, 1).toString();
        PopupDetailPresensi popup = new PopupDetailPresensi();
        popup.setTitle("Detail Presensi " + nama);
        try {
            popup.load_table(nama);
        } catch (SQLException ex) {
            Logger.getLogger(Form2.class.getName()).log(Level.SEVERE, null, ex);
        }
        popup.txt_nama.setText(nama);
        popup.txt_tanggal.setText(tanggal);
        popup.setVisible(true);
        popup.pack();

    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filterActionPerformed
        int row = model.getRowCount();
        for (int i = 0; i < row; i++) {
            model.removeRow(0);
        }
        if (txt_tanggal1.getDateEditor().getDate() == null || txt_tanggal2.getDateEditor().getDate() == null) {
            JOptionPane.showMessageDialog(null, "Filter Gagal \nDimohon untuk mengisi field tanggal", "Gagal", JOptionPane.ERROR_MESSAGE);
        } else {
            try {

                String pattern = "YYYY-M-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String tanggal1 = simpleDateFormat.format(txt_tanggal1.getDateEditor().getDate());
                String tanggal2 = simpleDateFormat.format(txt_tanggal2.getDateEditor().getDate());
                int no = 1;
                String sql = "SELECT presensi.id,presensi.tanggal,karyawan.nama,presensi.keterangan \n"
                        + "FROM `presensi` \n"
                        + "JOIN karyawan \n"
                        + "ON nik = presensi.karyawan_nik where presensi.tanggal between '" + tanggal1 + "'"
                        + " and '" + tanggal2 + "'";
                java.sql.Connection conn = (Connection) koneksi.configDB();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet rs = stm.executeQuery(sql);

                while (rs.next()) {
                    model.addRow(new Object[]{rs.getString(1),
                        rs.getString(2), rs.getString(3), rs.getString(4)});
                    jTable1.setModel(model);
                    jTable1.validate();
                    jTable1.repaint();
                }

            } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_filterActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        PopupTambahPresensi ptp = new PopupTambahPresensi();
        ptp.setVisible(true);
        addDataTable();
//       ptp.setP
    }//GEN-LAST:event_btn_tambahActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_export;
    private javax.swing.JButton btn_filter;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel message;
    private javax.swing.JProgressBar progress;
    private javax.swing.JTextField txt_cari;
    private com.toedter.calendar.JDateChooser txt_tanggal1;
    private com.toedter.calendar.JDateChooser txt_tanggal2;
    // End of variables declaration//GEN-END:variables

}
