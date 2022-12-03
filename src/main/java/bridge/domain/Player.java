package bridge.domain;

import bridge.constant.ErrorCode;
import bridge.constant.MatchConst;

import java.util.ArrayList;
import java.util.List;

public class Player {

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
            throw new IllegalArgumentException(ErrorCode.WRONG_WORD_IN_LIST.getMessage());
        }
    }

    private void validationSize(int size) {
        if (size > MatchConst.Size.BRIDGE_MAX_SIZE) {
            throw new IllegalArgumentException(ErrorCode.OUT_OF_RANGE.getMessage());
        }
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
