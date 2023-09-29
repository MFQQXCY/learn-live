package gui.swing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class TextArea1 {
    public static void main(String[] args) {
        new TextArea1().go();
    }

    private void go() {
        JFrame frame = new JFrame();

        JTextArea textArea = new JTextArea(10, 20);
        JScrollPane scroller = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        JPanel panel = new JPanel();
        panel.add(scroller);
        
        
        JButton button = new JButton("shock me");
        button.addActionListener((event)->textArea.append("不敢相信 \n"));
        

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
