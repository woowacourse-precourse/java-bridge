package bridge.service;

import bridge.model.Bridge;
import bridge.model.GameStatus;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private boolean gameOver;
    private boolean success;
    private Bridge randomBridge;
    private Bridge bridge;
    private int count;

    public BridgeGame(Bridge randomBridge) {
        this.gameOver = false;
        this.success = false;
        this.randomBridge = randomBridge;
        this.bridge = new Bridge();
        this.count = 0;
    }

    public boolean isSuccess() {
        return success;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public void setBridge(Bridge bridge) {
        this.bridge = bridge;
    }

    public int getCount() {
        return count;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public void move(String move) {
        bridge.getBrdige().add(move);
        this.success = true;

        if (bridge.getBrdige().size() == this.randomBridge.getBrdige().size()) {
            this.gameOver = true;
            this.count++;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry(String command) {
        if (command.equals(GameStatus.RETRY.getCommand())) {
            this.success = false;
            this.bridge = new Bridge();
            this.count++;
        }
        if (command.equals(GameStatus.QUIT.getCommand())) {
            this.success = false;
            this.gameOver = true;
            this.count++;
        }
    }

    /**
     * 사용자가 이동 가능한 칸인지 확인하는 메서드
     */
    public boolean check(String move) {
        int idx = bridge.getBrdige().size();
        return this.randomBridge.getBrdige().get(idx).equals(move);
    }
}
