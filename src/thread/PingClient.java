package thread;

import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.concurrent.TimeUnit;

public class PingClient {
    
    public static void main(String[] args) {
        InetSocketAddress server = new InetSocketAddress("127.0.0.1", 5000);
        try (SocketChannel channel =SocketChannel.open(server)) {
            System.out.println("NetWorking established");
            PrintWriter writer = new PrintWriter(Channels.newWriter(channel, StandardCharsets.UTF_8));
            for (int i = 0; i < 10; i++) {
                String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
                String message = "ping " + i;
                System.out.println(currentTime + " send " + message);
                writer.println(message);
                writer.flush();
                TimeUnit.SECONDS.sleep(1);
 
            }

            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
