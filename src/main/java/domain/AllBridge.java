package domain;


import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class AllBridge {
    private List<String> bridge = new ArrayList<>();
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    public AllBridge(String size) {
        checkBridgeLength(size);
        bridge = bridgeMaker.makeBridge(Integer.parseInt(size));
    }

    public List<String> getBridge() {
        return bridge;
    }

    public void checkBridgeLength(String bridgeSize) {
        try {
            int size = Integer.parseInt(bridgeSize);
            if(size > 20 || size < 3) {
                throw new IllegalArgumentException("[ERROR] 3~20 사이의 양의 정수를 입력해주세요");
            }
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 3~20 사이의 양의 정수를 입력해주세요");
        }
    }

}
