package io.net.advice;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Random;

public class DailyAdviceService {
    final private String[] adviceList = {
        "Take smaller bites",
        "Go for the tight jeans. No they do Not make you look fat.",
        "One word: inappropeaiate",
        "Just fot today, be honest. Tell your boss what you *really* think",
        "You might want to rethink that haircut"
    };
    private final Random random = new Random();
    public static void main(String[] args) {
        new DailyAdviceService().go();
    }

    private void go() {
        try (ServerSocketChannel serverChannel = ServerSocketChannel.open()) {
            serverChannel.bind(new InetSocketAddress(6000));

            while(serverChannel.isOpen()){
                SocketChannel clientChannel = serverChannel.accept();
                PrintWriter writer = new PrintWriter(Channels.newOutputStream(clientChannel));
                writer.println(getAdvice());
                writer.close();
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    private String getAdvice() {
        return adviceList[random.nextInt(adviceList.length)];
    }
}
