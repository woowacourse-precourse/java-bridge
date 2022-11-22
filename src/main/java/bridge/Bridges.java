package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridges {
    List<String> upBridge;
    List<String> downBridge;
    int bridgesSize;
    public Bridges(int bridgesSize){
        List<String> upBridge = new ArrayList<>();
        List<String> downBridge = new ArrayList<>();

        this.upBridge = upBridge;
        this.downBridge = downBridge;
        this.bridgesSize = bridgesSize;
    }

}