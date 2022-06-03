package com.raven.model;

import com.raven.swing.table.EventAction3;
import com.raven.swing.table.ModelAction3;
import com.raven.swing.table.ModelProfile;
import java.text.DecimalFormat;
import javax.swing.Icon;
import com.raven.model.StatusType2;

public class ModelStudent3 {

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
    public ModelStudent3(String date, String nama, String pekerjaan, enum status,String keterangan) {
        this.date = date;
        this.nama = nama;
        this.pekerjaan = pekerjaan;
        this.status = status;
        this.keterangan = keterangan;
    }
     public ModelStudent3() {
    }
    private String date;
    private String nama;
    private String pekerjaan;
    private enum statuss{HADIR, TIDAKHADIR};
    private String keterangan;

    public Object[] toRowTable(EventAction3 event) {
        return new Object[]{date, nama, pekerjaan, statuss, keterangan, new ModelAction3(this, event)};
    }
}
