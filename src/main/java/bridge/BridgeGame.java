package bridge;

import java.util.ArrayList;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private CurrentBridge currentBridge;
    private Integer count = 0;
    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        currentBridge = new CurrentBridge(new ArrayList<>());
    }
    public boolean isComplete(){
        if(currentBridge.getBridgeStatus() == BridgeStatus.COMPLETE)return true;
        return false;
    }
    public boolean isContinue(){
        if(currentBridge.getBridgeStatus() == BridgeStatus.SUCCESS) return true;
        else return false;
    }
    public void move(String moveCommand) {
        currentBridge.move(moveCommand);
    }
    public void changeStatus(){
        currentBridge.changeStatus(bridge);
    }

    public String returnMap(){
        return currentBridge.toString();
    }

    public void retry() {
        currentBridge.reset();
        count += 1;
    }
}
