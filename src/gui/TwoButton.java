package gui;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 * 内部类版本
 */
public class TwoButton {
    private JFrame frame;
    private JLabel label;

    public static void main(String[] args) {
        new TwoButton().go();
    }

    private void go() {
        frame = new JFrame();
        label = new JLabel("I'm a lable");

        Button colorButton = new Button("change color");
        colorButton.addActionListener(new ColorButtonListener());
        Button labelButton = new Button("change label");
        labelButton.addActionListener(new LabelButtonListener());
        
        frame.add(BorderLayout.SOUTH, colorButton);
        frame.add(BorderLayout.CENTER,new DrawPanel());
        frame.add(BorderLayout.WEST, label);
        frame.add(BorderLayout.EAST, labelButton);   
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    class ColorButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.repaint();
        }

    }

    class LabelButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText("that hurt");
        }

    }
}
