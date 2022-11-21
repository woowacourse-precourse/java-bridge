package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.domain.BridgeResult;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> answerBridge;
    private int count;
    private List<String> playerBridge;
    private BridgeResult bridgeResult;

    public BridgeGame(List<String> answerBridge, int count) {
        this.answerBridge = answerBridge;
        this.playerBridge = new ArrayList<>();
        this.bridgeResult = new BridgeResult(answerBridge);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String input) {
        playerBridge.add(input);
        return bridgeResult.matchBridge(playerBridge);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String input) {
        if (input.equals("R")) {
            count++;
            playerBridge.clear();
            return true;
        }
        return false;
    }
}
