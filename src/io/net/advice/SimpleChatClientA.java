package io.net.advice;

import java.awt.BorderLayout;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleChatClientA {
    public static void main(String[] args) {
        new SimpleChatClientA().go();
    }

    private JTextField outgoing;
    private PrintWriter writer;


    private void go(){
        setUpNetworking();
        
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");

        JPanel panel = new JPanel();
        outgoing = new JTextField(20);
        JButton button = new JButton("send");
        button.addActionListener(e->sendMessage());
        panel.add(outgoing);
        panel.add(button);
        frame.getContentPane().add(BorderLayout.CENTER,panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 100);
        frame.setVisible(true);
    }


    private void setUpNetworking(){
        try {
            InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1", 6000);
            SocketChannel socketChannel =SocketChannel.open(serverAddress);
            writer = new PrintWriter(Channels.newWriter(socketChannel, StandardCharsets.UTF_8));
            System.out.println("Networking established");
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    private void sendMessage(){
        writer.println(outgoing.getText());
        writer.flush();
        outgoing.setText("");
        outgoing.requestFocus();
    }
}
