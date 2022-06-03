package com.raven.swing;

import com.raven.model.StatusType2;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;

public class TableStatus3 extends JLabel {

    public StatusType2 getType() {
        return type;
    }

    public TableStatus3() {
        setForeground(Color.WHITE);
    }

    private StatusType2 type;

    public void setType2(StatusType2 type) {
        this.type = type;
        setText(type.toString());
        repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        if (type != null) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            GradientPaint g;
            if (type == StatusType2.HADIR) {
                g = new GradientPaint(0, 0, new Color(66, 194, 255), 0, getHeight(), new Color(66, 194, 255));
            } else {
                g = new GradientPaint(0, 0, new Color(255, 66, 66), 0, getHeight(), new Color(255, 66, 66));
            }
            g2.setPaint(g);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 1, 1);
        }
        super.paintComponent(grphcs);
    }
}
