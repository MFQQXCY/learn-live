package gui.swing;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class CheckBox implements ItemListener{

    private JCheckBox checkBox;
    public static void main(String[] args) {
        new CheckBox().go();
    }

    private void go() {
        checkBox = new JCheckBox("Goes to 11");
        JFrame frame = new JFrame();

        checkBox.addItemListener(this);

        frame.getContentPane().add(checkBox);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String onOrOff = "off";
        if(checkBox.isSelected()){
            onOrOff = "on";
        }
        System.out.println("Check box is " + onOrOff);
    }
}
