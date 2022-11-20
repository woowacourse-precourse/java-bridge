package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge;
    private final int bridgeSize;
    private int gameCount;
    private final List<String> resultBridge;
    private boolean gameResult;

    public BridgeGame(int size) {
        setBridge(createNewBridge(size));
        this.bridgeSize = bridge.size();
        this.gameCount = 1;
        this.resultBridge = new ArrayList<>();
    }

    public List<String> createNewBridge(int size){
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        return bridgeMaker.makeBridge(size);
    }

    public void setBridge(List<String> bridge){
        this.bridge = bridge;
    }

    public void setGameResult(boolean result) {
        this.gameResult = result;
    }

    public int getBridgeSize() {
        return this.bridgeSize;
    }

    public List<String> getResultBridge() {
        return this.resultBridge;
    }

    public int getGameCount() {
        return this.gameCount;
    }

    public boolean getGameResult(){
        return this.gameResult;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int sequence, String moving) {
        if (this.bridge.get(sequence).equals(moving)) {
            insertResult(moving, "O");
            return true;
        }
        insertResult(moving, "X");
        return false;
    }

    public void insertResult(String moving, String result) {
        if (moving.equals(BridgeValue.UP.getValue())) {
            resultBridge.add(result);
            resultBridge.add(" ");
            return;
        }
        resultBridge.add(" ");
        resultBridge.add(result);
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        gameCount++;
        resultBridge.clear();
    }
}
