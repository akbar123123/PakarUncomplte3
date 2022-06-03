package com.pakar.com.raven.chart;

import com.pakar.com.raven.chart.blankchart.BlankPlotChart;
import com.pakar.com.raven.chart.blankchart.BlankPlotChatRender;
import com.pakar.com.raven.chart.blankchart.SeriesSize;
import com.pakar.component.BarChart;
import com.pakar.koneksi.koneksi;
import java.awt.Color;
import java.awt.Graphics2D;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.SwingConstants;

public class Chart extends javax.swing.JPanel {

    private List<ModelLegend> legends = new ArrayList<>();
    private List<ModelChart> model = new ArrayList<>();
    private final int seriesSize = 12;
    private final int seriesSpace = 6;
    
    
    public Chart() {
        initComponents();
//        txt_tahun.setHorizontalAlignment(SwingConstants.CENTER);
//        LocalDate dateObject = LocalDate.now();
//        DateTimeFormatter format =  DateTimeFormatter.ofPattern("yyyy");
//        txt_tahun.setText(dateObject.format(format));
        blankPlotChart.setBlankPlotChatRender(new BlankPlotChatRender() {
            @Override
            public String getLabelText(int index) {
                return model.get(index).getLabel();
            }

            @Override
            public void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index) {
                double totalSeriesWidth = (seriesSize * legends.size()) + (seriesSpace * (legends.size() - 1));
                double x = (size.getWidth() - totalSeriesWidth) / 2;
                for (int i = 0; i < legends.size(); i++) {
                    ModelLegend legend = legends.get(i);
                    g2.setColor(legend.getColor());
                    double seriesValues = chart.getSeriesValuesOf(model.get(index).getValues()[i], size.getHeight());
                    g2.fillRect((int) (size.getX() + x), (int) (size.getY() + size.getHeight() - seriesValues), seriesSize, (int) seriesValues);
                    x += seriesSpace + seriesSize;
                }
            }
        });
    }

    public void addLegend(String name, Color color) {
        ModelLegend data = new ModelLegend(name, color);
        legends.add(data);
        panelLegend.add(new LegendItem(data));
        panelLegend.repaint();
        panelLegend.revalidate();
    }

    public void addData(ModelChart data) {
        model.add(data);
        blankPlotChart.setLabelCount(model.size());
        double max = data.getMaxValues();
        if (max > blankPlotChart.getMaxValues()) {
            blankPlotChart.setMaxValues(max);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLegend = new javax.swing.JPanel();
        blankPlotChart = new com.pakar.com.raven.chart.blankchart.BlankPlotChart();
        pilih_tahun = new com.toedter.calendar.JYearChooser();
        button_submit = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        panelLegend.setOpaque(false);
        panelLegend.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

        blankPlotChart.setForeground(new java.awt.Color(51, 51, 51));
        blankPlotChart.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N

        pilih_tahun.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N

        button_submit.setBackground(new java.awt.Color(255, 255, 255));
        button_submit.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        button_submit.setForeground(new java.awt.Color(51, 51, 51));
        button_submit.setText("Submit");
        button_submit.setBorder(null);
        button_submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blankPlotChart, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
                    .addComponent(panelLegend, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(440, 440, 440)
                        .addComponent(pilih_tahun, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(blankPlotChart, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pilih_tahun, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(button_submit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelLegend, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_submitActionPerformed
//        int select_month = pilih_bulan.getMonth()+1; //get value from monthchooser
        int select_year = pilih_tahun.getYear(); //get value from yearchooser
        
//        //total_hadir
//        try {
//            String sql = "SELECT COUNT(keterangan) as total_hadir from presensi WHERE MONTH(tanggal) = "+select_month+" AND YEAR(tanggal) = "+select_year+" AND karyawan_nik='"+txt_nik.getText()+"' AND keterangan='Hadir'";
//            java.sql.Connection conn = (Connection) koneksi.configDB();
//            java.sql.Statement stm = conn.createStatement();
//            java.sql.ResultSet rs = stm.executeQuery(sql);
//            while(rs.next()){
//                txt_hadir.setText(String.valueOf(rs.getInt("total_hadir")));
//                System.out.println(rs.getInt("total_hadir"));
//                System.out.println(""+sql);
//                polarAreaChart.addItem(new ModelPolarAreaChart(new Color(9, 91, 255), "Hadir", rs.getInt("total_hadir")));
//                polarAreaChart.repaint();
//            }
//            System.out.println(sql);
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, e.getMessage());
//
//        }
        //total_sakit
        try {
            String sql = "select count(keterangan) as total from presensi where keterangan = 'total' AND year(tanggal) = '"+select_year+"'";
        double Bln = 0;
            java.sql.Connection conn=(Connection)koneksi.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet rs=stm.executeQuery(sql);
            System.out.println("INI TAMPIL"+sql);
            if(rs.next()){
//                Bln = rs.getDouble(1);
//                System.out.println(rs.getDouble(1));
                
                BarChart bc = new BarChart();
                bc.Tampil();
            }
        }catch(SQLException ex){
            
        }
        
    }//GEN-LAST:event_button_submitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.pakar.com.raven.chart.blankchart.BlankPlotChart blankPlotChart;
    private javax.swing.JButton button_submit;
    private javax.swing.JPanel panelLegend;
    public com.toedter.calendar.JYearChooser pilih_tahun;
    // End of variables declaration//GEN-END:variables
}
