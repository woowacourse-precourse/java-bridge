package bridge.Model;

import static bridge.Constant.InputValue.COMMAND_RETRY;

import java.util.List;



public class BridgeGame {
    private final Bridge bridge;
    private final Player player;
    private int retryCount;
    private int maxPassedCount;


    public BridgeGame(int size) throws IllegalArgumentException {
        try {
            this.bridge = new Bridge(size);
            this.player = new Player();
            this.retryCount = 1;
            this.maxPassedCount = 0;
        } catch (IllegalArgumentException illegalArgumentException) {
            throw illegalArgumentException;
        }
    }


    public void move(String playerSelection) {
        int nextPlayerLocation = player.getPassedCount();
        String nextBridgeState = bridge.getBridgeState(nextPlayerLocation);

        if (!playerSelection.equals(nextBridgeState)) {
            player.die();
        }
    }

    public void retry(String command) {
        updateMaxPassedCount();

        if (command.equals(COMMAND_RETRY)) {
            player.revive();
            retryCount++;
        }
    }

    public void updateMaxPassedCount() {
        int passedCount = player.getPassedCount();

        if (maxPassedCount < passedCount) {
            maxPassedCount = passedCount;
        }
    }

    public boolean winGame() {
        int playerNextLocation = player.getPassedCount();
        List<String> bridgeStates = bridge.getBridgeStates();

        if (bridgeStates.size() <= playerNextLocation) {    // 다음에 이동할 곳이 인덱스를 벗어날 경우 끝에 도달한 것
            maxPassedCount = playerNextLocation - 1;

            return true;
        }

        return false;
    }

    public boolean isGameOver() {
        if (isPlayerDead() || winGame()) {
            return true;
        }

        return false;
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

    //getter
    public List<String> getBridgeStates() {
        return bridge.getBridgeStates();
    }

    public int getRetryCount() {
        return retryCount;
    }

    public int getMaxPassedCount() {
        return maxPassedCount;
    }

    public int getPassedCount() {
        return player.getPassedCount();
    }
}
