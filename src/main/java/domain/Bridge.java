package domain;

import enums.BridgeEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bridge {
    List<String> up = new ArrayList<>(Collections.nCopies(BridgeEnum.MAX_SIZE.getValue(), " "));

    List<String> down = new ArrayList<>(Collections.nCopies(BridgeEnum.MAX_SIZE.getValue(), " "));

    public List<String> getUp(){
        return up;
    }

    public List<String> getDown(){
        return down;
    }

}
