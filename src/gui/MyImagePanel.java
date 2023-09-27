package gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyImagePanel extends JPanel{

    @Override
    protected void paintComponent(Graphics g) {
        Image image = new ImageIcon("").getImage();
        g.drawImage(image, 3, 4, this);
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new MyImagePanel());
    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
    
}
