package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentReaders {
    public static void main(String[] args) {
        
        // 当一个集合被某线程修改，另一个线程正在读取这个集合时，你讲得到一个java.util.ConcurrentModificationException
        // List<Chat> chathistory = new ArrayList<>();

        // 一个线程安全的，可以同时被多个线程读取和修改的集合有CopyOnWriteArrayList.
        List<Chat> chathistory = new CopyOnWriteArrayList<>();



        ExecutorService pools = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            
            pools.execute(()->chathistory.add(new Chat("Hi there!")));
            pools.execute(()->System.out.println(chathistory));
            pools.execute(()->System.out.println(chathistory));
        }
        pools.shutdown();
        
        
    }
}
