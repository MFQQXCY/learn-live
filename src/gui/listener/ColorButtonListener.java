package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorButtonListener implements ActionListener{
    
    private MyGui myGui;

    @Override
    public void actionPerformed(ActionEvent e) {
        myGui.getFrame().repaint();
    }

    public ColorButtonListener(MyGui myGui) {
        this.myGui = myGui;
    }
    
    
    
}
