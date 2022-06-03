package com.pakar.form;

import com.formdev.flatlaf.FlatLightLaf;
import com.pakar.com.chart.ModelPolarAreaChart;
import com.pakar.com.raven.chart.Chart;
import com.pakar.com.raven.chart.ModelChart;
import com.pakar.component.BarChart;
import com.pakar.component.PolarChart;
import com.pakar.koneksi.koneksi;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.lang.Class;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Form3 extends javax.swing.JPanel {

    public Form3() {
        initComponents();
        setOpaque(false);
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
    public void load_table() {
        DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
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
        try {
            int no = 1;
            String sql = "Select * from karyawan ";
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
//    public void TampilChart(){
//        chart.addLegend("Income", new Color(245, 189, 135));
//        chart.addLegend("Expense", new Color(135, 189, 245));
//        chart.addLegend("Profit", new Color(189, 135, 245));
//        chart.addLegend("Cost", new Color(139, 229, 222));
//        chart.addData(new ModelChart("January", new double[]{500, 200, 80,89}));
//        chart.addData(new ModelChart("February", new double[]{600, 750, 90,150}));
//        chart.addData(new ModelChart("March", new double[]{200, 350, 460,900}));
//        chart.addData(new ModelChart("April", new double[]{480, 150, 750,700}));
//        chart.addData(new ModelChart("May", new double[]{350, 540, 300,150}));
//        chart.addData(new ModelChart("June", new double[]{190, 280, 81,200}));
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_all = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_cari2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1050, 598));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_all.setBackground(new java.awt.Color(64, 194, 255));
        btn_all.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        btn_all.setForeground(new java.awt.Color(255, 255, 255));
        btn_all.setText("Rekapitulasi");
        btn_all.setBorder(null);
        btn_all.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_allActionPerformed(evt);
            }
        });
        add(btn_all, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 80, 120, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon search.png"))); // NOI18N

        txt_cari2.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        txt_cari2.setForeground(new java.awt.Color(102, 102, 102));
        txt_cari2.setBorder(null);
        txt_cari2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cari2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cari2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_cari2)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 540, 40));

        jLabel5.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Statistik");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 220, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 127, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cari2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cari2KeyReleased
        DefaultTableModel model = new DefaultTableModel();
        String cari = txt_cari2.getText();
        int row = model.getRowCount();
        for (int i = 0; i < row; i++) {
            model.removeRow(0);
        }

        try{
            int no = 1;
            String sql = "Select * from karyawan Where nama LIKE '%"+cari+"%'";
            java.sql.Connection conn=(Connection)koneksi.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet rs=stm.executeQuery(sql);

            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1),
                    rs.getString(2),rs.getString(3),rs.getString(4),
                    rs.getString(5),rs.getString(6)});
            jTable1.setModel(model);
            jTable1.validate();
            jTable1.repaint();
        }

        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_txt_cari2KeyReleased

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
//        if (evt.getButton()==MouseEvent.BUTTON3) {
//            if (evt.isPopupTrigger()&&jTable1.getSelectedRowCount() !=0) {
//                jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
//            }
//        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
         PolarChart pl = new PolarChart();
        
        //get month year    
        java.util.Date date= new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH)+1;
        int year = cal.get(Calendar.YEAR);
        
        int baris = jTable1.rowAtPoint(evt.getPoint());
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();

        String nik = model.getValueAt(index, 0).toString();
        String nama = model.getValueAt(index, 1).toString();
        String pekerjaan = model.getValueAt(index, 2).toString();
        //total_hadir
        try {
            String sql = "SELECT COUNT(keterangan) as total_hadir from presensi WHERE MONTH(tanggal) = "+month+" AND YEAR(tanggal) = "+year+" AND karyawan_nik='"+nik+"' AND keterangan='Hadir'";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                pl.txt_hadir.setText(String.valueOf(rs.getInt("total_hadir")));
                System.out.println(rs.getInt("total_hadir"));
                System.out.println(""+sql);
                pl.polarAreaChart.addItem(new ModelPolarAreaChart(new Color(9, 91, 255), "Hadir", rs.getInt("total_hadir")));
                
            }
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        
    }
        //total_sakit
         try {
            String sql = "SELECT COUNT(keterangan) as total_sakit from presensi WHERE MONTH(tanggal) = "+month+" AND YEAR(tanggal) = "+year+" AND karyawan_nik='"+nik+"' AND keterangan='Sakit'";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                pl.txt_sakit.setText(String.valueOf(rs.getInt("total_sakit")));
                System.out.println(rs.getInt("total_sakit"));
                System.out.println(""+sql);
                pl.polarAreaChart.addItem(new ModelPolarAreaChart(new Color(255, 255, 0), "Sakit", rs.getInt("total_sakit")));
            }
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        
    }
         //total_izin
         try {
            String sql = "SELECT COUNT(keterangan) as total_izin from presensi WHERE MONTH(tanggal) = "+month+" AND YEAR(tanggal) = "+year+" AND karyawan_nik='"+nik+"' AND keterangan='Izin'";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                pl.txt_izin.setText(String.valueOf(rs.getInt("total_izin")));
                System.out.println(rs.getInt("total_izin"));
                System.out.println(""+sql);
                pl.polarAreaChart.addItem(new ModelPolarAreaChart(new Color(33, 255, 9), "Izin", rs.getInt("total_izin")));
            }
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        
    }
         //total_alpha
         try {
            String sql = "SELECT COUNT(keterangan) as total_alpha from presensi WHERE MONTH(tanggal) = "+month+" AND YEAR(tanggal) = "+year+" AND karyawan_nik='"+nik+"' AND keterangan='Tidak Hadir'";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                pl.txt_alpha.setText(String.valueOf(rs.getInt("total_alpha")));
                System.out.println(rs.getInt("total_alpha"));
                System.out.println(""+sql);
                pl.polarAreaChart.addItem(new ModelPolarAreaChart(new Color(255, 0, 0), "Tidak Hadir", rs.getInt("total_alpha")));
            }
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        
    }
          //total_lembur
         try {
            String sql = "SELECT COUNT(keterangan) as total_lembur from presensi WHERE MONTH(tanggal) = "+month+" AND YEAR(tanggal) = "+year+" AND karyawan_nik='"+nik+"' AND keterangan='Lembur'";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                pl.txt_lembur.setText(String.valueOf(rs.getInt("total_lembur")));
                System.out.println(rs.getInt("total_lembur"));
                System.out.println(""+sql);
                pl.polarAreaChart.addItem(new ModelPolarAreaChart(new Color(204, 0, 204), "Lembur", rs.getInt("total_lembur")));
            }
          
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        
    } 
        pl.polarAreaChart.start();
        pl.setVisible(true);
        pl.setTitle("Statistik");
        pl.pack();
        pl.txt_nik.setText(nik);
        pl.txt_nama.setText(nama);
        pl.txt_jabatan.setText(pekerjaan);
        System.out.println(""+nik);
        java.sql.PreparedStatement preparedStatement = null;
//        PolarChart pl = new PolarChart();
//        int baris = jTable1.rowAtPoint(evt.getPoint());
//        int index = jTable1.getSelectedRow();
//        TableModel model = jTable1.getModel();
//
//        String nik = model.getValueAt(index, 0).toString();
//        String nama = model.getValueAt(index, 1).toString();
//        String pekerjaan = model.getValueAt(index, 2).toString();
//
//        pl.setVisible(true);
//        pl.setTitle("Statistik");
//        pl.pack();
//        pl.txt_nik.setText(nik);
//        pl.txt_nama.setText(nama);
//        pl.txt_jabatan.setText(pekerjaan);
//        System.out.println(""+nik);
//        java.sql.PreparedStatement preparedStatement = null;
//        
//        // get monthly selling
//            String sql3 = "Select * from karyawan where"+nik;
//            java.sql.Connection conn = null;
//        try {
//            conn = (Connection) koneksi.configDB();
//        } catch (SQLException ex) {
//            Logger.getLogger(Form3.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            java.sql.Statement stm = null;
//        try {
//            stm = conn.createStatement();
//        } catch (SQLException ex) {
//            Logger.getLogger(Form3.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            java.sql.ResultSet rs = stm.executeQuery(sql3);
////        pofep.txt_id.setText(id);
////        pofep.txt_hari.setText(hari);
////        try {
////            DefaultTableModel model2 = (DefaultTableModel)jTable1.getModel();
////            int index2 = jTable1.getSelectedRow();
////            Date tanggal = new SimpleDateFormat("YYYY-MM-dd").parse((String)model2.getValueAt(index2, 3));
////            pofep.txt_tanggal.setDate(tanggal);
////        } catch (ParseException ex) {
////            Logger.getLogger(Form4.class.getName()).log(Level.SEVERE, null, ex);
////        }
////        pofep.txt_keterangan.setText(keterangan);
//
////        jButton2.setEnabled(true);
////        jButton3.setEnabled(true);
//        } catch (SQLException ex) {
//            Logger.getLogger(Form3.class.getName()).log(Level.SEVERE, null, ex);
//        }
      
    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_allActionPerformed
        // TODO add your handling code here:
        BarChart bc = new BarChart();
        bc.setVisible(true);
//        Chart ch = new Chart();
//        bc.TampilTH();
    }//GEN-LAST:event_btn_allActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_all;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_cari2;
    // End of variables declaration//GEN-END:variables
}
