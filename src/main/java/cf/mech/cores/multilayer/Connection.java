package cf.mech.cores.multilayer;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.net.Socket;
@RequiredArgsConstructor
public class Connection {

    @Getter
    @NonNull
    private int IP,Port;
    private Socket s;

    boolean connect(){
        return true;
    }
    void init(){

    }

    void send(){

    }




}
