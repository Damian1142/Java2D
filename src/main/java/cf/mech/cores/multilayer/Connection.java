package cf.mech.cores.multilayer;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.omg.CORBA.WStringSeqHelper;

import java.io.PrintStream;
import java.net.Socket;
@RequiredArgsConstructor
public class Connection {

    @Getter
    @NonNull
    private String IP;

    @Getter
    @NonNull
    private int Port;
    private Socket s;
    private Gson gson = new Gson();
    private PrintStream ps;

    public boolean connect(){
        return true;
    }
    @SneakyThrows
    void init(){
        s = new Socket(IP,Port);
        ps = new PrintStream(s.getOutputStream());
    }

    @SneakyThrows
    public PackageR receive(){
        return null;
    }
    public void send(PackageS pack){
        if (s != null && ps != null) {
            ps.println(gson.toJson(pack));
        }
    }

}
