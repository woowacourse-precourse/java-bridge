package bridge.model;

import bridge.BridgeController;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge;
    private int gameCount;
    private int currentPosition;
    private boolean gameResult;

    public BridgeGame() {
        this.bridge = new ArrayList<>();
        this.gameCount = 0;
        this.currentPosition = 0;
        this.gameResult = true;
    }





    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String playerMove) {
        String correctMove = this.bridge.get(this.currentPosition);
        if (!correctMove.equals(playerMove)) {
            this.gameResult = false;
        }
        this.currentPosition++;
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.gameCount++;
        this.currentPosition = 0;
        this.gameResult = true;
    }


    // Getters --------------------------------------------------------

    public List<String> getBridge() {
        return bridge;
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int getGameCount() {
        return gameCount;
    }

    public void setGameCount(int gameCount) {
        this.gameCount = gameCount;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public boolean getGameResult() {
        return gameResult;
    }

    public void setGameResult(boolean gameResult) {
        this.gameResult = gameResult;
    }
}
