package bridge.util;

import java.util.ArrayList;
import java.util.List;

import static bridge.enums.BridgeType.LOWER;
import static bridge.enums.BridgeType.UPPER;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
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
