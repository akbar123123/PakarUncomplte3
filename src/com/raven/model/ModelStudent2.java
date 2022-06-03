package com.raven.model;

import com.raven.swing.table.EventAction2;
import com.raven.swing.table.ModelAction2;
import com.raven.swing.table.ModelProfile;
import java.text.DecimalFormat;
import javax.swing.Icon;

public class ModelStudent2 {

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
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

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }
    
    public ModelStudent2(String NIK, String nama, String pekerjaan, String jk, String alamat, String nohp) {
        this.NIK = NIK;
        this.nama = nama;
        this.pekerjaan = pekerjaan;
        this.jk = jk;
        this.alamat = alamat;
        this.nohp = nohp;
    }

    public ModelStudent2() {
    }

    private String NIK;
    private String nama;
    private String pekerjaan;
    private String jk;
    private String alamat;
    private String nohp;

    public Object[] toRowTable(EventAction2 event) {
        return new Object[]{NIK, nama, pekerjaan, jk, alamat, nohp, new ModelAction2(this, event)};
    }
}
