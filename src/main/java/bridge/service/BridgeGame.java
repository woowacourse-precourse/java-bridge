package bridge.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge;
    private int gameCount;
    private int bridgeIndex;
    private String user;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        setup();
    }

    public int getGameCount() {
        return gameCount;
    }

    public String getUser() {
        return user;
    }

    public void setup() {
        this.bridgeIndex = 0;
    }

    public boolean stateGame() {
        if ((bridge.size()) == bridgeIndex) {
            return false;
        }
        return true;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String upDown) {
        if (bridge.get(bridgeIndex).equals(upDown)) {
            user = "O";
            bridgeIndex++;
            return true;
        }
        user = "X";
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String retry) {
        if (retry.equals("R")) {
            gameCount++;
            return true;
        }
        return false;
    }
}