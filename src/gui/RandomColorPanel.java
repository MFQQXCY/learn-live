package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RandomColorPanel extends JPanel{

    @Override
    protected void paintComponent(Graphics g) {
        // 不进行设置即为黑色
        //g.setColor(Color.GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);
        // 绘制椭圆
        g.fillOval(70, 70, 100, 100);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new RandomColorPanel());
    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
    
}
