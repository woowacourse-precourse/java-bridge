package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> upperBridge;
    private List<String> lowerBridge;
    private List<String> answerBridge;
    private int bridgeIndex;

    public BridgeGame() {
        upperBridge = new ArrayList<>();
        lowerBridge = new ArrayList<>();
        bridgeIndex = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        if(answerBridge.get(bridgeIndex) != direction){
            addWrongBridgeResult(direction);
            return;
        }
        addBridgeResult(direction);
    }

    private void addBridgeResult(String direction) {
        if(direction == "U"){
            upperBridge.add("O");
            lowerBridge.add(" ");
        }
        if(direction == "D"){
            upperBridge.add(" ");
            lowerBridge.add("O");
        }
    }

    private void addWrongBridgeResult(String direction) {
        if(direction == "U"){
            upperBridge.add("X");
            lowerBridge.add(" ");
        }
        if(direction == "D"){
            upperBridge.add(" ");
            lowerBridge.add("X");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
