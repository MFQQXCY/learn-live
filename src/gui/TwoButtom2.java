package gui;

import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 * 使用lamda表达式更新代码
 */
public class TwoButtom2 {
    private JFrame frame;
    private JLabel label;

    public static void main(String[] args) {
        new TwoButtom2().go();
    }

    private void go() {
        frame = new JFrame();
        label = new JLabel("I'm a lable");

        Button colorButton = new Button("change color");
        colorButton.addActionListener((event)->frame.repaint());
        Button labelButton = new Button("change label");
        labelButton.addActionListener((event)->label.setText("new text was set"));
        
        frame.add(BorderLayout.SOUTH, colorButton);
        frame.add(BorderLayout.CENTER,new DrawPanel());
        frame.add(BorderLayout.WEST, label);
        frame.add(BorderLayout.EAST, labelButton);   
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
    
}
