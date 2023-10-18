package beatbox;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MusicServer {
    final List<ObjectOutputStream> clientOutputStreams = new ArrayList<>();

    public static void main(String[] args) {
        new MusicServer().go();
    }

    private void go() {
        try {
            ServerSocket serverSocket = new ServerSocket(6000);
            ExecutorService threadPool = Executors.newCachedThreadPool();
            while(!serverSocket.isClosed()){
                Socket clientSocket = serverSocket.accept();
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                clientOutputStreams.add(out);
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                threadPool.execute(clientHandler);
                System.out.println("Got a connection");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public class ClientHandler implements Runnable{

        private ObjectInputStream in;
        
        

        public ClientHandler(Socket socket) {
            try {
                in = new ObjectInputStream(socket.getInputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



        @Override
        public void run() {
            Object userName;
            Object beatSquence;

            try {
                while((userName = in.readObject()) != null){
                    beatSquence = in.readObject();
                    System.out.println("read two objects");
                    tellEveryOne(userName,beatSquence);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



        private void tellEveryOne(Object userName, Object beatSquence) {
            for (ObjectOutputStream clienOutputStream : clientOutputStreams) {
                try {
                    clienOutputStream.writeObject(userName);
                    clienOutputStream.writeObject(beatSquence);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
}
