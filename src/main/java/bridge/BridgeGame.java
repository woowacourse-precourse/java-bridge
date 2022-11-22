package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridges;
    private final List<String> moveProgress = new ArrayList<>();
    private boolean moveOk = true;
    private int tryCnt = 1;

    public BridgeGame(int size){
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridges = bridgeMaker.makeBridge(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String userChoice) {
        if(!userChoice.equals(bridges.get(moveProgress.size()))){
            moveOk = false;
        }
        moveProgress.add(userChoice);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        moveProgress.clear();
        moveOk = true;
        tryCnt ++;
    }

    public int getTryCnt() {
        return tryCnt;
    }

    public boolean isMoveOk() {
        return moveOk;
    }

    public List<String> getMoveProgress(){
        return moveProgress;
    }
}
