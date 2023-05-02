package cf.mech.cores.multilayer;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.net.Socket;
@RequiredArgsConstructor
public class Connection {

    @Getter
    @NonNull
    private int IP,Port;
    private Socket s;
    private Gson gson = new Gson();

    boolean connect(){
        return true;
    }
    void init(){

    }

    @SneakyThrows
    PackageR receive(){
        return null;
    }




}
