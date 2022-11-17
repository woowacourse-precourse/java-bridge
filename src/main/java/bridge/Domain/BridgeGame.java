package bridge.Domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    Bridge bridge;
    Player player;
    private int retryCount;


    public BridgeGame(int size) throws IllegalArgumentException {
        try {
            this.bridge = new Bridge(size);
            this.player = new Player();
            this.retryCount = 1;
        } catch (IllegalArgumentException illegalArgumentException) {
            throw illegalArgumentException;
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String playerSelection) {
        player.setLastSelection(playerSelection);

        int nextPlayerLocation = player.getNextLocation();
        String nextBridgeState = bridge.getBridgeState(nextPlayerLocation);

        if (!playerSelection.equals(nextBridgeState)) {
            player.die();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String command) {
        if (command.equals("R")) {
            player.revive();
            this.retryCount++;
        }
    }


    public boolean winGame() {
        int playerNextLocation = player.getNextLocation();
        List<String> bridgeStates = bridge.getBridgeStates();

        // 다음에 이동할 곳이 인덱스를 벗어날 경우 끝에 도달한 것
        if (bridgeStates.size() <= playerNextLocation) {
            return true;
        }

        return false;
    }

    public List<String> getBridgeStates() {
        return this.bridge.getBridgeStates();
    }

    public boolean isPlayerDead() {
        if (player.isAlive()) {
            return false;
        }

        return true;
    }

    public void updatePlayer() {
        if (player.isAlive()) {
            player.success();
        }
    }

    public Player getPlayer() {
        return this.player;
    }

    public int getRetryCount() {
        return this.retryCount;
    }
}
