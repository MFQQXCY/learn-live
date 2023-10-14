package io.net.advice;

import java.util.List;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleChatServer {
    private final List<PrintWriter> clientWriters = new ArrayList<>();
    public static void main(String[] args) {
        new SimpleChatServer().go();
        
    }

    private void go() {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(6000));
            while(serverSocketChannel.isOpen()){
                SocketChannel clientChannel = serverSocketChannel.accept();
                PrintWriter writer = new PrintWriter(Channels.newWriter(clientChannel, StandardCharsets.UTF_8));
                clientWriters.add(writer);
                threadPool.submit(new ClientHandler(clientChannel));
                System.out.println("got a connection");
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void tellEveryOne(String message){
        for(PrintWriter writer:clientWriters){
            writer.println(message);
            writer.flush();
        }
    }

    public class ClientHandler implements Runnable{

        BufferedReader reader;
        SocketChannel socket;
        
        

        public ClientHandler(SocketChannel socket) {
            this.socket = socket;
            reader = new BufferedReader(Channels.newReader(socket, StandardCharsets.UTF_8));
        }



        @Override
        public void run() {
            String message;
            try {
                while((message = reader.readLine()) != null){
                    System.out.println("read " + message);
                    tellEveryOne(message);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }

    
}


