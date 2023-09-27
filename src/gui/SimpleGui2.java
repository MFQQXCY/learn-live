package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class SimpleGui2 implements ActionListener{
    
    private JButton button;

    public static void main(String[] args) {
        new SimpleGui2().go();
    }


    public void go(){
        JFrame frame = new JFrame();
        button = new JButton("click me");
        JCheckBox checkBox = new JCheckBox("choose me");
        checkBox.addActionListener(this);
        button.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        frame.getContentPane().add(checkBox);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        button.setText("click on me!");
    }
}
