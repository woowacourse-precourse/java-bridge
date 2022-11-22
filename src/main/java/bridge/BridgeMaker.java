package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.enums.BridgeType.LOWER;
import static bridge.enums.BridgeType.UPPER;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }
    public List<String> makeBridge(int size) {
        List<String> bridges = new ArrayList<>();
        while(bridges.size() < size){
            bridges.add(constructBridgeAtPoint());
        }
        return bridges;
    }

    private String constructBridgeAtPoint(){
        return changeValueToCommand(chooseSideOfBridge());
    }

    private String changeValueToCommand(int value){
        if(value == UPPER.getValue()) return UPPER.getCommand();
        return LOWER.getCommand();
    }

    private int chooseSideOfBridge(){
        return bridgeNumberGenerator.generate();
    }
}
