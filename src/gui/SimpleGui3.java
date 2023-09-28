package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class SimpleGui3 implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.repaint();
    }

    private JFrame frame;

    public static void main(String[] args) {
        new SimpleGui3().go();
    }

    private void go() {
        frame = new JFrame();
        Button button = new Button("changeColors");
        button.addActionListener(this);
        
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        DrawPanel drawPanel = new DrawPanel();
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
    
}
