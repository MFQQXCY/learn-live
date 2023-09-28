package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LabelButtonListener implements ActionListener{

    private MyGui myGui;

    
    @Override
    public void actionPerformed(ActionEvent e) {
        myGui.getLabel().setText("that hurt");
    }

    public LabelButtonListener(MyGui myGui) {
        this.myGui = myGui;
    }

    
    
}
