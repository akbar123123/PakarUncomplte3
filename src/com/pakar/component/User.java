/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pakar.component;

import com.formdev.flatlaf.FlatLightLaf;
import com.pakar.db.Select;
import com.pakar.db.Settings;
import com.pakar.login.login;
import java.awt.Robot;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Akbar Ramadhani Firdaus
 */
public class User extends javax.swing.JFrame {

    ArrayList keys = new ArrayList();
    int hour;

    /**
     * Creates new form User
     */
    public User() {
        initComponents();
//        try {
//            UIManager.setLookAndFeel(new FlatLightLaf());
//        } catch (UnsupportedLookAndFeelException e) {
//
//        }
        nama.setText(" ");
        nik.setText(" ");
        jabatan.setText(" ");
        card_id.setText("");
//        card_id.setEditable(false);
        card_id.requestFocus();
        try {
            getTimeNow();
            getHariLibur();
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }

//        btn_clear.requestFocus();
        realtimeClock();
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    private void realtimeClock() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Robot robbie;

                int second, minute, hour;
                Calendar date = Calendar.getInstance();
                second = date.get(Calendar.SECOND);
                minute = date.get(Calendar.MINUTE);
                hour = date.get(Calendar.HOUR_OF_DAY);
                time.setText(hour + " : " + minute + " : " + second);
            }
        }, 1 * 500, 1 * 500);
    }

    private void getTimeNow() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Robot robbie;

                Calendar date = Calendar.getInstance();
                int hour = date.get(Calendar.HOUR_OF_DAY);
                setHour(hour);
//                System.out.println(getHour());

            }
        }, 1 * 500, 1 * 500);

    }

    private void getHariLibur() throws SQLException {
        Date now = new Date();
// EEE gives short day names, EEEE would be full length.
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE", Locale.US);
        String asWeek = dateFormat.format(now);

        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateObj.format(formatter);
//        System.out.println(date);
        String sql = "SELECT * FROM `jadwal_libur` WHERE tanggal = '" + date + "'";
        java.sql.Connection con = (Connection) Settings.MyConfig();
        java.sql.PreparedStatement pst = con.prepareStatement(sql);
        java.sql.ResultSet rs = pst.executeQuery();
        int count = 0;
        //display results
        while (rs.next()) {
            String data = rs.getString(2);
//            System.out.println(data);
            count++;
        }
        if (asWeek.equals("Sunday") || asWeek.equals("Saturday")) {
            keterangan.setText("Hari Libur, Absen Tidak tersedia ....");
        }
        System.out.println(count);
        if (count >= 1) {
            keterangan.setText("Hari Libur, Absen Tidak tersedia ....");
            card_id.setEditable(false);
            nik.setText("");
            jabatan.setText("");
            nama.setText("");
        }
        if (getHour() >= 6 && getHour() <= 8) {
            keterangan.setText("     Absen datang...");
        } else if (getHour() >= 11 && getHour() <= 13) {
            keterangan.setText("     Absen Istirahat 1...");
        } else if (getHour() >= 13 && getHour() <= 14) {

            keterangan.setText("     Absen Istirahat 2...");
        } else if (getHour() >= 15 && getHour() <= 17) {
            keterangan.setText("     Absen Pulang");
        } else {
            keterangan.setText(" ");
        }
    }

    private void insertUser(String card_id) throws SQLException {
        Select select = new Select();
        int count = 0;
        java.sql.Connection con = (Connection) Settings.MyConfig();

        Date now = new Date();
// EEE gives short day names, EEEE would be full length.
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE", Locale.US);
        String asWeek = dateFormat.format(now);

        String[] condition = {" card_code = '" + card_id + "'"};
        java.sql.ResultSet rs = select.getWhere("karyawan", condition);
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateNow = dateObj.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String date = dateObj.format(formatter);
        rs.next();
        String idformat = date + "_" + rs.getString(1);

        String[] condition1 = {"id  = '" + idformat + "'"};
        java.sql.ResultSet userData = select.getWhere("presensi", condition1);

        while (userData.next()) {
            count++;
            System.out.println("Count = " + count);
        }
        if (asWeek.equals("Sunday") || asWeek.equals("Saturday")) {
            keterangan.setText("Hari Libur, Absen Tidak tersedia ....");
        } else {
            if (count >= 1) {
                insertDetail(idformat, rs.getString(2));
            } else {
                String sqlInsert = "INSERT INTO `presensi`\n"
                        + "(`id`, `tanggal`, `karyawan_nik`) \n"
                        + "VALUES \n"
                        + "('" + idformat + "','" + dateNow + "','" + rs.getString(1) + "')";
                System.out.println(dateNow);
                java.sql.PreparedStatement pst2 = con.prepareStatement(sqlInsert);
                pst2.execute();
                insertDetail(idformat, rs.getString(2));
            }
        }
    }

    /*
    *  
    * @param String id => id presensi
     */
    private void insertDetail(String id, String nik) throws SQLException {
        Calendar date = Calendar.getInstance();
        System.out.println(date.get(Calendar.HOUR_OF_DAY));

        if (getHour() >= 6 && getHour() <= 8) {
            new Presensi().Datang(id, nik);

        } else if (getHour() >= 11 && getHour() <= 13) {
            new Presensi().Istirahat1(id);
        } else if (getHour() >= 13 && getHour() <= 14) {
            new Presensi().Istirahat2(id);
        } else if (getHour() >= 15 && getHour() <= 17) {
            new Presensi().Pulang(id);
        } else {

        }
    }

    private void getUser(String id) throws SQLException {
        Select select = new Select();
        String sql = "SELECT * FROM `karyawan` WHERE card_code = '" + id + "'";
        java.sql.Connection con = (Connection) Settings.MyConfig();
        java.sql.PreparedStatement pst = con.prepareStatement(sql);
        java.sql.ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString(2));
            nik.setText(rs.getString(1));
            nama.setText(rs.getString(2));
            jabatan.setText(rs.getString(3));
        }
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                clearfield();
            }
        }, 3000);
//        TimeUnit.SECONDS.sleep(3);
//        clearfield();
    }

    private void clearfield() {
        card_id.setText("");
        nik.setText("");
        jabatan.setText("");
        nama.setText("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The0604933637 content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jabatan = new javax.swing.JLabel();
        btn_clear = new javax.swing.JButton();
        keterangan = new javax.swing.JLabel();
        nama = new javax.swing.JLabel();
        nik = new javax.swing.JLabel();
        card_id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Absensi");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, -1, -1));

        jabatan.setFont(new java.awt.Font("Montserrat", 1, 30)); // NOI18N
        jabatan.setText("jLabel2");
        getContentPane().add(jabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 630, -1, -1));

        btn_clear.setBackground(new java.awt.Color(153, 255, 255));
        btn_clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/clear.png"))); // NOI18N
        btn_clear.setBorder(null);
        btn_clear.setBorderPainted(false);
        btn_clear.setContentAreaFilled(false);
        btn_clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_clear.setFocusPainted(false);
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        btn_clear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btn_clearKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_clearKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btn_clearKeyReleased(evt);
            }
        });
        getContentPane().add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 480, 80, 70));

        keterangan.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        keterangan.setForeground(new java.awt.Color(255, 255, 255));
        keterangan.setText("jLabel2");
        getContentPane().add(keterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, -1, -1));

        nama.setFont(new java.awt.Font("Montserrat", 1, 30)); // NOI18N
        nama.setText("jLabel2");
        getContentPane().add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 580, -1, -1));

        nik.setFont(new java.awt.Font("Montserrat", 1, 30)); // NOI18N
        nik.setText("jLabel2");
        getContentPane().add(nik, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 530, -1, -1));

        card_id.setForeground(new java.awt.Color(255, 255, 255));
        card_id.setText("jTextField1");
        card_id.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        card_id.setCaretColor(new java.awt.Color(255, 255, 255));
        card_id.setSelectionColor(new java.awt.Color(255, 255, 255));
        card_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                card_idKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                card_idKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                card_idKeyTyped(evt);
            }
        });
        getContentPane().add(card_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 510, 130, -1));

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 30)); // NOI18N
        jLabel1.setText("NIK          :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 530, 150, 40));

        jLabel5.setFont(new java.awt.Font("Montserrat", 1, 30)); // NOI18N
        jLabel5.setText("Nama     :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 580, 150, 40));

        jLabel6.setFont(new java.awt.Font("Montserrat", 1, 30)); // NOI18N
        jLabel6.setText("Jabatan :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 630, 150, 40));

        time.setFont(new java.awt.Font("Montserrat", 1, 90)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setText("00:00:00");
        time.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, 490, 90));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/User1.png"))); // NOI18N
        jLabel7.setRequestFocusEnabled(false);
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1360, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed

    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_clearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_clearKeyPressed
//        if (!keys.contains(evt.getKeyCode())) {
//            keys.add(evt.getKeyCode());
//        }
    }//GEN-LAST:event_btn_clearKeyPressed

    private void btn_clearKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_clearKeyReleased
//        if (keys.contains(KeyEvent.VK_CONTROL) && keys.contains(KeyEvent.VK_L)) {
//        login lg = new login();
//        lg.setVisible(true);
//        dispose();
//            keys.removeAll(keys);
//        }
    }//GEN-LAST:event_btn_clearKeyReleased

    @SuppressWarnings("empty-statement")
    private void btn_clearKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_clearKeyTyped

    }//GEN-LAST:event_btn_clearKeyTyped

    private void card_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_card_idKeyReleased
// if (evt.getKey && evt.getKeyChar() == 'l') {
//            login lgn = new login();
//            lgn.setVisible(true);
//        }
        if (evt.isControlDown() && evt.getKeyChar() != 'a' && evt.getKeyCode() == 65) {
            login lgn = new login();
            this.setVisible(false);
            lgn.setVisible(true);
        }
        try {
            getUser(card_id.getText());
//                        insertUser(card_id.getText());

        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_card_idKeyReleased

    private void card_idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_card_idKeyPressed
        // TODO add your handling code here:
//        if (evt.isControlDown() && evt.getKeyChar() == 'l') {
//            login lgn = new login();
//            lgn.setVisible(true);
//        }
//        System.out.println(card_id.getText());


    }//GEN-LAST:event_card_idKeyPressed

    private void card_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_card_idKeyTyped
        // TODO add your handling code here:
        try {
            insertUser(card_id.getText());
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_card_idKeyTyped

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JTextField card_id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jabatan;
    private javax.swing.JLabel keterangan;
    private javax.swing.JLabel nama;
    private javax.swing.JLabel nik;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables

//    @Override
//    public void keyTyped(KeyEvent evt) {
//       if(evt.getKeyChar()=='k') {
//
//            System.out.println("Combination success");
//        }else{
//        System.out.println("xxxx");
//            evt.setKeyChar(evt.getKeyChar());
//        }
//    }
//
//    @Override
//    public void keyPressed(KeyEvent evt) {
//        if(evt.getKeyChar()=='k') {
//
//            System.out.println("Combination success");
//        }else{
//            System.out.println("xxxx");
//            evt.setKeyChar(evt.getKeyChar());
//        }
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//        
//    }
}
