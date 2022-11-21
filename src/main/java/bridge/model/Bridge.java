package bridge.model;

import bridge.config.BridgeGameConfig;

import java.util.List;

public class Bridge {
    private List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public void forward(String input){
        bridge.add(input);
    }

    public boolean matchAll(Bridge anotherBridge){
        return bridge.equals(anotherBridge.bridge);
    }

    // anotherBridge의 크기는 항상 현재 bridge보다 같거나 큼
    public boolean matchCurrentSize(Bridge anotherBridge){
        List<String> anotherSubBridge = anotherBridge.bridge.subList(0, bridge.size());
        return bridge.equals(anotherSubBridge);
    }
}
