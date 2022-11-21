package bridge.domain;

import bridge.BridgeMaker;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Integer currentBlockIndex = -1;
    private List<String> bridge = new ArrayList<>();
    private List<String> bridgeProgress = new ArrayList<>();
    public BridgeGame(List<String> bridge){
        currentBlockIndex = -1;
        this.bridge = bridge;
        this.bridgeProgress = new ArrayList<>();
    }

    public void move(String moveCommand) {
        if (isMovable(moveCommand)) {
            this.bridgeProgress.add("O");
            currentBlockIndex += 1;
            return;
        }
        this.bridgeProgress.add("X");
    }

    private Boolean isMovable(String moveCommand){
        return bridge.get(currentBlockIndex + 1).equals(moveCommand);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }


    public List<String> getBridgeProgress() {
        return bridgeProgress;
    }
}
