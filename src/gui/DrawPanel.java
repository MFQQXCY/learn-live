package gui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Color startColor = getRandomColor();
        Color endColor = getRandomColor();

        // 绘制一个混合渐变的圆
        GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);

        g2d.setPaint(gradient);

        g2d.fillOval(70, 70, 100, 100);

    }

    private Color getRandomColor() {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        return new Color(red, green, blue);
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new DrawPanel());
    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

}
