package io.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class SimpleClientReceive {
    public static void main(String[] args) {
        SocketAddress serverAddr = new InetSocketAddress("127.0.0.1", 5000);
        try (SocketChannel channel = SocketChannel.open(serverAddr)) {
            
            Reader reader = Channels.newReader(channel, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String msg = bufferedReader.readLine();
            System.out.println(msg);
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    
}
