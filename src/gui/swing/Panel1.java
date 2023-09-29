package gui.swing;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panel1 {
    public static void main(String[] args) {
        new Panel1().go();
    }

    private void go() {
        JFrame frame = new JFrame();

        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        // panel 默认是flow布局，设置为box,可以强制显示为一列或一行
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JButton button = new JButton("shock me");
        JButton button1 = new JButton("bliss");
        panel.add(button);
        panel.add(button1);
        

        frame.getContentPane().add(BorderLayout.EAST, panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}
