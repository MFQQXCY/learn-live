package gui.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;

public class Button1 {
    public static void main(String[] args) {
        new Button1().go();
    }

    private void go() {
        JFrame frame = new JFrame();
        JButton button = new JButton("click me, hello world");
        // in the east region of a border layout, the layout manager only respect the its preferred width
        // frame.getContentPane().add(BorderLayout.EAST, button);
        
        // the width stays same, but taller
        Font bigFont = new Font("serif", Font.BOLD, 28);
        button.setFont(bigFont);
        frame.getContentPane().add(BorderLayout.NORTH, button);


        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}
