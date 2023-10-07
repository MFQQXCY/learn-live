package io.net.advice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class DailyAdviceClient {
    public static void main(String[] args) {
        new DailyAdviceClient().go();
    }

    void go() {
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 6000);
        try (SocketChannel socketChannel = SocketChannel.open(socketAddress)) {
            Reader reader = Channels.newReader(socketChannel, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String msg = bufferedReader.readLine();
            System.out.println("Today you should: " + msg);
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
