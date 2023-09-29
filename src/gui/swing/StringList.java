package gui.swing;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

public class StringList {
    public static void main(String[] args) {
        new StringList().go();
    }

    private void go() {
        String[] listEntries = {"alpha","beta","gamma","delta","epsilon","zeta","eta","theta"};
        JList<String> list = new JList<>(listEntries);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        list.setVisibleRowCount(4);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener((event)->{
            if(!event.getValueIsAdjusting()){
                System.out.println(list.getSelectedValue());
            }
        });
        
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        frame.getContentPane().add(BorderLayout.CENTER, panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
