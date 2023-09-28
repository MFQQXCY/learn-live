package gui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graphics2DPanel extends JPanel{

    @Override
    protected void paintComponent(Graphics g) {
        // 此处的g指向的是Graphics2D的实例，
        // 向下转型，可以调用更多的方法
        Graphics2D g2d = (Graphics2D)g;

        // 绘制一个混合渐变的圆
        GradientPaint gradient = new GradientPaint(70, 70, Color.BLUE, 150, 150, Color.orange);
        
        g2d.setPaint(gradient);

        g2d.fillOval(70, 70, 100, 100);
        

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new Graphics2DPanel());
    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
    
}
