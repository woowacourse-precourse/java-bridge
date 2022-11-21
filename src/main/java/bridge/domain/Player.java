package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int BRIDGE_MAX_SIZE = 20;

    private List<BridgeShapeMatcher> bridgeShapeMatcher;
    private boolean isSuccess;
    private int tryNumber;

    public Player(List<BridgeShapeMatcher> bridgeShapeMatcher) {
        validation(bridgeShapeMatcher);
        this.bridgeShapeMatcher = bridgeShapeMatcher;
        this. isSuccess = false;
        this.tryNumber = 0;
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
    public void removeAllMatcher(){
        this.bridgeShapeMatcher = new ArrayList<>();
    }

    public void addBridgeShapeMatcher(String direction, boolean isTrue){
        this.bridgeShapeMatcher.add(BridgeShapeMatcher.findBridgeShape(direction,isTrue));
    }

    public void success(){
        this.isSuccess = true;
    }
    public void addTryNumber(){
        this.tryNumber ++;
    }

    public int getPlayerLocation(){
        return this.bridgeShapeMatcher.size();
    }

    public List<BridgeShapeMatcher> getBridgeShapeMatcher() {
        return this.bridgeShapeMatcher;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
