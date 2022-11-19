package bridge.Domain;

import java.util.ArrayList;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int bridgeSize;
    private List<String> bridge;
    private List<Boolean> matchResult = new ArrayList<>();
    private int gameCount = 0;
    private boolean succecs = false;
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public int getBridgeSize() {
        return bridgeSize;
    }

    public void setBridgeSize(int bridgeSize) {
        this.bridgeSize = bridgeSize;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<Boolean> getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(List<Boolean> matchResult) {
        this.matchResult = matchResult;
    }

    public int getGameCount() {
        return gameCount;
    }

    public void increaseGameCount() {
        this.gameCount++;
    }

    public boolean isSuccecs() {
        return succecs;
    }

    public void gameSuccecs() {
        this.succecs = true;
    }
}

