package cf.mech.cores.multilayer.server;

import cf.mech.cores.Core;
import cf.mech.cores.multilayer.PackageS;
import lombok.SneakyThrows;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SerwerCore implements Core {

    private ServerSocket s;

    ArrayList<PackageS> sys;

    private Queue<Socket> queue = new ArrayDeque<>();

    ExecutorService es = Executors.newFixedThreadPool(10);

    @Override
    public void update(ActionEvent actionEvent) {

    }

    @Override
    public void paint() {

    }

    @SneakyThrows
    @Override
    public void enable() {
        s = new ServerSocket(2137);
        sys = new ArrayList<>();
        new Thread(() -> {
            while (true){
                try {
                    queue.add(s.accept());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                es.execute(() -> {
                    Socket s = queue.poll();
                    try {
                        PrintStream ps = new PrintStream(s.getOutputStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    while (true){

                    }
                });
            }
        }).start();
    }
}
