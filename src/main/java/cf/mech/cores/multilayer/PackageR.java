package cf.mech.cores.multilayer;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class PackageR implements Serializable {
    int levelID;
    ArrayList<PackageS> obj;
}
