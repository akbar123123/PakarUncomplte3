package com.pakar.component;

import com.pakar.db.Settings;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author mhmmdadi21
 */
public class Presensi {

    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    Date dateDate = new Date();
    String timeNow = dateFormat.format(dateDate);

    Calendar date = Calendar.getInstance();
    int time = date.get(Calendar.HOUR_OF_DAY);

    LocalDate dateObj = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String dateNow = dateObj.format(formatter);

    private void Dialog() {
        JOptionPane pane = new JOptionPane("Berhasil absen untuk jam sekarang", JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = pane.createDialog(null, "Title");
        dialog.setModal(false);
        dialog.setVisible(true);

        new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
        }).start();
    }

    private void ErrorDialog(String message) {
        JOptionPane pane = new JOptionPane(message, JOptionPane.ERROR_MESSAGE);
        JDialog dialog = pane.createDialog(null, "Title");
        dialog.setModal(false);
        dialog.setVisible(true);

        new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
        }).start();
    }

    public void Datang(String id, String nik) throws SQLException {
        try {
//            String status ="Tepat Waktu";
            String status = (time == 7) ? "Tepat Waktu" : "Terlambat";
            java.sql.Connection con = (Connection) Settings.MyConfig();
            String sqlInsert = "INSERT INTO `detail_presensi`\n"
                    + "(`id_presensi`, `id_jenis_presensi`, `jam`, `keterangan`) \n"
                    + "VALUES ('" + id + "','DTG','" + timeNow + "','Tepat Waktu')";
            java.sql.PreparedStatement pst2 = con.prepareStatement(sqlInsert);
            pst2.execute();
            Dialog();
        } catch (SQLException e) {
            ErrorDialog(e.getMessage());
        } finally {
            System.out.println("Errornya line 42");
        }

    }

    public void Istirahat1(String id) {
        try {
//             String status ="Tepat Waktu";
            String status = (time == 11) ? "Tepat Waktu" : "Terlambat";
            java.sql.Connection con = (Connection) Settings.MyConfig();
            String sqlInsert = "INSERT INTO `detail_presensi`\n"
                    + "(`id_presensi`, `id_jenis_presensi`, `jam`, `keterangan`) \n"
                    + "VALUES ('" + id + "','ISTRHT1','" + timeNow + "','Tepat Waktu')";
            java.sql.PreparedStatement pst2 = con.prepareStatement(sqlInsert);
            pst2.execute();
            Dialog();
        } catch (SQLException e) {
            ErrorDialog(e.getMessage());
        } finally {
            System.out.println("Errornya line 57");
        }
    }

    public void Istirahat2(String id) {
        try {
//            String status ="Tepat Waktu";
            String status = (time == 13) ? "Tepat Waktu" : "Terlambat";
            java.sql.Connection con = (Connection) Settings.MyConfig();
            String sqlInsert = "INSERT INTO `detail_presensi`\n"
                    + "(`id_presensi`, `id_jenis_presensi`,`jam`, `keterangan`) \n"
                    + "VALUES ('" + id + "','ISTRHT2','" + timeNow + "','Tepat Waktu')";
            java.sql.PreparedStatement pst2 = con.prepareStatement(sqlInsert);
            pst2.execute();
            Dialog();
        } catch (SQLException e) {
            ErrorDialog(e.getMessage());;
        } finally {
            System.out.println("Errornya line 72");
        }
    }

    public void Pulang(String id) {
        try {
            String status = "Tepat Waktu";
            java.sql.Connection con = (Connection) Settings.MyConfig();
            String sqlInsert = "INSERT INTO `detail_presensi`\n"
                    + "(`id_presensi`, `id_jenis_presensi`, `jam`, `keterangan`) \n"
                    + "VALUES ('" + id + "','PLNG','" + timeNow + "','Tepat Waktu')";
            java.sql.PreparedStatement pst2 = con.prepareStatement(sqlInsert);
            pst2.execute();
            Dialog();
        } catch (SQLException e) {
            ErrorDialog(e.getMessage());
        } finally {
            System.out.println("Errornya line 89");
        }
    }

    public void Lembur(String id) {

    }
}
