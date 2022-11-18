package bridge.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static List<String> bridge;
    private static List<String> playerMove = new ArrayList<>();
    private final BridgePrinter bridgePrinter = new BridgePrinter();
    private boolean success = true;
    private int turn = 0;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgePrinter move(String move) {
        turn++;
        playerMove.add(move);
        bridgePrinter.printStatus(bridge, playerMove);
        success = checkCorrect();
        return bridgePrinter;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        turn = 0;
        success = true;
        playerMove.clear();
    }

    public boolean checkCorrect(){
        for (int turn = 0; turn < playerMove.size(); turn++) {
            if(!playerMove.get(turn).equals(bridge.get(turn))){
                return false;
            }
        }
        return true;
    }

    public boolean isEnd(){
        if (turn == bridge.size()) {
            return false;
        }
        return success;
    }

    public boolean isSuccess() {
        return success;
    }
}
