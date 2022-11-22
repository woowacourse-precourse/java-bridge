package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridges {
    public List<String> upBridge;
    public List<String> downBridge;
    public int bridgesSize;
    public Bridges(int bridgesSize){
        List<String> upBridge = new ArrayList<>();
        List<String> downBridge = new ArrayList<>();

        this.upBridge = upBridge;
        this.downBridge = downBridge;
        this.bridgesSize = bridgesSize;
    }

}