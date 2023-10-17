package io.net.advice;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class SimpleChatClientA {
    public static void main(String[] args) {
        new SimpleChatClientA().go();
    }

    private JTextField outgoing;
    private PrintWriter writer;
    private BufferedReader reader;
    private JTextArea incoming;


    private void go(){
        setUpNetworking();
        
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");

        JPanel panel = new JPanel();
        outgoing = new JTextField(20);
        JButton button = new JButton("send");
        button.addActionListener(e->sendMessage());

        JScrollPane scroller = createScrollableTextArea();

        panel.add(scroller);
        panel.add(outgoing);
        panel.add(button);




        frame.getContentPane().add(BorderLayout.CENTER,panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setVisible(true);

        ExecutorService thread = Executors.newSingleThreadExecutor();
        thread.execute(new IncomingReader());
    }


    private JScrollPane createScrollableTextArea() {
        incoming = new JTextArea(15, 30);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane scroller = new JScrollPane(incoming);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        return scroller;
    }


    private void setUpNetworking(){
        try {
            InetSocketAddress serverAddress = new InetSocketAddress("www.xiangsj.top", 6000);
            SocketChannel socketChannel =SocketChannel.open(serverAddress);

            reader = new BufferedReader(Channels.newReader(socketChannel, StandardCharsets.UTF_8));
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

    public class IncomingReader implements Runnable{

        @Override
        public void run() {
            String message;
            try {
                while((message = reader.readLine()) != null){
                    System.out.println("read " + message);
                    
                }

            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }
}
