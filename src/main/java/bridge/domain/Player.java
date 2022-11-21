package bridge.domain;

import java.util.List;

public class Player {
    private static final int BRIDGE_MAX_SIZE = 20;

    private List<BridgeShapeMatcher> bridgeShapeMatcher;

    public Player(List<BridgeShapeMatcher> bridgeShapeMatcher) {
        validation(bridgeShapeMatcher);
        this.bridgeShapeMatcher = bridgeShapeMatcher;
    }

    private void validation(List<BridgeShapeMatcher> bridgeShapeMatcher) {
        isContainNone(bridgeShapeMatcher);
        validationSize(bridgeShapeMatcher.size());
    }

    private void isContainNone(List<BridgeShapeMatcher> bridgeShapeMatcher) {
        if (bridgeShapeMatcher.contains(BridgeShapeMatcher.NONE)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 값이 포함되어있음");
        }
    }

    private void validationSize(int size) {
        if (size > BRIDGE_MAX_SIZE) {
            throw new IllegalArgumentException("[ERROR] 다리 길이가 범위를 벗어납니다.");
        }
    }

    public void addMatcher(BridgeShapeMatcher bridgeShapeMatcher) {
        this.bridgeShapeMatcher.add(bridgeShapeMatcher);
    }

    public void removeMatcher(){
        this.bridgeShapeMatcher.remove(bridgeShapeMatcher.size()-1);
    }

    public void addBridgeShapeMatcher(String direction, boolean isTrue){
        this.bridgeShapeMatcher.add(BridgeShapeMatcher.findBridgeShape(direction,isTrue));
    }

    public int getPlayerLocation(){
        return this.bridgeShapeMatcher.size();
    }

    public List<BridgeShapeMatcher> getBridgeShapeMatcher() {
        return this.bridgeShapeMatcher;
    }
}
