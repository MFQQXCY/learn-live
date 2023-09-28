package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleAnimation {
    private int xPos = 70;
    private int yPos = 70;

    public static void main(String[] args) {
        new SimpleAnimation().go();
    }

    private void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        InnerDrawPanele drawPanele = new InnerDrawPanele();
        frame.getContentPane().add(drawPanele);
        frame.setSize(300, 300);
        frame.setVisible(true);
        for (int i = 0; i < 130; i++) {
            xPos ++;
            yPos ++;
            drawPanele.repaint();
            
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        
    }

    class InnerDrawPanele extends JPanel{

        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(Color.green);
            g.fillOval(xPos, yPos, 40, 40);
        }
        
        
    }
}
