package gui.listener;

import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.JFrame;
import javax.swing.JLabel;

import gui.DrawPanel;

public class MyGui {
    private JFrame frame;
    private JLabel label;

    /**
     * 此处有两个Button,需要两个事件监听。
     * 监听的类需要使用MyGui的实例变量，
     * 就要通过监听类的方法传送过去，
     * 由于frame,label是private的，需要公开的public get方法
     * 
     * 冗余代码在于两个listener,无法直接访问MyGui的成员变量，
     * 使用内部类即可解决这个问题
     * 即 使两个listener 成为Gui 的内部类
     */

    void gui(){
        frame = new JFrame();
        label = new JLabel("I'm a lable");

        Button colorButton = new Button("change color");
        colorButton.addActionListener(new ColorButtonListener(this));
        Button labelButton = new Button("change label");
        labelButton.addActionListener(new LabelButtonListener(this));
        
        frame.add(BorderLayout.SOUTH, colorButton);
        frame.add(BorderLayout.CENTER,new DrawPanel());
        frame.add(BorderLayout.WEST, label);
        frame.add(BorderLayout.EAST, labelButton);        
    }

    public JFrame getFrame() {
        return frame;
    }

    public JLabel getLabel() {
        return label;
    }


    
    
}
